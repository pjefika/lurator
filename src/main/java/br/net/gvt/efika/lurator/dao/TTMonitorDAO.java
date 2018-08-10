/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.net.gvt.efika.lurator.dao;

import br.net.gvt.efika.lurator.model.TTMonitor;
import br.net.gvt.efika.mongo.dao.AbstractMongoDAO;
import br.net.gvt.efika.mongo.dao.MongoEndpointEnum;

/**
 *
 * @author G0041775
 */
public class TTMonitorDAO extends AbstractMongoDAO<TTMonitor> {

    public TTMonitorDAO() {
        super(MongoEndpointEnum.MONGO.getIp(), "generalLure", TTMonitor.class);
    }

}
