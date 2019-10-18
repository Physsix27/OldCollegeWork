import java.io.*;

//This program creates a list of songs for a CD by reading from a file
public class CompactDisc
{
 public static void main(String [] args) throws IOException
 {
        FileReader file = new FileReader("Classics.txt");
        BufferedReader input = new BufferedReader(file);
       String title;
       String artist;
       
       //Declare an array of songs, called cd, of size 6
       
       String[]cd=new String[6];
       
       for (int i = 0; i < cd.length; i++)
       {
          
          title = input.readLine();
          artist = input.readLine();
          Song s = new Song(title,artist);   
          // fill the array by creating a new song with 
          // the title and artist and storing it in the 
          // appropriate position in the array
         cd[i]= s.toString();
       }
       
       System.out.println("Contents of Classics:");
       for (int i = 0; i < cd.length; i++)
       {
          //print the contents of the array to the console
                 
         System.out.print(cd[i]);
 
       }
 }
}