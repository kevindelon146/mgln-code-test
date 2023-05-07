package ai.magellan.codetests.chocolateshop;

import java.util.ArrayList;
import java.util.List;

public class OldChocolateShop {
	
	public int[] run(List<OldPurchaseInfo> inputs){
		
		List<Integer> results = new ArrayList<Integer>();
		for(OldPurchaseInfo each: inputs) {
			
			int totalPurchased = each.PocketCash/each.Price;
			int wrappers = totalPurchased;
			while (wrappers >= each.WrappersNeeded){
				totalPurchased +=1;
				wrappers -= each.WrappersNeeded -1;
			}
			results.add(totalPurchased);
						
		}
		return results.stream().mapToInt(i->i).toArray();
	}
}
