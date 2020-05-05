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
        this.root = new Node(' ');
        Map<Character, Node> map = new HashMap<Character, Node>();
        map.put(' ', root);

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

        Node cinco = new Node('5');
        cinco.setParent(h);
        h.setLeft(cinco);
        map.put('5', cinco);

        Node quatro = new Node('4');
        quatro.setParent(h);
        h.setRight(quatro);
        map.put('4', quatro);

        Node v = new Node('v');
        v.setParent(s);
        s.setRight(v);
        map.put('v', v);

        Node tres = new Node('3');
        tres.setParent(v);
        v.setRight(tres);
        map.put('3', tres);

        Node u = new Node('u');
        u.setParent(i);
        i.setRight(u);
        map.put('u', u);

        Node f = new Node('f');
        f.setParent(i);
        i.setLeft(f);
        map.put('f', f);

        Node EmptyFLeft = new Node(' ');
        EmptyFLeft.setParent(f);
        f.setLeft(EmptyFLeft);
        map.put(' ', EmptyFLeft);

        Node EmptyFRight = new Node(' ');
        EmptyFRight.setParent(f);
        f.setRight(EmptyFRight);
        map.put(' ', EmptyFRight);

        Node EmptyU = new Node(' ');
        EmptyU.setParent(u);
        u.setRight(EmptyU);
        map.put(' ', EmptyU);

        Node EmptyULeft = new Node(' ');
        EmptyULeft.setParent(EmptyU);
        EmptyU.setRight(EmptyULeft);
        map.put(' ', EmptyULeft);

        Node dois = new Node('2');
        dois.setParent(EmptyU);
        EmptyU.setLeft(dois);
        map.put('2', dois);

        // Parte direita de E

        Node a = new Node('a');
        a.setParent(e);
        e.setRight(a);
        map.put('a',a);

        Node r = new Node('r');
        r.setParent(a);
        a.setLeft(r);
        map.put('r', r);

        Node l = new Node('l');
        l.setParent(r);
        r.setLeft(l);
        map.put('l', l);

        Node EmptyLLeft = new Node(' ');
        EmptyLLeft.setParent(l);
        l.setLeft(EmptyLLeft);
        map.put(' ', EmptyLLeft);

        Node EmptyLRight = new Node(' ');
        EmptyLRight.setParent(l);
        l.setRight(EmptyLRight);
        map.put(' ', EmptyLRight);

        Node EmptyR = new Node(' ');
        EmptyR.setParent(r);
        r.setRight(EmptyR);
        map.put(' ', EmptyR);

        Node SignalPlus = new Node('+');
        SignalPlus.setParent(EmptyR);
        EmptyR.setLeft(SignalPlus);
        map.put('+', SignalPlus);

        Node EmptyRRight = new Node(' ');
        EmptyRRight.setParent(EmptyR);
        EmptyR.setRight(EmptyRRight);
        map.put(' ', EmptyRRight);

        Node w = new Node('w');
        w.setParent(a);
        a.setRight(w);
        map.put('w', w);

        Node p = new Node('p');
        p.setParent(w);
        w.setLeft(p);
        map.put('p', p);

        Node EmptyPLeft = new Node(' ');
        EmptyPLeft.setParent(p);
        p.setLeft(EmptyPLeft);
        map.put(' ', EmptyPLeft);

        Node EmptyPRight = new Node(' ');
        EmptyPRight.setParent(p);
        p.setRight(EmptyPRight);
        map.put(' ', EmptyPRight);

        Node j = new Node('j');
        j.setParent(w);
        w.setRight(j);
        map.put('j', j);

        Node EmptyJLeft = new Node(' ');
        EmptyJLeft.setParent(j);
        j.setLeft(EmptyJLeft);
        map.put(' ', EmptyJLeft);

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
        m.setRight(g);
        map.put('g', g);




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


    // Este método deve permanecer como está.
    public String charToMorse(char c) {
        return charToMorse(map.get(c));
    }


    // Você deve mudar o recheio deste método,
    // de acordo com os requisitos do projeto.
    public LinkedList<String> getCodes() {
        return new LinkedList<>();
    }
}
