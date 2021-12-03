/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Dao;

import Conexoes.ConexaoMySql;
import Model.ModelProcessador;
import java.util.ArrayList;

/**
 *
 * @author luizl
 */
public class DaoProcessador extends ConexaoMySql {

    public ArrayList<ModelProcessador> getProcessadorDAO(String Pcondicional) {
        ArrayList<ModelProcessador> listamodelSoquete = new ArrayList();
        ModelProcessador modelProcessador = new ModelProcessador();
        try {
            this.conectar();
            this.executarSQL("SELECT * FROM processador "+ Pcondicional +" ORDER BY cod_soq DESC ;");

            while (this.getResultSet().next()) {
                modelProcessador = new ModelProcessador();
                modelProcessador.setCod_pro(this.getResultSet().getInt(1));
                modelProcessador.setCpu_modelo_pro(this.getResultSet().getString(2));
//                modelProcessador.setCod_soq(this.getResultSet().getInt(2));
                listamodelSoquete.add(modelProcessador);
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            this.fecharConexao();
        }
        return listamodelSoquete;
    }

}
