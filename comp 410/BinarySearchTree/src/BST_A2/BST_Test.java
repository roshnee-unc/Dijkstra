package BST_A2;

import static org.junit.Assert.*;

import org.junit.Test;

public class BST_Test {

	@Test
	public void testFindMin() {
		try {
			BST tree = new BST();

			tree.insert("gg");
			tree.insert("dd");
			tree.insert("ss");
			tree.insert("ee");
			tree.insert("cc");
			tree.insert("zz");
			tree.insert("gg");
			tree.insert("bb");
			tree.insert("ff");
			tree.insert("aa");

			assertEquals("findMin returns wrong node", "aa", tree.findMin());
		} catch (Exception e) {
			fail("Exception thrown: " + e.getMessage());
		}
	}

	@Test
	public void testFindMax() {
		try {
			BST tree = new BST();

			tree.insert("gg");
			tree.insert("dd");
			tree.insert("ss");
			tree.insert("ee");
			tree.insert("cc");
			tree.insert("zz");
			tree.insert("gg");
			tree.insert("bb");
			tree.insert("ff");
			tree.insert("aa");

			assertEquals("findMax returns wrong node", "zz", tree.findMax());
		} catch (Exception e) {
			fail("Exception thrown: " + e.getMessage());
		}
	}

	@Test
	public void testContainsTrue() {
		try {
			BST tree = new BST();

			tree.insert("gg");
			tree.insert("dd");
			tree.insert("ss");
			tree.insert("ee");
			tree.insert("cc");
			tree.insert("zz");
			tree.insert("gg");
			tree.insert("bb");
			tree.insert("ff");
			tree.insert("aa");

			assertTrue("contains returns false", tree.contains("cc"));
		} catch (Exception e) {
			fail("Exception thrown: " + e.getMessage());
		}
	}

	@Test
	public void testContainsFalse() {
		try {
			BST tree = new BST();

			tree.insert("gg");
			tree.insert("dd");
			tree.insert("ss");
			tree.insert("ee");
			tree.insert("cc");
			tree.insert("zz");
			tree.insert("gg");
			tree.insert("bb");
			tree.insert("ff");
			tree.insert("aa");

			assertFalse("contains returns true", tree.contains("ad"));
		} catch (Exception e) {
			fail("Exception thrown: " + e.getMessage());
		}
	}

	@Test
	public void testEmptyTrue() {
		try {
			BST tree = new BST();

			assertTrue("empty returns false", tree.empty());
		} catch (Exception e) {
			fail("Exception thrown: " + e.getMessage());
		}
	}

	@Test
	public void testEmptyFalse() {
		try {
			BST tree = new BST();

			tree.insert("h");

			assertFalse("empty returns true", tree.empty());
		} catch (Exception e) {
			fail("Exception thrown: " + e.getMessage());
		}
	}

	@Test
	public void testHeightInsertOnly() {
		try {
			BST tree = new BST();

			tree.insert("a");
			tree.insert("d");
			tree.insert("s");
			tree.insert("e");
			tree.insert("c");
			tree.insert("g");
			tree.insert("b");
			tree.insert("f");

			assertEquals("height returned wrong height", 5, tree.height());
		} catch (Exception e) {
			fail("Exception thrown: " + e.getMessage());
		}
	}

	@Test
	public void testHeightRemoveLeaf() {
		try {
			BST tree = new BST();

			tree.insert("a");
			tree.insert("d");
			tree.insert("s");
			tree.insert("e");
			tree.insert("c");
			tree.insert("g");
			tree.insert("b");
			tree.insert("f");
			tree.remove("f");

			assertEquals("height returned wrong height", 4, tree.height());
		} catch (Exception e) {
			fail("Exception thrown: " + e.getMessage());
		}
	}

	@Test
	public void testHeightRemoveOneChild() {
		try {
			BST tree = new BST();

			tree.insert("a");
			tree.insert("d");
			tree.insert("s");
			tree.insert("e");
			tree.insert("c");
			tree.insert("g");
			tree.insert("b");
			tree.insert("f");
			tree.remove("g");

			assertEquals("height returned wrong height", 4, tree.height());
		} catch (Exception e) {
			fail("Exception thrown: " + e.getMessage());
		}
	}

	@Test
	public void testHeightRemoveTwoChildren() {
		try {
			BST tree = new BST();

			tree.insert("a");
			tree.insert("d");
			tree.insert("s");
			tree.insert("e");
			tree.insert("c");
			tree.insert("g");
			tree.insert("b");
			tree.insert("f");
			tree.remove("d");

			if (tree.root.right.data.equals("c")) {
				assertEquals("height returned wrong height", 5, tree.height());
			} else if (tree.root.right.data.equals("e")) {
				assertEquals("height returned wrong height", 4, tree.height());
			} else {
				throw new Exception("Remove two children didn't work properly."
						+ "\nExpected c if using left subtree findMax"
						+ "\nor expected e if using right subtree findMin"
						+ " but received: "
						+ tree.root.right.data);
			}
		} catch (Exception e) {
			fail("Exception thrown: " + e.getMessage());
		}
	}

	@Test
	public void testSizeInsertOnly() {
		try {
			BST tree = new BST();

			tree.insert("a");
			tree.insert("d");
			tree.insert("s");
			tree.insert("e");
			tree.insert("c");
			tree.insert("g");
			tree.insert("b");
			tree.insert("f");

			assertEquals("size returned wrong size", 8, tree.size());
		} catch (Exception e) {
			fail("Exception thrown: " + e.getMessage());
		}
	}

	@Test
	public void testSizeRemove() {
		try {
			BST tree = new BST();

			tree.insert("a");
			tree.insert("d");
			tree.insert("s");
			tree.insert("e");
			tree.insert("c");
			tree.insert("g");
			tree.insert("b");
			tree.insert("f");
			tree.remove("s");

			assertEquals("size returned wrong size", 7, tree.size());
		} catch (Exception e) {
			fail("Exception thrown: " + e.getMessage());
		}
	}

	@Test
	public void testInsert() {
		try {
			BST tree = new BST();

			assertTrue("insert returned false", tree.insert("a"));
			assertTrue("insert returned false", tree.insert("d"));
			assertTrue("insert returned false", tree.insert("c"));

			tree.insert("a");
			tree.insert("d");
			tree.insert("s");
			tree.insert("e");
			tree.insert("c");
			tree.insert("g");
			tree.insert("b");
			tree.insert("f");

			assertEquals("inserted wrong node into spot", "s", tree.root.right.right.getData());
			assertEquals("inserted wrong node into spot", "g", tree.root.right.right.left.right.getData());
			assertFalse("insert returned true", tree.insert("a"));
		} catch (Exception e) {
			fail("Exception thrown: " + e.getMessage());
		}
	}

	@Test
	public void testRemoveNoChildren() {
		try {
			BST tree = new BST();

			tree.insert("a");
			tree.insert("d");
			tree.insert("s");
			tree.insert("e");
			tree.insert("c");
			tree.insert("g");
			tree.insert("b");
			tree.insert("f");

			assertTrue("remove no children case returned false", tree.remove("f"));
			assertEquals("remove no children case didn't remove", null, tree.root.right.right.left.right.left);
			assertTrue("remove 1 child case returned false", tree.remove("e"));
			assertEquals("remove 1 child case didn't remove properly", "g", tree.root.right.right.left.getData());
		} catch (Exception e) {
			fail("Exception thrown: " + e.getMessage());
		}
	}

	@Test
	public void testRemoveOneChild() {
		try {
			BST tree = new BST();

			tree.insert("a");
			tree.insert("d");
			tree.insert("s");
			tree.insert("e");
			tree.insert("c");
			tree.insert("g");
			tree.insert("b");
			tree.insert("f");

			assertTrue("remove 1 child case returned false", tree.remove("e"));
			assertEquals("remove 1 child case didn't remove properly", "g", tree.root.right.right.left.getData());
		} catch (Exception e) {
			fail("Exception thrown: " + e.getMessage());
		}
	}

	@Test
	public void testRemoveTwoChildren() {
		try {
			BST tree = new BST();

			tree.insert("a");
			tree.insert("d");
			tree.insert("s");
			tree.insert("e");
			tree.insert("c");
			tree.insert("g");
			tree.insert("b");
			tree.insert("f");
			tree.insert("w");
			tree.insert("z");
			tree.insert("y");
			tree.insert("u");

			assertTrue("remove 2 children case returned false", tree.remove("s"));
			assertFalse("remove 2 children didn't remove properly", tree.contains("s"));
			assertTrue("remove 2 children didn't replace node properly"
					+ "\n expected g if using left subtree findMax"
					+ "\n or expected u if using right subtree findMin"
					+ "\n but received: " + tree.root.right.right,
					tree.root.right.right.data.equals("u")
					|| tree.root.right.right.data.equals("g"));
		} catch (Exception e) {
			fail("Exception thrown: " + e.getMessage());
		}
	}
}