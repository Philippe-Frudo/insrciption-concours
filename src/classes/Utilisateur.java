
package classes;

/**
 *
 * @author MSI
 */
public class Utilisateur {
    
    private int idA;
    private String nomA;
    private String emailA;
    private String passwordA;
    private String telA;
    private String adrsA;
    private String sexeA;
    
    public Utilisateur(int idA, String nomA, String emailA, String passwordA, String telA, String adrsA, String sexeA){
        this.idA = idA;
        this.nomA = nomA;
        this.emailA = emailA;
        this.passwordA = passwordA;
        this.telA = telA;
        this.adrsA = adrsA;
        this.sexeA = sexeA;
    }
    
        
    public Utilisateur( String nomA, String emailA, String passwordA, String telA, String adrsA, String sexeA){
        this.nomA = nomA;
        this.emailA = emailA;
        this.passwordA = passwordA;
        this.telA = telA;
        this.adrsA = adrsA;
        this.sexeA = sexeA;
    }
    
    
    public int getIdA(){
        return idA;
    }
    public void setIdA(){
        this.idA = idA;
    }
    
    
    public String getNomA(){
        return nomA;
    }
    public void setNomA(){
        this.nomA = nomA;
    }
       
    
    public String getEmailA(){
        return emailA;
    }
    public void setEmailA(){
        this.emailA = emailA;
    }
    
        
    public String getPasswordA(){
        return passwordA;
    }
    public void setPasswordA(){
        this.passwordA = passwordA;
    }
    
    
    public String getTelA(){
        return telA;
    }
    public void setTelA(){
        this.telA = telA;
    }
        
    
    public String getAdrsA(){
        return adrsA;
    }
    public void setAdrsA(){
        this.adrsA = adrsA;
    }
            
    
    public String getSexeA(){
        return sexeA;
    }
    public void setSexeA(){
        this.sexeA = sexeA;
    }
    
}
