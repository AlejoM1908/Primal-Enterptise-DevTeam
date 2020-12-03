
package lib.ui.ProductionList;

import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import lib.ui.MainApp.MainAppController;


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
    }
    @Override
    public void mouseClicked(MouseEvent me) {
        throw new UnsupportedOperationException(); 
    }

    @Override
    public void mousePressed(MouseEvent me) {
        throw new UnsupportedOperationException(); 
    }

    @Override
    public void mouseReleased(MouseEvent me) {
        throw new UnsupportedOperationException(); 
    }

    @Override
    public void mouseEntered(MouseEvent me) {
        throw new UnsupportedOperationException(); 
    }

    @Override
    public void mouseExited(MouseEvent me) {
        throw new UnsupportedOperationException(); 
    }
    
}
