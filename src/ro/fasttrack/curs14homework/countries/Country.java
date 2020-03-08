package ro.fasttrack.curs14homework.countries;

import java.util.Objects;

public class Country {
    private final String name;
    private final String capital;
    private final long population;
    private final long area;
    private final Density density;


    public Country(String name, String capital, long population, long area) {
        this.name = name;
        this.capital = capital;
        this.population = population;
        this.area = area;
        this.density = Density.getType(population / area);
    }

    public String getCapital() {
        return capital;
    }

    public long getPopulation() {
        return population;
    }

    public long getArea() {
        return area;
    }

    public String getName() {
        return name;
    }

    public Density getDensity() {
        return density;
    }


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Country)) return false;
        Country country = (Country) o;
        return getPopulation() == country.getPopulation() &&
                getArea() == country.getArea() &&
                Objects.equals(getName(), country.getName()) &&
                Objects.equals(getCapital(), country.getCapital()) &&
                getDensity() == country.getDensity();
    }

    @Override
    public int hashCode() {
        return Objects.hash(getName(), getCapital(), getPopulation(), getArea(), getDensity());
    }

    @Override
    public String toString() {
        return "Country{" +
                "name='" + name + '\'' +
                ", capital='" + capital + '\'' +
                ", population=" + population +
                ", area=" + area +
                ", density=" + density +
                '}';
    }
}
