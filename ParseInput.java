

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;

public class ParseInput {

	private static ArrayList<String> GetInputStrList(){		
		String st;
		ArrayList<String> itemArray=new ArrayList<String>();

		BufferedReader br=new BufferedReader(new InputStreamReader(System.in)); 
		ProcessBeginningStr(br);
		itemArray = ProcessContentAndEndingStr(br);
			
		return itemArray;
	}
	
	private static void ProcessBeginningStr(BufferedReader br){
		try{
			String st = br.readLine(); 
			while(!st.contentEquals("[")){
				System.out.print("invalid input format!");
				st = br.readLine(); 
			}
		}catch(IOException exc){}
	}
	
	private static ArrayList<String> ProcessContentAndEndingStr(BufferedReader br){
		ArrayList<String> itemArray=new ArrayList<String>();
		
		try{
			String st = br.readLine(); 
			while(!st.contentEquals("]")){
				itemArray.add(st);
				st = br.readLine(); 	
			}
		}catch(IOException exc){}
		
		return itemArray;
	}
	public static HashMap<String, Integer> ParseInput(){
		ArrayList<String> strList = GetInputStrList();
		Iterator<String> it = strList.iterator();
		ArrayList<Item> itemList = new ArrayList<Item> ();
		HashMap<String, Integer> itemMap;
		while (it.hasNext()){
			String[] itemStr = it.next().toString().split("-");
			itemList.add(ItemMap(itemStr));
		}
		itemMap = Reduce(itemList);
		
		return itemMap;
	}

	private static Item ItemMap(String[] itemStr){
		Item item = null;
		
		if(itemStr.length == 1){
			item = new Item(itemStr[0].toString(),1);
		}
		else{
			item = new Item(itemStr[0].toString(),Integer.parseInt(itemStr[1].toString()));
		}	
		
		return item;
	}
	
	private static HashMap<String, Integer> Reduce(ArrayList<Item> itemList){
		HashMap<String, Integer> itemMap=     new     HashMap<String, Integer>();   
		
		for (Iterator<Item> it = itemList.iterator(); it.hasNext();) { 
			Item item = it.next();
            String itemNumber = item.GetItemNumber();
            int count = item.GetItemCount();
			if(itemMap.containsKey(itemNumber)){
			    itemMap.put(itemNumber, itemMap.get(itemNumber).intValue()+count);
			}else{
				itemMap.put(itemNumber, count);
			}
	    }
		return itemMap;
	}
	
}
