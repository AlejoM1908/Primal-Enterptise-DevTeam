    /*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lib.ui.AssetRegistration;

import com.mysql.cj.xdevapi.PreparableStatement;
import java.sql.CallableStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.swing.JOptionPane;
import lib.app.DBConnection;
import lib.ui.MainApp.MainAppController;

/**
 *
 * @author user
 */
public class AssetRegistrationModel {
    private AssetRegistrationView view;
    
    private MainAppController rootComponent;

    public AssetRegistrationModel(AssetRegistrationView view) {
        this.view = view;
    }

    public AssetRegistrationView getView() {
        return view;
    }

    public void setView(AssetRegistrationView view) {
        this.view = view;
    }
    
    public boolean validateLength(){
        String name = view.getJtxtName().getText();
        String brand = view.getJtxtBrand().getText();
        String nit = view.getJtxtNit().getText();
        String desc = view.getJtxtaDesc().getText();
        return name.isEmpty() || brand.isEmpty() || nit.isEmpty()
                || desc.isEmpty();
    }
    
    public boolean validateFormat(){
        try{
            int nit = Integer.parseInt(view.getJtxtNit().getText());
        }catch(NumberFormatException e){
            return true;
        }
        return false;
    }
    
    public void registerAsset() throws SQLException{
        String name = "\"" + view.getJtxtName().getText() + "\"";
        String brand = "\"" + view.getJtxtBrand().getText() + "\"";
        int nit = Integer.parseInt(view.getJtxtNit().getText());
        String desc = "\"" + view.getJtxtaDesc().getText() + "\"";
        String status = "\"" + view.getJcbStatus().getSelectedItem().toString() + "\"";
        String user = "\""+ this.rootComponent.getMainAppModel().getLoggedUser().getUser() +"\"";
        DBConnection conn = new DBConnection();
        conn.getConnection();
        
        
        conn.executeQuery("CALL registerActive(" + user + "," + nit + "," + desc + "," + status + "," + name + "," + brand +  ");");
        conn.endCOnnection();
        
        JOptionPane.showMessageDialog(view, "Activo registrado", "", JOptionPane.INFORMATION_MESSAGE);
    }
    
    public boolean validateNit() throws SQLException{
        int nit = Integer.parseInt(this.view.getJtxtNit().getText());
        DBConnection conn = new DBConnection();
        conn.getConnection();
        ResultSet result = conn.executeQuery("SELECT COUNT(pve_nit) FROM proveedores WHERE pve_nit = " + Integer.toString(nit) + ";");
        conn.endCOnnection();
        result.next();
        return result.getInt(1) == 0;   
        
    }
    
    public void clearFields(){
        this.view.getJtxtBrand().setText("");
        this.view.getJtxtName().setText("");
        this.view.getJtxtNit().setText("");
        this.view.getJtxtaDesc().setText("");
        this.view.getJcbStatus().setSelectedIndex(0);
    }

    public MainAppController getRootComponent() {
        return rootComponent;
    }

    public void setRootComponent(MainAppController rootComponent) {
        this.rootComponent = rootComponent;
    }
    
    
}
