package driver;

import shop.Product;
import shop.ProductDAO;

public class Ex2 {

	public static void main(String[] args) {
		ProductDAO dao = new ProductDAO();
		Product product = dao.getProductById(2);
		System.out.println(product);
		
	}

}