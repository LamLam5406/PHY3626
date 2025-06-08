package hus.oop.statistics;

public class MyArrayList extends MyAbstractList {
    private static final int DEFAULT_CAPACITY = 16;
    private double[] data;
    private int size;

    /**
     * Khởi tạo dữ liệu mặc định.
     */
    public MyArrayList() {
        /* TODO */
        data = new double[DEFAULT_CAPACITY];
        size = 0;
    }

    @Override
    public int size() {
        /* TODO */
        return size;
    }

    @Override
    public void add(double data) {
        /* TODO */
        if (size >= this.data.length) {
            allocateMore();
        }
        this.data[size] = data;
        size++;
    }

    @Override
    public void insert(double data, int index) {
        /* TODO */
        if (index < 0 || index > size) {
            throw new ArrayIndexOutOfBoundsException("Index: " + index + ", Size: " + size);
        }

        if (size >= this.data.length) {
            allocateMore();
        }

        // Shift elements to make room for the new element
        for (int i = size; i > index; i--) {
            this.data[i] = this.data[i - 1];
        }

        this.data[index] = data;
        size++;
    }

    @Override
    public void remove(int index) {
        /* TODO */
        if (index < 0 || index >= size) {
            throw new ArrayIndexOutOfBoundsException("Index: " + index + ", Size: " + size);
        }

        // Shift elements to remove the element at the specified index
        for (int i = index; i < size - 1; i++) {
            data[i] = data[i + 1];
        }

        size--;
    }

    @Override
    public MyArrayList sortIncreasing() {
        /* TODO */
        MyArrayList sortedList = new MyArrayList();

        // Copy data to the new list
        for (int i = 0; i < size; i++) {
            sortedList.add(data[i]);
        }

        // Simple bubble sort implementation
        for (int i = 0; i < sortedList.size - 1; i++) {
            for (int j = 0; j < sortedList.size - i - 1; j++) {
                if (sortedList.data[j] > sortedList.data[j + 1]) {
                    // Swap
                    double temp = sortedList.data[j];
                    sortedList.data[j] = sortedList.data[j + 1];
                    sortedList.data[j + 1] = temp;
                }
            }
        }

        return sortedList;
    }

    @Override
    public int binarySearch(double data) {
        /* TODO */
        return binarySearchHelper(data, 0, size - 1);
    }

    private int binarySearchHelper(double data, int left, int right) {
        if (left > right) {
            return -1;
        }

        int mid = left + (right - left) / 2;

        if (this.data[mid] == data) {
            return mid;
        }

        if (this.data[mid] > data) {
            return binarySearchHelper(data, left, mid - 1);
        }

        return binarySearchHelper(data, mid + 1, right);
    }
    /**
     * Tạo iterator để có thể duyệt qua các phần tử của list.
     * @return
     */
    @Override
    public MyIterator iterator(int start) {
        /* TODO */
        return new MyArrayListIterator(start);
    }

    /**
     * Cấp phát gấp đôi chỗ cho danh sách khi cần thiết.
     */
    private void allocateMore() {
        /* TODO */
        double[] newData = new double[data.length * 2];
        for (int i = 0; i < size; i++) {
            newData[i] = data[i];
        }
        data = newData;
    }

    private class MyArrayListIterator implements MyIterator {
        /**
         * Vị trí hiện tại của iterator trong MyArrayList.
         */
        private int currentPosition;

        /**
         * Khởi tạo dữ liệu cho iterator tại vị trí position của list.
         */
        public MyArrayListIterator(int position) {
            /* TODO */
            currentPosition = position;
        }

        @Override
        public boolean hasNext() {
            /* TODO */
            return currentPosition < size;

        }

        @Override
        public Number next() {
            /* TODO */
            if (!hasNext()) {
                throw new IndexOutOfBoundsException("No more elements to iterate");
            }
            return data[currentPosition++];
        }

        @Override
        public void remove() {
            /* TODO */
            MyArrayList.this.remove(--currentPosition);
        }
    }
}
