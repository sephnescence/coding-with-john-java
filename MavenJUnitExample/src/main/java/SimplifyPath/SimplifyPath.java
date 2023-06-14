package SimplifyPath;

import java.util.Arrays;
import java.util.LinkedList;

public class SimplifyPath {
    LinkedList<Pair<Integer, Integer>> folders = new LinkedList<>();
    public String simplifyPath(String path) {
        // Right... there are two stacks - folders too, but folders is fifo :/

        char[] pathChars = path.toCharArray();
        Integer left = 0;
        Integer right = 0;

        // This is now essentially an explode
        for (char b : pathChars) {
            if (b == '/') {
                if (left.equals(right)) {
                    left++;
                    right++;
                    continue;
                }

                folders.addLast(new Pair<>(left, right));

                left = right + 1;
            }
            right++;
        }

        if (right > left) {
            folders.addLast(new Pair<>(left, right));
        }

        LinkedList<Pair<Integer,Integer>> finalFolders = new LinkedList<>();
        while (!folders.isEmpty()) {
            Pair<Integer,Integer> pair = folders.removeFirst();

            if (pair.right - pair.left == 1 && pathChars[pair.left] == '.') {
                continue;
            }

            if (
                pair.right - pair.left == 2
                && pathChars[pair.left] == '.'
                && pathChars[pair.left + 1] == '.')
            {
                if (!finalFolders.isEmpty()) {
                    finalFolders.removeLast();
                }

                continue;
            }

            finalFolders.addLast(pair);
        }

        StringBuilder sbFinalDir = new StringBuilder();
        while (!finalFolders.isEmpty()) {
            Pair<Integer,Integer> pair = finalFolders.removeFirst();
            for (int i = pair.left; i < pair.right; i++) {
                sbFinalDir.append(pathChars[i]);
            }

            sbFinalDir.append("/");
        }

        if (sbFinalDir.length() > 0) {
            sbFinalDir.deleteCharAt(sbFinalDir.length() - 1);
        }

        return '/' + sbFinalDir.toString();
    }
}


//StringBuilder sb = new StringBuilder();
//public String simplifyPath(String path) {
//    int folderDepth = 0;
//    int sbEnd = 0;
//
//    char[] pathChars = path.toCharArray();
//
//    char lastPathChar = '/';
//    for (int i = 1; i < pathChars.length; i++) {
//        char pathChar = pathChars[i];
//
//        if (pathChar == '/' && lastPathChar == '/') {
//            continue; // no-op
//        }
//
//        if (pathChar == '.' && lastPathChar == '.') { // Navigate up
//            sb.deleteCharAt(--sbEnd);
//
//            if (folderDepth > 0) {
//                sb.deleteCharAt(--sbEnd);
//            }
//
//            folderDepth--;
//            if (folderDepth < 0) {
//                folderDepth = 0;
//            }
//
//            if (sbEnd > 0) {
//                char lastChar = sb.charAt(sbEnd - 1);
//                while (lastChar != '/' && sbEnd > 0) {
//                    sb.deleteCharAt(--sbEnd);
//                    if (sbEnd > 0) {
//                        lastChar = sb.charAt(sbEnd - 1);
//                    }
//                }
//            }
//
//            lastPathChar = '/';
//            // Not sure how to handle an erroneous three periods
//
//            continue;
//        }
//
//        if (lastPathChar == '.' && pathChar == '/') {
//            sb.deleteCharAt(--sbEnd); // Essentially a no-op
//
//            continue;
//        }
//
//        lastPathChar = pathChar;
//
//        if (pathChar == '/') {
//            folderDepth++;
//        }
//
//        sb.append(pathChar);
//        sbEnd++;
//    }
//
//    if (sbEnd > 0 && sb.charAt(sbEnd - 1) == '/') {
//        sb.deleteCharAt(--sbEnd);
//    }
//
//    return '/' + sb.toString();
//}