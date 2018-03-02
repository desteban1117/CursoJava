package collections;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class Main {

	public static void main(String[] args) {
		
		List<String> lista = new ArrayList<>();		
		lista.add("1");
		lista.add("2");
		lista.add("3");
		lista.add("4");
		//valor repetido
		lista.add("3");
		imprimir(lista);
		
		Set<String> sets = new HashSet<>();
		sets.add("1");
		sets.add("2");
		sets.add("3");
		sets.add("4");
		//valor repetido
		sets.add("3");
		imprimir(sets);
		
		Map<String, String> maps = new HashMap<>();
		maps.put("1", "Juan");
		maps.put("2", "david");
		maps.put("3", "carlos");
		maps.put("4", "andres");
		imprimir(maps.keySet());
		imprimir(maps.values());
	}
	
	public static void imprimir(Collection<String> collection) {
		
		for (Object c : collection) {
			System.out.print(c + ", ");
		}
		System.out.println("");
	}

}
