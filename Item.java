

public class Item {
    private String itemNumber;
    private int count;
    
    public Item(String number, int count){
    	this.itemNumber = number;
    	this.count = count;
    }
    
    public String GetItemNumber(){
    	return this.itemNumber;
    }
    
    public int GetItemCount(){
    	return this.count;
    }
}
