package com.project4.mareu.ui.meeting;

import androidx.appcompat.app.AppCompatActivity;

import com.project4.mareu.model.Meeting;
import com.project4.mareu.model.Participants;
import com.project4.mareu.model.Room;

import java.util.List;

public class MeetingListActivity extends AppCompatActivity {

    private final List<Meeting> mMeetings;
    private final List<Participants> mParticipants;
    private final List<Room> mRooms;

    public MeetingListActivity(List<Meeting> mMeetings, List<Participants> mParticipants, List<Room> mRooms) {
        this.mMeetings = mMeetings;
        this.mParticipants = mParticipants;
        this.mRooms = mRooms;
    }

}
