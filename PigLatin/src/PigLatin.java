import java.util.*;
public class PigLatin {
    // MAIN METHOD //
    public static void main(String[] args) {
	
        // CREATING A SCANNER TO GET USER INPUT //
        Scanner input = new Scanner(System.in);
        
        // ASKING THE USER FOR A STRING TO CONVERT IT TO PIG LATIN //
        System.out.println("What word would you like to translate to Pig Latin?: ");
        
        // GETTING THE USER INPUT //
	String Sentence = input.nextLine();
        
        // RETURNING THE ANSWER TO THE USER //
        System.out.println("English to Pig Latin");
	System.out.println("Original Sentence: " + Sentence);
	System.out.println("Translation: " + solve(Sentence));
    }
	
    // THE SOLVE METHOD, CONVERTS A STRING TO PIG LATIN //
    public static String solve(String Sentence) {
        
        // TAKING THE USER INOUT ANDD PUTTING IN IT IN A STRING //
	String temp = Sentence.toLowerCase();
		
        // 
        Sentence = Sentence.replaceAll(" ", "ay ");
                
        // GETTING THE FIRST LEETER THAT FROM THE USER INPUT //      
        char first = temp.charAt(0);
	    
        // SUBSTRING CLASS HELPS YOU SELECT A SPECIFIC CHARACTER BASED ON THE INDEXES //
        // GETTING ALL THE OTHER CHARACTERS ENTER AFTER THE FRIST ONE //
        Sentence = Sentence.substring(1);
        
        // RETURNING THE USER INPUT WITH 'AY' AT THE END //
        Sentence += first + "ay";
        return Sentence;   
    }
}