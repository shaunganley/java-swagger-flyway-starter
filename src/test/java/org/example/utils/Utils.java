package org.example.utils;

import static org.junit.jupiter.api.Assertions.*;

import java.util.List;

public class Utils {

    public static <T, G> void assertEqualLists(List<T> list1, List<G> list2) {
        if (list1 == null) {
            fail("First list is null");
        }
        if (list2 == null) {
            fail("Second list is null");
        }
        if (list1.size() != list2.size()) {
            fail("Lists are different size.");
        }
        for (int i = 0; i < list1.size(); i++) {
            assertEquals(list1.get(i), list2.get(i));
        }
    }
}
