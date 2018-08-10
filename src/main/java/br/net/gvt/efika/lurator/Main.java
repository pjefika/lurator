/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.net.gvt.efika.lurator;

import br.net.gvt.efika.lurator.dao.TTMonitorDAO;
import br.net.gvt.efika.lurator.model.TTMonitor;
import com.fasterxml.jackson.dataformat.xml.XmlMapper;
import java.io.BufferedReader;
import java.io.File;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.URLEncoder;
import java.nio.charset.Charset;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClientBuilder;

/**
 *
 * @author G0041775
 */
public class Main {

    public static void main(String[] args) {

        do {
            Calendar now = Calendar.getInstance();
            try {

                DateFormat df = new SimpleDateFormat("dd/MM/yyyy HH:mm");
//                Calendar now = Calendar.getInstance();
                Calendar nowMinusTen = Calendar.getInstance();
                nowMinusTen.add(Calendar.MINUTE, -10);
                String agora = URLEncoder.encode(df.format(now.getTime()), "UTF-8");
                String dezMin = URLEncoder.encode(df.format(nowMinusTen.getTime()), "UTF-8");

                CloseableHttpClient httpClient = HttpClientBuilder.create().build();
                HttpPost post = new HttpPost("http://svuxpope10:8080/TTMonitor-war/PesquisaTTsServlet?method=pesquisarTTsByFiltros");
                post.addHeader("Content-Type", "application/x-www-form-urlencoded; charset=UTF-8");
                post.addHeader("Cookie", args[0]);
                String json = "sip=false&ddd=&requestDate=" + now.getTime().getTime() + "&armario=&dataInicio=" + dezMin + "&detalhes=&bras=&dataFim=" + agora + "&descricao=&status=";
//            System.out.println("POST -> " + json);
                post.setEntity(new StringEntity(json, Charset.forName("UTF-8")));

                CloseableHttpResponse response = httpClient.execute(post);
                InputStreamReader reader;

                reader = new InputStreamReader(response.getEntity().getContent());

                BufferedReader br = new BufferedReader(reader);

                String output;
                StringBuffer result = new StringBuffer();
                while ((output = br.readLine()) != null) {
                System.out.println("OUTPUT -> " + output);
                    result.append(output);
                }
                httpClient.close();

                String xml = result.toString();

                XmlMapper xmlMapper = new XmlMapper();
                TTMonitor value = xmlMapper.readValue(xml, TTMonitor.class);
                TTMonitorDAO dao = new TTMonitorDAO();
                dao.save(value);
                System.out.println("Salvou no Banco->" + now.getTime().toString());

                String filename = System.getProperty("os.name").startsWith("Windows") ? "C:\\Temp\\ttMonitorLurage.txt" : "~/ttMonitorLurage.txt";
//            System.out.println(filename);
                try {
                    Files.write(Paths.get(filename), result.toString().getBytes(), StandardOpenOption.APPEND);
                    System.out.println("Salvou Arquivo->" + now.getTime().toString());
                } catch (IOException e) {
                    try {
                        File file = new File(filename);
                        file.createNewFile();
                        Files.write(Paths.get(filename), result.toString().getBytes(), StandardOpenOption.APPEND);
                        System.out.println("Salvou Arquivo->" + now.getTime().toString());
                    } catch (Exception ex) {
                        ex.printStackTrace();
                        System.out.println("Excessao ao salvar arquivo->" + now.getTime().toString());
                    }
                }
            } catch (Exception e) {
                e.printStackTrace();
                System.out.println("Excessao generico->" + now.getTime().toString());
            }
            try {
                Thread.sleep(300000);
            } catch (InterruptedException ex) {
                Logger.getLogger(Main.class.getName()).log(Level.SEVERE, null, ex);
            }
        } while (true);
    }
}
