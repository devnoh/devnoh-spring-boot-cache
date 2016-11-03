package devnoh.demoapp.repository;

import devnoh.demoapp.domain.Book;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Component;

/**
 * Created by Sehwan Noh on 11/1/16.
 */
@Component
public class BookRepositoryImpl implements BookRepository {

    private static final Logger logger = LoggerFactory.getLogger(BookRepositoryImpl.class);

    @Override
    @Cacheable("books")
    public Book getByIsbn(String isbn) {
        logger.info("Loading a book with isbn '{}'...", isbn);
        simulateSlowService();
        return new Book(isbn, "Some book for " + isbn);
    }

    private void simulateSlowService() {
        try {
            long time = 3000L;
            Thread.sleep(time);
        } catch (InterruptedException e) {
            throw new IllegalStateException(e);
        }
    }
}
