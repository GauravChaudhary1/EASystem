package PS1;
import java.io.File; 
import java.util.Scanner;

public class EmployeeAttendance {
	public static void main(String[] args) throws Exception 
	  { 	    
	    File file = new File("C:\\Users\\i330087\\Desktop\\M.Tech\\Semester 1\\DSA\\input.txt"); 
	    Scanner sc = new Scanner(file); 	  
	    EmpBT<Integer> bTree = new EmpBT<>();
	    while (sc.hasNextLine()) {
	    	bTree.add(Integer.parseInt(sc.nextLine())); 
	    }
	    sc.close();
	    
	    Scanner scan = new Scanner(System.in);
	    int choice, empId;
        do{
            System.out.print("\n *******Attendance Monitoring System********");
            System.out.print("\n 1. How many employees came today?");
            System.out.print("\n 2. Did a particular employee came today?");
            System.out.print("\n 3. Is a particular employee still in office?");
            System.out.print("\n 4. How often did an employee enter into the office?");
            System.out.print("\n 5. Which employee moves out of office most number of times?");
            System.out.print("\n 6. Who all came within a range of IDs, and how often they entered? ");
            System.out.print("\n 7. Exit \n Choice:");
            choice = scan.nextInt();

            switch(choice)
            {
                case 1:
                	System.out.println("Total number of " + bTree.getHeadCount(bTree.getRoot()) + " Employee(s) came today.");
                    break;
                case 2:
                	System.out.print("\n\n Enter the Employee Id: ");
                	empId= scan.nextInt();
                	if(bTree.searchID(bTree.getRoot(),empId))
                		System.out.println("Yes, the Employee came to the office premises.");
                	else
                		System.out.println("No, the Employee didn't came.");
                		
                    break;
                case 3:
                	System.out.print("\n\n Enter the Employee Id: ");
                	empId= scan.nextInt();
                	if(bTree.inOffice(empId))
                		System.out.println("Yes, the Employee is in Office premises.");
                	else
                		System.out.println("No, the Employee is not in Office.");
                    break;
                case 4:
                	System.out.print("\n\n Enter the Employee Id: ");
                	empId= scan.nextInt();
                	System.out.println("Employee with ID-" + empId + " has entered " + bTree.howOften(empId) + " times.");
                    break;
                case 5:
                	System.out.println("Employee  " + bTree.frequentVisitor(bTree.getRoot()).getEmpId() + " moves most number of times.");
                    break;
                case 6:
                	System.out.print("\n\n Enter the Employee Id for Lower Range(from): ");
                	empId= scan.nextInt();
                	System.out.print("\nEnter the Employee Id for Higher Range(to): ");
                	int empId2= scan.nextInt();
                    bTree.printRangePresent(bTree.getRoot(), empId, empId2);
                    break;
                default:
                    return;
            }            
        }while(choice != 7 );  
        scan.close();  
	  } 		
	}
