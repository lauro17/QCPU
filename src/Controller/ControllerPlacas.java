/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;

import Dao.DaoPlacas;
import Model.ModelPlacas;
import java.util.ArrayList;

/**
 *
 * @author luizl
 */
public class ControllerPlacas {

    private DaoPlacas daoPlacas = new DaoPlacas();


    public ArrayList<ModelPlacas> getListaPlacasController(String Pcondicional) {
        return this.daoPlacas.getPlacasDAO(Pcondicional);
    }


}
