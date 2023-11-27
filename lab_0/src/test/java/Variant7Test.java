import org.example.Variant7;

import org.testng.Assert;
import static org.testng.Assert.assertEquals;
import org.testng.annotations.Test;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;


public class Variant7Test {

    @Test
    public void testIntegerTask() {
        int[] result = Variant7.integerTask(45);
        assertEquals(result[0], 9);
        assertEquals(result[1], 20);
    }

    @Test(expectedExceptions = IllegalArgumentException.class)
    public void testIntegerTaskException() {
        Variant7.integerTask(9);
    }

    public void testBooleanTask() {
        boolean result = Variant7.booleanTask(10, 15, 20);
        Assert.assertTrue(result);
    }

    @Test
    public void testIfTask() {
        int result = Variant7.ifTask(5.0f, 3.0f);
        assertEquals(result, 2);
    }

    @Test
    public void testCaseTask() {
        float result = Variant7.caseTask(3, 1500);
        assertEquals(result, 1.5);
    }

    @Test(expectedExceptions = IllegalArgumentException.class)
    public void testCaseTaskException() {
        Variant7.caseTask(6, 1500);
    }

    @Test
    public void testForTask() {
        double result = Variant7.forTask(1, 5);
        assertEquals(result, 15.0);
    }

    @Test
    public void testWhileTask() {
        int result = Variant7.whileTask(10);
        assertEquals(result, 4);
    }

    @Test(expectedExceptions = IllegalArgumentException.class)
    public void testWhileTaskException() {
        Variant7.whileTask(-5);
    }

    @Test
    public void testMinMaxTask() {
        int[] result = Variant7.minMaxTask(4, new int[]{5, 8, 2, 10});
        assertEquals(result[0], 3);
        assertEquals(result[1], 2);
    }

    @Test(expectedExceptions = IllegalArgumentException.class)
    public void testMinMaxTaskException() {
        Variant7.minMaxTask(1, new int[]{5});
    }

    @Test
    public void testArrayTask() {
        ByteArrayOutputStream outContent = new ByteArrayOutputStream();
        System.setOut(new PrintStream(outContent));

        Variant7.arrayTask(3, new float[]{1.2f, 3.4f, 5.6f});

        assertEquals(outContent.toString().trim(), "5.6 3.4 1.2");
    }

    @Test(expectedExceptions = IllegalArgumentException.class)
    public void testArrayTaskException() {
        Variant7.arrayTask(0, new float[]{1.2f, 3.4f, 5.6f});
    }

    @Test
    public void testMatrixTask() {
        ByteArrayOutputStream outContent = new ByteArrayOutputStream();
        System.setOut(new PrintStream(outContent));

        Variant7.matrixTask(new int[][]{{1, 2, 3}, {4, 5, 6}, {7, 8, 9}}, 3, 3, 1);

        assertEquals(outContent.toString().trim(), "4 5 6");
    }

    @Test(expectedExceptions = IllegalArgumentException.class)
    public void testMatrixTaskException() {
        Variant7.matrixTask(new int[][]{{1, 2, 3}, {4, 5, 6}, {7, 8, 9}}, 3, 3, 5);
    }

}

