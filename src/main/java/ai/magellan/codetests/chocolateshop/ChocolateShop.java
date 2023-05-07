package ai.magellan.codetests.chocolateshop;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;


public class ChocolateShop {

    public List<HashMap<PurchaseInfo.CandyTypes, Integer>> run(List<PurchaseInfo> inputs) {

        ArrayList<HashMap<PurchaseInfo.CandyTypes, Integer>> results = new ArrayList<HashMap<PurchaseInfo.CandyTypes, Integer>>();
        for (PurchaseInfo each : inputs) {

            int milkChocolates = 0, darkChocolates = 0, sugarFreeChocolates = 0, whiteChocolates = 0;  // Initially Number Of Chocolates For Each Type Will Be Zero
            int milkWrappers = 0, darkWrappers = 0, sugarFreeWrappers = 0, whiteWrappers = 0;          // Initially Number Of Wrappers For Each Type Will Be Zero

            switch (each.Type) {
                case MILK:
                    milkChocolates += (each.PocketCash-each.Price)/ each.Price; //Bob buy 1 MILK Chocolates and sets it aside for Alice
                    milkWrappers = milkChocolates;
                    break;
                case DARK:
                    darkChocolates = each.PocketCash / each.Price;
                    darkWrappers = darkChocolates;
                    break;
                case SUGAR_FREE:
                    sugarFreeChocolates = each.PocketCash / each.Price;
                    sugarFreeWrappers = sugarFreeChocolates;
                    break;
                case WHITE:
                    whiteChocolates += (each.PocketCash-each.Price) / each.Price; //Bob buy 1 WHITE Chocolates and sets it aside for Alice
                    whiteWrappers = whiteChocolates;
                    break;
            }

            while (milkWrappers >= each.WrappersNeeded || darkWrappers >= each.WrappersNeeded ||
                    sugarFreeWrappers >= each.WrappersNeeded || whiteWrappers >= each.WrappersNeeded) {
              if(milkWrappers >= each.WrappersNeeded){
                  milkChocolates += 1;
                  sugarFreeChocolates+=1;
                  sugarFreeWrappers+=1;
                  milkWrappers -= each.WrappersNeeded - 1;
              }else if(whiteWrappers >= each.WrappersNeeded){
                  whiteChocolates += 1;
                  sugarFreeChocolates+=1;
                  sugarFreeWrappers+=1;
                  whiteWrappers -= each.WrappersNeeded - 1;
              }else if(sugarFreeWrappers >= each.WrappersNeeded){
                  sugarFreeChocolates+=1;
                  darkChocolates+=1;
                  darkWrappers+=1;
                  sugarFreeWrappers -= each.WrappersNeeded - 1;
              }else if(darkWrappers >= each.WrappersNeeded){
                  darkChocolates+=1;
                  darkWrappers -= each.WrappersNeeded - 1;
              }
            }

            HashMap<PurchaseInfo.CandyTypes, Integer> purchaseMap = new HashMap<PurchaseInfo.CandyTypes, Integer>();
            purchaseMap.put(PurchaseInfo.CandyTypes.MILK, milkChocolates);
            purchaseMap.put(PurchaseInfo.CandyTypes.DARK, darkChocolates);
            purchaseMap.put(PurchaseInfo.CandyTypes.SUGAR_FREE, sugarFreeChocolates);
            purchaseMap.put(PurchaseInfo.CandyTypes.WHITE, whiteChocolates);
            results.add(purchaseMap);
        }
        return results;
    }
}
