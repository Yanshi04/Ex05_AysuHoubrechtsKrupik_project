package de.unistuttgart.dsass2024.ex05.p4;

import org.junit.Before;
import org.junit.Test;

public class SorterTest {

    ISimpleList<Integer> list;
    ISimpleList<Integer> emptyList;

    @Before
    public void setUp() {
        list = new SimpleList<>();
        emptyList = new SimpleList<>();
        list.append(5);
        list.append(10);
        list.append(6);
        list.append(1);
        list.append(10);
        list.append(2);
    }

    @Test
    public void testSort() {
        Sorter.heapSort(list);
        for (int i = 0; i < list.size() - 1; i++) {
            assert (list.get(i) <= list.get(i + 1));
            System.out.println(list.get(i));
        }

        Sorter.heapSort(emptyList);
        for (int i = 0; i < emptyList.size() - 1; i++) {
            assert (emptyList.get(i) < emptyList.get(i + 1));
        }
    }

}