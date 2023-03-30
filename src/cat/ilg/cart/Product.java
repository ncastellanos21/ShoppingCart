package cat.ilg.cart;

public class Product {
	
	private Category category;
	private String name;
	private String id;
	private float price;
	
	public Product(String id, Category category) {
		this.category = category;
		this.id = id;
	}
	
	public Category getCategory() {
		return category;
	}
	public void setCategory(Category category) {
		this.category = category;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public float getPrice() {
		return price;
	}
	public void setPrice(float price) {
		this.price = price;
	}
	@Override
    public String toString(){
        String separator = "|";
        return this.id + separator + this.name + separator +
            (new Float(this.price)).toString();
    }
	
	@Override
	public boolean equals(Object product) {
		if(!(product instanceof Product))
			return false;
		if(this == product)
			return true;
		if(this.id == ((Product)product).id)
			return true;
		return false;
	}
}
