package Exer8;

import java.util.ArrayList;
import java.util.Collection;
import java.util.LinkedList;

public class Collentios_ex {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		Collection<molecule> hy = new LinkedList<molecule>();
		Collection<Helium> he = new ArrayList<>();

		hy.add(new Hydrogen("hy1",1,5));
		hy.add(new Hydrogen("hy2",2,4));
		hy.add(new Hydrogen("hy3",3,3));
		hy.add(new Hydrogen("hy4",4,2));
		hy.add(new Hydrogen("hy5",5,1));

		for(int i = 0; i<5 ;i++) {
			he.add(new Helium());
		}
	// Add form their code	
	}
}
