

public class Promotion {
    String []productIdList;
    float savedMoney;
    int freeCount;
    int DISCOUNT_LEVEL = 2;
    int DEDUCTIONCOUNT = 1;
    float totalMoney;
    
    public Promotion(String[] itemId){
    	this.productIdList = itemId;
    }
    
    public void SetDisCount(Product product){
    	
    	for(int i = 0;i<productIdList.length; i++){
	    	if(product.GetProductNumber().contentEquals(productIdList[i])){
	    		if(product.productCount >= DISCOUNT_LEVEL){
	    			product.SetDiscount(DEDUCTIONCOUNT);
	    		}
	    	}
    	}
    }
    
    public float CalculateMoneyWithDiscount(Product product){
    	float money = 0;
    	if(product.haveDiscount){
    		money = product.CalculateMoney() - product.GetPrice()*DEDUCTIONCOUNT;
			savedMoney += product.GetPrice()*DEDUCTIONCOUNT;
			totalMoney += money;
    	}else{
    		 money = product.CalculateMoney();
    		 totalMoney += money;  	
    	}
    	
    	return money;
    }
    
    public float GetSavedMoney(){
    	return this.savedMoney;
    }
    
    public float GetTotalMoney(){
    	return this.totalMoney;
    }
    
    public int GetFreeCount(){
    	return this.freeCount;
    }
}
