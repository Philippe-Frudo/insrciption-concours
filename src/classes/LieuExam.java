
package classes;

/**
 *
 * @author MSI
 */
public class LieuExam {
    private int idLieu;
    private String lieu;
    
    public LieuExam(int idLieu, String lieu){
        this.idLieu = idLieu;
        this.lieu = lieu;
    }
    
    public LieuExam(String lieu){
        this.lieu = lieu;
    }
    
    
    public int getIdLieu(){
        return idLieu;
    }
    
    public void setIdLieu(int idLieu){
        this.idLieu = idLieu;
    }
    
    
    public String getLieuE(){
        return lieu;
    }
    
    public void setLieuE(String lieu){
        this.lieu = lieu;
    }
}
