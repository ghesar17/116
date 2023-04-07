package tests;

import org.junit.Test;
import ratings.ProblemSet;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;

import static org.junit.Assert.assertTrue;

public class TestProblemSet {

    private final double EPSILON = 0.001;

    public void compareDoubles(double d1, double d2) {
        assertTrue(Math.abs(d1 - d2) < EPSILON);
    }

    @Test
    public void testAverage() {

        ArrayList<Double> numbers = new ArrayList<>(Arrays.asList(1.0,2.0,3.0));
        compareDoubles(ProblemSet.average(numbers), 2.0);

        ArrayList<Double> testvalues = new ArrayList<>();
        testvalues.add(6.5);
        testvalues.add(6.5);
        testvalues.add(8.5);
        testvalues.add(8.5);
        compareDoubles(ProblemSet.average(testvalues), 7.5);

        ArrayList<Double> singleton = new ArrayList<>();
        singleton.add(6.5);
        compareDoubles(ProblemSet.average(singleton), 6.5);


    }

    @Test
    public void testAverageNegative() {

        ArrayList<Double> values = new ArrayList<>();
        values.add(-5.0);
        values.add(5.0);
        compareDoubles(ProblemSet.average(values), 0.0);
    }

    @Test
    public void testAverageEdgeCase() {
        ArrayList<Double> nums = new ArrayList<>();
        compareDoubles(ProblemSet.average(nums), 0.0);
    }


    @Test
    public void testSumPositive() {
        assertTrue(ProblemSet.sumOfDigits(123) == 6);
        assertTrue(ProblemSet.sumOfDigits(57) == 12);
        assertTrue(ProblemSet.sumOfDigits(1) == 1);
        assertTrue(ProblemSet.sumOfDigits(12423) == 12);
        assertTrue(ProblemSet.sumOfDigits(99999) == 45);
    }

    @Test
    public void testSumNegative() {
        assertTrue(ProblemSet.sumOfDigits(-36) == 9);
        assertTrue(ProblemSet.sumOfDigits(-19) == 10);
        assertTrue(ProblemSet.sumOfDigits(-25) == 7);
        assertTrue(ProblemSet.sumOfDigits(-1524) == 12);
        assertTrue(ProblemSet.sumOfDigits(-1639124) == 26);
        assertTrue(ProblemSet.sumOfDigits(-2) == 2);
    }

    @Test
    public void testSumEdgeCase() {
        assertTrue(ProblemSet.sumOfDigits(0) == 0);
    }




    @Test
    public void testBestKeyCommon() {
        HashMap<String, Integer> map = new HashMap<>();
        map.put("CSE", 100);
        map.put("MTH", 90);
        map.put("MGT", 10);
        String str1 = ProblemSet.bestKey(map);
        String str2 = "CSE";
        assertTrue("CSE", str1.equals(str2));


        HashMap<String, Integer> asd = new HashMap<>();
        asd.put("qwerty", 1243234);
        asd.put("uiop", 232);
        asd.put("zxc", 1);
        String str5 = ProblemSet.bestKey(asd);
        String str6 = "qwerty";
        assertTrue("qwerty", str5.equals(str6));
    }


    @Test
    public void testBestKeyNegative() {
        HashMap<String, Integer> negative = new HashMap<>();
        negative.put("key1", -123);
        negative.put("key2", -9);
        negative.put("key3", -323);
        String str10 = ProblemSet.bestKey(negative);
        String str11 = "key2";
        assertTrue("key2", str10.equals(str11));
    }


    @Test
    public void testBestKeyEdgeCase() {
            HashMap<String, Integer> empty = new HashMap<>();
        String str7 = ProblemSet.bestKey(empty);
        String str8 = "";
        assertTrue("",str7.equals(str8));
    }


}

