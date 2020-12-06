//Java imports
package lib.ui.SingleProduction;

import java.awt.Cursor;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import javax.swing.JLabel;
import lib.ui.MainApp.MainAppController;

public class SingleProductionController {
    private final SingleProductionView singleProductionView;
    private final SingleProductionModel singleProductionModel;

    public SingleProductionController(SingleProductionView singleProductionView, SingleProductionModel singleProductionModel, MainAppController rootComponent) {
        this.singleProductionView = singleProductionView;
        this.singleProductionModel = singleProductionModel;
        this.singleProductionModel.setRootComponent(rootComponent);
        
        this.singleProductionView.setDate(this.singleProductionModel.getYears(), this.singleProductionModel.getMonths(), this.singleProductionModel.getDays());
        
        this.singleProductionView.getBackButton().addMouseListener(new SingleProductionListener(this.singleProductionView, this.singleProductionModel));
        this.singleProductionView.getUpdateButton().addMouseListener(new SingleProductionListener(this.singleProductionView, this.singleProductionModel));
        
        this.singleProductionView.getYearComboBox().addActionListener(new SingleActionListener(singleProductionView, singleProductionModel));
        this.singleProductionView.getMonthComboBox().addActionListener(new SingleActionListener(singleProductionView, singleProductionModel));
        this.singleProductionView.getDayComboBox().addActionListener(new SingleActionListener(singleProductionView, singleProductionModel));
        
        this.singleProductionView.getYearComboBox_02().addActionListener(new SingleActionListener(singleProductionView, singleProductionModel));
        this.singleProductionView.getMonthComboBox_02().addActionListener(new SingleActionListener(singleProductionView, singleProductionModel));
        this.singleProductionView.getDayComboBox_02().addActionListener(new SingleActionListener(singleProductionView, singleProductionModel));
    }
    
    private class SingleProductionListener implements MouseListener{
        private final SingleProductionView view;
        private final SingleProductionModel model;

        public SingleProductionListener(SingleProductionView singleProductionView, SingleProductionModel singleProductionModel) {
            this.view = singleProductionView;
            this.model = singleProductionModel;
        }

        @Override
        public void mouseClicked(MouseEvent me) {
            if (me.getSource() == this.view.getBackButton()){
                this.model.getRootComponent().getMainAppView().setProductionListView(this.model.getRootComponent().getMainAppModel().getProductionListView());
            }
            else if (me.getSource() == this.view.getUpdateButton()){
                this.model.updateInfo();
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
            this.view.getBackButton().setCursor(new Cursor(Cursor.HAND_CURSOR));
            this.view.getUpdateButton().setCursor(new Cursor(Cursor.HAND_CURSOR));
        }

        @Override
        public void mouseExited(MouseEvent me) {
            
        }
        
    }
    
    private class SingleActionListener implements ActionListener{
        private final SingleProductionView view;
        private final SingleProductionModel model;

        public SingleActionListener(SingleProductionView singleProductionView, SingleProductionModel singleProductionModel) {
            this.view = singleProductionView;
            this.model = singleProductionModel;
        }

        @Override
        public void actionPerformed(ActionEvent me) {
            if (me.getSource() == this.view.getYearComboBox() || me.getSource() == this.view.getMonthComboBox() || me.getSource() == this.view.getDayComboBox()){
                modifyDate(this.view.getStatringDate());
            }
            else if (me.getSource() == this.view.getYearComboBox_02() || me.getSource() == this.view.getMonthComboBox_02() || me.getSource() == this.view.getDayComboBox_02()){
                modifyDate(this.view.getFinishingDate());
            }
        }
        
        private void modifyDate(JLabel placeHolder){
            if (placeHolder == this.view.getStatringDate()){
                String date = (String) this.view.getYearComboBox().getSelectedItem() + "-" + (String) this.view.getMonthComboBox().getSelectedItem() + "-" + (String) this.view.getDayComboBox().getSelectedItem();
                
                this.view.getStatringDate().setText(date);
            }
            else if (placeHolder == this.view.getFinishingDate()){
                String date = (String) this.view.getYearComboBox_02().getSelectedItem() + "-" + (String) this.view.getMonthComboBox_02().getSelectedItem() + "-" + (String) this.view.getDayComboBox_02().getSelectedItem();
                
                this.view.getFinishingDate().setText(date);
            }
        }
        
    }
}
