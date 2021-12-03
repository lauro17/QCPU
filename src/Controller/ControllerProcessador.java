/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;

import Dao.DaoProcessador;
import Model.ModelProcessador;
import java.util.ArrayList;

/**
 *
 * @author luizl
 */
public class ControllerProcessador {

    private DaoProcessador daoProcessador = new DaoProcessador();

    public ArrayList<ModelProcessador> getListaProcessadorController(String Pcondicional) {
        return this.daoProcessador.getProcessadorDAO(Pcondicional);
    }


}
