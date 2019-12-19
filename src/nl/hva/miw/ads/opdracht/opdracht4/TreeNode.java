package nl.hva.miw.ads.opdracht.opdracht4;

/**
 * Deze klasse is aangepast door Dirk van der Straaten, studentnummer 500837825.
 * @param <V>
 */

public class TreeNode <V extends Comparable> {
	
	private V value;
	private TreeNode left;
	private TreeNode right;
	
	public TreeNode(V value, TreeNode left, TreeNode right) {
		super();
		this.value = value;
		this.left = left;
		this.right = right;
	}
	
	public TreeNode(V value) {
		this(value, null, null);
	}

	public V getValue() {
		return value;
	}

	public void setValue(V value) {
		this.value = value;
	}


	public TreeNode getLeft() {
		return left;
	}

	public void setLeft(TreeNode left) {
		this.left = left;
	}

	public TreeNode getRight() {
		return right;
	}

	public void setRight(TreeNode right) {
		this.right = right;
	}
}
