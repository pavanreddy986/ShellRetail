package seller;
import java.util.*;
import ecomm.*;
import ecomm.Globals;
import ecomm.Platform;
import ecomm.Product;
import ecomm.Seller;
public class SellerC extends Seller{
    private String myID;
    public SellerC(String id){
        super(id);
        Mobile mobi=new Mobile();
        mobi.setVals("something", "9004", 1000f, 12);
        Book b=new Book();
        b.setVals("classmate", "arihant", 265.4f, 12);
        items.add(mobi);
        items.add(b);
        Mobile mobi2=new Mobile();
        mobi2.setVals("anything", "10000", 10000f, 15);
        Book b2=new Book();
        b2.setVals("roomate", "irodov", 565.4f, 116);
        items.add(mobi2);
        items.add(b2);
    }
    public ArrayList<Product>items=new ArrayList<Product>();
    
    public String getID() { return myID;}
    public void addPlatform(Platform thePlatform,Seller S){
        thePlatform.addSeller(S);
    }
    public ArrayList<Product> findProducts(Globals.Category whichOne){
        ArrayList<Product> lis=new ArrayList<Product>();
        for(int i=0;i<items.size();i++)
        {
            if(items.get(i).getCategory().equals(whichOne)){
                lis.add(items.get(i));
            }
        }
        return lis; 
    }
    public boolean buyProduct(String productID,int quantity){
        for(int i=0;i<items.size();i++)
        {
            
            if(items.get(i).getProductID().equals(productID))
            {
                
                if(items.get(i).getQuantity()>quantity){
                    
                    items.get(i).setQuantity(quantity);
                    return true;
                }
            }
        }
        return false;
    }
}
