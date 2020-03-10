package ro.fasttrack.curs14homework.countries;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.List;

public class CasualFormat implements FormatCountry {

    public void print(List<Country> list){
        formatText(list);
    }

    private void formatText(List<Country> list) {
        BufferedWriter writer = null;
        try {
            writer = new BufferedWriter(new FileWriter("CasualFormat.txt"));
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
        try {
            for (Country country : list) {
                writer.write(String.format("%s has population of %d on area %d and has capital %s\n"
                        , country.getName(), country.getPopulation(), country.getArea(), country.getCapital()));
            }
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
    }
}

