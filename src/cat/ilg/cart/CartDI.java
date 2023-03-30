package cat.ilg.cart;

import java.util.Set;

public class CartDI extends Cart{
	
	public CartDI(Set<Line<Product,Integer,Float>> lines) {
		super (lines);
	}

}
