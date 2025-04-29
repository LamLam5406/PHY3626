package hus.oop.numbersystem;

import java.util.EmptyStackException;
public class MyStack {
    private MyList stack;

    public MyStack() {
        this.stack = new MyArrayList();
    }

    /**
     * Thêm dữ liệu vào đầu stack.
     * @param value
     */
    public void push(int value) {
        /* TODO */
        // Add element to the "end" of the list, which represents the top of the stack
        stack.insertAtEnd(value);
    }

    /**
     * Xóa và trả lại giá trị ở vị trí đầu stack.
     * @return
     */
    public int pop() {
        /* TODO */
        if (isEmpty()) {
            throw new EmptyStackException();
        }
        // Get the item from the end (top) before removing it
        int topValue = stack.get(stack.size() - 1);
        // Remove the item from the end (top)
        stack.remove(stack.size() - 1);
        return topValue;
    }

    /**
     * Kiểm tra xem stack có rỗng không.
     * @return true nếu stack rỗng, false nếu stack không rỗng.
     */
    public boolean isEmpty() {
        /* TODO */
        return stack.size() == 0;
    }

    /**
     * Trả lại giá trị ở đầu stack mà không xóa phần tử.
     * @return giá trị ở vị trí đầu stack.
     */
    public int peek() {
        /* TODO */
        if (isEmpty()) {
            throw new EmptyStackException();
        }
        // Return the item at the end (top) without removing it
        return stack.get(stack.size() - 1);
    }

    /**
     * Lấy kích thước của stack.
     * @return
     */
    public int size() {
        /* TODO */
        return stack.size();
    }
    public int get(int index) {
        return stack.get(index);
    }

    @Override
    public String toString() {
        return stack.toString();
    }
}
