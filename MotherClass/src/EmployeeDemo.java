public class EmployeeDemo 
{
    
 
 public static void main(String[] args)
 {
 //Calling my EMployee class
  EmployeeClass class1 = new EmployeeClass();
  EmployeeClass class2 = new EmployeeClass("Mak Jones", "Programmer", "IT", 39119);
  EmployeeClass class3 = new EmployeeClass("Joy Rogers", "Engineer", "Manufacturing",81774);
     
  System.out.println("    Name           ID Number         Deparment             Position");
  System.out.println("---------------------------------------------------------------------------");
  System.out.println(class1.name + "          "+class1.idNumber+"          "+class1.department+"          "+class1.position);
  System.out.println(class2.name + "            "+class2.idNumber+"          "+class2.department+"                  "+class2.position);
  System.out.println(class3.name + "           "+class3.idNumber+"          "+class3.department+"       "+class3.position);

 }
}