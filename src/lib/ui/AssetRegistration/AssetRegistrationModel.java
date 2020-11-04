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
import lib.app.DBConnection;

/**
 *
 * @author user
 */
public class AssetRegistrationModel {
    private AssetRegistrationView view;

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
        String quantity = view.getJtxtQuantity().getText();
        String ticket = view.getJtxtTicket().getText();
        String desc = view.getJtxtaDesc().getText();
        return name.isEmpty() || brand.isEmpty() || nit.isEmpty() || quantity.isEmpty() 
                || ticket.isEmpty() || desc.isEmpty();
    }
    
    public boolean validateFormat(){
        try{
            int nit = Integer.parseInt(view.getJtxtNit().getText());
            int quantity = Integer.parseInt(view.getJtxtQuantity().getText());
            int ticket = Integer.parseInt(view.getJtxtTicket().getText());
        }catch(NumberFormatException e){
            return true;
        }
        return false;
    }
    
    public void registerAsset() throws SQLException{
        String name = "\"" + view.getJtxtName().getText() + "\"";
        String brand = "\"" + view.getJtxtBrand().getText() + "\"";
        int nit = Integer.parseInt(view.getJtxtNit().getText());
        int quantity = Integer.parseInt(view.getJtxtQuantity().getText());
        int ticket = Integer.parseInt(view.getJtxtTicket().getText());
        String desc = "\"" + view.getJtxtaDesc().getText() + "\"";
        String status = "\"" + view.getJcbStatus().getSelectedItem().toString() + "\"";
        
        DBConnection conn = new DBConnection();
        conn.getConnection();
        //CallableStatement stat = conn.getConn().prepareStatement("CALL registrarActivo(" + Integer.toString(10) + "," + "miguel" + "," + nit + "," + ticket + "," + desc + "," + status + "," + name + ");");
        
        conn.executeQuery("CALL registrarActivo(" + Integer.toString(10) + "," + "\""+"miguel"+"\"" + "," + nit + "," + ticket + "," + desc + "," + status + "," + name + ");");
        conn.endCOnnection();
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
}