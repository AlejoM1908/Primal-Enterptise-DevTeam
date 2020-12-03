/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lib.ui.userAdministrationMenuView;

import java.awt.Dimension;
import java.awt.Image;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JLabel;

/**
 *
 * @author rodri
 */
public class AdministrationMenuView extends javax.swing.JPanel {

    public AdministrationMenuView() {
        initComponents();
        
        
        this.repaint();
    }
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        userAdministrationTittle = new javax.swing.JLabel();
        userAdministrationTittle1 = new javax.swing.JLabel();
        userAdministrationTittle2 = new javax.swing.JLabel();
        userAdministrationTittle3 = new javax.swing.JLabel();
        addUserslb = new javax.swing.JLabel();
        usersListlb = new javax.swing.JLabel();
        rolesCreationlb = new javax.swing.JLabel();
        jlSupplierRegistration = new javax.swing.JLabel();
        userAdministrationTittle4 = new javax.swing.JLabel();

        setBackground(new java.awt.Color(255, 255, 255));
        setPreferredSize(new java.awt.Dimension(1060, 708));

        userAdministrationTittle.setBackground(new java.awt.Color(79, 84, 110));
        userAdministrationTittle.setFont(new java.awt.Font("Leelawadee UI", 1, 18)); // NOI18N
        userAdministrationTittle.setForeground(new java.awt.Color(79, 84, 110));
        userAdministrationTittle.setText("Lista de Usuarios");

        userAdministrationTittle1.setBackground(new java.awt.Color(79, 84, 110));
        userAdministrationTittle1.setFont(new java.awt.Font("Leelawadee UI", 1, 36)); // NOI18N
        userAdministrationTittle1.setForeground(new java.awt.Color(79, 84, 110));
        userAdministrationTittle1.setText("Administración de Usuarios");

        userAdministrationTittle2.setBackground(new java.awt.Color(79, 84, 110));
        userAdministrationTittle2.setFont(new java.awt.Font("Leelawadee UI", 1, 18)); // NOI18N
        userAdministrationTittle2.setForeground(new java.awt.Color(79, 84, 110));
        userAdministrationTittle2.setText("Creación de Roles");

        userAdministrationTittle3.setBackground(new java.awt.Color(79, 84, 110));
        userAdministrationTittle3.setFont(new java.awt.Font("Leelawadee UI", 1, 18)); // NOI18N
        userAdministrationTittle3.setForeground(new java.awt.Color(79, 84, 110));
        userAdministrationTittle3.setText("Registro de Usuarios");

        addUserslb.setSize(new Dimension(155,165));
        addUserslb.setText("jLabel1");
        addUserslb.setMaximumSize(new java.awt.Dimension(155, 165));
        addUserslb.setMinimumSize(new java.awt.Dimension(155, 165));
        addUserslb.setPreferredSize(new java.awt.Dimension(155, 165));
        ImageIcon addUsers = new ImageIcon(getClass().getResource("/documentation/Images/Agregar Usuarios.png"));
        Icon fondo = new ImageIcon(addUsers.getImage().getScaledInstance(addUserslb.getWidth(),addUserslb.getHeight(),Image.SCALE_SMOOTH));
        addUserslb.setIcon(fondo);

        usersListlb.setSize(new Dimension(155,165));
        usersListlb.setForeground(new java.awt.Color(79, 84, 110));
        usersListlb.setText("jLabel1");
        usersListlb.setMaximumSize(new java.awt.Dimension(155, 165));
        usersListlb.setMinimumSize(new java.awt.Dimension(155, 165));
        ImageIcon usersList = new ImageIcon(getClass().getResource("/documentation/Images/LIsta de Usuarios.png"));
        Icon fondo1 = new ImageIcon(usersList.getImage().getScaledInstance(usersListlb.getWidth(),usersListlb.getHeight(),Image.SCALE_SMOOTH));
        usersListlb.setIcon(fondo1);
        usersListlb.setPreferredSize(new java.awt.Dimension(155, 165));

        rolesCreationlb.setSize(new Dimension(155,165));
        rolesCreationlb.setText("jLabel1");
        rolesCreationlb.setMaximumSize(new java.awt.Dimension(155, 165));
        rolesCreationlb.setMinimumSize(new java.awt.Dimension(155, 165));
        ImageIcon addRoles = new ImageIcon(getClass().getResource("/documentation/Images/Roles.png"));
        Icon fondo2 = new ImageIcon(addRoles.getImage().getScaledInstance(rolesCreationlb.getWidth(),rolesCreationlb.getHeight(),Image.SCALE_SMOOTH));
        rolesCreationlb.setIcon(fondo2);
        rolesCreationlb.setPreferredSize(new java.awt.Dimension(155, 165));

        jlSupplierRegistration.setSize(new Dimension(155,165));
        jlSupplierRegistration.setText("jLabel1");
        jlSupplierRegistration.setMaximumSize(new java.awt.Dimension(155, 165));
        jlSupplierRegistration.setMinimumSize(new java.awt.Dimension(155, 165));
        jlSupplierRegistration.setPreferredSize(new java.awt.Dimension(155, 165));
        ImageIcon img2 = new ImageIcon(getClass().getResource("/documentation/Imagenes/Boton Registro de Proveedor.png"));
        Icon icon2 = new ImageIcon(img2.getImage().getScaledInstance(jlSupplierRegistration.getWidth(), jlSupplierRegistration.getHeight(), Image.SCALE_SMOOTH));
        jlSupplierRegistration.setIcon(icon2);

        userAdministrationTittle4.setBackground(new java.awt.Color(79, 84, 110));
        userAdministrationTittle4.setFont(new java.awt.Font("Leelawadee UI", 1, 18)); // NOI18N
        userAdministrationTittle4.setForeground(new java.awt.Color(79, 84, 110));
        userAdministrationTittle4.setText("Registro de proveedores");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(userAdministrationTittle1)
                .addGap(289, 289, 289))
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(264, 264, 264)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                .addComponent(addUserslb, javax.swing.GroupLayout.PREFERRED_SIZE, 155, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(194, 194, 194))
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(userAdministrationTittle3)
                                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                        .addComponent(jlSupplierRegistration, javax.swing.GroupLayout.PREFERRED_SIZE, 153, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(14, 14, 14)))
                                .addGap(184, 184, 184))))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(userAdministrationTittle4)
                        .addGap(165, 165, 165)))
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                        .addComponent(rolesCreationlb, javax.swing.GroupLayout.PREFERRED_SIZE, 153, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(userAdministrationTittle2))
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                        .addComponent(userAdministrationTittle, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(usersListlb, javax.swing.GroupLayout.PREFERRED_SIZE, 143, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(284, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(41, 41, 41)
                .addComponent(userAdministrationTittle1, javax.swing.GroupLayout.PREFERRED_SIZE, 69, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(60, 60, 60)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(usersListlb, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(userAdministrationTittle))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(2, 2, 2)
                        .addComponent(addUserslb, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(userAdministrationTittle3)))
                .addGap(40, 40, 40)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(rolesCreationlb, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jlSupplierRegistration, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(userAdministrationTittle2))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(171, 171, 171)
                        .addComponent(userAdministrationTittle4)))
                .addContainerGap(92, Short.MAX_VALUE))
        );
    }// </editor-fold>//GEN-END:initComponents


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel addUserslb;
    private javax.swing.JLabel jlSupplierRegistration;
    private javax.swing.JLabel rolesCreationlb;
    private javax.swing.JLabel userAdministrationTittle;
    private javax.swing.JLabel userAdministrationTittle1;
    private javax.swing.JLabel userAdministrationTittle2;
    private javax.swing.JLabel userAdministrationTittle3;
    private javax.swing.JLabel userAdministrationTittle4;
    private javax.swing.JLabel usersListlb;
    // End of variables declaration//GEN-END:variables

    public javax.swing.JLabel getAddUserslb() {
        return addUserslb;
    }

    public void setAddUserslb(javax.swing.JLabel addUserslb) {
        this.addUserslb = addUserslb;
    }

    public javax.swing.JLabel getRolesCreationlb() {
        return rolesCreationlb;
    }

    public void setRolesCreationlb(javax.swing.JLabel rolesCreationlb) {
        this.rolesCreationlb = rolesCreationlb;
    }

    public javax.swing.JLabel getUsersListlb() {
        return usersListlb;
    }

    public void setUsersListlb(javax.swing.JLabel usersListlb) {
        this.usersListlb = usersListlb;
    }
    
    public javax.swing.JLabel getJlSupplier(){
        return jlSupplierRegistration;
    }
}
