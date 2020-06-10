package EncodingAndDecoding;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

/**
 * Title: HuffmanDecoding.
 * @Eng - HuffmanDecoding.
 * @Rus - Задача на программирование: декодирование Хаффмана.
 * @author PJ
 * @since 10/06/2020
 * @version 1.0
 * @task Восстановите строку по её коду и беспрефиксному коду символов.
 * В первой строке входного файла заданы два целых числа k и l через пробел — количество различных букв,
 * встречающихся в строке, и размер получившейся закодированной строки, соответственно. В следующих k строках
 * записаны коды букв в формате "letter: code". Ни один код не является префиксом другого.
 * Буквы могут быть перечислены в любом порядке. В качестве букв могут встречаться лишь строчные буквы латинского
 * алфавита; каждая из этих букв встречается в строке хотя бы один раз. Наконец, в последней строке записана
 * закодированная строка. Исходная строка и коды всех букв непусты. Заданный код таков, что закодированная
 * строка имеет минимальный возможный размер.
 * В первой строке выходного файла выведите строку s. Она должна состоять из строчных букв латинского алфавита.
 * Гарантируется, что длина правильного ответа не превосходит 10^4 символов.
 * Sample Input 1:
 * 1 1
 * a: 0
 * 0
 * Sample Output 1:
 * a
 * Sample Input 2:
 * 4 14
 * a: 0
 * b: 10
 * c: 110
 * d: 111
 * 01001100100111
 * Sample Output 2:
 * abacabad
 */

public class HuffmanDecoding {
    private void codeHuffman() {
        Scanner scannerInput = new Scanner(System.in);
        int sumStrings = scannerInput.nextInt();
        int lengthStrings = scannerInput.nextInt();
        Map<String, Character> map = new HashMap<>();
        for (int i = 0; i < sumStrings; i++) {
            String letter = scannerInput.next();
            char value = letter.charAt(0);
            String key = scannerInput.next();
            map.put(key, value);
        }
        String encodingString = scannerInput.next();
        char[] encodingChars = encodingString.toCharArray();
        String code = "";
        for (char element : encodingChars) {
            code += element;
            if (map.containsKey(code)) {
                System.out.print(map.get(code));
                code = "";
            }
        }
    }

    public static void main(String[] args) {
        long startTime = System.currentTimeMillis();
        new HuffmanDecoding().codeHuffman();
        long finishTime = System.currentTimeMillis();
        System.out.println("");
        System.out.println("Run Time: " + (finishTime - startTime) + " ms");
    }
}