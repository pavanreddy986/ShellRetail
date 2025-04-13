package ecomm;
import java.util.*;
public abstract class Product {
	public abstract void setVals(String s,String i,Float p,int n);
	// common queries to get category, unique name, price, and number available
	public abstract Globals.Category getCategory();
	public abstract String getName();
	public abstract String getProductID();
	public abstract float getPrice();
	public abstract int getQuantity();
	public abstract void setQuantity(int q);
}


