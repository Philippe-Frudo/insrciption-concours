

package formulaire;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 *
 * @author MSI
 */
public class Regex {
    
    public static Pattern pattern ;
    public static Matcher matcher;
    
//    /^[^\s@]+@[^\s@]+\.[^\s@]+$/ email
//     /^(?=.*[a-z])(?=.*[A-Z])(?=.*\d)[a-zA-Z\d]{8,20}$/ password
//    /^(034|038|032|033)\\d{7,12}$/ telephone
    public static boolean validPhone(String input){
        pattern = Pattern.compile("/^(034|038|032|033)\\d{7,12}$/");
        matcher = pattern.matcher(input);
        
        return matcher.matches();
    }
    
    public static boolean isInt(String str){
        return str.matches("\\d"); 
    }
    
    public static void main(String arg[]){
        //System.out.println(validPhone("0380312546"));
        System.out.println(isInt("2122665"));
        //System.out.println(validPhone("frudo@gmail.com"));
    }
    
    
    
}
