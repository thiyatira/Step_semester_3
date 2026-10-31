package data_structures.assigment_problems;

import java.util.ArrayDeque;
import java.util.Deque;

// Expands nested k[text] banner codes with a count stack and a text stack, no recursion.
public class BannerPrinter {

    public String expandBanner(String code) {
        if (code == null) {
            throw new IllegalArgumentException("code must not be null");
        }
        Deque<Integer> counts = new ArrayDeque<>();
        Deque<StringBuilder> texts = new ArrayDeque<>();
        StringBuilder current = new StringBuilder();
        int number = 0;

        for (char ch : code.toCharArray()) {
            if (Character.isDigit(ch)) {
                number = number * 10 + (ch - '0');
            } else if (ch == '[') {
                counts.push(number);
                texts.push(current);
                current = new StringBuilder();
                number = 0;
            } else if (ch == ']') {
                int times = counts.pop();
                StringBuilder outer = texts.pop();
                for (int i = 0; i < times; i++) {
                    outer.append(current);
                }
                current = outer;
            } else {
                current.append(ch);
            }
        }
        return current.toString();
    }
}
