package de.unistuttgart.dsass2024.ex05.p4;

public class HeapSortCheckerList<T extends Comparable<T>> extends AbstractSortCheckerList<T> {

    public HeapSortCheckerList(ISimpleList<T> list) {
        super(list);
    }

    @Override
    public void testSort() {
        Sorter.heapSort(list);
    }

    @Override
    public boolean contains(T element) {
        return false;
    }
}