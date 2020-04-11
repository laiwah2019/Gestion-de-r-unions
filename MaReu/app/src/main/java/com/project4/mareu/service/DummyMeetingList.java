package com.project4.mareu.service;

import com.project4.mareu.model.Meeting;
import com.project4.mareu.model.Participants;
import com.project4.mareu.model.Room;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;


public abstract class DummyMeetingList {
    //Generate Room
    public static List<Room> DUMMY_ROOM = Arrays.asList(
            new Room(0, "Salle 1", 4, "1er étage"),
            new Room(1, "Salle 2", 6, "1er étage"),
            new Room(2, "Salle 3", 4, "1er étage"),
            new Room(3, "Salle 4", 10, "1er étage"),
            new Room(4, "Salle 5", 4, "2ème étage"),
            new Room(5, "Salle 6", 4, "2ème étage"),
            new Room(6, "Salle 7", 6, "2ème étage"),
            new Room(7, "Salle 8", 8, "2ème étage"),
            new Room(8, "Salle 9", 4, "3ème étage"),
            new Room(9, "Salle 10", 12, "3ème étage")
    );
    //Generate Meeting
    public static List<Meeting> DUMMY_MEETING = Arrays.asList(

            new Meeting("Meeting 1", 1, " Francis", 04 / 04 / 2020, 1400, 1500),
            new Meeting("Meeting 2", 2, "Alexandra", 06 / 04 / 2020, 1435, 1520),
            new Meeting("Meeting 3", 4, "Bran", 04 / 04 / 2020, 1500, 1600)
    );

    //Generate Participants
    public static List<Participants> Dummy_PARTICIPANTS = Arrays.asList(

            new Participants(0, "Francis", "francis@lamzone.com"),
            new Participants(1, "Alexandra", "alexandra@lamzone.com"),
            new Participants(2, "Bran", "bran@lamzone.com")
    );


    static List<Room> generateRoom() {
        return new ArrayList<>(DUMMY_ROOM);

    }
    static List<Meeting> generateMeeting() {
        return new ArrayList<>(DUMMY_MEETING);

    }
    static List<Participants> generateParticipants() {
        return new ArrayList<>(Dummy_PARTICIPANTS);

    }

    public static List<Meeting> NEW_MEETING = Arrays.asList(
            new Meeting("Meeting 1", 1, " Francis", 05 / 04 / 2020, 1600, 1630)
    );

}
