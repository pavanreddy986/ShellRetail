package seller;
import java.util.*;
import ecomm.*;
import ecomm.Globals;
import ecomm.Platform;
import ecomm.Product;
import ecomm.Seller;
public class SellerA extends Seller{
    private String myID;
    public SellerA(String id){
        super(id);
        Mobile mobile1=new Mobile();mobile1.setVals("zoro", "9492", 2000f, 15);
        Book book1=new Book();book1.setVals("benchmate", "cengage", 246.2f, 10);
        products.add(mobile1);
        products.add(book1);
        Mobile mobile2=new Mobile();mobile2.setVals("luffy", "9241", 2200f, 20);
        Book book2=new Book();book2.setVals("glassmate", "deepthi_publications", 346.5f, 11);
        products.add(mobile2);
        products.add(book2);
        Mobile mobile3=new Mobile();mobile3.setVals("sanji", "9493", 2300f, 25);
        Book book3=new Book();book3.setVals("onenote", "ativeer", 148.2f, 13);
        products.add(mobile3);
        products.add(book3);
    }
    public ArrayList<Product>products=new ArrayList<Product>();
    
    public String getID() { return myID;}
    public void addPlatform(Platform thePlatform,Seller S){
        thePlatform.addSeller(S);
    }
    public ArrayList<Product> findProducts(Globals.Category whichOne){
        ArrayList<Product> pro=new ArrayList<Product>();
        for(int i=0;i<products.size();i++)
        {
            if(products.get(i).getCategory().equals(whichOne)){
                pro.add(products.get(i));
            }
        }
        return pro; 
    }
    public boolean buyProduct(String productID,int quantity){
        for(int i=0;i<products.size();i++)
        {
            
            if(products.get(i).getProductID().equals(productID))
            {
                
                if(products.get(i).getQuantity()>quantity){
                    
                    products.get(i).setQuantity(quantity);
                    return true;
                }
            }
        }
        return false;
    }
}
