import java.util.Arrays;
// To get random...
import java.util.Random;

public class QuickSort {
    // Main reads a single int from the terminal that specifices the size of the array
    // and then reads that many integers from standard input
    // stores them in an array sorts them, then prints them to the console.
    public static void main(String[] args) {
        //Kattio io = new Kattio(System.in, System.out);
        int n = 1000000;;
        int[] a = new int[n];
        Random r = new Random();
        for (int i = 0; i < n; i++)
            a[i] = r.nextInt(1000000);
        if (true) //(args.length > 0 && args[0].equals("quick"))
            quickSort(a);
        else if (args.length > 0 && args[0].equals("Arrays.sort"))
            Arrays.sort(a);
        else
            insertionSort(a);
        //for (int i = 0; i < n; i++)
        //    System.out.print(a[i] + " ");
    }

    // insertionSort sorts the array a into ascending order.
    public static void insertionSort(int[] a) {
        for (int i = 1; i < a.length; i++) {
            int j = i;
            int temp = a[j];
            while (j > 0 && temp < a[j - 1]) {
                a[j] = a[j - 1];
                j--;
            }
            a[j] = temp;
        }
    }

    // Sort the array but use Quicksort all the way
    public static void quickSort(int[] a) {
        quickSort(a, 0, a.length - 1);
    }

    // quickSort sorts the array a into ascending order.
    // Uses the quicksort algorithm.
    public static void quickSort(int[] a, int lo, int hi) {
        if (hi <= lo) return;
        int j = partition(a, lo, hi);
        quickSort(a, lo, j - 1);
        quickSort(a, j + 1, hi);
    }

    // partition rearranges the array so that a[lo] <= a[lo + 1] <= ... <= a[hi].
    // It also returns the index j so that a[lo] <= a[lo + 1] <= ... <= a[j - 1] <= a[j] <= a[j + 1] <= ... <= a[hi].
    public static int partition(int[] a, int lo, int hi) {
        int i = lo;
        int j = hi + 1;
        int v = a[lo]; // partitioning item
        while (true) {
            // Scan right, scan left, check for scan complete, and exchange.
            while (a[++i] < v) if (i == hi) break;
            while (v < a[--j]) if (j == lo) break;
            if (i >= j) break;
            exch(a, i, j);
        }
        exch(a, lo, j); // Put v = a[j] into position
        return j; // with a[lo] <= a[lo + 1] <= ... <= a[j - 1] <= a[j] <= a[j + 1] <= ... <= a[hi].
    }


    // exch exchanges the values of a[i] and a[j].
    public static void exch(int[] a, int i, int j) {
        int swap = a[i]; a[i] = a[j]; a[j] = swap;
    }

}