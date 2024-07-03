
package formulaire;

import classes.LieuExam;
import classes.Mention;
import gestion.GestionLieuExam;
import gestion.GestionMention;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import javax.swing.JOptionPane;
import javax.swing.plaf.basic.BasicInternalFrameUI;
import javax.swing.table.DefaultTableModel;

/**
 * @author MSI
 */
public class mentionEtLieuExamen1 extends javax.swing.JInternalFrame {

    public Connection conn;
    public Statement stat;
    
    public GestionLieuExam gtLE;
    public GestionMention gtM;
    public Mention mention;
    public LieuExam LE;
    
    public mentionEtLieuExamen1() throws Exception {
        BasicInternalFrameUI ui= (BasicInternalFrameUI)this.getUI();
        ui.setNorthPane(null);
        gtM = new GestionMention();
        gtLE = new GestionLieuExam();
        
        initComponents();
        
        //effacerChampsLE();
        ChargerListLE();
        
        //effacerChampsMention(); 
        ChargerListMention();
        
        if(txtIdLieu.equals("") ){
            btnModifier.setVisible(false);
        }else{
             btnModifier.setVisible(true);
        }
    }

    //*********************LIEU D'EXAMANET************************
    
    //EFFACER TOUS LES CHAMPS TEXT LIEU EXAMEN
    public void effacerChampsLE(){
        txtIdLieu.setText("");
        txtLieu.setText("");
        //txtVille.setText("");
    }
    
    //Affichage de TOUS LES LIEU D'EXAMEN VALIDE dans un tableau
    public void ChargerListLE(){
        String titre[] = {"ID", "Lieu"};
        Object enreg[][] = new Object[1][1];
        
        try {
            int nbr = gtLE.countEnreg();
            lblNombreLE.setText( String.valueOf(nbr) );
            System.out.println(nbr);
            enreg = new Object[nbr][titre.length];
            
            ResultSet rs1 = gtLE.getAll();

            int i = 0;
            while( rs1.next() ){
                enreg[i][0] = (Object) rs1.getString("idLieu");
                enreg[i][1] = (Object) rs1.getString("lieu");
                //enreg[i][2] = (Object) rs1.getString("ville");
                i++;  
            }  
        } catch (Exception e) {
            e.printStackTrace();
        }
        tableLE.setModel( new DefaultTableModel(enreg, titre) );
        jScrollPane3.setViewportView(tableLE);
    }
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jLabel8 = new javax.swing.JLabel();
        jPanel2 = new javax.swing.JPanel();
        jPanel4 = new javax.swing.JPanel();
        btnSuppM = new javax.swing.JButton();
        btnAnnulerM = new javax.swing.JButton();
        jLabel7 = new javax.swing.JLabel();
        btnModifierM = new javax.swing.JButton();
        btnAjoutM = new javax.swing.JButton();
        txtIDMention = new javax.swing.JTextField();
        jScrollPane2 = new javax.swing.JScrollPane();
        tabMention = new javax.swing.JTable();
        txtCherchLieuM = new javax.swing.JTextField();
        txtnomMention = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        lblNombreM = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        jPanel3 = new javax.swing.JPanel();
        btnSupp = new javax.swing.JButton();
        btnAnnuler = new javax.swing.JButton();
        jLabel6 = new javax.swing.JLabel();
        btnModifier = new javax.swing.JButton();
        btnAjouter = new javax.swing.JButton();
        txtIdLieu = new javax.swing.JTextField();
        txtCherchLieu = new javax.swing.JTextField();
        txtLieu = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        lblNombreLE = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jScrollPane3 = new javax.swing.JScrollPane();
        tableLE = new javax.swing.JTable();
        jLabel9 = new javax.swing.JLabel();

        setBackground(new java.awt.Color(255, 255, 255));
        setBorder(null);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));
        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel8.setFont(new java.awt.Font("Segoe UI Semilight", 1, 24)); // NOI18N
        jLabel8.setForeground(new java.awt.Color(1, 1, 1));
        jLabel8.setText("Gestion Mention et Lieu d'examen");
        jPanel1.add(jLabel8, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 0, 445, 56));

        getContentPane().add(jPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 2133, -1));

        jPanel2.setBackground(new java.awt.Color(255, 255, 255));
        jPanel2.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel4.setBackground(new java.awt.Color(255, 255, 255));
        jPanel4.setBorder(javax.swing.BorderFactory.createEtchedBorder(java.awt.Color.lightGray, null));
        jPanel4.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        btnSuppM.setBackground(new java.awt.Color(255, 6, 6));
        btnSuppM.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        btnSuppM.setText("Suprimer");
        btnSuppM.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSuppMActionPerformed(evt);
            }
        });
        jPanel4.add(btnSuppM, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 610, 129, 38));

        btnAnnulerM.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        btnAnnulerM.setText("Annuler");
        btnAnnulerM.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAnnulerMActionPerformed(evt);
            }
        });
        jPanel4.add(btnAnnulerM, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 670, 129, 38));

        jLabel7.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jLabel7.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        jLabel7.setText("ID:");
        jLabel7.setVerticalAlignment(javax.swing.SwingConstants.BOTTOM);
        jPanel4.add(jLabel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 440, 60, 20));

        btnModifierM.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        btnModifierM.setText("Modifier");
        btnModifierM.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnModifierMActionPerformed(evt);
            }
        });
        jPanel4.add(btnModifierM, new org.netbeans.lib.awtextra.AbsoluteConstraints(210, 670, 129, 38));

        btnAjoutM.setBackground(new java.awt.Color(38, 54, 212));
        btnAjoutM.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        btnAjoutM.setForeground(new java.awt.Color(255, 255, 255));
        btnAjoutM.setText("Ajout");
        btnAjoutM.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAjoutMActionPerformed(evt);
            }
        });
        jPanel4.add(btnAjoutM, new org.netbeans.lib.awtextra.AbsoluteConstraints(210, 610, 129, 38));

        txtIDMention.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        txtIDMention.setDisabledTextColor(new java.awt.Color(255, 255, 255));
        txtIDMention.setEnabled(false);
        jPanel4.add(txtIDMention, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 460, 320, 37));

        tabMention.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        tabMention.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "ID", "Lieu"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.Integer.class, java.lang.String.class
            };
            boolean[] canEdit = new boolean [] {
                false, false
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        tabMention.setRowHeight(30);
        tabMention.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tabMentionMouseClicked(evt);
            }
        });
        jScrollPane2.setViewportView(tabMention);
        if (tabMention.getColumnModel().getColumnCount() > 0) {
            tabMention.getColumnModel().getColumn(0).setResizable(false);
            tabMention.getColumnModel().getColumn(1).setResizable(false);
        }

        jPanel4.add(jScrollPane2, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 120, 370, 260));

        txtCherchLieuM.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                txtCherchLieuMKeyPressed(evt);
            }
        });
        jPanel4.add(txtCherchLieuM, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 90, 260, 30));

        txtnomMention.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jPanel4.add(txtnomMention, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 540, 320, 37));

        jLabel3.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jLabel3.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        jLabel3.setText("Mention:");
        jLabel3.setVerticalAlignment(javax.swing.SwingConstants.BOTTOM);
        jPanel4.add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 520, 60, 20));

        lblNombreM.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        lblNombreM.setVerticalAlignment(javax.swing.SwingConstants.BOTTOM);
        jPanel4.add(lblNombreM, new org.netbeans.lib.awtextra.AbsoluteConstraints(100, 380, 103, 20));

        jLabel5.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jLabel5.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        jLabel5.setText("Nombre total:");
        jLabel5.setVerticalAlignment(javax.swing.SwingConstants.BOTTOM);
        jPanel4.add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 380, 80, 20));

        jLabel1.setBackground(new java.awt.Color(56, 68, 249));
        jLabel1.setFont(jLabel1.getFont().deriveFont(jLabel1.getFont().getSize()+7f));
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setText("Mention");
        jPanel4.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 660, 40));

        jPanel2.add(jPanel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 10, 660, 820));

        jPanel3.setBackground(new java.awt.Color(255, 255, 255));
        jPanel3.setBorder(javax.swing.BorderFactory.createEtchedBorder(java.awt.Color.lightGray, null));
        jPanel3.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jPanel3.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        btnSupp.setBackground(new java.awt.Color(255, 0, 0));
        btnSupp.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        btnSupp.setText("Suprimer");
        btnSupp.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSuppActionPerformed(evt);
            }
        });
        jPanel3.add(btnSupp, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 590, 129, 38));

        btnAnnuler.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        btnAnnuler.setText("Annuler");
        btnAnnuler.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAnnulerActionPerformed(evt);
            }
        });
        jPanel3.add(btnAnnuler, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 660, 129, 38));

        jLabel6.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jLabel6.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        jLabel6.setText("ID:");
        jLabel6.setVerticalAlignment(javax.swing.SwingConstants.BOTTOM);
        jPanel3.add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 420, 60, 20));

        btnModifier.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        btnModifier.setText("Modifier");
        btnModifier.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnModifierActionPerformed(evt);
            }
        });
        jPanel3.add(btnModifier, new org.netbeans.lib.awtextra.AbsoluteConstraints(180, 660, 129, 38));

        btnAjouter.setBackground(new java.awt.Color(38, 54, 212));
        btnAjouter.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        btnAjouter.setForeground(new java.awt.Color(255, 255, 255));
        btnAjouter.setText("Ajout");
        btnAjouter.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAjouterActionPerformed(evt);
            }
        });
        jPanel3.add(btnAjouter, new org.netbeans.lib.awtextra.AbsoluteConstraints(180, 590, 129, 38));

        txtIdLieu.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        txtIdLieu.setEnabled(false);
        jPanel3.add(txtIdLieu, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 440, 280, 37));

        txtCherchLieu.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                txtCherchLieuKeyPressed(evt);
            }
        });
        jPanel3.add(txtCherchLieu, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 80, 250, 30));

        txtLieu.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jPanel3.add(txtLieu, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 510, 280, 37));

        jLabel2.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jLabel2.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        jLabel2.setText("Adresse:");
        jLabel2.setVerticalAlignment(javax.swing.SwingConstants.BOTTOM);
        jPanel3.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 490, 60, 20));

        lblNombreLE.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        lblNombreLE.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        lblNombreLE.setVerticalAlignment(javax.swing.SwingConstants.BOTTOM);
        jPanel3.add(lblNombreLE, new org.netbeans.lib.awtextra.AbsoluteConstraints(100, 370, 110, 20));

        jLabel4.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jLabel4.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        jLabel4.setText("Nombre total:");
        jLabel4.setVerticalAlignment(javax.swing.SwingConstants.BOTTOM);
        jPanel3.add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 370, 80, 20));

        tableLE.setFont(new java.awt.Font("SansSerif", 0, 12)); // NOI18N
        tableLE.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Title 1", "Title 2"
            }
        ));
        tableLE.setRowHeight(30);
        tableLE.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tableLEMouseClicked(evt);
            }
        });
        jScrollPane3.setViewportView(tableLE);
        tableLE.getAccessibleContext().setAccessibleDescription("");

        jPanel3.add(jScrollPane3, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 110, 510, 260));

        jLabel9.setBackground(new java.awt.Color(56, 68, 249));
        jLabel9.setFont(jLabel9.getFont().deriveFont(jLabel9.getFont().getSize()+7f));
        jLabel9.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel9.setText("Lieu d'Examen");
        jPanel3.add(jLabel9, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 750, 40));

        jPanel2.add(jPanel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(730, 10, 750, 820));

        getContentPane().add(jPanel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 50, 1650, 880));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnAjouterActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAjouterActionPerformed
        String valLieu, id;
        id = txtIdLieu.getText();
        valLieu = txtLieu.getText();
        if(id.equals("")){
            try {
                LE = new LieuExam(valLieu);
                gtLE.insert(LE);

                JOptionPane.showMessageDialog(null, "Enregistrement reussi");
                effacerChampsLE();
                ChargerListLE();

            } catch (Exception e) {
                e.printStackTrace();
            }    
        }else{
            JOptionPane.showMessageDialog(null, "Cette enregistrement existe");
        }
    }//GEN-LAST:event_btnAjouterActionPerformed

    private void btnModifierActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnModifierActionPerformed
        String id, valLieu;
        id = txtIdLieu.getText();
        valLieu = txtLieu.getText();
        //ville = txtVille;
         if(!id.equals("")){
            if(JOptionPane.showConfirmDialog( null , "Confirmez-vous la modification !! ", 
                 "Modification" ,JOptionPane.YES_NO_OPTION ) == JOptionPane.OK_OPTION){
                try {
                   LE = new LieuExam(Integer.parseInt(id), valLieu);
                   gtLE.update( LE);

                   JOptionPane.showMessageDialog(null, "Enregistrement reussi");
                   effacerChampsLE();
                   ChargerListLE();
                   conn.close();
               } catch (Exception e) {
                   e.printStackTrace();
               }
                 
            }else{
                JOptionPane.showMessageDialog(null, "Modification annule");
            }
 
        }else{
            JOptionPane.showMessageDialog(null, "Verifier l'identifiant de cette ville");
        }
        
    }//GEN-LAST:event_btnModifierActionPerformed

    private void btnSuppActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSuppActionPerformed
        String id = txtIdLieu.getText();
        if(JOptionPane.showConfirmDialog( null , "Confirmez-vous la suppression !! ", 
                 "Suppression" ,JOptionPane.YES_NO_OPTION ) == JOptionPane.OK_OPTION   ){
            try {
                gtLE = new GestionLieuExam();
                
                gtLE.delete( Integer.parseInt(id) );

                JOptionPane.showMessageDialog(null, "Enregistrement supprement");
                effacerChampsLE();
                ChargerListLE();
                conn.close();

            } catch (Exception e) {
                e.printStackTrace();
            }
        }else{
            JOptionPane.showMessageDialog(null, "Suppression annule");
        }
    }//GEN-LAST:event_btnSuppActionPerformed

    private void btnAnnulerActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAnnulerActionPerformed
        ChargerListLE();
        effacerChampsLE();
    }//GEN-LAST:event_btnAnnulerActionPerformed

    private void txtCherchLieuKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtCherchLieuKeyPressed
        String rech = txtCherchLieu.getText();
        if (rech.equals("")) {
            ChargerListLE();
        } else {
            String titre[] = {"ID", "Lieu"};
            Object enreg[][] = new Object[1][1];

            try {  
                int nbr = gtLE.countEnreg();
                lblNombreLE.setText( String.valueOf(nbr) );

                enreg = new Object[nbr][titre.length];

                //Reponse de la requete cherche
                ResultSet rs1 = gtLE.getByNom(rech);

                int i = 0;
                while(rs1.next()){
                    enreg[i][0] = (Object) rs1.getString("idLieu");
                    enreg[i][1] = (Object) rs1.getString("lieu");
                    i++;  
                }

            } catch (Exception e) {
                e.printStackTrace();
            }
            tableLE.setModel( new DefaultTableModel(enreg, titre) );
            jScrollPane3.setViewportView(tableLE);
        }
        
        
    }//GEN-LAST:event_txtCherchLieuKeyPressed


    //****************************MENTION******************************
    
    //EFFACER TOUS LES CHAMPS MENTION
    public void effacerChampsMention(){
        txtIDMention.setText("");
        txtnomMention.setText("");
    }
    
    //Affichage de TOUS LES LIEU D'EXAMEN VALIDE dans un tableau
    public void ChargerListMention(){
        String titre[] = {"Mention"};
        Object enregM[][] = new Object[1][1];
   
        try {
            int nbr = gtM.countEnreg();
            lblNombreM.setText( String.valueOf(nbr) );
            enregM = new Object[nbr][titre.length];

            ResultSet rs1 = gtM.getAll();

            int i = 0;
            while(rs1.next()){
                enregM[i][0] = (Object) rs1.getString("nomM");
                i++;  
            } 
        } catch (Exception e) {
            e.printStackTrace();
        }
        tabMention.setModel( new DefaultTableModel(enregM, titre) );
        jScrollPane2.setViewportView(tabMention);
    }
    
    
    private void btnSuppMActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSuppMActionPerformed
        
        String id = txtIDMention.getText();
        if(!id.equals("")){
            if(JOptionPane.showConfirmDialog( null , "Confirmez-vous la suppression !! ", 
                     "Suppression" ,JOptionPane.YES_NO_OPTION ) == JOptionPane.OK_OPTION   ){
                try {
                    gtM = new GestionMention();

                    gtM.delete( id );

                    JOptionPane.showMessageDialog(null, "Enregistrement supprement");
                    effacerChampsMention();
                    ChargerListMention();
                    conn.close();

                } catch (Exception e) {
                    e.printStackTrace();
                }

            }else{
                JOptionPane.showMessageDialog(null, "Suppression annule");
            }
            
        }else{
            JOptionPane.showMessageDialog(null, "Suppression annule");
        }
    }//GEN-LAST:event_btnSuppMActionPerformed

    private void btnAnnulerMActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAnnulerMActionPerformed
        ChargerListMention();
        effacerChampsMention();
    }//GEN-LAST:event_btnAnnulerMActionPerformed

    private void btnModifierMActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnModifierMActionPerformed
        String id, valMention;
        id = txtIdLieu.getText();
        valMention = txtLieu.getText();
         if(!id.equals("")){
            if(JOptionPane.showConfirmDialog( null , "Confirmez-vous la modification !! ", 
                 "Modification" ,JOptionPane.YES_NO_OPTION ) == JOptionPane.OK_OPTION){
                try {
                   mention = new Mention(valMention);
                   gtM.update( mention );

                   JOptionPane.showMessageDialog(null, "Modification reussi");
                   effacerChampsMention();
                   ChargerListMention();
                   //conn.close();
                   
               } catch (Exception e) {
                   e.printStackTrace();
               }
                 
            }else{
                JOptionPane.showMessageDialog(null, "Modification annule");
            }
 
        }else{
            JOptionPane.showMessageDialog(null, "Verifier l'identifiant de mention");
        }
    }//GEN-LAST:event_btnModifierMActionPerformed

    private void btnAjoutMActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAjoutMActionPerformed
        String valnomM = txtnomMention.getText();

        if(!valnomM.equals("")){
            try {
                mention = new Mention(valnomM);
                gtM.insert(mention);

                JOptionPane.showMessageDialog(null, "Enregistrement reussi");
                effacerChampsMention();
                ChargerListMention();

            } catch (Exception e) {
                e.printStackTrace();
            }    
        }else{
            JOptionPane.showMessageDialog(null, "Cette enregistrement existe");
        }
    }//GEN-LAST:event_btnAjoutMActionPerformed

    private void tabMentionMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tabMentionMouseClicked
        int ligne = tabMention.getSelectedRow();
        txtnomMention.setText(String.valueOf(tabMention.getValueAt(ligne, 0)));
    }//GEN-LAST:event_tabMentionMouseClicked

    private void txtCherchLieuMKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtCherchLieuMKeyPressed
         String rech = txtCherchLieuM.getText();
         if (rech.equals("")) {
            
        } else {
            String titre[] = {"Mention"};
            Object enreg[][] = new Object[1][1];
            try {  
                int nbr = gtM.countEnreg();
                lblNombreM.setText( String.valueOf(nbr) );
                enreg = new Object[nbr][titre.length];

                //Reponse de la requete cherche
                ResultSet rs1 = gtM.getByNom(rech);
                int i = 0;
                while(rs1.next()){
                    enreg[i][0] = (Object) rs1.getString("nomM");
                    i++;  
                } 
            } catch (Exception e) {
                e.printStackTrace();
            }
            tabMention.setModel( new DefaultTableModel(enreg, titre) );
            jScrollPane2.setViewportView(tabMention);
        }
      
    }//GEN-LAST:event_txtCherchLieuMKeyPressed

    
    //Lieu Exament
    private void tableLEMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tableLEMouseClicked
        int ligne = tableLE.getSelectedRow();
        txtIdLieu.setText(String.valueOf(tableLE.getValueAt(ligne, 0)));
        txtLieu.setText(String.valueOf(tableLE.getValueAt(ligne, 1)));
    }//GEN-LAST:event_tableLEMouseClicked


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnAjoutM;
    private javax.swing.JButton btnAjouter;
    private javax.swing.JButton btnAnnuler;
    private javax.swing.JButton btnAnnulerM;
    private javax.swing.JButton btnModifier;
    private javax.swing.JButton btnModifierM;
    private javax.swing.JButton btnSupp;
    private javax.swing.JButton btnSuppM;
    private javax.swing.JLabel jLabel1;
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
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JLabel lblNombreLE;
    private javax.swing.JLabel lblNombreM;
    private javax.swing.JTable tabMention;
    private javax.swing.JTable tableLE;
    private javax.swing.JTextField txtCherchLieu;
    private javax.swing.JTextField txtCherchLieuM;
    private javax.swing.JTextField txtIDMention;
    private javax.swing.JTextField txtIdLieu;
    private javax.swing.JTextField txtLieu;
    private javax.swing.JTextField txtnomMention;
    // End of variables declaration//GEN-END:variables
}
