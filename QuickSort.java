public class QuickSort {
    public static void main(String[] args) {
        int array[] = {8,2,5,3,9,4,7,6,1};
        quickSort(array,0,array.length-1);
        
        for (int i : array) {
            System.out.print(i + " ");
        }
    }

    // Quick Sort Algorithm
    private static void quickSort (int [] array,  int start, int end) {
        if (end <= start) {
            return;
        }
        int pivot = partition (array, start, end);
        quickSort(array, start, pivot - 1);
        quickSort(array, pivot + 1, end);
    }

    // Partitioning the array
    private static int partition (int [] array , int start , int end) {
        int pivot = array[end];
        int i = start -1 ;
        int j = start;

        for (; j <= end ; j++) {
            if (array[j] < pivot) {
                i++;
                int temp = array[i];
                array[i] = array[j];
                array[j] = temp;
            }
        }
        
        i++;
        int temp = array[i];
        array[i] = array[end];
        array[end] = temp;
        return i;
    }
}