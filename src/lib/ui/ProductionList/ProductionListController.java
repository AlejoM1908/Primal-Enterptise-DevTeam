
package lib.ui.ProductionList;

import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.sql.SQLException;


public class ProductionListController implements MouseListener {
    
    private ProductionListModel model;
    private ProductionListView view;

    public ProductionListController() throws SQLException {
        this.view = new ProductionListView();
        this.model = new ProductionListModel(view);
        this.model.fillTableProductions();
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
