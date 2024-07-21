public class MergeSort {
    public static void main(String[] args) {
        int array[] = { 8, 2, 5, 9, 7, 1, 3, 6, 4 };

        mergeSort(array);

        for (int i : array) {
            System.out.print(i + " ");
        }
    }

    // Merge Sort Algorithm
    private static void mergeSort(int[] array) {
        int length = array.length;

        // base case
        // divide the array into two halves until the length is 1
        if (length <= 1) {
            return;
        }

        // mid point of the array
        int middle = length / 2;

        int[] leftArray = new int[middle];
        int[] rightArray = new int[length - middle];

        int i = 0; // index for left array
        int j = 0; // index for right array

        // copy the elements of original array into left and right arrays
        for (; i < length; i++) {
            if (i < middle) {
                leftArray[i] = array[i];
            } else {
                rightArray[j] = array[i];
                j++;
            }
        }
        mergeSort(leftArray);
        mergeSort(rightArray);
        merge(leftArray, rightArray, array);
    }

    // Merge the left and right arrays into the original array
    private static void merge(int[] leftArray, int[] rightArray, int[] array) {

        int leftArraySize = array.length / 2;
        int rightArraySize = array.length - leftArraySize;

        int i = 0; // keep track of index of original array
        int l = 0; // keep track of index of left array
        int r = 0; // keep track of index of right array

        // check the conditions for merging
        while (l < leftArraySize && r < rightArraySize) {
            if (leftArray[l] < rightArray[r]) {
                array[i] = leftArray[l];
                i++;
                l++;
            } else {
                array[i] = rightArray[r];
                i++;
                r++;
            }
        }

        // copy the remaining elements of left and right arrays
        while (l < leftArraySize) {
            array[i] = leftArray[l];
            i++;
            l++;
        }

        // copy the remaining elements of right array
        while (r < rightArraySize) {
            array[i] = rightArray[r];
            i++;
            r++;
        }
    }
}
