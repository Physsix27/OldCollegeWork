/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package laststring;

import java.util.*;
import java.lang.*;

/**
 *
 * @author Starlyn
 */
public class LastString {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {

     String lastWordinastring;
        
// create a scanner //
     Scanner test = new Scanner(System.in);
     
  
// ask for testscore and accept them //
     System.out.println("Enter a string to return you the last word");
     lastWordinastring = test.next();
        
      lastW
    }
    
    
    public static String lastWord(String str) {
                
        char space = ' ';
        
        for(int i =  str.length() -1; i >= 0; i--){
            String lastWord = str.substring(str.lastIndexOf(" ")+1);
        }
        
        
        return str;
        
    }
    
    
    
    
}
