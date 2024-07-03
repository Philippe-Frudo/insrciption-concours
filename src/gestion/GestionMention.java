
package gestion;

/**
 *
 * @author MSI
 */
import classes.Mention;
import connexionBD.ConnexionBD;
import java.sql.ResultSet;


public class GestionMention {
    
    public ConnexionBD connexion;
    
    public GestionMention() throws Exception{
        connexion = new ConnexionBD();
    }
    
    public void insert(Mention obj) throws Exception {
        String req = "INSERT INTO mention VALUES('" + obj.getNomMention()+ "' )";
        connexion.executeUpdate(req);
    }

    public void update(String id, Mention obj) throws Exception {
        String query = "UPDATE mention SET nomM='" + obj.getNomMention()+ "' WHERE nomM= '" + id + "'";
        connexion.executeUpdate(query);
    }

    public void delete(String id) throws Exception {
        String query = "DELETE FROM mention WHERE nomM='" + id + "'";
        //System.out.println(query);
        connexion.executeUpdate(query);
    }

    public ResultSet getAll() throws Exception {
        String query = "SELECT * FROM mention";
        ResultSet rs = connexion.executeQuery(query);
        return rs;
    }
    
    public int countEnreg() throws Exception {
        String query = "SELECT count(*) as nombre FROM mention";
        ResultSet rs = connexion.executeQuery(query);
        rs.next();
        int nbr = rs.getInt("nombre");
        return nbr;
    }
    
    public ResultSet getByNom(String recher) throws Exception {
        String query = "SELECT * FROM mention WHERE nomM LIKE '"+recher+"%'";
//        System.out.println(query);
        ResultSet rs = connexion.executeQuery(query);
        return rs;
    }

    public void update(Mention mention) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
}
