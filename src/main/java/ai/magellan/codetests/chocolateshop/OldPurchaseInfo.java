package ai.magellan.codetests.chocolateshop;

/**
 * A skeletal class that just encapsulates the arguments to the OldChocolateShop
 * 
 * 
 *
 */
public class OldPurchaseInfo {



	public int PocketCash;  	//The amount of money to be spent
	public int Price;			//The price per transaction
	public int WrappersNeeded;	//The number of items that must be purchased for a free one

	/**
	 * Constructor supporting the original candy shop
	 * @param pocketCash
	 * @param price
	 * @param wrappersNeeded
	 */
	public OldPurchaseInfo(int pocketCash, int price, int wrappersNeeded){

		PocketCash = pocketCash;
		Price = price;
		WrappersNeeded = wrappersNeeded;
	}


}
