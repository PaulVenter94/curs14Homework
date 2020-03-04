package ro.fasttrack.curs14homework.countries;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.List;
import java.util.zip.CheckedOutputStream;

public class LongFormat implements FormatCountry {

    @Override
    public void formatCountry(List<Country> list) throws IOException {
        BufferedWriter writer = new BufferedWriter(new FileWriter("LongFormat.txt"));
        for (Country country : list) {
            writer.write(String.format("The country of %s has capital in %s with a population of %d on an area of %d km2\n"
                    , country.getName(), country.getCapital(), country.getPopulation(), country.getArea()));
        }
    }
}
