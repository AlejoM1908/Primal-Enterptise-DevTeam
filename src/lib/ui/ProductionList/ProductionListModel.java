
package lib.ui.ProductionList;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.table.DefaultTableModel;
import lib.app.DBConnection;
import lib.ui.MainApp.MainAppController;


/**
 *
 * @author rodri
 */
public class ProductionListModel {
    
    private ProductionListView view;
    private MainAppController root;

    public MainAppController getRoot() {
        return root;
    }

    public void setRoot(MainAppController root) {
        this.root = root;
    }

    public ProductionListModel(ProductionListView view) {
        this.view = view;
    }

    public ProductionListView getView() {
        return view;
    }

    public void setView(ProductionListView view) {
        this.view = view;
    }
    
    public void fillTableProductions() throws SQLException{
        DBConnection conn = new DBConnection();
        conn.getConnection();
        ResultSet result = conn.executeQuery("SELECT prd_id, prd_estado , prd_tipo FROM producciones;" );
        conn.endCOnnection();
        
        DefaultTableModel model = (DefaultTableModel) view.getJtProductions().getModel();
        while(result.next()){
            int prd_id = Integer.parseInt(result.getString(1));
            String estado = result.getString(2);
            String tipo = result.getString(3);
            model.addRow(new Object[]{prd_id,
                                      estado,
                                      tipo});
        }
        view.updateUI();
    }
    
    public void updateTableListProduction(){
        DefaultTableModel model = (DefaultTableModel) view.getJtProductions().getModel();
        int rowCount = model.getRowCount();
        for(int i = 0; i < rowCount; i++){
            model.removeRow(0);
        }
        try {
            fillTableProductions();
        } catch (SQLException ex) {
            Logger.getLogger(ProductionListModel.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
}
