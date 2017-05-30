
public class Client {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
  
		ICICIBank b=new ICICIBank();
		try
		{
			b.display();
		}catch(Exception obj)
		{
			System.out.println(obj.getMessage());
		}
	}

}
