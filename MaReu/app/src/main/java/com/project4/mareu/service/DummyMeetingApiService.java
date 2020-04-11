package com.project4.mareu.service;

import com.project4.mareu.model.Meeting;
import com.project4.mareu.model.Participants;
import com.project4.mareu.model.Room;

import java.util.ArrayList;
import java.util.List;

/**
 * Dummy mock for the Api
 */
public class DummyMeetingApiService implements MeetingApiService {
    private List<Meeting> meetings = DummyMeetingList.generateMeeting();
    private List<Participants> participants = DummyMeetingList.generateParticipants();
    private List<Room> rooms = DummyMeetingList.generateRoom();

    @Override
    public List<Meeting> getMeetings() {
        return meetings;
    }

    @Override
    public List<Participants> getParticipants() {
        return participants;
    }

    @Override
    public List<Room> getRooms() {
        return rooms;
    }

    @Override
    public void addMeeting(Meeting meeting) {meetings.add(meeting);

    }

    @Override
    public void deleteMeeting(Meeting meeting) {meetings.remove(meeting);

    }


}
