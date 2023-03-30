package cat.ilg.cart;

import java.util.Objects;

public class Triplet<T, T1, T2> {
	
	private T t;
	private T1 t1;
	private T2 t2;
	
	
	
	public T getT() {
		return t;
	}

	public void setT(T t) {
		this.t = t;
	}

	public T1 getT1() {
		return t1;
	}

	public void setT1(T1 t1) {
		this.t1 = t1;
	}

	public T2 getT2() {
		return t2;
	}

	public void setT2(T2 t2) {
		this.t2 = t2;
	}

	@SuppressWarnings("unchecked")
	@Override
    public boolean equals(Object o) {

        if (o == this) return true;
        if (!(o instanceof Triplet)) {
            return false;
        }
        Triplet<T, T1, T2> triplet = (Triplet<T, T1, T2>) o;
        return Objects.equals(this.t, triplet.getT());
    }

    @Override
    public int hashCode() {
        return Objects.hash(this.t);
    }
    
    @Override
    public String toString(){
        String separator = "|";
        return t.toString() + separator + t1.toString() +
            separator + t2.toString();
    }

}
