package ro.fasttrack.curs14homework.countries;

import java.util.Objects;

public class AdvancedCountries extends Country {
    private String tech;

    public AdvancedCountries(String name, String capital, long population, long area, String tech) {
        super(name, capital, population, area);
        this.tech = tech;
    }

    public AdvancedCountries(Country country) {
        super(country.getName(), country.getCapital(), country.getPopulation(), country.getArea());
    }

    public String getTech() {
        return tech;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof AdvancedCountries)) return false;
        if (!super.equals(o)) return false;
        AdvancedCountries that = (AdvancedCountries) o;
        return Objects.equals(getTech(), that.getTech());
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), getTech());
    }

    @Override
    public String toString() {
        return "AdvancedCountries{" +
                "tech='" + tech + '\'' +
                "} " + super.toString();
    }
}
