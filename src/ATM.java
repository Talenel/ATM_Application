import java.math.BigDecimal;
import java.util.ArrayList;

public class ATM implements iATM {

	private ArrayList<Account> accounts;
	public ATM() {
		accounts=new ArrayList<>();
		// TODO Auto-generated constructor stub
	}

	@Override
	public  String getBalance(String user, int pin) {
		// TODO Auto-generated method stub
		TransactionSummary r;
		boolean check=true;
		boolean correct=true;
		int find=0;
		int attempts=0;
		for(int i=0; i<accounts.size();i++)
		{ 
				if(user.equals(accounts.get(i).getAcct()))
				{
					check=false;
					if(pin==accounts.get(i).getPin())
					{
						
						find=i;
						
					}
					else
					{
						correct=false;
						attempts=accounts.get(i).lock();
					}
					break;
				}
				
			
		}
		if(!check)
		{
			if(accounts.get(find).checkLock())
			{	
				return "This account if locked right now.  The lock will last a total of 30 minutes\n"
					+ "Please try again later.";
			}
	
			else if(correct)
			{
				accounts.get(find).unlock();
				r=new TransactionSummary(accounts.get(find).getUser(),accounts.get(find).getBalance());
				
				return r.getReceipt();
			}
			else
			{
				return "That pin is incorrect.  You have "+(3-attempts)+" attempts remaining";
			}
			
			
		}
		else
		{
			return "This account number does not correspond to an account in our database";
		}
		
		
		
		
	}

	@Override
	public String withdrawFunds(BigDecimal amt, String acct, int pin) {
		TransactionSummary r;
		boolean check=true;
		boolean correct=true;
		int find=0;
		int attempts=0;
		for(int i=0; i<accounts.size();i++)
		{ 
				if(acct.equals(accounts.get(i).getAcct()))
				{
					check=false;
					if(pin==accounts.get(i).getPin())
					{
						
						find=i;
						
					}
					else
					{
						correct=false;
						attempts=accounts.get(i).lock();
					}
					break;
				}
				
			
		}
		if(!check)
		{
			if(accounts.get(find).checkLock())
			{	
				return "This account if locked right now.  The lock will last a total of 30 minutes\n"
					+ "Please try again later.";
			}
	
			else if(correct)
			{
				accounts.get(find).unlock();
				if(!amt.max(accounts.get(find).getBalance()).equals(amt))
				{
					accounts.get(find).setBalance(accounts.get(find).getBalance().subtract(amt));
					
					r=new TransactionSummary(accounts.get(find).getUser(),accounts.get(find).getBalance());
					
					return r.getReceipt();
					
				}
				else
				{r=new TransactionSummary(accounts.get(find).getUser(),accounts.get(find).getBalance());
				
				return r.getReceipt()
							+"\nThere are insufficient funds in your account for this withdrawal. Please try again";
				}
			}
			else
			{
				return "That pin is incorrect.  You have "+(3-attempts)+" attempts remaining";
			}
			
			
		}
		else
		{
			return "This account number does not correspond to an account in our database";
		}
	}

	@Override
	public String depositFunds(BigDecimal amt, String acct, int pin) {
		TransactionSummary r;
		boolean check=true;
		boolean correct=true;
		int find=0;
		int attempts=0;
		for(int i=0; i<accounts.size();i++)
		{ 
				if(acct.equals(accounts.get(i).getAcct()))
				{
					check=false;
					if(pin==accounts.get(i).getPin())
					{
						
						find=i;
						
					}
					else
					{
						correct=false;
						attempts=accounts.get(i).lock();
					}
					break;
				}
				
			
		}
		if(!check)
		{
			if(accounts.get(find).checkLock())
			{	
				return "This account if locked right now.  The lock will last a total of 30 minutes\n"
					+ "Please try again later.";
			}
	
			else if(correct)
			{
				accounts.get(find).unlock();
				accounts.get(find).setBalance(amt.add(accounts.get(find).getBalance()));
				r=new TransactionSummary(accounts.get(find).getUser(),accounts.get(find).getBalance());
				
				return r.getReceipt();
			}
			else
			{
				return "That pin is incorrect.  You have "+(3-attempts)+" attempts remaining";
			}
			
			
		}
		else
		{
			return "This account number does not correspond to an account in our database";
		}
	}

	@Override
	public String createUser(String acct, int aPin, String userName, BigDecimal aBalance) {
		// TODO Auto-generated method stub
		boolean checkA=true;
		
		for(int i=0; i<accounts.size();i++)
		{ 
				if(acct.equals(accounts.get(i).getAcct()))
				{
					checkA=false;
					
					
				}
				
				
			
		}
		if(checkA)
		{
			Account newAcct=new Account(acct,aPin,userName,aBalance);
			accounts.add(newAcct);
			return "Thanks for making a new account, "+newAcct.getUser()
			+"\nYour account number is "+newAcct.getAcct();
		}
		else
		{
			return "You must select a different account number, that account number is already in use";
		}
	}
	
	
	

}
