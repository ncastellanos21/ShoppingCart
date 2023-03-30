package cat.ilg.main;

import java.util.HashSet;
import java.util.TreeSet;

import cat.ilg.cart.Cart;
import cat.ilg.cart.CartDI;
import cat.ilg.cart.Category;
import cat.ilg.cart.ICart;
import cat.ilg.cart.Product;

public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		ICart cart = fillCart(new CartDI(new TreeSet<>()));
		fillMore(cart);
		
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
	
	
	private static ICart fillMore(ICart cart){  
		
		Product p7 = new Product("p7", Category.COMPUTERS);
		p7.setName("Desktop");
		p7.setPrice(305.0f);

		Product p8 = new Product("p8", Category.FOOD);
		p8.setName("Peach");
		p8.setPrice(0.40f);

		Product p9 = new Product("p9", Category.BOOKS);
		p9.setName("Learn Advanced Java");
		p9.setPrice(33.9f);

		Product p10 = new Product("p10", Category.COMPUTERS);
		p10.setName("RAM 16Gb");
		p10.setPrice(60.2f);

		Product p11 = new Product("p11", Category.FOOD);
		p11.setName("Ravioli");
		p11.setPrice(3.4f);

		Product p12 = new Product("p12", Category.BOOKS);
		p12.setName("Data Science Masterclass");
		p12.setPrice(39.5f);
		
	    ICart cart2 = fillCart(cart);
	    cart2.addProduct(p7); //Afegim una unitat del producte p7
	    cart2.addProduct(p7,2); //Afegim dues unitats del producte p7
	    cart2.addProduct(p8,6); //Afegim 6 unitats del producte p8
	    cart2.addProduct(p9,2); //Afegim 2 unitats del producte p9
	    cart2.addProduct(p10); //Afegim una unitat del producte p10
	    cart2.addProduct(p11,2); //Afegim 2 unitats del producte p11
	    cart2.addProduct(p12,3); //Afegim 3 unitats del producte p12
	    return cart2;
	}

}
