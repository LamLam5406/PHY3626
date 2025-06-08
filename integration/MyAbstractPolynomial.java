package hus.oop.integration;

public abstract class MyAbstractPolynomial implements MyPolynomial {
    /**
     * Mô tả đa thức theo định dạng [a0 + a1x + a2x^2 + ... + anx^n]
     * @return String mô tả về đa thức.
     */
    @Override
    public String toString() {
        /* TODO */
        double[] coeffs = coefficients();
        if (coeffs.length == 0) {
            return "[]";
        }

        StringBuilder sb = new StringBuilder();
        sb.append("[");

        for (int i = 0; i < coeffs.length; i++) {
            if (coeffs[i] != 0) {
                // Append sign for non-first terms
                if (sb.length() > 1) {
                    if (coeffs[i] > 0) {
                        sb.append(" + ");
                    } else {
                        sb.append(" - ");
                    }
                }

                double absCoeff = Math.abs(coeffs[i]);

                // Append coefficient if it's not 1 or if it's the constant term
                if (absCoeff != 1 || i == 0) {
                    sb.append(absCoeff);
                }

                // Append variable part
                if (i > 0) {
                    sb.append("x");
                    if (i > 1) {
                        sb.append("^").append(i);
                    }
                }
            }
        }

        if (sb.length() == 1) { // Only contains "["
            return "[0.0]";
        }

        sb.append("]");
        return sb.toString();
    }

    /**
     * Lấy đạo hàm đa thức.
     * @return mảng các phần tử là hệ số của đa thức đạo hàm.
     */
    public double[] differentiate() {
        /* TODO */
        int degree = degree();
        if (degree < 1) {
            return new double[0];
        }
        double[] currentCoeffs = coefficients();
        double[] derivCoeffs = new double[degree];
        for (int i = 0; i < degree; i++) {
            derivCoeffs[i] = currentCoeffs[i + 1] * (i + 1);
        }
        return derivCoeffs;
    }
}
