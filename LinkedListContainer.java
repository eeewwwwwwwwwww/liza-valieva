//публичный класс
public class LinkedListContainer<T> {
    //голова и хвост связного списка
    private Node<T> head;
    private Node<T> tail;
    //количество элементов в контейнере
    private int size;
//статический вложенный класс, который представляет узел связного списка
    private static class Node<T> {
        private T data;//значение элемента
        private Node<T> next;//указывает на следующий узел в списке
//конструктор
        public Node(T data) {
            this.data = data;
            this.next = null;
        }
    }
//конструктор
    public LinkedListContainer() {
        this.head = null;
        this.tail = null;
        this.size = 0;
    }
//Метод `add` добавляет новый элемент в контейнер
    public void add(T element) {
        Node<T> newNode = new Node<>(element);
        if (size == 0) {
            head = newNode;
            tail = newNode;
        } else {
            tail.next = newNode;
            tail = newNode;
        }
        size++;
    }
//Метод `get` получает элемент по заданному индексу
    public T get(int index) {
        //Если индекс выходит за пределы диапазона контейнера
        if (index < 0 || index >= size) {
            //выбрасывается исключение `IndexOutOfBoundsException`
            throw new IndexOutOfBoundsException();
        }
        Node<T> current = head;
        //происходит итерация по связному списку до нужного узла, и его значение возвращается
        for (int i = 0; i < index; i++) {
            current = current.next;
        }
        return current.data;
    }
//Метод `remove` удаляет элемент по заданному индексу
    public void remove(int index) {
        if (index < 0 || index >= size) {
            throw new IndexOutOfBoundsException();
        }
        //Если индекс равен 0, то голова обновляется на следующий узел
        if (index == 0) {
            head = head.next;
            //сли голова стала `null`, то хвост также обновляется
            if (head == null) {
                tail = null;
            }
        } else {
            Node<T> prev = head;
            //происходит итерация по связному списку до предыдущего узла перед удаляемым
            for (int i = 0; i < index - 1; i++) {
                prev = prev.next;
            }
            Node<T> current = prev.next;
            prev.next = current.next;
            //Если после удаления хвост стал `null`, то он обновляется на предыдущий узел
            if (prev.next == null) {
                tail = prev;
            }
        }
        size--;
    }
//Метод `size` возвращает количество элементов в контейнере
    public int size() {
        return size;
    }
}
