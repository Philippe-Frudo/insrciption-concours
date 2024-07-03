
package gestion;

import classes.Candidat;
import static com.sun.org.apache.xalan.internal.lib.ExsltDatetime.date;
import connexionBD.ConnexionBD;
import java.sql.Connection;
import java.util.Date;
import java.sql.ResultSet;
import java.text.SimpleDateFormat;
import java.time.LocalDateTime;

/**
 * @author MSI
 */
public class GestionCandidat {
    
    public  ConnexionBD connexion;
    
    Date date = new Date();
    SimpleDateFormat ft = new SimpleDateFormat("yyyy");
    int nowYear = Integer.parseInt(ft.format(date));
        
    
    public GestionCandidat() throws Exception{
        connexion = new ConnexionBD();
    }

     
   public void insert(Candidat obj) throws Exception {
        String req = "INSERT INTO candidat( nomC, prenomC, dateNais, lieuNais, sexeC, SMC, nationC, adrsPostC, emailC, telC, numIBACC, serieBACC, mentionBACC, recuVers, fiche, demande, releveOuDiplome, copieAEC, photoC, idLieu, nomM ) VALUES('" 
                + obj.getNomC() + "','" + obj.getPrenomC()+ "','" + obj.getDateNaisC()+ "','" + obj.getLieuNaisC()+ "','" + obj.getSexeC()+ "','" 
                + obj.getSMC()+ "','" + obj.getNationC()+ "','" + obj.getAdrsPC()+ "','" + obj.getEmailC()+ "','" + obj.getTelC()+ "','" + obj.getNumIBACC()+ "','" + obj.getSerieBACC()+ "','" 
                + obj.getMentionBACC()+ "','" + obj.getRecuVers()+ "','" + obj.getFiche()+ "','" + obj.getDemande()+ "','" + obj.getReleveOUdiplome()+ "','" + obj.getCopieAEC()+ "','" + obj.getPhotoC()+ "','" 
                + obj.getIdLieu() + "','" + obj.getNomMention()+ "')";
        connexion.executeUpdate(req);
    }
    
    /**public void insert(Candidat obj) throws Exception {
        String req = "INSERT INTO candidat( nomC, prenomC, dateNais, lieuNais, sexeC, SMC, nationC, adrsPostC, emailC, telC, numIBACC, serieBACC, mentionBACC, idLieu, nomM ) VALUES('" 
                + obj.getNomC() + "','" + obj.getPrenomC()+ "','" + obj.getDateNaisC()+ "','" + obj.getLieuNaisC()+ "','" + obj.getSexeC()+ "','" 
                + obj.getSMC()+ "','" + obj.getNationC()+ "','" + obj.getAdrsPC()+ "','" + obj.getEmailC()+ "','" + obj.getTelC()+ "','" + obj.getNumIBACC()+ "','" + obj.getSerieBACC()+ "','" 
                + obj.getMentionBACC()+ "','" + obj.getIdLieu() + "','" + obj.getNomMention()+ "')";
        connexion.executeUpdate(req);
    }*/

    public void update(String id, Candidat obj) throws Exception {
        String query = "UPDATE candidat SET nomC='" +obj.getNomC() + "',prenomC='" +obj.getPrenomC()+ "',dateNais='" +obj.getDateNaisC()+ "',lieuNais='"+obj.getLieuNaisC()+ "',sexeC='"+ obj.getSexeC()
                + "',SMC='" + obj.getSMC()+ "',nationC='" + obj.getNationC()+ "',adrsPostC='" + obj.getAdrsPC()+ "',emailC='" + obj.getEmailC()+ "',telC='" + obj.getTelC()+ "',numIBACC='" + obj.getNumIBACC()
                + "',serieBACC='" + obj.getSerieBACC()+ "',mentionBACC='" + obj.getMentionBACC()+ "',recuVers='" + obj.getRecuVers()+ "',fiche='" + obj.getFiche()+ "',demande='" + obj.getDemande()
                + "',releveOuDiplome='" + obj.getReleveOUdiplome()+ "',copieAEC='" + obj.getCopieAEC()+ "',photoC='" + obj.getPhotoC()+ "',nomM='" + obj.getNomMention()+ "',idLieu='" + obj.getIdLieu()+ "' "
                + "WHERE idC='"+ id +"' ";
        connexion.executeUpdate(query);
    }
    
    public void setImage(String id,String valrecuVers,String valfiche,String valdemande,String valreleveOuDiplome,String valcopieAEC,String pathPhoto ) throws Exception {
        String query = "UPDATE candidat SET recuVers='" + valrecuVers + "',fiche='" + valfiche + "',demande='" + valdemande + "',releveOuDiplome='" 
                + valreleveOuDiplome+ "',copieAEC='" + valcopieAEC+ "',photoC='" + pathPhoto + "WHERE idC='" + id+ "' ";
        connexion.executeUpdate(query);
    }

    public void delete(int id) throws Exception {
        String query = "DELETE FROM candidat WHERE idC='" + id + "'";
        //System.out.println(query);
        connexion.executeUpdate(query);
    }

    public ResultSet getAll() throws Exception {
        String query = "SELECT c.*, l.lieu FROM candidat c LEFT JOIN lieuExam l ON c.idLieu = l.idLieu WHERE YEAR(c.dateEnvoie)='"+nowYear+"' ";
        //System.out.println(query);
        ResultSet rs = connexion.executeQuery(query);
        return rs;
    }
    
    //Return DATA  
    public ResultSet getNumberCandidatPerYear2() throws Exception {
        String query = "SELECT YEAR(dateEnvoie) AS annee, COUNT( idC ) AS totalCand FROM candidat GROUP BY YEAR(dateEnvoie) ORDER BY annee ASC ";
        ResultSet rs = connexion.executeQuery(query);
        return rs;
    }
    
    
    /**public int[] getNumberCandidatPerYear() throws Exception {
        String query = "SELECT YEAR(dateEnvoie) AS annee, COUNT( idC ) AS totalCand FROM candidat GROUP BY YEAR(dateEnvoie) ORDER BY annee ASC ";
        ResultSet rs = connexion.executeQuery(query);
        int valeur[] = new int[12];
        
        int i = 0;
        while (rs.next()) {
            int indexYear = findIndex(rs.getString("annee"));
            valeur[indexYear] = (rs.getInt("totalCand")*10);
            i++;
            }
        return valeur;
    }
    
    //FOnction not for demand or Conge but for finding index
    public int findIndex(String str){ 
        //int year[] = new int[5]; 
        int year[] = {2024, 2023, 2022, 2021, 2020};
        /**Date date = new Date();
        SimpleDateFormat ft = new SimpleDateFormat("yyyy");
        int nowYear = Integer.parseInt(ft.format(date));
        
        for(int i=5;i>0.;i--){
            year[i] = nowYear - i;
        }
        for(int j=0;j<year.length;j++){
            System.out.println(year[j]);
        }
        
        for(int j=0;j<year.length;j++){
            if(str.equalsIgnoreCase(String.valueOf(year[j]))) return j;
        }
        
        return 0;
    }*/
    
    
    
    
    public int countEnreg() throws Exception {
        String query = "SELECT count(*) as nombre, YEAR(dateEnvoie) FROM candidat WHERE YEAR(dateEnvoie)='"+nowYear+"' GROUP BY YEAR(dateEnvoie) ";
        ResultSet rs = connexion.executeQuery(query);
        rs.next();
        int nbr = rs.getInt("nombre");
        return nbr;
    }
    
    public int countAllEnreg() throws Exception {
        String query = "SELECT count(*) as nombreTous FROM candidat WHERE YEAR(dateEnvoie)='"+nowYear+"' ";
        ResultSet rs = connexion.executeQuery(query);
        rs.next();
        int nbr = rs.getInt("nombreTous");
        return nbr;
    }
    
    public ResultSet nombreParParcours(String lieuExam) throws Exception {
        String query = "SELECT COUNT(nomM) AS nombreC, nomM FROM candidat c LEFT JOIN lieuExam l ON c.idLieu = l.idLieu WHERE l.lieu='"+lieuExam+"' AND YEAR(dateEnvoie)='"+nowYear+"' GROUP BY nomM";
        ResultSet rs = connexion.executeQuery(query);
        return rs;
    }
    
    public ResultSet nombreChaqueParcours() throws Exception {
        String query = "SELECT COUNT(nomM) AS nombreC, nomM FROM candidat c LEFT JOIN lieuExam l ON c.idLieu = l.idLieu WHERE YEAR(dateEnvoie)='"+nowYear+"' GROUP BY nomM";
        ResultSet rs = connexion.executeQuery(query);
        return rs;
    }
    
    public ResultSet getById(int idC) throws Exception {
        String query = "SELECT * FROM candidat WHERE idC='" + idC + "' ";
        //System.out.println(query);
        ResultSet rs = connexion.executeQuery(query);
        return rs;
    }
    
    public ResultSet getByLieu(String lieu) throws Exception {
        String query = "SELECT c.*, l.lieu FROM candidat c LEFT JOIN lieuExam l ON c.idLieu = l.idLieu WHERE l.lieu LIKE'"+lieu+"%' AND YEAR(dateEnvoie)='"+nowYear+"'";
        //System.out.println(query);
        ResultSet rs = connexion.executeQuery(query);
        return rs;
    }
    
    public ResultSet getBySearcch(String recher) throws Exception {
        String query = "SELECT c.*, l.lieu FROM candidat c ,lieuExam l WHERE (nomC LIKE'"+recher+"%' OR prenomC LIKE '"+recher+"%' OR sexeC LIKE '"
                +recher+"%' OR serieBACC LIKE '"+recher+"%' OR nationC LIKE '"+recher+"%' OR emailC LIKE '"+recher+"%' OR telC LIKE '"
                +recher+"%' OR numIBACC LIKE '"+recher+"%' OR serieBACC LIKE '"+recher+"%' OR mentionBACC LIKE '"+recher+"%' OR nomM LIKE '"+recher+"%' OR l.lieu LIKE'"+recher+"%') AND YEAR(dateEnvoie)='"+nowYear+"' ";
        //System.out.println(query);
        ResultSet rs = connexion.executeQuery(query);
        return rs;
    }
    
    public String takeLast() throws Exception{
        String query = "SELECT (idC) as idenitifiant FROM candidat ORDER BY idC DESC LIMIT 1";
        ResultSet rs = connexion.executeQuery(query);
        rs.next();
        String id = rs.getString("idenitifiant");
        return id;
    }
    
}
