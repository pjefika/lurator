/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.net.gvt.efika.lurator.model;

import br.net.gvt.efika.mongo.model.entity.AbstractMongoEntity;
import com.fasterxml.jackson.annotation.JsonProperty;
import java.util.List;
import org.mongodb.morphia.annotations.Entity;

/**
 *
 * @author G0041775
 */
@Entity("ttMonitor")
public class TTMonitor extends AbstractMongoEntity {

    @JsonProperty("LISTA_TTS")
    private List<MonitorTT> listaTts;

    public TTMonitor() {
    }

    public List<MonitorTT> getListaTts() {
        return listaTts;
    }

    public void setListaTts(List<MonitorTT> listaTts) {
        this.listaTts = listaTts;
    }

}
