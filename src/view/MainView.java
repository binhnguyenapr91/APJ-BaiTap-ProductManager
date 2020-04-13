package view;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Iterator;

import model.Product;

public class MainView {

	public Product createProductForm() throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		System.out.println("===ADD NEW PRODUCT===");
		System.out.print("1. Enter product id:");
		int id = Integer.parseInt(br.readLine());
		System.out.print("2. Enter product name:");
		String name = br.readLine();
		System.out.print("3. Enter product manufacturer:");
		String manufacturer = br.readLine();
		System.out.print("4. Enter product price:");
		double price = Double.parseDouble(br.readLine());
		System.out.print("5. Enter product information:");
		String information = br.readLine();

		Product newProduct = new Product(id, name, manufacturer, price, information);
		return newProduct;

	}

	public int mainMenu() throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int option;
		System.out.println("========== MAIN MENU ==========");
		System.out.println("1. Display products");
		System.out.println("2. Add new product");
		System.out.println("3. Edit product by ID");
		System.out.println("4. Delete product by ID");
		System.out.println("5. Search product info by ID");
		System.out.println("6. Search product info by Name");
		System.out.println("7. Display product sort by Price");
		System.out.println("8. Load products from database");
		System.out.println("9. Save products to database");
		System.out.println("================================");
		System.out.println("0. Quit");
		option = Integer.parseInt(br.readLine());
		return option;
	}

	public void displayAllProducts(ArrayList<Product> productList) {
		System.out.println("================DISPLAY ALL PRODUCTS======================================");
		System.out.printf("%-5s%-20s%-20s%-10s%-30s\n", "id", "name", "manufacturer", "price", "information");
		Iterator<Product> itr = productList.iterator();
		while (itr.hasNext()) {
			Product holder = itr.next();
			System.out.printf("%-5s%-20s%-20s%-10s%-30s\n", holder.getId(), holder.getName(), holder.getManufacturer(),
					holder.getPrice(), holder.getInformation());
		}
		System.out.println("===========================================================================");

	}

	public static int enterIDForm() throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int value;
		System.out.println("========== ENTER ID FORM ==========");
		System.out.print("Enter product id:");
		value = Integer.parseInt(br.readLine());
		return value;
	}

	public static String enterNameForm() throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String value;
		System.out.println("========== ENTER NAME FORM ==========");
		System.out.print("Enter product name:");
		value = br.readLine();
		return value;
	}
}
