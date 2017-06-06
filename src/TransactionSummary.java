import java.math.BigDecimal;

public class TransactionSummary extends Receipt {

	public TransactionSummary(String aUser, BigDecimal aBal) {
		super(aUser, aBal);
		// TODO Auto-generated constructor stub
	}

	@Override
	public String getReceipt() 
		{
			StringBuilder sb=new StringBuilder("__________________________________________\n"
					+"|                                        |\n"
					+"|             Bank of Justin             |\n"
					+"|                ATM# 1027               |\n"
					+"|                                        |\n"
					+"|                                        |\n"
					+"|              Welcome "+this.getUser()+"               |\n"
					+"|         New Balance: $"+this.getBal()+"          |\n"
					+"|                                        |\n"
					+"| Thanks for Banking with Bank of Justin |\n"
					+"|________________________________________|\n\n\n");
			
			
			
			
			
			
			
			
			
			
			
			return sb.toString();
		}

}
