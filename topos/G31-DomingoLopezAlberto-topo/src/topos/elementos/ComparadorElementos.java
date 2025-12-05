package topos.elementos;

import java.util.Comparator;

public class ComparadorElementos implements Comparator<Elemento>{
	
	@Override
	public int compare(Elemento e1, Elemento e2) {
		return e1.getPosicion().compareTo(e2.getPosicion());
	}
	
}
