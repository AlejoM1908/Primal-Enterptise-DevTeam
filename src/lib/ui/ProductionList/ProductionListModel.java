
package lib.ui.ProductionList;

import java.sql.ResultSet;
import java.sql.SQLException;
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
            model.addRow(new Object[]{Integer.parseInt(result.getString(1)), result.getString(3), result.getString(4)});
        }
        view.updateUI();
    }
    
}
