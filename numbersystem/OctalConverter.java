package hus.oop.numbersystem;

public class OctalConverter extends AbstractNumberConverter {
    public OctalConverter(MyNumber originalNumber) {
        /* TODO */
        super(originalNumber);
    }

    /*
     * Chuyển đổi một số được biểu diễn trong hệ cơ số 10
     * sang số được biểu diễn trong hệ cơ số 8.
     * @param decimal
     * @return xâu ký tự biểu diễn số trong hệ cơ số 8.
     *
     * Yêu cầu: sử dụng thuật toán Euclid để chuyển đổi,
     * không sử dụng thư viện chuyển đổi số có sẵn của Java.
     */
    @Override
    public void decimalTo(int decimal) {
        convertedNumber = new MyStack(); // Khởi tạo mới stack kết quả

        if (decimal == 0) {
            convertedNumber.push(0);
            return;
        }

        int num = decimal;
        while (num > 0) {
            int remainder = num % 8;
            convertedNumber.push(remainder);
            num /= 8;
        }
    }


    /*
     * Cập nhật số được chuyển đổi khi số ban đầu thay đổi
     * hoặc cơ số của số ban đầu thay đổi. Sau đó in ra terminal 
     * số được chuyển đổi theo định dạng a1a2...an(8).
     */
    @Override
    public void update() {
        /* TODO */
        super.update();
    }

    /*
     * Hiển thị số ra terminal theo định dạng a1a2...an(8).
     */
    @Override
    public void display() {
        System.out.println(getConvertedNumber() + "(8)");
    }
}
