public class Stacky 
{
   public static void main(String[] args) 
   {

        StackyC s = new StackyC(5);

        for (int i = 0; i < s.length(); i++) 
        {
            s.push(i);
        }

        if (!s.empty())
        {
            for (int i = 0; i < s.length(); i++)
            {
                System.out.println(s.pop());
            }
        }

    }
}