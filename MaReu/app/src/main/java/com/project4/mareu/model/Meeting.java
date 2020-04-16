package com.project4.mareu.model;

import java.util.List;

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
    private String date;

    /**
     * StartTime
     */
    private String startTime;

    /**
     * EndTime
     */
    private String endTime;

    /**
     *  PersonParticipant
     */
    private List<Participants> personParticipant;

    /**
     * Constructor
     *
     * @param title
     * @param idRoom
     * @param nameOrganiser
     * @param date
     * @param personParticipant
     * @Param startTime
     * @Param endTime
     */
    public Meeting(String title, Integer idRoom, String nameOrganiser, String date, String startTime, String endTime, List<Participants> personParticipant) {
        this.title = title;
        this.idRoom = idRoom;
        this.nameOrganiser = nameOrganiser;
        this.date= date;
        this.startTime = startTime;
        this.endTime = endTime;
        this.personParticipant = personParticipant;
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

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getStartTime() {
        return startTime;
    }

    public void setStartTime(String startTime) {
        this.startTime = startTime;
    }

    public String getEndTime() {
        return endTime;
    }

    public void setEndTime(String endTime) {
        this.endTime = endTime;
    }

    public List<Participants> getPersonParticipant() {
        return personParticipant;
    }

    public void setPersonParticipant(List<Participants> personParticipant) {
        this.personParticipant = personParticipant;
    }
}