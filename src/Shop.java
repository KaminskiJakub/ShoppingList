import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.util.ArrayList;
import java.util.List;

public class Shop {

	private String path = "C:\\Users\\User\\eclipse-workspace\\ShoppingList\\FileShop.txt";
	private File file = new File(path);
	private List<Purchase> shoppingList = new ArrayList<>();

	public Shop() {

		loadPurchases();
	}

	private void loadPurchases() {
		List<String> grandmaList = new ArrayList<>();
		try {
			for (String s : Files.readAllLines(file.toPath())) {
				grandmaList.add(s);
			}
		} catch (IOException e) {
			e.printStackTrace();
		}

		for (String s : grandmaList) {

			String[] elements = s.split(":");

			int cost = Integer.parseInt(elements[1]);
			int howMany = Integer.parseInt(elements[2]);
			Purchase purchase = new Purchase(elements[0], cost, howMany);

			shoppingList.add(purchase);
		}
	}

	public int countFullPrice() {
		int sum = 0;
		for (Purchase purchase : shoppingList) {
			sum += purchase.getPrice() * purchase.getHowMany();
		}
		return sum;
	}

	public Purchase getMostAmountProduct() {
		Purchase max = shoppingList.get(0);
		for (Purchase purchase : shoppingList) {
			if (max.getHowMany() < purchase.getHowMany()) {
				max = purchase;
			}
		}
		return max;
	}

	public int getMaximumPrice() {
		int max = 0;
		for (Purchase purchase : shoppingList) {
			if (max < purchase.getPrice()) {
				max = purchase.getPrice();
			}
		}
		return max;
	}
}