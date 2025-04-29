package hus.oop.book;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class BookManager {
    private List<Book> bookList;

    public BookManager() {
        /* TODO */
        this.bookList = new ArrayList<>();
    }

    public List<Book> getBookList() {
        return bookList;
    }

    public void append(Book book) {
        /* TODO */
        bookList.add(book);
    }

    public void insertAtPosition(Book book, int index) {
        /* TODO */
        bookList.add(index, book);
    }

    public void remove(int index) {
        /* TODO */
        bookList.remove(index);
    }

    public Book bookAt(int index) {
        /* TODO */
        return bookList.get(index);
    }

    public int numberOfBooks() {
        /* TODO */
        return bookList.size();
    }

    public double totalPrice() {
        /* TODO */
        double sum = 0;
        for (Book book : bookList) {
            sum += book.getPrice();
        }
        return sum;
    }

    public double totalPages() {
        /* TODO */
        int sum = 0;
        for (Book book : bookList) {
            sum += book.getPages();
        }
        return (double)sum;
    }

    /**
     * Sắp xếp sách tăng dần theo title.
     * @return List<Book> collection of books sorted by title ascending.
     */
    public List<Book> sortIncreasingByTitle() {
        /* TODO */
        List<Book> sorted = new ArrayList<>(bookList);
        sorted.sort((o1, o2) -> o1.getTitle().compareTo(o2.getTitle()));// Relies on Book.compareTo()
        return sorted;
    }

    /**
     * Sắp xếp sách theo tiêu chí, publisher tăng dần, price giảm dần.
     * @return List<Book> collection of books sorted by publisher and price.
     */
    public List<Book> sortByPublisherAndPrice() {
        /* TODO */
        List<Book> sorted = new ArrayList<>(bookList);
        MyBookComparator comparatorLogic = new MyBookComparator() {
            @Override
            public int compare(Book left, Book right) {
                int pubCompare = left.getPublisher().compareToIgnoreCase(right.getPublisher());
                if (pubCompare != 0) {
                    return pubCompare;
                } else {
                    return Double.compare(right.getPrice(), left.getPrice()); // Descending price
                }
            }
        };

        Collections.sort(sorted, new Comparator<Book>() {
            @Override
            public int compare(Book b1, Book b2) {
                return comparatorLogic.compare(b1, b2);
            }
        });
        return sorted;
    }

    /**
     * Sắp xếp sách theo giá tăng dần.
     * @return List<Book> collection of books sorted by price ascending.
     */
    public List<Book> sortIncreasingPrice() {
        /* TODO */
        List<Book> sorted = new ArrayList<>(bookList);
        MyBookComparator comparatorLogic = new MyBookComparator() {
            @Override
            public int compare(Book left, Book right) {
                return Double.compare(left.getPrice(), right.getPrice()); // Ascending price
            }
        };
        Collections.sort(sorted, new Comparator<Book>() {
            @Override
            public int compare(Book b1, Book b2) {
                return comparatorLogic.compare(b1, b2);
            }
        });
        return sorted;
    }

    /**
     * Sắp xếp sách theo giá giảm dần.
     * @return List<Book> collection of books sorted by price descending.
     */
    public List<Book> sortDecreasingPrice() {
        /* TODO */
        List<Book> sorted = new ArrayList<>(bookList);
        MyBookComparator comparatorLogic = new MyBookComparator() {
            @Override
            public int compare(Book left, Book right) {
                return Double.compare(right.getPrice(), left.getPrice()); // Descending price
            }
        };
        Collections.sort(sorted, new Comparator<Book>() {
            @Override
            public int compare(Book b1, Book b2) {
                return comparatorLogic.compare(b1, b2);
            }
        });
        return sorted;
    }

    /**
     * Lọc ra những sách theo genre.
     * @param genre
     * @return List<Book>
     */
    public List<Book> filterBooksOfGenre(String genre) {
        /* TODO */
        List<Book> result = new ArrayList<>();
        for (Book book : bookList) {
            if (book.getGenre().equalsIgnoreCase(genre.trim())) {
                result.add(book);
            }
        }
        return result;
    }

    /**
     * Lọc ra những sách theo tác giả.
     * @param author
     * @return List<Book>
     */
    public List<Book> filterBooksOfAuthor(String author) {
        /* TODO */
        List<Book> result = new ArrayList<>();
        for (Book book : bookList) {
            if (book.getAuthor().equalsIgnoreCase(author.trim())) {
                result.add(book);
            }
        }
        return result;
    }

    /**
     * Lọc ra những sách theo nhà xuất bản.
     * @param publisher
     * @return List<Book>
     */
    public List<Book> filterBooksOfPublisher(String publisher) {
        /* TODO */
        List<Book> result = new ArrayList<>();
        for (Book book : bookList) {
            if (book.getPublisher().equalsIgnoreCase(publisher.trim())) {
                result.add(book);
            }
        }
        return result;
    }

    /**
     * Lấy ra danh sách các sách được thêm vào cuối cùng.
     * @param
     * @return List<Book>
     */

    public static String titleOfBooksToString(List<Book> bookList) {
        StringBuilder titleOfBooks = new StringBuilder();
        titleOfBooks.append("[\n");
        for (Book book : bookList) {
            titleOfBooks.append(book.getTitle()).append("\n"); // Original format from snippet
        }
        return titleOfBooks.toString().trim() + "\n]";
    }

    public static void print(List<Book> bookList) {
        StringBuilder booksString = new StringBuilder();
        booksString.append("[\n");
        for (Book book : bookList) {
            booksString.append(book.toString()).append("\n"); // Original format from snippet
        }
        booksString.append("]");
        System.out.println(booksString.toString());
    }
}