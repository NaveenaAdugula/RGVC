
public class BankRunner implements Runnable {

	ICICIBank bank;
	
	public BankRunner(ICICIBank bank)
	{
		this.bank=bank;
	}
	
	
	
	@Override
	public void run() {
		
		
		try
		{
			if(Thread.currentThread().getName().equals("first"))
			{
			System.out.println("Balance = "+bank.withdrawAmount(101, 2000));
			}
			else
			{
				System.out.println("Balance = "+bank.withdrawAmount(101, 2000));
			}
		}catch(InvalidAccountNumberException ian)
		{
			System.out.println("invalid account number");
		}catch(InsufficientBalanceException ibe)
		{
			System.out.println("Insufficient balance");
		}

	}

}
