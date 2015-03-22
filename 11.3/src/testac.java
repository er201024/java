/**
 * Name: ´^²[ªå </br>
 * ID: U10316003 </br>
 * Ex: 11.3 </br>
 */
 

import java.util.Date;
import java.util.Scanner;
public  class testac{

	/**Main method*/
	public static void main(String[] args){

		//Create Scanner object
		Scanner input = new Scanner(System.in);
	
		//Definite the variable
		int service;
		double money;

		//print
		System.out.println("your ID : 1122 \nBalance : 20000 \nAnnual Interest Rate : 4.5%");
		
		System.out.println("Account : \nWhich service do you want? withdraw (press \"1\") or deposit (press \"2\") ");
		
		service = input.nextInt();

		System.out.println("How much money?");
		
		money = input.nextDouble();

		Account account = new Account(1122, 20000);
	
		//Invoke setannualInterestRate method record rate
		account.setannualInterestRate(4.5);

		if(service == 1){
		
			account.withdraw(money);		
		
		}else if(service == 2){
		
			System.out.println("Saving Money : " + money); 
			account.deposit(money);
		}else{
			
			System.out.println("No exist the service");
		}

		System.out.println(account.toString());

		
		System.out.println("\nCheckingAccount : \nWhich service do you want? withdraw (press \"1\") or deposit (press \"2\") ");
		
		service = input.nextInt();
		
		System.out.println("How much money? \nChecking account has an overdraft limit $5000 .");		

		money = input.nextDouble();

		//Create check object
		CheckingAccount check = new CheckingAccount(1122, 20000);

		//Invoke setannualInterestRate method rate
		check.setannualInterestRate(4.5);

		if(service == 1){
		
			check.withdraw(money);		
		}
		else if(service == 2){

			System.out.println("Saving Money : " + money); 
			check.deposit(money);
		}
		else{
			
			System.out.println("No exist the service");
		}

		//Invoke the toString method to print the result
		System.out.println(check.toString());
		
		
		System.out.println("\nSavingsAccount : \nWhich service do you want? withdraw (press \"1\") or deposit (press \"2\") ");
		
		service = input.nextInt();
				
		System.out.println("How much money? \nSaving account cannot be overdrawn!");
		
		money = input.nextDouble();
		
		//Create save object
		SavingsAccount save = new SavingsAccount(1122, 20000);
		
		//Invoke setannualInterestRate method record rate
		save.setannualInterestRate(4.5);

		if(service == 1){
		
			save.withdraw(money);		
		}
		else if(service == 2){
	
			System.out.println("Saving Money : " + money); 
			save.deposit(money);
		}
		else{
			
			System.out.println("No exist the service");
		}

		//print the result
		System.out.println(save.toString());
	
		
	}
}
class Account{
	/** Main method */
	private int id = 0;
	private double Balance = 0;
	private double annualInterestRate = 0;
	private java.util.Date dateCreated ;
		//a no-arg construct
		public Account(){
			
		}
		//Construct Accounts
		public Account(int id ,double Balance){
			dateCreated = new java.util.Date();
			this.id = id;
			this.Balance = Balance;
		}
		//set id
		public void setid(int id){
			this.id = id;
		}
		//get id
		public int getid(){
			return id;
		}
		//set Balance
		public void setBalance(double Balance){
			this.Balance = Balance;
		}
		//get Balance
		public double getBalance(){
			return Balance;
		}
		//a method set annual interest rate
		public void setannualInterestRate(double annualInterestRate){
			this.annualInterestRate = annualInterestRate;
		}
		//a method get annual interest rate
		public double getannualInterestRate(){
			return annualInterestRate / 100;
		}
		//a method getdateCreated
		public java.util.Date getdateCreated(){
			return dateCreated;
		}
		//a method getmonthlyInterestRate
		public double getmonthlyInterestRate(){
			return getannualInterestRate() / (12 * 100);
		}
		//a method getmonthlyInterest
		public double getmonthlyInterest(){
			return getBalance() * getmonthlyInterestRate();
		}
		//a method withdraw
		public double withdraw(double withdraw){
			return Balance = Balance - withdraw;
		}
		//a method deposit
		public double deposit(double deposit){
			return Balance = Balance + deposit;
		}
		
		//toString method
		public String toString(){

			return "ID : " + getid() + "\nBalance : " + getBalance() + "\nMonthly Interest : " + getmonthlyInterest() + "\nDate : " + dateCreated;
		}
}


class CheckingAccount extends Account{
	private double withdrawMoney;
	private double savingMoney;
	
	//a no-arg construct
	CheckingAccount(){
		super();
			
	}
	//Construct a Checking Accounts
	CheckingAccount(int iid, double bbalance){

		super(iid, bbalance);
		
	}
	//a method 			
	public void setannualInterestRate(double annualInterestRate){

		super.setannualInterestRate(annualInterestRate);
	}
	
	//a method withdraw to new balance
	public double withdraw(double withdraw){

		double money;
		money = overdraft(withdraw);
		return super.withdraw(money);
	}

	//a method deposit to new balance
	public double deposit(double deposit){
	
		return super.deposit(deposit);
	}
	
	//decide if the account has the overdraft limit
	public double overdraft(double withdrawMoney){

		double balance = super.getBalance();
		
		if(balance - withdrawMoney < -5000){

			System.out.println("Your balance is less $5000 than withdraw Money");
		
			withdrawMoney = 0;
		}
		
		System.out.println("Withdraw Money : " + withdrawMoney);
		return withdrawMoney;
	}
		//String 
		@Override
		public String toString(){
			return super.toString();
			}	
	}


class SavingsAccount extends Account{
	//a no-arg construct
	SavingsAccount(){

		super();	
	}
	//Construct a Checking Accounts
	SavingsAccount(int iid, double bbalance){

		super(iid, bbalance);
	}
	
	//a method 
	public void setannualInterestRate(double annualInterestRate){

		super.setannualInterestRate(annualInterestRate);
	}
	
	//a method withdraw to new balance
	public double withdraw(double wwithdraw){
		
		double money;	
		money = overdraft(wwithdraw);
		return  super.withdraw(money);
	}

	//a method deposit to new balance
	public double deposit(double deposit){
	
		return  super.deposit(deposit);
	}
	
	//decide if the account has the overdraft limit
	public double overdraft(double withdrawMoney){

		double balance = super.getBalance();
		
		if(balance < withdrawMoney){

			System.out.println("Your balance is less than withdraw Money\nSaving account cannot be overdrawn!");
		
			withdrawMoney = 0;
		}
		
		System.out.println("Withdraw Money : " + withdrawMoney);
		return withdrawMoney;
	}
	//String 
	@Override
	public String toString(){

		return super.toString();
	}
}