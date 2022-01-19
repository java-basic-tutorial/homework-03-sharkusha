package com.softserveinc.task03;

import com.softserveinc.task02.City;

import javax.imageio.metadata.IIOMetadataFormatImpl;
import java.util.ArrayList;
import java.util.Arrays;

public class Country {
    private String name;
    private String continent;
    private String code;
    private City capital;
    private City[] cities = new City[5];

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getContinent() {
        return continent;
    }

    public void setContinent(String continent) {
        this.continent = continent;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public City getCapital() {
        return capital;
    }

    public void setCapital(City capital) {
        this.capital = capital;
    }

    public City[] getCities() {
        return cities;
    }

    public void setCities(City[] cities) {
        this.cities = cities;
    }

    public Country() {
    }

    public Country(String name, String continent, String code, City capital) {
        this.name = name;
        this.continent = continent;
        this.code = code;
        this.capital = capital;
        addCity(capital);
    }

    @Override
    public String toString() {
        return "Country{" +
                "name='" + name + '\'' +
                ", continent='" + continent + '\'' +
                ", code='" + code + '\'' +
                ", capital=" + capital +
                ", cities=" + Arrays.toString(cities) +
                '}';
    }

    public void addCity(City name) {
        boolean isExists = false;
        for (int i = 0; i < cities.length; i++) {
            if (name == cities[i]) {
                isExists = true;
                break;
            }
        }
        if (!isExists) {
            boolean isAdded = false;
            for (int i = 0; i < cities.length; i++) {
                if (cities[i] == null)                {
                    cities[i] = name;
                    isAdded = true;
                    break;
                }
            }
            if (!isAdded) {
                cities = Arrays.copyOf(cities, cities.length + 5);
                addCity(name);
            }
        }
    }

    public int getInhabitants (){
        int people = 0;
        for (int i = 0; i < cities.length; i++) {
            if (cities[i] != null) {
                people += cities[i].getInhabitants();
            }

        }
        return people;
    }


}
