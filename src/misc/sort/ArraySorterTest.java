package misc.sort;

import misc.FisherYatesShuffle;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.util.Arrays;

public class ArraySorterTest {

    private int[] array;
    private int[] expected;

    @Before
    public void setup() {
        array = new FisherYatesShuffle().shuffle(10);
        System.out.println("array : " + Arrays.toString(array));
        expected = array.clone();
        Arrays.sort(expected);
    }

    @Test
    public void testInsertionSort() {
        ArraySorter.insertionSort(array);
        assertEquals(array);
    }

    @Test
    public void testMergeSort() {
        ArraySorter.mergeSort(array);
        System.out.println(Arrays.toString(array));
        assertEquals(array);
    }

    @Test
    public void testHeapSort() {
        ArraySorter.heapSort(array);
        System.out.println(Arrays.toString(array));
        assertEquals(array);
    }

    private void assertEquals(int[] array) {
        Assert.assertArrayEquals(expected, array);
    }

    @Test
    public void heapify() {
        ArraySorter.heapify(array, 0, array.length - 1);
        System.out.println(Arrays.toString(array));
    }

    @Test
    public void topK() {
        for (int i = 1; i <= array.length; i++) {
            System.out.println(Arrays.toString(ArraySorter.topK(array, i)));
        }
    }
}
