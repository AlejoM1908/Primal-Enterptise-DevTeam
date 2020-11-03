/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lib.ui.UsersList;

import java.sql.ResultSet;
import java.sql.SQLException;
import javax.swing.table.DefaultTableModel;
import lib.app.DBConnection;

/**
 *
 * @author user
 */
public class UsersListModel {
    private UsersListView view;

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
        ResultSet result = conn.executeQuery("SELECT * FROM usuarios JOIN telefonos WHERE usr_telefonos_id = tel_id;");
        conn.endCOnnection();
        
        DefaultTableModel model = (DefaultTableModel) view.getJtUsers().getModel();
        while(result.next()){
            model.addRow(new Object[]{result.getString(6), result.getString(1), Integer.parseInt(result.getString(8))
                    , Integer.parseInt(result.getString(10)), result.getString(3), result.getString(5), result.getString(7)});
        }
        view.updateUI();
    }
}
