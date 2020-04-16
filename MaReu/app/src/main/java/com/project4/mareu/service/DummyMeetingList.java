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

            new Meeting("Meeting 1", 1, "Maxime","04/04/2020","14h00","15h00", DUMMY_PARTICIPANTS),
            new Meeting("Meeting 2", 2, "Paul", "06 / 04 / 2020", "16h00", "17h00", DUMMY_PARTICIPANTS),
            new Meeting("Meeting 3", 4, "Amandine", "04 / 04 / 2020", "19h00", "20h00", DUMMY_PARTICIPANTS));


    //Generate Participants
    public static List<Participants> DUMMY_PARTICIPANTS = Arrays.asList(

            new Participants(0, "Maxime", "maximes@lamzone.com"),
            new Participants(1, "Paul", "paul@lamzone.com"),
            new Participants(2, "Amandine", "amandine@lamzone.com")
    );



    static List<Meeting> generateMeeting() {
        return new ArrayList<>(DUMMY_MEETING);

    }


}
