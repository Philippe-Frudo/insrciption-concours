
package formulaire;

import classes.Candidat;
import com.barcodelib.barcode.a.f.e;
import gestion.GestionCandidat;
import gestion.GestionLieuExam;
import gestion.GestionMention;
import java.awt.Color;
import java.awt.Font;
import java.awt.Image;
import java.awt.event.ContainerListener;
import java.awt.image.BufferedImage;
import static java.awt.image.ImageObserver.WIDTH;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import static java.lang.String.join;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.StandardCopyOption;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.imageio.ImageIO;
import javax.swing.ButtonGroup;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JFileChooser;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JScrollPane;
import javax.swing.JTextField;
import javax.swing.border.Border;
import javax.swing.border.LineBorder;
import javax.swing.filechooser.FileNameExtensionFilter;
import javax.swing.plaf.IconUIResource;
import javax.swing.plaf.basic.BasicInternalFrameUI;
import javax.swing.table.DefaultTableModel;

/**
 * @author MSI
 */
public class inscription1 extends javax.swing.JInternalFrame {

    
    //VARIABLES
    int validateValues[] = {0,0,0,0,0};
    
    public Connection conn;
    public Statement stat;
    
    public GestionCandidat gtCand;
    public GestionMention gM;
    public GestionLieuExam gLE;

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

    public inscription1() throws Exception {
        BasicInternalFrameUI ui= (BasicInternalFrameUI)this.getUI();
        ui.setNorthPane(null);
        
        try {
             gtCand = new GestionCandidat();
            gM = new GestionMention();
            gLE = new GestionLieuExam();
        } catch (Exception e) {
            e.printStackTrace();
        }
        
        initComponents();
        
        ButtonGroup GpSexe = new ButtonGroup();
        GpSexe.add(sexeM);
        GpSexe.add(sexeF);
        sexeF.setSelected(true);
        
        
        //Appeler la methode ChargeListe()
        ChargerListe();
        
        //Appeler la methode listeDeroulantParcours()
        listeDeroulantParcours();
        
        //Appeler la methode qui affiche la liste d'examen
        listeDeroulantLieuExam();
        
//        JScrollPane scroll = new JScrollPane();
//        tableCandidat
//        tableCandidat     
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
        
        
        
        btnAjouter.setVisible(true);
        btnAjouter.setEnabled(true);
    }
   
    //Ajout de liste de la MENTION dans une liste deroulante
    public void listeDeroulantParcours(){
                   
    try {
            ResultSet rslM = gM.getAll();
            int i = 0;
            while(rslM.next()){
                txtParcoursC.addItem( rslM.getString("nomM") );
                i++;
            }
        } catch (Exception e) {
            System.err.println("Erreur de charger Liste de Mention");
            e.printStackTrace();
        }
    }
    
    //Ajout de liste de lieu d'examen dans une liste deroulante
    public void listeDeroulantLieuExam(){
        cherchPerLE.addItem("Afficher tous");
        try {
            ResultSet rslLE = gLE.getAll();
            int j = 0;
            while(rslLE.next()){
                txtLieuExamC.addItem( rslLE.getString("lieu") );
                cherchPerLE.addItem( rslLE.getString("lieu") );
                j++;
            }
        } catch (Exception e) {
            System.err.println("Erreur de charger la Liste de Lieu d'Examen");
            e.printStackTrace();
        }
    }
    
    
    //Affichage de liste de candidat dans une table
    public void ChargerListe(){
        String titre[] = {"ID", "Nom", "Prenom", "Date de naissance", "Lieu de naissance", "Situation Matrimoniale", 
            "Sexe", "Nationalite", "Adresse", "Email", "Telephone", "Numero Bacc", "Serie Bacc", "Mention Bacc", "Mention", "Lieu"};
        Object enreg[][] = new Object[1][1];
        
        try {
            int nbr = gtCand.countEnreg();
            lblNombreTotal.setText( String.valueOf(nbr) );
            enreg = new Object[nbr][titre.length];
            
            ResultSet rs1 = gtCand.getAll(); 
            int i = 0;
            while( rs1.next() ){
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
            System.out.println("Erreur Chargement ");
            e.printStackTrace(); 
        }
        tableCandidat.setModel( new DefaultTableModel(enreg, titre) );
        jScrollPane1.setViewportView(tableCandidat);  
    }
    
    public void nombreTousChaqueMention() throws Exception{
        
                ResultSet rs1Total = gtCand.nombreChaqueParcours();
                String nomM[] = new String[10];
                String nombreC[] = new String[10];
                
                int j = 0;
                while(rs1Total.next()){
                    nomM[j] = rs1Total.getString("nomM")+":";
                    nombreC[j] = rs1Total.getString("nombreC");
                    j++;
                }
                System.out.println("Nombre m ="+j);
                System.out.println(nombreC[0]);
                /**String lblLieu[] = {"lblLieu1", "lblLieu2", "lblLieu3"};
                String lblTotalLieu[] = {"lblTotalLieu1", "lblTotalLieu2", "lblTotalLieu3"};*/
                
                if (j == 1) {
                    lblLieu1.setText(nomM[0]);
                    lblTotalLieu1.setText(nombreC[0]);
                    System.out.println(nomM[0]);
                    System.out.println(nombreC[0]);
                    
                } else if(j == 2) {
                    lblLieu1.setText(nomM[0]);
                    lblTotalLieu1.setText(nombreC[0]);
                
                    lblLieu2.setText(nomM[1]);
                    lblTotalLieu2.setText(nombreC[1]);
                    
                }else if(j == 3) {
                    lblLieu1.setText(nomM[0]);
                    lblTotalLieu1.setText(nombreC[0]);
                
                    lblLieu2.setText(nomM[1]);
                    lblTotalLieu2.setText(nombreC[1]);
                    
                    lblLieu3.setText(nomM[2]);
                    lblTotalLieu3.setText(nombreC[2]);
                }else{
                    
                }
    }
    
    public ImageIcon ResizeIMG(String imagePath, JLabel Image_lbl_contain){
        ImageIcon myImage = new ImageIcon(imagePath);
        Image imge = myImage.getImage();
        Image newImage = imge.getScaledInstance(Image_lbl_contain.getWidth(), Image_lbl_contain.getHeight(), Image.SCALE_SMOOTH);
        ImageIcon image = new ImageIcon(newImage);
        return image;
    }
    
    
    
   /** INPUT VALID */
    public void redBorder(JTextField txt){
        Border redBorder = new LineBorder(Color.RED);
        txt.setBorder(redBorder);
    }
    
     public void CyanBorder(JTextField txt){
        Border redBorder = new LineBorder(Color.LIGHT_GRAY);
        txt.setBorder(redBorder);
    }
    
    private void vierifyValide(){
        if (AllValide()) this.btnAjouter.setEnabled(true);
        else this.btnAjouter.setEnabled(true);
    }
    
    private boolean AllValide(){
        for(int i=0; i<validateValues.length;i++){
           if (this.validateValues[i]==0) return false;
        }
        return true;
    }
    
    private boolean validDate(String date){
        String separated[] = date.split("-");
        if(separated.length!=3) return false;
        else{
            if(separated[0].length()!=4 || separated[1].length()!=2 || separated[2].length()!=2) return false;
            return true;
        }
    }
    
    private String removeLast(String[] str){
        String[] result = new String[str.length-1];
        for(int i=0;i<result.length;i++){
            result[i]=str[i];
        }
        return join("", result);
    }
    
    private boolean isInt(String str){
        return str.matches("\\d"); 
    }
     
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        txtRecherch = new javax.swing.JTextField();
        lblNombreTotal = new javax.swing.JLabel();
        jLabel18 = new javax.swing.JLabel();
        cherchPerLE = new javax.swing.JComboBox();
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
        pane2 = new javax.swing.JPanel();
        imgVersement = new javax.swing.JLabel();
        imgReleveC = new javax.swing.JPanel();
        imgReleve = new javax.swing.JLabel();
        imgCopieAEC = new javax.swing.JPanel();
        imgCopie = new javax.swing.JLabel();
        pane = new javax.swing.JPanel();
        imgDemande = new javax.swing.JLabel();
        pane3 = new javax.swing.JPanel();
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
        jPanel2 = new javax.swing.JPanel();
        jLabel19 = new javax.swing.JLabel();
        lblLieu1 = new javax.swing.JLabel();
        jLabel21 = new javax.swing.JLabel();
        jLabel22 = new javax.swing.JLabel();
        lblTotalLieu1 = new javax.swing.JLabel();
        lblLieu2 = new javax.swing.JLabel();
        lblTotalLieu2 = new javax.swing.JLabel();
        lblLieu3 = new javax.swing.JLabel();
        lblTotalLieu3 = new javax.swing.JLabel();

        setBackground(new java.awt.Color(255, 255, 255));
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabel1.setText("S'incrire");
        jPanel1.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(26, 0, 187, 40));

        txtRecherch.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        txtRecherch.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                txtRecherchKeyPressed(evt);
            }
        });
        jPanel1.add(txtRecherch, new org.netbeans.lib.awtextra.AbsoluteConstraints(1351, 0, 241, 40));

        lblNombreTotal.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jPanel1.add(lblNombreTotal, new org.netbeans.lib.awtextra.AbsoluteConstraints(970, 10, 60, 20));

        jLabel18.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jLabel18.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        jLabel18.setText("Nobre total:");
        jLabel18.setVerticalAlignment(javax.swing.SwingConstants.BOTTOM);
        jPanel1.add(jLabel18, new org.netbeans.lib.awtextra.AbsoluteConstraints(890, 10, 80, 20));

        cherchPerLE.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        cherchPerLE.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                cherchPerLEItemStateChanged(evt);
            }
        });
        jPanel1.add(cherchPerLE, new org.netbeans.lib.awtextra.AbsoluteConstraints(1100, 0, 210, 40));

        getContentPane().add(jPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 1592, -1));

        tableCandidat.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        tableCandidat.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null, null, null, null, null, null, null, null, null, null}
            },
            new String [] {
                "N", "Nom", "Prenom", "Date de Naissance", "Lieu de naissance", "Sexe", "Situation Matimoniale", "Nationalite", "Adresse Postale", "Email", "Telephone", "N  BACC", "Serie BACC", "Mention BACC", "Parcours"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                true, false, false, false, false, false, false, false, false, false, false, false, false, true, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        tableCandidat.setRowHeight(30);
        tableCandidat.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseReleased(java.awt.event.MouseEvent evt) {
                tableCandidatMouseReleased(evt);
            }
        });
        jScrollPane1.setViewportView(tableCandidat);
        if (tableCandidat.getColumnModel().getColumnCount() > 0) {
            tableCandidat.getColumnModel().getColumn(0).setPreferredWidth(30);
            tableCandidat.getColumnModel().getColumn(0).setMaxWidth(30);
            tableCandidat.getColumnModel().getColumn(5).setPreferredWidth(50);
            tableCandidat.getColumnModel().getColumn(5).setMaxWidth(50);
            tableCandidat.getColumnModel().getColumn(11).setMaxWidth(80);
            tableCandidat.getColumnModel().getColumn(12).setPreferredWidth(80);
            tableCandidat.getColumnModel().getColumn(12).setMaxWidth(80);
        }

        getContentPane().add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 58, 1572, 260));

        jLabel2.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel2.setText("Numero:");
        getContentPane().add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 460, 62, 26));

        jLabel3.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel3.setText("Nom:");
        getContentPane().add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 500, -1, 27));

        jLabel4.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel4.setText("Prenom:");
        getContentPane().add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 540, 60, 27));

        jLabel5.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel5.setText("Date de naissance:");
        getContentPane().add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 580, -1, 20));

        jLabel6.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel6.setText("Lieu de naissance:");
        getContentPane().add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 620, 114, 31));

        jLabel7.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel7.setText("Sexe:");
        getContentPane().add(jLabel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 670, 54, 31));

        jLabel8.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel8.setText("Situation matrimoniale:");
        getContentPane().add(jLabel8, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 710, -1, 31));

        jLabel9.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel9.setText("Nationalite:");
        getContentPane().add(jLabel9, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 750, -1, 31));

        sexeM.setText("Masculin");
        getContentPane().add(sexeM, new org.netbeans.lib.awtextra.AbsoluteConstraints(130, 670, -1, -1));

        sexeF.setText("Feminin");
        getContentPane().add(sexeF, new org.netbeans.lib.awtextra.AbsoluteConstraints(250, 670, -1, -1));

        txtNationalite.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Malagasy", "Etranger" }));
        txtNationalite.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtNationaliteActionPerformed(evt);
            }
        });
        getContentPane().add(txtNationalite, new org.netbeans.lib.awtextra.AbsoluteConstraints(160, 750, 150, 31));

        txtIDC.setEnabled(false);
        getContentPane().add(txtIDC, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 450, 250, 36));
        getContentPane().add(txtNomC, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 500, 250, 31));
        getContentPane().add(txtPrenomC, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 540, 250, 31));

        txtDateNaisC.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txtDateNaisCKeyReleased(evt);
            }
        });
        getContentPane().add(txtDateNaisC, new org.netbeans.lib.awtextra.AbsoluteConstraints(130, 580, 186, 31));
        getContentPane().add(txtLieuNaisC, new org.netbeans.lib.awtextra.AbsoluteConstraints(130, 620, 186, 31));

        getContentPane().add(txtLieuExamC, new org.netbeans.lib.awtextra.AbsoluteConstraints(611, 700, 260, 31));

        txtParcoursC.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        getContentPane().add(txtParcoursC, new org.netbeans.lib.awtextra.AbsoluteConstraints(610, 740, 260, 31));

        txtSerieC.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "A", "D", "C", "OSE", "L", "Technique" }));
        getContentPane().add(txtSerieC, new org.netbeans.lib.awtextra.AbsoluteConstraints(678, 610, 190, 31));

        txtNumInscriC.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txtNumInscriCKeyReleased(evt);
            }
        });
        getContentPane().add(txtNumInscriC, new org.netbeans.lib.awtextra.AbsoluteConstraints(680, 570, 190, 31));

        jLabel10.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel10.setText("Adresse postale:");
        getContentPane().add(jLabel10, new org.netbeans.lib.awtextra.AbsoluteConstraints(510, 450, -1, 31));

        jLabel11.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel11.setText("Email:");
        getContentPane().add(jLabel11, new org.netbeans.lib.awtextra.AbsoluteConstraints(510, 490, -1, 31));

        jLabel12.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel12.setText("Telephone:");
        getContentPane().add(jLabel12, new org.netbeans.lib.awtextra.AbsoluteConstraints(510, 530, -1, 31));

        jLabel13.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel13.setText("Numero d'inscription BACC:");
        getContentPane().add(jLabel13, new org.netbeans.lib.awtextra.AbsoluteConstraints(510, 570, -1, 31));

        jLabel14.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel14.setText("Serie:");
        getContentPane().add(jLabel14, new org.netbeans.lib.awtextra.AbsoluteConstraints(510, 610, -1, 31));

        jLabel15.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel15.setText("Mention:");
        getContentPane().add(jLabel15, new org.netbeans.lib.awtextra.AbsoluteConstraints(510, 650, -1, 31));

        jLabel16.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel16.setText("Lieu d'examen:");
        getContentPane().add(jLabel16, new org.netbeans.lib.awtextra.AbsoluteConstraints(510, 700, -1, 31));

        jLabel17.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel17.setText("Parcours:");
        getContentPane().add(jLabel17, new org.netbeans.lib.awtextra.AbsoluteConstraints(510, 740, -1, 31));
        getContentPane().add(txtAdrsPC, new org.netbeans.lib.awtextra.AbsoluteConstraints(610, 450, 261, 31));
        getContentPane().add(txtEmailC, new org.netbeans.lib.awtextra.AbsoluteConstraints(608, 490, 260, 31));

        txtTelC.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtTelCActionPerformed(evt);
            }
        });
        txtTelC.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txtTelCKeyReleased(evt);
            }
        });
        getContentPane().add(txtTelC, new org.netbeans.lib.awtextra.AbsoluteConstraints(610, 530, 260, 31));

        imgFiche.setBackground(new java.awt.Color(204, 204, 204));

        imgFicheC.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        imgFicheC.setForeground(new java.awt.Color(51, 51, 0));
        imgFicheC.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        imgFicheC.setText("Fiche");
        imgFicheC.setBorder(javax.swing.BorderFactory.createEtchedBorder(java.awt.Color.lightGray, null));
        imgFicheC.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                imgFicheCMouseClicked(evt);
            }
        });

        javax.swing.GroupLayout imgFicheLayout = new javax.swing.GroupLayout(imgFiche);
        imgFiche.setLayout(imgFicheLayout);
        imgFicheLayout.setHorizontalGroup(
            imgFicheLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(imgFicheC, javax.swing.GroupLayout.PREFERRED_SIZE, 180, javax.swing.GroupLayout.PREFERRED_SIZE)
        );
        imgFicheLayout.setVerticalGroup(
            imgFicheLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(imgFicheC, javax.swing.GroupLayout.PREFERRED_SIZE, 160, javax.swing.GroupLayout.PREFERRED_SIZE)
        );

        getContentPane().add(imgFiche, new org.netbeans.lib.awtextra.AbsoluteConstraints(1401, 610, 180, 160));

        pane2.setBackground(new java.awt.Color(204, 204, 204));

        imgVersement.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        imgVersement.setForeground(new java.awt.Color(51, 51, 0));
        imgVersement.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        imgVersement.setText("Versement");
        imgVersement.setBorder(javax.swing.BorderFactory.createEtchedBorder(java.awt.Color.lightGray, null));
        imgVersement.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                imgVersementMouseClicked(evt);
            }
        });

        javax.swing.GroupLayout pane2Layout = new javax.swing.GroupLayout(pane2);
        pane2.setLayout(pane2Layout);
        pane2Layout.setHorizontalGroup(
            pane2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, pane2Layout.createSequentialGroup()
                .addGap(0, 2, Short.MAX_VALUE)
                .addComponent(imgVersement, javax.swing.GroupLayout.PREFERRED_SIZE, 178, javax.swing.GroupLayout.PREFERRED_SIZE))
        );
        pane2Layout.setVerticalGroup(
            pane2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(imgVersement, javax.swing.GroupLayout.DEFAULT_SIZE, 160, Short.MAX_VALUE)
        );

        getContentPane().add(pane2, new org.netbeans.lib.awtextra.AbsoluteConstraints(1191, 611, 180, 160));

        imgReleveC.setBackground(new java.awt.Color(204, 204, 204));
        imgReleveC.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        imgReleve.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        imgReleve.setForeground(new java.awt.Color(51, 51, 0));
        imgReleve.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        imgReleve.setText("Releve");
        imgReleve.setBorder(javax.swing.BorderFactory.createEtchedBorder(java.awt.Color.lightGray, null));
        imgReleve.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                imgReleveMouseClicked(evt);
            }
        });
        imgReleveC.add(imgReleve, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, -2, 190, 160));

        getContentPane().add(imgReleveC, new org.netbeans.lib.awtextra.AbsoluteConstraints(960, 610, 190, -1));

        imgCopieAEC.setBackground(new java.awt.Color(204, 204, 204));

        imgCopie.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        imgCopie.setForeground(new java.awt.Color(51, 51, 0));
        imgCopie.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        imgCopie.setText("Copie");
        imgCopie.setBorder(javax.swing.BorderFactory.createEtchedBorder(java.awt.Color.lightGray, null));
        imgCopie.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                imgCopieMouseClicked(evt);
            }
        });

        javax.swing.GroupLayout imgCopieAECLayout = new javax.swing.GroupLayout(imgCopieAEC);
        imgCopieAEC.setLayout(imgCopieAECLayout);
        imgCopieAECLayout.setHorizontalGroup(
            imgCopieAECLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(imgCopie, javax.swing.GroupLayout.PREFERRED_SIZE, 180, javax.swing.GroupLayout.PREFERRED_SIZE)
        );
        imgCopieAECLayout.setVerticalGroup(
            imgCopieAECLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(imgCopie, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE)
        );

        getContentPane().add(imgCopieAEC, new org.netbeans.lib.awtextra.AbsoluteConstraints(1400, 450, 180, -1));

        pane.setBackground(new java.awt.Color(204, 204, 204));

        imgDemande.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        imgDemande.setForeground(new java.awt.Color(51, 51, 0));
        imgDemande.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        imgDemande.setText("Demande");
        imgDemande.setBorder(javax.swing.BorderFactory.createEtchedBorder(java.awt.Color.lightGray, null));
        imgDemande.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                imgDemandeMouseClicked(evt);
            }
        });

        javax.swing.GroupLayout paneLayout = new javax.swing.GroupLayout(pane);
        pane.setLayout(paneLayout);
        paneLayout.setHorizontalGroup(
            paneLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(imgDemande, javax.swing.GroupLayout.DEFAULT_SIZE, 180, Short.MAX_VALUE)
        );
        paneLayout.setVerticalGroup(
            paneLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(imgDemande, javax.swing.GroupLayout.DEFAULT_SIZE, 150, Short.MAX_VALUE)
        );

        getContentPane().add(pane, new org.netbeans.lib.awtextra.AbsoluteConstraints(1190, 450, 180, -1));

        pane3.setBackground(new java.awt.Color(204, 204, 204));

        imgPhoto.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        imgPhoto.setForeground(new java.awt.Color(51, 51, 0));
        imgPhoto.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        imgPhoto.setText("Photo");
        imgPhoto.setBorder(javax.swing.BorderFactory.createEtchedBorder(java.awt.Color.lightGray, null));
        imgPhoto.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                imgPhotoMouseClicked(evt);
            }
        });

        javax.swing.GroupLayout pane3Layout = new javax.swing.GroupLayout(pane3);
        pane3.setLayout(pane3Layout);
        pane3Layout.setHorizontalGroup(
            pane3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(imgPhoto, javax.swing.GroupLayout.DEFAULT_SIZE, 190, Short.MAX_VALUE)
        );
        pane3Layout.setVerticalGroup(
            pane3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(imgPhoto, javax.swing.GroupLayout.DEFAULT_SIZE, 150, Short.MAX_VALUE)
        );

        getContentPane().add(pane3, new org.netbeans.lib.awtextra.AbsoluteConstraints(960, 450, 190, 150));

        txtSituationMatC.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Celibataire", "Mari", "Marie", "Divorce" }));
        getContentPane().add(txtSituationMatC, new org.netbeans.lib.awtextra.AbsoluteConstraints(160, 710, 156, 31));

        txtMentionBaccC.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Passable", "Assez bien", "Bien", "Tres bien", "Honorable" }));
        getContentPane().add(txtMentionBaccC, new org.netbeans.lib.awtextra.AbsoluteConstraints(677, 650, 190, 31));

        btnAjouter.setBackground(new java.awt.Color(38, 54, 212));
        btnAjouter.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        btnAjouter.setForeground(new java.awt.Color(255, 255, 255));
        btnAjouter.setText("Ajouter");
        btnAjouter.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        btnAjouter.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAjouterActionPerformed(evt);
            }
        });
        getContentPane().add(btnAjouter, new org.netbeans.lib.awtextra.AbsoluteConstraints(1110, 820, 169, 39));

        btnModifier.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        btnModifier.setText("Modifier");
        btnModifier.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        btnModifier.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnModifierActionPerformed(evt);
            }
        });
        getContentPane().add(btnModifier, new org.netbeans.lib.awtextra.AbsoluteConstraints(880, 820, 177, 39));

        btnSupprimer.setBackground(new java.awt.Color(255, 51, 51));
        btnSupprimer.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        btnSupprimer.setForeground(new java.awt.Color(255, 255, 255));
        btnSupprimer.setText("Supprimer");
        btnSupprimer.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        btnSupprimer.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSupprimerActionPerformed(evt);
            }
        });
        getContentPane().add(btnSupprimer, new org.netbeans.lib.awtextra.AbsoluteConstraints(660, 820, 177, 39));

        btnAnnuler.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        btnAnnuler.setText("Annuler");
        btnAnnuler.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        btnAnnuler.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAnnulerActionPerformed(evt);
            }
        });
        getContentPane().add(btnAnnuler, new org.netbeans.lib.awtextra.AbsoluteConstraints(450, 820, 169, 39));

        txtpathPhoto.setEnabled(false);
        txtpathPhoto.setPreferredSize(new java.awt.Dimension(0, 0));
        getContentPane().add(txtpathPhoto, new org.netbeans.lib.awtextra.AbsoluteConstraints(1430, 433, -1, -1));

        txtpathDemande.setEnabled(false);
        txtpathDemande.setPreferredSize(new java.awt.Dimension(0, 0));
        getContentPane().add(txtpathDemande, new org.netbeans.lib.awtextra.AbsoluteConstraints(1430, 444, -1, -1));

        txtpathcopie.setEnabled(false);
        txtpathcopie.setPreferredSize(new java.awt.Dimension(0, 0));
        getContentPane().add(txtpathcopie, new org.netbeans.lib.awtextra.AbsoluteConstraints(1430, 462, -1, -1));

        txtpathReleve.setEnabled(false);
        txtpathReleve.setPreferredSize(new java.awt.Dimension(0, 0));
        getContentPane().add(txtpathReleve, new org.netbeans.lib.awtextra.AbsoluteConstraints(1430, 480, -1, -1));

        txtpathVersement.setEnabled(false);
        txtpathVersement.setPreferredSize(new java.awt.Dimension(0, 0));
        getContentPane().add(txtpathVersement, new org.netbeans.lib.awtextra.AbsoluteConstraints(1430, 498, -1, -1));

        txtpathFiche.setEnabled(false);
        txtpathFiche.setPreferredSize(new java.awt.Dimension(0, 0));
        getContentPane().add(txtpathFiche, new org.netbeans.lib.awtextra.AbsoluteConstraints(1430, 516, -1, -1));

        btnActualiser.setText("Actualiser");
        btnActualiser.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        btnActualiser.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnActualiserActionPerformed(evt);
            }
        });
        getContentPane().add(btnActualiser, new org.netbeans.lib.awtextra.AbsoluteConstraints(250, 820, 166, 39));

        jPanel2.setBackground(new java.awt.Color(255, 255, 255));
        jPanel2.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel19.setFont(new java.awt.Font("Tahoma", 1, 10)); // NOI18N
        jLabel19.setForeground(new java.awt.Color(102, 204, 0));
        jLabel19.setText("(YYYY-MM-DD)");
        jPanel2.add(jLabel19, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 620, 110, -1));

        lblLieu1.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jPanel2.add(lblLieu1, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 340, 130, 30));
        jPanel2.add(jLabel21, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 340, 90, 30));
        jPanel2.add(jLabel22, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 340, 90, 30));

        lblTotalLieu1.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        lblTotalLieu1.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        jPanel2.add(lblTotalLieu1, new org.netbeans.lib.awtextra.AbsoluteConstraints(150, 340, 80, 30));

        lblLieu2.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jPanel2.add(lblLieu2, new org.netbeans.lib.awtextra.AbsoluteConstraints(290, 340, 130, 30));

        lblTotalLieu2.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        lblTotalLieu2.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        jPanel2.add(lblTotalLieu2, new org.netbeans.lib.awtextra.AbsoluteConstraints(420, 340, 80, 30));

        lblLieu3.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jPanel2.add(lblLieu3, new org.netbeans.lib.awtextra.AbsoluteConstraints(550, 340, 130, 30));

        lblTotalLieu3.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        lblTotalLieu3.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        jPanel2.add(lblTotalLieu3, new org.netbeans.lib.awtextra.AbsoluteConstraints(680, 340, 70, 30));

        getContentPane().add(jPanel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(-10, -20, 1650, 950));

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
    
    
    String FileNameDem;
    File destinationFileDem;
    Path filePathDem;
    private void imgDemandeMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_imgDemandeMouseClicked
//        telechargeImage( pathDemande, imgDemande, bytphotoC);
//        System.out.println("pathPhoto="+ pathDemande);
//        System.out.println("bytphotoC="+ imgDemande);      
//        JFileChooser pic = new JFileChooser();
//        pic.showOpenDialog(null);
//        File picture = pic.getSelectedFile();
//        pathDemande = picture.getAbsolutePath();
//        BufferedImage img;
//        try {
//            img = ImageIO.read( pic.getSelectedFile() );
//            ImageIcon imageIc = new ImageIcon( new ImageIcon(img).getImage().getScaledInstance(150, 150, Image.SCALE_DEFAULT) );          
//            imgDemande.setIcon(imageIc);
//            imgDemande.setText(null);
//            txtpathDemande.setText(pathDemande);    
//            System.out.println(imgDemande.getText());
//            File image = new File( pathDemande );
//            FileInputStream fis = new FileInputStream( image );    
//            ByteArrayOutputStream bos = new ByteArrayOutputStream();
//            byte[] buff = new byte[1024];   
//            for(int i; (i = fis.read(buff)) != -1; ){
//                bos.write(buff , 0, i ); 
//            }
//            bytphotoC = bos.toByteArray();
//        } catch (Exception e) {
//            System.out.println("Erreur de telechargement");
//            e.printStackTrace();
//        }
        
                //traitement d'image
        JFileChooser fileChooser = new JFileChooser();
        fileChooser.setCurrentDirectory(new File(System.getProperty("user.home")));
        FileNameExtensionFilter filter = new FileNameExtensionFilter("*.IMAGE", "jpg","png");
        fileChooser.addChoosableFileFilter(filter);
        int result = fileChooser.showSaveDialog(null);
        if (result==JFileChooser.APPROVE_OPTION){
            File selectedFile = fileChooser.getSelectedFile();
            String pathDemande = selectedFile.getAbsolutePath();
            imgDemande.setIcon(ResizeIMG(pathDemande, imgDemande));
            imgDemande.setText("");
            
            //String destination = "../Java version 2 Pieris/src/media/profil_image/";
            String destinationDem = "../InscriptionConcoursEMIT2.0/src/image/demande/";
//            "C:\Users\MSI\Desktop\Java version 2 Pieris\src\projet_java\modal_personnel.java";
//            C:\Users\MSI\Documents\NetBeansProjects\InscriptionConcoursEMIT2.0\src\formulaire\formEtudiant.java;
            String nameFile = selectedFile.getName();
            filePathDem = selectedFile.toPath();
            System.out.println("filePathDem= "+filePathDem);
            destinationFileDem = new File(destinationDem, nameFile);
            FileNameDem = nameFile;
        }
        
    }//GEN-LAST:event_imgDemandeMouseClicked

    
    String FileNameCopie;
    File destinationFileCopie;
    Path filePathCopie;
    private void imgCopieMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_imgCopieMouseClicked
//        telechargeImage( pathCopie, imgCopie, bytcopieAEC);
//        System.out.println("pathCopie="+ pathCopie);
//        System.out.println("bytcopieAEC="+ bytcopieAEC);
        
//        JFileChooser pic = new JFileChooser();
//        pic.showOpenDialog(null);
//    
//        File picture = pic.getSelectedFile();
//        pathCopie = picture.getAbsolutePath();
//        BufferedImage img;
//        
//        try {
//            img = ImageIO.read( pic.getSelectedFile() );
//            ImageIcon imageIc = new ImageIcon( new ImageIcon(img).getImage().getScaledInstance(150, 150, Image.SCALE_DEFAULT) );
//            
//            imgCopie.setIcon(imageIc);
//            imgCopie.setText(null);
//            txtpathcopie.setText(pathCopie);
//            
//            File image = new File( pathCopie );
//            FileInputStream fis = new FileInputStream( image );
//            
//            ByteArrayOutputStream bos = new ByteArrayOutputStream();
//            byte[] buff = new byte[1024];
//            
//            for(int i; (i = fis.read(buff)) != -1; ){
//                bos.write(buff , 0, i ); 
//            }
//            bytcopieAEC = bos.toByteArray();
//
//        } catch (Exception e) {
//            System.out.println("Erreur de telechargement");
//            e.printStackTrace();
//        }
        
         //traitement d'image
        JFileChooser fileChooser = new JFileChooser();
        fileChooser.setCurrentDirectory(new File(System.getProperty("user.home")));
        FileNameExtensionFilter filter = new FileNameExtensionFilter("*.IMAGE", "jpg","png");
        fileChooser.addChoosableFileFilter(filter);
        int result = fileChooser.showSaveDialog(null);
        if (result==JFileChooser.APPROVE_OPTION){
            File selectedFile = fileChooser.getSelectedFile();
            String pathCopie = selectedFile.getAbsolutePath();
            imgCopie.setIcon(ResizeIMG(pathCopie, imgCopie));
            imgCopie.setText("");
            
            String destinationCopie = "../InscriptionConcoursEMIT2.0/src/image/copie_cand/";
            String nameFile = selectedFile.getName();
            filePathCopie = selectedFile.toPath();
            destinationFileCopie = new File(destinationCopie, nameFile);
            FileNameCopie = nameFile;
        }
    }//GEN-LAST:event_imgCopieMouseClicked

    
    String FileNameReleve;
    File destinationFileReleve;
    Path filePathReleve;
    private void imgReleveMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_imgReleveMouseClicked
//        telechargeImage( pathReleveOUDipl, imgReleve, bytreleveOuDiplome);
//        System.out.println("pathReleveOUDipl="+ pathReleveOUDipl);
//        System.out.println("bytreleveOuDiplome="+ bytreleveOuDiplome);
//        
//        JFileChooser pic = new JFileChooser();
//        pic.showOpenDialog(null);
//    
//        File picture = pic.getSelectedFile();
//        pathReleveOUDipl = picture.getAbsolutePath();
//        BufferedImage img;
//        
//        try {
//            img = ImageIO.read( pic.getSelectedFile() );
//            ImageIcon imageIc = new ImageIcon( new ImageIcon(img).getImage().getScaledInstance(150, 150, Image.SCALE_DEFAULT) );
//            
//            imgReleve.setIcon(imageIc);
//            imgReleve.setText(null);
//            txtpathReleve.setText(pathReleveOUDipl);
//            
//            File image = new File( pathReleveOUDipl );
//            FileInputStream fis = new FileInputStream( image );
//            
//            ByteArrayOutputStream bos = new ByteArrayOutputStream();
//            byte[] buff = new byte[1024];
//            
//            for(int i; (i = fis.read(buff)) != -1; ){
//                bos.write(buff , 0, i ); 
//            }
//            bytreleveOuDiplome = bos.toByteArray();
//
//        } catch (Exception e) {
//            System.out.println("Erreur de telechargement");
//            e.printStackTrace();
//        }
        
                 //traitement d'image
        JFileChooser fileChooser = new JFileChooser();
        fileChooser.setCurrentDirectory(new File(System.getProperty("user.home")));
        FileNameExtensionFilter filter = new FileNameExtensionFilter("*.IMAGE", "jpg","png");
        fileChooser.addChoosableFileFilter(filter);
        int result = fileChooser.showSaveDialog(null);
        if (result==JFileChooser.APPROVE_OPTION){
            File selectedFile = fileChooser.getSelectedFile();
            String pathReleve = selectedFile.getAbsolutePath();
            imgReleve.setIcon(ResizeIMG(pathReleve, imgReleve));
            imgReleve.setText("");
            
            String destinationCopie = "../InscriptionConcoursEMIT2.0/src/image/releveOuDiplome/";
            String nameFile = selectedFile.getName();
            filePathReleve = selectedFile.toPath();
            destinationFileReleve = new File(destinationCopie, nameFile);
            FileNameReleve = nameFile;
        }
    }//GEN-LAST:event_imgReleveMouseClicked

    
    String FileNameVers;
    File destinationFileVers;
    Path filePathVers;
    private void imgVersementMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_imgVersementMouseClicked
//        telechargeImage( pathVersement, imgVersement, bytrecuVers);
//        System.out.println("pathVersement="+ pathVersement);
//        System.out.println("bytrecuVers="+ bytrecuVers);
        
//        JFileChooser pic = new JFileChooser();
//        pic.showOpenDialog(null);
//
//        File picture = pic.getSelectedFile();
//        pathVersement = picture.getAbsolutePath();
//        BufferedImage img;
//        
//        try {
//            img = ImageIO.read( pic.getSelectedFile() );
//            ImageIcon imageIc = new ImageIcon( new ImageIcon(img).getImage().getScaledInstance(150, 150, Image.SCALE_DEFAULT) );
//            
//            imgVersement.setIcon(imageIc);
//            imgVersement.setText(null);
//            txtpathVersement.setText(pathVersement);
//            
//            File image = new File( pathVersement );
//            FileInputStream fis = new FileInputStream( image );
//            
//            ByteArrayOutputStream bos = new ByteArrayOutputStream();
//            byte[] buff = new byte[1024];
//            
//            for(int i; (i = fis.read(buff)) != -1; ){
//                bos.write(buff , 0, i ); 
//            }
//            bytrecuVers = bos.toByteArray();
//
//        } catch (Exception e) {
//            System.out.println("Erreur de telechargement");
//            e.printStackTrace();
//        }
        
        //traitement d'image
        JFileChooser fileChooser = new JFileChooser();
        fileChooser.setCurrentDirectory(new File(System.getProperty("user.home")));
        FileNameExtensionFilter filter = new FileNameExtensionFilter("*.IMAGE", "jpg","png");
        fileChooser.addChoosableFileFilter(filter);
        int result = fileChooser.showSaveDialog(null);
        if (result==JFileChooser.APPROVE_OPTION){
            File selectedFile = fileChooser.getSelectedFile();
            String pathVers = selectedFile.getAbsolutePath();
            imgVersement.setIcon(ResizeIMG(pathVers, imgVersement));
            imgVersement.setText("");
            
            //String destinationVers = "../InscriptionConcoursEMIT2.0/src/image/versement_cand/";
            String destinationVers = "../InscriptionConcoursEMIT2.0/src/image/versement_cand/";
            String nameFile = selectedFile.getName();
            filePathVers = selectedFile.toPath();
            destinationFileVers = new File(destinationVers, nameFile);
            FileNameVers = nameFile;
        }
    }//GEN-LAST:event_imgVersementMouseClicked

  
    String FileNameFiche;
    File destinationFileFiche;
    Path filePathFiche;
    private void imgFicheCMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_imgFicheCMouseClicked
//        telechargeImage( pathFiche, imgFicheC, bytfiche);
//        System.out.println("pathVersement="+ pathVersement);
//        System.out.println("bytfiche="+ bytfiche);
        
//        JFileChooser pic = new JFileChooser();
//        pic.showOpenDialog(null);
//
//        File picture = pic.getSelectedFile();
//        pathFiche = picture.getAbsolutePath();
//        BufferedImage img;
//        
//        try {
//            img = ImageIO.read( pic.getSelectedFile() );
//            ImageIcon imageIc = new ImageIcon( new ImageIcon(img).getImage().getScaledInstance(150, 150, Image.SCALE_DEFAULT) );
//            
//            imgFicheC.setIcon(imageIc);
//            imgFicheC.setText(null);
//            txtpathFiche.setText(pathFiche);
//            
//            File image = new File( pathFiche );
//            FileInputStream fis = new FileInputStream( image );
//            
//            ByteArrayOutputStream bos = new ByteArrayOutputStream();
//            byte[] buff = new byte[1024];
//            
//            for(int i; (i = fis.read(buff)) != -1; ){
//                bos.write(buff , 0, i ); 
//            }
//            bytfiche = bos.toByteArray();
//
//        } catch (Exception e) {
//            System.out.println("Erreur de telechargement");
//            e.printStackTrace();
//        }
        
        
        //traitement d'image
        JFileChooser fileChooser = new JFileChooser();
        fileChooser.setCurrentDirectory(new File(System.getProperty("user.home")));
        FileNameExtensionFilter filter = new FileNameExtensionFilter("*.IMAGE", "jpg","png");
        fileChooser.addChoosableFileFilter(filter);
        int result = fileChooser.showSaveDialog(null);
        if (result==JFileChooser.APPROVE_OPTION){
            File selectedFile = fileChooser.getSelectedFile();
            String pathVers = selectedFile.getAbsolutePath();
            imgFicheC.setIcon(ResizeIMG(pathVers, imgFicheC));
            imgFicheC.setText("");
            
            String destinationFiche = "../InscriptionConcoursEMIT2.0/src/image/Fiche_cand/";
            String nameFile = selectedFile.getName();
            filePathFiche = selectedFile.toPath();
            destinationFileFiche = new File(destinationFiche, nameFile);
            FileNameFiche = nameFile;
        }
    }//GEN-LAST:event_imgFicheCMouseClicked

    
    String FileNamePhoto;
    File destinationFilePhoto;
    Path filePathPhoto;
    private void imgPhotoMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_imgPhotoMouseClicked
//         telechargeImage( pathPhoto, imgPhoto, bytphotoC);
//        System.out.println("pathPhoto="+ pathPhoto);
//        System.out.println("bytphotoC="+ bytphotoC);
        
//        JFileChooser pic = new JFileChooser();
//        pic.showOpenDialog(null);
//        File picture = pic.getSelectedFile();
//        
//        pathPhoto = picture.getAbsolutePath();
//        //System.out.println( " 931= "+pathPhoto);
//        BufferedImage img;
//        
//        try {
//            img = ImageIO.read( pic.getSelectedFile() );
//            //System.out.println( " 936= "+img);
//            ImageIcon imageIc = new ImageIcon( new ImageIcon(img).getImage().getScaledInstance(150, 150, Image.SCALE_DEFAULT) );
//            //System.out.println( " 938= "+imageIc);
//            
//            imgPhoto.setIcon(imageIc);
//            imgPhoto.setText("");
//            txtpathPhoto.setText(pathPhoto);
//            
//            File image = new File( pathPhoto );
//            //System.out.println( " 942= "+image);
//            
//            FileInputStream fis = new FileInputStream( image );
//            //System.out.println( " 945= "+fis);
//            
//            ByteArrayOutputStream bos = new ByteArrayOutputStream();
//            byte[] buff = new byte[1024];
//            
//            for(int i; (i = fis.read(buff)) != -1; ){
//                bos.write(buff , 0, i ); 
//            }
//            bytphotoC = bos.toByteArray();
//            //System.out.println( " 954= "+bytphotoC);
//            //System.out.println( " Succes= ");
//        } catch (Exception e) {
//            System.out.println("Erreur de telechargement");
//            e.printStackTrace();
//        }
        
                //traitement d'image
        JFileChooser fileChooser = new JFileChooser();
        fileChooser.setCurrentDirectory(new File(System.getProperty("user.home")));
        FileNameExtensionFilter filter = new FileNameExtensionFilter("*.IMAGE", "jpg","png");
        fileChooser.addChoosableFileFilter(filter);
        int result = fileChooser.showSaveDialog(null);
        if (result==JFileChooser.APPROVE_OPTION){
            File selectedFile = fileChooser.getSelectedFile();
            String pathPhoto = selectedFile.getAbsolutePath();
            imgPhoto.setText("");
            imgPhoto.setIcon(ResizeIMG(pathPhoto, imgPhoto));
            
            String destinationPhoto = "../InscriptionConcoursEMIT2.0/src/image/profil_cand/";
            String nameFile = selectedFile.getName();
            filePathPhoto = selectedFile.toPath();
            destinationFilePhoto = new File(destinationPhoto, nameFile);
            FileNamePhoto = nameFile;
        }
    }//GEN-LAST:event_imgPhotoMouseClicked
 
    //AJOUT DE CANDIDAT
    @SuppressWarnings("empty-statement")
    
    //AJOUTER 
    private void btnAjouterActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAjouterActionPerformed
        //System.out.println("filePathDem= "+filePathDem);
        
        String valnom = txtNomC.getText();
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
        
        /**String valrecuVers = txtpathVersement.getText();
        String valfiche = txtpathFiche.getText();
        String valdemande = txtpathDemande.getText();
        String valreleveOuDiplome = txtpathReleve.getText();
        String valcopieAEC = txtpathcopie.getText();
        String valphotoC = txtpathPhoto.getText();
        */

        String valnomMention = txtParcoursC.getSelectedItem().toString();
        String valLieu = txtLieuExamC.getSelectedItem().toString();
        int valIdLieu1 = 1;
        try {
            //Objet LIEU D'EXAMANT 
            ResultSet rslLE = gLE.getAll(); 
            int j = 1;
            while(rslLE.next()){
                if( rslLE.getString("lieu").equals(valLieu) ) {
                    valIdLieu1 = j;
                } j++;
        } } catch (Exception ex) {ex.printStackTrace();}
        
        /**try {
            String last_idC;        
            last_idC = gtCand.takeLast();
            System.out.println("LastID= "+last_idC);
        } catch (Exception ex) {
            Logger.getLogger(inscription1.class.getName()).log(Level.SEVERE, null, ex);
        }*/
        if (!txtIDC.equals("")) {
            
            if( !valnom.equals("") &&  !valdateNais.equals("") && !vallieuNais.equals("") &&  !valnation.equals("") &&  
                !valnumIBACC.equals("") &&  !valserieBACC.equals("") && !valmentionBACC.equals("") && !valnomMention.equals("") &&
                (filePathCopie!=null && !filePathCopie.equals("")) &&
                (filePathDem!=null && !filePathDem.equals("")) &&
                (filePathFiche!=null && !filePathFiche.equals("")) &&
                (filePathPhoto!=null && !filePathPhoto.equals(""))  &&
                (filePathReleve!=null && !filePathReleve.equals("")) &&
                (filePathVers!=null && !filePathVers.equals(""))
            ){
                try {
                    Files.copy(filePathCopie, destinationFileCopie.toPath(), StandardCopyOption.REPLACE_EXISTING);
                    Files.copy(filePathDem, destinationFileDem.toPath(), StandardCopyOption.REPLACE_EXISTING);
                    Files.copy(filePathFiche, destinationFileFiche.toPath(), StandardCopyOption.REPLACE_EXISTING);
                    Files.copy(filePathPhoto, destinationFilePhoto.toPath(), StandardCopyOption.REPLACE_EXISTING);
                    Files.copy(filePathReleve, destinationFileReleve.toPath(), StandardCopyOption.REPLACE_EXISTING);
                    Files.copy(filePathVers, destinationFileVers.toPath(), StandardCopyOption.REPLACE_EXISTING);

                        System.out.println("Image saved successfully.");
                    } catch (IOException ex) { 
                        ex.printStackTrace();
                        System.out.println("No image found"); 
                    } 

                try {  
                    String pathPhoto = FileNamePhoto;
                    String valrecuVers = FileNameVers;
                    String valfiche = FileNameFiche;
                    String valdemande = FileNameDem;
                    String valreleve = FileNameReleve;
                    String valcopieAEC = FileNameCopie;
                    //System.out.println("FileNameVers= "+FileNameVers +" "+ valrecuVers.length());

                    Candidat cand = new Candidat(
                       valnom, valprenom, valdateNais, vallieuNais, valsexe, valSMC, valnation, valadrsP, valemail, valtel, valnumIBACC, valserieBACC, 
                        valmentionBACC, valrecuVers, valfiche, valdemande, valreleve, valcopieAEC, pathPhoto, valnomMention, String.valueOf(valIdLieu1));

                    GestionCandidat gCand = new GestionCandidat();
                    gCand.insert(cand);
                    JOptionPane.showMessageDialog(null, "Insertion réussi!!");

                   effacerChamps();
                   ChargerListe();
                   try {
                        nombreTousChaqueMention();
                    } catch (Exception ex) {
                        Logger.getLogger(inscription1.class.getName()).log(Level.SEVERE, null, ex);
                    }

                } catch (Exception e) {
                    JOptionPane.showMessageDialog(null, "Erreur de l'enregistrement");
                    e.printStackTrace();
                }
            }
        } else {
            JOptionPane.showMessageDialog(txtIDC, " Candidat duplicquer");
        }
    }//GEN-LAST:event_btnAjouterActionPerformed

    
    //AFFICHE LIGNE SELECTIONNER
    private void tableCandidatMouseReleased(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tableCandidatMouseReleased
        btnAjouter.setVisible(false);
        
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
                
                if( ( rs1.getString("recuVers")).equals(null) ){
                }else{                    
                    imgVersement.setIcon( new ImageIcon( "C:\\Users\\MSI\\Documents\\NetBeansProjects\\InscriptionConcoursEMIT2.0\\src\\image\\versement_cand\\"+rs1.getString("recuVers") ) ); 
                    imgVersement.setText(null); 
                    FileNameVers = rs1.getString("recuVers");
                    System.out.println(FileNameVers);

                    //System.out.println("filePathVers" + filePathVers);
                    //formulaire\inscription1.java
//                    txtpathVersement.setText(rs1.getString("recuVers" ));
//                    imgVersement.setVisible(true);
                } 
                
                if( ( rs1.getString("fiche").equals(null)) ){
                }else{                   
                    //C:\Users\MSI\Documents\NetBeansProjects\InscriptionConcoursEMIT2.0\src\formulaire\main_form.java
                    imgFicheC.setIcon( new ImageIcon( "C:\\Users\\MSI\\Documents\\NetBeansProjects\\InscriptionConcoursEMIT2.0\\src\\fiche_cand\\image\\"+rs1.getString("fiche")) ); 
                    imgFicheC.setText(null);
                    FileNameFiche = rs1.getString("fiche");
                    System.out.println(FileNameFiche);
//                    txtpathFiche.setText(rs1.getString("fiche" ));
//                    imgFicheC.setVisible(true);
                } 
                
                if( ( rs1.getString("demande")).equals(null) ){   
                }else{
                    imgDemande.setIcon( new ImageIcon( "C:\\Users\\MSI\\Documents\\NetBeansProjects\\InscriptionConcoursEMIT2.0\\src\\image\\demande\\"+rs1.getString("demande")) ); 
                    imgDemande.setText(null);
                    FileNameDem = rs1.getString("demande");
                    System.out.println(FileNameDem);
//                    txtpathDemande.setText(rs1.getString("demande" ));
//                    imgDemande.setVisible(true);
                }  
                
                if( rs1.getString("releveOuDiplome").equals(null)){   
                }else{
                    imgReleve.setIcon( new ImageIcon( "C:\\Users\\MSI\\Documents\\NetBeansProjects\\InscriptionConcoursEMIT2.0\\src\\image\\releveOuDiplome\\"+rs1.getString("releveOuDiplome")) ); 
                    imgReleve.setText(null); 
                    FileNameReleve = rs1.getString("releveOuDiplome");
                    System.out.println(FileNameReleve);
//                    txtpathReleve.setText(rs1.getString("releveOuDiplome" ));
//                    imgReleve.setVisible(true);
                }
                if( ( rs1.getString("photoC")).equals(null) ){  
                }else{
                    imgPhoto.setIcon( new ImageIcon( "C:\\Users\\MSI\\Documents\\NetBeansProjects\\InscriptionConcoursEMIT2.0\\src\\image\\profil_cand\\"+rs1.getString("photoC") ) );
                    imgPhoto.setText(null); 
                    FileNamePhoto = rs1.getString("photoC");
                    System.out.println(FileNamePhoto);
//                    txtpathPhoto.setText(rs1.getString("photoC" ));
//                    imgPhoto.setVisible(true);
                }
                if( ( rs1.getString("copieAEC").equals(null)) ){
                }else{
                    imgCopie.setIcon( new ImageIcon( "C:\\Users\\MSI\\Documents\\NetBeansProjects\\InscriptionConcoursEMIT2.0\\src\\image\\copie_cand\\"+rs1.getString("copieAEC")) ); 
                    imgCopie.setText(""); 
                    FileNameCopie = rs1.getString("copieAEC");
                    System.out.println(FileNameCopie);
//                    txtpathcopie.setText(rs1.getString("copieAEC" ));
//                    imgCopie.setVisible(true);
                }
                
                txtMentionBaccC.setSelectedItem( rs1.getString("nomM") );
                txtLieuExamC.setSelectedItem( rs1.getString("idlieu") );
            } 
        } catch (Exception e) {
            e.printStackTrace();
        }   
    }//GEN-LAST:event_tableCandidatMouseReleased
  
    //VIDER TOUT LES CHAMP
    private void btnAnnulerActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAnnulerActionPerformed
        CyanBorder(txtDateNaisC);
        CyanBorder(txtNumInscriC);
        CyanBorder(txtTelC);
        effacerChamps();
    }//GEN-LAST:event_btnAnnulerActionPerformed

    //ACTUALISER LA PAGE
    private void btnActualiserActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnActualiserActionPerformed
        ChargerListe();
        effacerChamps();
        
        try {
            nombreTousChaqueMention();
        } catch (Exception ex) {
            Logger.getLogger(inscription1.class.getName()).log(Level.SEVERE, null, ex);
        }
        btnAjouter.setVisible(true);
        btnAjouter.setEnabled(true);
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
        if (!rech.equals("") && rech != null) {
        
            String titre[] = {"ID", "Nom", "Prenom", "Date de naissance", "Lieu de naissance", "Situation Matrimoniale", 
                "Sexe", "Nationalite", "Adresse", "Email", "Telephone", "Numero Bacc", "Serie Bacc", "Mention Bacc", "Mention", "Lieu"};
            Object enreg[][] = new Object[1][1];

            try {
                int nbr = gtCand.countEnreg();
                lblNombreTotal.setText( String.valueOf(nbr) );
                enreg = new Object[nbr][titre.length];

                ResultSet rs1 = gtCand.getBySearcch(rech);
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
        } else {
            ChargerListe();
        }
    }//GEN-LAST:event_txtRecherchKeyPressed

    private void txtNationaliteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtNationaliteActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtNationaliteActionPerformed

    private void cherchPerLEItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_cherchPerLEItemStateChanged
        String c = cherchPerLE.getSelectedItem().toString();
        System.out.println(c);
        
        lblLieu1.setText("");
        lblTotalLieu1.setText("");
                
        lblLieu2.setText("");
        lblTotalLieu2.setText("");
                    
        lblLieu3.setText("");
        lblTotalLieu3.setText("");
        
        /**int valIdLieu1 = 1;
        try {
            //Objet LIEU D'EXAMANT 
            ResultSet rslLE = gLE.getAll(); 
            int j = 1;
            while(rslLE.next()){
                if( rslLE.getString("lieu").equals(valLieu) ) {
                    valIdLieu1 = j;
                } j++;
        } } catch (Exception ex) {ex.printStackTrace();}*/
        if (!c.equals("") && c != null && !c.equals("Afficher tous")) {
        
            String titre[] = {"ID", "Nom", "Prenom", "Date de naissance", "Lieu de naissance", "Situation Matrimoniale", 
                "Sexe", "Nationalite", "Adresse", "Email", "Telephone", "Numero Bacc", "Serie Bacc", "Mention Bacc", "Mention", "Lieu"};
            Object enreg[][] = new Object[1][1];

            try {
                int nbr = gtCand.countEnreg();
                lblNombreTotal.setText( String.valueOf(nbr) );
                
                ResultSet rs1Total = gtCand.nombreParParcours(c);
                String nomM[] = new String[10];
                String nombreC[] = new String[10];
                
                int j = 0;
                while(rs1Total.next()){
                    nomM[j] = rs1Total.getString("nomM")+":";
                    nombreC[j] = rs1Total.getString("nombreC");
                    j++;
                }
                System.out.println("Nombre m ="+j);
                System.out.println(nombreC[0]);
                /**String lblLieu[] = {"lblLieu1", "lblLieu2", "lblLieu3"};
                String lblTotalLieu[] = {"lblTotalLieu1", "lblTotalLieu2", "lblTotalLieu3"};*/
                
                if (j == 1) {
                    lblLieu1.setText(nomM[0]);
                    lblTotalLieu1.setText(nombreC[0]);
                    System.out.println(nomM[0]);
                    System.out.println(nombreC[0]);
                    
                } else if(j == 2) {
                    lblLieu1.setText(nomM[0]);
                    lblTotalLieu1.setText(nombreC[0]);
                
                    lblLieu2.setText(nomM[1]);
                    lblTotalLieu2.setText(nombreC[1]);
                    
                }else if(j == 3) {
                    lblLieu1.setText(nomM[0]);
                    lblTotalLieu1.setText(nombreC[0]);
                
                    lblLieu2.setText(nomM[1]);
                    lblTotalLieu2.setText(nombreC[1]);
                    
                    lblLieu3.setText(nomM[2]);
                    lblTotalLieu3.setText(nombreC[2]);
                }else{
                    
                }
                
                enreg = new Object[nbr][titre.length];
                ResultSet rs1 = gtCand.getByLieu(c);
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
                lblNombreTotal.setText( String.valueOf(i) );

            } catch (Exception e) {
                e.printStackTrace();
            }
            tableCandidat.setModel( new DefaultTableModel(enreg, titre) );
            jScrollPane1.setViewportView(tableCandidat);
        } else {
            ChargerListe();
            try {
                nombreTousChaqueMention();
            } catch (Exception ex) {
                Logger.getLogger(inscription1.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        
    }//GEN-LAST:event_cherchPerLEItemStateChanged

    private void btnModifierActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnModifierActionPerformed
//        txtIDC; txtNomC; txtAdrsPC; txtPrenomC; txtDateNaisC; txtLieuNaisC;
//        txtSituationMatC; txtNationalite; txtAdrsPC; txtEmailC; txtTelC;
//        txtNumInscriC; txtSerieC; txtMentionBaccC; imgCopieAEC; imgDemandeC;
//        imgFiche; imgPhotoC; imgReleveC; imgVersementC; txtLieuExamC; txtParcoursC;
        
        String valID = txtIDC.getText();
        String valnom = txtNomC.getText();
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
        
        String pathPhoto = FileNamePhoto;
        String valrecuVers = FileNameVers;
        String valfiche = FileNameFiche;
        String valdemande = FileNameDem;
        String valreleve = FileNameReleve;
        String valcopieAEC = FileNameCopie;
        
        //System.out.println("FileNameVers= "+FileNameVers +" "+ valrecuVers.length());
        /**String valrecuVers = pathVersement;
        String valfiche = pathFiche;
        String valdemande = pathDemande;
        String valreleveOuDiplome = pathReleveOUDipl;
        String valcopieAEC = pathCopie;
        String valphotoC = pathPhoto;*/

        String valnomMention = txtParcoursC.getSelectedItem().toString();
        String valLieu = txtLieuExamC.getSelectedItem().toString();
        int valIdLieu1 = 1;
        try {
            //Objet LIEU D'EXAMANT 
            ResultSet rslLE = gLE.getAll(); 
            int j = 1;
            while( rslLE.next() )
            {
                if( rslLE.getString("lieu").equals(valLieu) ) {
                    valIdLieu1 = j;
                } 
                j++;
            } } catch (Exception ex) {ex.printStackTrace();}
        
        if(valID.equals("")) {
            JOptionPane.showMessageDialog(null, "Selectionner une ligne de tableau");
        }else{

            if (!txtIDC.equals("")) {
            
                if( !valnom.equals("") &&  !valdateNais.equals("") && !vallieuNais.equals("") &&  !valnation.equals("") &&  
                    !valnumIBACC.equals("") &&  !valserieBACC.equals("") && !valmentionBACC.equals("") && !valnomMention.equals("") &&
                    !(FileNamePhoto==null || FileNamePhoto.equals("")) &&
                    !(FileNameVers==null || FileNameVers.equals("")) &&
                    !(FileNameFiche==null || FileNameFiche.equals("")) &&
                    !(FileNameDem==null || FileNameDem.equals(""))  &&
                    !(FileNameReleve==null || FileNameReleve.equals("")) &&
                    !(FileNameCopie==null || FileNameCopie.equals(""))
                ){
                    /**try {
                        Files.copy(filePathCopie, destinationFileCopie.toPath(), StandardCopyOption.REPLACE_EXISTING);
                        Files.copy(filePathDem, destinationFileDem.toPath(), StandardCopyOption.REPLACE_EXISTING);
                        Files.copy(filePathFiche, destinationFileFiche.toPath(), StandardCopyOption.REPLACE_EXISTING);
                        Files.copy(filePathPhoto, destinationFilePhoto.toPath(), StandardCopyOption.REPLACE_EXISTING);
                        Files.copy(filePathReleve, destinationFileReleve.toPath(), StandardCopyOption.REPLACE_EXISTING);
                        Files.copy(filePathVers, destinationFileVers.toPath(), StandardCopyOption.REPLACE_EXISTING);

                            System.out.println("Image saved successfully.");
                        } catch (IOException ex) { 
                            ex.printStackTrace();
                            System.out.println("No image found"); 
                        } */
                    

                    try {  
                        Candidat cand = new Candidat(
                           valnom, valprenom, valdateNais, vallieuNais, valsexe, valSMC, valnation, valadrsP, valemail, valtel, valnumIBACC, valserieBACC, 
                            valmentionBACC, valrecuVers, valfiche, valdemande, valreleve, valcopieAEC, pathPhoto, valnomMention, String.valueOf(valIdLieu1));

                        GestionCandidat gCand = new GestionCandidat();
                        gCand.update(valID, cand);
                        JOptionPane.showMessageDialog(txtNomC, " Modification reussii !!");

                       effacerChamps();
                       ChargerListe();

                    } catch (Exception e) {
                        JOptionPane.showMessageDialog(txtNomC, "Erreur de modification");
                        e.printStackTrace();
                    }
                } else {
                    JOptionPane.showMessageDialog(null, "Remplir les champs vide");
                }
            } else {
                JOptionPane.showMessageDialog(txtIDC, " Candidat duplicquer");
            }
        }        
    }//GEN-LAST:event_btnModifierActionPerformed

    private void txtDateNaisCKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtDateNaisCKeyReleased
        String dts = txtDateNaisC.getText();
        if(dts.equals("") || dts==null || !validDate(dts)) {
            this.validateValues[3]=0;
            redBorder(txtDateNaisC);
        }
        else {this.validateValues[3]=1; CyanBorder(txtDateNaisC);}
        vierifyValide();
    }//GEN-LAST:event_txtDateNaisCKeyReleased

    private void txtTelCKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtTelCKeyReleased
        String values[] = txtTelC.getText().split("");
        String newValues = removeLast(values);
        if(isInt(values[values.length-1]) && values.length<=10) newValues+=values[values.length-1];
        txtTelC.setText(newValues);
        if (newValues.length()==10){
            this.validateValues[4]=1;
            CyanBorder(txtTelC);
        }
        else {this.validateValues[4]=0; redBorder(txtTelC);}
        vierifyValide();
    }//GEN-LAST:event_txtTelCKeyReleased

    private void txtNumInscriCKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtNumInscriCKeyReleased
        String values[] = txtNumInscriC.getText().split("");
        String newValues = removeLast(values);
        if(isInt(values[values.length-1]) && values.length<=7) newValues+=values[values.length-1];
        txtNumInscriC.setText(newValues);
        if (newValues.length()==7){
            this.validateValues[4]=1;
            CyanBorder(txtNumInscriC);
        }
        else {this.validateValues[4]=0; redBorder(txtNumInscriC);}
        vierifyValide();
    }//GEN-LAST:event_txtNumInscriCKeyReleased


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnActualiser;
    private javax.swing.JButton btnAjouter;
    private javax.swing.JButton btnAnnuler;
    private javax.swing.JButton btnModifier;
    private javax.swing.JButton btnSupprimer;
    private javax.swing.JComboBox cherchPerLE;
    private javax.swing.JLabel imgCopie;
    private javax.swing.JPanel imgCopieAEC;
    private javax.swing.JLabel imgDemande;
    private javax.swing.JPanel imgFiche;
    private javax.swing.JLabel imgFicheC;
    private javax.swing.JLabel imgPhoto;
    private javax.swing.JLabel imgReleve;
    private javax.swing.JPanel imgReleveC;
    private javax.swing.JLabel imgVersement;
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
    private javax.swing.JLabel jLabel19;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel21;
    private javax.swing.JLabel jLabel22;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JLabel lblLieu1;
    private javax.swing.JLabel lblLieu2;
    private javax.swing.JLabel lblLieu3;
    private javax.swing.JLabel lblNombreTotal;
    private javax.swing.JLabel lblTotalLieu1;
    private javax.swing.JLabel lblTotalLieu2;
    private javax.swing.JLabel lblTotalLieu3;
    private javax.swing.JPanel pane;
    private javax.swing.JPanel pane2;
    private javax.swing.JPanel pane3;
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
