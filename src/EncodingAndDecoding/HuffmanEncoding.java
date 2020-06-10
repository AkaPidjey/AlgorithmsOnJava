package EncodingAndDecoding;

import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;
import java.util.Scanner;

/**
 * Title: HuffmanEncoding.
 * @Eng - Huffman Encoding.
 * @Rus - Задача на программирование: кодирование Хаффмана.
 * @author PJ
 * @since 10/06/2020
 * @version 1.0
 * @task По данной непустой строке s длины не более 10^4, состоящей из строчных букв латинского алфавита,
 * постройте оптимальный беспрефиксный код. В первой строке выведите количество различных букв k,
 * встречающихся в строке, и размер получившейся закодированной строки. В следующих k строках запишите коды букв
 * в формате "letter: code". В последней строке выведите закодированную строку.
 * Sample Input 1:
 * a
 * Sample Output 1:
 * 1 1
 * a: 0
 * 0
 * Sample Input 2:
 * abacabad
 * Sample Output 2:
 * 4 14
 * a: 0
 * b: 10
 * c: 110
 * d: 111
 * 01001100100111
 */

class HuffmanEncoding {

    class Node implements Comparable<Node> {
        final int sum;
        String code;

        void buildCode(String code) {
            this.code = code;
        }

        public Node(int sum) {
            this.sum = sum;
        }

        @Override
        public int compareTo(Node o) {
            return Integer.compare(sum, o.sum);
        }
    }

    class InternalNode extends Node {
        Node left;
        Node right;

        @Override
        void buildCode(String code) {
            super.buildCode(code);
            left.buildCode(code + "0");
            right.buildCode(code + "1");
        }

        public InternalNode(Node left, Node right) {
            super(left.sum + right.sum);
            this.left = left;
            this.right = right;

        }
    }

    class LeavesNode extends Node {
        char symbol;

        @Override
        void buildCode(String code) {
            super.buildCode(code);
            System.out.println(symbol + ": " + code);
        }

        public LeavesNode(char symbol, int count) {
            super(count);
            this.symbol = symbol;

        }
    }

    private void codeHaffman() {
        Scanner scannerInput = new Scanner(System.in);
        String strInput = scannerInput.next();
        Map<Character, Integer> countChar = new HashMap<>();
        for (int i = 0; i < strInput.length(); i++) {
            char c = strInput.charAt(i);
            if (countChar.containsKey(c)) {
                countChar.put(c, countChar.get(c) + 1);
            } else {
                countChar.put(c, 1);
            }
        }
        Map<Character, Node> mapNodes = new HashMap<>();
        PriorityQueue<Node> priorityQueue = new PriorityQueue<>();
        for (Map.Entry<Character, Integer> entry : countChar.entrySet()) {
            LeavesNode node = new LeavesNode(entry.getKey(), entry.getValue());
            mapNodes.put(entry.getKey(), node);
            priorityQueue.add(node);
        }
        int sum = 0;
        while (priorityQueue.size() > 1) {
            Node first = priorityQueue.poll();
            Node second = priorityQueue.poll();
            InternalNode node = new InternalNode(first, second);
            sum += node.sum;
            priorityQueue.add(node);
        }
        if (countChar.size() == 1) {
            sum = strInput.length();
        }
        System.out.println(countChar.size() + " " + sum);
        Node root = priorityQueue.poll();
        if (countChar.size() == 1) {
            root.buildCode("0");
        } else {
            root.buildCode("");
        }
        StringBuilder stringBuilder = new StringBuilder();
        for (int i = 0; i < strInput.length(); i++) {
            char c = strInput.charAt(i);
            stringBuilder.append(mapNodes.get(c).code);
        }
        System.out.println(stringBuilder.toString());

    }

    public static void main(String[] args) {
        new HuffmanEncoding().codeHaffman();
    }
}