package MakeTheStringGreat;

import java.util.Stack;

public class MakeTheStringGreat { // 100%|96% on leetcode
    public String makeGood(String s) {
        if (s.length() < 2) {
            return s;
        }

        StringBuilder sb = new StringBuilder(s);

        int pos = 0;
        while (pos < sb.length() - 1 && sb.length() >= 1) {
            char left = sb.charAt(pos);
            char right = sb.charAt(pos + 1);

            if (
                left - 32 == right
                || left + 32 == right
            ) {
                sb.deleteCharAt(pos + 1);
                sb.deleteCharAt(pos);

                if (pos > 0) {
                    pos--;
                }

                continue;
            }

            pos++;
        }

        return sb.toString();
    }
}
