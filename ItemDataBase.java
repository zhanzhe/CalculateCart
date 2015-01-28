

import java.util.ArrayList;

public class ItemDataBase {

	private ArrayList<Product> list;
	
	public ItemDataBase(){
		list = new ArrayList<Product>();
		
		list.add(new Product("ITEM000001","羽毛球",1.00f,1));
		list.add(new Product("ITEM000003","苹果",5.50f,1));
		list.add(new Product("ITEM000005","可口可乐",3.00f,1));
		list.add(new Product("ITEM000002","铅笔",1.00f,1));
	}
	
	public String GetNameByItemNumber(String itemId){
		int dbSize = list.size();
		for(int i=0; i<dbSize; i++){
			if(list.get(i).GetProductNumber().contentEquals(itemId))
				return list.get(i).GetName();
		}
		
		return null;
	}
	
	public float GetPriceByItemNumber(String itemId){
		int dbSize = list.size();
		for(int i=0; i<dbSize; i++){
			if(list.get(i).GetProductNumber().contentEquals(itemId))
				return list.get(i).GetPrice();
		}
		
		return -1;
	}
}
