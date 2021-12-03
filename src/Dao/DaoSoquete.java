/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Dao;

import Conexoes.ConexaoMySql;
import Model.ModelSoquete;
import java.util.ArrayList;

/**
 *
 * @author luizl
 */
public class DaoSoquete extends ConexaoMySql {

    public ArrayList<ModelSoquete> getSoqueteDAO() {
        ArrayList<ModelSoquete> listamodelSoquete = new ArrayList();
        ModelSoquete modelSoquete = new ModelSoquete();
        try {
            this.conectar();
            this.executarSQL("SELECT * FROM soquete ORDER BY cod_soq DESC ;");

            while (this.getResultSet().next()) {
                modelSoquete = new ModelSoquete();
                modelSoquete.setCod_soq(this.getResultSet().getInt(1));
                modelSoquete.setModelo_soq(this.getResultSet().getString(2));
                listamodelSoquete.add(modelSoquete);
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            this.fecharConexao();
        }
        return listamodelSoquete;
    }

    public ModelSoquete getNomeSoqueteDAO(String pNome) {
        
                
         ModelSoquete modelSoquete = new ModelSoquete();
        try {
            this.conectar();
            this.executarSQL("SELECT * FROM soquete WHERE modelo_soq = '" + pNome + "' ;");
            while (this.getResultSet().next()) {
                modelSoquete.setCod_soq(this.getResultSet().getInt(1));
                modelSoquete.setModelo_soq(this.getResultSet().getString(2));
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            this.fecharConexao();
        }
        return modelSoquete;
    }

}
