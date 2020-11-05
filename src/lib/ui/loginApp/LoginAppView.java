//Java imports
package lib.ui.loginApp;

//Proyect imports
import lib.ui.loginView.LoginView;
import lib.ui.loginView.LoginController;
import lib.ui.loginView.LoginModel;
import lib.models.User;

public class LoginAppView extends javax.swing.JFrame {
    
    public LoginAppView() {
        initComponents();
        
        this.setSize(1360, 768);
        this.setResizable(false);
        this.setLocationRelativeTo(null);
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        appPrincipal = new javax.swing.JPanel();
        appBar = new javax.swing.JPanel();
        appContent = new javax.swing.JPanel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setMinimumSize(new java.awt.Dimension(1360, 786));
        setUndecorated(true);

        appBar.setBackground(new java.awt.Color(51, 255, 51));
        appBar.setLayout(new java.awt.CardLayout());

        appContent.setBackground(new java.awt.Color(51, 255, 255));
        appContent.setLayout(new java.awt.CardLayout());

        javax.swing.GroupLayout appPrincipalLayout = new javax.swing.GroupLayout(appPrincipal);
        appPrincipal.setLayout(appPrincipalLayout);
        appPrincipalLayout.setHorizontalGroup(
            appPrincipalLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(appContent, javax.swing.GroupLayout.DEFAULT_SIZE, 1360, Short.MAX_VALUE)
            .addComponent(appBar, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        appPrincipalLayout.setVerticalGroup(
            appPrincipalLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(appPrincipalLayout.createSequentialGroup()
                .addComponent(appBar, javax.swing.GroupLayout.DEFAULT_SIZE, 71, Short.MAX_VALUE)
                .addGap(0, 0, 0)
                .addComponent(appContent, javax.swing.GroupLayout.PREFERRED_SIZE, 708, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        getContentPane().add(appPrincipal, java.awt.BorderLayout.CENTER);

        pack();
    }// </editor-fold>//GEN-END:initComponents

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
            java.util.logging.Logger.getLogger(LoginAppView.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(LoginAppView.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(LoginAppView.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(LoginAppView.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new LoginAppView().setVisible(true);
            }
        });
    }

    private void setLogin(LoginView loginView){
        this.appContent.add(loginView);
        loginView.setVisible(true);
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel appBar;
    private javax.swing.JPanel appContent;
    private javax.swing.JPanel appPrincipal;
    // End of variables declaration//GEN-END:variables
}
