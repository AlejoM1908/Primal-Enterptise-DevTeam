/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lib.ui.registroProd;

import java.awt.Cursor;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import javax.swing.JOptionPane;
import lib.ui.InventoryMenu.InventoryMenuView;
import lib.ui.MainApp.MainAppController;

/**
 *
 * @author Fredy AGP
 */
public class prodController implements MouseListener {

    private prodModel model;
    private registroProd view;

    public prodController(prodModel model, registroProd view, MainAppController rootComponent) {
        this.view = view;
        this.model = model;
        this.model.setRootComponent(rootComponent);

        this.view.getRegistrarB().addMouseListener(this);
        this.view.getRegresarB().addMouseListener(this);
    }
    /*
    public int registrados(String nombre, String marca, String tipo, String nit, String cantidad, String metodo, String lugar, String fecha, String usr, String descrip) {
        int registro_retorno;
        int num_nit;
        int num_cantidad;
        try {
            num_nit = Integer.parseInt(nit);

        } catch (NumberFormatException ex) {
            return 0;
        }
        try {
            num_cantidad = Integer.parseInt(cantidad);

        } catch (NumberFormatException ex) {
            return 0;
        }
        prodModel registro = new prodModel(this.view);
        registro_retorno = registro.registro_prod(nombre, marca, tipo, num_nit, num_cantidad, metodo, lugar, fecha, usr, descrip);
        return registro_retorno;
    }*/

    @Override
    public void mouseClicked(MouseEvent me) {
        if (me.getSource() == this.view.getRegresarB()) {
            System.out.println("prueba");
            InventoryMenuView inventoryMenuView = this.model.getRootComponent().getMainAppModel().getInventoryMenuView();
            this.model.getRootComponent().getMainAppView().setInventoryMenu(inventoryMenuView);
        } else if (me.getSource() == this.view.getRegistrarB()) {
            int indicador;
            String fecha = "\"" + this.view.getAnoCB().getSelectedItem().toString() + "-" + this.view.getMesCB().getSelectedItem().toString() + "-" + this.view.getDiaCB().getSelectedItem().toString() + "\"";
            String usr = "\"" + this.model.getRootComponent().getMainAppModel().getLoggedUser().getUser() + "\"";
            
            indicador = this.model.registrados("\"" + this.view.getNombreTF().getText() + "\"", "\"" + this.view.getMarcaTF().getText() + "\"",
                    "\"" + this.view.getTipolTF().getText() + "\"", this.view.getNitTF().getText(), this.view.getCantidadTF().getText(), "\"" + this.view.getAlmacenamientoTF().getText() + "\"",
                    "\"" + this.view.getLugarTF().getText() + "\"", fecha, usr, "\"" + this.view.getDescripcionTF().getText() + "\"");

            if (indicador != 1) {
                JOptionPane.showMessageDialog(this.view, "Datos Incorrectos");
            }

            {
                JOptionPane.showMessageDialog(this.view, "Producto registrado");
            }

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
        this.view.getRegistrarB().setCursor(new Cursor(Cursor.HAND_CURSOR));
        this.view.getRegresarB().setCursor(new Cursor(Cursor.HAND_CURSOR));
    }

    @Override
    public void mouseExited(MouseEvent me) {

    }
}
