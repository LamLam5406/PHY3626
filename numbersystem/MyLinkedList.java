package hus.oop.numbersystem;

public class MyLinkedList extends MyAbstractList {
    private Node start;
    private Node end;
    private int size;

    /**
     * Hàm dựng khởi tạo list để chứa dữ liệu.
     */
    public MyLinkedList() {
        /* TODO */
        this.start = null;
        this.end = null;
        this.size = 0;
    }

    @Override
    public int size() {
        /* TODO */
        return this.size;
    }

    /**
     * Lấy giá trị của phần tử ở vị trí index.
     * @param index
     * @return
     */
    @Override
    public int get(int index) {
        /* TODO */
        if (!checkBoundaries(index, size)) {
            throw new IndexOutOfBoundsException("Index: " + index + ", Size: " + size);
        }
        Node node = getNodeByIndex(index);
        return node.data;
    }

    /**
     * Sửa dữ liệu ở vị trí index thành data.
     * @param data
     * @param index
     */
    @Override
    public void set(int data, int index) {
        /* TODO */
        if (!checkBoundaries(index, size)) {
            throw new IndexOutOfBoundsException("Index: " + index + ", Size: " + size);
        }
        Node node = getNodeByIndex(index);
        node.data = data;
    }

    /**
     * Thêm phần tử dữ liệu vào đầu tập dữ liệu.
     * @param value giá trị của phần tử dữ liệu được thêm vào.
     */
    @Override
    public void insertAtStart(int value) {
        /* TODO */
        Node newNode = new Node(value);
        if (isEmpty()) {
            start = newNode;
            end = newNode; // If list was empty, new node is both start and end
        } else {
            newNode.next = start; // New node points to the old start
            start = newNode;      // New node becomes the new start
        }
        size++;
    }

    /**
     * Thêm phần tử dữ liệu vào cuối tập dữ liệu.
     * @param value giá trị của phần tử dữ liệu được thêm vào.
     */
    @Override
    public void insertAtEnd(int value) {
        /* TODO */
        Node newNode = new Node(value);
        if (isEmpty()) {
            start = newNode;
            end = newNode; // If list was empty, new node is both start and end
        } else {
            end.next = newNode; // Old end points to the new node
            end = newNode;      // New node becomes the new end
        }
        size++;
    }

    /**
     * Thêm phần tử dữ liệu vào vị trí index của tập dữ liệu.
     * Chỉ thêm được nếu index nằm trong đoạn [0 - size()].
     * @param value
     * @param index
     */
    @Override
    public void insertAtPos(int value, int index) {
        /* TODO */
        if (!checkBoundariesForInsertion(index, size)) {
            throw new IndexOutOfBoundsException("Index for insertion: " + index + ", Size: " + size);
        }

        if (index == 0) {
            insertAtStart(value); // Use existing method for insertion at start
        } else if (index == size) {
            insertAtEnd(value); // Use existing method for insertion at end
        } else {
            // Find the node *before* the insertion point
            Node previousNode = getNodeByIndex(index - 1);
            Node newNode = new Node(value);
            newNode.next = previousNode.next; // New node points to the node currently at index
            previousNode.next = newNode;      // Previous node points to the new node
            size++;
        }
    }

    /**
     * Xóa phần tử dữ liệu tại vị trí index.
     * Chỉ xóa được nếu index nằm trong đoạn [0 - (size() - 1)]
     * @param index
     */
    @Override
    public void remove(int index) {
        /* TODO */
        if (!checkBoundaries(index, size)) {
            throw new IndexOutOfBoundsException("Index: " + index + ", Size: " + size);
        }

        if (index == 0) {
            // Remove the start node
            if (size == 1) { // Special case: removing the only element
                start = null;
                end = null;
            } else {
                start = start.next; // The second node becomes the new start
            }
        } else {
            // Find the node *before* the one to remove
            Node previousNode = getNodeByIndex(index - 1);
            Node nodeToRemove = previousNode.next;
            previousNode.next = nodeToRemove.next; // Link previous node to the node after the one being removed

            // Update end pointer if the last element was removed
            if (previousNode.next == null) { // Or equivalently, if index == size - 1
                end = previousNode;
            }
        }
        size--;
    }

    /**
     * Phương thức lấy Node ở vị trí index.
     * @param index
     * @return
     */
    private Node getNodeByIndex(int index) {
        /* TODO */
        // No need for boundary check here as it's private and called by public methods
        // that already do the check.
        Node current = start;
        for (int i = 0; i < index; i++) {
            current = current.next;
        }
        return current;
    }
    private boolean isEmpty() {
        return size == 0;
    }
    /**
     * Lấy ra dữ liệu được lưu theo cấu trúc dữ liệu kiểu mảng.
     * @return
     */
    @Override
    public int[] toArray() {
        /* TODO */
        int[] array = new int[size];
        Node current = start;
        int i = 0;
        while (current != null) {
            array[i++] = current.data;
            current = current.next;
        }
        return array;
    }
}
