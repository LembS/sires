/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Sires;


import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import javax.swing.DefaultListModel;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

/* AUTHOR ADSI-108
*Version del software 1.0
*Fecha 06/10/2016
*/

public class vehiculosES extends javax.swing.JInternalFrame {
    String codigo;
    DefaultTableModel modelo;
    /**
     * Creates new form vehiculosES
     */
    public vehiculosES() {
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

        datos = new javax.swing.JPanel();
        nombre = new javax.swing.JLabel();
        id = new javax.swing.JLabel();
        apellidos = new javax.swing.JLabel();
        rol = new javax.swing.JLabel();
        ejemplo = new javax.swing.JTextField();
        ejemploB = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        vehiculosES = new JTable(){

            public boolean isCellEditable(int rowIndex, int colIndex) {

                return false; //Las celdas no son editables.

            }
        };
        jLabel1 = new javax.swing.JLabel();

        setOpaque(false);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        datos.setOpaque(false);

        nombre.setFont(new java.awt.Font("Comic Sans MS", 1, 14)); // NOI18N
        nombre.setText("Nombre");

        id.setFont(new java.awt.Font("Comic Sans MS", 1, 14)); // NOI18N
        id.setText("Identificación");

        apellidos.setFont(new java.awt.Font("Comic Sans MS", 1, 14)); // NOI18N
        apellidos.setText("Apellidos");

        rol.setFont(new java.awt.Font("Comic Sans MS", 1, 14)); // NOI18N
        rol.setText("Rol");

        ejemploB.setText("ok");
        ejemploB.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ejemploBActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout datosLayout = new javax.swing.GroupLayout(datos);
        datos.setLayout(datosLayout);
        datosLayout.setHorizontalGroup(
            datosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(datosLayout.createSequentialGroup()
                .addComponent(rol)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(datosLayout.createSequentialGroup()
                .addGroup(datosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(apellidos)
                    .addComponent(id)
                    .addComponent(nombre))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 182, Short.MAX_VALUE)
                .addGroup(datosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(ejemplo, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 71, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(ejemploB, javax.swing.GroupLayout.Alignment.TRAILING))
                .addGap(25, 25, 25))
        );
        datosLayout.setVerticalGroup(
            datosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(datosLayout.createSequentialGroup()
                .addGroup(datosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(datosLayout.createSequentialGroup()
                        .addComponent(nombre)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(apellidos)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(id)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, datosLayout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(ejemplo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(ejemploB)
                        .addGap(15, 15, 15)))
                .addComponent(rol)
                .addGap(0, 3, Short.MAX_VALUE))
        );

        getContentPane().add(datos, new org.netbeans.lib.awtextra.AbsoluteConstraints(25, 12, -1, -1));

        jScrollPane1.setOpaque(false);

        vehiculosES.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {},
                {},
                {},
                {}
            },
            new String [] {

            }
        ));
        vehiculosES.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                vehiculosESMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(vehiculosES);

        getContentPane().add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(25, 139, 384, 136));

        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/subPlantillas.png"))); // NOI18N
        getContentPane().add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 420, 300));

        pack();
    }// </editor-fold>//GEN-END:initComponents
    
    void salida(){
        String sql="SELECT * FROM vehiculoES WHERE codigo="+codigo;
        Conect cc = new Conect();
        Connection CC = cc.conexion();
        try {
            Statement sta= CC.createStatement();
            ResultSet res =sta.executeQuery(sql);
            if(res.next()){
                eliminar();
                System.out.println("Exito!!!");
            }
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Error "+ex);
        }
    }
    
    void eliminar(){
         String sql="DELETE FROM vehiculoES WHERE codigo="+codigo;
            Conect cone = new Conect();
            Connection con=cone.conexion();
            try {
                PreparedStatement pst=con.prepareStatement(sql);
                int n=pst.executeUpdate();
                if(n>0){
                    JOptionPane.showMessageDialog(null, "Vehiculo Saliendo");
                }

            } catch (SQLException ex) {
                JOptionPane.showMessageDialog(null, ex);
            }
    }
    private void ejemploBActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ejemploBActionPerformed
        
        String sql="SELECT codigo, identificacion, persona.nombre, apellido, tipo_id.descripcion, rol.nombre "
               + " FROM persona "
               + " INNER JOIN tipo_id ON tipo_id.cod_tipo_id=persona.tipoID "
               + " INNER JOIN rol ON rol.id_rol=persona.id_rol"
               + " WHERE codigo = "+ejemplo.getText().toString();
        Conect cc = new Conect();
        Connection CC = cc.conexion();
        try {
            Statement sta= CC.createStatement();
            ResultSet res =sta.executeQuery(sql);
            if(res.next()){
                codigo=res.getString("codigo").toString();
                nombre.setText(res.getString("persona.nombre"));
                apellidos.setText(res.getString("apellido").toString());
                id.setText(res.getString("tipo_id.descripcion").toString()+" "+res.getString("identificacion").toString());
                rol.setText(res.getString("rol.nombre").toString());

                System.out.println("Exito");
            }
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Error "+ex);
        }
        
        salida();
        
        String [] titulos={"Identificador", "Tipo", "Codigo"};
        String [] registros=new String[3];
        sql="SELECT placa, desc_tipo_vehi, id_vehiculo FROM vehiculo"
                + " INNER JOIN tipo_vehi ON tipo_vehi.cod_tipo_vehi=vehiculo.tipo_veh "
                + "WHERE vehiculo.codigo="+codigo;
        modelo=new DefaultTableModel(null,titulos);
        Conect cone = new Conect();
        Connection con=cone.conexion();
        
        try {
            Statement st=con.createStatement();
            ResultSet rs=st.executeQuery(sql);
            while(rs.next()){
                registros[0]=rs.getString("placa");
                registros[1]=rs.getString("desc_tipo_vehi");
                registros[2]=rs.getString("id_vehiculo");
                modelo.addRow(registros);
            }
            vehiculosES.setModel(modelo);
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, ex);
        }
    }//GEN-LAST:event_ejemploBActionPerformed

    private void vehiculosESMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_vehiculosESMouseClicked
        if (evt.getClickCount() == 2) {
            int row=vehiculosES.getSelectedRow();
            String codigoOBJ=vehiculosES.getValueAt(row,2).toString();
           
            String sql="INSERT INTO vehiculoES (id_vehiculo, codigo) "
                    + "VALUES("+codigoOBJ+", "+codigo+")";
            Conect cone = new Conect();
            Connection con=cone.conexion();
            try {
                PreparedStatement pst=con.prepareStatement(sql);
                int n=pst.executeUpdate();
                if(n>0){
                    JOptionPane.showMessageDialog(null, "Registro Guardado con Exito");
                }

            } catch (SQLException ex) {
                JOptionPane.showMessageDialog(null, ex);
            }
                

        }
    }//GEN-LAST:event_vehiculosESMouseClicked


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel apellidos;
    private javax.swing.JPanel datos;
    private javax.swing.JTextField ejemplo;
    private javax.swing.JButton ejemploB;
    private javax.swing.JLabel id;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JLabel nombre;
    private javax.swing.JLabel rol;
    private javax.swing.JTable vehiculosES;
    // End of variables declaration//GEN-END:variables
}