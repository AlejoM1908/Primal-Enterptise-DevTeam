/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lib.ui.UsersList;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.table.DefaultTableModel;
import lib.app.DBConnection;
import lib.ui.MainApp.MainAppController;

/**
 *
 * @author user
 */
public class UsersListModel {
    private UsersListView view;
    
    private MainAppController rootComponent;

    public UsersListModel(UsersListView view) {
        this.view = view;
    }
    
    public UsersListView getView() {
        return view;
    }

    public void setView(UsersListView view) {
        this.view = view;
    }
    
    public void fillTable() throws SQLException{
        DBConnection conn = new DBConnection();
        conn.getConnection();
        ResultSet result = conn.executeQuery("SELECT * FROM usuarios JOIN telefonos WHERE usuarios.usr_usuario = telefonos.tel_usuario AND usr_estado != 3;");
        conn.endCOnnection();
        
        DefaultTableModel model = (DefaultTableModel) view.getJtUsers().getModel();
        
        while(result.next()){
            String name = result.getString(5);
            String user = result.getString(1);
            int id = result.getInt(7);
            int tel = result.getInt(11);
            String range = result.getString(2);
            String email = result.getString(4);
            String address = result.getString(6);
            boolean blocked = result.getInt(8) == 2;
            model.addRow(new Object[]{name,
                                      user,
                                      id,
                                      tel,
                                      range,
                                      email,
                                      address,
                                      blocked});
        }
        view.updateUI();
    }
    
    public void updateTable(){
        DefaultTableModel model = (DefaultTableModel) view.getJtUsers().getModel();
        int rowCount = model.getRowCount();
        for(int i = 0; i < rowCount; i++){
            model.removeRow(0);
        }
        try {
            fillTable();
        } catch (SQLException ex) {
            Logger.getLogger(UsersListModel.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public void saveChanges(){
        DBConnection conn = new DBConnection();
        conn.getConnection();
        DefaultTableModel model = (DefaultTableModel) view.getJtUsers().getModel();
        int rowCount = model.getRowCount();
        for(int i = 0; i < rowCount; i++){
            boolean isBlocked = (boolean) model.getValueAt(i, 7);
            int newStatus = 1;
            if(isBlocked) newStatus = 2;
            String user = "\"" + (String) model.getValueAt(i, 1) + "\"";
            conn.executeQuery("CALL updateUserStatus(" + user + "," + Integer.toString(newStatus) + ");");
        }
        conn.endCOnnection();
    }

    public MainAppController getRootComponent() {
        return rootComponent;
    }

    public void setRootComponent(MainAppController rootComponent) {
        this.rootComponent = rootComponent;
    }
    
    
}
