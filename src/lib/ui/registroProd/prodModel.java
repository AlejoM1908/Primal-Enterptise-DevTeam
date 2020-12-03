/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lib.ui.registroProd;

import java.sql.ResultSet;
import java.sql.SQLException;
import lib.app.DBConnection;
import lib.ui.MainApp.MainAppController;

/**
 *
 * @author Fredy AGP
 */
public class prodModel {

    private DBConnection conn = new DBConnection();

    private registroProd registroProdView;

    private MainAppController rootComponent;

    public prodModel(registroProd registroProdView) {
        this.registroProdView = registroProdView;
    }

    public int registro_prod(String nombre, String marca, String tipo, int nit, int cantidad, String metodo, String lugar, String fecha, String usr, String descrip) {
        int retornador = 0;
        try {
            startConnection();
            conn.executeQuery("CALL registerProduct("+ usr + "," + Integer.toString(nit) + "," + marca + "," + tipo + "," + Integer.toString(cantidad) + "," + metodo + "," + lugar + "," + nombre + "," + descrip + ", STR_TO_DATE(" + fecha + ", '%Y-%m-%d'));");
            ResultSet result = conn.executeQuery("select pru_nombre from productos ");
            if (result.next() == false) {
                retornador = 0;
            } else {
                retornador = 1;
            }
            endConnection();
        } catch (SQLException e) {
            System.out.println("Ha ocurrido una SQLExeption: " + e.getMessage());
        }
        return retornador;
    }
    
    public int registrados(String nombre, String marca, String tipo, String nit, String cantidad, String metodo, String lugar, String fecha, String usr, String descrip) {
        int registro_retorno;
        int num_nit;
        int num_cantidad;
        try {
            num_nit = Integer.parseInt(nit);

        } catch (NumberFormatException ex) {
            return 0;
        }
        try {
            num_cantidad = Integer.parseInt(cantidad);

        } catch (NumberFormatException ex) {
            return 0;
        }
        registro_retorno = registro_prod(nombre, marca, tipo, num_nit, num_cantidad, metodo, lugar, fecha, usr, descrip);
        return registro_retorno;
    }
    
    public void clearFields(){
        this.registroProdView.getNombreTF().setText("");
        this.registroProdView.getMarcaTF().setText("");
        this.registroProdView.getTipolTF().setText("");
        this.registroProdView.getNitTF().setText("");
        this.registroProdView.getAlmacenamientoTF().setText("");
        this.registroProdView.getLugarTF().setText("");
        this.registroProdView.getDescripcionTF().setText("");
        this.registroProdView.getAnoCB().setSelectedIndex(0);
        this.registroProdView.getMesCB().setSelectedIndex(0);
        this.registroProdView.getDiaCB().setSelectedIndex(0);
    }

    private void startConnection() {
        conn.getConnection();
    }

    private void endConnection() {
        conn.endCOnnection();
    }

    public registroProd getRegistroProdView() {
        return registroProdView;
    }

    public void setRegistroProdView(registroProd registroProdView) {
        this.registroProdView = registroProdView;
    }

    public MainAppController getRootComponent() {
        return rootComponent;
    }

    public void setRootComponent(MainAppController rootComponent) {
        this.rootComponent = rootComponent;
    }
    
    
}
