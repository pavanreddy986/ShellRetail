package demo;
import ecomm.Globals;
import ecomm.Platform;
import ecomm.Product;
import ecomm.Seller;
import ecomm.Globals.Category;
import ecomm.*;
import java.util.*;
import java.io.File;
import java.io.FileWriter;
import java.io.*;
import java.io.BufferedWriter;
import java.io.IOException;
public class DemoPlatform extends Platform {
	ArrayList<Seller>se=new ArrayList<Seller>();
	@Override
	public boolean addSeller(Seller aSeller) {
		se.add(aSeller);
		return true;
	}
	@Override
	public void processRequests() {
		try{
			File file = new File("PortalToPlatform.txt");
			Scanner sc = new Scanner(file);
			PrintWriter writ=new PrintWriter("PlatformToPortal.txt");
			writ.print("");
			while (sc.hasNextLine()){
				String s=sc.nextLine();
				String[] sa=s.split(" ");
				String pid=sa[0],rid=sa[1],com=sa[2];
				if(com.equals("List")){
					Globals.Category cat=Globals.Category.valueOf(sa[3]);
					ArrayList<Product> l=new ArrayList<Product>();
					FileWriter fw = new FileWriter("PlatformToPortal.txt",true);
					for(Seller i:se){
						l=i.findProducts(cat);
						for(Product x:l){
							fw.write(sa[0]+" "+sa[1]+" "+x.getCategory()+" "+x.getName()+" "+x.getPrice()+" "+x.getQuantity());
							fw.write("\n");
						}
					}
					fw.close();	
				}
				else if(com.equals("Buy")){
					BufferedWriter fw = new BufferedWriter(new FileWriter("PlatformToPortal.txt",true));
					boolean isopen=true;
					for(Seller i:se){
						if(i.buyProduct(sa[3],Integer.parseInt(sa[4]))){							
							fw.write(sa[0]+" "+sa[1]+" "+"Success");
							fw.write("\n");
							fw.close();
							isopen=false;
							break;
						}	
					}
					if(isopen){
						fw.write(sa[0]+" "+sa[1]+" "+"Failure");
						fw.write("\n");
						fw.close();
						isopen=false;
					}
				}
				else if(com.equals("Start")){		
					FileWriter fw = new FileWriter("PlatformToPortal.txt",true);
					/*fw.write(sa[0]+" "+sa[1]);
					for(Globals.Category x : Globals.Category.values()){
						fw.write(" "+Globals.getCategoryName(x));
					}
					fw.write("\n");
					//fw.write(System.getProperty("line.seperator"));
					fw.close();*/
					for(Seller e:se)
					{
						int mq=0,bq=0;
						for(Product prol:e.findProducts(Globals.Category.values()[0]))
						{
							if(prol.getQuantity()>0) bq++;
						}
						for(Product prol:e.findProducts(Globals.Category.values()[1]))
						{
							if(prol.getQuantity()>0) mq++;
						}
						fw.write(sa[0]+" "+sa[1]);
						if(mq>0 && bq>0)
						{
							fw.write(" "+"Book"+" "+"Mobile");
						}
						else if(bq==0) 
						{
							fw.write(" "+"Mobile");
						}
						else if(mq==0)
						{
							fw.write(" "+"Book");
						}
					}
					fw.write("\n");
					fw.close();
				}
			}
		}
		catch(IOException e){
			System.out.print("File not found");
		}
	}
}
