package de.unistuttgart.dsass2024.ex05.p4;

public abstract class AbstractSortCheckerList<T extends Comparable<T>> implements ISimpleList<T> {

    ISimpleList<T> list;

    public AbstractSortCheckerList(ISimpleList<T> list) {
        this.list = list;
    }

    @Override
    public int size() {
        return list.size();
    }

    @Override
    public void append(T element) {
        list.append(element);
    }

    @Override
    public T get(int index) {
        return list.get(index);
    }

    @Override
    public void swap(int firstElementIndex, int secondElementIndex) {
        list.swap(firstElementIndex, secondElementIndex);
    }

    public abstract void testSort();

}