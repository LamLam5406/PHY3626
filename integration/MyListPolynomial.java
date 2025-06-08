package hus.oop.integration;

import java.util.ArrayList;
import java.util.List;

public class MyListPolynomial extends MyAbstractPolynomial {
    private List<Double> coefficients;

    /**
     * Khởi tạo dữ liệu mặc định.
     */
    public MyListPolynomial() {
        /* TODO */
        this.coefficients = new ArrayList<>();
    }
    private MyListPolynomial(List<Double> coefficients) {
        this.coefficients = coefficients;
    }

    @Override
    public double coefficient(int index) {
        /* TODO */
        if (index < 0 || index >= coefficients.size()) {
            return 0;
        }
        return coefficients.get(index);
    }

    @Override
    public double[] coefficients() {
        /* TODO */
        double[] coeffs = new double[coefficients.size()];
        for (int i = 0; i < coefficients.size(); i++) {
            coeffs[i] = coefficients.get(i);
        }
        return coeffs;
    }

    @Override
    public MyListPolynomial append(double coefficient) {
        /* TODO */
        coefficients.add(coefficient);
        return this;
    }

    @Override
    public MyListPolynomial add(double coefficient, int index) {
        /* TODO */
        if (index < 0 || index > coefficients.size()) {
            throw new IndexOutOfBoundsException();
        }
        coefficients.add(index, coefficient);
        return this;
    }

    @Override
    public MyListPolynomial set(double coefficient, int index) {
        /* TODO */
        if (index < 0 || index >= coefficients.size()) {
            throw new IndexOutOfBoundsException();
        }
        coefficients.set(index, coefficient);
        return this;
    }

    @Override
    public int degree() {
        /* TODO */
        return coefficients.size() - 1;
    }

    @Override
    public double evaluate(double x) {
        /* TODO */
        double result = 0;
        for (int i = degree(); i >= 0; i--) {
            result = result * x + coefficient(i);
        }
        return result;
    }

    @Override
    public MyListPolynomial derivative() {
        /* TODO */
        double[] derivCoeffs = differentiate();
        List<Double> newCoeffsList = new ArrayList<>();
        for (double coeff : derivCoeffs) {
            newCoeffsList.add(coeff);
        }
        return new MyListPolynomial(newCoeffsList);
    }

    @Override
    public MyListPolynomial plus(MyPolynomial right) {
        /* TODO */
        int maxDegree = Math.max(this.degree(), right.degree());
        List<Double> resultCoeffs = new ArrayList<>();
        for (int i = 0; i <= maxDegree; i++) {
            resultCoeffs.add(this.coefficient(i) + right.coefficient(i));
        }
        return new MyListPolynomial(resultCoeffs);
    }

    @Override
    public MyListPolynomial minus(MyPolynomial right) {
        /* TODO */
        int maxDegree = Math.max(this.degree(), right.degree());
        List<Double> resultCoeffs = new ArrayList<>();
        for (int i = 0; i <= maxDegree; i++) {
            resultCoeffs.add(this.coefficient(i) - right.coefficient(i));
        }
        return new MyListPolynomial(resultCoeffs);
    }

    @Override
    public MyListPolynomial multiply(MyPolynomial right) {
        /* TODO */
        int resultDegree = this.degree() + right.degree();
        List<Double> resultCoeffs = new ArrayList<>();
        for(int i = 0; i <= resultDegree; i++) {
            resultCoeffs.add(0.0);
        }

        for (int i = 0; i <= this.degree(); i++) {
            for (int j = 0; j <= right.degree(); j++) {
                resultCoeffs.set(i + j, resultCoeffs.get(i + j) + this.coefficient(i) * right.coefficient(j));
            }
        }
        return new MyListPolynomial(resultCoeffs);
    }
}
