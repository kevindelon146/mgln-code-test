package ai.magellan.codetests.chocolateshop;

import junit.framework.Assert;
import junit.framework.TestCase;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

public class ChocolateShopAcceptanceTest extends TestCase {

    public void testChocolateShopAcceptance() {

        ChocolateShop shop = new ChocolateShop();
        List<PurchaseInfo> purchases = Arrays.asList(
                new PurchaseInfo(12, 2, 5, PurchaseInfo.CandyTypes.MILK),
                new PurchaseInfo(12, 4, 4, PurchaseInfo.CandyTypes.DARK),
                new PurchaseInfo(6, 2, 2, PurchaseInfo.CandyTypes.SUGAR_FREE),
                new PurchaseInfo(6, 2, 2, PurchaseInfo.CandyTypes.WHITE),
                new PurchaseInfo(8, 2, 2, PurchaseInfo.CandyTypes.WHITE)
        );

        List<HashMap<PurchaseInfo.CandyTypes, Integer>> res = shop.run(purchases);

        //Testing for this {SUGAR_FREE=1, DARK=0, MILK=6, WHITE=0}
        Assert.assertEquals(new Integer(6), res.get(0).get(PurchaseInfo.CandyTypes.MILK));
        Assert.assertEquals(new Integer(1), res.get(0).get(PurchaseInfo.CandyTypes.SUGAR_FREE));
        Assert.assertEquals(new Integer(0), res.get(0).get(PurchaseInfo.CandyTypes.DARK));
        Assert.assertEquals(new Integer(0), res.get(0).get(PurchaseInfo.CandyTypes.WHITE));

        //Testing for this {SUGAR_FREE=0, DARK=3, MILK=0, WHITE=0}
        Assert.assertEquals(new Integer(0), res.get(1).get(PurchaseInfo.CandyTypes.MILK));
        Assert.assertEquals(new Integer(0), res.get(1).get(PurchaseInfo.CandyTypes.SUGAR_FREE));
        Assert.assertEquals(new Integer(3), res.get(1).get(PurchaseInfo.CandyTypes.DARK));
        Assert.assertEquals(new Integer(0), res.get(1).get(PurchaseInfo.CandyTypes.WHITE));

        //Testing for this {SUGAR_FREE=5, DARK=3, MILK=0, WHITE=0}
        Assert.assertEquals(new Integer(0), res.get(2).get(PurchaseInfo.CandyTypes.MILK));
        Assert.assertEquals(new Integer(5), res.get(2).get(PurchaseInfo.CandyTypes.SUGAR_FREE));
        Assert.assertEquals(new Integer(3), res.get(2).get(PurchaseInfo.CandyTypes.DARK));
        Assert.assertEquals(new Integer(0), res.get(2).get(PurchaseInfo.CandyTypes.WHITE));

        //Testing for this {SUGAR_FREE=1, DARK=0, MILK=0, WHITE=3}
        Assert.assertEquals(new Integer(0), res.get(3).get(PurchaseInfo.CandyTypes.MILK));
        Assert.assertEquals(new Integer(1), res.get(3).get(PurchaseInfo.CandyTypes.SUGAR_FREE));
        Assert.assertEquals(new Integer(0), res.get(3).get(PurchaseInfo.CandyTypes.DARK));
        Assert.assertEquals(new Integer(3), res.get(3).get(PurchaseInfo.CandyTypes.WHITE));

        //Testing for this {SUGAR_FREE=3, DARK=1, MILK=0, WHITE=5}
        Assert.assertEquals(new Integer(0), res.get(4).get(PurchaseInfo.CandyTypes.MILK));
        Assert.assertEquals(new Integer(3), res.get(4).get(PurchaseInfo.CandyTypes.SUGAR_FREE));
        Assert.assertEquals(new Integer(1), res.get(4).get(PurchaseInfo.CandyTypes.DARK));
        Assert.assertEquals(new Integer(5), res.get(4).get(PurchaseInfo.CandyTypes.WHITE));
    }
}
