/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Sires;

import Sires.Conect;
import java.awt.Component;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableCellRenderer;
import javax.swing.table.TableColumnModel;

/**
 *
 * @author dell1
 */
public class Objetos extends javax.swing.JInternalFrame {

DefaultTableModel model;
    /**
     * Creates new form PuntoEmergencia
     */
    public Objetos() {
        initComponents();
        cargar("");
    }
void cargar(String id){
        String [] titulos={"Serial","Descripcion","Modelo","Tipo Objeto", "Tipo de Estado"};
        String [] registros=new String[5];
        String sql="SELECT serial, descripcion, modelo, tipo_obj, id_estado \n FROM objetos \n"
                + "WHERE serial \n LIKE '%"+id+"%'";
        
        model=new DefaultTableModel(null,titulos);
        
        Conect conectar=new Conect();
        Connection Conect=conectar.conexion();
        try{
            Statement st=Conect.createStatement();
            ResultSet rs=st.executeQuery(sql);
            
            while(rs.next()){
                registros[0]=rs.getString("serial");
                registros[1]=rs.getString("descripcion");
                registros[2]=rs.getString("modelo");
                registros[3]=rs.getString("tipo_obj");
                registros[4]=rs.getString("id_estado");
     
                model.addRow(registros);
            }
            tabla.setModel(model);
            resizeColumnWidth(tabla);
        }catch (SQLException ex){
            JOptionPane.showMessageDialog(null, ex);
        }
    }
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        menu = new javax.swing.JPopupMenu();
        modificar = new javax.swing.JMenuItem();
        eliminar = new javax.swing.JMenuItem();
        modificarObj = new javax.swing.JFrame();
        jPanel4 = new javax.swing.JPanel();
        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jTabbedPane2 = new javax.swing.JTabbedPane();
        jPanel3 = new javax.swing.JPanel();
        mod = new javax.swing.JTextField();
        desc = new javax.swing.JTextField();
        ser = new javax.swing.JTextField();
        obj = new javax.swing.JComboBox<>();
        jLabel4 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        guardar = new javax.swing.JButton();
        jPanel2 = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        buscar = new javax.swing.JTextField();
        jScrollPane2 = new javax.swing.JScrollPane();
        jScrollPane1 = new javax.swing.JScrollPane();
        tabla = new javax.swing.JTable();

        modificar.setText("Modificar");
        modificar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                modificarActionPerformed(evt);
            }
        });
        menu.add(modificar);

        eliminar.setText("Eliminar");
        menu.add(eliminar);

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 380, Short.MAX_VALUE)
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 278, Short.MAX_VALUE)
        );

        javax.swing.GroupLayout modificarObjLayout = new javax.swing.GroupLayout(modificarObj.getContentPane());
        modificarObj.getContentPane().setLayout(modificarObjLayout);
        modificarObjLayout.setHorizontalGroup(
            modificarObjLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(modificarObjLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );
        modificarObjLayout.setVerticalGroup(
            modificarObjLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(modificarObjLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );

        setClosable(true);
        setIconifiable(true);
        setMaximizable(true);
        setResizable(true);
        setAutoscrolls(true);
        setDoubleBuffered(true);
        setFocusTraversalPolicyProvider(true);
        try {
            setSelected(true);
        } catch (java.beans.PropertyVetoException e1) {
            e1.printStackTrace();
        }
        setVisible(true);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel1.setBackground(new java.awt.Color(0, 153, 92));
        jPanel1.setForeground(new java.awt.Color(0, 153, 92));
        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel1.setFont(new java.awt.Font("Comic Sans MS", 1, 36)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setText("OBJETOS");
        jPanel1.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(281, 0, 238, 80));

        getContentPane().add(jPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 740, 80));

        jPanel3.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        mod.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                modActionPerformed(evt);
            }
        });
        jPanel3.add(mod, new org.netbeans.lib.awtextra.AbsoluteConstraints(230, 150, 310, 30));

        desc.setFocusCycleRoot(true);
        desc.setFocusTraversalPolicyProvider(true);
        desc.setInheritsPopupMenu(true);
        desc.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                descActionPerformed(evt);
            }
        });
        jPanel3.add(desc, new org.netbeans.lib.awtextra.AbsoluteConstraints(230, 100, 310, 30));

        ser.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                serActionPerformed(evt);
            }
        });
        jPanel3.add(ser, new org.netbeans.lib.awtextra.AbsoluteConstraints(230, 50, 310, 30));

        obj.setFont(new java.awt.Font("Comic Sans MS", 1, 14)); // NOI18N
        obj.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Ordenador", "Elemento", "Accesorios", "Otro." }));
        obj.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                objActionPerformed(evt);
            }
        });
        jPanel3.add(obj, new org.netbeans.lib.awtextra.AbsoluteConstraints(230, 200, 210, 30));

        jLabel4.setFont(new java.awt.Font("Comic Sans MS", 1, 14)); // NOI18N
        jLabel4.setText("SERIAL:  ");
        jPanel3.add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(100, 50, 80, 20));

        jLabel3.setFont(new java.awt.Font("Comic Sans MS", 1, 14)); // NOI18N
        jLabel3.setText("DESCRIPCIÓN: ");
        jPanel3.add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(100, 100, 120, 20));

        jLabel5.setFont(new java.awt.Font("Comic Sans MS", 1, 14)); // NOI18N
        jLabel5.setText("MODELO:  ");
        jPanel3.add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(100, 150, 90, 20));

        jLabel7.setFont(new java.awt.Font("Comic Sans MS", 1, 14)); // NOI18N
        jLabel7.setText("TIPO OBJETO:  ");
        jPanel3.add(jLabel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(100, 201, 130, 30));

        guardar.setFont(new java.awt.Font("Comic Sans MS", 1, 14)); // NOI18N
        guardar.setText("GUARDAR");
        guardar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                guardarActionPerformed(evt);
            }
        });
        jPanel3.add(guardar, new org.netbeans.lib.awtextra.AbsoluteConstraints(320, 270, 100, 50));

        jTabbedPane2.addTab("Registrar Objeto", jPanel3);

        jPanel2.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel2.setFont(new java.awt.Font("Comic Sans MS", 1, 14)); // NOI18N
        jLabel2.setText("Buscar:");
        jPanel2.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(480, 20, -1, 20));

        buscar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                buscarActionPerformed(evt);
            }
        });
        buscar.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                buscarKeyReleased(evt);
            }
        });
        jPanel2.add(buscar, new org.netbeans.lib.awtextra.AbsoluteConstraints(540, 20, 140, -1));

        tabla.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {},
                {},
                {},
                {}
            },
            new String [] {

            }
        ));
        tabla.setComponentPopupMenu(menu);
        jScrollPane1.setViewportView(tabla);

        jScrollPane2.setViewportView(jScrollPane1);

        jPanel2.add(jScrollPane2, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 60, 740, 270));

        jTabbedPane2.addTab("Consultar Objeto", jPanel2);

        getContentPane().add(jTabbedPane2, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 80, 750, 370));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void buscarKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_buscarKeyReleased
        // TODO add your handling code here:
        cargar(buscar.getText());
    }//GEN-LAST:event_buscarKeyReleased

    private void buscarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_buscarActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_buscarActionPerformed

    private void guardarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_guardarActionPerformed
        if (JOptionPane.showConfirmDialog(rootPane, "Desea Registrar Nuevo Objeto? ",
            "Nuevo Registro...", JOptionPane.YES_NO_OPTION) == JOptionPane.YES_OPTION){

        Conect conectar=new Conect();
        Connection cn=conectar.conexion();

        String seri, descri, model, tipo_obj="", uno="1", id_estado="";
        seri=ser.getText();
        descri=desc.getText();
        model=mod.getText();

        switch(obj.getSelectedItem().toString()){
            case "Ordenador":
            tipo_obj="1";
            break;
            case "Elemento":
            tipo_obj="2";
            break;
            case "Accesorios":
            tipo_obj="3";
        }
        
 

        String sql="INSERT INTO objetos(descripcion, serial, modelo, codigo_persona, tipo_obj, id_estado) VALUES (?,?,?,?,?,1)";
        try{
            PreparedStatement pst=cn.prepareStatement(sql);
            pst.setString(1,descri);
            pst.setString(2,seri);
            pst.setString(3,model);
            pst.setString(4,uno);
            pst.setString(5,tipo_obj);
         

            int n=pst.executeUpdate();

            if (n>0){
                JOptionPane.showMessageDialog(null,"Registro ingresado con Exito");
                cargar("");

            }

        }catch (SQLException ex) {
            Logger.getLogger(Objetos.class.getName()).log(Level.SEVERE,null, ex);
        }
        }        // TODO add your handling code here:
    }//GEN-LAST:event_guardarActionPerformed

    public void resizeColumnWidth(JTable table) {
        final TableColumnModel columnModel = table.getColumnModel();
        for (int column = 0; column < table.getColumnCount(); column++) {
            int width = 50; // Min width
            for (int row = 0; row < table.getRowCount(); row++) {
                TableCellRenderer renderer = table.getCellRenderer(row, column);
                Component comp = table.prepareRenderer(renderer, row, column);
                width = Math.max(comp.getPreferredSize().width +1 , width);
            }
            columnModel.getColumn(column).setPreferredWidth(width);
        }
    }
    private void objActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_objActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_objActionPerformed

    private void serActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_serActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_serActionPerformed

    private void descActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_descActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_descActionPerformed

    private void modActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_modActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_modActionPerformed

    private void modificarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_modificarActionPerformed
            // TODO add your handling code here:
    }//GEN-LAST:event_modificarActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTextField buscar;
    private javax.swing.JTextField desc;
    private javax.swing.JMenuItem eliminar;
    private javax.swing.JButton guardar;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JTabbedPane jTabbedPane2;
    private javax.swing.JPopupMenu menu;
    private javax.swing.JTextField mod;
    private javax.swing.JMenuItem modificar;
    private javax.swing.JFrame modificarObj;
    private javax.swing.JComboBox<String> obj;
    private javax.swing.JTextField ser;
    private javax.swing.JTable tabla;
    // End of variables declaration//GEN-END:variables
}
