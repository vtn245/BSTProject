package binarySearchTree;

import student.TestCase;

/**
 * Test class for all public operations on a binary search tree.
 * using a tree of String objects.
 * 
 * @author VanHa Nguyen (vtn245)
 * 
 * @version 2022-04-25
 */
public class BinarySearchTreeTest extends TestCase {
    private Lab14BinarySearchTree<String> tree;

    /**
     * setUp method
     */
    public void setUp() {
        tree = new Lab14BinarySearchTree<String>();
    }


    /**
     * tester method for {@link BinarySearchTree#insert()}
     */
    public void testInsert() {
        tree.insert("apple");

        try {
            tree.insert("apple");
        }
        catch (DuplicateItemException exception) {
            assertNotNull(exception);
        }

    }


    /**
     * tester method for {@link BinarySearchTree#remove()}
     */
    public void testRemove() {
        tree.insert("apple");
        tree.remove("apple");
        tree.insert("leaf");
        tree.insert("bird");
        tree.insert("apple");
        tree.remove(tree.findMax());
        tree.remove(tree.findMin());
        tree.find("bird");

        tree.insert("a");
        tree.remove("a");

        tree.insert("ba");
        tree.remove("ba");
        tree.remove("bird");
        assertTrue(tree.isEmpty());

        tree = new Lab14BinarySearchTree<String>();
        tree.insert("apple");
        tree.insert("leaf");
        tree.insert("mango");
        tree.insert("banhbao");
        tree.insert("yao");
        tree.remove("apple");
        tree.remove(tree.findMin());
        assertFalse(tree.isEmpty());

        Exception exception = null;
        try {
            tree.remove("apple");
        }
        catch (Exception e) {
            exception = e;
        }
        assertTrue(exception instanceof ItemNotFoundException);
    }


    /**
     * tester method for {@link BinarySearchTree#findMin()}
     */
    public void testFindMin() {
        assertNull(tree.findMin());
        tree.insert("apple");
        tree.insert("apples");
        tree.insert("leaf");
        assertEquals("apple", tree.findMin());
        tree.remove("apple");
        assertEquals("apples", tree.findMin());
        tree.remove("apples");
        assertEquals("leaf", tree.findMin());
    }


    /**
     * tester method for {@link BinarySearchTree#findMax()}
     */
    public void testFindMax() {
        assertNull(tree.findMax());
        tree.insert("apple");
        tree.insert("apples");
        assertEquals("apples", tree.findMax());
        tree.remove("apples");
        assertEquals("apple", tree.findMax());
    }


    /**
     * tester method for {@link BinarySearchTree#find()}
     */
    public void testFind() {
        assertNull(tree.find("apple"));
        tree.insert("apples");
        tree.insert("apple");
        tree.insert("bird");
        assertEquals("apple", tree.find("apple"));
        assertEquals("bird", tree.find("bird"));
        assertEquals("apples", tree.find("apples"));
    }


    /**
     * tester method for {@link BinarySearchTree#makeEmpty()}
     */
    public void testMakeEmpty() {
        tree.insert("apple");
        tree.insert("leaf");
        tree.makeEmpty();
        assertNull(tree.find("apple"));
        assertNull(tree.find("leaf"));
    }


    /**
     * tester method for {@link BinarySearchTree#isEmpty()}
     */
    public void testIsEmpty() {
        assertTrue(tree.isEmpty());
        tree.insert("apple");
        assertFalse(tree.isEmpty());
    }


    /**
     * tester method for {@link BinarySearchTree#toString()}
     */
    public void testToString() {
        Lab14BinarySearchTree<String> tree2 =
            new Lab14BinarySearchTree<String>();
        tree.insert("apple");
        tree.insert("leaf");
        tree.insert("bird");
        assertEquals("(apple, bird, leaf)", tree.toString());
        assertEquals("()", tree2.toString());
    }
}
