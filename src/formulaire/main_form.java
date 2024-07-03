
package formulaire;

import java.awt.Image;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JOptionPane;


public class main_form extends javax.swing.JFrame {

    /**
     * Creates new form main_form
     */
    public main_form() throws Exception {
        initComponents();
        this.DesktopPane.removeAll();
        this.DesktopPane.repaint();
        dashbord dash = new dashbord();
        this.DesktopPane.add(dash);
        dash.show();
        
        lieuExam.setVisible(false);
        gestionParcoursEtExam.setVisible(false);
        
        // new ImageIcon( "C:\\Users\\MSI\\Documents\\NetBeansProjects\\InscriptionConcoursEMIT2.0\\src\\image\\versement_cand\\"+rs1.getString("recuVers") )
        
         setImage();
    }
    
    public ImageIcon ResizeIMG(String imagePath, JLabel Image_lbl_contain){
        ImageIcon myImage = new ImageIcon(imagePath);
        Image imge = myImage.getImage();
        Image newImage = imge.getScaledInstance(Image_lbl_contain.getWidth(), Image_lbl_contain.getHeight(), Image.SCALE_SMOOTH);
        ImageIcon image = new ImageIcon(newImage);
        return image;
    }

   public void setImage(){
       //logoEMIT.setIcon(  ResizeIMG("file:/C:/Users/MSI/Documents/NetBeansProjects/inscriptionConcoursEMIT2.0/src/icones/logoEMIT.jpg", logoEMIT) );
   }
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        btnDashbord = new javax.swing.JButton();
        inscription = new javax.swing.JButton();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        deconnexion = new javax.swing.JButton();
        elementParamaetre = new javax.swing.JPanel();
        lieuExam = new javax.swing.JButton();
        gestionParcoursEtExam = new javax.swing.JButton();
        parametre = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        logoEMIT = new javax.swing.JLabel();
        jPanel2 = new javax.swing.JPanel();
        DesktopPane = new javax.swing.JDesktopPane();
        jPanel3 = new javax.swing.JPanel();
        jLabel4 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setBackground(new java.awt.Color(255, 255, 255));
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel1.setBackground(new java.awt.Color(51, 51, 255));
        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        btnDashbord.setBackground(new java.awt.Color(255, 255, 255));
        btnDashbord.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        btnDashbord.setText("   Dashbord");
        btnDashbord.setAlignmentX(1.0F);
        btnDashbord.setBorder(null);
        btnDashbord.setBorderPainted(false);
        btnDashbord.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnDashbord.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        btnDashbord.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnDashbordActionPerformed(evt);
            }
        });
        jPanel1.add(btnDashbord, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 300, 250, 50));

        inscription.setBackground(new java.awt.Color(255, 255, 255));
        inscription.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        inscription.setText("   S'inscrire");
        inscription.setAlignmentX(1.0F);
        inscription.setBorder(null);
        inscription.setBorderPainted(false);
        inscription.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        inscription.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        inscription.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                inscriptionActionPerformed(evt);
            }
        });
        jPanel1.add(inscription, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 350, 250, 50));

        jLabel2.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel2.setForeground(java.awt.Color.white);
        jLabel2.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel2.setText(" Ecole Management ");
        jPanel1.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 70, 226, 30));

        jLabel3.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel3.setForeground(java.awt.Color.white);
        jLabel3.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel3.setText("d'Innovation Technologique");
        jPanel1.add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 100, 226, 32));

        deconnexion.setBackground(new java.awt.Color(255, 84, 84));
        deconnexion.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        deconnexion.setForeground(new java.awt.Color(255, 255, 255));
        deconnexion.setText("Deconnexion");
        deconnexion.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        deconnexion.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                deconnexionActionPerformed(evt);
            }
        });
        jPanel1.add(deconnexion, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 930, 250, 50));

        elementParamaetre.setBackground(new java.awt.Color(51, 51, 255));
        elementParamaetre.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseExited(java.awt.event.MouseEvent evt) {
                elementParamaetreMouseExited(evt);
            }
        });
        elementParamaetre.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        lieuExam.setBackground(new java.awt.Color(255, 255, 255));
        lieuExam.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        lieuExam.setText("   Lieu Examen");
        lieuExam.setAlignmentX(1.0F);
        lieuExam.setBorder(null);
        lieuExam.setBorderPainted(false);
        lieuExam.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        lieuExam.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        lieuExam.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                lieuExamMouseEntered(evt);
            }
        });
        lieuExam.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                lieuExamActionPerformed(evt);
            }
        });
        elementParamaetre.add(lieuExam, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 47, 250, 50));

        gestionParcoursEtExam.setBackground(new java.awt.Color(255, 255, 255));
        gestionParcoursEtExam.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        gestionParcoursEtExam.setText("   Utilisateur");
        gestionParcoursEtExam.setAlignmentX(1.0F);
        gestionParcoursEtExam.setBorder(null);
        gestionParcoursEtExam.setBorderPainted(false);
        gestionParcoursEtExam.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        gestionParcoursEtExam.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        gestionParcoursEtExam.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                gestionParcoursEtExamMouseEntered(evt);
            }
        });
        gestionParcoursEtExam.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                gestionParcoursEtExamActionPerformed(evt);
            }
        });
        elementParamaetre.add(gestionParcoursEtExam, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 97, 250, 50));

        parametre.setBackground(new java.awt.Color(255, 255, 255));
        parametre.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        parametre.setText("   Parametre");
        parametre.setAlignmentX(1.0F);
        parametre.setBorder(null);
        parametre.setBorderPainted(false);
        parametre.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        parametre.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        parametre.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                parametreMouseClicked(evt);
            }
        });
        elementParamaetre.add(parametre, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 250, 50));

        jPanel1.add(elementParamaetre, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 400, 250, 150));

        jLabel1.setText("jLabel1");
        jPanel1.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 920, 40, 40));

        logoEMIT.setBackground(new java.awt.Color(255, 255, 255));
        logoEMIT.setFont(new java.awt.Font("Tahoma", 1, 48)); // NOI18N
        logoEMIT.setForeground(new java.awt.Color(255, 255, 255));
        logoEMIT.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        logoEMIT.setText("EMIT");
        logoEMIT.setMaximumSize(new java.awt.Dimension(180, 60));
        logoEMIT.setMinimumSize(new java.awt.Dimension(180, 60));
        jPanel1.add(logoEMIT, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 10, 230, 60));

        getContentPane().add(jPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 250, 990));

        jPanel2.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());
        getContentPane().add(jPanel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(257, 0, -1, -1));

        DesktopPane.setBackground(new java.awt.Color(255, 255, 255));
        DesktopPane.setBorder(javax.swing.BorderFactory.createEtchedBorder(java.awt.Color.black, null));
        DesktopPane.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N

        javax.swing.GroupLayout DesktopPaneLayout = new javax.swing.GroupLayout(DesktopPane);
        DesktopPane.setLayout(DesktopPaneLayout);
        DesktopPaneLayout.setHorizontalGroup(
            DesktopPaneLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 1636, Short.MAX_VALUE)
        );
        DesktopPaneLayout.setVerticalGroup(
            DesktopPaneLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 926, Short.MAX_VALUE)
        );

        getContentPane().add(DesktopPane, new org.netbeans.lib.awtextra.AbsoluteConstraints(247, 61, 1640, 930));

        jPanel3.setBackground(new java.awt.Color(255, 255, 255));
        jPanel3.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel4.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N
        jLabel4.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel4.setText("INSCRIPTION CONCOURS EMIT");
        jPanel3.add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(3, 0, 1550, 60));

        getContentPane().add(jPanel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(250, 0, 1630, 60));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnDashbordActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnDashbordActionPerformed
        this.DesktopPane.removeAll();
        this.DesktopPane.repaint();
        
        dashbord dash = null;
        try {
            dash = new dashbord();
            
            dash.nombreC();
            dash.nombreU();
        } catch (Exception ex) {
            Logger.getLogger(main_form.class.getName()).log(Level.SEVERE, null, ex);
        }
        this.DesktopPane.add(dash);
        dash.show();
    }//GEN-LAST:event_btnDashbordActionPerformed

    private void inscriptionActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_inscriptionActionPerformed
        this.DesktopPane.removeAll();
        this.DesktopPane.repaint();
        
        inscription1 inscription = null;
        try {
            inscription = new inscription1();
        } catch (Exception ex) {
            Logger.getLogger(main_form.class.getName()).log(Level.SEVERE, null, ex);
        }
        this.DesktopPane.add(inscription);
        inscription.show();
    }//GEN-LAST:event_inscriptionActionPerformed

    private void lieuExamActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_lieuExamActionPerformed
        
        this.DesktopPane.removeAll();
        this.DesktopPane.repaint();
        
        mentionEtLieuExamen1 mentionEtExam = null;
        try {
            mentionEtExam = new mentionEtLieuExamen1();
        } catch (Exception ex) {
            Logger.getLogger(main_form.class.getName()).log(Level.SEVERE, null, ex);
        }
        this.DesktopPane.add(mentionEtExam);
        mentionEtExam.show();
    }//GEN-LAST:event_lieuExamActionPerformed

    
    private void gestionParcoursEtExamActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_gestionParcoursEtExamActionPerformed
        this.DesktopPane.removeAll();
        this.DesktopPane.repaint();
                
        utilisateur1 utilisateur1 = null;
        try {
            utilisateur1 = new utilisateur1();
        } catch (Exception ex) {
            Logger.getLogger(main_form.class.getName()).log(Level.SEVERE, null, ex);
        }
        this.DesktopPane.add(utilisateur1);
        utilisateur1.show();
    }//GEN-LAST:event_gestionParcoursEtExamActionPerformed

    private void deconnexionActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_deconnexionActionPerformed
        if(JOptionPane.showConfirmDialog( null , "Vous-allez deconnecte", 
          "Deconnexion" ,JOptionPane.YES_NO_OPTION ) == JOptionPane.OK_OPTION )
        {
            this.dispose();
            try {
                login log = new login();
                log.setVisible(true);
            } catch (Exception ex) {
                Logger.getLogger(main_form.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        
        
    }//GEN-LAST:event_deconnexionActionPerformed

    private void elementParamaetreMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_elementParamaetreMouseExited
        lieuExam.setVisible(false);
        gestionParcoursEtExam.setVisible(false);
    }//GEN-LAST:event_elementParamaetreMouseExited

    private void lieuExamMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lieuExamMouseEntered
        lieuExam.setVisible(true);
        gestionParcoursEtExam.setVisible(true);
    }//GEN-LAST:event_lieuExamMouseEntered

    private void gestionParcoursEtExamMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_gestionParcoursEtExamMouseEntered
        lieuExam.setVisible(true);
        gestionParcoursEtExam.setVisible(true);
    }//GEN-LAST:event_gestionParcoursEtExamMouseEntered

    private void parametreMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_parametreMouseClicked
        //parametre
        lieuExam.setVisible(true);
        gestionParcoursEtExam.setVisible(true);
    }//GEN-LAST:event_parametreMouseClicked

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
            java.util.logging.Logger.getLogger(main_form.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(main_form.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(main_form.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(main_form.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    new main_form().setVisible(true);
                } catch (Exception ex) {
                    Logger.getLogger(main_form.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JDesktopPane DesktopPane;
    private javax.swing.JButton btnDashbord;
    private javax.swing.JButton deconnexion;
    private javax.swing.JPanel elementParamaetre;
    private javax.swing.JButton gestionParcoursEtExam;
    private javax.swing.JButton inscription;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JButton lieuExam;
    private javax.swing.JLabel logoEMIT;
    private javax.swing.JButton parametre;
    // End of variables declaration//GEN-END:variables
}
