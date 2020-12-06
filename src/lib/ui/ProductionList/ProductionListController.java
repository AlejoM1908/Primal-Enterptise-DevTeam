
package lib.ui.ProductionList;

import java.awt.Cursor;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import lib.app.DBConnection;
import lib.ui.MainApp.MainAppController;
import lib.ui.productionSubmenu.ProductionSubmenuView;


public class ProductionListController implements MouseListener {
    
    private ProductionListModel model;
    private ProductionListView view;

    public ProductionListController(ProductionListView view, ProductionListModel model, MainAppController rootComponent) {
        this.view = view;
        this.model = model;
        this.model.setRoot(rootComponent);
        try {
            this.model.fillTableProductions();
        } catch (SQLException ex) {
            Logger.getLogger(ProductionListController.class.getName()).log(Level.SEVERE, null, ex);
        }
        this.view.getJlDetailProduction().addMouseListener(this);
        this.view.getJlReturn().addMouseListener(this);
    }
    @Override
    public void mouseClicked(MouseEvent me) {
        if(me.getSource() == this.view.getJlReturn()){
            ProductionSubmenuView productionSubmenuView = this.model.getRoot().getMainAppModel().getProductionSubmenuView();
            this.model.getRoot().getMainAppView().setProductionSubmenuView(productionSubmenuView);
        } else if (me.getSource()==this.view.getJlDetailProduction()){
            int row = this.view.getProductionsTable().getSelectedRow();
            
            if (row == -1)
                this.view.sendError();
            else
                this.model.getRoot().goToSingleProduction( (int) this.view.getProductionsTable().getValueAt(row, 0));
        }
    }

    @Override
    public void mousePressed(MouseEvent me) {
       
    }

    @Override
    public void mouseReleased(MouseEvent me) {
        
    }

    @Override
    public void mouseEntered(MouseEvent me) {
        this.view.getJlReturn().setCursor(new Cursor(Cursor.HAND_CURSOR));
        this.view.getJlDetailProduction().setCursor(new Cursor(Cursor.HAND_CURSOR));
        
    }

    @Override
    public void mouseExited(MouseEvent me) {
       
    }
    
}
