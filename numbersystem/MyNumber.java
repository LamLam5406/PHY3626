package hus.oop.numbersystem;

import java.util.ArrayList;
import java.util.List;

public class MyNumber {
    private int number;  // Số ban đầu trong hệ thập phân
    private List<NumberConverter> converters;  // Danh sách các converter theo observer pattern

    public MyNumber(int number) {
        /* TODO */
        this.number = number;
        this.converters = new ArrayList<>();
    }

    /*
     * Thêm vào converter để quan sát số ban đầu.
     * @param converter
     */
    public void addConverter(NumberConverter converter) {
        /* TODO */
        if (converter != null && !converters.contains(converter)) {
            converters.add(converter);
            // Optionally, update the new converter immediately
            // converter.update();
        }
    }

    /*
     * Hủy quan sát số ban đầu của converter.
     * @param converter
     */
    public void removeConverter(NumberConverter converter) {
        /* TODO */
        if (converter != null) {
            converters.remove(converter);
        }
    }

    /*
     * Khi có sự thay đổi trạng thái (biểu diễn số hoặc cơ số), thông báo cho tất cả
     * các converter đang ký quan sát để cập nhật lại trạng thái theo dữ liệu mới.
     */
    public void notifyConverters() {
        /* TODO */
        for (NumberConverter converter : converters) {
            converter.update();
        }
    }

    public void setNumber(int number) {
        /* TODO */
        if (this.number != number) { // Only notify if the number actually changes
            this.number = number;
            onStateChanged(); // Trigger notification process
        } else {
            // If the number is the same, we might still want to notify
            // in case the converters need to re-display or if the initial state wasn't set correctly.
            // However, typically Observer pattern notifies only on actual state change.
            // Let's adhere to notifying only on change. If initial display is needed,
            // it should happen upon registration or explicit call.
            // If you need to force display even if number is same, call notifyConverters() directly.
        }
    }

    public int getNumber() {
        /* TODO */
        return this.number;
    }

    /*
     * Được gọi khi có sự thay đổi về trạng thái (biểu diến số hoặc cơ số),
     * hàm này sẽ gọi hàm để thông báo cho tất cả các observer đang ký quan sát
     * cập nhật lại trạng thái.
     */
    private void onStateChanged() {
        /* TODO */
        notifyConverters();
    }
    public void displayAll() {
        System.out.println("\nOriginal number: " + this.number + "(10)");
        // Notify converters first to ensure they have the latest converted value
        // notifyConverters(); // Already called by setNumber if number changed. If called directly, uncomment.
        // Then tell each converter to display itself
        for (NumberConverter converter : converters) {
            converter.display();
        }
    }
}