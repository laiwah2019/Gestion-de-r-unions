package com.project4.mareu.service;


import com.project4.mareu.model.Meeting;
import com.project4.mareu.model.Participants;
import com.project4.mareu.model.Room;

import java.util.List;

/**
 * Meeting API client
 */
public interface MeetingApiService {
    /**
     * Get all my Meeting
     * @return {@link List}
     */
    List<Meeting> getMeetings();

    List<Participants> getParticipants();

    List<Room>getRooms();

    /**
     * Deletes a meeting
     * @param meeting
     */


    void addMeeting(Meeting meeting);

    /**
     * Deletes a meeting
     * @param meeting
     */
    void deleteMeeting(Meeting meeting);


}
