
package formulaire;

import classes.Candidat;
import gestion.GestionCandidat;
import gestion.GestionLieuExam;
import gestion.GestionMention;
import java.awt.Font;
import java.awt.Image;
import java.awt.event.ContainerListener;
import java.awt.image.BufferedImage;
import static java.awt.image.ImageObserver.WIDTH;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.imageio.ImageIO;
import javax.swing.ButtonGroup;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JFileChooser;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.plaf.IconUIResource;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author MSI
 */
public class inscription1_Copy extends javax.swing.JInternalFrame {

    
    //VARIABLES
    public Connection conn;
    public Statement stat;
    
//    public static String tblMention[100];
//    public static String tblLieu[100];
    
    //URL image
    String pathVersement = null;
    String pathFiche = null;
    String pathDemande = null;
    String pathReleveOUDipl = null;
    String pathCopie = null;
    String pathPhoto = "";
    
    byte[] bytrecuVers = null; 
    byte[] bytfiche = null; 
    byte[] bytdemande = null; 
    byte[] bytreleveOuDiplome = null; 
    byte[] bytcopieAEC = null; 
    byte[] bytphotoC = null; 
    
   
    String valrecuVers = null;
    String valfiche = null;
    String valdemande = null;
    String valreleveOuDiplome = null;
    String valcopieAEC = null;
    String valphotoC = null;
    
    //Variable Content imge
    //JLabel lblVersementC, lblFiche, lblDemandeC, lblReleveC, lblCopieAEC, lblPhotoC;
    
    //Variable Pane
//    String imgVersementC;
//    String imgFiche;
//    String imgDemandeC;
//    String imgReleveC;
//    String imgCopieAEC;
//    String imgPhotoC;

    public inscription1_Copy() {
        initComponents();
        ButtonGroup GpSexe = new ButtonGroup();
        GpSexe.add(sexeM);
        GpSexe.add(sexeF);
        sexeF.setSelected(true);
        
//        lblPhotoC = new JLabel();
//        lblPhotoC.setBounds(520, 60, 150, 150);
//        lblPhotoC.setFont( new Font("Arial", Font.BOLD, 16) );
//        lblPhotoC.setBackground(new java.awt.Color(255, 0, 0));
//        lblPhotoC.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
//        lblPhotoC.setBorder( javax.swing.BorderFactory.createEtchedBorder() );
        
        //Appeler la methode ChargeListe()
        ChargerListe();
        
        //Appeler la methode listeDeroulantParcours()
        listeDeroulantParcours();
        
        //Appeler la methode qui affiche la liste d'examen
        listeDeroulantLieuExam();
    }
    
    //METHODE POUR TELECHARGEMENT
    public static String telechargeImage(String path, JLabel lbl, byte[] byt){
//        JFileChooser pic = new JFileChooser();
//        pic.showOpenDialog(null);
//        
//        File picture = pic.getSelectedFile();
//        
//        //Path
//        path = picture.getAbsolutePath();
//        System.out.println( " 931= "+path);
//        BufferedImage img;
//        
//        try {
//            img = ImageIO.read( pic.getSelectedFile() );
//            System.out.println( " 936= "+img);
//            ImageIcon imageIc = new ImageIcon( new ImageIcon(img).getImage().getScaledInstance(150, 150, Image.SCALE_DEFAULT) );
//            System.out.println( " 938= "+imageIc);
//            
//            //Labelle
//            lbl.setIcon(imageIc);
//            lbl.setText("");
//            File image = new File( path );
//            System.out.println( " 942= "+image);
//            
//            FileInputStream fis = new FileInputStream( image );
//            System.out.println( " 945= "+fis);
//            
//            ByteArrayOutputStream bos = new ByteArrayOutputStream();
//            byte[] buff = new byte[1024];
//            
//            for(int i; (i = fis.read(buff)) != -1; ){
//                bos.write(buff , 0, i ); 
//            }
//            
//            //Byte
//            byt = bos.toByteArray();
//            System.out.println( " 954= "+byt);
//            
//            System.out.println( " Succes= ");
//        } catch (Exception e) {
//            System.out.println("Erreur de telechargement");
//            e.printStackTrace();
//        }
        
        return path;
    }

    
    //EFFACER TOUS LES CHAMPS TEXT
    public void effacerChamps(){
        //"C:\\Users\\MSI\\Documents\\NetBeansProjects\\InscriptionConcoursEMIT\\src\\icones\default_Img.png"
        
        txtIDC.setText("");
        txtNomC.setText("");
        txtAdrsPC.setText("");
        txtPrenomC.setText("");
        txtDateNaisC.setText("");
        txtLieuNaisC.setText("");
        //sexe.setText("");
        txtSituationMatC.setSelectedIndex(0);
        txtNationalite.setSelectedIndex(0);
        txtAdrsPC.setText("");
        txtEmailC.setText("");
        txtTelC.setText("");
        txtNumInscriC.setText("");
        txtSerieC.setSelectedIndex(0);
        txtMentionBaccC.setSelectedIndex(0);
        
        imgCopie.setIcon(null);
        imgCopie.setText("Copie");
        
        imgDemande.setIcon(null);
        imgDemande.setText("Demande");
        
        imgFicheC.setIcon(null);
        imgFicheC.setText("Fiche");
        
        imgPhoto.setIcon(null);
        imgPhoto.setText("Photo");
        
        imgReleve.setIcon(null);
        imgReleve.setText("Releve");
        
        imgVersement.setIcon(null);
        imgVersement.setText("Versement");
        
        txtLieuExamC.setSelectedIndex(0);
        txtParcoursC.setSelectedIndex(0);
    }
    
   
    //Ajout de MENTION DE PARCOURS dans une liste deroulante
    public void listeDeroulantParcours(){
        
        try {
            GestionMention gM = new GestionMention();
            
            //Objet Mention du parcours
            ResultSet rslM = gM.getAll();
            
            int i = 0;
            while(rslM.next()){
                txtParcoursC.addItem( rslM.getString("nomM") );
                //System.out.println("i=" +i);
                //this.tblMention[i] = rslM.getString("nomM");
                i++;
            }
        } catch (Exception e) {
            System.err.println("Erreur de charger Liste de Mention");
            e.printStackTrace();
        }
    }
    
    
    //Affichage de lieu d'examen dans une liste deroulante
    public void listeDeroulantLieuExam(){ 
        try {
            GestionLieuExam gLE = new GestionLieuExam();
            int nbrLE = gLE.countEnreg();
            //Objet LIEU D'EXAMANT 
            ResultSet rslLE = gLE.getAll();
            int i = 0;
            while(rslLE.next()){
                txtLieuExamC.addItem( rslLE.getString("lieu") );
                //System.out.println("i=" +i);
                //this.tblLieu[i] = rslLE.getString("lieu") + rslLE.getString("ville");
                i++;
            }
        } catch (Exception e) {
            System.err.println("Erreur de charger Liste de Mention");
            e.printStackTrace();
        }
        
    }
    
    
    //Affichage de TOUS LES CANDIDATS dans un tableau
    public void ChargerListe(){
        String titre[] = {"ID", "Nom", "Prenom", "Date de naissance", "Lieu de naissance", "Situation Matrimoniale", 
            "Sexe", "Nationalite", "Adresse", "Email", "Telephone", "Numero Bacc", "Serie Bacc", "Mention Bacc", "Mention", "Lieu"};
        Object enreg[][] = new Object[1][1];
        
        try {
            GestionCandidat gtCand = new GestionCandidat();
            
            int nbr = gtCand.countEnreg();
            lblNombreTotal.setText( String.valueOf(nbr) );
            System.out.println(nbr);
            enreg = new Object[nbr][titre.length];
            
            ResultSet rs1 = gtCand.getAll();
            //int nbr = Integer.parseInt( rs1 ) - 6;
            int i = 0;
            while(rs1.next()){
                enreg[i][0] = (Object) rs1.getString("idC");
                enreg[i][1] = (Object) rs1.getString("nomC");
                enreg[i][2] = (Object) rs1.getString("prenomC");
                enreg[i][3] = (Object) rs1.getString("dateNais");
                enreg[i][4] = (Object) rs1.getString("lieuNais");
                enreg[i][5] = (Object) rs1.getString("SMC");
                enreg[i][6] = (Object) rs1.getString("sexeC");
                enreg[i][7] = (Object) rs1.getString("nationC");
                enreg[i][8] = (Object) rs1.getString("adrsPostC");
                enreg[i][9] = (Object) rs1.getString("emailC");
                enreg[i][10] = (Object) rs1.getString("telC");
                enreg[i][11] = (Object) rs1.getString("numIBACC");
                enreg[i][12] = (Object) rs1.getString("serieBACC");
                enreg[i][13] = (Object) rs1.getString("mentionBACC");
                
                enreg[i][14] = (Object) rs1.getString("nomM");
                enreg[i][15] = (Object) rs1.getString("lieu");
                
                //enreg[i][24] = (Object) rs1.getString("recuVers");
                //enreg[i][24] = (Object) rs1.getString("fiche");
                //enreg[i][24] = (Object) rs1.getString("demande");
                //enreg[i][24] = (Object) rs1.getString("releveOuDiplome");
                //enreg[i][24] = (Object) rs1.getString("copieAEC");
                //enreg[i][24] = (Object) rs1.getString("photoC");
                i++;  
            }
            
        } catch (Exception e) {
            e.printStackTrace();
        }
        tableCandidat.setModel( new DefaultTableModel(enreg, titre) );
        jScrollPane1.setViewportView(tableCandidat);
        
        
    }
    
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        txtRecherch = new javax.swing.JTextField();
        lblNombreTotal = new javax.swing.JLabel();
        jLabel18 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tableCandidat = new javax.swing.JTable();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        sexeM = new javax.swing.JRadioButton();
        sexeF = new javax.swing.JRadioButton();
        txtNationalite = new javax.swing.JComboBox();
        txtIDC = new javax.swing.JTextField();
        txtNomC = new javax.swing.JTextField();
        txtPrenomC = new javax.swing.JTextField();
        txtDateNaisC = new javax.swing.JTextField();
        txtLieuNaisC = new javax.swing.JTextField();
        txtLieuExamC = new javax.swing.JComboBox();
        txtParcoursC = new javax.swing.JComboBox();
        txtSerieC = new javax.swing.JComboBox();
        txtNumInscriC = new javax.swing.JTextField();
        jLabel10 = new javax.swing.JLabel();
        jLabel11 = new javax.swing.JLabel();
        jLabel12 = new javax.swing.JLabel();
        jLabel13 = new javax.swing.JLabel();
        jLabel14 = new javax.swing.JLabel();
        jLabel15 = new javax.swing.JLabel();
        jLabel16 = new javax.swing.JLabel();
        jLabel17 = new javax.swing.JLabel();
        txtAdrsPC = new javax.swing.JTextField();
        txtEmailC = new javax.swing.JTextField();
        txtTelC = new javax.swing.JTextField();
        imgFiche = new javax.swing.JPanel();
        imgFicheC = new javax.swing.JLabel();
        imgVersementC = new javax.swing.JPanel();
        imgVersement = new javax.swing.JLabel();
        imgReleveC = new javax.swing.JPanel();
        imgReleve = new javax.swing.JLabel();
        imgCopieAEC = new javax.swing.JPanel();
        imgCopie = new javax.swing.JLabel();
        imgDemandeC = new javax.swing.JPanel();
        imgDemande = new javax.swing.JLabel();
        imgPhotoC = new javax.swing.JPanel();
        imgPhoto = new javax.swing.JLabel();
        txtSituationMatC = new javax.swing.JComboBox();
        txtMentionBaccC = new javax.swing.JComboBox();
        btnAjouter = new javax.swing.JButton();
        btnModifier = new javax.swing.JButton();
        btnSupprimer = new javax.swing.JButton();
        btnAnnuler = new javax.swing.JButton();
        txtpathPhoto = new javax.swing.JTextField();
        txtpathDemande = new javax.swing.JTextField();
        txtpathcopie = new javax.swing.JTextField();
        txtpathReleve = new javax.swing.JTextField();
        txtpathVersement = new javax.swing.JTextField();
        txtpathFiche = new javax.swing.JTextField();
        btnActualiser = new javax.swing.JButton();

        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabel1.setText("S'incrire");

        txtRecherch.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        txtRecherch.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                txtRecherchKeyPressed(evt);
            }
        });

        lblNombreTotal.setText("jLabel18");

        jLabel18.setText("Nobre totale:");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(26, 26, 26)
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 187, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(161, 161, 161)
                .addComponent(jLabel18, javax.swing.GroupLayout.PREFERRED_SIZE, 104, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(lblNombreTotal, javax.swing.GroupLayout.PREFERRED_SIZE, 91, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(txtRecherch, javax.swing.GroupLayout.PREFERRED_SIZE, 241, javax.swing.GroupLayout.PREFERRED_SIZE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
            .addComponent(txtRecherch, javax.swing.GroupLayout.Alignment.TRAILING)
            .addComponent(jLabel18, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(lblNombreTotal, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        tableCandidat.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null, null, null, null, null, null, null, null, null, null}
            },
            new String [] {
                "Numero", "Nom", "Prenom", "Date de Naissance", "Lieu de naissance", "Sexe", "Situation Matimoniale", "Nationalite", "Adresse Postale", "Email", "Telephone", "Numero BACC", "Serie BACC", "Mention BACC", "Parcours"
            }
        ));
        tableCandidat.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseReleased(java.awt.event.MouseEvent evt) {
                tableCandidatMouseReleased(evt);
            }
        });
        jScrollPane1.setViewportView(tableCandidat);

        jLabel2.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel2.setText("Numero:");

        jLabel3.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel3.setText("Nom:");

        jLabel4.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel4.setText("Prenom:");

        jLabel5.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel5.setText("Date de naissance:");

        jLabel6.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel6.setText("Lieu de naissance:");

        jLabel7.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel7.setText("Sexe:");

        jLabel8.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel8.setText("Situation matrimoniale:");

        jLabel9.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel9.setText("Nationalite:");

        sexeM.setText("Masculin");

        sexeF.setText("Feminin");

        txtNationalite.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Malagasy", "Etranger" }));

        txtIDC.setEnabled(false);

        txtParcoursC.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N

        txtSerieC.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "A", "D", "C", "OSE", "L", "Technique" }));

        jLabel10.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel10.setText("Adresse postale:");

        jLabel11.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel11.setText("Email:");

        jLabel12.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel12.setText("Telephone:");

        jLabel13.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel13.setText("Numero d'inscription BACC:");

        jLabel14.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel14.setText("Serie:");

        jLabel15.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel15.setText("Mention:");

        jLabel16.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel16.setText("Lieu d'examen:");

        jLabel17.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel17.setText("Parcours:");

        txtTelC.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtTelCActionPerformed(evt);
            }
        });

        imgFiche.setBackground(new java.awt.Color(204, 204, 204));

        imgFicheC.setForeground(new java.awt.Color(51, 51, 0));
        imgFicheC.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        imgFicheC.setText("Fiche");
        imgFicheC.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                imgFicheCMouseClicked(evt);
            }
        });

        javax.swing.GroupLayout imgFicheLayout = new javax.swing.GroupLayout(imgFiche);
        imgFiche.setLayout(imgFicheLayout);
        imgFicheLayout.setHorizontalGroup(
            imgFicheLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(imgFicheC, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        imgFicheLayout.setVerticalGroup(
            imgFicheLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(imgFicheC, javax.swing.GroupLayout.DEFAULT_SIZE, 153, Short.MAX_VALUE)
        );

        imgVersementC.setBackground(new java.awt.Color(204, 204, 204));

        imgVersement.setForeground(new java.awt.Color(51, 51, 0));
        imgVersement.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        imgVersement.setText("Versement");
        imgVersement.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                imgVersementMouseClicked(evt);
            }
        });

        javax.swing.GroupLayout imgVersementCLayout = new javax.swing.GroupLayout(imgVersementC);
        imgVersementC.setLayout(imgVersementCLayout);
        imgVersementCLayout.setHorizontalGroup(
            imgVersementCLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(imgVersement, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 142, Short.MAX_VALUE)
        );
        imgVersementCLayout.setVerticalGroup(
            imgVersementCLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(imgVersement, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        imgReleveC.setBackground(new java.awt.Color(204, 204, 204));

        imgReleve.setForeground(new java.awt.Color(51, 51, 0));
        imgReleve.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        imgReleve.setText("Releve");
        imgReleve.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                imgReleveMouseClicked(evt);
            }
        });

        javax.swing.GroupLayout imgReleveCLayout = new javax.swing.GroupLayout(imgReleveC);
        imgReleveC.setLayout(imgReleveCLayout);
        imgReleveCLayout.setHorizontalGroup(
            imgReleveCLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(imgReleve, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 144, Short.MAX_VALUE)
        );
        imgReleveCLayout.setVerticalGroup(
            imgReleveCLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(imgReleve, javax.swing.GroupLayout.DEFAULT_SIZE, 150, Short.MAX_VALUE)
        );

        imgCopieAEC.setBackground(new java.awt.Color(204, 204, 204));

        imgCopie.setForeground(new java.awt.Color(51, 51, 0));
        imgCopie.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        imgCopie.setText("Copie");
        imgCopie.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                imgCopieMouseClicked(evt);
            }
        });

        javax.swing.GroupLayout imgCopieAECLayout = new javax.swing.GroupLayout(imgCopieAEC);
        imgCopieAEC.setLayout(imgCopieAECLayout);
        imgCopieAECLayout.setHorizontalGroup(
            imgCopieAECLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(imgCopie, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 141, Short.MAX_VALUE)
        );
        imgCopieAECLayout.setVerticalGroup(
            imgCopieAECLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(imgCopie, javax.swing.GroupLayout.DEFAULT_SIZE, 150, Short.MAX_VALUE)
        );

        imgDemandeC.setBackground(new java.awt.Color(204, 204, 204));

        imgDemande.setForeground(new java.awt.Color(51, 51, 0));
        imgDemande.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        imgDemande.setText("Demande");
        imgDemande.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                imgDemandeMouseClicked(evt);
            }
        });

        javax.swing.GroupLayout imgDemandeCLayout = new javax.swing.GroupLayout(imgDemandeC);
        imgDemandeC.setLayout(imgDemandeCLayout);
        imgDemandeCLayout.setHorizontalGroup(
            imgDemandeCLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(imgDemande, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 143, Short.MAX_VALUE)
        );
        imgDemandeCLayout.setVerticalGroup(
            imgDemandeCLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(imgDemande, javax.swing.GroupLayout.DEFAULT_SIZE, 150, Short.MAX_VALUE)
        );

        imgPhotoC.setBackground(new java.awt.Color(204, 204, 204));

        imgPhoto.setForeground(new java.awt.Color(51, 51, 0));
        imgPhoto.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        imgPhoto.setText("Photo");
        imgPhoto.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                imgPhotoMouseClicked(evt);
            }
        });

        javax.swing.GroupLayout imgPhotoCLayout = new javax.swing.GroupLayout(imgPhotoC);
        imgPhotoC.setLayout(imgPhotoCLayout);
        imgPhotoCLayout.setHorizontalGroup(
            imgPhotoCLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(imgPhoto, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 144, Short.MAX_VALUE)
        );
        imgPhotoCLayout.setVerticalGroup(
            imgPhotoCLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(imgPhoto, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        txtSituationMatC.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Celibataire", "Mari", "Marie", "Divorce" }));

        txtMentionBaccC.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Passable", "Assez bien", "Bien", "Tres bien", "Honorable" }));

        btnAjouter.setBackground(new java.awt.Color(0, 0, 255));
        btnAjouter.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        btnAjouter.setText("Ajouter");
        btnAjouter.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAjouterActionPerformed(evt);
            }
        });

        btnModifier.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        btnModifier.setText("Modifier");
        btnModifier.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnModifierActionPerformed(evt);
            }
        });

        btnSupprimer.setBackground(new java.awt.Color(255, 51, 51));
        btnSupprimer.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        btnSupprimer.setText("Supprimer");
        btnSupprimer.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSupprimerActionPerformed(evt);
            }
        });

        btnAnnuler.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        btnAnnuler.setText("Annuler");
        btnAnnuler.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAnnulerActionPerformed(evt);
            }
        });

        txtpathPhoto.setEnabled(false);
        txtpathPhoto.setPreferredSize(new java.awt.Dimension(0, 0));

        txtpathDemande.setEnabled(false);
        txtpathDemande.setPreferredSize(new java.awt.Dimension(0, 0));

        txtpathcopie.setEnabled(false);
        txtpathcopie.setPreferredSize(new java.awt.Dimension(0, 0));

        txtpathReleve.setEnabled(false);
        txtpathReleve.setPreferredSize(new java.awt.Dimension(0, 0));

        txtpathVersement.setEnabled(false);
        txtpathVersement.setPreferredSize(new java.awt.Dimension(0, 0));

        txtpathFiche.setEnabled(false);
        txtpathFiche.setPreferredSize(new java.awt.Dimension(0, 0));

        btnActualiser.setText("Actualiser");
        btnActualiser.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnActualiserActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane1)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jLabel9)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(txtNationalite, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 62, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(txtIDC))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jLabel3)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(txtNomC))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(txtPrenomC, javax.swing.GroupLayout.PREFERRED_SIZE, 240, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jLabel7, javax.swing.GroupLayout.PREFERRED_SIZE, 54, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(28, 28, 28)
                                .addComponent(sexeM)
                                .addGap(18, 18, 18)
                                .addComponent(sexeF))
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                    .addComponent(jLabel5, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(jLabel6, javax.swing.GroupLayout.PREFERRED_SIZE, 114, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(txtDateNaisC)
                                    .addComponent(txtLieuNaisC, javax.swing.GroupLayout.PREFERRED_SIZE, 186, javax.swing.GroupLayout.PREFERRED_SIZE)))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jLabel8)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(txtSituationMatC, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                        .addGap(106, 106, 106)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jLabel10)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(txtAdrsPC, javax.swing.GroupLayout.PREFERRED_SIZE, 261, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jLabel11)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(txtEmailC, javax.swing.GroupLayout.PREFERRED_SIZE, 328, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                                    .addComponent(jLabel12)
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                    .addComponent(txtTelC))
                                .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                                    .addComponent(jLabel15)
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                    .addComponent(txtMentionBaccC, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                                .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                                    .addComponent(jLabel13)
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                    .addComponent(txtNumInscriC))
                                .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                                    .addComponent(jLabel17)
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                    .addComponent(txtParcoursC, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                                .addGroup(layout.createSequentialGroup()
                                    .addComponent(jLabel16)
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                    .addComponent(txtLieuExamC, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                                .addGroup(layout.createSequentialGroup()
                                    .addComponent(jLabel14)
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                    .addComponent(txtSerieC, javax.swing.GroupLayout.PREFERRED_SIZE, 328, javax.swing.GroupLayout.PREFERRED_SIZE))))
                        .addGap(105, 105, 105)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(imgReleveC, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(imgPhotoC, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(35, 35, 35)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(imgDemandeC, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(imgVersementC, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(38, 38, 38)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(imgCopieAEC, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(imgFiche, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addGap(37, 37, 37)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(txtpathPhoto, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txtpathDemande, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txtpathcopie, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txtpathReleve, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txtpathVersement, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txtpathFiche, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(0, 152, Short.MAX_VALUE)))
                .addContainerGap())
            .addGroup(layout.createSequentialGroup()
                .addGap(73, 73, 73)
                .addComponent(btnActualiser, javax.swing.GroupLayout.PREFERRED_SIZE, 166, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(37, 37, 37)
                .addComponent(btnAnnuler, javax.swing.GroupLayout.PREFERRED_SIZE, 169, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(34, 34, 34)
                .addComponent(btnSupprimer, javax.swing.GroupLayout.PREFERRED_SIZE, 177, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(43, 43, 43)
                .addComponent(btnModifier, javax.swing.GroupLayout.PREFERRED_SIZE, 177, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(54, 54, 54)
                .addComponent(btnAjouter, javax.swing.GroupLayout.PREFERRED_SIZE, 169, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 357, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txtIDC, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(12, 12, 12)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(txtNomC, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 27, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(6, 6, 6)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 27, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txtPrenomC, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txtDateNaisC, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel6, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txtLieuNaisC, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel7, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(sexeM)
                            .addComponent(sexeF))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel8, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txtSituationMatC, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel9, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txtNationalite, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                        .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                            .addComponent(imgCopieAEC, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(imgFiche, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                            .addComponent(imgDemandeC, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGap(18, 18, 18)
                            .addComponent(imgVersementC, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addGroup(layout.createSequentialGroup()
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                .addGroup(layout.createSequentialGroup()
                                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                        .addComponent(jLabel10, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(txtAdrsPC, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addGap(12, 12, 12)
                                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                        .addComponent(jLabel11, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(txtEmailC, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addGap(6, 6, 6)
                                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                        .addComponent(jLabel12, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(txtTelC, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                        .addComponent(jLabel13, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(txtNumInscriC, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                .addGroup(layout.createSequentialGroup()
                                    .addComponent(imgPhotoC, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addGap(7, 7, 7)))
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                .addGroup(layout.createSequentialGroup()
                                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                        .addGroup(layout.createSequentialGroup()
                                            .addComponent(jLabel14, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED))
                                        .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                                            .addGap(6, 6, 6)
                                            .addComponent(txtSerieC, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                                .addComponent(jLabel15, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addComponent(txtMentionBaccC, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE))
                                            .addGap(87, 87, 87))
                                        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                                .addComponent(jLabel16, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addComponent(txtLieuExamC, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE))
                                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                                .addComponent(jLabel17, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addComponent(txtParcoursC, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)))))
                                .addComponent(imgReleveC, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                            .addComponent(txtpathPhoto, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                            .addComponent(txtpathDemande, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGap(18, 18, 18)
                            .addComponent(txtpathcopie, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGap(18, 18, 18)
                            .addComponent(txtpathReleve, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGap(18, 18, 18)
                            .addComponent(txtpathVersement, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGap(18, 18, 18)
                            .addComponent(txtpathFiche, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 63, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnAjouter, javax.swing.GroupLayout.PREFERRED_SIZE, 39, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnModifier, javax.swing.GroupLayout.PREFERRED_SIZE, 39, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnSupprimer, javax.swing.GroupLayout.PREFERRED_SIZE, 39, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnAnnuler, javax.swing.GroupLayout.PREFERRED_SIZE, 39, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnActualiser, javax.swing.GroupLayout.PREFERRED_SIZE, 39, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(23, 23, 23))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void txtTelCActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtTelCActionPerformed
 
        /**String cin = txtC.getText();
        if (cin.length()==12){
            if (cin.charAt(5)=='1'){
                rbM.setSelected(true);
            }else if(cin.charAt(5)=='2'){
                rbF.setSelected(true);
            }else{
                JOptionPane.showMessageDialog(cbFb, "Veuillez vérifier votre CIN svp", "Error", WIDTH);
            }
        }else{
            JOptionPane.showMessageDialog(cbFb, "Veuillez vérifier votre CIN svp", "Error", WIDTH);
        }*/
    }//GEN-LAST:event_txtTelCActionPerformed

    
    private void btnModifierActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnModifierActionPerformed
//        txtIDC;
//        txtNomC;
//        txtAdrsPC;
//        txtPrenomC;
//        txtDateNaisC;
//        txtLieuNaisC;
//        
//        txtSituationMatC;
//        txtNationalite;
//        txtAdrsPC;
//        txtEmailC;
//        txtTelC;
//        txtNumInscriC;
//        txtSerieC;
//        txtMentionBaccC;
//        
//        imgCopieAEC;
//        imgDemandeC;
//        imgFiche;
//        imgPhotoC;
//        imgReleveC;
//        imgVersementC;
//        
//        txtLieuExamC;
//        txtParcoursC;
        
        String valID = txtIDC.getText();
         String valnom = txtNomC.getText();
        //String adresse = txtAdrsPC.getText();
        String valprenom = txtPrenomC.getText();
        String valdateNais = txtDateNaisC.getText();
        String vallieuNais = txtLieuNaisC.getText();
        
        String valsexe = null;
        if(sexeF.isSelected()){
            valsexe = "F";
        }else if(sexeM.isSelected()){
            valsexe = "M";
        }
        
        String valSMC = txtSituationMatC.getSelectedItem().toString();
        String valnation = txtNationalite.getSelectedItem().toString();
        String valadrsP =  txtAdrsPC.getText();
        String valemail = txtEmailC.getText();
        String valtel = txtTelC.getText();
        String valnumIBACC = txtNumInscriC.getText();
        String valserieBACC = txtSerieC.getSelectedItem().toString();
        String valmentionBACC = txtMentionBaccC.getSelectedItem().toString();
        
        String valrecuVers = txtpathVersement.getText();
        String valfiche = txtpathFiche.getText();
        String valdemande = txtpathDemande.getText();
        String valreleveOuDiplome = txtpathReleve.getText();
        String valcopieAEC = txtpathcopie.getText();
        String valphotoC = txtpathPhoto.getText();
        
//        String valrecuVers = pathVersement;
//        String valfiche = pathFiche;
//        String valdemande = pathDemande;
//        String valreleveOuDiplome = pathReleveOUDipl;
//        String valcopieAEC = pathCopie;
//        String valphotoC = pathPhoto;

        String valnomMention = txtParcoursC.getSelectedItem().toString();
 
        String valLieu = txtLieuExamC.getSelectedItem().toString();
        int valIdLieu1 = 1;
        try {
            GestionLieuExam gLE = new GestionLieuExam();
            //Objet LIEU D'EXAMANT 
            ResultSet rslLE = gLE.getAll(); 
            
            int j = 1;
            while(rslLE.next()){
                if( rslLE.getString("lieu").equals(valLieu) ) {
                    valIdLieu1 = j;
                } j++;
            } } catch (Exception ex) {}

        if(valID.equals("")) {
            JOptionPane.showMessageDialog(null, "Selectionner une ligne de tableau");
        }else{
            
            try {

                Candidat cand = new Candidat(
                        Integer.parseInt(valID) ,valnom, valprenom, valdateNais, vallieuNais, valsexe, valSMC, valnation, valadrsP, valemail, valtel, 
                        valnumIBACC, valserieBACC, 
                        valmentionBACC, 
                        valrecuVers,
                        valfiche,
                        valdemande, 
                        valreleveOuDiplome,
                        valcopieAEC, 
                        valphotoC,
                        valnomMention, 
                        String.valueOf(valIdLieu1)
                );

                GestionCandidat gCand = new GestionCandidat();
                gCand.insert(cand);
                JOptionPane.showMessageDialog(txtNomC, "Modification reussii !!");
                effacerChamps();
                ChargerListe();
                conn.close();

            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }//GEN-LAST:event_btnModifierActionPerformed

    
    private void imgDemandeMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_imgDemandeMouseClicked
//        telechargeImage( pathDemande, imgDemande, bytphotoC);
//        System.out.println("pathPhoto="+ pathDemande);
//        System.out.println("bytphotoC="+ imgDemande);      
        JFileChooser pic = new JFileChooser();
        pic.showOpenDialog(null);
        File picture = pic.getSelectedFile();
        pathDemande = picture.getAbsolutePath();
        BufferedImage img;
        try {
            img = ImageIO.read( pic.getSelectedFile() );
            ImageIcon imageIc = new ImageIcon( new ImageIcon(img).getImage().getScaledInstance(150, 150, Image.SCALE_DEFAULT) );          
            imgDemande.setIcon(imageIc);
            imgDemande.setText(null);
            txtpathDemande.setText(pathDemande);    
            System.out.println(imgDemande.getText());
            File image = new File( pathDemande );
            FileInputStream fis = new FileInputStream( image );    
            ByteArrayOutputStream bos = new ByteArrayOutputStream();
            byte[] buff = new byte[1024];   
            for(int i; (i = fis.read(buff)) != -1; ){
                bos.write(buff , 0, i ); 
            }
            bytphotoC = bos.toByteArray();
        } catch (Exception e) {
            System.out.println("Erreur de telechargement");
            e.printStackTrace();
        }
    }//GEN-LAST:event_imgDemandeMouseClicked

    private void imgCopieMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_imgCopieMouseClicked
//        telechargeImage( pathCopie, imgCopie, bytcopieAEC);
//        System.out.println("pathCopie="+ pathCopie);
//        System.out.println("bytcopieAEC="+ bytcopieAEC);
        
        JFileChooser pic = new JFileChooser();
        pic.showOpenDialog(null);
    
        File picture = pic.getSelectedFile();
        pathCopie = picture.getAbsolutePath();
        BufferedImage img;
        
        try {
            img = ImageIO.read( pic.getSelectedFile() );
            ImageIcon imageIc = new ImageIcon( new ImageIcon(img).getImage().getScaledInstance(150, 150, Image.SCALE_DEFAULT) );
            
            imgCopie.setIcon(imageIc);
            imgCopie.setText(null);
            txtpathcopie.setText(pathCopie);
            
            File image = new File( pathCopie );
            FileInputStream fis = new FileInputStream( image );
            
            ByteArrayOutputStream bos = new ByteArrayOutputStream();
            byte[] buff = new byte[1024];
            
            for(int i; (i = fis.read(buff)) != -1; ){
                bos.write(buff , 0, i ); 
            }
            bytcopieAEC = bos.toByteArray();

        } catch (Exception e) {
            System.out.println("Erreur de telechargement");
            e.printStackTrace();
        }
    }//GEN-LAST:event_imgCopieMouseClicked

    private void imgReleveMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_imgReleveMouseClicked
//        telechargeImage( pathReleveOUDipl, imgReleve, bytreleveOuDiplome);
//        System.out.println("pathReleveOUDipl="+ pathReleveOUDipl);
//        System.out.println("bytreleveOuDiplome="+ bytreleveOuDiplome);
        
        JFileChooser pic = new JFileChooser();
        pic.showOpenDialog(null);
    
        File picture = pic.getSelectedFile();
        pathReleveOUDipl = picture.getAbsolutePath();
        BufferedImage img;
        
        try {
            img = ImageIO.read( pic.getSelectedFile() );
            ImageIcon imageIc = new ImageIcon( new ImageIcon(img).getImage().getScaledInstance(150, 150, Image.SCALE_DEFAULT) );
            
            imgReleve.setIcon(imageIc);
            imgReleve.setText(null);
            txtpathReleve.setText(pathReleveOUDipl);
            
            File image = new File( pathReleveOUDipl );
            FileInputStream fis = new FileInputStream( image );
            
            ByteArrayOutputStream bos = new ByteArrayOutputStream();
            byte[] buff = new byte[1024];
            
            for(int i; (i = fis.read(buff)) != -1; ){
                bos.write(buff , 0, i ); 
            }
            bytreleveOuDiplome = bos.toByteArray();

        } catch (Exception e) {
            System.out.println("Erreur de telechargement");
            e.printStackTrace();
        }
    }//GEN-LAST:event_imgReleveMouseClicked

    private void imgVersementMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_imgVersementMouseClicked
//        telechargeImage( pathVersement, imgVersement, bytrecuVers);
//        System.out.println("pathVersement="+ pathVersement);
//        System.out.println("bytrecuVers="+ bytrecuVers);
        
        JFileChooser pic = new JFileChooser();
        pic.showOpenDialog(null);

        File picture = pic.getSelectedFile();
        pathVersement = picture.getAbsolutePath();
        BufferedImage img;
        
        try {
            img = ImageIO.read( pic.getSelectedFile() );
            ImageIcon imageIc = new ImageIcon( new ImageIcon(img).getImage().getScaledInstance(150, 150, Image.SCALE_DEFAULT) );
            
            imgVersement.setIcon(imageIc);
            imgVersement.setText(null);
            txtpathVersement.setText(pathVersement);
            
            File image = new File( pathVersement );
            FileInputStream fis = new FileInputStream( image );
            
            ByteArrayOutputStream bos = new ByteArrayOutputStream();
            byte[] buff = new byte[1024];
            
            for(int i; (i = fis.read(buff)) != -1; ){
                bos.write(buff , 0, i ); 
            }
            bytrecuVers = bos.toByteArray();

        } catch (Exception e) {
            System.out.println("Erreur de telechargement");
            e.printStackTrace();
        }
    }//GEN-LAST:event_imgVersementMouseClicked

    private void imgFicheCMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_imgFicheCMouseClicked
//        telechargeImage( pathFiche, imgFicheC, bytfiche);
//        System.out.println("pathVersement="+ pathVersement);
//        System.out.println("bytfiche="+ bytfiche);
        
        JFileChooser pic = new JFileChooser();
        pic.showOpenDialog(null);

        File picture = pic.getSelectedFile();
        pathFiche = picture.getAbsolutePath();
        BufferedImage img;
        
        try {
            img = ImageIO.read( pic.getSelectedFile() );
            ImageIcon imageIc = new ImageIcon( new ImageIcon(img).getImage().getScaledInstance(150, 150, Image.SCALE_DEFAULT) );
            
            imgFicheC.setIcon(imageIc);
            imgFicheC.setText(null);
            txtpathFiche.setText(pathFiche);
            
            File image = new File( pathFiche );
            FileInputStream fis = new FileInputStream( image );
            
            ByteArrayOutputStream bos = new ByteArrayOutputStream();
            byte[] buff = new byte[1024];
            
            for(int i; (i = fis.read(buff)) != -1; ){
                bos.write(buff , 0, i ); 
            }
            bytfiche = bos.toByteArray();

        } catch (Exception e) {
            System.out.println("Erreur de telechargement");
            e.printStackTrace();
        }
    }//GEN-LAST:event_imgFicheCMouseClicked

    private void imgPhotoMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_imgPhotoMouseClicked
//         telechargeImage( pathPhoto, imgPhoto, bytphotoC);
//        System.out.println("pathPhoto="+ pathPhoto);
//        System.out.println("bytphotoC="+ bytphotoC);
        
        JFileChooser pic = new JFileChooser();
        pic.showOpenDialog(null);
        
        File picture = pic.getSelectedFile();
        
        pathPhoto = picture.getAbsolutePath();
        //System.out.println( " 931= "+pathPhoto);
        BufferedImage img;
        
        try {
            img = ImageIO.read( pic.getSelectedFile() );
            //System.out.println( " 936= "+img);
            ImageIcon imageIc = new ImageIcon( new ImageIcon(img).getImage().getScaledInstance(150, 150, Image.SCALE_DEFAULT) );
            //System.out.println( " 938= "+imageIc);
            
            imgPhoto.setIcon(imageIc);
            imgPhoto.setText("");
            txtpathPhoto.setText(pathPhoto);
            
            File image = new File( pathPhoto );
            //System.out.println( " 942= "+image);
            
            FileInputStream fis = new FileInputStream( image );
            //System.out.println( " 945= "+fis);
            
            ByteArrayOutputStream bos = new ByteArrayOutputStream();
            byte[] buff = new byte[1024];
            
            for(int i; (i = fis.read(buff)) != -1; ){
                bos.write(buff , 0, i ); 
            }
            bytphotoC = bos.toByteArray();
            //System.out.println( " 954= "+bytphotoC);
            //System.out.println( " Succes= ");
        } catch (Exception e) {
            System.out.println("Erreur de telechargement");
            e.printStackTrace();
        }
    }//GEN-LAST:event_imgPhotoMouseClicked
 
    //AJOUT DE CANDIDAT
    private void btnAjouterActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAjouterActionPerformed

        String valnom = txtNomC.getText();
        //String adresse = txtAdrsPC.getText();
        String valprenom = txtPrenomC.getText();
        String valdateNais = txtDateNaisC.getText();
        String vallieuNais = txtLieuNaisC.getText();
        
        String valsexe = null;
        if(sexeF.isSelected()){
            valsexe = "F";
        }else if(sexeM.isSelected()){
            valsexe = "M";
        }
        
        String valSMC = txtSituationMatC.getSelectedItem().toString();
        String valnation = txtNationalite.getSelectedItem().toString();
        String valadrsP =  txtAdrsPC.getText();
        String valemail = txtEmailC.getText();
        String valtel = txtTelC.getText();
        String valnumIBACC = txtNumInscriC.getText();
        String valserieBACC = txtSerieC.getSelectedItem().toString();
        String valmentionBACC = txtMentionBaccC.getSelectedItem().toString();
        
        String valrecuVers = txtpathVersement.getText();
        String valfiche = txtpathFiche.getText();
        String valdemande = txtpathDemande.getText();
        String valreleveOuDiplome = txtpathReleve.getText();
        String valcopieAEC = txtpathcopie.getText();
        String valphotoC = txtpathPhoto.getText();
        
//        String valrecuVers = pathVersement;
//        String valfiche = pathFiche;
//        String valdemande = pathDemande;
//        String valreleveOuDiplome = pathReleveOUDipl;
//        String valcopieAEC = pathCopie;
//        String valphotoC = pathPhoto;

        String valnomMention = txtParcoursC.getSelectedItem().toString();
 
        String valLieu = txtLieuExamC.getSelectedItem().toString();
        int valIdLieu1 = 1;
        try {
            GestionLieuExam gLE = new GestionLieuExam();
            //Objet LIEU D'EXAMANT 
            ResultSet rslLE = gLE.getAll(); 
            
            int j = 1;
            while(rslLE.next()){
                if( rslLE.getString("lieu").equals(valLieu) ) {
                    valIdLieu1 = j;
                } j++;
            } } catch (Exception ex) {}


        try {
            
            Candidat cand = new Candidat(
                    valnom, valprenom, valdateNais, vallieuNais, valsexe, valSMC, valnation, valadrsP, valemail, valtel, valnumIBACC, valserieBACC, 
                    valmentionBACC, 
                    valrecuVers,
                    valfiche,
                    valdemande, 
                    valreleveOuDiplome,
                    valcopieAEC, 
                    valphotoC,
                    valnomMention, 
                    String.valueOf(valIdLieu1)
            );
            
            GestionCandidat gCand = new GestionCandidat();
            gCand.insert(cand);
            JOptionPane.showMessageDialog(txtNomC, "Insertion réussi!!");
            effacerChamps();
            ChargerListe();
            conn.close();
   
        } catch (Exception e) {
            e.printStackTrace();
        }
        
    }//GEN-LAST:event_btnAjouterActionPerformed

    
    //AFFICHE LIGNE SELECTIONNER
    private void tableCandidatMouseReleased(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tableCandidatMouseReleased
        int ligne = tableCandidat.getSelectedRow();
        int id =  Integer.parseInt(tableCandidat.getValueAt(ligne, 0).toString() );

        try {
            GestionCandidat gtCand = new GestionCandidat();
            ResultSet rs1 = gtCand.getById( id );
            
            if (rs1.next()){
                txtIDC.setText( rs1.getString("idC") );
                txtNomC.setText( rs1.getString("nomC") );
                txtPrenomC.setText( rs1.getString("prenomC") );
                txtDateNaisC.setText( rs1.getString("dateNais") );
                txtLieuNaisC.setText( rs1.getString("lieuNais") );
                
//                txtSituationMatC.getSelectedObjects();
//                System.out.println( "Situation= " + txtSituationMatC );

                txtSituationMatC.setSelectedItem(rs1.getString("SMC") );
                
                String sexe = rs1.getString("sexeC");
                if( sexe.equals("F")){
                    sexeF.setSelected(true);
                    sexeM.setSelected(false);
                }else{
                    sexeF.setSelected(false);
                    sexeM.setSelected(true);
                }
                
                txtNationalite.setSelectedItem( rs1.getString("nationC") );
                txtAdrsPC.setText( rs1.getString("adrsPostC") );
                txtEmailC.setText( rs1.getString("emailC") );
                txtTelC.setText( rs1.getString("telC") );
                txtNumInscriC.setText( rs1.getString("numIBACC") );
                txtSerieC.setSelectedItem( rs1.getString("serieBACC") );
                txtMentionBaccC.setSelectedItem( rs1.getString("mentionBACC") );
                
                if( (rs1.getString("recuVers" )).equals("null") ){
                }else{
                    imgVersement.setIcon( new ImageIcon( rs1.getString("recuVers" ) ) ); 
                    imgVersement.setText(null); 
                    txtpathVersement.setText(rs1.getString("recuVers" ));
                    imgVersement.setVisible(true);
                } 
                
                if( (rs1.getString("fiche" ).equals("")) ){
                }else{
                    imgFicheC.setIcon( new ImageIcon( rs1.getString("fiche" ) ) ); 
                    imgFicheC.setText(null);
                    txtpathFiche.setText(rs1.getString("fiche" ));
                    imgFicheC.setVisible(true);
                } 
                
                if( (rs1.getString("demande" )).equals("") ){   
                }else{
                    imgDemande.setIcon( new ImageIcon( rs1.getString("demande" ) ) ); 
                    imgDemande.setText("");
                    txtpathDemande.setText(rs1.getString("demande" ));
                    imgDemande.setVisible(true);
                }  
                
                if(rs1.getString("releveOuDiplome" ).equals("")){   
                }else{
                    imgReleve.setIcon( new ImageIcon( rs1.getString("releveOuDiplome" ) ) ); 
                    imgReleve.setText(""); 
                    txtpathReleve.setText(rs1.getString("releveOuDiplome" ));
                    imgReleve.setVisible(true);
                }
                if( (rs1.getString("photoC" )).equals("") ){  
                }else{
                    imgPhoto.setIcon( new ImageIcon( rs1.getString("photoC" ) ) );
                    System.out.println( rs1.getString("photoC" ) );
                    imgPhoto.setText(""); 
                    txtpathPhoto.setText(rs1.getString("photoC" ));
                    imgPhoto.setVisible(true);
                }
                if( (rs1.getString("copieAEC" ).equals("")) ){
                }else{
                    imgCopie.setIcon( new ImageIcon( rs1.getString("copieAEC" ) ) ); 
                    imgCopie.setText(""); 
                    txtpathcopie.setText(rs1.getString("copieAEC" ));
                    imgCopie.setVisible(true);
                }
                
                
//                txtIDC.setText( rs1.getString("recuVers") );
//                txtIDC.setText( rs1.getString("fiche") );
//                txtIDC.setText( rs1.getString("demande") );
//                txtIDC.setText( rs1.getString("releveOuDiplome") );
//                txtIDC.setText( rs1.getString("copieAEC") );
                
                txtMentionBaccC.setSelectedItem( rs1.getString("nomM") );
                txtLieuExamC.setSelectedItem( rs1.getString("idlieu") );
  
            }
            
        } catch (Exception e) {
            e.printStackTrace();
        }
        
    }//GEN-LAST:event_tableCandidatMouseReleased

    
    //VIDER TOUT LES CHAMP
    private void btnAnnulerActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAnnulerActionPerformed
        effacerChamps();
    }//GEN-LAST:event_btnAnnulerActionPerformed

    //ACTUALISER LA PAGE
    private void btnActualiserActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnActualiserActionPerformed
        ChargerListe();
        effacerChamps();
    }//GEN-LAST:event_btnActualiserActionPerformed

    //SUPPRIMER LA LIGNE QUI EST SELECTIONNER
    private void btnSupprimerActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSupprimerActionPerformed
        String valID = txtIDC.getText();
        
         if(valID.equals("") ) {
             JOptionPane.showMessageDialog(null, "Selectionner une ligne de tableau");
         }else if (JOptionPane.showConfirmDialog( null , "Supression reussii !! '"+txtNomC+"' ", 
                 "Modification" ,JOptionPane.YES_NO_OPTION ) == JOptionPane.OK_OPTION   
                 ){
             
             try {
                 
//                Candidat cand = new Candidat(
//                        Integer.parseInt(valID)
//                );
                 
                 GestionCandidat gCand = new GestionCandidat();
                 gCand.delete( Integer.parseInt(valID) );
                 JOptionPane.showMessageDialog(txtNomC, "Supression reussii !!");
                 effacerChamps();
                 ChargerListe();
                 conn.close();
                 
             } catch (Exception e) {
                 e.printStackTrace();
             }
             
         }else{
               JOptionPane.showMessageDialog(null, " Supression annuler !!");      
        }
    }//GEN-LAST:event_btnSupprimerActionPerformed

    
    //CHAMP DE RECHERCHE
    private void txtRecherchKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtRecherchKeyPressed
        String rech = txtRecherch.getText();
        
        String titre[] = {"ID", "Nom", "Prenom", "Date de naissance", "Lieu de naissance", "Situation Matrimoniale", 
            "Sexe", "Nationalite", "Adresse", "Email", "Telephone", "Numero Bacc", "Serie Bacc", "Mention Bacc", "Mention", "Lieu"};
        Object enreg[][] = new Object[1][1];
        
        try {
            GestionCandidat gtCand = new GestionCandidat();
            
            int nbr = gtCand.countEnreg();
            lblNombreTotal.setText( String.valueOf(nbr) );
            enreg = new Object[nbr][titre.length];
            
            ResultSet rs1 = gtCand.getBySearcch(rech);
            //int nbr = Integer.parseInt( rs1 ) - 6;
            int i = 0;
            while(rs1.next()){
                enreg[i][0] = (Object) rs1.getString("idC");
                enreg[i][1] = (Object) rs1.getString("nomC");
                enreg[i][2] = (Object) rs1.getString("prenomC");
                enreg[i][3] = (Object) rs1.getString("dateNais");
                enreg[i][4] = (Object) rs1.getString("lieuNais");
                enreg[i][5] = (Object) rs1.getString("SMC");
                enreg[i][6] = (Object) rs1.getString("sexeC");
                enreg[i][7] = (Object) rs1.getString("nationC");
                enreg[i][8] = (Object) rs1.getString("adrsPostC");
                enreg[i][9] = (Object) rs1.getString("emailC");
                enreg[i][10] = (Object) rs1.getString("telC");
                enreg[i][11] = (Object) rs1.getString("numIBACC");
                enreg[i][12] = (Object) rs1.getString("serieBACC");
                enreg[i][13] = (Object) rs1.getString("mentionBACC");
                
                enreg[i][14] = (Object) rs1.getString("nomM");
                enreg[i][15] = (Object) rs1.getString("lieu");
               
                i++;  
            }
            
        } catch (Exception e) {
            e.printStackTrace();
        }
        tableCandidat.setModel( new DefaultTableModel(enreg, titre) );
        jScrollPane1.setViewportView(tableCandidat);
        
    }//GEN-LAST:event_txtRecherchKeyPressed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnActualiser;
    private javax.swing.JButton btnAjouter;
    private javax.swing.JButton btnAnnuler;
    private javax.swing.JButton btnModifier;
    private javax.swing.JButton btnSupprimer;
    private javax.swing.JLabel imgCopie;
    private javax.swing.JPanel imgCopieAEC;
    private javax.swing.JLabel imgDemande;
    private javax.swing.JPanel imgDemandeC;
    private javax.swing.JPanel imgFiche;
    private javax.swing.JLabel imgFicheC;
    private javax.swing.JLabel imgPhoto;
    private javax.swing.JPanel imgPhotoC;
    private javax.swing.JLabel imgReleve;
    private javax.swing.JPanel imgReleveC;
    private javax.swing.JLabel imgVersement;
    private javax.swing.JPanel imgVersementC;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel16;
    private javax.swing.JLabel jLabel17;
    private javax.swing.JLabel jLabel18;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JLabel lblNombreTotal;
    private javax.swing.JRadioButton sexeF;
    private javax.swing.JRadioButton sexeM;
    private javax.swing.JTable tableCandidat;
    private javax.swing.JTextField txtAdrsPC;
    private javax.swing.JTextField txtDateNaisC;
    private javax.swing.JTextField txtEmailC;
    private javax.swing.JTextField txtIDC;
    private javax.swing.JComboBox txtLieuExamC;
    private javax.swing.JTextField txtLieuNaisC;
    private javax.swing.JComboBox txtMentionBaccC;
    private javax.swing.JComboBox txtNationalite;
    private javax.swing.JTextField txtNomC;
    private javax.swing.JTextField txtNumInscriC;
    private javax.swing.JComboBox txtParcoursC;
    private javax.swing.JTextField txtPrenomC;
    private javax.swing.JTextField txtRecherch;
    private javax.swing.JComboBox txtSerieC;
    private javax.swing.JComboBox txtSituationMatC;
    private javax.swing.JTextField txtTelC;
    private javax.swing.JTextField txtpathDemande;
    private javax.swing.JTextField txtpathFiche;
    private javax.swing.JTextField txtpathPhoto;
    private javax.swing.JTextField txtpathReleve;
    private javax.swing.JTextField txtpathVersement;
    private javax.swing.JTextField txtpathcopie;
    // End of variables declaration//GEN-END:variables
}
