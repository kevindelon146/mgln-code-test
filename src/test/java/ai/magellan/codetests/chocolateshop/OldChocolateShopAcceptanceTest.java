package ai.magellan.codetests.chocolateshop;

import java.util.Arrays;
import java.util.List;

import junit.framework.TestCase;

public class OldChocolateShopAcceptanceTest extends TestCase {
	
	public void testOldChocolateShopAcceptance(){
		
		OldChocolateShop shop = new OldChocolateShop();
		List<OldPurchaseInfo> purchases = Arrays.asList(
				new OldPurchaseInfo(10,2,5),
				new OldPurchaseInfo(12,4,4),
				new OldPurchaseInfo(6,2,2));
		
		assertTrue(Arrays.equals( new int[]{6,3,5}, shop.run(purchases)));
		
	}

}
