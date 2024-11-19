package com.example.mongo_project.dtos;

import com.example.mongo_project.model.Location;

import java.util.List;

public class StationDTO {
    private String id;
    private String name;
    private String code;
    private Location location;
    private List<Integer> platforms;
    private List<String> services;
    private Integer passengersServed;
    private Integer openedYear;
    private boolean hasRestaurant;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public Location getLocation() {
        return location;
    }

    public void setLocation(Location location) {
        this.location = location;
    }

    public List<Integer> getPlatforms() {
        return platforms;
    }

    public void setPlatforms(List<Integer> platforms) {
        this.platforms = platforms;
    }

    public List<String> getServices() {
        return services;
    }

    public void setServices(List<String> services) {
        this.services = services;
    }

    public Integer getPassengersServed() {
        return passengersServed;
    }

    public void setPassengersServed(Integer passengersServed) {
        this.passengersServed = passengersServed;
    }

    public Integer getOpenedYear() {
        return openedYear;
    }

    public void setOpenedYear(Integer openedYear) {
        this.openedYear = openedYear;
    }

    public boolean isHasRestaurant() {
        return hasRestaurant;
    }

    public void setHasRestaurant(boolean hasRestaurant) {
        this.hasRestaurant = hasRestaurant;
    }
}
