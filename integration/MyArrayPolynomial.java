package hus.oop.integration;

public class MyArrayPolynomial extends MyAbstractPolynomial {
    private static final int DEFAULT_CAPACITY = 8;
    private double[] coefficents;
    private int size;

    /**
     * Khởi tạo dữ liệu mặc định.
     */
    public MyArrayPolynomial() {
        /* TODO */
        this.coefficents = new double[DEFAULT_CAPACITY];
        this.size = 0;
    }
    private MyArrayPolynomial(double[] newCoefficients) {
        this.coefficents = newCoefficients;
        this.size = newCoefficients.length;
    }

    @Override
    public double coefficient(int index) {
        /* TODO */
        if (index < 0 || index >= size) {
            return 0;
        }
        return coefficents[index];
    }

    @Override
    public double[] coefficients() {
        /* TODO */
        double[] result = new double[size];
        System.arraycopy(coefficents, 0, result, 0, size);
        return result;
    }

    @Override
    public MyArrayPolynomial append(double coefficient) {
        /* TODO */
        if (size == coefficents.length) {
            allocateMore();
        }
        coefficents[size] = coefficient;
        size++;
        return this;
    }

    @Override
    public MyArrayPolynomial add(double coefficient, int index) {
        /* TODO */
        if (index < 0 || index > size) {
            throw new IndexOutOfBoundsException();
        }
        if (size == coefficents.length) {
            allocateMore();
        }
        System.arraycopy(coefficents, index, coefficents, index + 1, size - index);
        coefficents[index] = coefficient;
        size++;
        return this;
    }

    @Override
    public MyArrayPolynomial set(double coefficient, int index) {
        /* TODO */
        if (index < 0 || index >= size) {
            throw new IndexOutOfBoundsException();
        }
        coefficents[index] = coefficient;
        return this;
    }

    @Override
    public int degree() {
        /* TODO */
        return size - 1;
    }

    @Override
    public double evaluate(double x) {
        /* TODO */
        double result = 0;
        for (int i = size - 1; i >= 0; i--) {
            result = result * x + coefficents[i];
        }
        return result;
    }

    @Override
    public MyArrayPolynomial derivative() {
        /* TODO */
        double[] derivCoeffs = differentiate();
        MyArrayPolynomial derivativePoly = new MyArrayPolynomial();
        for (double coeff : derivCoeffs) {
            derivativePoly.append(coeff);
        }
        return derivativePoly;
    }

    @Override
    public MyArrayPolynomial plus(MyPolynomial right) {
        /* TODO */
        int maxDegree = Math.max(this.degree(), right.degree());
        double[] resultCoeffs = new double[maxDegree + 1];
        for (int i = 0; i <= maxDegree; i++) {
            resultCoeffs[i] = this.coefficient(i) + right.coefficient(i);
        }
        return new MyArrayPolynomial(resultCoeffs);
    }

    @Override
    public MyArrayPolynomial minus(MyPolynomial right) {
        /* TODO */
        int maxDegree = Math.max(this.degree(), right.degree());
        double[] resultCoeffs = new double[maxDegree + 1];
        for (int i = 0; i <= maxDegree; i++) {
            resultCoeffs[i] = this.coefficient(i) - right.coefficient(i);
        }
        return new MyArrayPolynomial(resultCoeffs);
    }

    @Override
    public MyArrayPolynomial multiply(MyPolynomial right) {
        /* TODO */
        int resultDegree = this.degree() + right.degree();
        double[] resultCoeffs = new double[resultDegree + 1];
        for (int i = 0; i <= this.degree(); i++) {
            for (int j = 0; j <= right.degree(); j++) {
                resultCoeffs[i + j] += this.coefficient(i) * right.coefficient(j);
            }
        }
        return new MyArrayPolynomial(resultCoeffs);
    }

    /**
     * Tăng kích thước mảng lên gấp đôi để lưu đa thức khi cần thiết.
     */
    private void allocateMore() {
        /* TODO */
        double[] newCoefficients = new double[coefficents.length * 2];
        System.arraycopy(coefficents, 0, newCoefficients, 0, size);
        this.coefficents = newCoefficients;
    }
}
