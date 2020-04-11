package com.project4.mareu.model;

/**
 * Model object representing a Participants
 */
public class Participants {
    /**
     * Identifier
     */
    private Integer id;
     /**
     * Full name
     */
    private String name;

    /**
     * addressMail
     */
    private String addressMail;

    /**
     * Constructor
     * @param id
     * @param name
     * @param addressMail
     */
    public Participants( Integer id, String name, String addressMail) {
        this.id = id;
        this.name = name;
        this.addressMail = addressMail;

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

    public String getAddressMail() {
        return addressMail;
    }

    public void setAddressMail(String addressMail) {
        this.addressMail = addressMail;
    }
}

