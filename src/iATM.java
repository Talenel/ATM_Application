import java.math.BigDecimal;

public interface iATM {
	
	public String getBalance(String user, int pin);
	
	public String withdrawFunds(BigDecimal amt, String user, int pin);
	
	public String depositFunds(BigDecimal amt, String user, int pin);
	
	
	public String createUser(String  anAcct,int aPin, String aUserName, BigDecimal aBalance);

}
