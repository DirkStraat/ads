package nl.hva.miw.ads.opdracht.opdracht4;

/**
 * Deze klasse is aangepast door Dirk van der Straaten, studentnummer 500837825.
 */

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class BinaryTreeLauncher {
	
	public BinaryTreeLauncher() {
		super();
	}
	
	public static void main(String[] args) {
		BinaryTreeLauncher m = new BinaryTreeLauncher();
		m.run();
	}
	
	private void run() {
		List<Integer> values = new ArrayList<Integer>();
		for (int i=0; i<10; i++) {
			values.add(i);
		}
		Collections.shuffle(values);
		BinaryTree tree = new BinaryTree(values);
		tree.printTree();
		
		System.out.println();
		System.out.println("Hoogte van deze boom is " + tree.getHeight());


		tree.zoekBigO();
	}
}
