package hus.oop.numbersystem;

public class BinaryConverter extends AbstractNumberConverter {
    public BinaryConverter(MyNumber originalNumber) {
        /* TODO */
        super(originalNumber);
    }

    /*
     * Chuyển đổi một số được biểu diễn trong hệ cơ số 10
     * sang số được biểu diễn trong hệ cơ số 2.
     * @param decimal
     * @return xâu ký tự biểu diễn số trong hệ cơ số 2.
     *
     * Yêu cầu: sử dụng thuật toán Euclid để chuyển đổi,
     * không sử dụng thư viện chuyển đổi số có sẵn của Java.
     */
    @Override
    public void decimalTo(int decimal) {
        convertedNumber = new MyStack(); // Reset stack trước khi thêm mới

        if (decimal == 0) {
            convertedNumber.push(0);
            return;
        }

        int num = decimal;
        while (num > 0) {
            int remainder = num % 2;
            convertedNumber.push(remainder);
            num /= 2;
        }

        // Sau vòng lặp, các chữ số nhị phân đã được lưu trong convertedNumber theo thứ tự ngược,
        // nhưng nếu bạn cần hiển thị đúng thứ tự, nên đảo ngược trong getConvertedNumber().
    }


    /*
     * Cập nhật số được chuyển đổi khi số ban đầu thay đổi
     * hoặc cơ số của số ban đầu thay đổi. Sau đó in ra terminal
     * số được chuyển đổi theo định dạng a1a2...an(2).
     */
    @Override
    public void update() {
        /* TODO */
        super.update();
    }

    /*
     * Hiển thị số ra terminal theo định dạng a1a2...an(2).
     */
    @Override
    public void display() {
        System.out.println(getConvertedNumber() + "(2)");
    }
}
