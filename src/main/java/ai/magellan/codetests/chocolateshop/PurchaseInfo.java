package ai.magellan.codetests.chocolateshop;

/**
 * A skeletal class that just encapsulates the arguments to the OldChocolateShop
 * 
 * 
 *
 */
public class PurchaseInfo {
	
	public enum CandyTypes {
		
		MILK, DARK, SUGAR_FREE, WHITE
		
	};
	
	public int PocketCash;  	//The amount of money to be spent
	public int Price;			//The price per transaction
	public int WrappersNeeded;	//The number of items that must be purchased for a free one
	public CandyTypes Type;     //The type of candy
	
	/**
	 * Constructor supporting the original candy shop
	 * @param pocketCash
	 * @param price
	 * @param wrappersNeeded
	 */
	public PurchaseInfo( int pocketCash,  int price, int wrappersNeeded){
		
		PocketCash = pocketCash;
		Price = price;
		WrappersNeeded = wrappersNeeded;			
	}
	
	/**
	 * 
	 * Constructor supporting the new Candy shop with the types
	 * 
	 * @param pocketCash
	 * @param price
	 * @param wrappersNeeded
	 * @param type
	 */
	public PurchaseInfo( int pocketCash,  int price, int wrappersNeeded, CandyTypes type){
	
		PocketCash = pocketCash;
		Price = price;
		WrappersNeeded = wrappersNeeded;
		Type = type;
	}
}
