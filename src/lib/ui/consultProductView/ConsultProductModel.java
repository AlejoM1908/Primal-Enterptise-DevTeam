/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lib.ui.consultProductView;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.InputMismatchException;
import javax.swing.JOptionPane;
import lib.app.DBConnection;
import lib.ui.MainApp.MainAppController;


public class ConsultProductModel {
    
    private int productId;
    
    private MainAppController rootComponent;

    public void setRootComponent(MainAppController rootComponent) {
        this.rootComponent = rootComponent;
    }
    
    private ConsultProductView view ; 

    public ConsultProductModel(ConsultProductView view) {
        this.view = view;
    }
    
    public void fillInfoProduct () throws SQLException{
    
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
      String metodoAlmacenamiento = resultInfo.getString(5);
      view.getJtxtName().setText(nombreInfo);
      view.getJtxtType().setText(tipoInfo);
      view.getJtxtAmount().setText(cantidadInfo);
      view.getJtxtPlace().setText(almacenamientoInfo);
      view.getJtxtMethod().setText(metodoAlmacenamiento);
      view.getJtxtaDescripcion().setText(descripcionInfo);
      view.getJcbxYear().setSelectedItem(fechaCaducidadInfo.substring(0, 4));
      view.getJcbxMonth().setSelectedItem(fechaCaducidadInfo.substring(5, 7));
      view.getJcbxDay().setSelectedItem(fechaCaducidadInfo.substring(8, 10));
    
    }
    
    public void updateInfo(){
        try {
            int amount = Integer.parseInt(view.getJtxtAmount().getText());
            String name = "\"" + view.getJtxtName().getText() + "\"";
            String type = "\"" + view.getJtxtType().getText() + "\"";
            String place = "\"" + view.getJtxtPlace().getText() + "\"";
            String method = "\"" + view.getJtxtMethod().getText() + "\"";
            String desc = "\"" + view.getJtxtaDescripcion().getText() + "\"";
            String year = (String) view.getJcbxYear().getSelectedItem();
            String month = (String) view.getJcbxMonth().getSelectedItem();
            String day = (String) view.getJcbxDay().getSelectedItem();
            String date = "\"" + year + "-" + month + "-" + day + "\"";
            DBConnection conn = new DBConnection();
            conn.getConnection();
            conn.executeQuery("CALL updateProductInfo(" + Integer.toString(productId) + "," 
                              + Integer.toString(amount) + "," + name + ","+ type + ","
                              + place + ","+ method + ","+ desc + ","+ date + ");");
            conn.endCOnnection();
        } catch (InputMismatchException e) {
            JOptionPane.showMessageDialog(view, "La cantidad debe ser un número", "", JOptionPane.WARNING_MESSAGE);
        }
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

    public int getProductId() {
        return productId;
    }

    public void setProductId(int productId) {
        this.productId = productId;
    }
    
}
