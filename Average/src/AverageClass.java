import java.util.Scanner;

public class AverageClass 
{
 int[] data;
 double mean;
 
 public AverageClass()
 {
  data = new int[5];
  Scanner aC = new Scanner(System.in);
  
  for(int i = 0; i < data.length; i++)
  {
   System.out.print("Enter score number " + (i + 1) + ": ");
   data[i] = aC.nextInt();
  }
 }
 
//calculate the mean of 5 scores
 public void setCalculateMean()
 {
  int i, sum = 0;
  for(i = 0; i < data.length; i++)
  {
   sum = sum + data[i];
  }
  mean = (double)sum / (data.length);   
 }
 
 public void selectionSort()
 {
  int maxIndex;
  int maxValue;

 //Reads values into the array
  for(int startScan = 0; startScan < data.length - 1; startScan++)
  {
   maxIndex = startScan;
   maxValue = data[startScan];
   
   for(int index = startScan + 1; index < data.length; index++)
   {
    if(data[index] > maxValue)
      {
       maxValue = data[index];
       maxIndex = index;
      }
   }
    data[maxIndex] = data[startScan];
   data[startScan] = maxValue;  
  }
 }   
  
 public String toString()
 {
  String output;
  output = "The test scores in descending order are \n";

  for(int i = 0; i < data.length; i++)
  {
   output = output + data[i] + " ";
  }
  output = output + "\nThe average is " + mean;
  return output;   
 }
}