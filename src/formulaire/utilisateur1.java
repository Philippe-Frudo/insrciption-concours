
package formulaire;

import classes.Utilisateur;
import gestion.GestionUtilisateur;
import java.sql.ResultSet;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.ButtonGroup;
import javax.swing.JOptionPane;
import javax.swing.plaf.basic.BasicInternalFrameUI;
import javax.swing.table.DefaultTableModel;

/**
 * @author MSI
 */
public class utilisateur1 extends javax.swing.JInternalFrame {

    public GestionUtilisateur gtU;
    public Utilisateur user;
    
    /**
     * Creates new form utilisateur1
     */
    public utilisateur1() throws Exception {
        BasicInternalFrameUI ui= (BasicInternalFrameUI)this.getUI();
        ui.setNorthPane(null);
        
        gtU = new GestionUtilisateur();

        
        initComponents();
        
        ButtonGroup GpSexe = new ButtonGroup();
        GpSexe.add(sexeM);
        GpSexe.add(sexeF);
        sexeF.setSelected(true);
        
        
        //Appeler la methode ChargeListe()
        ChargerListe();
    }

            
    //EFFACER TOUS LES CHAMPS TEXT
    public void effacerChamps(){
        txtID_u.setText("");
        txtNom_u.setText("");
        txtAdrs_u.setText("");
        txtEmail_u.setText("");
        txtTel_u.setText("");
        txtPass_u.setText("");
    }
    
    //Affichage de liste de candidat dans une table
    private void ChargerListe(){
        String titre[] = {"ID", "Nom", "Sexe", "Email", "Telephone", "Adresse"};
        Object enreg[][] = new Object[1][1];
        
        try {
            int nbr = gtU.countEnreg();
            lblNbrUtil.setText( String.valueOf(nbr) );
            enreg = new Object[nbr][titre.length];
            
            ResultSet rs1 = gtU.getAll(); 
            int i = 0;
            while( rs1.next() ){
                enreg[i][0] = (Object) rs1.getString("idA");
                enreg[i][1] = (Object) rs1.getString("nomA");
                enreg[i][2] = (Object) rs1.getString("sexeA");
                enreg[i][3] = (Object) rs1.getString("emailA");
                enreg[i][4] = (Object) rs1.getString("telA");
                enreg[i][5] = (Object) rs1.getString("adrsA");
                i++;  
            }
        } catch (Exception e) {
            System.out.println("Erreur Chargement ");
            e.printStackTrace();
        }
        table_u.setModel( new DefaultTableModel(enreg, titre) );
        jScrollPane1.setViewportView(table_u);  
    }
    
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel5 = new javax.swing.JLabel();
        sexeF = new javax.swing.JRadioButton();
        jLabel6 = new javax.swing.JLabel();
        sexeM = new javax.swing.JRadioButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        table_u = new javax.swing.JTable();
        btnAnuler = new javax.swing.JButton();
        btnModify = new javax.swing.JButton();
        btnAdd_u = new javax.swing.JButton();
        jPanel1 = new javax.swing.JPanel();
        jLabel8 = new javax.swing.JLabel();
        btnDelete_u = new javax.swing.JButton();
        jLabel7 = new javax.swing.JLabel();
        txtID_u = new javax.swing.JTextField();
        txtNom_u = new javax.swing.JTextField();
        jLabel1 = new javax.swing.JLabel();
        txtEmail_u = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        txtAdrs_u = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        txtTel_u = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        txtPass_u = new javax.swing.JPasswordField();
        lblNbrUtil = new javax.swing.JLabel();
        jPanel2 = new javax.swing.JPanel();

        setBackground(new java.awt.Color(255, 255, 255));
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel5.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jLabel5.setText("Adresse:");
        getContentPane().add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(26, 294, 101, 37));

        sexeF.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        sexeF.setText("Feminin");
        getContentPane().add(sexeF, new org.netbeans.lib.awtextra.AbsoluteConstraints(131, 210, -1, -1));

        jLabel6.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jLabel6.setText("ID:");
        getContentPane().add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(26, 112, 101, 37));

        sexeM.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        sexeM.setText("Masculain");
        getContentPane().add(sexeM, new org.netbeans.lib.awtextra.AbsoluteConstraints(282, 210, -1, -1));

        table_u.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        table_u.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "ID", "Nom", "Prenom", "Sexe", "Adresse", "Email", "Telephone"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.Integer.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }
        });
        table_u.setRowHeight(30);
        table_u.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                table_uMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(table_u);

        getContentPane().add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(490, 110, 940, 310));

        btnAnuler.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        btnAnuler.setText("Annuler");
        btnAnuler.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAnulerActionPerformed(evt);
            }
        });
        getContentPane().add(btnAnuler, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 530, 129, 38));

        btnModify.setBackground(new java.awt.Color(255, 255, 255));
        btnModify.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        btnModify.setText("Modifier");
        btnModify.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnModifyActionPerformed(evt);
            }
        });
        getContentPane().add(btnModify, new org.netbeans.lib.awtextra.AbsoluteConstraints(248, 478, 129, 38));

        btnAdd_u.setBackground(new java.awt.Color(51, 102, 255));
        btnAdd_u.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        btnAdd_u.setForeground(new java.awt.Color(255, 255, 255));
        btnAdd_u.setText("Ajout");
        btnAdd_u.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAdd_uActionPerformed(evt);
            }
        });
        getContentPane().add(btnAdd_u, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 480, 129, 38));

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));

        jLabel8.setBackground(new java.awt.Color(255, 255, 255));
        jLabel8.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N
        jLabel8.setText("  Utilisateur");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addComponent(jLabel8, javax.swing.GroupLayout.PREFERRED_SIZE, 455, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 1216, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLabel8, javax.swing.GroupLayout.DEFAULT_SIZE, 56, Short.MAX_VALUE)
        );

        getContentPane().add(jPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, -1, -1));

        btnDelete_u.setBackground(new java.awt.Color(255, 51, 51));
        btnDelete_u.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        btnDelete_u.setForeground(new java.awt.Color(255, 255, 255));
        btnDelete_u.setText("Suprimer");
        btnDelete_u.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnDelete_uActionPerformed(evt);
            }
        });
        getContentPane().add(btnDelete_u, new org.netbeans.lib.awtextra.AbsoluteConstraints(248, 527, 129, 38));

        jLabel7.setText("Sexe");
        getContentPane().add(jLabel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(26, 205, 101, 34));

        txtID_u.setEnabled(false);
        getContentPane().add(txtID_u, new org.netbeans.lib.awtextra.AbsoluteConstraints(131, 113, 274, 37));
        getContentPane().add(txtNom_u, new org.netbeans.lib.awtextra.AbsoluteConstraints(131, 162, 274, 37));

        jLabel1.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jLabel1.setText("Nom:");
        getContentPane().add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(26, 161, 101, 37));
        getContentPane().add(txtEmail_u, new org.netbeans.lib.awtextra.AbsoluteConstraints(131, 246, 274, 37));

        jLabel2.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jLabel2.setText("Email:");
        getContentPane().add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(26, 245, 101, 37));
        getContentPane().add(txtAdrs_u, new org.netbeans.lib.awtextra.AbsoluteConstraints(131, 295, 274, 37));

        jLabel3.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jLabel3.setText("Telephone:");
        getContentPane().add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(26, 343, 101, 37));

        txtTel_u.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseReleased(java.awt.event.MouseEvent evt) {
                txtTel_uMouseReleased(evt);
            }
        });
        txtTel_u.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txtTel_uKeyReleased(evt);
            }
        });
        getContentPane().add(txtTel_u, new org.netbeans.lib.awtextra.AbsoluteConstraints(131, 344, 274, 37));

        jLabel4.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jLabel4.setText("Mode de passe:");
        getContentPane().add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(26, 392, 101, 37));
        getContentPane().add(txtPass_u, new org.netbeans.lib.awtextra.AbsoluteConstraints(130, 390, 270, 40));

        lblNbrUtil.setText("jLabel9");
        getContentPane().add(lblNbrUtil, new org.netbeans.lib.awtextra.AbsoluteConstraints(1060, 80, 130, 30));

        jPanel2.setBackground(new java.awt.Color(255, 255, 255));
        jPanel2.setLayout(new java.awt.CardLayout());
        getContentPane().add(jPanel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(-10, -30, 1640, 980));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnAdd_uActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAdd_uActionPerformed
        String id = txtID_u.getText();
        String nom = txtNom_u.getText();
        
        String sexe = null;
        if(sexeF.isSelected()){
            sexe = "F";
        }else if(sexeM.isSelected()){
            sexe = "M";
        }
        
        String adrs = txtAdrs_u.getText();
        String email = txtEmail_u.getText();
        String tel = txtTel_u.getText();
        String pass = txtPass_u.getText();
        
        if (nom.equals("") || email.equals("") || adrs.equals("") || tel.equals("") || pass.equals("") ) {
            JOptionPane.showMessageDialog(null, "Erreur de l'enregistrement ");
            
        } else {
            
            try {
                user = new Utilisateur(nom, email, pass, tel, adrs, sexe);
                gtU.insert(user);
                
                JOptionPane.showConfirmDialog(null, "Enregistrement reussi");
                ChargerListe();
                
            } catch (Exception ex) {
                Logger.getLogger(utilisateur1.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }//GEN-LAST:event_btnAdd_uActionPerformed

    private void btnModifyActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnModifyActionPerformed
        String id = txtID_u.getText();
        String nom = txtNom_u.getText();
        
        String sexe = null;
        if(sexeF.isSelected()){
            sexe = "F";
        }else if(sexeM.isSelected()){
            sexe = "M";
        }
        
        String adrs = txtAdrs_u.getText();
        String email = txtEmail_u.getText();
        String tel = txtTel_u.getText();
        String pass = txtPass_u.getText();
        
        if (id.equals("") || nom.equals("") || email.equals("") || adrs.equals("") || tel.equals("") || pass.equals("") ) {
            JOptionPane.showConfirmDialog(null, "Erreur de la modification ");
            
        } else {           
            try {
                user = new Utilisateur(nom, email, pass, tel, adrs, sexe);
                gtU.update(Integer.parseInt(id), user);
                
                JOptionPane.showConfirmDialog(null, "Modification reussi");
                ChargerListe();
                
            } catch (Exception ex) {
                Logger.getLogger(utilisateur1.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }//GEN-LAST:event_btnModifyActionPerformed

    private void btnDelete_uActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnDelete_uActionPerformed
        String id = txtID_u.getText();
        String nom = txtNom_u.getText();
        
         if(id.equals("") ) {
             JOptionPane.showMessageDialog(null, "Selectionner une ligne de tableau");
         }else if (JOptionPane.showConfirmDialog( null , "Supression reussii !! '"+nom+"' ", 
                 "Suppression" ,JOptionPane.YES_NO_OPTION ) == JOptionPane.OK_OPTION   
         ){
            try {        
                 gtU.delete( Integer.parseInt(id) );
                 JOptionPane.showMessageDialog(txtNom_u, "Supression reussii !!");
                 effacerChamps();
                 ChargerListe();
                 //conn.close();
                 
             } catch (Exception e) {
                 e.printStackTrace();
             }
         }else{
            JOptionPane.showMessageDialog(null, " Supression annuler !!");      
        }
    }//GEN-LAST:event_btnDelete_uActionPerformed

    private void btnAnulerActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAnulerActionPerformed
        btnAdd_u.setVisible(true);
        effacerChamps();
        ChargerListe();
    }//GEN-LAST:event_btnAnulerActionPerformed

    private void table_uMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_table_uMouseClicked
        btnAdd_u.setVisible(false);

        int ligne = table_u.getSelectedRow();
        int id =  Integer.parseInt(table_u.getValueAt(ligne, 0).toString() );
        txtID_u.setText(String.valueOf(table_u.getValueAt(ligne, 0)));
        txtNom_u.setText(String.valueOf(table_u.getValueAt(ligne, 1)));
        
        String sexe = String.valueOf( table_u.getValueAt(ligne, 2) );
        if( sexe.equals("F")){
            sexeF.setSelected(true);
            sexeM.setSelected(false);
        }else{
            sexeF.setSelected(false);
            sexeM.setSelected(true);
        }
        txtEmail_u.setText(String.valueOf(table_u.getValueAt(ligne, 3)));
        txtTel_u.setText(String.valueOf(table_u.getValueAt(ligne, 4)));
        txtAdrs_u.setText(String.valueOf(table_u.getValueAt(ligne, 5)));
    }//GEN-LAST:event_table_uMouseClicked

    private void txtTel_uMouseReleased(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_txtTel_uMouseReleased

    }//GEN-LAST:event_txtTel_uMouseReleased

    private void txtTel_uKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtTel_uKeyReleased
        // TODO add your handling code here:
    }//GEN-LAST:event_txtTel_uKeyReleased

   

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnAdd_u;
    private javax.swing.JButton btnAnuler;
    private javax.swing.JButton btnDelete_u;
    private javax.swing.JButton btnModify;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JLabel lblNbrUtil;
    private javax.swing.JRadioButton sexeF;
    private javax.swing.JRadioButton sexeM;
    private javax.swing.JTable table_u;
    private javax.swing.JTextField txtAdrs_u;
    private javax.swing.JTextField txtEmail_u;
    private javax.swing.JTextField txtID_u;
    private javax.swing.JTextField txtNom_u;
    private javax.swing.JPasswordField txtPass_u;
    private javax.swing.JTextField txtTel_u;
    // End of variables declaration//GEN-END:variables


}
