import java.io.*;
import java.util.*;  
  
public class SecretWord
{
 public static void main(String [] args) throws IOException
 {
   FileReader file = new FileReader("secret.txt");
   BufferedReader input = new BufferedReader(file);
   StringBuffer word;
   String content;
   char boo;
   int x = 0;
       
   content = input.readLine();
   word = new StringBuffer();
   StringTokenizer Tostr = new StringTokenizer(content);
   while(Tostr.hasMoreTokens())
        {
         String token = Tostr.nextToken();
         if(x % 5 == 0)
           { 
            token = token.toUpperCase();
            boo = token.charAt(0);
            word.append(boo);      
           }  
            x++;
        } 
     System.out.print(word);
 }
}       