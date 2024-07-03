
package gestion;

import classes.LieuExam;
import connexionBD.ConnexionBD;
import java.sql.ResultSet;

/**
 * @author MSI
 */
public class GestionLieuExam {
    
    public ConnexionBD connexion;
    
    public GestionLieuExam() throws Exception{
        connexion = new ConnexionBD();
    }
    
    public ResultSet getAll() throws Exception {
        String query = "SELECT * FROM lieuexam";
        ResultSet rs = connexion.executeQuery(query);
        return rs;
    }

    public void insert( LieuExam obj ) throws Exception {
        String query = "INSERT INTO lieuexam (lieu) VALUES ('" +obj.getLieuE() +"') ";
        connexion.executeUpdate(query);
    }
    
    public void update( LieuExam obj ) throws Exception {
        String query = "UPDATE lieuexam SET lieu= '"+obj.getLieuE()+"' WHERE idLieu='"+obj.getIdLieu()+"' ";
        connexion.executeUpdate(query);
    }
    
    public void delete(int id) throws Exception {
        String query = "DELETE FROM lieuexam WHERE idLieu = '"+id+"' ";
        System.out.println(query);
        connexion.executeUpdate(query);
        
    }
    
    
    public int countEnreg() throws Exception {
        String query = "SELECT count(*) as nombre FROM lieuExam";
        ResultSet rs = connexion.executeQuery(query);
        rs.next();
        int nbr = rs.getInt("nombre");
        return nbr;
    }
    
    
    public ResultSet getByNom(String recher) throws Exception {
        String query = "SELECT * FROM lieuExam WHERE lieu LIKE '"+recher+"%'";
//        System.out.println(query);
        ResultSet rs = connexion.executeQuery(query);
        return rs;
    }
    
}
