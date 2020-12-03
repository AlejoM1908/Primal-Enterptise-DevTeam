/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lib.ui.consultProductView;

import java.sql.ResultSet;
import java.sql.SQLException;
import lib.app.DBConnection;
import lib.ui.MainApp.MainAppController;


public class ConsultProductModel {
    
    
    private MainAppController rootComponent;

    public void setRootComponent(MainAppController rootComponent) {
        this.rootComponent = rootComponent;
    }
    
    private ConsultProductView view ; 

    public ConsultProductModel(ConsultProductView view) {
        this.view = view;
    }
    
    public void fillInfoProduct (int productId) throws SQLException{
    
      DBConnection conection = new DBConnection();
      conection.getConnection();
      ResultSet resultInfo = conection.executeQuery("CALL productInfo("+ Integer.toString(productId)+");");
      conection.endCOnnection();
      resultInfo.next();
      String nombreInfo = resultInfo.getString(1) ;
      String tipoInfo = resultInfo.getString(3);
      String cantidadInfo = resultInfo.getString(4);
      String almacenamientoInfo = resultInfo.getString(6);
      String descripcionInfo = resultInfo.getString(2);
      String fechaCaducidadInfo = resultInfo.getString(7);
      view.getNombreInfolb().setText(nombreInfo);
      view.getTipoInfolb().setText(tipoInfo);
      view.getCantidadInfolb().setText(cantidadInfo);
      view.getAlmacenamientoInfolb().setText(almacenamientoInfo);
      view.getJtxtaDescripcion().setText(descripcionInfo);
      view.getFechaCaducidadInfolb().setText(fechaCaducidadInfo);
    
    }

    public void setView(ConsultProductView view) {
        this.view = view;
    }

    public MainAppController getRootComponent() {
        return rootComponent;
    }

    public ConsultProductView getView() {
        return view;
    }
    
}
