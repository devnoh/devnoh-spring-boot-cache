package devnoh.demoapp;

import devnoh.demoapp.repository.BookRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.cache.CacheManager;
import org.springframework.stereotype.Component;

/**
 * Created by Sehwan Noh on 11/1/16.
 */
@Component
public class BookCacheRunner implements CommandLineRunner {

    private static final Logger logger = LoggerFactory.getLogger(BookCacheRunner.class);

    private final CacheManager cacheManager;
    private final BookRepository bookRepository;

    public BookCacheRunner(CacheManager cacheManager, BookRepository bookRepository) {
        this.cacheManager = cacheManager;
        this.bookRepository = bookRepository;
    }

    @Override
    public void run(String... args) throws Exception {
        logger.info(">>> Using cache manager: " + this.cacheManager.getClass().getName());
        logger.info(">>> Fetching books");
        logger.info("isbn-1234 -->" + bookRepository.getByIsbn("isbn-1234"));
        logger.info("isbn-4567 -->" + bookRepository.getByIsbn("isbn-4567"));
        logger.info("isbn-1234 -->" + bookRepository.getByIsbn("isbn-1234"));
        logger.info("isbn-4567 -->" + bookRepository.getByIsbn("isbn-4567"));
        logger.info("isbn-1234 -->" + bookRepository.getByIsbn("isbn-1234"));
        logger.info("isbn-4567 -->" + bookRepository.getByIsbn("isbn-4567"));
    }
}
