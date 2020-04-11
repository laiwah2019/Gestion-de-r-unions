package com.project4.mareu.model;

import java.util.Random;

/**
 * Model object representing a Meeting
 */
public class Meeting {

    /**
     * Title
     */
    private String title;

    /**
     * IdRoom
     */
    private Integer idRoom;

    /**
     * NameOrganiser
     */
    private String nameOrganiser;

    /**
     * Date
     */
    private Integer date;

    /**
     * StartTime
     */
    private Integer startTime;

    /**
     * EndTime
     */
    private Integer endTime;

    /**
     * Constructor
     *
     * @param title
     * @param idRoom
     * @param nameOrganiser
     * @param date
     * @Param startTime
     * @Param endTime
     */
    public Meeting(String title, Integer idRoom, String nameOrganiser, Integer date, Integer startTime, Integer endTime) {
        this.title = title;
        this.idRoom = idRoom;
        this.nameOrganiser = nameOrganiser;
        this.date = date;
        this.startTime = startTime;
        this.endTime = endTime;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public Integer getIdRoom() {
        return idRoom;
    }

    public void setIdRoom(Integer idRoom) {
        this.idRoom = idRoom;
    }

    public String getNameOrganiser() {
        return nameOrganiser;
    }

    public void setNameOrganiser(String nameOrganiser) {
        this.nameOrganiser = nameOrganiser;
    }

    public Integer getDate() {
        return date;
    }

    public void setDate(Integer date) {
        this.date = date;
    }

    public Integer getStartTime() {
        return startTime;
    }

    public void setStartTime(Integer startTime) {
        this.startTime = startTime;
    }

    public Integer getEndTime() {
        return endTime;
    }

    public void setEndTime(Integer endTime) {
        this.endTime = endTime;
    }


}