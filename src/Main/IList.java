// metody z parametrem index rzucają wyjątkiem IndexOutOfBoundException
// w przypadku błędu zakresu jego wartości

public interface IList<E> {

    // dodanie do kolekcji, gdzie - zależy od typu kolekcji
    // zwraca true, jeśli element został dodany
    boolean add(E value);

    // dodanie do kolekcji na określoną pozycję
    // zwraca wynika jak dla poprzedniego add
    boolean add(int index, E value);

    // czyści kolekcję
    void clear();

    // zwraca, czy kolekcja zawiera podaną wartość
    boolean contains(E value);

    // pobiera (bez usuwania) wartość spod podanej pozycji
    E get(int index);

    // ustawia nową wartość na podanej pozycji, zwraca starą wartość
    E set(int index, E value);

    // wzraca pozycję podanej wartości lub -1
    int	indexOf(E value);

    // zwraca, czy kolekcja jest pusta
    boolean	isEmpty();

    // usuwa element z podaje pozycji, zwracając jego wartość
    // lub null jeśli go nie ma
    E remove(int index);

    // usuwa wartość oraz zwraca true lub zwraca false
    boolean	remove(E value);

    // zwraca liczbę elementów kolekcji
    int size();
}
