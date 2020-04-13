package model;
import java.util.Comparator;

public class ProductComparator implements Comparator<Product> {
	@Override
    public int compare(Product c1, Product c2) {
        if (c1.getPrice() > c2.getPrice()) return 1;
        else if (c1.getPrice() < c2.getPrice()) return -1;
        else return 0;
    }
}


