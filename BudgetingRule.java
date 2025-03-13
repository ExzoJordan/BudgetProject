/**
 * 
 */
package RoadToSSE1Package;
import java.util.Scanner;
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
		int numberOfCustomers = 10;
		int customerID = -1;
	    int choice = 10;
	    CustomerBudget[] Customer = new CustomerBudget[numberOfCustomers];
		
		DecimalFormat df = new DecimalFormat ("$#.##");
		
		
		
		
		System.out.println("Please enter a number: 1 - create a budget account \n"
				+ "                                2 - load an account \n"
				+ "                                3 - set a budget ");
		
		
		
		
		//Allows multiple people to create a budgeting account.
		while(choice != 0) {
			choice = 10;
			choice = scnr.nextInt();
			
			switch(choice) {
			
			//Case 1 will allow you to create an account
			case 1: 
				choice = 10;
				
				customerID++;
				System.out.println("Your customer ID is:" + customerID);
				
				
					
					Customer[customerID] = new CustomerBudget();
					
					//Get Customer Name
					System.out.println("Please enter your name: ");
					Customer[customerID].setName(scnr.next());
					System.out.println("You're name is: " + Customer[customerID].getName());
					
					
					
				
				
				
				
				
			
			break;
			
			//Case 2 will load an account
			case 2:
				
				System.out.println("Please enter your customer ID: ");
				customerID = scnr.nextInt();
				System.out.println("Your name is: " + Customer[customerID].getName());
			
			break;
			
			//Case 3 will set the budget
			case 3:
				
				//Monthly Income Prompt
				System.out.print("Please Input your income for this month: ");
				
				//Store Monthly Income
				Customer[customerID].setMonthlyIncome(scnr.nextDouble());
				
				System.out.println("Monthly income is:  " + df.format(Customer[customerID].getMonthlyIncome()) + "\n");
				
				//Set the budget. resets if the percentages doesn't add up to 1
				while (Customer[customerID].checkBudget() == false) {
					
					//Resets budgets if done incorrectly
					Customer[customerID].setNeedsBudget(0);
					Customer[customerID].setWantsBudget(0);
					Customer[customerID].setSavingsBudget(0);
					
					System.out.println("Enter needs percentage");
					Customer[customerID].setNeedsBudget(scnr.nextDouble()); //User inputs needs budget percentage
					
					System.out.println("Enter wants percentage");
					Customer[customerID].setWantsBudget(scnr.nextDouble()); //User inputs wants budget percentage
					
					System.out.println("Enter savings percentage");
					Customer[customerID].setSavingsBudget(scnr.nextDouble()); //User inputs savings budget percentage
					
					//Checks if the percentages adds up to 1
					if (Customer[customerID].checkBudget() == true) {
						System.out.println("Checking budget... \n");
						
						try {
							Thread.sleep(2000);//Timer
						}
						catch (InterruptedException e)
						{
						e.printStackTrace();	
						}
						
						System.out.println("Budget created!!");
					}
					else {
						System.out.println("Checking budget... \n");				
						try {
							Thread.sleep(1000);//Timer
						}
						catch (InterruptedException e) {
						e.printStackTrace();	
						}
						System.out.println("Budget Unsuccessful. Percentages must equal to 1 \n");
					}
				}
				
				//Calculate budget with monthly income
				Customer[customerID].calculateBudget();
				
				Customer[customerID].writeBudget();
				
				//Print out budget
				System.out.println(Customer.toString());
				
				Customer[customerID].readBudget();
				
				System.out.println("Current working directory: " + System.getProperty("user.dir"));
		
			break;
			
			default:
			
			break;
			
			
			}
		}
		
		
		
		
		
		
		
		
		
		

	}

}
