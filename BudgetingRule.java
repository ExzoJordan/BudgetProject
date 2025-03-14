/**
 * 
 */
package RoadToSSE1Package;
import java.util.Scanner;
import java.io.PrintWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.text.DecimalFormat;


/**
 * @author ijorda2
 *
 */
public class BudgetingRule {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		Scanner scnr = new Scanner (System.in);
		int numberOfCustomers = 10;//Limit on number of customers
		int customerID = -1;//Keeps track of customer ID's
	    int choice = 10;//Choice corresponds with a number to use program.
	    CustomerBudget[] Customer = new CustomerBudget[numberOfCustomers];
		
		DecimalFormat df = new DecimalFormat ("$#.##");
		
		
		
		
		
		
		
		
		//Allows multiple people to create a budgeting account.
		while(choice != 0) {
			
			//Display menu
			System.out.println("Please enter a number: 1 - create a budget account \n"
					+ "                                2 - load an account \n"
					+ "                                3 - set a budget ");
			
			choice = 10; //Resets the choice number to default.
			choice = scnr.nextInt();//Scans next choice number for program.
			
			switch(choice) {
			
			//Case 1 will allow you to create an account.
			case 1: 
							
				customerID++;
				
				
				
					
					Customer[customerID] = new CustomerBudget();
					System.out.println("Your customer ID is:" + customerID);
					Customer[customerID].createAccount();
					
					
					
					
				
				
				
				
				
			
			break;
			
			//Case 2 will load an account.
			case 2:
				
				System.out.println("Please enter your customer ID: ");
				customerID = scnr.nextInt();
				System.out.println("Your name is: " + Customer[customerID].getName());
			
			break;
			
			//Case 3 will set the budget.
			case 3:
							
				Customer[customerID].setBudget();
				
				//Calculate budget with monthly income
				Customer[customerID].calculateBudget();
				
				Customer[customerID].writeBudget();
				
				//Print out budget
				System.out.println(Customer.toString());
				
				Customer[customerID].readBudget();
				
				System.out.println("Current working directory: " + System.getProperty("user.dir"));
		
			break;
			
			//Checks the budget on the account
			case 4:
			
				System.out.println(Customer[customerID].toString());
				
			break;
			
			default:
			
			break;
			
			
			}
		}
		try  {
		
		PrintWriter writer = new PrintWriter("Budget.txt");
		
		for(int i = 0; i <= customerID; i++) {
			
			
				
				
				writer.println(Customer[i].getName());
				writer.println(Customer[i].getNeedsBudget());
				writer.println(Customer[i].getWantsBudget());
				writer.println(Customer[i].getSavingsBudget());
				
				System.out.println("Data saved");
		}
		writer.close();	
		}	
			catch (IOException e) {
				System.out.println("Error writting file");
			}
		
		
		
		
		
		
		
		

	}

}
