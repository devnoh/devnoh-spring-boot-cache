package devnoh.demoapp;

import devnoh.demoapp.repository.CountryRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.cache.CacheManager;
import org.springframework.stereotype.Component;

/**
 * Created by Sehwan Noh on 11/1/16.
 */
@Component
public class CountryCacheRunner implements CommandLineRunner {

    private static final Logger logger = LoggerFactory.getLogger(CountryCacheRunner.class);

    private final CacheManager cacheManager;
    private final CountryRepository countryRepository;

    public CountryCacheRunner(CacheManager cacheManager, CountryRepository countryRepository) {
        this.cacheManager = cacheManager;
        this.countryRepository = countryRepository;
    }

    @Override
    public void run(String... args) throws Exception {
        logger.info(">>> Using cache manager: " + this.cacheManager.getClass().getName());
        logger.info(">>> Fetching countries");
        logger.info("KR --> {}", countryRepository.findByCode("KR"));
        logger.info("US --> {}", countryRepository.findByCode("US"));
        logger.info("KR --> {}", countryRepository.findByCode("KR"));
        logger.info("US --> {}", countryRepository.findByCode("US"));
        logger.info("KR --> {}", countryRepository.findByCode("KR"));
        logger.info("US --> {}", countryRepository.findByCode("US"));
    }
}
