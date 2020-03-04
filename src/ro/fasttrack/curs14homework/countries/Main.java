package ro.fasttrack.curs14homework.countries;

import java.io.FileNotFoundException;

public class Main {
    public static void main(String[] args) throws FileNotFoundException {
        FileReader reader = new FileReader();
        CountryStatistics countryStatistics = new CountryStatistics(reader.countryReader("countries.txt"));
        System.out.println(countryStatistics.getCountries());
        System.out.println(countryStatistics.getCountriesWithStartingLetters("tuva"));
        System.out.println(countryStatistics.getLargestCountry());
        System.out.println(countryStatistics.getHighestPop());
        System.out.println(countryStatistics.getHighestDensity());
        System.out.println(countryStatistics.getCountriesForDensity(Density.HIGH));
        countryStatistics.makeAdvanced("tuvalu","Human Mutation");
        countryStatistics.makeAdvanced("Afghanistan","Galactic networking");
        System.out.println(countryStatistics.getCountriesWithStartingLetters("AFGH"));
        System.out.println(countryStatistics.getCountriesWithStartingLetters("tuva"));
        countryStatistics.makeAdvanced("Zimbabwe","Interphased fission");
        countryStatistics.printWithTech();
        }
}
