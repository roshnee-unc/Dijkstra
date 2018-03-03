package BST_A2;

public class BST_Node {
	String data;
	BST_Node left;
	BST_Node right;
	BST_Node parent;

	BST_Node(String data) {
		this.data = data;
		this.left = null;
		this.right = null;
		this.parent = null;
	}

	BST_Node() {
		this.data = null;
		this.left = null;
		this.right = null;
		this.parent = null;
	}

	// --- used for testing ----------------------------------------------
	//
	// leave these 3 methods in, as is

	public String getData() {
		return data;
	}

	public BST_Node getLeft() {
		return left;
	}

	public BST_Node getRight() {
		return right;
	}

	// --- end used for testing -------------------------------------------

	// --- fill in these methods ------------------------------------------
	//
	// at the moment, they are stubs returning false
	// or some appropriate "fake" value
	//
	// you make them work properly
	// add the meat of correct implementation logic to them

	// you MAY change the signatures if you wish...
	// make the take more or different parameters
	// have them return different types
	//
	// you may use recursive or iterative implementations

	public boolean hasRight() {
		if (right == null)
			return false;
		return true;
	}

	public boolean hasLeft() {
		if (left == null)
			return false;
		return true;
	}

	public boolean hasChild() {
		if (left == null && right == null)
			return false;
		return true;
	}

	public boolean containsNode(String s) {

		BST_Node current = this;

		if (current.getData().compareTo(s) == 0) {
			return true;
		}

		if (current.getData().compareTo(s) > 0 && current.getLeft() != null) {
			return current.getLeft().containsNode(s);
		} else if (current.getData().compareTo(s) < 0 && current.getRight() != null) {
			return current.getRight().containsNode(s);
		}
		return false;

	}

	public BST_Node getBSTNode(String s) {
		BST_Node current = this;

		BST_Node b = null;

		if (current.getData().compareTo(s) == 0) {
			return current;
		}

		if (current.getData().compareTo(s) > 0 && current.getLeft() != null) {
			b = current.getLeft().getBSTNode(s);
		} else if (current.getData().compareTo(s) < 0 && current.getRight() != null) {
			b = current.getRight().getBSTNode(s);
		}
		return b;
	}

	public boolean insertNode(String s) {
		if (this.hasLeft() == false) {
			if (this.getData().compareTo(s) > 0) {
				BST_Node ins = new BST_Node(s);
				this.left = ins;
				ins.parent = this;
				return true;
			}
		}

		if (this.hasRight() == false) {
			if (this.getData().compareTo(s) < 0) {
				BST_Node ins = new BST_Node(s);
				this.right = ins;
				ins.parent = this;
				return true;
			}
		}

		if (this.getData().compareTo(s) > 0) {
			return this.getLeft().insertNode(s);
		} else {
			return this.getRight().insertNode(s);
		}

	}


	public boolean removeNode(String s) {
		BST_Node b = this.getBSTNode(s);
		// if no children
		if (!b.hasChild()) {
			if (b.isLeftChild()) {
				b.parent.left = null;
			} else {
				b.parent.right = null;
			}
			return true;
		// if one child
		} else if ((b.hasRight() == true && b.hasLeft() == false) || (b.hasRight() == false && b.hasLeft() == true)) {
			if (b.hasLeft() && b.isRightChild()) {
				b.parent.right = b.left;
				b.left.parent = b.parent;
				return true;
			} else if (b.hasLeft() && b.isLeftChild()) {
				b.parent.left = b.left;
				b.left.parent = b.parent;
				return true;
			} else if (b.hasRight() && b.isRightChild()) {
				b.parent.right = b.right;
				b.right.parent = b.parent;
				return true;
			} else {
				b.parent.left = b.right;
				b.right.parent = b.parent;
				return true;
			}
		}
		// if two children
		else {
			b.setData(b.right.findMin().getData());
			b.right.removeNode(b.right.findMin().getData());
			return true;
		}

	}

	public BST_Node findMin() {
		if (this.hasLeft() == false)
			return this;
		else {
			return this.getLeft().findMin();
		}
	}

	public BST_Node findMax() {
		if (this.hasRight() == false)
			return this;
		else {
			return this.getRight().findMin();
		}
	}

	public int getHeight() {

		if (this.hasLeft() == false && this.hasRight() == false) {
			return 0;
		} else if (this.hasLeft() == false) {
			return 1 + this.getRight().getHeight();
		} else if (this.hasRight() == false) {
			return 1 + this.getLeft().getHeight();
		} else {
			return 1 + Math.max(this.getLeft().getHeight(), this.getRight().getHeight());
		}
	}

	public void setRight(BST_Node right) {
		this.right = right;
	}

	public void setLeft(BST_Node left) {
		this.left = left;
	}

	public void setParent(BST_Node parent) {
		this.parent = parent;
	}

	public void setData(String s) {
		this.data = s;
	}

	public boolean isLeftChild() {
		if (this.parent.left == this) {
			return true;
		} else {
			return false;
		}
	}

	public boolean isRightChild() {
		if (this.parent.right == this) {
			return true;
		} else {
			return false;
		}
	}

	// --- end fill in these methods --------------------------------------

	// --------------------------------------------------------------------
	// you may add any other methods you want to get the job done
	// --------------------------------------------------------------------

	public String toString() {
		return "Data: " + this.data + ", Left: " + ((this.left != null) ? left.data : "null") + ",Right: "
				+ ((this.right != null) ? right.data : "null");
	}
}