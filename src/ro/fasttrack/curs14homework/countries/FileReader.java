package ro.fasttrack.curs14homework.countries;

import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class FileReader {


    public List<Country> countryReader(String fileName) throws FileNotFoundException {
        List<Country> list = new ArrayList<>();
        Scanner scanner = new Scanner(new java.io.FileReader(fileName));
        while (scanner.hasNext()) {
            Country country = getCountry(scanner.nextLine());
            list.add(country);
        }
        return list;
    }

    private Country getCountry(String nextLine) {
        String[] strings = nextLine.split("\\|");
        return new Country(strings[0], strings[1], Long.parseLong(strings[2]), Long.parseLong(strings[3]));
    }
}
