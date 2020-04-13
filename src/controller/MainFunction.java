package controller;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.Iterator;

import model.Product;
import model.ProductComparator;
import view.MainView;
import view.ProductView;

public class MainFunction {
	public void searchProductByName(ArrayList<Product> productsList) throws IOException {
		Iterator<Product> itr;
		String nameValue = MainView.enterNameForm();
		itr = productsList.iterator();
		while (itr.hasNext()) {
			Product holder = itr.next();
			if (holder.getName().equalsIgnoreCase(nameValue)) {
				ProductView productView = new ProductView();
				ProductController productController = new ProductController(holder, productView);
				productController.updateProductView();
			}
		}
	}

	public void searchProductByID(ArrayList<Product> productsList) throws IOException {
		int idValue;
		Iterator<Product> itr;
		idValue = MainView.enterIDForm();
		itr = productsList.iterator();
		while (itr.hasNext()) {
			Product holder = itr.next();
			if (holder.getId() == idValue) {
				ProductView productView = new ProductView();
				ProductController productController = new ProductController(holder, productView);
				productController.updateProductView();
			}
		}
	}

	public void deleteProductById(ArrayList<Product> productsList) throws IOException {
		int idValue;
		Iterator<Product> itr;
		idValue = MainView.enterIDForm();
		itr = productsList.iterator();
		while (itr.hasNext()) {
			Product holder = itr.next();
			if (holder.getId() == idValue) {
				productsList.remove(holder);
				break;
			}
		}
	}

	public void updateProductById(ArrayList<Product> productsList) throws IOException {
		int idValue;
		Iterator<Product> itr;
		idValue = MainView.enterIDForm();
		itr = productsList.iterator();
		while (itr.hasNext()) {
			Product holder = itr.next();
			if (holder.getId() == idValue) {
				MainView mainView = new MainView();
				productsList.set(productsList.indexOf(holder), mainView.createProductForm());
				break;
			}
		}
	}

	public void sortProductIncreasePrice(ArrayList<Product> productsList) {
		Comparator comparator = new ProductComparator();
		MainView mainView = new MainView();
		Object[] array = productsList.toArray();
		Arrays.sort(array, comparator);
		ArrayList<Product> productsSortedList = new ArrayList<Product>();
		for (Object item : array) {
			productsSortedList.add((Product) item);
		}
		mainView.displayAllProducts(productsSortedList);
	}
}
