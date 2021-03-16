// ****************************************************************
// IntegerList.java
//
// Define an IntegerList class with methods to create, fill,
// sort, and search in a list of integers.
//
// ****************************************************************
public class IntegerList {
    int[] list; // values in the list
    // -------------------------------------------------------
    // create a list of the given size
    // -------------------------------------------------------

    public IntegerList(int size) {
        list = new int[size];
    }

    // -------------------------------------------------------
    // fill array with integers between 1 and 100, inclusive
    // -------------------------------------------------------
    public void randomize() {
        for (int i = 0; i < list.length; i++)
            list[i] = (int) (Math.random() * 100) + 1;
    }

    // -------------------------------------------------------
    // print array elements with indices
    // -------------------------------------------------------
    public void print() {
        for (int i = 0; i < list.length; i++)
            System.out.println(i + ":\t" + list[i]);
    }

    // -------------------------------------------------------
    // return the index of the first occurrence of target in the list.
    // return -1 if target does not appear in the list
    // -------------------------------------------------------
    public int search(int target) {
        int location = -1;
        for (int i = 0; i < list.length && location == -1; i++)
            if (list[i] == target)
                location = i;
        return location;
    }

    public int binarySearchD(int target) {
        int result = -1;
        int left = 0, right = this.list.length - 1;

        while ((left <= right) && (result == -1)) {
            int mid = (right + left) / 2;

            if (target == list[mid]) {
                result = mid;
            } else if (target < list[mid]) {
                left = mid + 1;
            } else if (target > list[mid]) {
                right = mid - 1;
            }
        }

        return result;
    }

    // -------------------------------------------------------
    // sort the list into ascending order using the selection sort algorithm
    // -------------------------------------------------------
    public void selectionSort() {
        int minIndex;
        for (int i = 0; i < list.length - 1; i++) {
            // find smallest element in list starting at location i
            minIndex = i;
            for (int j = i + 1; j < list.length; j++)
                if (list[j] < list[minIndex])
                    minIndex = j;
            // swap list[i] with smallest element
            int temp = list[i];

            list[i] = list[minIndex];
            list[minIndex] = temp;
        }
    }

    // -------------------------------------------------------
    // sort the list into descending order using the selection sort algorithm
    // -------------------------------------------------------
    public void sortDecreasing() {
        int maxIndex;
        for (int i = 0; i < list.length - 1; i++) {
            // find smallest element in list starting at location i
            maxIndex = i;
            for (int j = i + 1; j < list.length; j++)
                if (list[j] > list[maxIndex])
                    maxIndex = j;
            // swap list[i] with smallest element
            int temp = list[i];

            list[i] = list[maxIndex];
            list[maxIndex] = temp;
        }
    }

    // -------------------------------------------------------
    // replace first occurrence of oldVal to newVal
    // if oldVal not exist in the list, nothing happens
    // -------------------------------------------------------
    void replaceFirst(int oldVal, int newVal) {
        int index = search(oldVal);

        if (index != -1) {
           this.list[index] = newVal;
        }
    }

    void replaceAll(int oldVal, int newVal) {
        for (int i = 0; i < this.list.length; i++) {
            if (this.list[i] == oldVal) {
                this.list[i] = newVal;
            }
        }
    }
}
