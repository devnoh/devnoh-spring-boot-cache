package devnoh.demoapp.repository;

import devnoh.demoapp.domain.Book;

/**
 * Created by Sehwan Noh on 11/1/16.
 */
public interface BookRepository {

    Book getByIsbn(String isbn);

}
