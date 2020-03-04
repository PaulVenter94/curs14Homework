package ro.fasttrack.curs14homework.countries;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.List;

public class CountryStatistics {
    private final List<Country> countries;
    private List<AdvancedCountries> advCountries = new ArrayList<>();

    CountryStatistics(List<Country> countries) {
        this.countries = new ArrayList<>(countries);
    }

    public List<Country> getCountries() {
        return new ArrayList<>(countries);
    }

    public List<Country> getCountriesWithStartingLetters(String letter) {
        List<Country> result = new ArrayList<>();
        for (Country country : countries) {
            if (country.getName().substring(0, letter.length()).equalsIgnoreCase(letter)) {
                result.add(country);
            }
        }
        return result;
    }

    public String getCountryCapital(String country) {
        Country country1 = findCountry(country);
        return country1.getCapital();
    }

    public long getPopulation(String countryName) {
        Country country = findCountry(countryName);
        return country.getPopulation();
    }

    public long getArea(String countryName) {
        Country country = findCountry(countryName);
        return country.getArea();
    }

    public Country getLargestCountry() {
        long max = 0;
        Country result = null;
        for (Country country : countries) {
            if (country.getArea() > max) {
                result = country;
                max = country.getArea();
            }
        }
        return result;
    }

    public Country getHighestPop() {
        long max = 0;
        Country result = null;
        for (Country country : countries) {
            if (country.getPopulation() > max) {
                result = country;
                max = country.getPopulation();
            }
        }
        return result;
    }

    public Country getHighestDensity() {
        long max = 0;
        Country result = null;
        for (Country country : countries) {
            if (country.getPopulation() / country.getArea() > max) {
                result = country;
                max = country.getPopulation() / country.getArea();
            }
        }
        return result;
    }

    public List<Country> getCountriesForDensity(Density density) {
        List<Country> result = new ArrayList<>();
        for (Country country : countries) {
            if (density.equals(country.getDensity())) {
                result.add(country);
            }
        }
        return result;
    }

    public void makeAdvanced(String countryName, String tech) {
        for (int i = 0; i < countries.size(); i++) {
            if (countries.get(i).getName().equalsIgnoreCase(countryName)) {
                Country country = countries.get(i);
                country = new AdvancedCountries(country.getName(), country.getCapital(), country.getPopulation(), country.getArea(), tech);
                countries.set(i, country);
                advCountries.add(new AdvancedCountries(country.getName(), country.getCapital(), country.getPopulation(), country.getArea(), tech));
            }
        }
    }

    public void printWithTech() {
        boolean b = false;
        for (Country country : countries) {
            b = false;
            for (AdvancedCountries advancedCountries : advCountries) {
                if (country.getName().equals(advancedCountries.getName())) {
                    System.out.println(country.getName() + "-" + advancedCountries.getTech());
                    b = true;
                }
            }
            if (!b) {
                System.out.println(country.getName() + "-none");
            }
        }
    }

    private Country findCountry(String country) {
        for (Country country1 : countries) {
            if (country1.getName().equalsIgnoreCase(country)) {
                return country1;
            }
        }
        return null;
    }
}
