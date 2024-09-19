/* You have to use the following template to submit to Revel.
   Note: To test the code using the CheckExerciseTool, you will submit entire code.
   To submit your code to Revel, you must only submit the code enclosed between
     // BEGIN REVEL SUBMISSION

     // END REVEL SUBMISSION
*/
import java.util.*;

public class Exercise24_03 {
    @SuppressWarnings("InstantiationOfUtilityClass")
    public static void main(String[] args) {
        new Exercise24_03();
    }

    public Exercise24_03() {
        MyTwoWayLinkedList <Double> list = new MyTwoWayLinkedList <>();
        System.out.print("Enter five numbers: ");
        Scanner input = new Scanner(System.in);
        double[] v = new double[5];
        for (int i = 0; i < 5; i++) {
            v[i] = input.nextDouble();
        }

        list.add(v[1]);
        list.add(v[2]);
        list.add(v[3]);
        list.add(v[4]);
        list.add(0, v[0]);
        list.add(2, 10.55);
        list.remove(3);

        Iterator <Double> iterator1 = list.listIterator(0);
        System.out.print("The list in forward order: ");
        while (iterator1.hasNext())
            System.out.print(iterator1.next() + " ");

        ListIterator <Double> iterator2 = (ListIterator <Double>) list.listIterator(list.size());
        System.out.print("\nThe list in backward order: ");
        while (iterator2.hasPrevious())
            System.out.print(iterator2.previous() + " ");

    }
}

interface MyList<E> extends Collection<E> {
    /** Add a new element at the specified index in this list */
    public void add(int index, E e);

    /** Return the element from this list at the specified index */
    public E get(int index);

    /** Return the index of the first matching element in this list.
     *  Return -1 if no match. */
    public int indexOf(Object e);

    /** Return the index of the last matching element in this list
     *  Return -1 if no match. */
    public int lastIndexOf(E e);

    /**
     * Remove the element at the specified position in this list
     * Shift any subsequent elements to the left.
     * Return the element that was removed from the list.
     */
    public void remove(int index);

    /** Replace the element at the specified position in this list
     *  with the specified element and returns the new set. */
    public E set(int index, E e);

    @Override /* Add a new element at the end of this list */
    public default boolean add(E e) {
        add(size(), e);
        return true;
    }

    @Override /* Return true if this list contains no elements */
    public default boolean isEmpty() {
        return size() == 0;
    }

    @Override /* Remove the first occurrence of the element e
     *  from this list. Shift any subsequent elements to the left.
     *  Return true if the element is removed. */
    public default boolean remove(Object e) {
        if (indexOf(e) >= 0) {
            remove(indexOf(e));
            return true;
        }
        else
            return false;
    }

    @Override
    public default boolean containsAll(Collection<?> c) {
        // Left as an exercise
        return true;
    }

    @Override
    public default boolean addAll(Collection<? extends E> c) {
        // Left as an exercise
        return true;
    }

    @Override
    public default boolean removeAll(Collection<?> c) {
        // Left as an exercise
        return true;
    }

    @Override
    public default boolean retainAll(Collection<?> c) {
        // Left as an exercise
        return true;
    }

    @Override
    public default Object[] toArray() {
        // Left as an exercise
        return null;
    }

    @Override
    public default <T> T[] toArray(T[] array) {
        // Left as an exercise
        return null;
    }
}

class TwoWayLinkedList<E> implements MyListForLinking <E> {
    private Node<E> head, tail;
    private int size;

    /** Create a default list */
    public TwoWayLinkedList() {
    }

    /** Create a list from an array of objects */
    public TwoWayLinkedList(E[] objects) {
        for (E e : objects)
            add(e);
    }

    /** Return the head element in the list */
    public E getFirst() {
        if (size == 0) {
            return null;
        } else {
            return head.element;
        }
    }

    /** Return the last element in the list */
    public E getLast() {
        if (size == 0) {
            return null;
        } else {
            return tail.element;
        }
    }

    @Override
    public String toString() {
        StringBuilder result = new StringBuilder("[");

        Node<E> current = head;
        for (int i = 0; i < size; i++) {
            if (current != null) {
                result.append(current.element);
            }
            current = current != null ? current.next : null;
            if (current != null) {
                result.append(", "); // Separate two elements with a comma
            } else {
                result.append("]"); // Insert the closing ] in the string
            }
        }

        return result.toString();
    }

    /** Clear the list */
    public void clear() {
        head = tail = null;
    }

    /** Return true if this list contains the element o */
    public boolean contains(Object e) {
        System.out.println("Implementation left as an exercise");
        return true;
    }

    /** Return the element from this list at the specified index */
    public E get(int index) {
        System.out.println("Implementation left as an exercise");
        return null;
    }

    /**
     * Return the index of the head matching element in this list. Return -1 if
     * no match.
     */
    public int indexOf(Object e) {
        System.out.println("Implementation left as an exercise");
        return 0;
    }

    /**
     * Return the index of the last matching element in this list Return -1 if
     * no match.
     */
    public int lastIndexOf(Object e) {
        System.out.println("Implementation left as an exercise");
        return 0;
    }

    /**
     * Replace the element at the specified position in this list with the
     * specified element.
     */
    public E set(int index, E e) {
        System.out.println("Implementation left as an exercise");
        return null;
    }

    private class LinkedListIterator implements ListIterator<E> {
        private Node<E> current;
        private int index;

        public LinkedListIterator(int index) {
            this.index = index;
            current = head;
            for (int i = 0; i < index && current != null; i++) {
                current = current.next;
            }
        }

        public LinkedListIterator() {

        }


        @Override
        public boolean hasNext() {
            return current != null;
        }

        @Override
        public E next() {
            if (current == null) throw new NoSuchElementException();
            E element = current.element;
            current = current.next;
            index++;
            return element;
        }

        @Override
        public boolean hasPrevious() {
            return current != null && current.previous != null;
        }

        @Override
        public E previous() {
            if (current == null || current.previous == null) throw new NoSuchElementException();
            current = current.previous;
            index--;
            return current.element;
        }

        @Override
        public void remove() {
            System.out.println("Implementation left as an exercise");
        }

        @Override
        public void add(E e) {
            System.out.println("Implementation left as an exercise");
        }


        @Override
        public int nextIndex() {
            System.out.println("Implementation left as an exercise");
            return 0;
        }

        @Override
        public int previousIndex() {
            System.out.println("Implementation left as an exercise");
            return 0;
        }

        @Override
        public void set(E e) {
            current.element = e; // TODO Auto-generated method stub
        }
    }

    private class Node<E> {
        E element;
        Node<E> next;
        Node<E> previous;

        public Node(E o) {
            element = o;
        }
    }

    @Override
    public int size() {
        return size;
    }

    @Override
    public boolean isEmpty() {
        return size() == 0;
    }

    public ListIterator<E> listIterator() {
        return new LinkedListIterator();
    }

    public ListIterator<E> listIterator(int index) {
        return new LinkedListIterator(index);
    }

    @Override
    public Iterator<E> iterator() {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public boolean removeAll(Collection <?> c) {
        return false;
    }

// BEGIN REVEL SUBMISSION
    /** Add an element to the beginning of the list */
    public void addFirst(E e) {
        Node<E> newNode = new Node <>(e);
        if (head == null) {
            head = newNode;
            tail = newNode;
        } else {
            newNode.next = head;
            head.previous = newNode;
            head = newNode;
        }
    }

    /** Add an element to the end of the list */
    public void addLast(E e) {
        Node<E> newNode = new Node <>(e);
        if (head == null) {
            head = newNode;
        }
        tail.next = newNode;
        newNode.previous = tail;
        tail = newNode;
    }

    /**
     * Add a new element at the specified index in this list The index of the
     * head element is 0
     */
    public void add(int index, E element) {
        // Write your code here
        Node<E> newNode = new Node <>(element);
        if (index == 0) {
            addFirst(element);
        } else if (index >= size) {
            addLast(element);
        } else {
            Node<E> current = head;
            for (int i = 0; i < index - 1; i++) {
                current = current.next;
            }
            newNode.next = current.next;
            (current.next).previous = newNode;
            newNode.previous = current;
            current.next = newNode;
        }
    }

    /**
     * Remove the head node and return the object that is contained in the
     * removed node.
     */
    public E removeFirst() {
        // Write your code here
        if (size == 0) {
            return null;
        } else {
            head = head.next;
            head.next.previous = null;
        }
        return head.element;
    }

    /**
     * Remove the last node and return the object that is contained in the
     * removed node.
     */
    public E removeLast() {
        // Write your code here
        if (size == 0) {
            return null;
        } else {
            tail = tail.previous;
            tail.previous.next = null;
        }
        return tail.element;
    }

    /**
     * Remove the element at the specified position in this list. Return the
     * element that was removed from the list.
     */
    public E remove(int index) {
        // Write your code here
        Node <E> current;
        if (index < 0 || index >= size) {
            return null;
        } else if (index == 0) {
            return removeFirst();
        } else if (index == size - 1) {
            return removeLast();
        } else {
            current = head;
            for (int i = 0; i < index - 1; i++) {
                current = current.next;
            }
            Node <E> previous = current.previous;
            previous.next = current.next;
            current.next.previous = previous;
        }
        return current.element;
    }
}
// END REVEL SUBMISSION