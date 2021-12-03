/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;

import Dao.DaoSoquete;
import Model.ModelSoquete;
import java.util.ArrayList;

/**
 *
 * @author LUIZ LAURO SILVA GONÇALVES
 */
public class ControllerSoquete {

    private DaoSoquete daoSoquete = new DaoSoquete();

    /**
     * recupera uma lista de Soquete
     * @return
     */
    public ArrayList<ModelSoquete> getListaSoqueteController() {
        return this.daoSoquete.getSoqueteDAO();
    }

    public ModelSoquete getNomeSoqueteController(String pNome) {
        return this.daoSoquete.getNomeSoqueteDAO(pNome);
    }

}
