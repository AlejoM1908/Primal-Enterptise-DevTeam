/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package lib.ui.AssetRegistration;

import java.awt.Dimension;
import java.awt.Image;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JTextArea;
import javax.swing.JTextField;

/**
 *
 * @author user
 */
public class AssetRegistrationView extends javax.swing.JPanel {

    /** Creates new form AssetRegistrationView */
    public AssetRegistrationView() {
        initComponents();
    }

    public JComboBox<String> getJcbStatus() {
        return jcbStatus;
    }

    public JButton getBtnRegister() {
        return btnRegister;
    }

    public JLabel getJlReturn() {
        return jlReturn;
    }

    
    
    public JComboBox<String> getJcbIcon() {
        return jcbIcon;
    }

    public JTextField getJtxtBrand() {
        return jtxtBrand;
    }

    public JTextField getJtxtName() {
        return jtxtName;
    }

    public JTextField getJtxtNit() {
        return jtxtNit;
    }

    public JTextField getJtxtQuantity() {
        return jtxtQuantity;
    }

    public JTextField getJtxtTicket() {
        return jtxtTicket;
    }

    public JTextArea getJtxtaDesc() {
        return jtxtaDesc;
    }
    
    

    /** This method is called from within the constructor to
     * initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is
     * always regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jlReturn = new javax.swing.JLabel();
        jlTitle = new javax.swing.JLabel();
        jlName = new javax.swing.JLabel();
        jlBrand = new javax.swing.JLabel();
        jlStatus = new javax.swing.JLabel();
        jlNit = new javax.swing.JLabel();
        jlQuantity = new javax.swing.JLabel();
        jlIdTicket = new javax.swing.JLabel();
        jlDesc = new javax.swing.JLabel();
        jlIcon = new javax.swing.JLabel();
        jPanel1 = new javax.swing.JPanel();
        btnRegister = new javax.swing.JButton();
        jtxtName = new javax.swing.JTextField();
        jtxtBrand = new javax.swing.JTextField();
        jtxtNit = new javax.swing.JTextField();
        jtxtQuantity = new javax.swing.JTextField();
        jcbStatus = new javax.swing.JComboBox<>();
        jtxtTicket = new javax.swing.JTextField();
        jScrollPane1 = new javax.swing.JScrollPane();
        jtxtaDesc = new javax.swing.JTextArea();
        jcbIcon = new javax.swing.JComboBox<>();

        setBackground(new java.awt.Color(255, 255, 255));

        jlReturn.setSize(new Dimension(68,68));
        jlReturn.setMaximumSize(new java.awt.Dimension(68, 68));
        jlReturn.setMinimumSize(new java.awt.Dimension(68, 68));
        jlReturn.setName(""); // NOI18N
        jlReturn.setPreferredSize(new java.awt.Dimension(68, 68));
        ImageIcon img2 = new ImageIcon(getClass().getResource("/documentation/Imagenes/Boton de Atras.png"));
        Icon icon2 = new ImageIcon(img2.getImage().getScaledInstance(jlReturn.getWidth(), jlReturn.getHeight(), Image.SCALE_SMOOTH));
        jlReturn.setIcon(icon2);

        jlTitle.setFont(new java.awt.Font("Leelawadee UI", 1, 26)); // NOI18N
        jlTitle.setForeground(new java.awt.Color(79, 84, 110));
        jlTitle.setText("Registro de activo");

        jlName.setFont(new java.awt.Font("Leelawadee UI", 0, 22)); // NOI18N
        jlName.setForeground(new java.awt.Color(79, 84, 110));
        jlName.setText("Nombre:");

        jlBrand.setFont(new java.awt.Font("Leelawadee UI", 0, 22)); // NOI18N
        jlBrand.setForeground(new java.awt.Color(79, 84, 110));
        jlBrand.setText("Marca:");

        jlStatus.setFont(new java.awt.Font("Leelawadee UI", 0, 22)); // NOI18N
        jlStatus.setForeground(new java.awt.Color(79, 84, 110));
        jlStatus.setText("Estado:");

        jlNit.setFont(new java.awt.Font("Leelawadee UI", 0, 22)); // NOI18N
        jlNit.setForeground(new java.awt.Color(79, 84, 110));
        jlNit.setText("NIT Proveedor:");

        jlQuantity.setFont(new java.awt.Font("Leelawadee UI", 0, 22)); // NOI18N
        jlQuantity.setForeground(new java.awt.Color(79, 84, 110));
        jlQuantity.setText("Cantidad:");

        jlIdTicket.setFont(new java.awt.Font("Leelawadee UI", 0, 22)); // NOI18N
        jlIdTicket.setForeground(new java.awt.Color(79, 84, 110));
        jlIdTicket.setText("ID Factura:");

        jlDesc.setFont(new java.awt.Font("Leelawadee UI", 0, 22)); // NOI18N
        jlDesc.setForeground(new java.awt.Color(79, 84, 110));
        jlDesc.setText("Descripción:");

        jlIcon.setFont(new java.awt.Font("Leelawadee UI", 0, 22)); // NOI18N
        jlIcon.setForeground(new java.awt.Color(79, 84, 110));
        jlIcon.setText("Icono:");

        jPanel1.setBackground(new java.awt.Color(20, 56, 197));

        btnRegister.setFont(new java.awt.Font("Leelawadee UI", 0, 22)); // NOI18N
        btnRegister.setForeground(new java.awt.Color(255, 255, 255));
        btnRegister.setText("Registrar");
        btnRegister.setContentAreaFilled(false);
        btnRegister.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnRegisterActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(btnRegister, javax.swing.GroupLayout.DEFAULT_SIZE, 217, Short.MAX_VALUE)
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(btnRegister, javax.swing.GroupLayout.DEFAULT_SIZE, 48, Short.MAX_VALUE)
        );

        jtxtName.setFont(new java.awt.Font("Leelawadee UI", 0, 22)); // NOI18N

        jtxtBrand.setFont(new java.awt.Font("Leelawadee UI", 0, 22)); // NOI18N

        jtxtNit.setFont(new java.awt.Font("Leelawadee UI", 0, 22)); // NOI18N

        jtxtQuantity.setFont(new java.awt.Font("Leelawadee UI", 0, 22)); // NOI18N

        jcbStatus.setFont(new java.awt.Font("Leelawadee UI", 0, 22)); // NOI18N
        jcbStatus.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Nuevo", "Usado" }));

        jtxtTicket.setFont(new java.awt.Font("Leelawadee UI", 0, 22)); // NOI18N

        jtxtaDesc.setColumns(20);
        jtxtaDesc.setRows(5);
        jScrollPane1.setViewportView(jtxtaDesc);

        jcbIcon.setFont(new java.awt.Font("Leelawadee UI", 0, 22)); // NOI18N

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(143, 143, 143)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jlName)
                            .addComponent(jlBrand)
                            .addComponent(jlStatus))
                        .addGap(81, 81, 81)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jtxtName)
                            .addComponent(jtxtBrand)
                            .addComponent(jcbStatus, 0, 272, Short.MAX_VALUE)))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jlQuantity, javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jlNit, javax.swing.GroupLayout.Alignment.LEADING))
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jtxtNit, javax.swing.GroupLayout.PREFERRED_SIZE, 272, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jtxtQuantity, javax.swing.GroupLayout.PREFERRED_SIZE, 272, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addGap(61, 61, 61)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jlDesc)
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jlIcon)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(jcbIcon, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                            .addComponent(jScrollPane1, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 403, Short.MAX_VALUE)
                            .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                                .addComponent(jlIdTicket)
                                .addGap(29, 29, 29)
                                .addComponent(jtxtTicket)))
                        .addGap(39, 39, 39))))
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jlReturn, javax.swing.GroupLayout.PREFERRED_SIZE, 68, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(368, 368, 368)
                        .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(357, 357, 357)
                        .addComponent(jlTitle)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jlReturn, javax.swing.GroupLayout.PREFERRED_SIZE, 68, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(70, 70, 70))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addComponent(jlTitle)
                        .addGap(46, 46, 46)))
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jlName)
                    .addComponent(jlIdTicket)
                    .addComponent(jtxtName, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jtxtTicket, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(48, 48, 48)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jlBrand)
                    .addComponent(jlDesc)
                    .addComponent(jtxtBrand, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(51, 51, 51)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jlStatus)
                            .addComponent(jcbStatus, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(51, 51, 51)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jlNit)
                            .addComponent(jtxtNit, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(18, 18, 18)
                        .addComponent(jScrollPane1)))
                .addGap(48, 48, 48)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jlQuantity)
                    .addComponent(jtxtQuantity, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jlIcon)
                    .addComponent(jcbIcon, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 78, Short.MAX_VALUE)
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(74, 74, 74))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void btnRegisterActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnRegisterActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_btnRegisterActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnRegister;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JComboBox<String> jcbIcon;
    private javax.swing.JComboBox<String> jcbStatus;
    private javax.swing.JLabel jlBrand;
    private javax.swing.JLabel jlDesc;
    private javax.swing.JLabel jlIcon;
    private javax.swing.JLabel jlIdTicket;
    private javax.swing.JLabel jlName;
    private javax.swing.JLabel jlNit;
    private javax.swing.JLabel jlQuantity;
    private javax.swing.JLabel jlReturn;
    private javax.swing.JLabel jlStatus;
    private javax.swing.JLabel jlTitle;
    private javax.swing.JTextField jtxtBrand;
    private javax.swing.JTextField jtxtName;
    private javax.swing.JTextField jtxtNit;
    private javax.swing.JTextField jtxtQuantity;
    private javax.swing.JTextField jtxtTicket;
    private javax.swing.JTextArea jtxtaDesc;
    // End of variables declaration//GEN-END:variables

}