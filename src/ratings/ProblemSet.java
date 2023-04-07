package ratings;

import java.util.ArrayList;
import java.util.HashMap;

public class ProblemSet {


    public static double average(ArrayList<Double> numbers) {
        double sum = 0.0;
        int index = 0;
        if (numbers.size() > 1) {
            while (numbers.size() > index) {
                sum += numbers.get(index);
                index++;
            }
            return sum / numbers.size();
        }
            else if (numbers.size() == 1) {
                return numbers.get(index);
        }
            else {
                return 0.0;
        }
    }


    public static int sumOfDigits(int digit) {
        digit = Math.abs(digit);
        int sum = 0;
        while (digit > 0) {
            sum = sum + digit % 10;
            digit = digit / 10;
        }
        return sum;
    }


    public static String bestKey(HashMap<String, Integer> map) {
        int greatest = -1000000;
        String greatest_key = "";
        if (map.isEmpty()) {
            return "";
        } else {
            for (String key : map.keySet()) {
                int value = map.get(key);
                if (greatest < value) {
                    greatest = value;
                    greatest_key = key;
                }
            }
        }
        return greatest_key;
    }
}









    // TODO: Write a public static method named bestKey that takes a HashMap of String to Integer
    //       as a parameter and returns a key mapping to the largest Integer. Ties can be broken arbitrarily.
    //       If the HashMap is empty, return the empty String
    //
    // Examples
    // {"CSE": 100, "MTH": 90, "MGT": 10} returns "CSE"
    // {"cat": 5, "dog": 5, "fox": 4} can return either "cat" or "dog"
    // {} returns ""


