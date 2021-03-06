/**
 * @author ADSI-108
 * 
 * @version SIRES 1.0
 * 
 * Fecha 10/06/2016
 */
package Sires;

import java.awt.HeadlessException;
import java.awt.Image;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.ImageIcon;
import javax.swing.JOptionPane;
//import javax.swing.JPanel;
import javax.swing.table.DefaultTableModel;

public class Persona extends javax.swing.JInternalFrame {
    DefaultTableModel modelo;
    Statement sent;
    public Persona() {
        initComponents();
        inhabilitar();
        registros("");
        imagen();
    }
    void imagen(){
        ImageIcon imagen = new ImageIcon(getClass().getResource("../imagenes/subPlantillas2.png"));
        Image conversion =imagen.getImage();
        Image tamaño =conversion.getScaledInstance(800,350, Image.SCALE_SMOOTH);
        ImageIcon fin=new ImageIcon(tamaño);
        fondo.setIcon(fin);
        fondo2.setIcon(fin);
        fondo3.setIcon(fin);
    }
    void modificarPersona(){
        buscar.setText("Ingrese Numero de Identificacion");
        String identificaciones, nombre, apellido, telefonos, correos, tId="null", idCentros="null", idRoles="null", claves, idEstado=null;
        identificaciones=identificacion.getText();
        nombre=nombres.getText();
        apellido=apellidos.getText();
        telefonos=telefono.getText();
        correos=correo.getText();
        
        switch(tipoId.getSelectedItem().toString()){
            case "Tarjeta de Identidad":
                tId="1";
            break;
            case "Cedula de Ciudadanía":
                tId="2";
            break;
            case "Cedula de Extranjeria":
                tId="3";
            break;
            case "Seleccione...":
                tId="4";
        }
        switch(idCentro.getSelectedItem().toString()){
            case "CEAI":
                idCentros="1";
            break;
            case "CDTI":
                idCentros="2";
            break;
            case "ASTIN":
                idCentros="3";
            break;
            case "CGTS":
                idCentros="4";
            break;
            case "Seleccione...":
                idCentros="5";
        }
        switch(idRol.getSelectedItem().toString()){
            case "Funcionario":
                idRoles="1";
            break;
            case "Aprendiz":
                idRoles="2";
            break;
            case "Operario":
                idRoles="3";
            break;
            case "Visitante":
                idRoles="4";
            break;
            case "Seleccione...":
                idRoles="5";
        }
        idEstado="1";
        claves=identificacion.getText();
        if(nombre.isEmpty()){
            JOptionPane.showMessageDialog(null,"Datos Incompletos Todos los campos son Obligatorios");
        }else if(apellido.isEmpty()){
            JOptionPane.showMessageDialog(null,"Datos Incompletos Todos los campos son Obligatorios");
        }else if(correos.isEmpty()){
            JOptionPane.showMessageDialog(null,"Datos Incompletos Todos los campos son Obligatorios");
        }else if(tId=="4"){
            JOptionPane.showMessageDialog(null,"Datos Incompletos Todos los campos son Obligatorios");
        }else if(idCentros=="5"){
            JOptionPane.showMessageDialog(null,"Datos Incompletos Todos los campos son Obligatorios");
        }else if(idRoles=="5"){
            JOptionPane.showMessageDialog(null,"Datos Incompletos Todos los campos son Obligatorios");
        }else if(identificaciones.isEmpty()){
            JOptionPane.showMessageDialog(null,"Datos Incompletos Todos los campos son Obligatorios");
        }else{
            int fila=tDatos.getSelectedRow();
            String sql="UPDATE persona set identificacion=?, nombre=?, apellido=?, clave=?, "
                    + "tipoID=?, telefono=?, correo=?, id_rol=?, id_centro=? "
                    + "WHERE codigo="+tDatos.getValueAt(fila,0);
            Conect cone = new Conect();
            Connection con=cone.conexion();
            try {
                PreparedStatement pst=con.prepareStatement(sql);
                pst.setString(1,identificaciones);
                pst.setString(2,nombre);
                pst.setString(3,apellido);
                pst.setString(4,claves);
                pst.setString(5,tId);
                pst.setString(6,telefonos);
                pst.setString(7,correos);
                pst.setString(8,idRoles);
                pst.setString(9,idCentros);
    
                int n=pst.executeUpdate();
                if(n>0){
                    JOptionPane.showMessageDialog(null, "Registro Modificado con Exito");
                    limpiar();
                }
                tDatos.setModel(modelo);
            } catch (SQLException ex) {
                    JOptionPane.showMessageDialog(null, ex);
            }
        }
        registros("");
    }
    void inhabilitar(){
        actualizar.setVisible(false);
        jTabbedPane1.setEnabledAt(2, false);
        jPanel3.setVisible(false);
        personaD.setVisible(false);
        vehiculos.setVisible(false);
        objetos.setVisible(false);
    }
    void registrar(){
        buscar.setText("Ingrese Numero de Identificacion");
        String identificaciones, nombre, apellido, telefonos, correos, tId="null", idCentros="null", idRoles="null", claves, idEstado=null;
        identificaciones=identificacion.getText();
        nombre=nombres.getText();
        apellido=apellidos.getText();
        telefonos=telefono.getText();
        correos=correo.getText();
        
        switch(tipoId.getSelectedItem().toString()){
            case "Tarjeta de Identidad":
                tId="1";
            break;
            case "Cedula de Ciudadanía":
                tId="2";
            break;
            case "Cedula de Extranjeria":
                tId="3";
            break;
            case "Seleccione...":
                tId="4";
        }
        switch(idCentro.getSelectedItem().toString()){
            case "CEAI":
                idCentros="1";
            break;
            case "CDTI":
                idCentros="2";
            break;
            case "ASTIN":
                idCentros="3";
            break;
            case "CGTS":
                idCentros="4";
            break;
            case "Seleccione...":
                idCentros="5";
        }
        switch(idRol.getSelectedItem().toString()){
            case "Funcionario":
                idRoles="1";
            break;
            case "Aprendiz":
                idRoles="2";
            break;
            case "Operario":
                idRoles="3";
            break;
            case "Visitante":
                idRoles="4";
            break;
            case "Seleccione...":
                idRoles="5";
        }
        idEstado="1";
        claves=identificacion.getText();
        if(nombre.isEmpty()){
            JOptionPane.showMessageDialog(null,"Datos Incompletos Todos los campos son Obligatorios");
        }else if(apellido.isEmpty()){
            JOptionPane.showMessageDialog(null,"Datos Incompletos Todos los campos son Obligatorios");
        }else if(correos.isEmpty()){
            JOptionPane.showMessageDialog(null,"Datos Incompletos Todos los campos son Obligatorios");
        }else if(tId=="4"){
            JOptionPane.showMessageDialog(null,"Datos Incompletos Todos los campos son Obligatorios");
        }else if(idCentros=="5"){
            JOptionPane.showMessageDialog(null,"Datos Incompletos Todos los campos son Obligatorios");
        }else if(idRoles=="5"){
            JOptionPane.showMessageDialog(null,"Datos Incompletos Todos los campos son Obligatorios");
        }else if(identificaciones.isEmpty()){
            JOptionPane.showMessageDialog(null,"Datos Incompletos Todos los campos son Obligatorios");
        }else{
            String sql="INSERT INTO persona(identificacion, nombre, apellido, tipoID, telefono, correo, clave, id_rol, id_centro, id_estado)"
                    + "VALUES (?,?,?,?,?,?,?,?,?,?)";
            Conect cone = new Conect();
            Connection con=cone.conexion();

            try {
                PreparedStatement pst=con.prepareStatement(sql);
                pst.setString(1,identificaciones);
                pst.setString(2,nombre);
                pst.setString(3,apellido);
                pst.setString(4,tId);
                pst.setString(5,telefonos);
                pst.setString(6,correos);
                pst.setString(7,claves);
                pst.setString(8,idRoles);
                pst.setString(9,idCentros);
                pst.setString(10,idEstado);
                int n=pst.executeUpdate();
                if(n>0){
                    JOptionPane.showMessageDialog(null, "Registro Guardado con Exito");
                    limpiar();
                }
                tDatos.setModel(modelo);
            } catch (SQLException ex) {
                    JOptionPane.showMessageDialog(null, ex);
            }
        }
    }
    void registros(String id){
        buscar.setText("Ingrese Numero de Identificacion");
        String [] titulos={"CODIGO","NOMBRES","APELLIDOS","TIPO ID","IDENTIFICACION","TELEFONO","CORREO","ROL","CENTRO"};
        String [] registros=new String[9];
        String sql="SELECT * \n"
                + "FROM persona \n WHERE id_estado=1 \n AND identificacion LIKE '%"+id+"%'";
        modelo=new DefaultTableModel(null,titulos);
        Conect cone = new Conect();
        Connection con=cone.conexion();
        
        try {
            Statement st=con.createStatement();
            ResultSet rs=st.executeQuery(sql);
            while(rs.next()){
                registros[0]=rs.getString("codigo");
                registros[1]=rs.getString("nombre");
                registros[2]=rs.getString("apellido");
                registros[3]=rs.getString("tipoID");
                registros[4]=rs.getString("identificacion");
                registros[5]=rs.getString("telefono");
                registros[6]=rs.getString("correo");
                registros[7]=rs.getString("id_rol");
                registros[8]=rs.getString("id_centro");
                modelo.addRow(registros);
            }
            tDatos.setModel(modelo);
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, ex);
        }
    }
    void limpiar(){
        buscar.setText("Ingrese Numero de Identificacion");
        identificacion.setText("");
        tipoId.setSelectedIndex(0);
        nombres.setText("");
        apellidos.setText("");
        telefono.setText("");
        correo.setText("");
        idCentro.setSelectedIndex(0);
        idRol.setSelectedIndex(0);
        registrar.setVisible(true);
    }
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        menu = new javax.swing.JPopupMenu();
        modificar = new javax.swing.JMenuItem();
        eliminar = new javax.swing.JMenuItem();
        verMas = new javax.swing.JMenuItem();
        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jTabbedPane1 = new javax.swing.JTabbedPane();
        jPanel4 = new javax.swing.JPanel();
        jLabel3 = new javax.swing.JLabel();
        identificacion = new javax.swing.JTextField();
        jLabel5 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        nombres = new javax.swing.JTextField();
        apellidos = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        correo = new javax.swing.JTextField();
        telefono = new javax.swing.JTextField();
        jLabel10 = new javax.swing.JLabel();
        idCentro = new javax.swing.JComboBox<>();
        idRol = new javax.swing.JComboBox<>();
        jLabel9 = new javax.swing.JLabel();
        tipoId = new javax.swing.JComboBox<>();
        cancelar = new javax.swing.JButton();
        registrar = new javax.swing.JButton();
        actualizar = new javax.swing.JButton();
        fondo = new javax.swing.JLabel();
        jPanel2 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tDatos = new javax.swing.JTable();
        buscar = new javax.swing.JTextField();
        jLabel11 = new javax.swing.JLabel();
        fondo2 = new javax.swing.JLabel();
        jPanel3 = new javax.swing.JPanel();
        jScrollPane2 = new javax.swing.JScrollPane();
        personaD = new javax.swing.JTable();
        jScrollPane3 = new javax.swing.JScrollPane();
        vehiculos = new javax.swing.JTable();
        jScrollPane4 = new javax.swing.JScrollPane();
        objetos = new javax.swing.JTable();
        jLabel8 = new javax.swing.JLabel();
        jLabel12 = new javax.swing.JLabel();
        jLabel13 = new javax.swing.JLabel();
        fondo3 = new javax.swing.JLabel();

        modificar.setText("Modificar");
        modificar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                modificarActionPerformed(evt);
            }
        });
        menu.add(modificar);

        eliminar.setText("Eliminar");
        eliminar.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                eliminarMouseClicked(evt);
            }
        });
        eliminar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                eliminarActionPerformed(evt);
            }
        });
        eliminar.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                eliminarKeyReleased(evt);
            }
        });
        menu.add(eliminar);

        verMas.setText("Ver Mas");
        verMas.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                verMasActionPerformed(evt);
            }
        });
        menu.add(verMas);

        setClosable(true);
        setIconifiable(true);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel1.setBackground(new java.awt.Color(0, 153, 92));
        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel1.setFont(new java.awt.Font("Comic Sans MS", 1, 36)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setText("PERSONAS");
        jPanel1.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 810, 50));

        getContentPane().add(jPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 810, 50));

        jTabbedPane1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jTabbedPane1MouseClicked(evt);
            }
        });

        jPanel4.setLayout(null);

        jLabel3.setFont(new java.awt.Font("Comic Sans MS", 1, 14)); // NOI18N
        jLabel3.setText("IDENTIFICACIÓN");
        jPanel4.add(jLabel3);
        jLabel3.setBounds(80, 30, 131, 21);

        identificacion.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                identificacionActionPerformed(evt);
            }
        });
        jPanel4.add(identificacion);
        identificacion.setBounds(230, 30, 170, 30);

        jLabel5.setFont(new java.awt.Font("Comic Sans MS", 1, 14)); // NOI18N
        jLabel5.setText("TIPO DE ID");
        jPanel4.add(jLabel5);
        jLabel5.setBounds(460, 30, 85, 21);

        jLabel2.setFont(new java.awt.Font("Comic Sans MS", 1, 14)); // NOI18N
        jLabel2.setText("NOMBRES");
        jPanel4.add(jLabel2);
        jLabel2.setBounds(80, 70, 71, 21);
        jPanel4.add(nombres);
        nombres.setBounds(230, 70, 170, 30);
        jPanel4.add(apellidos);
        apellidos.setBounds(560, 70, 167, 30);

        jLabel4.setFont(new java.awt.Font("Comic Sans MS", 1, 14)); // NOI18N
        jLabel4.setText("APELLIDOS");
        jPanel4.add(jLabel4);
        jLabel4.setBounds(460, 70, 81, 21);

        jLabel6.setFont(new java.awt.Font("Comic Sans MS", 1, 14)); // NOI18N
        jLabel6.setText("TELEFONO");
        jPanel4.add(jLabel6);
        jLabel6.setBounds(80, 110, 78, 21);

        jLabel7.setFont(new java.awt.Font("Comic Sans MS", 1, 14)); // NOI18N
        jLabel7.setText("CORREO");
        jPanel4.add(jLabel7);
        jLabel7.setBounds(460, 110, 58, 21);
        jPanel4.add(correo);
        correo.setBounds(560, 110, 167, 30);
        jPanel4.add(telefono);
        telefono.setBounds(230, 110, 170, 30);

        jLabel10.setFont(new java.awt.Font("Comic Sans MS", 1, 14)); // NOI18N
        jLabel10.setText("CENTRO");
        jPanel4.add(jLabel10);
        jLabel10.setBounds(80, 150, 59, 21);

        idCentro.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Seleccione...", "CEAI", "CDTI", "ASTIN", "CGTS" }));
        idCentro.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                idCentroActionPerformed(evt);
            }
        });
        jPanel4.add(idCentro);
        idCentro.setBounds(230, 150, 167, 30);

        idRol.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Seleccione...", "Funcionario", "Aprendiz", "Operario", "Visitante" }));
        idRol.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                idRolActionPerformed(evt);
            }
        });
        jPanel4.add(idRol);
        idRol.setBounds(560, 150, 167, 30);

        jLabel9.setFont(new java.awt.Font("Comic Sans MS", 1, 14)); // NOI18N
        jLabel9.setText("ROL");
        jPanel4.add(jLabel9);
        jLabel9.setBounds(460, 150, 28, 21);

        tipoId.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Seleccione...", "Tarjeta de Identidad", "Cedula de Ciudadanía", "Cedula de Extranjeria" }));
        tipoId.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                tipoIdActionPerformed(evt);
            }
        });
        jPanel4.add(tipoId);
        tipoId.setBounds(560, 30, 167, 30);

        cancelar.setFont(new java.awt.Font("Comic Sans MS", 1, 14)); // NOI18N
        cancelar.setText("CANCELAR");
        cancelar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cancelarActionPerformed(evt);
            }
        });
        jPanel4.add(cancelar);
        cancelar.setBounds(260, 220, 107, 29);

        registrar.setFont(new java.awt.Font("Comic Sans MS", 1, 14)); // NOI18N
        registrar.setText("REGISTRAR");
        registrar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                registrarActionPerformed(evt);
            }
        });
        jPanel4.add(registrar);
        registrar.setBounds(410, 220, 120, 29);

        actualizar.setFont(new java.awt.Font("Comic Sans MS", 1, 14)); // NOI18N
        actualizar.setText("MODIFICAR");
        actualizar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                actualizarActionPerformed(evt);
            }
        });
        jPanel4.add(actualizar);
        actualizar.setBounds(410, 220, 119, 29);
        jPanel4.add(fondo);
        fondo.setBounds(0, 0, 800, 350);

        jTabbedPane1.addTab("Registro de Personas", jPanel4);

        jPanel2.setLayout(null);

        tDatos.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {},
                {},
                {},
                {}
            },
            new String [] {

            }
        ));
        tDatos.setComponentPopupMenu(menu);
        tDatos.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tDatosMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(tDatos);

        jPanel2.add(jScrollPane1);
        jScrollPane1.setBounds(10, 45, 780, 300);

        buscar.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                buscarMouseClicked(evt);
            }
        });
        buscar.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                buscarKeyReleased(evt);
            }
        });
        jPanel2.add(buscar);
        buscar.setBounds(440, 10, 240, 30);

        jLabel11.setFont(new java.awt.Font("Comic Sans MS", 1, 14)); // NOI18N
        jLabel11.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel11.setText("Buscar");
        jPanel2.add(jLabel11);
        jLabel11.setBounds(720, 10, 60, 30);
        jPanel2.add(fondo2);
        fondo2.setBounds(0, 0, 800, 350);

        jTabbedPane1.addTab("Consultar", jPanel2);

        jPanel3.setLayout(null);

        personaD.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {},
                {},
                {},
                {}
            },
            new String [] {

            }
        ));
        jScrollPane2.setViewportView(personaD);

        jPanel3.add(jScrollPane2);
        jScrollPane2.setBounds(0, 40, 808, 76);

        vehiculos.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {},
                {},
                {},
                {}
            },
            new String [] {

            }
        ));
        jScrollPane3.setViewportView(vehiculos);

        jPanel3.add(jScrollPane3);
        jScrollPane3.setBounds(410, 150, 395, 195);

        objetos.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {},
                {},
                {},
                {}
            },
            new String [] {

            }
        ));
        jScrollPane4.setViewportView(objetos);

        jPanel3.add(jScrollPane4);
        jScrollPane4.setBounds(0, 150, 395, 195);

        jLabel8.setFont(new java.awt.Font("Comic Sans MS", 1, 14)); // NOI18N
        jLabel8.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel8.setText("VEHICULOS");
        jPanel3.add(jLabel8);
        jLabel8.setBounds(405, 120, 400, 21);

        jLabel12.setFont(new java.awt.Font("Comic Sans MS", 1, 14)); // NOI18N
        jLabel12.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel12.setText("REGISTRO DETALLADO");
        jPanel3.add(jLabel12);
        jLabel12.setBounds(8, 10, 790, 21);

        jLabel13.setFont(new java.awt.Font("Comic Sans MS", 1, 14)); // NOI18N
        jLabel13.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel13.setText("OBJETOS");
        jPanel3.add(jLabel13);
        jLabel13.setBounds(-1, 120, 400, 21);
        jPanel3.add(fondo3);
        fondo3.setBounds(0, 0, 810, 350);

        jTabbedPane1.addTab("", jPanel3);

        getContentPane().add(jTabbedPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 50, 810, 390));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void idCentroActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_idCentroActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_idCentroActionPerformed

    private void identificacionActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_identificacionActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_identificacionActionPerformed

    private void cancelarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cancelarActionPerformed
        // TODO add your handling code here:
        limpiar();
    }//GEN-LAST:event_cancelarActionPerformed

    private void tipoIdActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_tipoIdActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_tipoIdActionPerformed

    private void registrarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_registrarActionPerformed
        // Registrar personas
        registrar();
        registros("");
    }//GEN-LAST:event_registrarActionPerformed

    private void idRolActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_idRolActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_idRolActionPerformed

    private void eliminarKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_eliminarKeyReleased
        // TODO add your handling code here:
    }//GEN-LAST:event_eliminarKeyReleased

    private void eliminarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_eliminarActionPerformed
        // ELIMINAR:
        if (JOptionPane.showConfirmDialog(rootPane, "Esta seguro de ELIMINAR este Registro?","Eliminar Registro... ",JOptionPane.YES_NO_OPTION)==JOptionPane.YES_OPTION){
            try{
                buscar.setText("Ingrese Numero de Identificacion");
                Conect cone = new Conect();
                Connection con=cone.conexion();
                int fila=tDatos.getSelectedRow();
                String sql="UPDATE persona \n SET id_estado=2 \n WHERE codigo="+tDatos.getValueAt(fila,0);
	
                PreparedStatement prest=con.prepareStatement(sql);
                sent = con.createStatement();
                int n=prest.executeUpdate(sql);
                if(n>0){
                    registros("");
                    JOptionPane.showMessageDialog(null, "Registro Eliminado con Exito");
                    limpiar();
                }
            }
            catch (SQLException ex){
                Logger.getLogger(Persona.class.getName()).log(Level.SEVERE, null, ex);
            }
            
            try{
                Conect cone = new Conect();
                Connection con=cone.conexion();
                int fila=tDatos.getSelectedRow();
                String sql2="UPDATE vehiculo \n SET id_estado=2 \n WHERE codigo="+tDatos.getValueAt(fila,0);
	
                PreparedStatement prest=con.prepareStatement(sql2);
                sent = con.createStatement();
                int n=prest.executeUpdate(sql2);
                if(n>0){
                    registros("");
                    //JOptionPane.showMessageDialog(null, "Registro Eliminado con Exito");
                    limpiar();
                }
            }
            catch (SQLException ex){
                Logger.getLogger(Persona.class.getName()).log(Level.SEVERE, null, ex);
            }
            
            try{
                Conect cone = new Conect();
                Connection con=cone.conexion();
                int fila=tDatos.getSelectedRow();
                String sql3="UPDATE objetos \n SET id_estado=2 \n WHERE codigo_persona="+tDatos.getValueAt(fila,0);
	
                PreparedStatement prest=con.prepareStatement(sql3);
                sent = con.createStatement();
                int n=prest.executeUpdate(sql3);
                if(n>0){
                    registros("");
                    //JOptionPane.showMessageDialog(null, "Registro Eliminado con Exito");
                    limpiar();
                }
            }
            catch (SQLException ex){
                Logger.getLogger(Persona.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        registros("");
    }//GEN-LAST:event_eliminarActionPerformed

    private void eliminarMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_eliminarMouseClicked
        // TODO add your handling code here:
    }//GEN-LAST:event_eliminarMouseClicked

    private void tDatosMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tDatosMouseClicked
        // TODO add your handling code here:
    }//GEN-LAST:event_tDatosMouseClicked

    private void modificarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_modificarActionPerformed
        // MODIFICAR:
        registrar.setVisible(false);
        actualizar.setVisible(true);
        jPanel3.setVisible(true);
        jTabbedPane1.setSelectedIndex(0);
        int fila;
        try{
            fila= tDatos.getSelectedRow();
            if (fila==-1){
                JOptionPane.showMessageDialog(null, "No se ha seleccionado ninguna fila");
            }else{
                modelo=(DefaultTableModel) tDatos.getModel();
                
                String nombre=(String) modelo.getValueAt(fila, 1);
                String apellido=(String) modelo.getValueAt(fila, 2);
                String tipo_id=(String)modelo.getValueAt(fila, 3);
                String ident=(String)modelo.getValueAt(fila, 4);
                String tel=(String)modelo.getValueAt(fila, 5);
                String corr=(String)modelo.getValueAt(fila, 6);
                String rol=(String)modelo.getValueAt(fila, 7);
                String cent=(String)modelo.getValueAt(fila, 8);
                
                int tip_id, idCent, idRo;
                
                tip_id = Integer.parseInt(tipo_id);
                idCent = Integer.parseInt(cent);
                idRo = Integer.parseInt(rol);
                
                nombres.setText(nombre);
                apellidos.setText(apellido);
                identificacion.setText(ident);
                tipoId.setSelectedIndex(tip_id);
                telefono.setText(tel);
                correo.setText(corr);
                idCentro.setSelectedIndex(idCent);
                idRol.setSelectedIndex(idRo);
            }
        }
        catch (HeadlessException ex){
            JOptionPane.showMessageDialog(null, "Error: "+ex+"\n Inténtelo nuevamente", " .::Error En la Operacion::." ,JOptionPane.ERROR_MESSAGE);
        }
    }//GEN-LAST:event_modificarActionPerformed

    private void buscarKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_buscarKeyReleased
        // buscar personas por el numero de identificacion
        registros(buscar.getText());
    }//GEN-LAST:event_buscarKeyReleased

    private void verMasActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_verMasActionPerformed
        // Ver personas con sus vehiculos u objetos:
        jPanel3.setVisible(true);
        personaD.setVisible(true);
        vehiculos.setVisible(true);
        objetos.setVisible(true);
        jTabbedPane1.setSelectedIndex(2);
        int fila=tDatos.getSelectedRow();
        Conect cone = new Conect();
        Connection con=cone.conexion();
        
        String [] titulos={"CODIGO","NOMBRES","APELLIDOS","TIPO ID","IDENTIFICACION","TELEFONO","CORREO","ROL","CENTRO"};
        String [] registros=new String[9];
        String sql="SELECT * \n"+
                   "FROM persona \n "+
                   "INNER JOIN centro USING(id_centro) \n"+
                   "INNER JOIN tipo_id ON tipo_id.cod_tipo_id=persona.tipoID \n"+
                   "INNER JOIN rol USING(id_rol) \n"+
                   "WHERE id_estado=1 AND codigo ="+tDatos.getValueAt(fila,0);
        modelo=new DefaultTableModel(null,titulos);
        try {
            Statement st=con.createStatement();
            ResultSet rs=st.executeQuery(sql);
            while(rs.next()){
                registros[0]=rs.getString("codigo");
                registros[1]=rs.getString("nombre");
                registros[2]=rs.getString("apellido");
                registros[3]=rs.getString("descripcion");
                registros[4]=rs.getString("identificacion");
                registros[5]=rs.getString("telefono");
                registros[6]=rs.getString("correo");
                registros[7]=rs.getString("rol.nombre");
                registros[8]=rs.getString("centro.nombre");
                modelo.addRow(registros);
            }
            personaD.setModel(modelo);
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, ex);
        }
        
        String [] titulos2={"DESCRIPCION","SERIAL","MODELO","OBJETO"};
        String [] registros2=new String[4];
        String sql2="select descripcion, serial, modelo, desc_obj \n" +
                    "from objetos \n" +
                    "inner join persona \n" +
                    "on persona.codigo=objetos.codigo_persona \n" +
                    "inner join tipo_obj \n" +
                    "on tipo_obj.codigo_obj=objetos.tipo_obj \n" +
                    "where persona.codigo="+tDatos.getValueAt(fila,0)+" and objetos.id_estado=1;";
        modelo=new DefaultTableModel(null,titulos2);
        try {
            Statement st=con.createStatement();
            ResultSet rs=st.executeQuery(sql2);
            while(rs.next()){
                registros2[0]=rs.getString("descripcion");
                registros2[1]=rs.getString("serial");
                registros2[2]=rs.getString("modelo");
                registros2[3]=rs.getString("desc_obj");
                modelo.addRow(registros2);
            }
            objetos.setModel(modelo);
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, ex);
        }
        
        String [] titulos3={"ID","TIPO","PLACA"};
        String [] registros3=new String[3];
        String sql3="SELECT id_vehiculo, desc_tipo_vehi, placa\n" +
                    "FROM persona\n" +
                    "INNER JOIN vehiculo\n" +
                    "USING (codigo)\n" +
                    "INNER JOIN tipo_vehi\n" +
                    "ON vehiculo.tipo_veh = tipo_vehi.cod_tipo_vehi\n" +
                    "WHERE persona.codigo ="+tDatos.getValueAt(fila,0);
        modelo=new DefaultTableModel(null,titulos3);
        try {
            Statement st=con.createStatement();
            ResultSet rs=st.executeQuery(sql3);
            while(rs.next()){
                registros3[0]=rs.getString("id_vehiculo");
                registros3[1]=rs.getString("desc_tipo_vehi");
                registros3[2]=rs.getString("placa");
                modelo.addRow(registros3);
            }
            vehiculos.setModel(modelo);
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, ex);
        }
    }//GEN-LAST:event_verMasActionPerformed

    private void actualizarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_actualizarActionPerformed
        // Modificar los datos deseados:
        modificarPersona();
        actualizar.setVisible(false);
        registrar.setVisible(true);
    }//GEN-LAST:event_actualizarActionPerformed

    private void buscarMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_buscarMouseClicked
        // buscar por identificaion:
        buscar.setText("");
    }//GEN-LAST:event_buscarMouseClicked

    private void jTabbedPane1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTabbedPane1MouseClicked
        // TODO add your handling code here:
        buscar.setText("Ingrese Numero de Identificacion");
    }//GEN-LAST:event_jTabbedPane1MouseClicked

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton actualizar;
    private javax.swing.JTextField apellidos;
    private javax.swing.JTextField buscar;
    private javax.swing.JButton cancelar;
    private javax.swing.JTextField correo;
    private javax.swing.JMenuItem eliminar;
    private javax.swing.JLabel fondo;
    private javax.swing.JLabel fondo2;
    private javax.swing.JLabel fondo3;
    private javax.swing.JComboBox<String> idCentro;
    private javax.swing.JComboBox<String> idRol;
    private javax.swing.JTextField identificacion;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JScrollPane jScrollPane4;
    private javax.swing.JTabbedPane jTabbedPane1;
    private javax.swing.JPopupMenu menu;
    private javax.swing.JMenuItem modificar;
    private javax.swing.JTextField nombres;
    private javax.swing.JTable objetos;
    private javax.swing.JTable personaD;
    private javax.swing.JButton registrar;
    private javax.swing.JTable tDatos;
    private javax.swing.JTextField telefono;
    private javax.swing.JComboBox<String> tipoId;
    private javax.swing.JTable vehiculos;
    private javax.swing.JMenuItem verMas;
    // End of variables declaration//GEN-END:variables
}
