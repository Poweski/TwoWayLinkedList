import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class TwoWayLinkedListNodeTest {
    private TwoWayLinkedList<Integer> list;

    @BeforeEach
    void setUp() {
        list = new TwoWayLinkedList<>();
        list.add(10);
        list.add(20);
        list.add(30);
    }

    @Test
    void getNodeWithValidIndexTest() {
        assertEquals(10, list.getNode(0).getValue());
        assertEquals(20, list.getNode(1).getValue());
        assertEquals(30, list.getNode(2).getValue());
    }

    @Test
    void getNodeWigthInvalidIndexTest() {
        assertThrows(IndexOutOfBoundsException.class, () -> list.getNode(-1));
        assertThrows(IndexOutOfBoundsException.class, () -> list.getNode(3));
        assertThrows(IndexOutOfBoundsException.class, () -> list.getNode(10));
    }

    @Test
    void getNodeWithValueInListTest() {
        assertEquals(10, list.getNode((Integer)10).getValue());
        assertEquals(20, list.getNode((Integer)20).getValue());
        assertEquals(30, list.getNode((Integer)30).getValue());
    }

    @Test
    void getNodeWithValueNotInListTest() {
        assertNull(list.getNode((Integer)0));
        assertNull(list.getNode((Integer)15));
        assertNull(list.getNode((Integer)25));
    }
}