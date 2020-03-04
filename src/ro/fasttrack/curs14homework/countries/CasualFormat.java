package ro.fasttrack.curs14homework.countries;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.List;

public class CasualFormat implements FormatCountry {

    @Override
    public void formatCountry(List<Country> result) throws IOException {
        BufferedWriter writer = new BufferedWriter(new FileWriter("CasualFormat.txt"));
        for (Country country : result) {
            writer.write(String.format("%s has population of %d on area %d and has capital %s\n"
                    , country.getName(), country.getPopulation(),  country.getArea(),country.getCapital()));
        }
    }
}
