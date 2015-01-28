

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;

public class Cart {

	ArrayList<Product> productList;
	HashMap<String, Integer> inputMap;
	ItemDataBase itemDB;
	Promotion myPromotion;
	String [] promotionIdList = {"ITEM000001","ITEM000005"};
	float savedMoney;
	
	public Cart(){
		productList = new ArrayList<Product> ();
		itemDB = new ItemDataBase();
		inputMap = ParseInput.ParseInput();		
		myPromotion = new Promotion(promotionIdList);
		
		ConvertMapToList();
		SetDiscount();
	}
	
	private void SetDiscount(){
		for(int i=0; i<productList.size(); i++){
			myPromotion.SetDisCount(productList.get(i));
		}
	}
	
	private void ConvertMapToList(){
		Set<Map.Entry<String, Integer>> set = inputMap.entrySet();       
		
		for (Iterator<Map.Entry<String, Integer>> it = set.iterator(); it.hasNext();) { 
			Map.Entry<String, Integer> entry = (Map.Entry<String, Integer>) it.next();  
			String itemId = entry.getKey();
			int count = entry.getValue();
			String name = itemDB.GetNameByItemNumber(itemId);
			float price = itemDB.GetPriceByItemNumber(itemId);
			
			productList.add(new Product(itemId, name,price,count));
    
	    }
	}
	
	public void PrintInventory(){
		System.out.println("***<没钱赚商店>购物清单***");
		PrintDetails();	
		System.out.println("-------------------------------");
		PrintSavedInfor();
		System.out.println("-------------------------------");
		PrintTotalInfo();
		System.out.println("-------------------------------");
	}
	
	private void PrintDetails(){
		for(Iterator<Product> it = productList.iterator(); it.hasNext();){
			Product product = it.next();

			System.out.println("名称: "+ product.GetName()+","+"数量: "+ product.GetCount()+","+"单价: "+product.GetPrice()+"(元)"+"小计: "+myPromotion.CalculateMoneyWithDiscount(product));
		}
	}
	private void PrintSavedInfor(){
		for(Iterator<Product> it = productList.iterator(); it.hasNext();){
			Product product = it.next();
			if(product.haveDiscount){
				System.out.println("名称: "+ product.GetName()+","+"数量: "+ product.disCountNumber);
			}
		}
	}
	
	private void PrintTotalInfo(){
		float totalMoney = myPromotion.GetTotalMoney();
		savedMoney = myPromotion.GetSavedMoney();
		
		System.out.println("总计: "+ totalMoney +"(元)");
		System.out.println("节省: "+ savedMoney + "(元)");
	}
	
}
