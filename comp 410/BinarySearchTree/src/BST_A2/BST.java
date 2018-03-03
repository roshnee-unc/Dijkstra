package BST_A2;

public class BST implements BST_Interface {
    public BST_Node root;
    int size;

    public BST() {
        size = 0;
        root = new BST_Node();
    }

    @Override
    // used for testing, please leave as is
    public BST_Node getRoot() {
        return root;
    }

    @Override
    public boolean insert(String s) {
        if (this.contains(s)) {
            return false;
        }

        if (size == 0) {
            root = new BST_Node(s);
            size++;
            return true;
        } else {
            size++;
            return root.insertNode(s);
        }
    }

    @Override
    public boolean remove(String s) {
    	if (root == null)
            return false;
    	if (!root.containsNode(s)) {
    		return false;
    	}
    	
    	BST_Node b = getBSTNode(s);
    	//if only one node in tree
    	if (size == 1) {
    		root = null;
    		size = 0;
    		return true;
    	}
    	//removing leaf
    	else if (!b.hasChild()) {
    		if (b.parent.left == b) {
    			b.parent.left = null;
    		} else {
    			b.parent.right = null;
    		}
    		size--;
    		return true;
    	}
    	//removing root
    	else if (s.equals(root.getData()))  {
    		root.setData(root.right.findMin().getData());
    		root.right.removeNode(root.right.findMin().getData());
    		size--;
    		return true;
    	}
    	//removing regular ole node with children
    	else {
    		if (root.removeNode(s)) {
    			size--;
    			return true;
    		} else {
    			return false;
    		}
    	}
    }

    @Override
    public String findMin() {

        if (this.size() == 0)
            return null;

        String str;
        BST_Node current = root;
        while (current.hasLeft()) {
            current = current.getLeft();
        }

        str = current.getData();
        return str;
    }

    @Override
    public String findMax() {

        if (this.size() == 0)
            return null;

        String str;
        BST_Node current = root;

        while (current.hasRight()) {
            current = current.getRight();
        }
        str = current.getData();
        return str;
    }

    @Override
    public boolean empty() {
        return size == 0;
    }

    @Override
    public boolean contains(String s) {
        BST_Node current = root;

        if (size == 0)
            return false;

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
    	BST_Node current = root;
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

    @Override
    public int size() {
        return size;
    }

    @Override
    public int height() {
        if (size == 0 || root == null) {
            return -1;
        }

        if (root.hasLeft() == false && root.hasRight() == false) {
            return 0;
        } else if (root.hasRight() == false) {
            return 1 + root.getLeft().getHeight();
        } else if (root.hasLeft() == false) {
            return 1 + root.getRight().getHeight();
        } else {
            return 1 + Math.max(root.getLeft().getHeight(), root.getRight().getHeight());
        }
    }
}
