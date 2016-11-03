package devnoh.demoapp;

import devnoh.demoapp.domain.Country;
import devnoh.demoapp.repository.CountryRepository;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.cache.Cache;
import org.springframework.cache.CacheManager;
import org.springframework.test.context.junit4.SpringRunner;

import static org.assertj.core.api.Java6Assertions.assertThat;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertNull;

/**
 * Created by Sehwan Noh on 11/2/16.
 */
@RunWith(SpringRunner.class)
@SpringBootTest
public class CountryCacheTest {

    @Autowired
    private CacheManager cacheManager;

    @Autowired
    private CountryRepository countryRepository;

    @Test
    public void validateCache() {
        Cache cache = cacheManager.getCache("countries");
        assertNotNull(cache);
        cache.clear(); // Simple test assuming the cache is empty
        assertNull(cache.get("US"));

        Country found = countryRepository.findByCode("US");
        System.out.println("found=" + found);
        Country cached = (Country) cache.get("US").get();
        System.out.println("cached=" + cached);

        assertEquals(cached, found);
    }
}
