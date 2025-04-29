package hus.oop.numbersystem;

public class MyArrayList extends MyAbstractList {
    private static final int DEFAULT_CAPACITY = 16;
    private int[] data;
    private int size;

    /**
     * Hàm dựng để khởi tạo dữ liệu.
     */
    public MyArrayList() {
        /* TODO */
        this.data = new int[DEFAULT_CAPACITY];
        this.size = 0;
    }

    /**
     * Lấy kích thước của tập dữ liệu.
     * @return
     */
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
        return data[index];
    }

    /**
     * Sửa dữ liệu ở vị trí index thành data.
     * @param data
     * @param index
     */
    @Override
    public void set(int data, int index) {
        /* TODO */
        // Check if the index is valid
        if (!checkBoundaries(index, size)) {
            throw new IndexOutOfBoundsException("Index: " + index + ", Size: " + size);
        }
        // Set the element at the specified index to the new data value
        this.data[index] = data; // Corrected from 'value' in user snippet to 'data'
    }

    /**
     * Thêm phần tử dữ liệu vào đầu mảng dữ liệu.
     * Nếu mảng không còn chỗ, mở rộng mảng để có thể chứa thêm dữ liệu.
     * @param value là giá trị của phần tử dữ liệu được thêm vào.
     */
    @Override
    public void insertAtStart(int value) {
        /* TODO */
        insertAtPos(value, 0);
    }

    /**
     * Thêm phần tử dữ liệu vào cuối mảng dữ liệu.
     * Nếu mảng không còn chỗ, mở rộng mảng để có thể chứa thêm dữ liệu.
     * @param value là giá trị của phần tử dữ liệu được thêm vào.
     */
    @Override
    public void insertAtEnd(int value) {
        /* TODO */
        insertAtPos(value, size);
    }

    /**
     * Thêm phần tử dữ liệu vào vị trí index của mảng dữ liệu.
     * Nếu mảng không còn chỗ, mở rộng mảng để có thể chứa thêm dữ liệu.
     * @param value
     * @param index
     */
    @Override
    public void insertAtPos(int value, int index) {
        /* TODO */
        if (!checkBoundariesForInsertion(index, size)) {
            throw new IndexOutOfBoundsException("Index for insertion: " + index + ", Size: " + size);
        }
        if (size >= data.length) {
            allocateMore(); // Double the capacity if array is full
        }
        // Shift elements to the right from index to size - 1
        for (int i = size; i > index; i--) {
            data[i] = data[i - 1];
        }
        data[index] = value; // Insert the new value
        size++; // Increment the size
    }

    /**
     * Xóa phần tử dữ liệu tại vị trí index.
     * Chỉ xóa được nếu index nằm trong đoạn [0 - (size - 1)]
     * @param index
     */
    @Override
    public void remove(int index) {
        /* TODO */
        if (!checkBoundaries(index, size)) {
            throw new IndexOutOfBoundsException("Index: " + index + ", Size: " + size);
        }
        // Shift elements to the left from index + 1 to size - 1
        for (int i = index; i < size - 1; i++) {
            data[i] = data[i + 1];
        }
        // Optional: Clear the last element slot (not strictly necessary)
        // data[size - 1] = 0; // Or some default value
        size--; // Decrement the size
    }

    /**
     * Mở rộng gấp đôi kích thước mảng nếu hết chỗ để chứa dữ liệu.
     */
    private void allocateMore() {
        /* TODO */
        int newCapacity = data.length * 2;
        // Handle case where capacity is 0 initially
        if (newCapacity == 0) {
            newCapacity = DEFAULT_CAPACITY;
        }
        int[] newData = new int[newCapacity];
        // Copy elements from the old array to the new array
        System.arraycopy(data, 0, newData, 0, size);
        data = newData; // Update the reference to the new array
    }

    /**
     * Lấy ra dữ liệu được lưu theo cấu trúc dữ liệu kiểu mảng.
     * @return
     */
    @Override
    public int[] toArray() {
        /* TODO */
        // Create a new array of the exact size and copy elements
        int[] array = new int[size];
        System.arraycopy(data, 0, array, 0, size);
        return array;
    }
}
