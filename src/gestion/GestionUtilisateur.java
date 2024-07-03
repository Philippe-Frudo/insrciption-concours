
package gestion;

import classes.Utilisateur;
import connexionBD.ConnexionBD;
import java.sql.ResultSet;

/**
 * @author MSI
 */
public class GestionUtilisateur {
    
    public ConnexionBD connexion;
    
    public GestionUtilisateur() throws Exception{
        connexion = new ConnexionBD();
    }
    
    public void insert(Utilisateur obj) throws Exception{
        String query = "INSERT INTO utilisateur (nomA, emailA, passwordA ,telA, adrsA, sexeA) VALUES ( '"+obj.getNomA()+"', '"+obj.getEmailA()+"', '"+obj.getPasswordA()+"', '"+obj.getTelA()+"', '"+obj.getAdrsA()+"', '"+obj.getSexeA()+"' ) ";
        connexion.executeUpdate(query);
    }
    
    public void update(int id, Utilisateur obj) throws Exception{
        String query = "UPDATE utilisateur SET nomA='"+obj.getNomA()+"', emailA='"+obj.getEmailA()+"', passwordA='"+obj.getPasswordA()+"', telA='"+obj.getTelA()+"', adrsA='"+obj.getAdrsA()+"', sexsA='"+obj.getSexeA()+"' WHERE idA='"+id+"' ";
        connexion.executeUpdate(query);
    }
    
    public void delete(int id) throws Exception{
        String query = "DELETE FROM utilisateur WHERE idA='"+id+"' ";
        connexion.executeUpdate(query);
    }
    
    public ResultSet getAll() throws Exception{
        String query = "SELECT * FROM utilisateur";
        ResultSet rs = connexion.executeQuery(query);
        return  rs;
    }
    
        public ResultSet getBy(String nomA, String passA) throws Exception{
        String query = "SELECT * FROM utilisateur WHERE nomA='"+nomA+"' AND passwordA='"+passA+"' ";
        ResultSet rs = connexion.executeQuery(query);
        return  rs;
    }
    
    public int countEnreg() throws Exception {
        String query = "SELECT count(*) as nombre FROM utilisateur";
        ResultSet rs = connexion.executeQuery(query);
        rs.next();
        int nbr = rs.getInt("nombre");
        return nbr;
    }
    
}
