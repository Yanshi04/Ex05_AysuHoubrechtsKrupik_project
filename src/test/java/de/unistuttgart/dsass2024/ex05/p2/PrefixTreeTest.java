package de.unistuttgart.dsass2024.ex05.p2;

import org.junit.Before;
import org.junit.Test;

import static junit.framework.TestCase.assertEquals;

public class PrefixTreeTest {

    IPrefixTree tree;
    IPrefixTree tree1;

    @Before
    public void setUp() {
        tree = new PrefixTree();
        tree1 = new PrefixTree();
        tree.insert("test1");
        tree.insert("test2");
        tree.insert("test34");
        tree.insert("blabla");

    }

    @Test
    public void testInsert() {
        IPrefixTreeNode node = tree.getRoot();

        System.out.println(node.getPrefix());
        node = node.getChild('t').getChild('e').getChild('s').getChild('t');
        assertEquals("test", node.getPrefix());

        assertEquals("test1", node.getChild('1').getPrefix());
        assertEquals("test2", node.getChild('2').getPrefix());
        assertEquals("test34", node.getChild('3').getChild('4').getPrefix());

    }

    @Test
    public void testSize() {
        assertEquals(14, tree.size());
        assertEquals(0, tree1.size());
    }

    @Test(expected = NullPointerException.class)
    public void testExceptions() {
        IPrefixTreeNode node = tree.getRoot();
        node = node.getChild('t').getChild('e').getChild('s').getChild('t').getChild('1').getChild('a');
        System.out.println(node.getPrefix());

        IPrefixTreeNode node3 = tree1.getRoot();
        node3 = node3.getChild('t');
        System.out.println(node3.getPrefix());
    }


}