package hus.oop.integration;

public class TestIntegrationCalculator {
    private MyPolynomial polynomial;

    public TestIntegrationCalculator(MyPolynomial polynomial) {
        this.polynomial = polynomial;
    }

    public static void main(String[] args) {
        /* TODO
         - Thực hiện các yêu cầu trong từng hàm test.
         - Lưu kết quả chạy chương trình vào file text có tên <TenSinhVien_MaSinhVien_Integration>.txt
           (ví dụ, NguyenVanA_123456_Integration.txt)
         - Nộp file kết quả chạy chương trình (file text trên) cùng với các file source code.
         */
        TestIntegrationCalculator testIntegrationCalculator = new TestIntegrationCalculator(null);
        System.out.println("--- Testing Array Polynomial ---");
        testIntegrationCalculator.testArrayPolynomial();
        System.out.println("\n--- Testing List Polynomial ---");
        testIntegrationCalculator.testListPolynomial();
    }

    public void testArrayPolynomial() {
        /* TODO
         - Sinh ngẫu nhiên một số nguyên, lưu vào biến size. Sinh ngẫu nhiên size số thực. Tạo đa thức kiểu MyArrayPolynomial
           với các hệ số là các số thực vừa sinh ra, lưu vào biến polynomial.
         - Viết chương trình test các chức năng đa thức (thêm phần tử vào đa thức, xóa phần tử trong đa thức,
           sửa hệ số tại một phần tử, cộng 2 đa thức, trừ 2 đa thức, nhân 2 đa thức, tính giá trị của đa thức khi biết
           giá trị của x).
         - Tính tích phân xác định của đa thức được tạo ban đầu với các cận tích phân là 1.0 và 5.0.
         */
        int size = (int) (Math.random() * 3) + 2; // Random size from 2 to 4 for readability
        MyArrayPolynomial polynomial = new MyArrayPolynomial();
        System.out.println("Generating a polynomial with " + size + " coefficients.");
        for (int i = 0; i < size; i++) {
            polynomial.append(Math.round((Math.random() * 10) * 10.0) / 10.0); // Random coeffs 0-10
        }
        System.out.println("Initial Polynomial (P1): " + polynomial);
        System.out.println("Degree of P1: " + polynomial.degree());

        // Test functions
        polynomial.set(5.5, 1);
        System.out.println("After setting coefficient at index 1 to 5.5: " + polynomial);

        MyArrayPolynomial polynomial2 = new MyArrayPolynomial();
        polynomial2.append(1.1).append(2.2);
        System.out.println("Second Polynomial (P2): " + polynomial2);

        System.out.println("P1 + P2: " + polynomial.plus(polynomial2));
        System.out.println("P1 - P2: " + polynomial.minus(polynomial2));
        System.out.println("P1 * P2: " + polynomial.multiply(polynomial2));

        double x = 2.0;
        System.out.println("Value of P1 at x = " + x + ": " + polynomial.evaluate(x));
        System.out.println("Derivative of P1: " + polynomial.derivative());

        // Integration part
        System.out.println("\n--- Integration of P1 from 1.0 to 5.0 ---");
        IntegrationCalculator calculator = new IntegrationCalculator(polynomial);

        MyIntegrator trap = new TrapezoidRule(1e-6, 100);
        calculator.setIntegrator(trap);
        System.out.println("Using Trapezoid Rule: " + calculator.integrate(1.0, 5.0));

        MyIntegrator simp = new SimpsonRule(1e-6, 100);
        calculator.setIntegrator(simp);
        System.out.println("Using Simpson's Rule: " + calculator.integrate(1.0, 5.0));
    }

    public void testListPolynomial() {
        /* TODO
         - Sinh ngẫu nhiên một số nguyên, lưu vào biến size. Sinh ngẫu nhiên size số thực. Tạo đa thức kiểu MyListPolynomial
           với các hệ số là các số thực vừa sinh ra, lưu vào biến polynomial.
         - Viết chương trình test các chức năng đa thức (thêm phần tử vào đa thức, xóa phần tử trong đa thức,
           sửa hệ số tại một phần tử, cộng 2 đa thức, trừ 2 đa thức, nhân 2 đa thức, tính giá trị của đa thức khi biết
           giá trị của x).
         - Tính tích phân xác định của đa thức được tạo ban đầu với các cận tích phân là 2.0 và 6.0.
         */
        int size = (int) (Math.random() * 3) + 2; // Random size from 2 to 4
        MyListPolynomial polynomial = new MyListPolynomial();
        System.out.println("Generating a polynomial with " + size + " coefficients.");
        for (int i = 0; i < size; i++) {
            polynomial.append(Math.round((Math.random() * 10) * 10.0) / 10.0);
        }
        System.out.println("Initial Polynomial (P1): " + polynomial);
        System.out.println("Degree of P1: " + polynomial.degree());

        // Test functions
        polynomial.set(8.8, 0);
        System.out.println("After setting coefficient at index 0 to 8.8: " + polynomial);

        MyListPolynomial polynomial2 = new MyListPolynomial();
        polynomial2.append(3.3).append(4.4);
        System.out.println("Second Polynomial (P2): " + polynomial2);

        System.out.println("P1 + P2: " + polynomial.plus(polynomial2));
        System.out.println("P1 - P2: " + polynomial.minus(polynomial2));
        System.out.println("P1 * P2: " + polynomial.multiply(polynomial2));

        double x = 3.0;
        System.out.println("Value of P1 at x = " + x + ": " + polynomial.evaluate(x));
        System.out.println("Derivative of P1: " + polynomial.derivative());

        // Integration part
        System.out.println("\n--- Integration of P1 from 2.0 to 6.0 ---");
        IntegrationCalculator calculator = new IntegrationCalculator(polynomial);

        MyIntegrator mid = new MidpointRule(1e-6, 100);
        calculator.setIntegrator(mid);
        System.out.println("Using Midpoint Rule: " + calculator.integrate(2.0, 6.0));

        MyIntegrator simp = new SimpsonRule(1e-6, 100);
        calculator.setIntegrator(simp);
        System.out.println("Using Simpson's Rule: " + calculator.integrate(2.0, 6.0));
    }
}
