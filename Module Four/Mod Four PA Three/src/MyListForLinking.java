import java.util.Collection;

public interface MyListForLinking<E> extends Collection <E> {
    public void add(int index, E element);

    public E get(int index);

    public int indexOf(Object e);

    public int lastIndexOf(Object e);

    public E remove(int index);

    public E set(int index, E element);

    @Override
    public default boolean add(E element) {
        add(size(), element);
        return true;
    }
    @Override
    public default boolean remove(Object element) {
        if (indexOf(element) == -1) {
            return false;
        }
        remove(indexOf(element));
        return true;
    }

    @Override
    public default boolean containsAll(Collection<?> c) {
        return true;
    }

    @Override
    public default boolean addAll(Collection<? extends E> c) {

        return true;
    }

    @Override
    public default boolean retainAll(Collection<?> c) {
        return true;
    }

    @Override
    public default Object[] toArray() {

        return null;
    }

    @Override
    public default <T> T[] toArray(T[] array) {

        return null;
    }
}

