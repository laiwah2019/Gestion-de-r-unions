package com.project4.mareu.model;
/**
 * Model object representing a Room
 */
public class Room {

    /**
     * Identifier
     */
    private Integer id;

    /**
     * Full name
     */
    private String name;

    /**
     * Capacity
     */
    private Integer capacity  ;
    /**
     * Location
     */
    private String location;

    /**
     * Constructor
     *
     * @param id
     * @param name
     * @param capacity
     * @param location
     */
    public Room (Integer id, String name, int capacity, String location) {
        this.id = id;
        this.name = name;
        this.capacity = capacity;
        this.location = location;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getCapacity() {
        return capacity;
    }

    public void setCapacity(Integer capacity) {
        this.capacity = capacity;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }
}
