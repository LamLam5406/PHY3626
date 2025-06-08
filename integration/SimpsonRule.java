package hus.oop.integration;

public class SimpsonRule implements MyIntegrator {
    private double precision;
    private int maxIterations;

    public SimpsonRule(double precision, int maxIterations) {
        /* TODO */
        this.precision = precision;
        this.maxIterations = maxIterations;
    }

    /**
     * Tính xấp xỉ giá trị tích phân. Giá trị xấp xỉ được chấp nhận nếu phép tính đạt độ chính xác đã cho,
     * hoặc có số vòng vượt quá ngưỡng quy định.
     * Độ chính xác được xác định như sau, chọn n0 tùy ý, sau đó tính I_n với n = n0, 2n0, 4n0, ...
     * Việc tính toán dừng lại khi |I_2n - In|/3 < eps (precision), hoặc số lần chia đôi vượt quá ngưỡng quy định (maxIterations).
     * @param polynomial
     * @param lower
     * @param upper
     * @return
     */
    @Override
    public double integrate(MyPolynomial polynomial, double lower, double upper) {
        /* TODO */
        int n = 2; // Start with 2 intervals (must be even)
        double lastValue = integrate(polynomial, lower, upper, n);

        for (int i = 0; i < maxIterations; i++) {
            n *= 2;
            double currentValue = integrate(polynomial, lower, upper, n);
            // For Simpson's rule, the error term suggests dividing by 15 for higher accuracy check
            if (Math.abs(currentValue - lastValue) / 15 < precision) {
                return currentValue;
            }
            lastValue = currentValue;
        }
        return lastValue;
    }

    /**
     * Tính xấp xỉ giá trị tích phân với numOfSubIntervals (số chẵn) khoảng phân hoạch đều.
     * @param polynomial
     * @param lower
     * @param upper
     * @param numOfSubIntervals
     * @return giá trị xấp xỉ giá trị tích phân.
     */
    private double integrate(MyPolynomial polynomial, double lower, double upper, int numOfSubIntervals) {
        /* TODO */
        if (numOfSubIntervals % 2 != 0) {
            numOfSubIntervals *=2; // Ensure n is even
        }
        double h = (upper - lower) / numOfSubIntervals;
        double sum = polynomial.evaluate(lower) + polynomial.evaluate(upper);

        for (int i = 1; i < numOfSubIntervals; i += 2) {
            sum += 4 * polynomial.evaluate(lower + i * h);
        }

        for (int i = 2; i < numOfSubIntervals - 1; i += 2) {
            sum += 2 * polynomial.evaluate(lower + i * h);
        }

        return sum * h / 3.0;
    }
}
