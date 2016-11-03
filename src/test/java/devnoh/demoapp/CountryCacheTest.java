package devnoh.demoapp;

import devnoh.demoapp.domain.Country;
import devnoh.demoapp.repository.CountryRepository;
import org.assertj.core.util.Compatibility;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.cache.Cache;
import org.springframework.cache.CacheManager;
import org.springframework.test.context.junit4.SpringRunner;

import static org.assertj.core.api.Java6Assertions.assertThat;

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
        assertThat(cache).isNotNull();
        cache.clear(); // Simple test assuming the cache is empty
        assertThat(cache.get("US")).isNull();

        Country found = countryRepository.findByCode("US");
        System.out.println("found=" + found);
        Country cached = (Country) cache.get("US").get();
        System.out.println("cached=" + cached);

        assertThat(cached).isEqualTo(found);
    }
}
