package driver;

import shop.Product;
import shop.ProductDAO;

public class Ex1 {

	public static void main(String[] args) {
		ProductDAO dao = new ProductDAO();
		Product product = new Product(2, "샤프", "쓸만한 샤프", 4500, 50);
		dao.updateProduct(product);
		System.out.println("수정 완료");
	}

}
