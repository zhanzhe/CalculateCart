

public class Product {
    String productNumber;
	String productName;
    int productCount;
    float price;
    boolean haveDiscount;
    int disCountNumber;
    
    public Product(String number, String name, float price, int count){
    	this.productNumber = number;
    	this.productName = name;
    	this.price = price;
    	this.productCount = count;
    	this.haveDiscount = false;
    	this.disCountNumber = 0;
    }
    
    public Product(String number, int count){
    	this.productNumber = number;
    	this.productCount = count;
    	this.haveDiscount = false;
    	this.disCountNumber = 0;
    }
    
    
    public float CalculateMoney(){
    	return this.price * productCount;
    }
    
    public void SetCount(int count){
    	this.productCount = count;
    }
    
    public float GetPrice(){
    	return this.price;
    }
    
    public String GetProductNumber(){
    	return this.productNumber;
    }
    
    public int GetCount(){
    	return this.productCount;
    }
    
    public String GetName(){
    	return this.productName;
    }
    
    public void SetDiscount(int disCountNumber){
    	this.haveDiscount  = true;
    	this.disCountNumber = disCountNumber;
    }
}
