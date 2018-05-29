package com.ucbcba.demo.services;

import com.ucbcba.demo.Entities.Country;

public interface CountryService {
    Iterable<Country> listAllCountries();

    void saveCountry(Country category);

    Country getCountry(Integer id);

    void deleteCountry(Integer id);
}
