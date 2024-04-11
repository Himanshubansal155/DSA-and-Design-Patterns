package recurrence.sequence_problems;

import java.util.ArrayList;

public class Permutation {
    public static void main(String[] args) {
        getPermutation("", "abcd");
        var res = getPermutationArrayList("", "abcd");
        System.out.println(res);
    }

    static void getPermutation(String p, String stream) {
        if (stream.isEmpty()) {
            System.out.println(p);
            return;
        }

        char ch = stream.charAt(0);
        for (int i = 0; i <= p.length(); i++) {
            getPermutation(p.substring(0, i) + ch + p.substring(i, p.length()), stream.substring(1));
        }
    }

    static ArrayList<String> getPermutationArrayList(String p, String stream) {
        if (stream.isEmpty()) {
            var list = new ArrayList<String>();
            list.add(p);
            return list;
        }

        var list = new ArrayList<String>();
        char ch = stream.charAt(0);
        for (int i = 0; i <= p.length(); i++) {
            list.addAll(
                    getPermutationArrayList(p.substring(0, i) + ch + p.substring(i, p.length()), stream.substring(1)));
        }
        return list;
    }
}
