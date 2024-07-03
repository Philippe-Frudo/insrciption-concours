
package connexionBD;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

/**
 *
 * @author MSI
 */
public class ConnexionBD {
    
    public Connection con;
    public Statement stat;
    
    public ConnexionBD() throws Exception{
	try {
            Class.forName("com.mysql.jdbc.Driver"); //charger le pilote jdbc
            con = DriverManager.getConnection(Constant.URL, Constant.USER, Constant.PASSWORD);
            stat = con.createStatement(); //lanceur de requette
            //System.out.println("Connexion etablie");
        } catch (Exception e) {
            System.err.println("Erreur de connexion base de donnee " + e.getMessage());
        }
    }

    //select
    public ResultSet executeQuery (String query) throws Exception{
        ResultSet res = null;
        res = stat.executeQuery(query);
        return(res);
    }
    
    //insertion, update, delete
    public int executeUpdate (String query) throws Exception{
        int res=0;
	res=stat.executeUpdate(query);
	return(res);
    }

    public void close() throws Exception{
	stat.close();
	con.close();
    }
    
}
