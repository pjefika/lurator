/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.net.gvt.efika.lurator.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import java.util.Date;

/**
 *
 * @author G0041775
 */
public class MonitorTT {

    @JsonProperty("TICKET_CODE")
    private String ticketCode;
    private String instancia;
    private String descricao;
    private String detalhe;
    private String armario;
    private String bras;
    private String estado;
    private String cidade;
    private String caixa;
    private String endereco;
    private String status;
    @JsonProperty("SWITCH")
    private String switche;

    private Long shelf;
    
    @JsonProperty("PORTA_VOZ")
    private Long portaVoz;
    @JsonProperty("PAR_SEC")
    private Long parSec;
    private Long rin;
    @JsonProperty("PORTA_ADSL")
    private Long portaAdsl;
    private Long down;
    private Long up;

    @JsonProperty("DATA_ABERTURA")
    private Date dataAbertura;

    public MonitorTT() {
    }

    public MonitorTT(String ticketCode, String instancia, String descricao, String detalhe,
            String armario, String bras, String estado, String cidade, String caixa,
            String endereco, String status, String switche, Long shelf, Long portaVoz,
            Long parSec, Long rin, Long portaAdsl, Long down, Long up, Date dataAbertura) {
        this.ticketCode = ticketCode;
        this.instancia = instancia;
        this.descricao = descricao;
        this.detalhe = detalhe;
        this.armario = armario;
        this.bras = bras;
        this.estado = estado;
        this.cidade = cidade;
        this.caixa = caixa;
        this.endereco = endereco;
        this.status = status;
        this.switche = switche;
        this.shelf = shelf;
        this.portaVoz = portaVoz;
        this.parSec = parSec;
        this.rin = rin;
        this.portaAdsl = portaAdsl;
        this.down = down;
        this.up = up;
        this.dataAbertura = dataAbertura;
    }

    public String getTicketCode() {
        return ticketCode;
    }

    public void setTicketCode(String ticketCode) {
        this.ticketCode = ticketCode;
    }

    public String getInstancia() {
        return instancia;
    }

    public void setInstancia(String instancia) {
        this.instancia = instancia;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public String getDetalhe() {
        return detalhe;
    }

    public void setDetalhe(String detalhe) {
        this.detalhe = detalhe;
    }

    public String getArmario() {
        return armario;
    }

    public void setArmario(String armario) {
        this.armario = armario;
    }

    public String getBras() {
        return bras;
    }

    public void setBras(String bras) {
        this.bras = bras;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    public String getCidade() {
        return cidade;
    }

    public void setCidade(String cidade) {
        this.cidade = cidade;
    }

    public String getCaixa() {
        return caixa;
    }

    public void setCaixa(String caixa) {
        this.caixa = caixa;
    }

    public String getEndereco() {
        return endereco;
    }

    public void setEndereco(String endereco) {
        this.endereco = endereco;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getSwitche() {
        return switche;
    }

    public void setSwitche(String switche) {
        this.switche = switche;
    }

    public Long getShelf() {
        return shelf;
    }

    public void setShelf(Long shelf) {
        this.shelf = shelf;
    }

    public Long getPortaVoz() {
        return portaVoz;
    }

    public void setPortaVoz(Long portaVoz) {
        this.portaVoz = portaVoz;
    }

    public Long getParSec() {
        return parSec;
    }

    public void setParSec(Long parSec) {
        this.parSec = parSec;
    }

    public Long getRin() {
        return rin;
    }

    public void setRin(Long rin) {
        this.rin = rin;
    }

    public Long getPortaAdsl() {
        return portaAdsl;
    }

    public void setPortaAdsl(Long portaAdsl) {
        this.portaAdsl = portaAdsl;
    }

    public Long getDown() {
        return down;
    }

    public void setDown(Long down) {
        this.down = down;
    }

    public Long getUp() {
        return up;
    }

    public void setUp(Long up) {
        this.up = up;
    }

    public Date getDataAbertura() {
        return dataAbertura;
    }

    public void setDataAbertura(Date dataAbertura) {
        this.dataAbertura = dataAbertura;
    }

}
