package com.example.citylist;

import org.junit.Test;

import static org.junit.Assert.*;

public class CityListTest {
    private CityList mockCityList() {
        CityList cityList = new CityList();
        cityList.add(mockCity());
        return cityList;
    }

    private City mockCity() {
        return new City("Edmonton", "AB");
    }

    @Test
    public void testAdd() {
        CityList cityList = mockCityList();
        assertEquals(1, cityList.getCities().size());

        City city = new City("Regina", "SK");
        cityList.add(city);

        assertEquals(2, cityList.getCities().size());
        assertTrue(cityList.getCities().contains(city));
    }

    @Test
    public void testAddException() {
        CityList cityList = new CityList();
        City city = mockCity();
        cityList.add(city);

        assertThrows(IllegalArgumentException.class, () -> {
            cityList.add(city);
        });
    }

    @Test
    public void testGetCities() {
        CityList cityList = mockCityList();
        assertEquals(0, mockCity().compareTo(cityList.getCities().get(0)));

        City city = new City("Charlottetown", "Prince Edward Island");
        cityList.add(city);

        assertEquals(0, city.compareTo(cityList.getCities().get(0)));
        assertEquals(0, mockCity().compareTo(cityList.getCities().get(1)));
    }

    /**
     * Tests the delete() method
     */
    @Test
    public void testDelete() {
        CityList citylist = new CityList();
        City city = new City("Dhaka", "Dhaka");
        citylist.add(city);
        citylist.delete(city);
        assertEquals(false, citylist.getCities().contains(city));
    }

    /**
     * Tests the invocation of IllegalArgumentException in delete() method
     */
    @Test
    public void testDeleteException() {
        CityList cityList = new CityList();
        City city = new City("Dhaka", "Dhaka");
        assertThrows(IllegalArgumentException.class, () -> {
            cityList.delete(city);
        });
    }

    /**
     * Tests the size of the list after adding or deleting cities.
     */
    @Test
    public void testCount() {
        CityList cityList = new CityList();
        assertEquals(0, cityList.count());
        City city1 = new City("Dhaka", "Dhaka");
        cityList.add(city1);
        assertEquals(1, cityList.count());
        City city2 = new City("Khulna", "Khulna");
        cityList.add(city2);
        assertEquals(2, cityList.count());
        cityList.delete(city1);
        assertEquals(1, cityList.count());
    }

    /**
     * Tests if the sorting based on cities or provinces are correct or not
     */
    @Test
    public void testSort() {
        CityList cityList = new CityList();
        City city1 = new City("Gazipur", "Rajshahi");
        cityList.add(city1);
        City city2 = new City("Mongla", "Khulna");
        cityList.add(city2);
        assertEquals(city1, cityList.getCities(true).get(0));
        assertEquals(city2, cityList.getCities(false).get(0));
    }
}