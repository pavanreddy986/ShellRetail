
import demo.DemoPlatform;
import ecomm.Platform;
import ecomm.Seller;
import seller.*;
import java.util.*;
public class PlatformMain {

	public static void main(String[] args) {

		Platform pf = new DemoPlatform();  // replace with appropriate derived class
		
		// create a number of sellers (of different sub-types of Seller)
		// Assign a name (sellerID) to each of them.
		
		// replace each of the XYZ below with the derived class name of one of the
		// team members.
		
		
		Seller s1 = new SellerG("Seller1"); 
		s1.addPlatform(pf,s1);
		Seller s2=new SellerA("Seller2");
		s2.addPlatform(pf,s2);
		Seller s3=new SellerC("Seller3");
		s3.addPlatform(pf,s3);
		Scanner sk=new Scanner(System.in);
		while(true){
			String s=sk.nextLine();
			if(s.equals("Check")){
				pf.processRequests();
			}
		}
	}

}
