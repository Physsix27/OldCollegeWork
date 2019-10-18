

public class EmployeeClass 
{ 
   String name;
   String position;
   String department;
   int idNumber;
   
 //Constructor 
 EmployeeClass()
 {
  name = "Susan Meyer";
  idNumber = 47899;
  department = "Accounting";
  position = "Vice President";
  
 } 
 
 EmployeeClass(String n, String p, String d, int a)
 {
  name = n;
  idNumber = a;
  department = d;
  position = p;

 }
 
 EmployeeClass(int a, String n, String p, String d )
 {
  name = n;
  idNumber = a;
  department = d;
  position = p;
 }
}