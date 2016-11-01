package devnoh.demoapp;

/**
 * Created by Sehwan Noh on 11/1/16.
 */
public interface BookRepository {

    Book getByIsbn(String isbn);

}
