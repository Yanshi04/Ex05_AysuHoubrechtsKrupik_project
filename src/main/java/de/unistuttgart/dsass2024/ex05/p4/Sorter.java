package de.unistuttgart.dsass2024.ex05.p4;

public class Sorter {

    public static <T extends Comparable<T>> void heapSort(final ISimpleList<T> list) {

        for (int i = list.size() / 2 ; i >= 0; i--) {
            percolateMax(list, i, list.size() - 1);
        }

        for (int i = list.size() - 1; i > 0; i--) {
            list.swap(0, i);
            percolateMax(list, 0, i );
        }

    }

    /**
     * Percolate- the other way around
     *
     * @param list the list
     * @param idx the position of the actual element
     * @param n the last element of the heap
     */
    private static <T extends Comparable<T>> void percolateMax(final ISimpleList<T> list, int idx, int n) {
        int i = idx;
        int biggest = idx;                                          // Initialize biggest (so far) as root
        int left = 2 * i + 1;                                     // left = 2*i + 1
        int right = 2 * i + 2;                                    // right = 2*i + 2


        if (left < n && list.get(left).compareTo(list.get(biggest)) > 0) { // If left child is bigger than the biggest so far:
            biggest = left;                                                // biggest is now left
        }

        if (right < n && list.get(right).compareTo(list.get(biggest)) > 0) { // If right child is bigger
            biggest = right;                                                 // biggest is now right
        }

        if (biggest != idx) {                       // If biggest is not the root
            list.swap(idx, biggest);                // Swap the root with the biggest

            percolateMax(list, biggest, n);        // percolate again the affected sub-tree
        }
    }

    /**
     * Percolate from lecture
     *
     * @param list the list
     * @param idx the position of the actual element
     * @param last the last element of the heap
     */

    private static <T extends Comparable<T>> void percolate(final ISimpleList<T> list, int idx, int last) {
        int i = idx;

        while ((2 * i) + 1 <= last) {
            int j = (2 * i) + 1;
            if (j+1 <= last) {
                if (list.get(j).compareTo(list.get(j+1)) > 0) {
                    j++;
                }

            }
            if (list.get(i).compareTo(list.get(j)) > 0) {
                list.swap(i, j);
                i = j;
            } else {
                break;
            }
        }
    }

}