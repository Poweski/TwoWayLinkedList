import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class TwoWayLinkedListTest {
    private TwoWayLinkedList<Integer> list;

    @BeforeEach
    public void setUp() {
        list = new TwoWayLinkedList<>();
    }

    @Test
    void isEmptyTest() {
        assertTrue(list.isEmpty());
        list.add(1);
        assertFalse(list.isEmpty());
    }

    @Test
    void clearTest() {
        list.add(1);
        list.add(2);
        list.add(3);
        assertFalse(list.isEmpty());
        list.clear();
        assertTrue(list.isEmpty());
    }

    @Test
    void containsTest() {
        list.add(1);
        list.add(2);
        assertTrue(list.contains(1));
        assertTrue(list.contains(2));
        assertFalse(list.contains(3));
    }

    @Test
    void sizeTest() {
        assertEquals(0, list.size());
        list.add(1);
        assertEquals(1, list.size());
        list.add(2);
        assertEquals(2, list.size());
        list.add(3);
        assertEquals(3, list.size());
    }

    @Test
    void indexOfTest() {
        assertEquals(-1,list.indexOf(1));
        list.add(1);
        list.add(2);
        list.add(3);
        assertEquals(0, list.indexOf(1));
        assertEquals(1, list.indexOf(2));
        assertEquals(2, list.indexOf(3));
        assertEquals(-1, list.indexOf(4));
    }

    @Test
    void getTest() {
        assertThrows(IndexOutOfBoundsException.class, () -> list.get(0));
        list.add(1);
        list.add(2);
        list.add(3);
        assertEquals(1, list.get(0));
        assertEquals(2, list.get(1));
        assertEquals(3, list.get(2));
        assertThrows(IndexOutOfBoundsException.class, () -> list.get(3));
    }

    @Test
    void setTest() {
        assertThrows(IndexOutOfBoundsException.class, () -> list.set(1,2));
        list.add(1);
        list.add(2);
        list.add(3);
        assertEquals(2, list.set(1, 4));
        assertEquals(1, list.set(0, 5));
        assertThrows(IndexOutOfBoundsException.class, () -> list.set(3, 6));
    }

    @Test
    void addTest() {
        assertTrue(list.add(1));
        assertTrue(list.add(2));
        assertTrue(list.add(3));
        assertEquals(1, list.get(0));
        assertEquals(2, list.get(1));
        assertEquals(3, list.get(2));
    }

    @Test
    void addAtIndexTest() {
        list.add(1);
        list.add(2);
        list.add(3);
        assertTrue(list.add(1, 4));
        assertEquals(1, list.get(0));
        assertEquals(4, list.get(1));
        assertEquals(2, list.get(2));
        assertEquals(3, list.get(3));
        assertThrows(IndexOutOfBoundsException.class, () -> list.add(5, 5));
    }

    //remove dla ostatniego elementu nie działa
    @Test
    public void removeByIndexTest() {
        list.add(1);
        list.add(2);
        list.add(3);
        assertEquals(2, list.remove(1));
        assertEquals(2, list.size());
        assertEquals(1, list.indexOf(3));
        assertEquals(-1,list.indexOf(2));
    }

    @Test
    public void removeByValueTest() {
        list.add(1);
        list.add(2);
        list.add(3);
        assertTrue(list.remove(Integer.valueOf(2)));
        assertEquals(2, list.size());
        assertEquals(-1, list.indexOf(2));
        assertEquals(0, list.indexOf(1));
    }

    @Test
    public void removeFromEmptyListTest() {
        assertThrows(IndexOutOfBoundsException.class, () -> list.remove(0));
        assertFalse(list.remove(Integer.valueOf(1)));
    }
}