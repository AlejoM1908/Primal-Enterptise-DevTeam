//Java imports
package lib.models;
import java.sql.ResultSet;
import javax.swing.table.DefaultTableModel;
import lib.app.DBConnection;

public class CustomTableModel extends DefaultTableModel{
    DBConnection con = new DBConnection();
    

    public CustomTableModel() {
        super();
        initializeTable();
    }
    
    private void initializeTable(){
        String[] titles = {"Icono", "Nombre", "ID Producto"};
        setColumnIdentifiers(titles);
        
        con.getConnection();
        try{
            ResultSet result = con.executeQuery("select * from getLastHistory");
            con.endCOnnection();

            while (result.next()){
                String[] query = new String[5];
                
                query[0] = result.getString("name");
                query[1] = result.getString("value");
                query[2] = result.getString("dateTime");
                query[3] = result.getString("location");
                query[4] = result.getString("processing");
                
                addRow(query);
            }
        }
        catch(Exception e){
            
        }
    } 
    
    @Override
    public boolean isCellEditable (int row, int column){
        return false;
    }
}
