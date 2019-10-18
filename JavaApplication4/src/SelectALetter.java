public class SelectALetter 
{
 public static void main(String[] args)
 {
     String str = "New York";
  showChar(str, 2);
 }

    public static void showChar(String str, int num)
 {
  System.out.println(str.charAt(num));
 }
}