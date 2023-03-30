package cat.ilg.main;

import cat.ilg.cart.Cart;
import cat.ilg.cart.Category;
import cat.ilg.cart.ICart;
import cat.ilg.cart.Product;

public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		ICart cart = fillCart(new Cart());
		
		cart.printCart();
	}
		
	private static ICart fillCart(ICart cart){
		
		Product p1 = new Product("p1", Category.COMPUTERS);
		p1.setName("Laptop");
		p1.setPrice(305.0f);

		Product p2 = new Product("p2", Category.FOOD);
		p2.setName("Banana");
		p2.setPrice(0.20f);

		Product p3 = new Product("p3", Category.BOOKS);
		p3.setName("Learn Java");
		p3.setPrice(33.9f);

		Product p4 = new Product("p4", Category.COMPUTERS);
		p4.setName("RAM 32Gb");
		p4.setPrice(110.6f);

		Product p5 = new Product("p5", Category.FOOD);
		p5.setName("Canneloni");
		p5.setPrice(7.0f);

		Product p6 = new Product("p6", Category.BOOKS);
		p6.setName("Data Science made easy");
		p6.setPrice(39.5f);

		
	    cart.addProduct(p2); //Afegim una unitat del producte p2
	    cart.addProduct(p2,6); //Afegim 6 unitats del producte p2
	    cart.addProduct(p2,10); //Afegim 10 unitats del producte p2
	    cart.addProduct(p4,2); //Afegim 2 unitats del producte p4
	    cart.addProduct(p1); //Afegim una unitat del producte p1
	    cart.addProduct(p3,2); //Afegim 2 unitats del producte p3
	    cart.addProduct(p5,3); //Afegim 3 unitats del producte p5
	    cart.addProduct(p6); //Afegim una unitat del producte p6
	    cart.addProduct(p6); //Afegim una unitat del producte p6
	    
	    return cart;
	}

}
