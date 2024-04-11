package recurrence.sequence_problems;

import java.util.ArrayList;

public class PhoneNumberCombinations {
    public static void main(String[] args) {
        // Used to find alphabets for phone number characters
        phoneNumber("", "12");
        var list = phoneNumberArrayList("", "12");
        System.out.println(list);
    }

    static void phoneNumber(String p, String str) {
        if (str.isEmpty()) {
            System.out.println(p);
            return;
        }
        int digit = str.charAt(0) - '0';
        int start = (digit - 1) * 3;
        for (int i = start; i <= start + 2; i++) {
            char ch = (char) ('a' + i);
            phoneNumber(p + ch, str.substring(1));
        }
    }

    static ArrayList<String> phoneNumberArrayList(String p, String str) {
        if (str.isEmpty()) {
            System.out.println(p);
            var list = new ArrayList<String>();
            list.add(p);
            return list;
        }
        var list = new ArrayList<String>();
        int digit = str.charAt(0) - '0';
        int start = (digit - 1) * 3;
        for (int i = start; i <= start + 2; i++) {
            char ch = (char) ('a' + i);
            list.addAll(phoneNumberArrayList(p + ch, str.substring(1)));
        }
        return list;
    }
}
