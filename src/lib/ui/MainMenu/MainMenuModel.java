package lib.ui.MainMenu;


import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Date;
import lib.app.DBConnection;
import lib.models.User;
import lib.ui.MainApp.MainAppController;

public class MainMenuModel {
    private ResultSet quantityAlerts;
    private ResultSet dateAlerts;
    
    private User user;
    
    private MainAppController rootComponent;

    public MainMenuModel() {
        DBConnection conn = new DBConnection();
        //System.out.println("query 0");
        conn.getConnection();
        quantityAlerts = conn.executeQuery("SELECT * FROM productlowamount");
        //System.out.println("query 1");
        conn.endCOnnection();
        
        conn.getConnection();
        dateAlerts = conn.executeQuery("SELECT * FROM productstoexpire");
        //System.out.println("query 2");
        conn.endCOnnection();
    }
    
    public ArrayList<QuantityAlertPanel> fillQuantityPanels() throws SQLException{
        ArrayList<QuantityAlertPanel> arr = new ArrayList<>();
        while(quantityAlerts.next()){
            String name = quantityAlerts.getString(1);
            int quantity = quantityAlerts.getInt(2);
            int id = quantityAlerts.getInt(3);
            QuantityAlertPanel panel = new QuantityAlertPanel(name, id , quantity, "");
            arr.add(panel);
        }
        return arr;
    }
    
    public ArrayList<DateAlertPanel> fillDatePanels() throws SQLException{
        ArrayList<DateAlertPanel> arr = new ArrayList<>();
        while(dateAlerts.next()){
            String name = dateAlerts.getString(1);
            Date expDate = dateAlerts.getDate(3);
            int id = dateAlerts.getInt(2);
            DateAlertPanel panel = new DateAlertPanel(name, id , expDate, "");
            arr.add(panel);
        }
        return arr;
    }

    public ResultSet getQuantityAlerts() {
        return quantityAlerts;
    }

    public void setQuantityAlerts(ResultSet quantityAlerts) {
        this.quantityAlerts = quantityAlerts;
    }

    public ResultSet getDateAlerts() {
        return dateAlerts;
    }

    public void setDateAlerts(ResultSet dateAlerts) {
        this.dateAlerts = dateAlerts;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public void setRootComponent(MainAppController rootComponent) {
        this.rootComponent = rootComponent;
    }

    public MainAppController getRootComponent() {
        return rootComponent;
    }
    
}
