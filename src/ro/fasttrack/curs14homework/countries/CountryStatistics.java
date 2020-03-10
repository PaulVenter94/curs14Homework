package ro.fasttrack.curs14homework.countries;

import java.util.ArrayList;
import java.util.List;

public class CountryStatistics {
    private final List<Country> countries;
    private List<AdvancedCountry> advCountries = new ArrayList<>();

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

    public String getCountryCapital(String countryName) {
        Country country = findCountry(countryName);
        return country!=null? country.getCapital():null;
    }

    public long getPopulation(String countryName) {
        Country country = findCountry(countryName);
        return country != null ? country.getPopulation() : 0L;
    }

    public long getArea(String countryName) {
        Country country = findCountry(countryName);
        return country != null ? country.getArea() : 0L;
    }

    public Country getLargestCountry() {
        Country result = countries.get(0);
        for (Country country : countries) {
            if (country.getArea() > result.getArea()) {
                result = country;
            }
        }
        return result;
    }

    public Country getHighestPop() {
        Country result = countries.get(0);
        for (Country country : countries) {
            if (country.getPopulation() > result.getPopulation()) {
                result = country;
            }
        }
        return result;
    }

    public Country getHighestDensity() {
        Country result = countries.get(0);
        for (Country country : countries) {
            if (country.getPopulation() / country.getArea() > (result.getPopulation()/result.getArea())) {
                result = country;
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
                country = new AdvancedCountry(country.getName(), country.getCapital(), country.getPopulation(), country.getArea(), tech);
                countries.set(i, country);
                advCountries.add(new AdvancedCountry(country.getName(), country.getCapital(), country.getPopulation(), country.getArea(), tech));
            }
        }
    }

    public void printWithTech() {
        boolean checkIfPrinted;
        for (Country country : countries) {
            checkIfPrinted = false;
            for (AdvancedCountry advancedCountry : advCountries) {
                if (country.getName().equals(advancedCountry.getName())) {
                    System.out.println(country.getName() + "-" + advancedCountry.getTech());
                    checkIfPrinted = true;
                }
            }
            if (!checkIfPrinted) {
                System.out.println(country.getName() + "-none");
            }
        }
    }

    public void printWithTechV2() {
        for (Country country : countries) {
            if (country instanceof AdvancedCountry) {
                AdvancedCountry advancedCountry = (AdvancedCountry) country;
                System.out.println(country.getName() + "-" + advancedCountry.getTech());
            } else {
                System.out.println(country.getName() + "-none");
            }
        }
    }

    private Country findCountry(String countryName) {
        for (Country country : countries) {
            if (country.getName().equalsIgnoreCase(countryName)) {
                return country;
            }
        }
        return null;
    }
}
