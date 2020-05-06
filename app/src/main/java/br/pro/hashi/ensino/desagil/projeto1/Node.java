/*
 * NÃO É PERMITIDO MODIFICAR NADA NESTE ARQUIVO.
 */

package br.pro.hashi.ensino.desagil.projeto1;
public class Node {
    private char value;
    private Node parent;
    private Node left;
    private Node right;

    public Node(char value) {
        this.value = value;
        this.parent = null;
        this.left = null;
        this.right = null;
    }

    public char getValue() {
        return value;
    }

    public Node getParent() {
        return parent;
    }

    public void setParent(Node parent) {
        this.parent = parent;
    }

    public Node getLeft() {
        return left;
    }

    public void setLeft(Node left) {
        this.left = left;
    }

    public Node getRight() {
        return right;
    }

    public void setRight(Node right) {
        this.right = right;
    }
}
