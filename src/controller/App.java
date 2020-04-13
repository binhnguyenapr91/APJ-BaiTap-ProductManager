package controller;

import java.io.IOException;
import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.Iterator;

import dao.DAO;
import model.Product;
import model.ProductComparator;
import view.MainView;
import view.ProductView;

public class App {

	private static final int SAVE_DATA_CODE = 9;
	private static final int LOAD_DATA_CODE = 8;
	private static final int SORTING_BY_PRICE_CODE = 7;
	private static final int SEARCH_BY_NAME_CODE = 6;
	private static final int SEARCH_BY_ID_CODE = 5;
	private static final int DELETE_BY_ID_CODE = 4;
	private static final int EDIT_BY_ID_CODE = 3;
	private static final int ADD_PRODUCT_CODE = 2;
	private static final int DISPLAY_ALL_CODE = 1;
	private static final String INVALID_OPTION_STRING = "Invalid Option";
	private static final String DATA_FILE_PATH = "files\\productData.dat";
	private static final int EXIT_CODE = 0;
	private static final int INIT_VALUE = -1;

	private static ArrayList<Product> initData() {
		// Sample Data
		ArrayList<Product> productsList = new ArrayList<Product>();

		Product p1 = new Product(1, "Macbook Air 2020", "Apple", 500, "Laptop");
		Product p2 = new Product(2, "Dell Precision 7510", "Dell", 500, "Laptop");
		Product p3 = new Product(3, "Iphone", "Apple", 500, "Smartphone");
		Product p4 = new Product(4, "BPhone 4", "BKAV", 150, "Smartphone");
		Product p5 = new Product(5, "DareU AK47", "DareU", 5, "Mouse");

		productsList.add(p1);
		productsList.add(p2);
		productsList.add(p3);
		productsList.add(p4);
		productsList.add(p5);
		// -----------------------
		return productsList;
	}

	public static void main(String[] args) throws NumberFormatException, IOException {
		MainView mainView = new MainView();
		MainFunction mainFunction = new MainFunction();
		DAO dao = new DAO();
		ArrayList<Product> productsList = initData();
		int option = INIT_VALUE;

		while (option != EXIT_CODE) {
			option = mainView.mainMenu();
			switch (option) {
			case EXIT_CODE:
				System.exit(EXIT_CODE);
				break;
			case DISPLAY_ALL_CODE:
				mainView.displayAllProducts(productsList);
				break;
			case ADD_PRODUCT_CODE:
				productsList.add(mainView.createProductForm());
				break;
			case EDIT_BY_ID_CODE:
				mainFunction.updateProductById(productsList);
				break;
			case DELETE_BY_ID_CODE:
				mainFunction.deleteProductById(productsList);
				break;
			case SEARCH_BY_ID_CODE:
				mainFunction.searchProductByID(productsList);
				break;
			case SEARCH_BY_NAME_CODE:
				mainFunction.searchProductByName(productsList);
				break;
			case SORTING_BY_PRICE_CODE:
				mainFunction.sortProductIncreasePrice(productsList);
				break;
			case LOAD_DATA_CODE:
				productsList = dao.readFromFile(DATA_FILE_PATH);
				break;
			case SAVE_DATA_CODE:
				dao.writeToFile(productsList, DATA_FILE_PATH);
				break;
			default:
				System.out.println(INVALID_OPTION_STRING);
			}
		}
	}

}
