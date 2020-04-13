package dao;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;

import model.Product;

public class DAO {

	public void writeToFile(ArrayList<?> productsList, String path) throws IOException {
		ObjectOutputStream oos = null;

		try {
			oos = new ObjectOutputStream(new FileOutputStream(path));

			for (Object product : productsList) {
				oos.writeObject(product);
			}
			oos.flush();
			System.out.println("Save Successfull!");
		} catch (Exception e) {
			e.printStackTrace();
			System.out.println("Error!");
		} finally {
			oos.close();
		}

	}

	public ArrayList<Product> readFromFile(String path) throws IOException {
		ObjectInputStream ois = null;
		ArrayList<Product> productsList = new ArrayList<Product>();
		try {
			ois = new ObjectInputStream(new FileInputStream(path));
			Product product;
			while (true) {
				product = (Product) ois.readObject();
				productsList.add(product);
			}
		} catch (Exception e) {
			e.printStackTrace();
			System.out.println("Error!");
		} finally {
			ois.close();
		}
		return productsList;
	}

}
