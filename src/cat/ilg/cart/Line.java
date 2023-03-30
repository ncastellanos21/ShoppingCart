package cat.ilg.cart;

public class Line<T,T1,T2> extends Triplet<T,T1,T2> implements Comparable{

	 @SuppressWarnings("unchecked")
	@Override
	    public int compareTo(Object line) {
	     /* 
	      * compareTo should return 
	      * < 0 if this(keyword) is supposed to be less than param object, 
	      * > 0 if this is supposed to be greater than object 
	      * and 0 if they are supposed to be equal
	      */
	        if (line == this) return 0;
	        if (!(line instanceof Line)) {
	            return -1;
	        }
	        Line<T,T1,T2> l = (Line<T,T1,T2>)line;
	        
	        int last = 0;
	        if(this.getT() instanceof Product && l.getT() instanceof Product){
	            
	            Product thisProduct = (Product)this.getT();
	            Product paramProduct = (Product)l.getT();
	            
	            if(thisProduct == paramProduct) return 0; //(**)
	            
	            //Ordenem per categoria
	            last = thisProduct.getCategory().name()	.compareTo(
	            		paramProduct.getCategory().name());
	            
	            //Ordenem per preu
	            if (last == 0) {
	            	if (thisProduct.getPrice() < paramProduct.getPrice())
	            		last = 1;
	            	else if (thisProduct.getPrice() == paramProduct.getPrice())
	            		last = 0;
	            	else
	            		last = 1;
	            }
	            
	            //Ordenem per nom
	            if (last == 0) {
	            	last = thisProduct.getName().compareTo(paramProduct.getName());
	            }
	            
	            //Ordenem per quantitat d'unitats de producte a la línia
	            if (last == 0) {
	            	if((int)(this.getT1()) < (int)(l.getT1()))
	            		last = 1;
	            	else if((int)(this.getT1()) == (int)(l.getT1()))
	            		last = 0;
	            	else
	            		last = -1;
	            }
	        }
	        return last;
	    }
}
