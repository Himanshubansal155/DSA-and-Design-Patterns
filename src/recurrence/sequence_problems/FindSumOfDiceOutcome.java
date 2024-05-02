package recurrence.sequence_problems;

import java.util.ArrayList;

public class FindSumOfDiceOutcome {
    public static void main(String[] args) {
        // Used to find a total of 4 from rolling dice again and again
        findSum("", 4);
        var res = findSumArrayList("", 4);
        System.out.println(res);
    }

    static void findSum(String processed, int sum) {
        if (sum == 0) {
            System.out.println(processed);
            return;
        }

        for (int i = 1; i <= sum; i++) {
            findSum(processed + i, sum - i);
        }
    }

    static ArrayList<String> findSumArrayList(String processed, int sum) {
        if (sum == 0) {
            ArrayList<String> list = new ArrayList<>();
            list.add(processed);
            return list;
        }
        ArrayList<String> list = new ArrayList<>();

        for (int i = 1; i <= sum; i++) {
            list.addAll(findSumArrayList(processed + i, sum - i));
        }
        return list;
    }
}
