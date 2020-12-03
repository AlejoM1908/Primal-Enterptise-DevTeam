//Java imports
package lib.ui.loginView;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import lib.utils.AppColors;

public class LoginView extends javax.swing.JPanel {
    private AppColors color = new AppColors();
    
    public LoginView() {
        initComponents();
        
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        loginPanel = new javax.swing.JPanel();
        optionsPanel = new javax.swing.JPanel();
        userLabel = new javax.swing.JLabel();
        userField = new javax.swing.JTextField();
        userSeparator = new javax.swing.JSeparator();
        passwordLabel = new javax.swing.JLabel();
        passwordField = new javax.swing.JPasswordField();
        passwordSeparator = new javax.swing.JSeparator();
        LoginButton = new javax.swing.JLabel();
        titleLabel = new javax.swing.JLabel();
        titleLogo = new javax.swing.JLabel();
        imagePanel = new javax.swing.JPanel();
        image = new javax.swing.JLabel();

        setBorder(javax.swing.BorderFactory.createLineBorder(this.color.borderColor()));
        setMaximumSize(new java.awt.Dimension(1360, 708));
        setMinimumSize(new java.awt.Dimension(1360, 708));
        setPreferredSize(new java.awt.Dimension(1360, 708));

        loginPanel.setBackground(new java.awt.Color(255, 255, 255));
        loginPanel.setMaximumSize(new java.awt.Dimension(680, 708));
        loginPanel.setMinimumSize(new java.awt.Dimension(680, 708));
        loginPanel.setRequestFocusEnabled(false);

        optionsPanel.setBackground(new java.awt.Color(255, 255, 255));
        optionsPanel.setBorder(javax.swing.BorderFactory.createLineBorder(color.borderColor()));

        userLabel.setBackground(new java.awt.Color(255, 255, 255));
        userLabel.setFont(new java.awt.Font("Leelawadee UI", 0, 28)); // NOI18N
        userLabel.setForeground(color.textColor());
        userLabel.setText("Usuario :");

        userField.setFont(new java.awt.Font("Leelawadee UI", 0, 20)); // NOI18N
        userField.setForeground(color.textColor());
        userField.setBorder(null);

        userSeparator.setForeground(color.borderColor());

        passwordLabel.setBackground(new java.awt.Color(255, 255, 255));
        passwordLabel.setFont(new java.awt.Font("Leelawadee UI", 0, 28)); // NOI18N
        passwordLabel.setForeground(color.textColor());
        passwordLabel.setText("Contraseña :");

        passwordField.setFont(new java.awt.Font("Leelawadee UI", 0, 20)); // NOI18N
        passwordField.setForeground(color.textColor());
        passwordField.setBorder(null);

        passwordSeparator.setForeground(color.borderColor());

        LoginButton.setBackground(color.buttonColor());
        LoginButton.setFont(new java.awt.Font("Leelawadee UI", 0, 32)); // NOI18N
        LoginButton.setForeground(new java.awt.Color(255, 255, 255));
        LoginButton.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        LoginButton.setText("iniciar");
        LoginButton.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        LoginButton.setOpaque(true);

        javax.swing.GroupLayout optionsPanelLayout = new javax.swing.GroupLayout(optionsPanel);
        optionsPanel.setLayout(optionsPanelLayout);
        optionsPanelLayout.setHorizontalGroup(
            optionsPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, optionsPanelLayout.createSequentialGroup()
                .addContainerGap(25, Short.MAX_VALUE)
                .addGroup(optionsPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.CENTER)
                    .addComponent(LoginButton, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(optionsPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                        .addComponent(userField)
                        .addComponent(userLabel)
                        .addComponent(passwordLabel)
                        .addComponent(userSeparator)
                        .addComponent(passwordField)
                        .addComponent(passwordSeparator, javax.swing.GroupLayout.PREFERRED_SIZE, 420, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(33, 33, 33))
        );
        optionsPanelLayout.setVerticalGroup(
            optionsPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(optionsPanelLayout.createSequentialGroup()
                .addGap(21, 21, 21)
                .addComponent(userLabel)
                .addGap(18, 18, 18)
                .addComponent(userField, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, 0)
                .addComponent(userSeparator, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(45, 45, 45)
                .addComponent(passwordLabel)
                .addGap(18, 18, 18)
                .addComponent(passwordField, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, 0)
                .addComponent(passwordSeparator, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 50, Short.MAX_VALUE)
                .addComponent(LoginButton)
                .addGap(35, 35, 35))
        );

        titleLabel.setBackground(new java.awt.Color(255, 255, 255));
        titleLabel.setFont(new java.awt.Font("Leelawadee UI", 0, 56)); // NOI18N
        titleLabel.setForeground(color.textColor());
        titleLabel.setText("rimal Enterprise");

        titleLogo.setIcon(new javax.swing.ImageIcon(getClass().getResource("/lib/images/AppLogo_100x100Px.png"))); // NOI18N

        javax.swing.GroupLayout loginPanelLayout = new javax.swing.GroupLayout(loginPanel);
        loginPanel.setLayout(loginPanelLayout);
        loginPanelLayout.setHorizontalGroup(
            loginPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(loginPanelLayout.createSequentialGroup()
                .addGap(96, 96, 96)
                .addGroup(loginPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(loginPanelLayout.createSequentialGroup()
                        .addComponent(titleLogo)
                        .addGap(0, 0, 0)
                        .addComponent(titleLabel))
                    .addComponent(optionsPanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(99, Short.MAX_VALUE))
        );
        loginPanelLayout.setVerticalGroup(
            loginPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(loginPanelLayout.createSequentialGroup()
                .addGap(66, 66, 66)
                .addGroup(loginPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(titleLabel, javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, loginPanelLayout.createSequentialGroup()
                        .addComponent(titleLogo)
                        .addGap(10, 10, 10)))
                .addGap(55, 55, 55)
                .addComponent(optionsPanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(77, Short.MAX_VALUE))
        );

        imagePanel.setBackground(new java.awt.Color(255, 255, 255));
        imagePanel.setMaximumSize(new java.awt.Dimension(680, 708));
        imagePanel.setMinimumSize(new java.awt.Dimension(680, 708));

        image.setIcon(new javax.swing.ImageIcon(getClass().getResource("/lib/images/loginImage_680x708px.png"))); // NOI18N

        javax.swing.GroupLayout imagePanelLayout = new javax.swing.GroupLayout(imagePanel);
        imagePanel.setLayout(imagePanelLayout);
        imagePanelLayout.setHorizontalGroup(
            imagePanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, imagePanelLayout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(image, javax.swing.GroupLayout.PREFERRED_SIZE, 680, javax.swing.GroupLayout.PREFERRED_SIZE))
        );
        imagePanelLayout.setVerticalGroup(
            imagePanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(imagePanelLayout.createSequentialGroup()
                .addComponent(image, javax.swing.GroupLayout.PREFERRED_SIZE, 708, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(loginPanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, 0)
                .addComponent(imagePanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(loginPanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(imagePanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
        );
    }// </editor-fold>//GEN-END:initComponents

    
    public JLabel getLoginButton(){
        return this.LoginButton;
    }

    public String getUserName(){
        return this.userField.getText();
    }

    public String getPassword(){
        return String.valueOf(this.passwordField.getPassword());
    }
    
    public void displayErrorMessage(int errorNum){
        switch (errorNum){
            case -1:
                JOptionPane.showMessageDialog(this, 
                        "Algo ocurrio mal con la base de datos, intente nuevamnete");
                break;
            case 0:
                JOptionPane.showMessageDialog(this, 
                        "El usuario no existe o se ingreso incorrectamnte, intente nuevamnete");
                break;
            case 1:
                JOptionPane.showMessageDialog(this, 
                        "La contraseña ingresada no es correcta, intente nuevamnte");
                break;
            case 3:
                JOptionPane.showMessageDialog(this, 
                        "Los campos no pueden estar vacios, intente nuevamnte");
                break;
            case 4:
                JOptionPane.showMessageDialog(this, 
                        "Usuario Bloqueado, Contacte a un Administrador del Sistema");
                break;
        }
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel LoginButton;
    private javax.swing.JLabel image;
    private javax.swing.JPanel imagePanel;
    private javax.swing.JPanel loginPanel;
    private javax.swing.JPanel optionsPanel;
    private javax.swing.JPasswordField passwordField;
    private javax.swing.JLabel passwordLabel;
    private javax.swing.JSeparator passwordSeparator;
    private javax.swing.JLabel titleLabel;
    private javax.swing.JLabel titleLogo;
    private javax.swing.JTextField userField;
    private javax.swing.JLabel userLabel;
    private javax.swing.JSeparator userSeparator;
    // End of variables declaration//GEN-END:variables
}
