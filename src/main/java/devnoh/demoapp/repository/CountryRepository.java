package devnoh.demoapp.repository;

import devnoh.demoapp.domain.Country;

/**
 * Created by Sehwan Noh on 11/1/16.
 */
public interface CountryRepository {

    Country findByCode(String code);

}
