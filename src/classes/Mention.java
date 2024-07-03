
package classes;

import javax.swing.JTextField;

/**
 *
 * @author MSI
 */
public class Mention {
    private String nomM;
    private String idM;
    
    /**
     *
     * @param idM [id entifiant de mewntion String]
     * @param nomMention [nom de mention universitaire]
     */
    public Mention(String idM, String nomMention){
        this.idM = idM;
        this.nomM = nomMention;
    }
        public Mention(String nomMention){
        this.nomM = nomMention;
    }
    
    public String getNomMention(){
        return nomM;
    }
    
    public void setNomMention(String nomMention){
        this.nomM = nomMention;
    }
    
}
