package hus.oop.numbersystem;

public abstract class AbstractNumberConverter implements NumberConverter {
    protected MyNumber originalNumber;   // Số gốc
    protected MyStack convertedNumber;   // Số được chuyển đổi theo cơ số nào đó từ số gốc

    public AbstractNumberConverter(MyNumber originalNumber) {
        if (originalNumber == null) {
            throw new IllegalArgumentException("Original number cannot be null.");
        }
        this.originalNumber = originalNumber;
        this.convertedNumber = new MyStack(); // Khởi tạo một stack rỗng
        this.originalNumber.addConverter(this); // Đăng ký converter
        update(); // Thực hiện chuyển đổi ban đầu
    }

    /*
     * Chuyển đổi số decimal từ hệ cơ số 10 thành số có hệ cơ số nào đó.
     * @param decimal Số nguyên dương ở hệ 10.
     *
     * Yêu cầu: sử dụng thuật toán Euclid để chuyển đổi,
     * không sử dụng thư viện có sẵn của Java.
     */
    public abstract void decimalTo(int decimal);

    @Override
    public void update() {
        int numberToConvert = originalNumber.getNumber();
        decimalTo(numberToConvert);
    }

    /**
     * Abstract method để hiển thị số đã chuyển đổi, ví dụ: "1101(2)".
     */
    @Override
    public abstract void display();

    /**
     * Trả về số đã chuyển đổi thành chuỗi.
     * @return xâu ký tự biểu diễn số đã chuyển đổi.
     */
    public String getConvertedNumber() {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < convertedNumber.size(); i++) {
            sb.append(convertedNumber.get(i));
        }
        return sb.toString();
    }
}
