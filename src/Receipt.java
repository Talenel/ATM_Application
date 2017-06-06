import java.math.BigDecimal;

public abstract class Receipt {
	
	private String user;
	private BigDecimal bal;
	
	public Receipt(String aUser, BigDecimal aBal)
	{
		bal=aBal;
		user=aUser;
	}
	
	public abstract String getReceipt();
	
	public String getUser()
	{
		return user;
	}
	public BigDecimal getBal()
	{
		return bal;
	}
	
	

}
