/*
 * NÃO É PERMITIDO MODIFICAR NADA NESTE ARQUIVO,
 * EXCETO PELO CONSTRUTOR E OS MÉTODOS INDICADOS.
 */

package br.pro.hashi.ensino.desagil.projeto1;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;

public class Translator {
    private Node root;
    private HashMap<Character, Node> map;

    // Você deve mudar o recheio do construtor,
    // de acordo com os requisitos do projeto.
    public Translator() {

        this.map.put('a', new Node('-'));
        this.root = new Node(' ');
        Node e = new Node('e');
        Node t = new Node('t');
        root.setLeft(e);
        root.setRight(t);
        e.setParent(root);
        t.setParent(root);

        this.root.getLeft().setLeft(new Node('i'));
        this.root.getLeft().setRight(new Node('a'));
        this.root.getRight().setLeft(new Node('n'));
        this.root.getRight().setRight(new Node('m'));
        this.root.getLeft().getLeft().setLeft(new Node('s'));
        this.root.getLeft().getLeft().setRight(new Node('u'));
        this.root.getLeft().getRight().setLeft(new Node('r'));
        this.root.getLeft().getRight().setRight(new Node('w'));
        this.root.getRight().getLeft().setLeft(new Node('d'));
        this.root.getRight().getLeft().setRight(new Node('k'));
        this.root.getRight().getRight().setLeft(new Node('g'));
        this.root.getRight().getRight().setRight(new Node('o'));
        this.root.getLeft().getLeft().getLeft().setLeft(new Node('h'));
        this.root.getLeft().getLeft().getLeft().setRight(new Node('v'));
        this.root.getLeft().getLeft().getRight().setLeft(new Node('f'));
        this.root.getLeft().getRight().getLeft().setLeft(new Node('l'));
        this.root.getLeft().getRight().getRight().setLeft(new Node('p'));
        this.root.getLeft().getRight().getRight().setRight(new Node('j'));
        this.root.getRight().getLeft().getLeft().setLeft(new Node('b'));
        this.root.getRight().getLeft().getLeft().setRight(new Node('x'));
        this.root.getRight().getLeft().getRight().setLeft(new Node('c'));
        this.root.getRight().getLeft().getRight().setRight(new Node('y'));
        this.root.getRight().getRight().getLeft().setLeft(new Node('z'));
        this.root.getRight().getRight().getLeft().setRight(new Node('q'));
        this.root.getLeft().getLeft().getLeft().getLeft().setLeft(new Node('5'));
        this.root.getLeft().getLeft().getLeft().getLeft().setRight(new Node('4'));
        this.root.getLeft().getLeft().getLeft().getRight().setRight(new Node('3'));
        this.root.getLeft().getLeft().getRight().getRight().setRight(new Node('2'));
        this.root.getLeft().getRight().getRight().getRight().setRight(new Node('1'));
        this.root.getRight().getLeft().getLeft().getLeft().setLeft(new Node('6'));
        this.root.getRight().getRight().getLeft().getLeft().setLeft(new Node('7'));
        this.root.getRight().getRight().getRight().getLeft().setLeft(new Node('8'));
        this.root.getRight().getRight().getRight().getRight().setLeft(new Node('9'));
        this.root.getRight().getRight().getRight().getRight().setRight(new Node('0'));
    }


    // Você deve mudar o recheio deste método,
    // de acordo com os requisitos do projeto.
    public char morseToChar(String code) {
        return ' ';
    }

    // Você deve mudar o recheio deste método,
    // de acordo com os requisitos do projeto.
    private String charToMorse(Node node) {
        return " ";
    }


    // Este método deve permanecer como está. Então ficará.
    public String charToMorse(char c) {
        return charToMorse(map.get(c));
    }

    // Você deve mudar o recheio deste método,
    // de acordo com os requisitos do projeto.
    public LinkedList<String> getCodes() {

        LinkedList<String> morseCode = new LinkedList();

        morseCode.add(".");
        morseCode.add("-");
        morseCode.add("..");
        morseCode.add(".-");
        morseCode.add("-.");
        morseCode.add("--");
        morseCode.add("...");
        morseCode.add("..-");
        morseCode.add(".-.");
        morseCode.add(".--");
        morseCode.add("-..");
        morseCode.add("-.-");
        morseCode.add("--.");
        morseCode.add("---");
        morseCode.add("....");
        morseCode.add("...-");
        morseCode.add("..-.");
        morseCode.add(".-..");
        morseCode.add(".--.");
        morseCode.add(".---");
        morseCode.add("-...");
        morseCode.add("-..-");
        morseCode.add("-.-.");
        morseCode.add("-.--");
        morseCode.add("--..");
        morseCode.add("--.-");
        morseCode.add(".....");
        morseCode.add("....-");
        morseCode.add("...--");
        morseCode.add("..---");
        morseCode.add(".----");
        morseCode.add("-....");
        morseCode.add("--...");
        morseCode.add("---..");
        morseCode.add("----.");
        morseCode.add("-----");

        return morseCode;
    }

    public static void main(String[] args) {
        Translator tree = new Translator();
        tree.getCodes();
    }

}
