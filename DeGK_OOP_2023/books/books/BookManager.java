package hus.oop.midterm.books;

public class BookManager {
    private MyList books;

    /**
     * Khởi tạo dữ liệu cho BookManager.
     */
    public BookManager(MyList data) {
        /* TODO */
    }

    /**
     * Lấy ra danh sách các sách được sắp xếp theo thứ tự title.
     * Chú ý, không thay đổi thứ tự sách trong danh sách gốc.
     * @param order
     * @return danh sách các sách đã được sắp xếp.
     */
    public MyList sortByTitle(boolean order) {
        /*
         TODO

         - Sửa lại lớp Book để sử dụng BookComparable để thực hiện việc so sánh các Book theo title.

         - Sử dụng tiêu chí so sánh trong BookComparable, viết code để sắp xếp danh sách các sách theo thứ tự
           phụ thuộc tham số order. Nếu order là true thì sắp xệp theo thứ tự tăng dần. Nếu order là false thì
           sắp xếp theo thứ tự giảm dần.

         - Trả ra danh sách mới các sách đã được sắp thứ tự.
         */
    }

    /**
     * Lấy ra danh sách các sách được sắp xếp theo pages.
     * Chú ý, không thay đổi thứ tự sách trong danh sách gốc.
     * @param order
     * @return danh sách các sách đã được sắp xếp.
     */
    public MyList sortByPageNumber(boolean order) {
        /*
         TODO

         - Thêm lớp PageComparison sử dụng BookComparator để có thể so sánh các sách theo pages.

         - Viết code sử dụng PageComparison để sắp xếp sách theo thứ tự phụ thuộc tham số order.
           Nếu order là true thì sắp xệp theo thứ tự tăng dần. Nếu order là false thì sắp xếp theo thứ tự giảm dần.

         - Trả ra danh sách mới các sách đã được sắp xếp.
         */
    }
}
