package misc;

import java.util.HashMap;
import java.util.Map;

public class Libaray {

    private  int number_of_books;
    private String name;
    private Map<String,Integer> bookGenres;

    public Libaray() {
        bookGenres = new HashMap<String,Integer>();
    }

    public int getNumber_of_books() {
        return number_of_books;
    }

    public void setNumber_of_books(int number_of_books) {
        this.number_of_books = number_of_books;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Map<String, Integer> getBookGenres() {
        return bookGenres;
    }

    public void setBookGenres(Map<String, Integer> bookGenres) {
        this.bookGenres = bookGenres;
    }
}
