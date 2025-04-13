package seller;
import java.util.*;

import ecomm.*;
public class Book extends Product{
    private String name,id;
    private float price;
    private int num;
    public void setVals(String s,String i,Float p,int n){
        this.name=s;
        this.price=p;
        this.num=n;
        this.id=i;
    }
    public void setQuantity(int q){
        num=num-q;
    }
    public String getName(){
        return name;
    }
    public int getQuantity(){
        return num;
    }
    public float getPrice(){
        return price;
    }
    public String getProductID(){
        return id;
    }
    public Globals.Category getCategory(){
        return Globals.Category.values()[1];
    }
}
