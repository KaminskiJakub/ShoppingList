
public class Main {

	 public static void main(String[] args) {
	
	Shop shop = new Shop();

	  System.out.println("The whole cost of Your purchase will be: " + shop.countFullPrice() + " zloty");
      System.out.println("The biggest price for an item is: " + shop.getMaximumPrice() + " zloty") ;
      System.out.println("Most popular product is: " + shop.getMostAmountProduct().getName() + " (amount: " + shop.getMostAmountProduct().getHowMany() + ")" );
	}

}
