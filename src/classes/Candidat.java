
package classes;

import java.io.File;
import java.io.FileNotFoundException;
import java.lang.String;

/**
 * @author MSI
 */
public class Candidat {
    // "C" signifie "Candidat"
    
    private int idC; //Identifiant
    private String nomC;
    private String prenomC;
    private String dateNaisC; //date de naissance
    private String lieuNaisC; // Lieu de naissance
    private String sexeC;
    private String SMC; //Situation matrimoniale
    private String nationC; //Nationalite
    private String adrsPC; //Adresse
    private String emailC; 
    private String telC; //Telephone
    private String numIBACC; // numero d'Inscription BACC
    private String serieBACC;
    private String mentionBACC;
    private String recuVers; // photo recu de versement
    private String fiche; // photo fiche de renseignement
    private String demande;  // photo demande d'inscription
    private String releveOuDiplome; // photo releve de note ou Diplome enBACC
    private String copieAEC; // copie Acte d'Etat Civil
    private String photoC; // photo d'identite du candidat
    private String nomMention; // mention (Identifiant) 
    private String idLieu; // Identifiant de lieu d'examen
 
    public Candidat(
            int idC, String nomC, String prenomC, String dateNaisC, String lieuNaisC, String sexeC, String SMC, String nationC, String adrsPC, String emailC, String telC, String numIBACC, 
            String serieBACC, String mentionBACC, 
            String recuVers, String fiche, String demande, String releveOuDiplome, String copieAEC, String photoC, String nomMention, String idLieu
    ) throws FileNotFoundException{
        
        this.idC = idC;
        this.nomC = nomC;
        this.prenomC = prenomC;
        this.dateNaisC = dateNaisC;
        this.lieuNaisC = lieuNaisC;
        this.sexeC = sexeC;
        this.SMC = SMC;
        this.nationC = nationC;
        this.adrsPC = adrsPC;
        this.emailC = emailC; 
        this.telC = telC;
        this.numIBACC = numIBACC;
        this.serieBACC = serieBACC;
        this.mentionBACC = mentionBACC;
        this.recuVers = recuVers ;
        this.fiche = fiche ;
        this.demande = demande ;
        this.releveOuDiplome = releveOuDiplome;
        this.copieAEC = copieAEC ;
        this.photoC = photoC ;
        this.nomMention = nomMention;
        this.idLieu = idLieu;

    } 
     
    
    public Candidat(
            String nomC, String prenomC, String dateNaisC, String lieuNaisC, String sexeC, String SMC, String nationC, String adrsPC, String emailC, String telC,
            String numIBACC, String serieBACC, String mentionBACC, String recuVers, String fiche, String demande, String releveOuDiplome, String copieAEC, String photoC, String nomMention, String idLieu
    ) throws FileNotFoundException{
  
        this.nomC = nomC;
        this.prenomC = prenomC;
        this.dateNaisC = dateNaisC;
        this.lieuNaisC = lieuNaisC;
        this.sexeC = sexeC;
        this.SMC = SMC;
        this.nationC = nationC;
        this.adrsPC = adrsPC;
        this.emailC = emailC; 
        this.telC = telC;
        this.numIBACC = numIBACC;
        this.serieBACC = serieBACC;
        this.mentionBACC = mentionBACC;
        this.recuVers = recuVers ;
        this.fiche = fiche ;
        this.demande = demande ;
        this.releveOuDiplome = releveOuDiplome;
        this.copieAEC = copieAEC ;
        this.photoC = photoC ;
        this.nomMention = nomMention;
        this.idLieu = idLieu;

    } 
    
        
    public Candidat(
            String nomC, String prenomC, String dateNaisC, String lieuNaisC, String sexeC, String SMC, String nationC, String adrsPC, 
            String emailC, String telC, String numIBACC, String serieBACC, String mentionBACC, String nomMention, String idLieu
    ) throws FileNotFoundException{
  
        this.nomC = nomC;
        this.prenomC = prenomC;
        this.dateNaisC = dateNaisC;
        this.lieuNaisC = lieuNaisC;
        this.sexeC = sexeC;
        this.SMC = SMC;
        this.nationC = nationC;
        this.adrsPC = adrsPC;
        this.emailC = emailC; 
        this.telC = telC;
        this.numIBACC = numIBACC;
        this.serieBACC = serieBACC;
        this.mentionBACC = mentionBACC;

        this.nomMention = nomMention;
        this.idLieu = idLieu;

    } 
    
//     public Candidat(String recuVers, String fiche, String demande, String releveOuDiplome, String copieAEC, String photoC ) throws FileNotFoundException{
//        this.recuVers = recuVers ;
//        this.fiche = fiche ;
//        this.demande = demande ;
//        this.releveOuDiplome = releveOuDiplome;
//        this.copieAEC = copieAEC ;
//        this.photoC = photoC ;
//    } 

    
    //ID 
    public int getIdC(){
        return idC;
    }
    
    public void setIdC(int idC){
        this.idC = idC;
    }
    
    //NOM
    public String getNomC(){
        return nomC;
    }
    
    public void setNomC(String nomC){
        this.nomC = nomC;
    }
        
    //PRENOM 
    public String getPrenomC(){
        return prenomC;
    }
    
    public void setPrenomC(String prenomC){
        this.prenomC = prenomC;
    }
        
    //DATE DE NAISSANCE
    public String getDateNaisC(){
        return dateNaisC;
    }
    
    public void setDateNaisC(String dateNaisC){
        this.dateNaisC = dateNaisC;
    }
        
    //LIEU DE NAISSANCE 
    public String getLieuNaisC(){
        return lieuNaisC;
    }
    
    public void setLieuNais(String lieuNaisC){
        this.lieuNaisC = lieuNaisC;
    }
        
    //SEXE
    public String getSexeC(){
        return sexeC;
    }
    
    public void setSexeC(String sexeC){
        this.sexeC = sexeC;
    }
    
        
    //SITUATION MATRIMONIALE
    public String getSMC(){
        return SMC;
    }
    
    public void setIdC(String SMC){
        this.SMC = SMC;
    }
        
    //NATIONALITE
    public String getNationC(){
        return nationC;
    }
    
    public void setNationC(String nationC){
        this.nationC = nationC;
    }
        
    //ADRESSE POSTALE
    public String getAdrsPC(){
        return adrsPC;
    }
    
    public void setAdrsPC(String adrsPC){
        this.adrsPC = adrsPC;
    }
        
    //EMAIL
    public String getEmailC(){
        return emailC;
    }
    
    public void setEmailC(String emailC){
        this.emailC = emailC;
    }
        
    //ID TELEPHONE
    public String getTelC(){
        return telC;
    }
    
    public void setTelC(String telC){
        this.telC = telC;
    }
        
    //NUMERO INSCRIPTION BACC
    public String getNumIBACC(){
        return numIBACC;
    }
    
    public void setNumIBACC(String numIBACC){
        this.numIBACC = numIBACC;
    }
        
    //SERIE  BACC 
    public String getSerieBACC(){
        return serieBACC;
    }
    
    public void setSerieBACC(String serieBACC){
        this.serieBACC = serieBACC;
    }
        
    //MENTION BACC 
    public String getMentionBACC(){
        return mentionBACC;
    }
    
    public void setMentionBACC(String mentionBACC){
        this.mentionBACC = mentionBACC;
    }
        
    //VERSEMENT 
    public String getRecuVers(){
        return recuVers;
    }
    
    public void setResVers(String recuVers){
        this.recuVers = recuVers;
    }
        
    //FICHE
    public String getFiche(){
        return fiche;
    }
    
    public void setFiche(String fiche){
        this.fiche = fiche;
    }
        
    //DEMANDE
    public String getDemande(){
        return demande;
    }
    
    public void setDemande(String demande){
        this.demande = demande;
    }
        
    //RELEVE DE NOTE OU DIPLOME BACC
    public String getReleveOUdiplome(){
        return releveOuDiplome;
    }
    
    public void setReleveOUdiplome(String releveOuDiplome){
        this.releveOuDiplome = releveOuDiplome;
    }
    
    // COPIE ACTE D'ETAT CIVIL
    public String getCopieAEC(){
        return copieAEC;
    }
    
    public void setCopieAECe(String copieAEC){
        this.copieAEC = copieAEC;
    }
    
    //PHOTO
    public String getPhotoC(){
        return photoC;
    }
    
    public void setPhotoC(String photoC){
        this.photoC = photoC;
    }
    
    //MONTION
    public String getNomMention(){
        return nomMention;
    }
    
    public void setNomMention(String nomMention){
        this.nomMention = nomMention;
    }
    
    // LIEU D'EXAMENT
    public String getIdLieu(){
        return idLieu;
    }
    
    public void setIdLieu(String idLieu){
        this.idLieu = idLieu;
    }
}
