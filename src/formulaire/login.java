/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package formulaire;

import connexionBD.ConnexionBD;
import gestion.GestionCandidat;
import gestion.GestionUtilisateur;
import java.awt.Color;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

/**
 *
 * @author MSI
 */
public class login extends javax.swing.JFrame {

    public Connection connexion;
    public Statement stat;
    public PreparedStatement pre;
    

    public login() throws Exception {
        initComponents();
//       JLabel lblNomU = new JLabel();
//       JButton lblMotPassU = new JButton();
        
        
        lblNomU.setVisible(false);
        lblMotPassU.setVisible(false);
        lblMessage.setVisible(false);
        
        ConnexionBD con = new ConnexionBD();
    }

//    effacerChamps(){
//        txtNomU.setText("");
//        txtMotPassU.setText("");
//    }
    //effacerChamps()
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        fermeLogin = new javax.swing.JLabel();
        jPanel2 = new javax.swing.JPanel();
        txtNomU = new javax.swing.JTextField();
        txtMotPassU = new javax.swing.JPasswordField();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        btnConnecter = new javax.swing.JButton();
        lblNomU = new javax.swing.JLabel();
        lblMotPassU = new javax.swing.JLabel();
        lblMessage = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jPanel3 = new javax.swing.JPanel();
        jLabel5 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setBackground(new java.awt.Color(255, 255, 255));
        setUndecorated(true);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));
        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel1.setBackground(new java.awt.Color(255, 255, 255));
        jLabel1.setFont(new java.awt.Font("Georgia", 1, 24)); // NOI18N
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setText("Login");
        jPanel1.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, -1, 750, 50));

        fermeLogin.setFont(new java.awt.Font("Tahoma", 1, 36)); // NOI18N
        fermeLogin.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        fermeLogin.setText("X");
        fermeLogin.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        fermeLogin.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                fermeLoginMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                fermeLoginMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                fermeLoginMouseExited(evt);
            }
        });
        jPanel1.add(fermeLogin, new org.netbeans.lib.awtextra.AbsoluteConstraints(784, 0, 40, 40));

        getContentPane().add(jPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 830, 50));

        jPanel2.setBackground(new java.awt.Color(255, 255, 255));
        jPanel2.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        txtNomU.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        txtNomU.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                txtNomUKeyPressed(evt);
            }
        });
        jPanel2.add(txtNomU, new org.netbeans.lib.awtextra.AbsoluteConstraints(44, 145, 310, 40));

        txtMotPassU.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        txtMotPassU.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                txtMotPassUKeyPressed(evt);
            }
        });
        jPanel2.add(txtMotPassU, new org.netbeans.lib.awtextra.AbsoluteConstraints(44, 230, 310, 40));

        jLabel2.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel2.setText("Nom:");
        jLabel2.setVerticalAlignment(javax.swing.SwingConstants.BOTTOM);
        jPanel2.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 120, 50, 20));

        jLabel3.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel3.setText("Mot de passe:");
        jLabel3.setVerticalAlignment(javax.swing.SwingConstants.BOTTOM);
        jPanel2.add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 210, 110, 20));

        btnConnecter.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        btnConnecter.setText("Connexion");
        btnConnecter.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnConnecter.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                btnConnecterMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                btnConnecterMouseExited(evt);
            }
        });
        btnConnecter.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnConnecterActionPerformed(evt);
            }
        });
        jPanel2.add(btnConnecter, new org.netbeans.lib.awtextra.AbsoluteConstraints(44, 316, 310, 40));

        lblNomU.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N
        lblNomU.setForeground(java.awt.Color.red);
        lblNomU.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblNomU.setText("*");
        jPanel2.add(lblNomU, new org.netbeans.lib.awtextra.AbsoluteConstraints(350, 150, 20, 30));

        lblMotPassU.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N
        lblMotPassU.setForeground(java.awt.Color.red);
        lblMotPassU.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblMotPassU.setText("*");
        jPanel2.add(lblMotPassU, new org.netbeans.lib.awtextra.AbsoluteConstraints(350, 240, 20, 30));

        lblMessage.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        lblMessage.setForeground(java.awt.Color.red);
        jPanel2.add(lblMessage, new org.netbeans.lib.awtextra.AbsoluteConstraints(83, 315, 316, 37));

        jLabel4.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jLabel4.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel4.setIcon(new javax.swing.ImageIcon("C:\\Users\\MSI\\Documents\\NetBeansProjects\\inscriptionConcoursEMIT2.0\\src\\icones\\admin.png")); // NOI18N
        jPanel2.add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(110, 0, 200, 110));

        getContentPane().add(jPanel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(389, 42, 440, 480));

        jPanel3.setBackground(new java.awt.Color(255, 255, 255));

        jLabel5.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel5.setIcon(new javax.swing.ImageIcon("C:\\Users\\MSI\\Documents\\NetBeansProjects\\inscriptionConcoursEMIT2.0\\src\\icones\\pM.jpg")); // NOI18N
        jLabel5.setText("jLabel5");

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel3Layout.createSequentialGroup()
                .addComponent(jLabel5, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLabel5, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        getContentPane().add(jPanel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 49, 390, 480));

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void btnConnecterActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnConnecterActionPerformed
       if(txtNomU.getText().equals("")){ lblNomU.setVisible(true);
       }else{ lblNomU.setVisible(false); }
       
       if( txtMotPassU.getText().equals("")){ lblMotPassU.setVisible(true);
       }else{ lblMotPassU.setVisible(false); }
       
       if(txtNomU.getText() != "" && txtMotPassU.getPassword().length != 0){
           
           //connexion = new ConnexionBD();
            GestionUtilisateur gU;
            
            String nomA = txtNomU.getText();
            String passA = txtMotPassU.getText();
            
           try {
               gU = new GestionUtilisateur();
                ResultSet rsl = gU.getBy(nomA, passA);
                
                if( rsl.next() ){

                    main_form mF = new main_form();
                    mF.setVisible(true);
                    
                    JOptionPane.showMessageDialog(null, "Bienvenu");
                    login log = new login();
                    log.setDefaultCloseOperation( JFrame.DISPOSE_ON_CLOSE );
                }else{
                    JOptionPane.showMessageDialog(null, "Utilisateur non identifie \n ou mot de passe incorrect "); 
                }
                
           } catch (Exception ex) {
               System.out.println("Erreur de la connexion de gestion " + ex);
           } 
           
       }else{
           lblMessage.setVisible(true);
           lblMessage.setText("Remplir les champs vide");
       }
       
    }//GEN-LAST:event_btnConnecterActionPerformed

    private void btnConnecterMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnConnecterMouseEntered
       btnConnecter.setBackground(Color.BLUE);
       btnConnecter.setForeground(Color.WHITE);
    }//GEN-LAST:event_btnConnecterMouseEntered

    private void btnConnecterMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnConnecterMouseExited
        btnConnecter.setBackground(Color.gray);
        btnConnecter.setForeground(Color.BLACK);
    }//GEN-LAST:event_btnConnecterMouseExited

    private void fermeLoginMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_fermeLoginMouseClicked
        dispose();
    }//GEN-LAST:event_fermeLoginMouseClicked

    private void fermeLoginMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_fermeLoginMouseEntered
        fermeLogin.setForeground(Color.red);
    }//GEN-LAST:event_fermeLoginMouseEntered

    private void fermeLoginMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_fermeLoginMouseExited
       fermeLogin.setForeground(Color.black);
    }//GEN-LAST:event_fermeLoginMouseExited

    private void txtNomUKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtNomUKeyPressed
        lblNomU.setVisible(false);
    }//GEN-LAST:event_txtNomUKeyPressed

    private void txtMotPassUKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtMotPassUKeyPressed
        lblMotPassU.setVisible(false);
    }//GEN-LAST:event_txtMotPassUKeyPressed

    /**
     * @param args the command line arguments
     */
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
            java.util.logging.Logger.getLogger(login.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(login.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(login.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(login.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    new login().setVisible(true);
                } catch (Exception ex) {
                    Logger.getLogger(login.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnConnecter;
    private javax.swing.JLabel fermeLogin;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JLabel lblMessage;
    private javax.swing.JLabel lblMotPassU;
    private javax.swing.JLabel lblNomU;
    private javax.swing.JPasswordField txtMotPassU;
    private javax.swing.JTextField txtNomU;
    // End of variables declaration//GEN-END:variables
}
