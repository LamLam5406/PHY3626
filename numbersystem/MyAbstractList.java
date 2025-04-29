package hus.oop.numbersystem;

public abstract class MyAbstractList implements MyList {
    /**
     * Phương thức kiểm tra xem index có nằm trong đoạn [0 - limit] không.
     * @param index
     * @param limit
     * @return
     */
    public boolean checkBoundaries(int index, int limit) {
        /* TODO */
        return index >= 0 && index < limit;
    }
    protected boolean checkBoundariesForInsertion(int index, int limit) {
        return index >= 0 && index <= limit;
    }

    /**
     * Mô tả tập dữ liệu.
     * @return mô tả tập dữ liệu theo định dạng [a1, a2, a3, ..., an].
     */
    @Override
    public String toString() {
        /* TODO */
        int[] elements = toArray();
        if (elements == null || elements.length == 0) {
            return "[]";
        }

        StringBuilder sb = new StringBuilder();
        sb.append('[');
        for (int i = 0; i < elements.length; i++) {
            sb.append(elements[i]);
            if (i < elements.length - 1) {
                sb.append(", ");
            }
        }
        sb.append(']');
        return sb.toString();
    }
    @Override
    public abstract int size();

    @Override
    public abstract int get(int index);

    @Override
    public abstract void set(int data, int index);

    @Override
    public abstract void insertAtStart(int data);

    @Override
    public abstract void insertAtEnd(int data);

    @Override
    public abstract void insertAtPos(int data, int index);

    @Override
    public abstract void remove(int index);

    @Override
    public abstract int[] toArray();
}
