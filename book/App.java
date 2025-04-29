package hus.oop.book;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class App {
    private static final String COMMA_DELIMITER = ",";

    private static final BookManager bookManager = new BookManager();

    public static void main(String[] args) throws IOException {
        init();

        System.out.println("Kiểm tra dữ liệu gốc:");
        testOriginalData();
        System.out.println("\nKiểm tra sắp xếp tăng dần theo tiêu đề:");
        testSortIncreasingTitle();
        System.out.println("\nKiểm tra sắp xếp theo nhà xuất bản và giá:");
        testSortPublisherAndPrice();
        System.out.println("\nKiểm tra giá tăng dần:");
        testPriceOfBooksIncreasing();
        System.out.println("\nKiểm tra giá giảm dần:");
        testPriceOfBooksDecreasing();
        System.out.println("\nKiểm tra lọc theo tác giả:");
        testFilterBooksOfAuthor();
        System.out.println("\nKiểm tra lọc theo nhà xuất bản:");
        testFilterBooksOfPublisher();
        System.out.println("\nKiểm tra lọc theo thể loại:");
        testFilterBooksOfGenre();
        System.out.println("\nKiểm tra tổng số trang:");
        System.out.println("Tổng số trang: " + (int)testTotalPages());
        System.out.println("\nKiểm tra tổng giá:");
        System.out.printf("Tổng giá: %.2f\n", testTotalPrice());

        /* Yêu cầu:
        - Hoàn thiện code chương trình theo mẫu đã cho.
        - Viết code để test cho tất cả các hàm test bên dưới.

        - Thực hiện chạy từng hàm test theo format:
              Tên test:
              Kết quả chạy chương trình.

          Lưu kết quả chạy chương trình và file text được đặt tên
          là <TenSinhVien_MaSinhVien_BookManager>.txt (Ví dụ, NguyenVanA_123456_BookManager.txt).
        - Nén các file source code và file text kết quả chạy chương trình vào file zip có tên
          <TenSinhVien_MaSinhVien_BookManager>.zip (Ví dụ, NguyenVanA_123456_BookManager.zip),
          nộp lên classroom.
         */
    }

    public static void init() throws IOException {
        String filePath = "data/books.csv";
        readListData(filePath);
    }

    public static void readListData(String filePath) throws IOException {
        BufferedReader dataReader = new BufferedReader(new FileReader(filePath));
        String line;
        dataReader = new BufferedReader(new FileReader(filePath));

        dataReader.readLine();

        while ((line = dataReader.readLine()) != null) {
            List<String> dataList = parseDataLineToList(line);

            String title = dataList.get(0).trim();
            String author = dataList.get(1).trim();
            String genre = dataList.get(2).trim();
            String pagesStr = dataList.get(3).trim();
            String priceStr = dataList.get(4).trim();
            String publisher = dataList.get(5).trim();

            int pages;
            double price;
            try {
                pages = Integer.parseInt(pagesStr);
                price = Double.parseDouble(priceStr);
            } catch (NumberFormatException e) {
                System.err.println("Skipping invalid line (error parsing number): " + line + " - Error: " + e.getMessage());
                continue; // Skip lines with invalid number formats
            }

            Book newBook = new Book.BookBuilder(title)
                    .withAuthor(author)
                    .withGenre(genre)
                    .withPages(pages)
                    .withPrice(price)
                    .withPublisher(publisher)
                    .build();

            bookManager.append(newBook);
        }

        if (dataReader != null) {
            dataReader.close();
        }
    }

    public static List<String> parseDataLineToList(String dataLine) {
        List<String> result = new ArrayList<>();
        if (dataLine != null) {
            String[] splitData = dataLine.split(COMMA_DELIMITER);
            for (int i = 0; i < splitData.length; i++) {
                result.add(splitData[i]);
            }
        }
        return result;
    }

    public static String[] parseDataLineToArray(String dataLine) {
        if (dataLine == null) {
            return null;
        }
        return dataLine.split(COMMA_DELIMITER);
    }

    /**
     * Test: In ra danh sách book theo thứ tự đọc vào ban đầu.
     */
    public static void testOriginalData() {
        /* TODO */
        BookManager.print(bookManager.getBookList());
    }

    /**
     * Test: In ra danh sách book theo thứ tự tăng dần của title.
     */
    public static void testSortIncreasingTitle() {
        /* TODO */
        List<Book> sortedBooks = bookManager.sortIncreasingByTitle();
        BookManager.print(sortedBooks);
    }

    /**
     * Test: In ra book sắp xếp theo tiêu chí: publisher tăng dần, sau đó price giảm dần.
     */
    public static void testSortPublisherAndPrice() {
        /* TODO */
        List<Book> sortedBooks = bookManager.sortByPublisherAndPrice();
        BookManager.print(sortedBooks);
    }

    /**
     * Test: In ra danh sách book theo giá tăng dần.
     * Mỗi book được in trên 1 dòng theo format book được định nghĩa trong trong hàm toString() của Book.
     */
    public static void testPriceOfBooksIncreasing() {
        /* TODO */
        List<Book> sortedBooks = bookManager.sortIncreasingPrice();
        BookManager.print(sortedBooks);
    }

    /**
     * Test: In ra danh sách book theo giá giảm dần.
     * Mỗi book được in trên 1 dòng theo format book được định nghĩa trong trong hàm toString() của Book.
     */
    public static void testPriceOfBooksDecreasing() {
        /* TODO */
        List<Book> sortedBooks = bookManager.sortDecreasingPrice();
        BookManager.print(sortedBooks);
    }

    /**
     * Test: In ra danh sách book theo tác giả.
     * Mỗi book được in trên 1 dòng theo format book được định nghĩa trong trong hàm toString() của Book.
     */
    public static void testFilterBooksOfAuthor() {
        /* TODO */
        String authorToFilter = "Hawking Stephen";
        System.out.println("Lọc theo tác giả: " + authorToFilter);
        List<Book> filteredBooks = bookManager.filterBooksOfAuthor(authorToFilter);
        BookManager.print(filteredBooks);
    }

    /**
     * Test: In ra danh sách book theo nhà xuất bản.
     * Mỗi book được in trên 1 dòng theo format book được định nghĩa trong trong hàm toString() của Book.
     */
    public static void testFilterBooksOfPublisher() {
        /* TODO */
        String publisherToFilter = "Penguin";
        System.out.println("Lọc theo nhà xuất bản: " + publisherToFilter);
        List<Book> filteredBooks = bookManager.filterBooksOfPublisher(publisherToFilter);
        BookManager.print(filteredBooks);
    }

    /**
     * Test: In ra danh sách book theo thể loại.
     * Mỗi book được in trên 1 dòng theo format book được định nghĩa trong trong hàm toString() của Book.
     */
    public static void testFilterBooksOfGenre() {
        /* TODO */
        String genreToFilter = "history";
        System.out.println("Lọc theo thể loại: " + genreToFilter);
        List<Book> filteredBooks = bookManager.filterBooksOfGenre(genreToFilter);
        BookManager.print(filteredBooks);
    }

    /**
     * In ra tổng số trang của tất cả các book.
     */
    public static double testTotalPages() {
        /* TODO */
        return bookManager.totalPages();
    }

    /**
     * In ra tổng giá của tất cả các sách.
     */
    public static double testTotalPrice() {
        /* TODO */
        return bookManager.totalPrice();
    }
}
