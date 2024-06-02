package de.unistuttgart.dsass2024.ex05.p2;

public class PrefixTree implements IPrefixTree {

    PrefixTreeNode root;

    public PrefixTree() {
        this.root = new PrefixTreeNode();

    }

    public PrefixTreeNode getRoot() {
        return root;
    }

    @Override
    public void insert(String word) {
        if (word == null || word.isEmpty()) {                         // if the word is null or empty, we don't need to insert anything
            return;
        }
        insertRecursive(root, word);
    }

    private void insertRecursive(PrefixTreeNode node, String word) {
        if (word.isEmpty()) {                                          // if the word is empty, we are done
            return;
        }

        if(node.getChild(word.charAt(0)) == null){                     // if the child doesnt exist yet with the first character of the word:
            PrefixTreeNode newNode = new PrefixTreeNode();             // create a new child
            newNode.setPrefix(node.getPrefix() + word.charAt(0));      // set the prefix of the new child
            node.setChild(word.charAt(0), newNode);                    // set the child to the parent
            insertRecursive(newNode, word.substring(1));      // continue with the next character
        } else if (node.getChild(word.charAt(0)) != null) {             // if the child already exists:
            insertRecursive((PrefixTreeNode) node.getChild(word.charAt(0)), word.substring(1)); // continue with the next character
        }
    }

    @Override
    public int size() {
        return sizeRecursive(root);
    }

    private int sizeRecursive(PrefixTreeNode node) {
        int count = 0;
        if (!node.getPrefix().isEmpty()) { // If the current node represents a complete word, count+1
            count++;
        }
        for (char label : node.getLabels()) {                             // iterate over all the children
            count += sizeRecursive((PrefixTreeNode) node.getChild(label)); // count the children
        }
        return count;
    }

}