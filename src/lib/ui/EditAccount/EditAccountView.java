/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lib.ui.EditAccount;

import java.awt.Dimension;
import java.awt.Image;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import lib.models.User;

/**
 *
 * @author user
 */
public class EditAccountView extends javax.swing.JPanel {
    
    /**
     * Creates new form EditAccountView
     */
    public EditAccountView() {
        initComponents();
    }
    
    public void fillInfo(User user){
        jtxtName.setText(user.getName());
        jtxtNumber.setText(Integer.toString(user.getCelNumber()));
        jtxtEmail.setText(user.getEmail());
        jtxtId.setText(Integer.toString(user.getIdCard()));
        jtxtUser.setText(user.getUser());
        jtxtRange.setText(user.getRange());
        jpfPassword.setText(user.getPassword());
    }
    
    public void fillInfoEdit(String nombre,String cedula,String email,String telefono,String rango)
    {
        jtxtName.setText(nombre);
        jtxtNumber.setText(telefono);
        jtxtEmail.setText(email);
        jtxtId.setText(cedula);
        jtxtRange.setText(rango);
        jpfPassword.setText("");
    }
    public JPasswordField getJpfPassword() {
        return jpfPassword;
    }

    public JTextField getJtxtEmail() {
        return jtxtEmail;
    }

    public JTextField getJtxtId() {
        return jtxtId;
    }

    public JTextField getJtxtName() {
        return jtxtName;
    }

    public JTextField getJtxtUser() {
        return jtxtUser;
    }

    public JTextField getJtxtNumber() {
        return jtxtNumber;
    }

    public JButton getBtnSave() {
        return btnSave;
    }

    public JLabel getJlEdit() {
        return jlEdit;
    }

    public JLabel getJlReturn() {
        return jlReturn;
    }

    public JLabel getJlEdit1() {//Añade boton para editar el nombre de usuario y editar distintos usuarios
        return jlEdit1;
    }

    public JButton getBtnrefrescar() {//genera la accion para cargar la nueva informacion
        return btnrefrescar;
    }

    public JTextField getJtxtRange() {//genera el feedback del rango
        return jtxtRange;
    }


    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jlReturn = new javax.swing.JLabel();
        jlTitle = new javax.swing.JLabel();
        jlName = new javax.swing.JLabel();
        jlId = new javax.swing.JLabel();
        jlEmail = new javax.swing.JLabel();
        jlNumber = new javax.swing.JLabel();
        jlRange = new javax.swing.JLabel();
        jlUser = new javax.swing.JLabel();
        jlPassword = new javax.swing.JLabel();
        jtxtName = new javax.swing.JTextField();
        jtxtId = new javax.swing.JTextField();
        jtxtEmail = new javax.swing.JTextField();
        jtxtNumber = new javax.swing.JTextField();
        jtxtRange = new javax.swing.JTextField();
        jtxtUser = new javax.swing.JTextField();
        jpfPassword = new javax.swing.JPasswordField();
        jlUserImage = new javax.swing.JLabel();
        jPanel1 = new javax.swing.JPanel();
        btnSave = new javax.swing.JButton();
        jlEdit = new javax.swing.JLabel();
        jlEdit1 = new javax.swing.JLabel();
        btnrefrescar = new javax.swing.JButton();

        setBackground(new java.awt.Color(255, 255, 255));

        jlReturn.setSize(new Dimension(68,68));
        jlReturn.setMaximumSize(new java.awt.Dimension(68, 68));
        jlReturn.setMinimumSize(new java.awt.Dimension(68, 68));
        jlReturn.setPreferredSize(new java.awt.Dimension(68, 68));
        ImageIcon img2 = new ImageIcon(getClass().getResource("/documentation/Imagenes/Boton de Atras.png"));
        Icon icon2 = new ImageIcon(img2.getImage().getScaledInstance(jlReturn.getWidth(), jlReturn.getHeight(), Image.SCALE_SMOOTH));
        jlReturn.setIcon(icon2);

        jlTitle.setFont(new java.awt.Font("Leelawadee UI", 1, 26)); // NOI18N
        jlTitle.setForeground(new java.awt.Color(79, 84, 110));
        jlTitle.setText("Perfil de usuario");

        jlName.setFont(new java.awt.Font("Leelawadee UI", 0, 22)); // NOI18N
        jlName.setForeground(new java.awt.Color(79, 84, 110));
        jlName.setText("Nombre:");

        jlId.setFont(new java.awt.Font("Leelawadee UI", 0, 22)); // NOI18N
        jlId.setForeground(new java.awt.Color(79, 84, 110));
        jlId.setText("Cedula:");

        jlEmail.setFont(new java.awt.Font("Leelawadee UI", 0, 22)); // NOI18N
        jlEmail.setForeground(new java.awt.Color(79, 84, 110));
        jlEmail.setText("Email:");

        jlNumber.setFont(new java.awt.Font("Leelawadee UI", 0, 22)); // NOI18N
        jlNumber.setForeground(new java.awt.Color(79, 84, 110));
        jlNumber.setText("Teléfono:");

        jlRange.setFont(new java.awt.Font("Leelawadee UI", 0, 22)); // NOI18N
        jlRange.setForeground(new java.awt.Color(79, 84, 110));
        jlRange.setText("Rango:");

        jlUser.setFont(new java.awt.Font("Leelawadee UI", 0, 22)); // NOI18N
        jlUser.setForeground(new java.awt.Color(79, 84, 110));
        jlUser.setText("Usuario:");

        jlPassword.setFont(new java.awt.Font("Leelawadee UI", 0, 22)); // NOI18N
        jlPassword.setForeground(new java.awt.Color(79, 84, 110));
        jlPassword.setText("Contraseña:");

        jtxtName.setFont(new java.awt.Font("Leelawadee UI", 0, 22)); // NOI18N

        jtxtId.setFont(new java.awt.Font("Leelawadee UI", 0, 22)); // NOI18N

        jtxtEmail.setFont(new java.awt.Font("Leelawadee UI", 0, 22)); // NOI18N

        jtxtNumber.setFont(new java.awt.Font("Leelawadee UI", 0, 22)); // NOI18N

        jtxtRange.setEditable(false);
        jtxtRange.setFont(new java.awt.Font("Leelawadee UI", 0, 22)); // NOI18N

        jtxtUser.setEditable(false);
        jtxtUser.setFont(new java.awt.Font("Leelawadee UI", 0, 22)); // NOI18N

        jpfPassword.setEditable(false);
        jpfPassword.setFont(new java.awt.Font("Leelawadee UI", 0, 22)); // NOI18N

        jlUserImage.setSize(new java.awt.Dimension(362,362));
        jlUserImage.setMaximumSize(new java.awt.Dimension(362, 362));
        jlUserImage.setMinimumSize(new java.awt.Dimension(362, 362));
        jlUserImage.setPreferredSize(new java.awt.Dimension(362, 362));
        ImageIcon img4 = new ImageIcon(getClass().getResource("/documentation/Imagenes/Foto usuario.png"));
        Icon icon4 = new ImageIcon(img4.getImage().getScaledInstance(jlUserImage.getWidth(), jlUserImage.getHeight(), Image.SCALE_SMOOTH));
        jlUserImage.setIcon(icon4);

        jPanel1.setBackground(new java.awt.Color(20, 56, 197));
        jPanel1.setToolTipText("");

        btnSave.setFont(new java.awt.Font("Leelawadee UI", 0, 22)); // NOI18N
        btnSave.setForeground(new java.awt.Color(255, 255, 255));
        btnSave.setText("Guardar");
        btnSave.setContentAreaFilled(false);
        btnSave.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSaveActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(btnSave, javax.swing.GroupLayout.DEFAULT_SIZE, 217, Short.MAX_VALUE)
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(btnSave, javax.swing.GroupLayout.DEFAULT_SIZE, 48, Short.MAX_VALUE)
        );

        jlEdit.setSize(new Dimension(35,35));
        jlEdit.setMaximumSize(new java.awt.Dimension(35, 35));
        jlEdit.setMinimumSize(new java.awt.Dimension(35, 35));
        jlEdit.setPreferredSize(new java.awt.Dimension(35, 35));
        ImageIcon img3 = new ImageIcon(getClass().getResource("/documentation/Imagenes/Icono Editar.png"));
        Icon icon3 = new ImageIcon(img3.getImage().getScaledInstance(jlEdit.getWidth(), jlEdit.getHeight(), Image.SCALE_SMOOTH));
        jlEdit.setIcon(icon3);

        jlEdit1.setSize(new Dimension(35,35));
        jlEdit1.setMaximumSize(new java.awt.Dimension(35, 35));
        jlEdit1.setMinimumSize(new java.awt.Dimension(35, 35));
        jlEdit1.setPreferredSize(new java.awt.Dimension(35, 35));
        ImageIcon img5 = new ImageIcon(getClass().getResource("/documentation/Imagenes/Icono Editar.png"));
        Icon icon5 = new ImageIcon(img5.getImage().getScaledInstance(jlEdit.getWidth(), jlEdit.getHeight(), Image.SCALE_SMOOTH));
        jlEdit1.setIcon(icon5);

        btnrefrescar.setBackground(new java.awt.Color(102, 102, 255));
        btnrefrescar.setFont(new java.awt.Font("Leelawadee UI", 1, 11)); // NOI18N
        btnrefrescar.setText("Recargar");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(90, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addComponent(jlTitle)
                        .addGap(441, 441, 441))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addComponent(jlUserImage, javax.swing.GroupLayout.PREFERRED_SIZE, 362, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(68, 68, 68)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jlPassword)
                            .addComponent(jlNumber)
                            .addComponent(jlRange)
                            .addComponent(jlUser)
                            .addComponent(jlName)
                            .addComponent(jlId)
                            .addComponent(jlEmail))
                        .addGap(24, 24, 24)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jtxtRange, javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jtxtNumber, javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jtxtId, javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jtxtName, javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jtxtEmail, javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jtxtUser)
                            .addComponent(jpfPassword, javax.swing.GroupLayout.DEFAULT_SIZE, 309, Short.MAX_VALUE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jlEdit, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jlEdit1, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(48, 48, 48))))
            .addGroup(layout.createSequentialGroup()
                .addGap(25, 25, 25)
                .addComponent(jlReturn, javax.swing.GroupLayout.PREFERRED_SIZE, 68, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(967, Short.MAX_VALUE))
            .addGroup(layout.createSequentialGroup()
                .addGap(162, 162, 162)
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(btnrefrescar, javax.swing.GroupLayout.PREFERRED_SIZE, 86, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(202, 202, 202))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(btnrefrescar, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(22, 22, 22)
                        .addComponent(jlReturn, javax.swing.GroupLayout.PREFERRED_SIZE, 68, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(30, 30, 30)
                        .addComponent(jlTitle)
                        .addGap(65, 65, 65)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jlUserImage, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 362, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addGroup(layout.createSequentialGroup()
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                            .addComponent(jlName)
                                            .addComponent(jtxtName, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                        .addGap(18, 18, 18)
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                            .addComponent(jlId)
                                            .addComponent(jtxtId, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                        .addGap(18, 18, 18)
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                            .addComponent(jlEmail)
                                            .addComponent(jtxtEmail, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                        .addGap(18, 18, 18)
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                            .addComponent(jlNumber)
                                            .addComponent(jtxtNumber, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                        .addGap(18, 18, 18)
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                            .addComponent(jlRange)
                                            .addComponent(jtxtRange, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                        .addGap(18, 18, 18)
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                            .addComponent(jlUser)
                                            .addComponent(jtxtUser, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                    .addComponent(jlEdit1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(18, 18, 18)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                        .addComponent(jlPassword)
                                        .addComponent(jpfPassword, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addComponent(jlEdit, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE))))
                        .addGap(18, 18, Short.MAX_VALUE)
                        .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(67, 67, 67))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void btnSaveActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSaveActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_btnSaveActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnSave;
    private javax.swing.JButton btnrefrescar;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JLabel jlEdit;
    private javax.swing.JLabel jlEdit1;
    private javax.swing.JLabel jlEmail;
    private javax.swing.JLabel jlId;
    private javax.swing.JLabel jlName;
    private javax.swing.JLabel jlNumber;
    private javax.swing.JLabel jlPassword;
    private javax.swing.JLabel jlRange;
    private javax.swing.JLabel jlReturn;
    private javax.swing.JLabel jlTitle;
    private javax.swing.JLabel jlUser;
    private javax.swing.JLabel jlUserImage;
    private javax.swing.JPasswordField jpfPassword;
    private javax.swing.JTextField jtxtEmail;
    private javax.swing.JTextField jtxtId;
    private javax.swing.JTextField jtxtName;
    private javax.swing.JTextField jtxtNumber;
    private javax.swing.JTextField jtxtRange;
    private javax.swing.JTextField jtxtUser;
    // End of variables declaration//GEN-END:variables
}
