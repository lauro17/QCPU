/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Dao;

import Conexoes.ConexaoMySql;
import Model.ModelPlacas;
import java.util.ArrayList;

/**
 *
 * @author luizl
 */
public class DaoPlacas extends ConexaoMySql {

    public ArrayList<ModelPlacas> getPlacasDAO(String Pcondicional) {
        ArrayList<ModelPlacas> listamodelSoquete = new ArrayList();
        ModelPlacas modelPlacas = new ModelPlacas();
        try {
            this.conectar();
            this.executarSQL("SELECT * FROM placas  "+ Pcondicional +"  ORDER BY cod_pla DESC ;");

            while (this.getResultSet().next()) {
                modelPlacas = new ModelPlacas();
                modelPlacas.setCod_pla(this.getResultSet().getInt(1));
                modelPlacas.setCod_soq(this.getResultSet().getInt(2));
                modelPlacas.setNome_pla(this.getResultSet().getString(3));
                modelPlacas.setSerie_pla(this.getResultSet().getString(4));
                modelPlacas.setPcb_pla(this.getResultSet().getString(5));
                modelPlacas.setNota_pla(this.getResultSet().getString(6));
                modelPlacas.setUrl_pla(this.getResultSet().getString(7));
                listamodelSoquete.add(modelPlacas);
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            this.fecharConexao();
        }
        return listamodelSoquete;
    }

}
