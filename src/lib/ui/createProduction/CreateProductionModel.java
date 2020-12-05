/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lib.ui.createProduction;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Calendar;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import lib.app.DBConnection;
import lib.ui.MainApp.MainAppController;
import lib.ui.UsersList.UsersListModel;

/**
 *
 * @author user
 */
public class CreateProductionModel {

    private CreateProductionView view;

    private MainAppController rootComponent;

    public CreateProductionModel(CreateProductionView view) {
        this.view = view;
    }

    public void fillTable() throws SQLException {
        DBConnection conn = new DBConnection();
        conn.getConnection();
        ResultSet result = conn.executeQuery("SELECT pru_id, pru_nombre, pru_marca, pru_cantidad FROM productos WHERE pru_estado != 2;");
        conn.endCOnnection();

        DefaultTableModel model = (DefaultTableModel) view.getJtableProducts().getModel();

        while (result.next()) {
            int id = result.getInt(1);
            String name = result.getString(2);
            String brand = result.getString(3);
            int amount = result.getInt(4);
            model.addRow(new Object[]{id,
                name,
                brand,
                amount,
                0});
        }
        view.updateUI();
    }

    public void updateTable() {
        DefaultTableModel model = (DefaultTableModel) view.getJtableProducts().getModel();
        int rowCount = model.getRowCount();
        for (int i = 0; i < rowCount; i++) {
            model.removeRow(0);
        }
        try {
            fillTable();
        } catch (SQLException ex) {
            Logger.getLogger(UsersListModel.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public void createProduction() throws SQLException {

        if (checkAmounts()) {
            JOptionPane.showMessageDialog(view, "Hay cantidades incorrectas", "", JOptionPane.WARNING_MESSAGE);
        } else {
            DBConnection conn = new DBConnection();
            conn.getConnection();

            String finishYear = (String) view.getJcbxYear().getSelectedItem();
            String finishMonth = (String) view.getJcbxMonth().getSelectedItem();
            String finishDay = (String) view.getJcbxDay().getSelectedItem();
            String finishDate = "\"" + finishYear + "-" + finishMonth + "-" + finishDay + "\"";

            String startYear = (String) view.getJcbxYear1().getSelectedItem();
            String startMonth = (String) view.getJcbxMonth1().getSelectedItem();
            String startDay = (String) view.getJcbxDay1().getSelectedItem();
            String startDate = "\"" + startYear + "-" + startMonth + "-" + startDay + "\"";

            String type = "\"" + view.getJtxtType().getText() + "\"";
            String user = "\"" + rootComponent.getMainAppModel().getLoggedUser().getUser() + "\"";
            String status = "\"" + "Nueva" + "\"";
            conn.executeQuery("CALL create_production(" + startDate + "," + finishDate + "," + type + "," + user + "," + status + ");");

            ResultSet result = conn.executeQuery("SELECT prd_id FROM producciones ORDER BY prd_id DESC");
            result.next();
            String productionId = Integer.toString(result.getInt(1));
            DefaultTableModel model = (DefaultTableModel) view.getJtableProducts().getModel();
            int rowCount = model.getRowCount();
            for (int i = 0; i < rowCount; i++) {
                String productId = Integer.toString((int) model.getValueAt(i, 0));
                int amount = (int) model.getValueAt(i, 3);
                if (amount != 0) {
                    conn.executeQuery("CALL link_product_to_production(" + productId + "," + productionId + "," + Integer.toString(amount) + ");");
                }
            }
            JOptionPane.showMessageDialog(view, "Producción creada", "", JOptionPane.INFORMATION_MESSAGE);
            conn.endCOnnection();
        }

        
    }

    private boolean checkAmounts() throws SQLException {
        DBConnection conn = new DBConnection();
        conn.getConnection();
        DefaultTableModel model = (DefaultTableModel) view.getJtableProducts().getModel();
        int rowCount = model.getRowCount();
        boolean allZero = true;
        for (int i = 0; i < rowCount; i++) {
            int productId = (int) model.getValueAt(i, 0);
            int amount = (int) model.getValueAt(i, 3);

            ResultSet result = conn.executeQuery("SELECT pru_cantidad FROM productos WHERE pru_id = " + Integer.toString(productId) + ";");
            result.next();
            System.out.println("stock: " + result.getInt(1));
            System.out.println("cantidad: " + amount);
            if (amount != 0) {
                allZero = false;
            }
            if (result.getInt(1) - amount < 0 || result.getInt(1) < 0) {
                return true;
            }
        }

        conn.endCOnnection();

        return allZero;
    }

    public void clearFields() {
        view.getJtxtType().setText("");
        view.getJcbxDay().setSelectedIndex(0);
        view.getJcbxMonth().setSelectedIndex(0);
        view.getJcbxYear().setSelectedIndex(0);
        view.getJcbxDay1().setSelectedIndex(0);
        view.getJcbxMonth1().setSelectedIndex(0);
        view.getJcbxYear1().setSelectedIndex(0);

    }

    public CreateProductionView getView() {
        return view;
    }

    public void setView(CreateProductionView view) {
        this.view = view;
    }

    public MainAppController getRootComponent() {
        return rootComponent;
    }

    public void setRootComponent(MainAppController rootComponent) {
        this.rootComponent = rootComponent;
    }

}
