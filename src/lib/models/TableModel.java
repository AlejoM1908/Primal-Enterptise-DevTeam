//Java imports
package lib.models;
import java.sql.ResultSet;
import javax.swing.table.DefaultTableModel;
import lib.app.DBConnection;

public class TableModel extends DefaultTableModel{
    DBConnection con = new DBConnection();
    

    public TableModel(int id) {
        super();
        initializeTable(id);
    }
    
    private void initializeTable(int id){
        String[] titles = {"Icono", "Nombre", "ID Producto"};
        setColumnIdentifiers(titles);
        
        con.getConnection();
        try{
            ResultSet result = con.executeQuery("call getProductionsProducts(" + id + ");");
            con.endCOnnection();

            while (result.next()){
                String[] query = new String[5];
                
                query[0] = result.getString("icon");
                query[1] = result.getString("nombre");
                query[2] = result.getString("id");
                
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
