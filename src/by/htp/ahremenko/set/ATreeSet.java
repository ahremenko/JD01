package by.htp.ahremenko.set;

public class ATreeSet {
	
	public Node root;
	private int size;
	
	public void ATreeSet() {
		size = 0;
	}
	
	public int getSize() {
		return this.size;
	}
	
	public String toString() {
		StringBuilder sb = new StringBuilder();
		if (this.root == null) {
			sb.append("[ ] L: R: ");		
		} else {
			sb.append(this.root.toString());
		}	
		return sb.toString();
	}
	
	
	public Node add( Node parent, int k) {
		
		Node ret;
		// if parent is null - just create new Node and return it from recursive function
		if (parent == null) {
			ret = new Node(k);
			this.size++;
			if (root == null) {root = ret;}
			return ret;
		}
		
		// find out - left or right side of tree will be used
		if (k < parent.key) {
			parent.left = add (parent.left, k);
		} else if (k > parent.key) {
			parent.right = add (parent.right, k);
		}
		// if k = parent.key - skip adding
		return parent;
	}

	public String getAsString(Node parent, int k) {
		Node findedNode = null;
		findedNode =get(parent, k); 
		if (findedNode != null ) {
			return findedNode.toString();
		} else {
			return "Node [" + k + "] not found!";
		}			
	}
	
	public Node get(Node parent, int k) {
		
		if (parent == null ) {
			return null;
		}
		
		if (parent.key == k ) {
			return parent;
		}

		Node ret = null;
		// find out - left or right side of tree will be used
		if (k < parent.key) {
			ret = get (parent.left, k);
		} else if (k > parent.key) {
			ret = get (parent.right, k);
		}
		return ret;
	}
	
	class Node {
		public int key;
		public Node left;
		public Node right;
		
		public Node(int k) {
			this.key = k;
		}
		
		public String toString() {
			String ret = " ["+key+"] " + "{Left: " + (this.left==null ? "" : this.left.toString()) + "Right: " + (this.right == null ? "" : this.right.toString()) + "}";
			return ret;
		}
	}

}
