package sires;


import java.awt.Image;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.ImageIcon;
import javax.swing.JOptionPane;

/**
 *
 * @author Juan Pablo
 */
public class Login extends javax.swing.JFrame {
    public Login() {
        initComponents();
        imagen();
    }
    void imagen(){
        ImageIcon imagen = new ImageIcon(getClass().getResource("../imagenes/subPlantillas2.png"));
        Image conversion =imagen.getImage();
        Image tamaño =conversion.getScaledInstance(280,170, Image.SCALE_SMOOTH);
        ImageIcon fin=new ImageIcon(tamaño);
        fondo.setIcon(fin);
    }
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jPanel2 = new javax.swing.JPanel();
        jLabel3 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        usuario = new javax.swing.JTextField();
        claves = new javax.swing.JPasswordField();
        ingresar = new javax.swing.JButton();
        cerrar = new javax.swing.JButton();
        fondo = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel1.setBackground(new java.awt.Color(0, 153, 92));
        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel1.setFont(new java.awt.Font("Comic Sans MS", 1, 36)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setText("LOGIN");
        jPanel1.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(2, 0, 290, -1));

        getContentPane().add(jPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 290, 50));

        jPanel2.setLayout(null);

        jLabel3.setFont(new java.awt.Font("Comic Sans MS", 1, 14)); // NOI18N
        jLabel3.setText("CONTRASEÑA");
        jPanel2.add(jLabel3);
        jLabel3.setBounds(21, 83, 100, 21);

        jLabel2.setFont(new java.awt.Font("Comic Sans MS", 1, 14)); // NOI18N
        jLabel2.setText("USUARIO");
        jPanel2.add(jLabel2);
        jLabel2.setBounds(21, 35, 68, 21);

        usuario.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                usuarioActionPerformed(evt);
            }
        });
        jPanel2.add(usuario);
        usuario.setBounds(125, 26, 150, 30);
        jPanel2.add(claves);
        claves.setBounds(125, 74, 150, 30);

        ingresar.setFont(new java.awt.Font("Comic Sans MS", 1, 14)); // NOI18N
        ingresar.setText("INGRESAR");
        ingresar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ingresarActionPerformed(evt);
            }
        });
        jPanel2.add(ingresar);
        ingresar.setBounds(139, 122, 109, 30);

        cerrar.setFont(new java.awt.Font("Comic Sans MS", 1, 14)); // NOI18N
        cerrar.setText("SALIR");
        jPanel2.add(cerrar);
        cerrar.setBounds(52, 122, 77, 30);
        jPanel2.add(fondo);
        fondo.setBounds(4, 4, 280, 170);

        getContentPane().add(jPanel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 50, 290, 180));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void usuarioActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_usuarioActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_usuarioActionPerformed

    private void ingresarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ingresarActionPerformed
        // INGRESAR:
        Sires.Conect cone = new Sires.Conect();
        Connection con=cone.conexion();
        
        String cap="";
        String usu = usuario.getText(), pass = claves.getText();
        String sql ="SELECT *"+
                    "FROM persona"+
                    "INNER JOIN rol USING(id_rol)"+
                    "INNER JOIN rolxpermisos USING(id_rol)"+
                    "INNER JOIN permisos ON rolxpermisos.id_permiso=permisos.id_permisos"+
                    "WHERE identificacion ="+usu+" AND clave = "+pass+" AND id_estado=1"; 
                    
        try {
            Statement st = con.createStatement();
            ResultSet rs = st.executeQuery(sql);
            while(rs.next()){
                JOptionPane.showMessageDialog(null,"ENTROOOO");
                cap = rs.getString("descripcion");
            }
            if(cap.equals("Consulta")){
                
            }
        } 
        catch (SQLException ex) {
            Logger.getLogger(Login.class.getName()).log(Level.SEVERE, null, ex);
        }
            
        
    }//GEN-LAST:event_ingresarActionPerformed

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
            java.util.logging.Logger.getLogger(Login.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Login.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Login.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Login.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Login().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton cerrar;
    private javax.swing.JPasswordField claves;
    private javax.swing.JLabel fondo;
    private javax.swing.JButton ingresar;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JTextField usuario;
    // End of variables declaration//GEN-END:variables
}
