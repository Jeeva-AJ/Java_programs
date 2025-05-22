abstract class Employee{
String name;
int empId;
double basicSalary;
Employee(String name,int empId,double basicSalary){
this.name = name;
this.empId = empId;
this.basicSalary = basicSalary;
}
abstract double calculateSalary();
void displaySalary(){
System.out.println("Employee ID : "+empId);
System.out.println("Employee Name : "+name);
System.out.println("Salary : "+calculateSalary());
}
}
class FullTimeEmployee extends Employee{
FullTimeEmployee(String name,int empId,double basicSalary){
super(name,empId,basicSalary);
}
@Override
double calculateSalary(){
return basicSalary+(0.2*basicSalary);
}
}
class PartTimeEmployee extends Employee{
int hoursWorked;
double hourlyRate;
PartTimeEmployee(String name,int empId,double basicSalary,int hoursWorked,double hourlyRate){
super(name,empId,basicSalary);
this.hoursWorked = hoursWorked;
this.hourlyRate = hourlyRate;
}
@Override
double calculateSalary(){
return basicSalary+(hourlyRate*hoursWorked);
}
}
public class EmployeeManagement{
public static void main(String args[]){
Employee fulltime = new FullTimeEmployee("John",101,50000);
Employee parttime = new PartTimeEmployee("Alice",102,20000,20,500);
fulltime.displaySalary();
parttime.displaySalary();
}
}