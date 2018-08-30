package misc.sort;

@SuppressWarnings("WeakerAccess")
public class ArraySorter {

    public static void insertionSort(int[] array) {
        for (int i = 1; i < array.length; i++) {
            int j = 0, t = array[i];
            for (; j <= i; j++) {
                if (t <= array[j])
                    break;
            }
            backward(array, j, i);
            array[j] = t;
        }
    }

    protected static void backward(int[] array, int start, int end) {
        for (int i = end; i > start; i--) {
            array[i] = array[i - 1];
        }
    }

    public static void mergeSort(int[] array) {
        int[] result = new int[array.length];
        mergeSort(array, 0, array.length - 1, result);
    }

    private static void mergeSort(int[] array, int start, int end, int[] result) {
        if (end <= start)
            return;
        int middle = (end - start) / 2 + start;
        int start1 = start, start2 = middle + 1;
        mergeSort(array, start1, middle, result);
        mergeSort(array, start2, end, result);
        int i = start;
        while (start1 <= middle && start2 <= end) {
            result[i++] = array[start1] < array[start2] ? array[start1++] : array[start2++];
        }
        while (start1 <= middle) {
            result[i++] = array[start1++];
        }
        while (start2 <= end) {
            result[i++] = array[start2++];
        }
        for (int j = start; j <= end; j++) {
            array[j] = result[j];
        }
    }

    private static void swap(int[] array, int n, int m) {
        int t = array[n];
        array[n] = array[m];
        array[m] = t;
    }

    public static int[] topK(int[] array, int k) {
        int[] result = new int[k];
        buildHeap(array);
        for (int i = array.length - 1, j = 0; i > 0 && j < k; i--) {
            result[j++] = array[0];
            swap(array, 0, i);
            heapify(array, 0, i - 1);
        }
        return result;
    }

    public static void heapSort(int[] array) {
        buildHeap(array);
        for (int i = array.length - 1; i > 0; i--) {
            swap(array, 0, i);
            heapify(array, 0, i - 1);
        }
    }

    private static void buildHeap(int[] array) {
        for (int i = array.length - 1; i >= 0; i--) {
            heapify(array, i, array.length - 1);
        }
    }

    protected static void heapify(int[] array, int index, int len) {
        int left = index * 2 + 1;
        int right = left + 1;
        if (left > len) return;
        int max = left;
        if (right <= len && array[right] > array[left])
            max = right;
        if (array[max] > array[index]) {
            swap(array, max, index);
            heapify(array, max, len);
        }
    }

}
