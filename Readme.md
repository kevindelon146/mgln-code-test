Magellan Code Test
=================
Welcome to the alpha release of the Magellan code test. Since this is a brand new test, we expect there to be problems, 
mistakes and plenty of confusion. Please do not hesitate to ask questions and suggest improvements, 
by emailing rex@magellan.ai.
 
The test is an extension of a problem from HackerRank. You are given a small snippet of legacy code that solved the old
HackerRank problem. Now you have some new requirements that need to be implemented.

* Note: please do not share this test or your answer with anyone. The test and your solution is intended to be private
so please keep the repo private

Instructions
------------

### Language/Libraries
 - Both the Ruby test and the Java test are included.
    - Please only do one of them. Submitting both tests does not earn you any extra credit. In fact that 
    just means we have to grade 2 tests -- that's NOT twice as much fun.
    - Much of the language in this readme refers to the Ruby version, but it should translate pretty well for the Java
    folks. Again, if something is unclear, please ask. (Or learn Ruby!)
 - Do not use any outside gems/jars aside from what's already in the gemfile or pom.xml. 
 The bulk of the test should be plain Ruby/Java code.

### Submission
Keep it in the Github repo and let us know when you're done.
 
### Specs/Tests 
 - Add as many specs as you need, though they are optional. Any specs you do add should be in the "spec" or "test" folder
and run successfully by running the default `rake spec` task or `mvn test`.
    - If you do add any specs/tests, please submit them! We'd like to see them.
 - Do not change the signature of the ChocolateShop.new or ChocolateShop.run methods. Besides that, you can
 add as much code as you like, including, but not limited to: new classes, new test files and new methods on the 
 existing classes...pretty much anything is fair game. 
 - You can leave the old_chocolate_shop.rb. No need to touch that or the old_acceptance_test.rb. The spec should be passing.
Those are just there for demonstration purposes and so that you can make sure `rake spec` and everything is working.

### Grades
- Your code will be graded on
    - Correctness
    - Code quality metrics such as cleanliness, readability, maintainability and simplicity. Basically, 
    put out there what you would consider *good* code.
    - This is not a timed test, so you will not be graded on how quickly you turn around an answer. It is to take your
    time and focus on the above.
- We ARE NOT concerned about how fast the code performs. (It's a small chocolate shop!)

Original Problem
================
From [HackerRank](https://www.hackerrank.com/challenges/chocolate-feast)

Little Bob loves chocolates, and goes to the store with $:pocket_cash money in his pocket. The price of
each chocolate is $:price. The store offers a discount: for every :wrappers_needed wrappers
he gives the store, he’ll get one chocolate for free. How many chocolates does Bob get to eat?
Input Format
------------
An array of purchase hashes (count<=1000).

Output Format:
--------------
An array of # of chocolates eaten.

Constraints:
------------
2 <= :pocket_cash <= 100000
1 <= :price <= :pocket_cash
2 <= :wrappers_needed <= :pocket_cash 

Sample Case Explanation
-----------------------
See [ruby spec] (ruby/spec/old_acceptance_test_spec.rb)
or [java test] (java/src/test/java/ai/magellan/codetests/chocolateshop/OldChocolateShopAcceptanceTest.java)

1. In the first case, he can buy 5 chocolates with $10 and exchange the 5 wrappers to get
one more chocolate thus making the total number of chocolates he can eat as 6
2. In the second case, he can buy 3 chocolates for $12. However, it takes 4 wrappers
to get one more chocolate. He can’t avail the offer and hence the total number of chocolates remains 3.
3. In the third case, he can buy 3 chocolates for $6. Now he can give 2 of
these 3 wrappers and get 1 chocolate. Again, he can use his 1 unused wrapper and 1 wrapper of new chocolate to get
one more chocolate. Total is 5.

Solutions
---------
See [ruby solution] (ruby/code/old_chocolate_shop.rb) or 
[java solution] (java/src/main/java/ai/stride/codetests/chocolateshop/OldChocolateShop.java)

- Note that these solutions were found at random on the Internet. We are are not implying in any way whether these are
 *good or bad* solutions. Again, we just wanted something as a starting point.

New Problem
===========
The free chocolate program has been successful, and they've decided to tweak the promotion.

Chocolate Types
---------------
The store is now pushing certain types of chocolates (known as :type in the hash). There are
four types, :white, :dark, :milk and :sugar_free and the store
is giving away an extra sample of chocolates in addition to the original wrapper promotion.
For the original wrapper promotion, the free chocolates will be of the same
type that you are buying for that purchase. Note that if Bob accumulates enough wrappers of the other type,
he can trade those in as well.

- If you trade in wrappers for :milk or :white, you get an extra :sugar_free chocolate along with
every free :milk or :white chocolate that you would normally get.
- If you trade in wrappers for :sugar_free chocolate, you get an extra  :dark chocolate along
with every free :sugar_free chocolate that you get.
- Since :dark is all the rage, that is considered premium and there is no additional candy bonus.


Good Brother
-----------
Little Bob's sister Alice likes milk and white chocolate. For each purchase,
Bob sets the first milk or white chocolate he receives (still wrapped!) to give to her, then he eats the rest.

Output
------
Instead of an array of # of chocolates eaten, the output will now be an array of hashes. Each hash will have the four
types of chocolates and how much Little Bob eats of each of those types.
 
Explanation
-----------
See currently failing [ruby spec] (ruby/spec/acceptance_test_spec.rb) or 
[java test] (/java/src/test/java/ai/magellan/codetests/chocolateshop/ChocolateShopAcceptanceTest.java)

1. He buys 1 milk chocolate and sets it aside for Alice, still wrapped. He has enough money for 5 more. He trades in
those 5 wrappers and gets 1 more milk chocolate. He also gets one sugar_free.
2. No change from original problem. 
3. He can buy 3 sugar_free chocolates for $6. Now he can give 2 of this 3 wrappers and get 1 sugar_free
chocolate. Again, he can use his 1 unused wrapper and 1 wrapper of new chocolate to get one more chocolate. 
Total is 5 sugar free. Since he got 2 bonus sugar_free chocolates, he also gets 2 bonus dark chocolates. 
And since he got 2 dark chocolates, he can trade both of those in for an extra :dark.
4. He buys 1 white and sets it aside for Alice. He buys 2 more, and trades in those two
wrappers for 1 white and 1 sugar_free.
5. He buys 1 white and sets it aside for Alice. He buys 3 more, and trades in two
of those wrappers for 1 white and 1 sugar_free. He then trades in the 1 extra white wrapper 
with the one he had left to get another sugar_free and another white. 
Since he now has 2 sugar_free, he can trade them both in for a sugar_free and a dark.
