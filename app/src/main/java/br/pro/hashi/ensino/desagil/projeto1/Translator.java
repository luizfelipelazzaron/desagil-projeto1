/*
 * NÃO É PERMITIDO MODIFICAR NADA NESTE ARQUIVO,
 * EXCETO PELO CONSTRUTOR E OS MÉTODOS INDICADOS.
 */

package br.pro.hashi.ensino.desagil.projeto1;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;
import java.util.Stack;

@SuppressWarnings({"SuspiciousNameCombination", "unused"})
class Translator {
    private final Node root;
    @SuppressWarnings({"MismatchedQueryAndUpdateOfCollection", "unused"})
    private HashMap<Character, Node> map;

    // Você deve mudar o recheio do construtor,
    // de acordo com os requisitos do projeto.
    public Translator() {
        this.root = new Node('#');

        //noinspection MismatchedQueryAndUpdateOfCollection
        Map<Character, Node> map = new HashMap<>();
        map.put('#', root);

        // Parte esquerda de E
        Node e = new Node('e');
        e.setParent(root);
        root.setLeft(e);
        map.put('e', e);

        Node i = new Node('i');
        i.setParent(e);
        e.setLeft(i);
        map.put('i', i);

        Node s = new Node('s');
        s.setParent(i);
        i.setLeft(s);
        map.put('s', s);

        Node h = new Node('h');
        h.setParent(s);
        s.setLeft(h);
        map.put('h', h);

        Node NumberFive = new Node('5');
        NumberFive.setParent(h);
        h.setLeft(NumberFive);
        map.put('5', NumberFive);

        Node NumberFour = new Node('4');
        NumberFour.setParent(h);
        h.setRight(NumberFour);
        map.put('4', NumberFour);

        Node v = new Node('v');
        v.setParent(s);
        s.setRight(v);
        map.put('v', v);

        Node NumberThree = new Node('3');
        NumberThree.setParent(v);
        v.setRight(NumberThree);
        map.put('3', NumberThree);

        Node u = new Node('u');
        u.setParent(i);
        i.setRight(u);
        map.put('u', u);

        Node f = new Node('f');
        f.setParent(u);
        u.setLeft(f);
        map.put('f', f);

        Node EmptyURight = new Node(' ');
        EmptyURight.setParent(u);
        u.setRight(EmptyURight);
        map.put(' ', EmptyURight);

        Node NumberTwo = new Node('2');
        NumberTwo.setParent(EmptyURight);
        EmptyURight.setRight(NumberTwo);
        map.put('2', NumberTwo);

        // Parte direita de E

        Node a = new Node('a');
        a.setParent(e);
        e.setRight(a);
        map.put('a', a);

        Node r = new Node('r');
        r.setParent(a);
        a.setLeft(r);
        map.put('r', r);

        Node l = new Node('l');
        l.setParent(r);
        r.setLeft(l);
        map.put('l', l);

        Node EmptyRRight = new Node(' ');
        EmptyRRight.setParent(r);
        r.setRight(EmptyRRight);
        map.put(' ', EmptyRRight);

        Node SignalPlus = new Node('+');
        SignalPlus.setParent(EmptyRRight);
        EmptyRRight.setLeft(SignalPlus);
        map.put('+', SignalPlus);

        Node w = new Node('w');
        w.setParent(a);
        a.setRight(w);
        map.put('w', w);

        Node p = new Node('p');
        p.setParent(w);
        w.setLeft(p);
        map.put('p', p);

        Node j = new Node('j');
        j.setParent(w);
        w.setRight(j);
        map.put('j', j);

        Node NumberOne = new Node('1');
        NumberOne.setParent(j);
        j.setRight(NumberOne);
        map.put('1', NumberOne);

        Node t = new Node('t');
        t.setParent(root);
        root.setRight(t);
        map.put('t', t);

        Node n = new Node('n');
        n.setParent(t);
        t.setLeft(n);
        map.put('n', n);

        Node d = new Node('d');
        d.setParent(n);
        n.setLeft(d);
        map.put('d', d);

        Node b = new Node('b');
        b.setParent(d);
        d.setLeft(b);
        map.put('b', b);

        Node NumberSix = new Node('6');
        NumberSix.setParent(b);
        b.setLeft(NumberSix);
        map.put('6', NumberSix);

        Node SignalEquals = new Node('=');
        SignalEquals.setParent(b);
        b.setRight(SignalEquals);
        map.put('=', SignalEquals);

        Node x = new Node('x');
        x.setParent(d);
        d.setRight(x);
        map.put('x', x);

        Node SignalBar = new Node('/');
        SignalBar.setParent(x);
        x.setLeft(SignalBar);
        map.put('/', SignalBar);

        Node k = new Node('k');
        k.setParent(n);
        n.setRight(k);
        map.put('k', k);

        Node c = new Node('c');
        c.setParent(k);
        k.setLeft(c);
        map.put('c', c);

        Node y = new Node('y');
        y.setParent(k);
        k.setRight(y);
        map.put('y', y);

        Node m = new Node('m');
        m.setParent(t);
        t.setRight(m);
        map.put('m', m);

        Node g = new Node('g');
        g.setParent(m);
        m.setLeft(g);
        map.put('g', g);

        Node z = new Node('z');
        z.setParent(g);
        g.setLeft(z);
        map.put('z', z);

        Node NumberSeven = new Node('7');
        NumberSeven.setParent(z);
        z.setLeft(NumberSeven);
        map.put('7', NumberSeven);

        Node q = new Node('q');
        q.setParent(g);
        g.setRight(q);
        map.put('q', q);

        Node o = new Node('o');
        o.setParent(m);
        m.setRight(o);
        map.put('o', o);

        Node EmptyOLeft = new Node(' ');
        EmptyOLeft.setParent(o);
        o.setLeft(EmptyOLeft);
        map.put(' ', EmptyOLeft);

        Node NumberEight = new Node('8');
        NumberEight.setParent(EmptyOLeft);
        EmptyOLeft.setLeft(NumberEight);
        map.put('8', NumberEight);

        Node EmptyORight = new Node(' ');
        EmptyORight.setParent(o);
        o.setRight(EmptyORight);
        map.put(' ', EmptyORight);

        Node NumberNine = new Node('9');
        NumberNine.setParent(EmptyORight);
        EmptyORight.setLeft(NumberNine);
        map.put('9', NumberNine);

        Node NumberZero = new Node('0');
        NumberZero.setParent(EmptyORight);
        EmptyORight.setRight(NumberZero);
        map.put('0', NumberZero);

    }

    // Você deve mudar o recheio deste método,
    // de acordo com os requisitos do projeto.
    public char morseToChar(String code) {
        if (code != null) {
            Node previousLevel = root;
            Node currentLevel = new Node(' ');
            String output;
            for (int i = 0; i < code.length(); i++) {
                if (code.charAt(i) == '-') {
                    if (previousLevel.getRight() != null) {
                        currentLevel = previousLevel.getRight();
                    } else {
                        return '#';
                    }
                }
                if (code.charAt(i) == '.') {
                    if (previousLevel.getLeft() != null) {
                        currentLevel = previousLevel.getLeft();
                    } else {
                        return '#';
                    }
                }
                previousLevel = currentLevel;
            }
//        Log.d( "myApp", Character.toString(previousLevel.getValue()) );
            return previousLevel.getValue();
        } else {
            return 'a';
        }
    }

    // Você deve mudar o recheio deste método,
    // de acordo com os requisitos do projeto.
    @SuppressWarnings("SameReturnValue")
    private String charToMorse(Node node){
        String devolve = "";
        char c = node.getValue();
        // node.getValue() is a char
        node = map.get(c);

        while (node != root){
            if (node.getParent().getRight().getValue() == node.getValue()){
                devolve = devolve.concat("-");
            } else if (node.getParent().getLeft().getValue() == node.getValue()){
                devolve = devolve.concat(".");
            }
            node = node.getParent();
        }
        // 'andando' o caminho de volta até o root
        String back = "";
        for (int i = devolve.length() - 1; i >= 0; i--) {
            back += devolve.charAt(i);
        }
        return back;
    }

    // map.get(c) é um node
    // Este método deve permanecer como está. Então ficará.
    public String charToMorse(char c) {
        return charToMorse(map.get(c));
    }

    // Você deve mudar o recheio deste método,
    // de acordo com os requisitos do projeto.
    public LinkedList<String> getCodes() {
        //noinspection unchecked
        LinkedList<String> morseCode = new LinkedList();
        //noinspection MismatchedQueryAndUpdateOfCollection
        Stack<Node> stack = new Stack<>();
        // criar pilha a partir da raiz
        stack.push(this.root);

        while (!stack.isEmpty()) {
            Node node = stack.peek();
            Node left = node.getLeft();
            Node right = node.getRight();
            if (left != null) {
                stack.push(left);
            }
            if (right != null) {
                stack.push(right);
            }
            // verifica o que está sobrando da árvore que montamos em relacao
            // ao que tem nos 26 elementos apresentados pelo Requisito 4 -> 26 letras + 10 numeros (0 a 9)
            if (node.getValue() != '+' && node.getValue() != '=' && node.getValue() != '/' && node.getValue() != ' ') {
                String newElement = charToMorse(node.getValue());
                morseCode.add(newElement);
            }
        }

        return morseCode;
    }


}
