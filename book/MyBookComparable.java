package hus.oop.book;

public interface MyBookComparable extends Comparable<Book> {
    @Override
    int compareTo(Book another);
}
