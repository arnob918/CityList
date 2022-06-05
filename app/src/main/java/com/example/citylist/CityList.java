package com.example.citylist;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

/**
 * This is a class that keeps track of a list of city objects
 */
public class CityList {
    private List<City> cities = new ArrayList<>();

    /**
     * This adds a city to the list if that city does not exist
     * @param city
     *      This is the city to add
     */
    public void add(City city) {
        if (cities.contains(city)) {
            throw new IllegalArgumentException();
        }
        cities.add(city);
    }

    /**
     * This returns a sorted list of cities
     *
     * @return
     *      Return the sorted list of cities
     */
    public List<City> getCities() {
        List<City> cityList = cities;
        Collections.sort(cityList);
        return cityList;
    }

    /** This deletes a city from the list of cities
     *
     * @param city
     *      This is the city to delete
     */
    public void delete(City city) {
        if(!cities.contains(city)) {
            throw new IllegalArgumentException();
        }
        cities.remove(city);
    }

    /** This returns the number of cities
     *
     * @return
     *      Returns the size of the list
     */
    public int count() {
        return cities.size();
    }

    /** This returns the list of cities sorted by city names or province names.
     *
     * @param is_city
     *      Check to sort by city name or province name
     * @return
     *      Returns the sorted list of cities
     */
    public List<City> getCities(boolean is_city) {
        List<City> cityList = cities;
        if(is_city) {
            Collections.sort(cityList);
        } else {
            Collections.sort(cityList, new Comparator<City>() {
                @Override
                public int compare(City c1, City c2) {
                    return c1.getProvinceName().compareTo(c2.getProvinceName());
                }
            });
        }
        return cityList;
    }
}