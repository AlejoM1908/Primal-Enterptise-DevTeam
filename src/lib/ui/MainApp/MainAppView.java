//Java imports
package lib.ui.MainApp;
import java.awt.Component;
import javax.swing.ImageIcon;
import javax.swing.JPanel;
import lib.ui.AssetRegistration.AssetRegistrationView;
import lib.ui.AssetsReport.AssetsReportView;
import lib.ui.EditAccount.EditAccountView;
import lib.ui.Inventory.InventoryView;
import lib.ui.InventoryMenu.InventoryMenuView;
import lib.ui.MainBar.MainBarView;
import lib.ui.MainMenu.MainMenuView;
import lib.ui.ProductionList.ProductionListView;
import lib.ui.ProductionsReport.ProductionsReportView;
import lib.ui.ReportsMenu.ReportsMenuView;
import lib.ui.SupplierRegistration.SupplierRegistrationView;
import lib.ui.UsersList.UsersListView;
import lib.ui.buttonBar.ButtonBarView;
import lib.ui.productionSubmenu.ProductionSubmenuView;
import lib.ui.consultProductView.ConsultProductView;
//Proyect imports
import lib.ui.registroUsr.registroUsr;
import lib.ui.registroProd.registroProd;
import lib.ui.userAdministrationMenuView.AdministrationMenuView;


public class MainAppView extends javax.swing.JFrame {
    private JPanel registro = new registroUsr();
    private JPanel registro_prod = new registroProd();

    public MainAppView() {
        initComponents();
        
        this.setSize(1360, 768);
        this.setResizable(false);
        this.setLocationRelativeTo(null);
        
        this.setIconImage(new ImageIcon(getClass().getResource("/lib/images/AppLogo_100x100Px.png")).getImage());
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        ButtonPanel = new javax.swing.JPanel();
        appBar = new javax.swing.JPanel();
        appContent = new javax.swing.JPanel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setMaximumSize(new java.awt.Dimension(1360, 768));
        setMinimumSize(new java.awt.Dimension(1360, 768));
        setUndecorated(true);
        setResizable(false);

        ButtonPanel.setBackground(new java.awt.Color(255, 51, 51));
        ButtonPanel.setMaximumSize(new java.awt.Dimension(300, 708));
        ButtonPanel.setMinimumSize(new java.awt.Dimension(300, 708));
        ButtonPanel.setPreferredSize(new java.awt.Dimension(300, 708));
        ButtonPanel.setLayout(new java.awt.CardLayout());

        appBar.setBackground(new java.awt.Color(51, 255, 51));
        appBar.setMaximumSize(new java.awt.Dimension(1360, 60));
        appBar.setMinimumSize(new java.awt.Dimension(1360, 60));
        appBar.setPreferredSize(new java.awt.Dimension(1360, 60));
        appBar.setRequestFocusEnabled(false);
        appBar.setLayout(new java.awt.CardLayout());

        appContent.setBackground(new java.awt.Color(0, 51, 255));
        appContent.setMaximumSize(new java.awt.Dimension(1060, 708));
        appContent.setMinimumSize(new java.awt.Dimension(1060, 708));
        appContent.setPreferredSize(new java.awt.Dimension(1060, 708));
        appContent.setLayout(new java.awt.CardLayout());

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(ButtonPanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, 0)
                .addComponent(appContent, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addComponent(appBar, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(appBar, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, 0)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(ButtonPanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(appContent, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(MainAppView.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(MainAppView.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(MainAppView.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(MainAppView.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new MainAppView().setVisible(true);
            }
        });
    }
    
    protected void setMainBar(MainBarView mainBarView){
        this.appBar.add(mainBarView);
        mainBarView.setVisible(true);
    }

    protected void setButtonBar(ButtonBarView buttonBarView){
        this.ButtonPanel.add(buttonBarView);
        buttonBarView.setVisible(true);
    }
    
    public void setMainMenu(MainMenuView mainMenuView){
        for(Component c : this.appContent.getComponents()){
            c.setVisible(false);
        }
        this.appContent.removeAll();
        this.appContent.add(mainMenuView);
        mainMenuView.setVisible(true);
    }
    
    public void setEditAccount(EditAccountView editAccountView){
        for(Component c : this.appContent.getComponents()){
            c.setVisible(false);
        }
        this.appContent.removeAll();
        
        this.appContent.add(editAccountView);
        editAccountView.setVisible(true);
    }
    
    public void setAdministrationMenu(AdministrationMenuView adminMenuView){
        for(Component c : this.appContent.getComponents()){
            c.setVisible(false);
        }
        this.appContent.removeAll();
        
        this.appContent.add(adminMenuView);
        adminMenuView.setVisible(true);
    }
    
    public void setUsersList(UsersListView usersListView){
        for(Component c : this.appContent.getComponents()){
            c.setVisible(false);
        }
        this.appContent.removeAll();
        
        this.appContent.add(usersListView);
        usersListView.setVisible(true);
    }
    
    public void setAssetRegistration(AssetRegistrationView assetRegistrationView){
        for(Component c : this.appContent.getComponents()){
            c.setVisible(false);
        }
        this.appContent.removeAll();
        
        this.appContent.add(assetRegistrationView);
        assetRegistrationView.setVisible(true);
    }
    
    public void setInventory(InventoryView inventoryView){
        for(Component c : this.appContent.getComponents()){
            c.setVisible(false);
        }
        this.appContent.removeAll();
        
        this.appContent.add(inventoryView);
        inventoryView.setVisible(true);
    }
    
    public void setSupplierRegistration(SupplierRegistrationView supplierRegistrationView){
        for(Component c : this.appContent.getComponents()){
            c.setVisible(false);
        }
        this.appContent.removeAll();
        
        this.appContent.add(supplierRegistrationView);
        supplierRegistrationView.setVisible(true);
    }
    
    public void setProductionSubmenuView(ProductionSubmenuView productionSubmenuView){
        for(Component c : this.appContent.getComponents()){
            c.setVisible(false);
        }
        this.appContent.removeAll();
        
        this.appContent.add(productionSubmenuView);
        productionSubmenuView.setVisible(true);
    }
    
    public void setAssetsReport(AssetsReportView assetsReportView){
        for(Component c : this.appContent.getComponents()){
            c.setVisible(false);
        }
        this.appContent.removeAll();

        this.appContent.add(assetsReportView);
        assetsReportView.setVisible(true);
    }
    
    public void setReportsMenu(ReportsMenuView reportsMenuView){
        for(Component c : this.appContent.getComponents()){
            c.setVisible(false);
        }
        this.appContent.removeAll();
        
        this.appContent.add(reportsMenuView);
        reportsMenuView.setVisible(true);
    }
    
    public void setProductionsReport(ProductionsReportView productionsReportView){
        for(Component c : this.appContent.getComponents()){
            c.setVisible(false);
        }
        this.appContent.removeAll();
        
        this.appContent.add(productionsReportView);
        productionsReportView.setVisible(true);
    }
    
    public void setInventoryMenu(InventoryMenuView inventoryMenuView){
        for(Component c : this.appContent.getComponents()){
            c.setVisible(false);
        }
        this.appContent.removeAll();
        
        this.appContent.add(inventoryMenuView);
        inventoryMenuView.setVisible(true);
    }
    
    public void setRegisterProduct(registroProd registerProductView){
        for(Component c : this.appContent.getComponents()){
            c.setVisible(false);
        }
        this.appContent.removeAll();
        
        this.appContent.add(registerProductView);
        registerProductView.setVisible(true);
    }
    
    public void setRegisterUser(registroUsr registerUserView){
        for(Component c : this.appContent.getComponents()){
            c.setVisible(false);
        }
        this.appContent.removeAll();
        
        this.appContent.add(registerUserView);
        registerUserView.setVisible(true);
    }
    
    public void setConsultProduct(ConsultProductView consultProductView){
        for(Component c : this.appContent.getComponents()){
            c.setVisible(false);
        }
        this.appContent.removeAll();
        
        this.appContent.add(consultProductView);
        consultProductView.setVisible(true);
    }
    
    public void setProductionListView(ProductionListView productionListView){
        for(Component c : this.appContent.getComponents()){
            c.setVisible(false);
        }
        this.appContent.removeAll();
        
        this.appContent.add(productionListView);
        productionListView.setVisible(true);
        
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel ButtonPanel;
    private javax.swing.JPanel appBar;
    private javax.swing.JPanel appContent;
    // End of variables declaration//GEN-END:variables
}
