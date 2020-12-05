/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lib.ui.ProductionList;

import java.awt.Dimension;
import java.awt.Image;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JTable;

/**
 *
 * @author rodri
 */
public class ProductionListView extends javax.swing.JPanel {

    /**
     * Creates new form ProductionListView
     */
    public ProductionListView() {
        initComponents();
    }

    public JLabel getJlDetailProduction() {
        return jlDetailProduction;
    }

    public JTable getJtProductions() {
        return jtProductions;
    }

    public JLabel getJlReturn() {
        return jlReturn;
    }




  
    
    
    
    

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jlTitle = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        jtProductions = new javax.swing.JTable();
        jlDetailProduction = new javax.swing.JLabel();
        jlReturn = new javax.swing.JLabel();

        setBackground(new java.awt.Color(255, 255, 255));
        setPreferredSize(new java.awt.Dimension(1085, 728));

        jlTitle.setFont(new java.awt.Font("Leelawadee UI", 1, 26)); // NOI18N
        jlTitle.setForeground(new java.awt.Color(79, 84, 110));
        jlTitle.setText("Lista de Producciones");

        jtProductions.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "ID Produccion", "Estado", "Tipo"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.Integer.class, java.lang.String.class, java.lang.String.class
            };
            boolean[] canEdit = new boolean [] {
                false, false, false
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jScrollPane1.setViewportView(jtProductions);

        jlDetailProduction.setSize(new Dimension(68,68));
        jlDetailProduction.setMaximumSize(new java.awt.Dimension(68, 68));
        jlDetailProduction.setMinimumSize(new java.awt.Dimension(68, 68));
        jlDetailProduction.setPreferredSize(new java.awt.Dimension(68, 68));
        ImageIcon img = new ImageIcon(getClass().getResource("/documentation/Imagenes/Icono Editar.png"));
        Icon icon = new ImageIcon(img.getImage().getScaledInstance(jlDetailProduction.getWidth(), jlDetailProduction.getHeight(), Image.SCALE_SMOOTH));
        jlDetailProduction.setIcon(icon);

        jlReturn.setSize(new Dimension(68,68));
        jlReturn.setMaximumSize(new java.awt.Dimension(68, 68));
        jlReturn.setMinimumSize(new java.awt.Dimension(68, 68));
        jlReturn.setPreferredSize(new java.awt.Dimension(68, 68));
        ImageIcon img2 = new ImageIcon(getClass().getResource("/documentation/Imagenes/Boton de Atras.png"));
        Icon icon2 = new ImageIcon(img2.getImage().getScaledInstance(jlReturn.getWidth(), jlReturn.getHeight(), Image.SCALE_SMOOTH));
        jlReturn.setIcon(icon2);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(275, Short.MAX_VALUE)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 559, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(80, 80, 80)
                .addComponent(jlDetailProduction, javax.swing.GroupLayout.PREFERRED_SIZE, 68, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(103, 103, 103))
            .addGroup(layout.createSequentialGroup()
                .addGap(29, 29, 29)
                .addComponent(jlReturn, javax.swing.GroupLayout.PREFERRED_SIZE, 68, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(303, 303, 303)
                .addComponent(jlTitle)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(51, 51, 51)
                        .addComponent(jlTitle)
                        .addGap(164, 164, 164)
                        .addComponent(jlDetailProduction, javax.swing.GroupLayout.PREFERRED_SIZE, 68, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(28, 28, 28)
                        .addComponent(jlReturn, javax.swing.GroupLayout.PREFERRED_SIZE, 68, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(16, 16, 16)
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 499, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(117, Short.MAX_VALUE))
        );
    }// </editor-fold>//GEN-END:initComponents


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JLabel jlDetailProduction;
    private javax.swing.JLabel jlReturn;
    private javax.swing.JLabel jlTitle;
    private javax.swing.JTable jtProductions;
    // End of variables declaration//GEN-END:variables
}