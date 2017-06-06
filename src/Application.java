import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.Scanner;

public class Application {

	public static void main(String[] args)
	{
		
		
		boolean check=true;
		Scanner sc = new Scanner(System.in);
		ATM atm = new ATM();
		do{
			
			System.out.print("What would you like to do today? \n"
					+ "Enter 1 to get the balance of your account \n"
					+ "Enter 2 to withdraw funds from your account \n"
					+ "Enter 3 to deposit funds to your account\n"
					+ "Enter 4 to create an account\n"
					+ "Enter any other number to restart\n");
			String input1=sc.nextLine();
			if(input1.equals("1"))
			{
				
				System.out.println("Please enter your account number now:");
				String acct=sc.nextLine();
				
				System.out.println("Please enter your PIN number now:");
				int pin=Integer.parseInt(sc.nextLine());
				
				System.out.println(atm.getBalance(acct, pin));
				
			}
			else if(input1.equals("2"))
			{
				
				System.out.println("Please enter your account number now:");
				String acct=sc.nextLine();
				
				System.out.println("Please enter your PIN number now:");
				int pin=Integer.parseInt(sc.nextLine());
				
				System.out.println("Please enter the amount you would like to withdraw now:");
				BigDecimal amt=new BigDecimal(sc.nextLine());
				amt.setScale(2, RoundingMode.HALF_EVEN);
				System.out.println(atm.withdrawFunds(amt,acct, pin));
				
			}
			else if(input1.equals("3"))
			{
				
				System.out.println("Please enter your account number now:");
				String acct=sc.nextLine();
				
				System.out.println("Please enter your PIN number now:");
				int pin=Integer.parseInt(sc.nextLine());
				
				System.out.println("Please enter the amount you would like to deposit now:");
				BigDecimal amt=new BigDecimal(sc.nextLine());
				amt.setScale(2, RoundingMode.HALF_EVEN);
				System.out.println(atm.depositFunds(amt, acct, pin));
				
			}
			else if(input1.equals("4"))
			{
				
				System.out.println("Please enter your new account number now:");
				String acct=sc.nextLine();
				
				System.out.println("Please enter your desired PIN number now:");
				int pin=Integer.parseInt(sc.nextLine());
				
				System.out.println("Please enter your username now:");
				String user=sc.nextLine();
				
				System.out.println("Please enter the amount you would like to deposit as your new balance now");
				BigDecimal bal=new BigDecimal(sc.nextLine());
				
				System.out.println(atm.createUser(acct, pin, user, bal));
				
				
			}
			else
			{
				System.out.println("That is not a valid input, Please restart");
			}
	
			
			System.out.print("Would you like to perform another transaction?\n"
					+ "Enter 1 for Yes or 2(or any other number) for no\n");
			String input5=sc.nextLine();
			if(!input5.equals("1"))
			{
				check=false;
			}
			
			
		}while (check);
		sc.close();
		
	}

}
