package com.project4.mareu.models;

public enum RoomItem {
    SALLE_A(0, "Peach", 5,"1er étage"),
    SALLE_B(1, "Mario", 4, "1er étage"),
    SALLE_C(2, "Luigi", 6, "1er étage"),
    SALLE_D(3, "Salle C", 4, "1er étage"),
    SALLE_E(4, "Salle D", 10, "1er étage"),
    SALLE_F(5, "Salle E", 4, "2ème étage"),
    SALLE_G(6, "Salle F", 4, "2ème étage"),
    SALLE_H(7, "Salle G", 6, "2ème étage"),
    SALLE_I(8, "Salle H", 8, "2ème étage"),
    SALLE_J(9, "Salle I", 4, "3ème étage");

    /**
     * //Fields
     */

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
    private Integer capacity;
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
    RoomItem(Integer id, String name, int capacity, String location) {
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
