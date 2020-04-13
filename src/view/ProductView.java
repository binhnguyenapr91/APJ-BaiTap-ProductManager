package view;

public class ProductView {
	public void displayProductDetail(int id, String name, String manufacturer, double price, String information) {
		System.out.printf("%-5s%-20s%-20s%-10s%-30s\n", "id", "name", "manufacturer", "price", "information");
		System.out.printf("%-5s%-20s%-20s%-10s%-30s\n", id, name, manufacturer, price, information);
	}
}
