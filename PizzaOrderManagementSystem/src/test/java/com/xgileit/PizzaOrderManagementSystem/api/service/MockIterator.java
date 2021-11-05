package com.xgileit.PizzaOrderManagementSystem.api.service;

import java.util.Arrays;
import java.util.Iterator;

import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

public class MockIterator {

    /*
    Could not figure out how to test a for each loop, so i've found this mock iterator class
    on the internet and implemented my own version of the implementation in my
    Customer & Manager Service test classes.

    Methods - listAllPendingOrders & listAllDeliveredOrders
     */


    public static <T> void mockIterable(Iterable<T> iterable, T... values) {

        Iterator<T> mockIterator = mock(Iterator.class);
        when(iterable.iterator()).thenReturn(mockIterator);

        if (values.length == 0) {
            when(mockIterator.hasNext()).thenReturn(false);
            return;
        } else if (values.length == 1) {
            when(mockIterator.hasNext()).thenReturn(true, false);
            when(mockIterator.next()).thenReturn(values[0]);
        } else {
            // build boolean array for hasNext()
            Boolean[] hasNextResponses = new Boolean[values.length];

            for (int i = 0; i < hasNextResponses.length -1 ; i++) {
                hasNextResponses[i] = true;
            }

            hasNextResponses[hasNextResponses.length - 1] = false;

            when(mockIterator.hasNext()).thenReturn(true, hasNextResponses);

            T[] valuesMinusTheFirst = Arrays.copyOfRange(values, 1, values.length);

            when(mockIterator.next()).thenReturn(values[0], valuesMinusTheFirst);
        }
    }
}
