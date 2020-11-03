
package lib.ui.consultProductView;


import java.awt.Cursor;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.sql.SQLException;


public class ConsultProductController implements MouseListener {
    
    private ConsultProductModel model;
    private ConsultProductView view;

    
    public ConsultProductController() throws SQLException {
        this.view = new ConsultProductView();
        this.model = new ConsultProductModel(view);
        this.view.getAtraslb().addMouseListener(this);
        model.fillInfoProduct();

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
            //DIRIGIR A VENTANA DE LISTA DE PRODUCTOS
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
        
    }

    @Override
    public void mouseExited(MouseEvent me) {
        
    }
    
}
