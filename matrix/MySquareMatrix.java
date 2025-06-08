package hus.oop.matrix;

public class MySquareMatrix {
    private int[][] data;

    /**
     * Hàm dựng, khởi tạo một ma trận có các phần tử được sinh ngẫu nhiên trong khoảng [1, 100]
     * @param size
     */
    public MySquareMatrix(int size) {
        initRandom(size);
    }

    /**
     * Phương thức khởi tạo ma trận, các phần tử của ma trận được sinh ngẫu nhiên trong đoạn [10, 90]
     * @param size
     */
    private void initRandom(int size) {
        /* TODO */
        if (size <= 0) {
            // Handle invalid size appropriately
            data = new int[0][0];
            return;
        }
        data = new int[size][size];
        for (int i = 0; i < size; i++) {
            for (int j = 0; j < size; j++) {
                // Random number between 10 and 90
                data[i][j] = (int) (Math.random() * 81) + 10;
            }
        }
    }

    /**
     * Lấy ra các phần tử trên đường chéo chính của ma trận.
     * @return đường chéo chính của ma trận.
     */
    public int[] principalDiagonal() {
        /* TODO */
        int size = data.length;
        int[] diagonal = new int[size];
        for (int i = 0; i < size; i++) {
            diagonal[i] = data[i][i];
        }
        return diagonal;
    }

    /**
     * Lấy ra các phần tử trên đường chéo phụ của ma trận.
     * @return đường chéo phụ của ma trận.
     */
    public int[] secondaryDiagonal() {
        /* TODO */
        int size = data.length;
        int[] diagonal = new int[size];
        for (int i = 0; i < size; i++) {
            diagonal[i] = data[i][size - 1 - i];
        }
        return diagonal;
    }

    /**
     * Phương thức lấy ra các số là số nguyên tố trong ma trận.
     * @return các số nguyên tố trong ma trận.
     */
    public int[] primes() {
        /* TODO */
        int count = 0;
        for (int[] row : data) {
            for (int value : row) {
                if (isPrime(value)) {
                    count++;
                }
            }
        }

        int[] primeNumbers = new int[count];
        int index = 0;
        for (int[] row : data) {
            for (int value : row) {
                if (isPrime(value)) {
                    primeNumbers[index++] = value;
                }
            }
        }
        return primeNumbers;
    }
    private boolean isPrime(int n) {
        if (n <= 1) {
            return false;
        }
        for (int i = 2; i * i <= n; i++) {
            if (n % i == 0) {
                return false;
            }
        }
        return true;
    }

    /**
     * Sắp xếp các phần tử của ma trận theo thứ tự giảm dần.
     * @return ma trận có các phần tử là phần tử của ma trận ban đầu được sắp xếp theo thứ tự giảm dần.
     * Các phần tử được sắp xếp theo thứ tự từ trái sang phải ở mỗi hàng, và từ trên xuống dưới.
     */
    public MySquareMatrix getSortedMatrix() {
        /* TODO */
        int size = data.length;
        int[] flatArray = new int[size * size];
        int index = 0;
        for (int[] row : data) {
            for (int value : row) {
                flatArray[index++] = value;
            }
        }

        // Simple bubble sort in descending order
        for (int i = 0; i < flatArray.length - 1; i++) {
            for (int j = 0; j < flatArray.length - i - 1; j++) {
                if (flatArray[j] < flatArray[j + 1]) {
                    int temp = flatArray[j];
                    flatArray[j] = flatArray[j + 1];
                    flatArray[j + 1] = temp;
                }
            }
        }

        MySquareMatrix sortedMatrix = new MySquareMatrix(size);
        index = 0;
        for (int i = 0; i < size; i++) {
            for (int j = 0; j < size; j++) {
                sortedMatrix.set(i, j, flatArray[index++]);
            }
        }
        return sortedMatrix;
    }

    /**
     * Lấy giá trị phần tử ở vị trí (row, col).
     * @param row
     * @param col
     * @return
     */
    public int get(int row, int col) {
        /* TODO */
        return data[row][col];
    }

    /**
     * Sửa giá trị phần tử ở vị trí (row, col) thành value.
     * @param row
     * @param col
     * @param value
     */
    public void set(int row, int col, int value) {
        /* TODO */
        data[row][col] = value;
    }

    /**
     * Cộng ma trận hiện tại với một ma trận khác.
     * @param that
     * @return ma trận mới là ma trận tổng của 2 ma trận.
     */
    public MySquareMatrix add(MySquareMatrix that) {
        /* TODO */
        int size = this.data.length;
        MySquareMatrix result = new MySquareMatrix(size);
        for (int i = 0; i < size; i++) {
            for (int j = 0; j < size; j++) {
                result.set(i, j, this.get(i, j) + that.get(i, j));
            }
        }
        return result;
    }

    /**
     * Trừ ma trận hiện tại cho một ma trận khác.
     * @param that
     * @return ma trận mới là ma trận hiệu của ma trận hiện tại và ma trận truyền vào.
     */
    public MySquareMatrix minus(MySquareMatrix that) {
        /* TODO */
        int size = this.data.length;
        MySquareMatrix result = new MySquareMatrix(size);
        for (int i = 0; i < size; i++) {
            for (int j = 0; j < size; j++) {
                result.set(i, j, this.get(i, j) - that.get(i, j));
            }
        }
        return result;
    }

    /**
     * Nhân ma trận hiện tại với một ma trận khác.
     * @param that
     * @return ma trận mới là ma trận nhân của ma trận hiện tại với ma trận truyền vào.
     */
    public MySquareMatrix multiply(MySquareMatrix that) {
        /* TODO */
        int size = this.data.length;
        MySquareMatrix result = new MySquareMatrix(size);
        for (int i = 0; i < size; i++) {
            for (int j = 0; j < size; j++) {
                int sum = 0;
                for (int k = 0; k < size; k++) {
                    sum += this.get(i, k) * that.get(k, j);
                }
                result.set(i, j, sum);
            }
        }
        return result;
    }

    /**
     * Nhân ma trận với một số vô hướng.
     * @param value
     * @return ma trận mới là ma trận hiện tại được nhân với một số vô hướng.
     */
    public MySquareMatrix scaled(int value) {
        /* TODO */
        int size = data.length;
        MySquareMatrix result = new MySquareMatrix(size);
        for (int i = 0; i < size; i++) {
            for (int j = 0; j < size; j++) {
                result.set(i, j, this.get(i, j) * value);
            }
        }
        return result;
    }

    /**
     * Phương thức lấy ma trận chuyển vị.
     * @return ma trận mới là ma trận chuyển vị của ma trận hiện tại.
     */
    public MySquareMatrix transpose() {
        /* TODO */
        int size = data.length;
        MySquareMatrix result = new MySquareMatrix(size);
        for (int i = 0; i < size; i++) {
            for (int j = 0; j < size; j++) {
                result.set(i, j, this.get(j, i));
            }
        }
        return result;
    }

    /**
     * Mô tả ma trận theo định dạng biểu diễn ma trận, ví dụ
     *   1 2 3
     *   4 5 6
     *   7 8 9
     * @return một chuỗi mô tả ma trận.
     */
    @Override
    public String toString() {
        /* TODO */
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < data.length; i++) {
            for (int j = 0; j < data[i].length; j++) {
                sb.append(data[i][j]);
                if (j < data[i].length - 1) {
                    sb.append(" ");
                }
            }
            if (i < data.length - 1) {
                sb.append("\n");
            }
        }
        return sb.toString();
    }
}
