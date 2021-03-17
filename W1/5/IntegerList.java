
// ****************************************************************
// FILE: IntegerList.java
//
// Purpose: Define an IntegerList class with methods to create, fill,
// sort, and search in a list of integers.
//
// ****************************************************************
import java.util.Scanner;

public class IntegerList {
    int[] list; // values in the list
    // ------------------------------------------------------------
    // Constructor -- takes an integer and creates a list of that
    // size. All elements default to value 0.
    // ------------------------------------------------------------

    public IntegerList(int size) {
        list = new int[size];
    }

    // ------------------------------------------------------------
    // randomize -- fills the array with randomly generated integers
    // between 1 and 100, inclusive
    // ------------------------------------------------------------
    public void randomize() {
        int max = list.length;
        for (int i = 0; i < list.length; i++)
            list[i] = (int) (Math.random() * max) + 1;
    }

    // ------------------------------------------------------------
    // fillSorted -- fills the array with sorted values
    // ------------------------------------------------------------
    public void fillSorted() {
        for (int i = 0; i < list.length; i++)
            list[i] = i + 2;
    }

    // ------------------------------------------------------------
    // print -- prints array elements with indices, one per line
    // ------------------------------------------------------------
    public String toString() {
        String s = "";
        for (int i = 0; i < list.length; i++)
            s += i + ":\t" + list[i] + "\n";
        return s;
    }

    // ------------------------------------------------------------
    // linearSearch -- takes a target value and returns the index
    // of the first occurrence of target in the list. Returns -1
    // if target does not appear in the list
    // ------------------------------------------------------------
    public int linearSearch(int target) {
        int location = -1;
        for (int i = 0; i < list.length && location == -1; i++)
            if (list[i] == target)
                location = i;
        return location;
    }

    private int minIndex(int arr[], int start) {
        int result = start;

        for (int i = start; i < this.list.length; i++) {
            if (this.list[i] < this.list[result]) {
                result = i;
            }
        }

        return result;
    }

    private void swap(int arr[], int a, int b) {
        int temp = this.list[a];
        this.list[a] = this.list[b];
        this.list[b] = temp;
    }

    // ------------------------------------------------------------
    // sortIncreasing -- uses selection sort
    // ------------------------------------------------------------
    public void sortIncreasing() {
        for (int i = 0; i < list.length - 1; i++) {
            int minIndex = minIndex(this.list, i);
            swap(this.list, i, minIndex);
        }
    }

    public int binarySearch(int n) {
        int l = 0, r = this.list.length - 1;
        int result = -1;

        while ((l <= r) && (result == -1)) {
            int m = (l + r) / 2;

            if (this.list[m] == n) {
                result = m;
            } else if (n < this.list[m]) {
                r = m - 1;
            } else if (n > this.list[m]) {
                l = m + 1;
            }
        }

        return result;
    }

    public void sortDecreasing() {
        int n = this.list.length;
        for (int i = 1; i < n; ++i) {
            int key = this.list[i];
            int j = i - 1;

            /* Move elements of this.list[0..i-1], that are
               greater than key, to one position ahead
               of their current position */
            while (j >= 0 && this.list[j] < key) {
                this.list[j + 1] = this.list[j];
                j = j - 1;
            }
            this.list[j + 1] = key;
        }
    }
}
