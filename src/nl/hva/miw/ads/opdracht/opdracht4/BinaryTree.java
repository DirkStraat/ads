package nl.hva.miw.ads.opdracht.opdracht4;

/**
 * Deze klasse is aangepast door Dirk van der Straaten, studentnummer 500837825
 */

import java.util.List;

public class BinaryTree <V extends Comparable>{
	
	TreeNode root;
	
	public BinaryTree() {
		super();
		root = null;
	}
	
	public BinaryTree(List<V> values) {
		super();
		for (V val: values) {
			insert(val);
		}
	}
	
	public void insert(V value) {
		if ( root == null ) {
			root = new TreeNode(value);
		} else {
			TreeNode node = root;
			TreeNode parent = null;
			while ( node != null && node.getValue() != value ) {
				parent = node;
				node = (value.compareTo(node.getValue())<0 ? node.getLeft() : node.getRight());
			}
			if ( parent != null && value.compareTo(parent.getValue())<0) {
				parent.setLeft(new TreeNode(value));
			} else if ( parent != null && value.compareTo(parent.getValue())>0 ) {
				parent.setRight(new TreeNode(value));
			}
		}
	}
	
	private void printTree(TreeNode node, int indent) {
		if ( node != null ) {
			printTree(node.getRight(), indent+1);
			for (int i=0; i<indent; i++) {
				System.out.print("\t");
			}
			System.out.println(node.getValue());
			printTree(node.getLeft(), indent+1);
		} else {
			for (int i=0; i<indent; i++) {
				System.out.print("\t");
			}
			System.out.println("*");
		}
	}
	
	public void printTree() {
		printTree(root, 0);
	}




	/**
	 * Returns the height of the tree.
	 * @return
	 */
	public int getHeight() {
		return getHeight(root);
	}

	public int getHeight(TreeNode node ) {
		if (node == null) {
			return 0;
		}

		int lh = getHeight(node.getLeft());
		int rh = getHeight(node.getRight());
		if (rh > lh) {
			return 1 + rh;
		} else {
			return 1 + lh;
		}
	}

	/**
	 * Print hier antwoord op de vraag van zoek efficientie.
	 */
	public void zoekBigO() {
		System.out.println("Mijn antwoord op vraag 4b) is: " +
				"In het slechtste geval kan deze boom een hoogte hebben van het aantal nodes en is de gemiddelde zoekefficientie O(n)." +
				"In dat geval moet je om een waarde te vinden elke knoop langslopen. Als de boom twee keer meer waarden heeft," +
				"wordt deze twee keer zo hoog en duurt zoeken twee keer zo lang. Dat is lineair met aantal waarden en daarom O(n)" +
				"In het beste geval is deze boom helemaal evenwichtig opgebouwd en is de zoekefficientie O(log(n))."+
				"Als het aantal waarden verdubbelt en de boom is evenwichtig opgebouwd, dan wordt het aantal zoekstappen slechts 1 meer."+
				"Daarom is de zoekefficientie O(log(n)). ");
	}
}