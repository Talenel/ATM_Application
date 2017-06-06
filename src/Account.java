import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;

public class Account {
	
	
	private String acctNum;
	private int pin;
	private String userName;
	private BigDecimal balance;
	private boolean locked;
	private LocalDateTime lockTime;
	private LocalDateTime firstFail;
	private LocalDateTime secondFail;
	private int attempts;
	
	public Account(String  anAcct,int aPin, String aUserName, BigDecimal aBalance)
	{
		acctNum=anAcct;
		pin=aPin;
		userName=aUserName;
		balance=aBalance;
		locked=false;
		lockTime=LocalDateTime.now();
		lockTime.minusMinutes(60);
		firstFail=lockTime;
		secondFail=lockTime;
		attempts=0;
	}
	
	public String getAcct()
	{
		
		return acctNum;
	}
	public String getUser()
	{
		return userName;
	}
	public int getPin()
	{
		return pin;
	}
	public BigDecimal getBalance()
	{
		return balance;
	}
	public void setBalance( BigDecimal newBal)
	{
		balance=newBal;
	}
	
	
	public void unlock()
	{
		attempts=0;
		firstFail=LocalDateTime.now().minusMinutes(60);
		secondFail=firstFail;
		
	}
	public boolean checkLock()
	{
		if(lockTime.toLocalDate().equals(LocalDate.now()))
		{
			if(lockTime.toLocalTime().isBefore((LocalTime.now().minusMinutes(30))))
			{
				locked=false;
			}
		}
		
		return locked;
	}
	public int lock()
	{	
		if(firstFail.equals(lockTime))
		{
			firstFail=LocalDateTime.now();
			attempts=1;
			
		}
		else if(secondFail.equals(lockTime))
		{
			secondFail=LocalDateTime.now();
			attempts=2;
		}
		
		else if(firstFail.toLocalDate().equals(LocalDate.now()))
		{
			if(firstFail.toLocalTime().isAfter((LocalTime.now().minusMinutes(30))))
			{
				if(secondFail.toLocalTime().isAfter((LocalTime.now().minusMinutes(30))))
				{
					locked=true;
					lockTime=LocalDateTime.now();
					attempts=0;
					
				}
				else
				{
					secondFail=LocalDateTime.now();
					attempts=2;
				}
			}
			else
			{
				firstFail=LocalDateTime.now();
				attempts=1;
			}
		}
		else
		{
			firstFail=LocalDateTime.now();
			attempts=1;
		}
		return attempts;
	}
	

}
