package hus.oop.matrix;

public class TestMatrix {
    public static void main(String[] args) {
        /* TODO
        Tạo ra 2 ma trận có cùng kích thước là một số ngẫu nhiên nằm trong đoạn [5, 10].
        Viết code thực hiện test các chức năng sau của các ma trận:
          - In ra 2 ma trận và 2 ma trận chuyển vị tương ứng.
          - In ra các đường chéo chính và đường chéo phụ của 2 ma trận.
          - In ra ma trận là ma trận tổng của 2 ma trận.
          - In ra ma trận là ma trận là hiệu của ma trận thứ nhất cho ma trận thứ 2.
          - In ra ma trận là ma trận tích của 2 ma trận.
          - In ra các số nguyên tố có trong 2 ma trận.

         Lưu kết quả chạy chương trình trên terminal vào file text và nộp cùng source code chương trình.
         File text kết quả được đặt tên như sau: <TenSinhVien_MaSinhVien_Matrix.txt> (Ví dụ, NguyenVanA_123456_Matrix.txt).
         */

        // Create 2 matrices with the same random size between 5 and 10
        int size = (int) (Math.random() * 6) + 5;
        System.out.println("Generated matrix size: " + size + "x" + size);
        System.out.println("---------------------------------");

        MySquareMatrix matrix1 = new MySquareMatrix(size);
        MySquareMatrix matrix2 = new MySquareMatrix(size);

        // Print the two matrices and their transposes
        System.out.println("Matrix 1:");
        System.out.println(matrix1);
        System.out.println("\nTranspose of Matrix 1:");
        System.out.println(matrix1.transpose());
        System.out.println("\n---------------------------------");

        System.out.println("Matrix 2:");
        System.out.println(matrix2);
        System.out.println("\nTranspose of Matrix 2:");
        System.out.println(matrix2.transpose());
        System.out.println("\n---------------------------------");

        // Print the principal and secondary diagonals
        System.out.println("Diagonals of Matrix 1:");
        System.out.print("Principal: ");
        printArray(matrix1.principalDiagonal());
        System.out.print("Secondary: ");
        printArray(matrix1.secondaryDiagonal());
        System.out.println("\n---------------------------------");

        System.out.println("Diagonals of Matrix 2:");
        System.out.print("Principal: ");
        printArray(matrix2.principalDiagonal());
        System.out.print("Secondary: ");
        printArray(matrix2.secondaryDiagonal());
        System.out.println("\n---------------------------------");


        // Print the sum of the two matrices
        System.out.println("Sum (Matrix 1 + Matrix 2):");
        System.out.println(matrix1.add(matrix2));
        System.out.println("\n---------------------------------");

        // Print the difference of the two matrices
        System.out.println("Difference (Matrix 1 - Matrix 2):");
        System.out.println(matrix1.minus(matrix2));
        System.out.println("\n---------------------------------");

        // Print the product of the two matrices
        System.out.println("Product (Matrix 1 * Matrix 2):");
        System.out.println(matrix1.multiply(matrix2));
        System.out.println("\n---------------------------------");

        // Print prime numbers from both matrices
        System.out.println("Prime numbers in Matrix 1:");
        printArray(matrix1.primes());
        System.out.println("\nPrime numbers in Matrix 2:");
        printArray(matrix2.primes());
    }
    private static void printArray(int[] arr) {
        if (arr == null) {
            System.out.println("null");
            return;
        }
        if (arr.length == 0) {
            System.out.println("[]");
            return;
        }

        StringBuilder sb = new StringBuilder();
        sb.append("[");
        for (int i = 0; i < arr.length; i++) {
            sb.append(arr[i]);
            if (i < arr.length - 1) {
                sb.append(", ");
            }
        }
        sb.append("]");
        System.out.println(sb.toString());
    }
}
