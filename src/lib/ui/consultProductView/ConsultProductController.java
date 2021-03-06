
package lib.ui.consultProductView;


import java.awt.Cursor;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import lib.ui.Inventory.InventoryView;
import lib.ui.MainApp.MainAppController;


public class ConsultProductController implements MouseListener {
    
    private ConsultProductModel model;
    private ConsultProductView view;

    
    public ConsultProductController(ConsultProductView view, ConsultProductModel model, MainAppController rootComponent) {
        this.view = view;
        this.model = model;
        this.model.setRootComponent(rootComponent);
        this.view.getAtraslb().addMouseListener(this);
        this.view.getJlSave().addMouseListener(this);
    }

    public ConsultProductModel getModel() {
        return model;
    }

    public ConsultProductView getView() {
        return view;
    }

    @Override
    public void mouseClicked(MouseEvent me) {
       if(me.getSource() == view.getAtraslb()){
            InventoryView inventoryView = this.model.getRootComponent().getMainAppModel().getInventoryView();
            this.model.getRootComponent().getMainAppModel().getInventoryModel().updateTable();
            this.model.getRootComponent().getMainAppView().setInventory(inventoryView);
        }else if(me.getSource() == view.getJlSave()){
            this.model.updateInfo();
            JOptionPane.showMessageDialog(view, "Cambios guardados", "", JOptionPane.INFORMATION_MESSAGE);
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
        view.getAtraslb().setCursor(new Cursor(Cursor.HAND_CURSOR));
        view.getJlSave().setCursor(new Cursor(Cursor.HAND_CURSOR));
    }

    @Override
    public void mouseExited(MouseEvent me) {
        
    }
    
}
