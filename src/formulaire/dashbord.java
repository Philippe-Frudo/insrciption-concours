
package formulaire;

import classes.Candidat;
import gestion.GestionCandidat;
import gestion.GestionLieuExam;
import gestion.GestionMention;
import gestion.GestionUtilisateur;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.sql.ResultSet;
import java.text.SimpleDateFormat;
import java.util.Date;
import javax.swing.plaf.basic.BasicInternalFrameUI;
import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartPanel;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.plot.CategoryPlot;
import org.jfree.chart.plot.PlotOrientation;
import org.jfree.data.category.DefaultCategoryDataset;

/**
 * @author MSI
 */
public class dashbord extends javax.swing.JInternalFrame {
    
    public GestionCandidat gtCand;
    public GestionMention gM;
    public GestionLieuExam gLE;
    public GestionUtilisateur gUtil;
    

    public dashbord() throws Exception {
        
        gtCand = new GestionCandidat();
        gM = new GestionMention();
        gLE = new GestionLieuExam();
        gUtil = new GestionUtilisateur();
        
        initComponents();
        
        BasicInternalFrameUI ui= (BasicInternalFrameUI)this.getUI();
        ui.setNorthPane(null);
        
        //Nombre utilisateur
        nombreU();
        
        //Nombdre utilisateur
        nombreC();
        
        chartShow();

    }

    public void nombreU() throws Exception{
            int nbr = gUtil.countEnreg();
            if(nbr < 10){
                lblnbrU.setText( "0"+String.valueOf(nbr) );
            }else{
                lblnbrU.setText( String.valueOf(nbr) );  
            }
    }
    
    public void nombreC() throws Exception{
        int nbr = gtCand.countAllEnreg();
        if(nbr < 10){
            lblnbrC.setText( "0"+String.valueOf(nbr) );
        }else{
            lblnbrC.setText( String.valueOf(nbr) );
        }
    }
    
    
    @SuppressWarnings("empty-statement")
    private void chartShow() throws Exception{
        int width = chart_container.getWidth();
        int height = chart_container.getHeight();
        
        GestionCandidat gtCand = new GestionCandidat();
        //int statData[] = gtCand.getNumberCandidatPerYear();
        int nbrCandidat = gtCand.countAllEnreg();

        ResultSet rsl = gtCand.getNumberCandidatPerYear2();
        String tableYear[] = new String[5];
        int countCandidat[] = new int[5];
        
        int i=0;
        while(rsl.next()){
            tableYear[i] = rsl.getString("annee");
            countCandidat[i] = rsl.getInt("totalCand");
            i++;
        }
        DefaultCategoryDataset barChart = new DefaultCategoryDataset();
        for (int j = 0; j < tableYear.length; j++) { 
            barChart.setValue( countCandidat[j] , "Annee", tableYear[j]); 
        }
        /**
        getData on dataBase
        System.out.println(nbrCandidat);
        barChart.setValue(countCandidat[1], "Annee", tableYear[1]);
        barChart.setValue(countCandidat[2], "Annee", tableYear[2]);
        barChart.setValue(countCandidat[3], "Annee", tableYear[3]);
        barChart.setValue(countCandidat[4], "Annee", tableYear[4]);*/


        JFreeChart bar = ChartFactory.createBarChart("Bilan de nombre des candidats de cinq derniere annee", "Annee", null, barChart, PlotOrientation.VERTICAL, true, true, false);

        CategoryPlot barChrt = bar.getCategoryPlot();
        barChrt.setRangeGridlinePaint(Color.GREEN);

        ChartPanel barPanel = new ChartPanel(bar);
        barPanel.setPreferredSize(new Dimension(400, 470));

        chart_container.setLayout(new BorderLayout());
        this.chart_container.removeAll();
        this.chart_container.add(barPanel,BorderLayout.CENTER);
        this.chart_container.updateUI();
        this.chart_container.revalidate();
        this.chart_container.repaint();
    }

    
    
    
    
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        chart_container = new javax.swing.JPanel();
        jPanel2 = new javax.swing.JPanel();
        jLabel3 = new javax.swing.JLabel();
        jPanel4 = new javax.swing.JPanel();
        jPanel12 = new javax.swing.JPanel();
        lblnbrC = new javax.swing.JLabel();
        jLabel20 = new javax.swing.JLabel();
        jLabel19 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        jPanel1 = new javax.swing.JPanel();
        lblnbrU = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jPanel3 = new javax.swing.JPanel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jPanel6 = new javax.swing.JPanel();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jPanel7 = new javax.swing.JPanel();
        jLabel9 = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        jPanel8 = new javax.swing.JPanel();
        jLabel11 = new javax.swing.JLabel();
        jLabel12 = new javax.swing.JLabel();
        jPanel9 = new javax.swing.JPanel();
        jLabel13 = new javax.swing.JLabel();
        jLabel14 = new javax.swing.JLabel();
        jPanel10 = new javax.swing.JPanel();
        jLabel15 = new javax.swing.JLabel();
        jLabel16 = new javax.swing.JLabel();
        jPanel11 = new javax.swing.JPanel();
        jLabel17 = new javax.swing.JLabel();
        jLabel18 = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();

        setBackground(new java.awt.Color(255, 255, 255));
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        chart_container.setBackground(new java.awt.Color(255, 255, 255));
        chart_container.setBorder(javax.swing.BorderFactory.createEtchedBorder(java.awt.Color.black, null));
        chart_container.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());
        getContentPane().add(chart_container, new org.netbeans.lib.awtextra.AbsoluteConstraints(24, 121, 1050, 550));

        jPanel2.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel3.setFont(new java.awt.Font("SansSerif", 1, 24)); // NOI18N
        jLabel3.setText("DASBORD");
        jPanel2.add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 0, 740, 40));

        jPanel4.setBackground(new java.awt.Color(255, 255, 255));
        jPanel4.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel12.setBackground(new java.awt.Color(102, 102, 255));
        jPanel12.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        lblnbrC.setBackground(new java.awt.Color(255, 255, 255));
        lblnbrC.setFont(new java.awt.Font("Tahoma", 1, 36)); // NOI18N
        lblnbrC.setForeground(new java.awt.Color(255, 255, 255));
        lblnbrC.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        lblnbrC.setText("00");
        jPanel12.add(lblnbrC, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 60, 230, 41));

        jLabel20.setBackground(new java.awt.Color(255, 255, 255));
        jLabel20.setFont(new java.awt.Font("SansSerif", 0, 14)); // NOI18N
        jLabel20.setForeground(new java.awt.Color(255, 255, 255));
        jLabel20.setText("Nombre des candidats");
        jPanel12.add(jLabel20, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 10, 230, 41));

        jLabel19.setIcon(new javax.swing.ImageIcon("C:\\Users\\MSI\\Documents\\NetBeansProjects\\InscriptionConcoursEMIT\\src\\icones\\personne_group.png")); // NOI18N
        jPanel12.add(jLabel19, new org.netbeans.lib.awtextra.AbsoluteConstraints(250, 30, 50, 60));

        jPanel4.add(jPanel12, new org.netbeans.lib.awtextra.AbsoluteConstraints(1160, 320, 350, 130));

        jLabel8.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel8.setText("Statistique");
        jPanel4.add(jLabel8, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 110, 1052, 40));

        jPanel1.setBackground(new java.awt.Color(102, 102, 255));
        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        lblnbrU.setFont(new java.awt.Font("Tahoma", 1, 36)); // NOI18N
        lblnbrU.setForeground(new java.awt.Color(255, 255, 255));
        lblnbrU.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        lblnbrU.setText("00");
        jPanel1.add(lblnbrU, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 60, 220, 49));

        jLabel2.setFont(new java.awt.Font("SansSerif", 0, 14)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(255, 255, 255));
        jLabel2.setText("Nombre d'utilisateur(s)");
        jPanel1.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 10, 220, 36));

        jPanel3.setBackground(new java.awt.Color(102, 102, 255));
        jPanel3.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel4.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(255, 255, 255));
        jLabel4.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel4.setText("2");
        jPanel3.add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 11, 320, 49));

        jLabel5.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel5.setForeground(new java.awt.Color(255, 255, 255));
        jLabel5.setText("Utilisateur(s)");
        jPanel3.add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 71, 320, 36));

        jPanel1.add(jPanel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(1164, 81, 360, 120));

        jPanel6.setBackground(new java.awt.Color(102, 102, 255));
        jPanel6.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel6.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N
        jLabel6.setForeground(new java.awt.Color(255, 255, 255));
        jLabel6.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel6.setText("2");
        jPanel6.add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 11, 320, 49));

        jLabel7.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel7.setForeground(new java.awt.Color(255, 255, 255));
        jLabel7.setText("Utilisateur(s)");
        jPanel6.add(jLabel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 71, 320, 36));

        jPanel7.setBackground(new java.awt.Color(102, 102, 255));
        jPanel7.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel9.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N
        jLabel9.setForeground(new java.awt.Color(255, 255, 255));
        jLabel9.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel9.setText("2");
        jPanel7.add(jLabel9, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 11, 320, 49));

        jLabel10.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel10.setForeground(new java.awt.Color(255, 255, 255));
        jLabel10.setText("Utilisateur(s)");
        jPanel7.add(jLabel10, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 71, 320, 36));

        jPanel6.add(jPanel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(1164, 81, 360, 120));

        jPanel1.add(jPanel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(1164, 81, 360, 120));

        jPanel8.setBackground(new java.awt.Color(102, 102, 255));
        jPanel8.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel11.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N
        jLabel11.setForeground(new java.awt.Color(255, 255, 255));
        jLabel11.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel11.setText("2");
        jPanel8.add(jLabel11, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 11, 320, 49));

        jLabel12.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel12.setForeground(new java.awt.Color(255, 255, 255));
        jLabel12.setText("Utilisateur(s)");
        jPanel8.add(jLabel12, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 71, 320, 36));

        jPanel9.setBackground(new java.awt.Color(102, 102, 255));
        jPanel9.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel13.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N
        jLabel13.setForeground(new java.awt.Color(255, 255, 255));
        jLabel13.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel13.setText("2");
        jPanel9.add(jLabel13, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 11, 320, 49));

        jLabel14.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel14.setForeground(new java.awt.Color(255, 255, 255));
        jLabel14.setText("Utilisateur(s)");
        jPanel9.add(jLabel14, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 71, 320, 36));

        jPanel8.add(jPanel9, new org.netbeans.lib.awtextra.AbsoluteConstraints(1164, 81, 360, 120));

        jPanel10.setBackground(new java.awt.Color(102, 102, 255));
        jPanel10.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel15.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N
        jLabel15.setForeground(new java.awt.Color(255, 255, 255));
        jLabel15.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel15.setText("2");
        jPanel10.add(jLabel15, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 11, 320, 49));

        jLabel16.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel16.setForeground(new java.awt.Color(255, 255, 255));
        jLabel16.setText("Utilisateur(s)");
        jPanel10.add(jLabel16, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 71, 320, 36));

        jPanel11.setBackground(new java.awt.Color(102, 102, 255));
        jPanel11.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel17.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N
        jLabel17.setForeground(new java.awt.Color(255, 255, 255));
        jLabel17.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel17.setText("2");
        jPanel11.add(jLabel17, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 11, 320, 49));

        jLabel18.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel18.setForeground(new java.awt.Color(255, 255, 255));
        jLabel18.setText("Utilisateur(s)");
        jPanel11.add(jLabel18, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 71, 320, 36));

        jPanel10.add(jPanel11, new org.netbeans.lib.awtextra.AbsoluteConstraints(1164, 81, 360, 120));

        jPanel8.add(jPanel10, new org.netbeans.lib.awtextra.AbsoluteConstraints(1164, 81, 360, 120));

        jPanel1.add(jPanel8, new org.netbeans.lib.awtextra.AbsoluteConstraints(1164, 81, 360, 120));

        jLabel1.setIcon(new javax.swing.ImageIcon("C:\\Users\\MSI\\Documents\\NetBeansProjects\\InscriptionConcoursEMIT\\src\\icones\\userAdmin.png")); // NOI18N
        jPanel1.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(250, 30, 50, 70));

        jPanel4.add(jPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(1160, 150, 350, 130));

        jPanel2.add(jPanel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(-20, -40, 1690, 980));

        getContentPane().add(jPanel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 11, -1, -1));

        pack();
    }// </editor-fold>//GEN-END:initComponents


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel chart_container;
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
    private javax.swing.JLabel jLabel20;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel10;
    private javax.swing.JPanel jPanel11;
    private javax.swing.JPanel jPanel12;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPanel jPanel6;
    private javax.swing.JPanel jPanel7;
    private javax.swing.JPanel jPanel8;
    private javax.swing.JPanel jPanel9;
    private javax.swing.JLabel lblnbrC;
    private javax.swing.JLabel lblnbrU;
    // End of variables declaration//GEN-END:variables
}
