/**
 * 
 */
package RoadToSSE1Package;
import java.io.PrintWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.text.DecimalFormat;
import java.util.Scanner;

/**
 * @author ijorda2
 *
 */
public class CustomerBudget {
	
	DecimalFormat df = new DecimalFormat ("$#.##");
	
	double monthlyIncome; //Monthly income of user.
	double needsBudgetPercentage; //Percent of needs budget.
	double wantsBudgetPercentage; //Percent of wants budget.
	double savingsBudgetPercentage; //Percent of savings budget
	
	double needsBudget; //Amount of needs budget
	double wantsBudget; //Amount of wants budget
	double savingsBudget; //Amount of savings budget
	
	String name = "";
	
//SETTERS

/**
 * Sets the name for the customer.
 * 
 * @param name The name of the customer.
 */
public void setName(String name) {
	this.name = name;
}
	
/**
 * Sets the monthly income for customer
 * 
 * @param monthlyIncome The monthly income of the customer.
 */
public void setMonthlyIncome( double monthlyIncome) {
	this.monthlyIncome = monthlyIncome;
}

/**
 * Sets the needs percentage budget.
 * 
 * @param needsBudget The needs percentage budget.
 */
public void setNeedsBudget (double needsBudget) {
	this.needsBudgetPercentage = needsBudget;
}

/**
 * Sets the wants percentage budget.
 * 
 * @param wantsBudget The wants percentage budget.
 */
public void setWantsBudget (double wantsBudget) {		
		this.wantsBudgetPercentage = wantsBudget;		
}

/**
 * Sets the savings percentage budget.
 * 
 * @param savingsBudget The savings percentage budget
 */
public void setSavingsBudget (double savingsBudget) {
		this.savingsBudgetPercentage = savingsBudget;
}

//GETTERS

/**
 * Gets the name of the customer.
 * 
 * @return The name of the customer.
 */
public String getName() {	
	return name;
}

/**
 * Gets the monthly income of customer
 * 
 * @return The customers monthly income.
 */
public double getMonthlyIncome() {	
	return monthlyIncome;
}

//BOOLEAN

/**
 * Checks If needs,wants, and savings percentage adds to 1
 * 
 * @return True if sum is equal to 1, False if not equal to 1
 */
public boolean checkBudget() {	
	
	double sum = (needsBudgetPercentage + wantsBudgetPercentage + savingsBudgetPercentage);
	
	return Math.abs(sum - 1) < 0.0001;
}

//METHODS


/**
 * This method Calculates the needs budget, wants budget, and savings budget
 * based on the monthly income and budget percentages.
 * 
 */
public void calculateBudget() {	
	needsBudget = monthlyIncome * needsBudgetPercentage;
	wantsBudget = monthlyIncome * wantsBudgetPercentage;
	savingsBudget = monthlyIncome * savingsBudgetPercentage;
	
}

//ToString

/**
 * This method prints the needs, wants, and savings budget amounts.
 * 
 */
public String toString() {
	
	return "According to you're income and split budget percentages \n" +
		   "Your income should be split as such \n" +
		   "\n" +
		   "Needs budget: " + df.format(needsBudget) + "\n" + 
		   "Wants budget: " + df.format(wantsBudget) + "\n" + 
		   "Savings budget: " + df.format(savingsBudget) + "\n";
}

//Write Method

/**
 * This method writes needs, wants ,and savings budget to Budget.txt File.
 * 
 */
public void writeBudget() {
	try  {
		PrintWriter writer = new PrintWriter("Budget.txt");
		
		writer.println(name);
		writer.println(needsBudget);
		writer.println(wantsBudget);
		writer.println(savingsBudget);
		
		System.out.println("Data saved");
		writer.close();
	}	
	catch (IOException e) {
		System.out.println("Error writting file");
	}	
}

//Read Method

/**
 * This method reads the Budget.txt file and prints out the budget.
 */
public void readBudget() {
	try {
		Scanner read = new Scanner(new File("Budget.txt"));
		
		while (read.hasNextLine()) {	
			name = read.nextLine();
			needsBudget = Double.parseDouble(read.nextLine());
			wantsBudget = Double.parseDouble(read.nextLine());
			savingsBudget = Double.parseDouble(read.nextLine());
			
			System.out.println(needsBudget);
			System.out.println(wantsBudget);
			System.out.println(savingsBudget);						
		}		
	} 
	catch (FileNotFoundException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
}

 


}