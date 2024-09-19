import java.util.Collection;
import java.util.Iterator;
import java.util.ListIterator;
import java.util.NoSuchElementException;

public class MyTwoWayLinkedList<E> implements MyListForLinking <E> {

    private Node<E> head, tail;
    private int size;

    public MyTwoWayLinkedList() { head = null; tail = null; size = 0; }

    public MyTwoWayLinkedList(E[] objects) {
        for (E object : objects) {
            add(object);
        }
    }
    public E getFirst() {
        if (getSize() == 0) {
            return null;
        } else {
            return head.element;
        }
    }
    public E getLast() {
        if (getSize() == 0) {
            return null;
        }
        return tail.element;
    }
    public int getSize() {
        return size;
    }
    private void setSize(int size) {
        this.size = size;
    }

    public void addFirst(E object) {
        Node<E> newNode = new Node <>(object);
        if (head == null) {
            head = newNode;
            tail = newNode;
        } else {
            newNode.next = head;
            head.previous = newNode;
            head = newNode;
        }
        size++;
    }
    public void addLast(E object) {
        Node<E> newNode = new Node <>(object);
        if (head == null) {
            head = newNode;
        } else {
            tail.next = newNode;
            newNode.previous = tail;
            tail = newNode;
        }
        size++;
    }
    public E removeFirst() {
        if (getSize() == 0) {
            return null;
        } else {
            head = head.next;
            head.next.previous = null;
        }
        size--;
        return head.element;
    }
    public E removeLast() {
        if (getSize() == 0) {
            return null;
        } else {
            tail = tail.previous;
            tail.next = null;
        }
        size--;
        return tail.element;
    }
    @Override
    public void add(int index, E element) {
        Node<E> newNode = new Node<>(element);
        if (index == 0) {
            addFirst(element);
        } else if (index >= getSize()) {
            addLast(element);
        } else {
            Node<E> current = head;
            for (int i = 0; i < index; i++) {
                current = current.next;
            }

            newNode.next = current;
            newNode.previous = current.previous;
            if (current.previous != null) {
                (current.previous).next = newNode;
            }
            current.previous = newNode;
            size++;
        }
    }

    @Override
    public E get(int index) {
        Node<E> current = head;
        for (int i = 0; i < index; i++) {
            current = current.next;
        }
        return current.element;
    }
    @Override
    public int indexOf(Object e) {
        int i = 0;
        Node<E> current = head;
        while (current != null) {
            if (current.element == e) {
                return i;
            }
            current = current.next;
        }
        return -1;
    }
    @Override
    public int lastIndexOf(Object e) {
        boolean matched = false;
        int i = 0;
        Node<E> current = head;
        while (current != null) {
            if (current.element == e) {
                E match = current.element;
                matched = true;
            }
            current = current.next;
            i++;

        }
        if (matched){
            return i;
        } else {
            return -1;
        }
    }
    @Override
    public E remove(int index) {
        Node <E> current;
        if (index < 0 || index >= getSize()) {
            return null;
        } else if (index == 0) {
            return removeFirst();
        } else if (index == getSize() - 1) {
            return removeLast();
        } else {
            current = head;
            for (int i = 0; i < index; i++) {
                current = current.next;
            }
            // isolating the current node
            Node <E> previous = current.previous;
            Node <E> next = current.next;
            previous.next = next;
            if (next != null) {
                next.previous = previous;
            }
        }
        size--;
        return current.element;
    }

    @Override
    public String toString() {
        StringBuilder result = new StringBuilder("[");
        Node<E> current = head;
        while (current != null) {
            result.append(current.element);
            current = current.next;
            if (current != null) {
                result.append(", ");
            }else {
                result.append("]");
            }
        }
        return result.toString();
    }

    @Override
    public E set(int index, E element) {
        Node<E> newNode = new Node <>(element);
        if (index == 0) {
            addFirst(element);
        } else if (index >= getSize()) {
            addLast(element);
        } else {
            Node<E> current = head;
            for (int i = 0; i < index - 1; i++) {
                current = current.next;
            }
            Node<E> previous = current.previous;
            newNode.next = current.next;
            current.next.previous = newNode;
            newNode.previous = previous;
            previous.next = newNode;
        }
        return newNode.element;
    }
    @Override
    public int size() {
        return getSize();
    }
    @Override
    public boolean isEmpty() {
        return getSize() == 0;
    }
    @Override
    public boolean contains(Object o) {
        Node<E> current = head;
        while (current != null) {
            if (current.element == o) {
                return true;
            }
            current = current.next;
        }
        return false;
    }

    @Override
    public Iterator <E> iterator() {
        return null;
    }


    private class LinkedListIterator implements ListIterator <E> {
        private Node<E> current;
        private int index;

        public LinkedListIterator(int index) {
            this.index = index;
            if (index == 0) {
                current = head;
            } else if (index == size) {
                current = tail;  // Start at the tail when iterating backward
            } else {
                current = head;
                for (int i = 0; i < index; i++) {
                    current = current.next;
                }
            }
        }

        @Override
        public boolean hasNext() {
            return current != null;
        }

        @Override
        public E next() {
            if (current == null && index == 0) throw new NoSuchElementException();{
                E element = current.element;
                current = current.next;
                index++;
                return element;
            }

        }

        @Override
        public boolean hasPrevious() {
            return current != null;
        }

        @Override
        public E previous() {
            if (!hasPrevious()) {
                throw new NoSuchElementException();
            }
            E element = current.element;
            current = current.previous;
            index--;
            return element;
        }

        @Override
        public int nextIndex() {
            return index;
        }

        @Override
        public int previousIndex() {
            return index - 1;
        }

        @Override
        public void remove() {
            throw new UnsupportedOperationException("Remove not implemented");
        }

        @Override
        public void set(E e) {
            if (current == null) throw new IllegalStateException();
            current.element = e;
        }

        @Override
        public void add(E element) {
            Node<E> newNode = new Node<>(element);
            if (tail == null) {
                head = tail = newNode;
            } else {
                tail.next = newNode;
                newNode.previous = tail;
                tail = newNode;
            }
            size++;
        }
    }

    public Iterator <E> listIterator(int index) {
        return new LinkedListIterator(index);
    }

    @Override
    public boolean removeAll(Collection <?> c) {
        return false;
    }

    @Override
    public void clear() {
        setSize(0);
        head = tail = null;
    }

    private static class Node<E> {
        E element;
        Node<E> next;
        Node<E> previous;

        public Node(E element) {
            this.element = element;
        }
    }
}
