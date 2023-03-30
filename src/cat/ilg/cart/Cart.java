package cat.ilg.cart;

import java.math.RoundingMode;
import java.text.DecimalFormat;
import java.util.HashSet;
import java.util.Set;
import java.util.TreeSet;

public class Cart implements ICart{
	
	//properties
	private final Set<Line<Product,Integer,Float>> lines;
    private float total = 0.0f;
    
    //Constructor
    public Cart() {
    	lines = new HashSet<>();
    }
    
    public Cart(Set<Line<Product,Integer,Float>> lines) {
    	this.lines = lines;
    }
        
    //needed getters
    public float getTotal() {
    	return total;
    }
    
    public void setTotal(float total) {
    	this.total = total;
    }
    
    public Set<Line<Product, Integer, Float>> getLines() {
    	return lines;
    }
    

    //Helper methods are private
    private boolean updateLine(Line<Product,Integer,Float> line){
        if(!lines.contains(line)) {
            return false;
        }
        
        for(Line<Product,Integer,Float> triplet : lines) {
        	if (triplet.equals(line)) {
        		//Update
	        	triplet.setT(line.getT()); //product Update
	        	triplet.setT1(triplet.getT1() + line.getT1()); //amount Update
	        	triplet.setT2(triplet.getT2() + line.getT2()); //price Update
        	}
        }
        // Iterating over the property lines
        // When line is found, update it        
                   
        return true;
    } 
      

	private boolean cartContains(Product product){
        // Iterating over hash set items 
        // using a foreach (enhanced for loop)
        for(Line<Product,Integer,Float> cline : lines){
            if(cline.getT().equals(product)){
                return true;
            }
        }
        return false;
    }

	private void updateTotal(Line<Product,Integer,Float> line){
        this.total = this.total + line.getT2();
        //update the property total after adding the new line
        //total keeps the total price of the cart
    }
    
    //Public methods are interface implementations
    /*
    * Add an amount of units of the specified product into the cart
    * 
    * @param  product  an instance of a product to be added to the cart
    * @param amount  the number of units of the specified product to be added
    * @return true if the product was successfully added, false otherwise
    */
    @Override
    public boolean addProduct(Product product, int amount){
    	
    	Line<Product,Integer,Float> line = new Line<>();
    	line.setT(product);
    	line.setT1(amount);
    	line.setT2((float)(product.getPrice()) * amount);
    	
    	boolean updated = false;
    	boolean added = false;
    	if(this.cartContains(product)) {
    		updated = updateLine(line);
    	} else {
    		added = lines.add(line);
    	}
    	
        this.updateTotal(line);
        return updated || added; //modify accordingly
        //Create a Triplet from parameters
        //id Cart contains the triplet, update the corresponding line
        //otherwise, add the line to the cart (to the Set)
    }
    /*
    * Add 1 single unit a the specified product into the cart
    * 
    * @param  product  an instance of a product to be added to the cart
    * @return true if the product was successfully added, false otherwise
    */
    @Override
    public boolean addProduct(Product product) {
        //implementation for adding only 1 unit of the product
    	this.addProduct(product, 1);
    	return true;
        //return this.addProduct(product, 1); //modify accordingly
    }
	
	@Override
    public void printCart(){
        if(lines instanceof HashSet) 
        	System.out.println("Lines is a HashSet");
        if(lines instanceof TreeSet)
        	System.out.println("Lines is a TreeSet");
        String separator = "\\|";
        System.out.printf("%6s - %25s | %8s | %8s | %14s\n", "ID", "Name", 
                            "Price", "Amount", "Total Price (€)");
        System.out.println("			--------------------------------------------------");
        for(Line<Product,Integer,Float> line: lines){
            //Position 0 contains ID Product as String
            //Position 1 contains product name as String
            //Position 2 contains product price (per unit) as String
            //Position 3 contains Integer (amount) as String
            //Position 4 contains Float (total price) as String
            String[] lineArr = line.toString().split(separator);
            
            System.out.format("%6s - %25s | %8s | %8s | %14s\n", lineArr[0], lineArr[1], 
                                 lineArr[2], lineArr[3], lineArr[4]);              
        }        
        DecimalFormat df = new DecimalFormat("#.##");
        df.setRoundingMode(RoundingMode.CEILING);
        System.out.format("%63s %8s€", "Total de la comanda:", df.format(this.total));
    }
}
