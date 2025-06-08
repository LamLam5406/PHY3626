package hus.oop.integration;

public class IntegrationCalculator {
    private MyIntegrator integrator;
    private MyPolynomial poly;

    /**
     * Hàm dựng, khởi tạo đa thức cần tính tích phân.
     * @param poly
     */
    public IntegrationCalculator(MyPolynomial poly) {
        /* TODO */
        this.poly = poly;
        this.integrator = null;
    }

    /**
     * Hàm dựng, khởi tạo phương pháp tính tích phân và đa thức cần tính tích phân.
     * @param integrator
     * @param poly
     */
    public IntegrationCalculator(MyIntegrator integrator, MyPolynomial poly) {
        /* TODO */
        this.integrator = integrator;
        this.poly = poly;
    }

    public void setPoly(MyPolynomial poly) {
        /* TODO */
        this.poly = poly;
    }

    public void setIntegrator(MyIntegrator integrator) {
        /* TODO */
        this.integrator = integrator;
    }

    public double integrate(double lower, double upper) {
        /* TODO */
        if (integrator == null) {
            // Or throw new IllegalStateException("Integrator not set.");
            return Double.NaN;
        }
        return integrator.integrate(poly, lower, upper);
    }
}
