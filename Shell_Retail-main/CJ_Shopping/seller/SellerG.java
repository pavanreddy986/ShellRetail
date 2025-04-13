package seller;
import java.util.*;

import ecomm.*;
import ecomm.Globals;
import ecomm.Platform;
import ecomm.Product;
import ecomm.Seller;
public class SellerG extends Seller{
    private String myID;
    public SellerG(String id){
        super(id);
        Mobile mob=new Mobile();mob.setVals("nami", "123", 900f, 7);
        Book bo=new Book();bo.setVals("abc", "seller1-book1", 345.3f, 5);
        prolist.add(mob);
        prolist.add(bo);
        Mobile mob2=new Mobile();mob2.setVals("boa_hancock", "456", 1000f, 9);
        Book bo2=new Book();bo2.setVals("def", "seller2-book2", 145.8f, 8);
        prolist.add(mob2);
        prolist.add(bo2);
        Mobile mob3=new Mobile();mob3.setVals("robin", "789", 2100f, 10);
        Book bo3=new Book();bo3.setVals("ghi", "seller2-book2", 765.8f, 7);
        prolist.add(mob3);
        prolist.add(bo3);
    }
    public ArrayList<Product>prolist=new ArrayList<Product>();
    
    public String getID() { return myID;}
    public void addPlatform(Platform thePlatform,Seller S){
        thePlatform.addSeller(S);
    }
    public ArrayList<Product> findProducts(Globals.Category whichOne){
        ArrayList<Product> l=new ArrayList<Product>();
        for(int i=0;i<prolist.size();i++)
        {
            if(prolist.get(i).getCategory().equals(whichOne)){
                l.add(prolist.get(i));
            }
        }
        return l; 
    }
    public boolean buyProduct(String productID,int quantity){
        for(int i=0;i<prolist.size();i++)
        {
            
            if(prolist.get(i).getProductID().equals(productID))
            {
                
                if(prolist.get(i).getQuantity()>quantity){
                    
                    prolist.get(i).setQuantity(quantity);
                    return true;
                }
            }
        }
        return false;
    }
}
