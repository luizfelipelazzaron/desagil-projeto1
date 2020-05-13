/*
 * NÃO É PERMITIDO MODIFICAR NADA NESTE ARQUIVO,
 * EXCETO PELO CONSTRUTOR E OS MÉTODOS INDICADOS.
 */

package br.pro.hashi.ensino.desagil.projeto1;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.Queue;

@SuppressWarnings({"SuspiciousNameCombination", "unused"})
class Translator {
    private final Node root;
    @SuppressWarnings({"unused"})
    private HashMap<Character, Node> map;

    // Você deve mudar o recheio do construtor,
    // de acordo com os requisitos do projeto.
    public Translator() {
        this.root = new Node('#');

        this.map = new HashMap<>();

        // Parte esquerda de E
        Node e = new Node('e');
        e.setParent(root);
        root.setLeft(e);

        Node i = new Node('i');
        i.setParent(e);
        e.setLeft(i);

        Node s = new Node('s');
        s.setParent(i);
        i.setLeft(s);

        Node h = new Node('h');
        h.setParent(s);
        s.setLeft(h);

        Node NumberFive = new Node('5');
        NumberFive.setParent(h);
        h.setLeft(NumberFive);

        Node NumberFour = new Node('4');
        NumberFour.setParent(h);
        h.setRight(NumberFour);

        Node v = new Node('v');
        v.setParent(s);
        s.setRight(v);

        Node NumberThree = new Node('3');
        NumberThree.setParent(v);
        v.setRight(NumberThree);

        Node u = new Node('u');
        u.setParent(i);
        i.setRight(u);

        Node f = new Node('f');
        f.setParent(u);
        u.setLeft(f);

        Node EmptyURight = new Node(' ');
        EmptyURight.setParent(u);
        u.setRight(EmptyURight);

        Node NumberTwo = new Node('2');
        NumberTwo.setParent(EmptyURight);
        EmptyURight.setRight(NumberTwo);

        // Parte direita de E

        Node a = new Node('a');
        a.setParent(e);
        e.setRight(a);

        Node r = new Node('r');
        r.setParent(a);
        a.setLeft(r);

        Node l = new Node('l');
        l.setParent(r);
        r.setLeft(l);

        Node EmptyRRight = new Node(' ');
        EmptyRRight.setParent(r);
        r.setRight(EmptyRRight);

        Node SignalPlus = new Node('+');
        SignalPlus.setParent(EmptyRRight);
        EmptyRRight.setLeft(SignalPlus);

        Node w = new Node('w');
        w.setParent(a);
        a.setRight(w);

        Node p = new Node('p');
        p.setParent(w);
        w.setLeft(p);

        Node j = new Node('j');
        j.setParent(w);
        w.setRight(j);

        Node NumberOne = new Node('1');
        NumberOne.setParent(j);
        j.setRight(NumberOne);

        Node t = new Node('t');
        t.setParent(root);
        root.setRight(t);

        Node n = new Node('n');
        n.setParent(t);
        t.setLeft(n);

        Node d = new Node('d');
        d.setParent(n);
        n.setLeft(d);

        Node b = new Node('b');
        b.setParent(d);
        d.setLeft(b);

        Node NumberSix = new Node('6');
        NumberSix.setParent(b);
        b.setLeft(NumberSix);

        Node SignalEquals = new Node('=');
        SignalEquals.setParent(b);
        b.setRight(SignalEquals);

        Node x = new Node('x');
        x.setParent(d);
        d.setRight(x);

        Node SignalBar = new Node('/');
        SignalBar.setParent(x);
        x.setLeft(SignalBar);

        Node k = new Node('k');
        k.setParent(n);
        n.setRight(k);

        Node c = new Node('c');
        c.setParent(k);
        k.setLeft(c);

        Node y = new Node('y');
        y.setParent(k);
        k.setRight(y);

        Node m = new Node('m');
        m.setParent(t);
        t.setRight(m);

        Node g = new Node('g');
        g.setParent(m);
        m.setLeft(g);

        Node z = new Node('z');
        z.setParent(g);
        g.setLeft(z);

        Node NumberSeven = new Node('7');
        NumberSeven.setParent(z);
        z.setLeft(NumberSeven);

        Node q = new Node('q');
        q.setParent(g);
        g.setRight(q);

        Node o = new Node('o');
        o.setParent(m);
        m.setRight(o);

        Node EmptyOLeft = new Node(' ');
        EmptyOLeft.setParent(o);
        o.setLeft(EmptyOLeft);

        Node NumberEight = new Node('8');
        NumberEight.setParent(EmptyOLeft);
        EmptyOLeft.setLeft(NumberEight);

        Node EmptyORight = new Node(' ');
        EmptyORight.setParent(o);
        o.setRight(EmptyORight);

        Node NumberNine = new Node('9');
        NumberNine.setParent(EmptyORight);
        EmptyORight.setLeft(NumberNine);

        Node NumberZero = new Node('0');
        NumberZero.setParent(EmptyORight);
        EmptyORight.setRight(NumberZero);

        map.put('0', NumberZero);
        map.put('9', NumberNine);
        map.put('8', NumberEight);
        map.put('o', o);
        map.put('q', q);
        map.put('7', NumberSeven);
        map.put('z', z);
        map.put('g', g);
        map.put('m', m);
        map.put('y', y);
        map.put('c', c);
        map.put('k', k);
        map.put('x', x);
        map.put('6', NumberSix);
        map.put('b', b);
        map.put('d', d);
        map.put('n', n);
        map.put('t', t);
        map.put('1', NumberOne);
        map.put('j', j);
        map.put('p', p);
        map.put('w', w);
        map.put('l', l);
        map.put('r', r);
        map.put('a', a);
        map.put('2', NumberTwo);
        map.put('f', f);
        map.put('u', u);
        map.put('3', NumberThree);
        map.put('v', v);
        map.put('4', NumberFour);
        map.put('5', NumberFive);
        map.put('h', h);
        map.put('s', s);
        map.put('i', i);
        map.put('e', e);
        map.put('#', root);

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
                        return '1';
                    }
                }
                if (code.charAt(i) == '.') {
                    if (previousLevel.getLeft() != null) {
                        currentLevel = previousLevel.getLeft();
                    } else {
                        return '2';
                    }
                }
                previousLevel = currentLevel;
            }
//        Log.d( "myApp", Character.toString(previousLevel.getValue()) );
            return previousLevel.getValue();
        } else {
            return '#';
        }
    }

    // Você deve mudar o recheio deste método,
    // de acordo com os requisitos do projeto.
    @SuppressWarnings("SameReturnValue")
    private String charToMorse(Node node) {
        Node atual = node;
        StringBuilder devolve = new StringBuilder();


        while (atual != root) {
            if (atual.getParent().getLeft() == atual) {
                devolve.insert(0, '.');
            } else {
                devolve.insert(0, '-');
            }
            atual = atual.getParent();
        }
        // 'andando' o caminho de volta até o root
        return devolve.toString();
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

        Queue<Node> queue = new LinkedList<>();
        queue.add(this.root);

        while (!queue.isEmpty()) {
            Node node = queue.element();

            Node left = node.getLeft();
            Node right = node.getRight();

            if (left != null) {
                queue.add(left);
            }
            if (right != null) {
                queue.add(right);
            }
            queue.remove();

            if (node.getValue() != '+' && node.getValue() != '=' && node.getValue() != '/' && node.getValue() != ' ' && node.getValue() != '#') {

                morseCode.add(charToMorse(node));

            }
        }

        return morseCode;
    }


}
