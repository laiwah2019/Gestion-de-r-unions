package com.project4.mareu.models;

import android.support.annotation.NonNull;


public class RoomItemSpinner {

    private String roomName;
    private int roomImage;

    public RoomItemSpinner(int roomImage, String roomName) {
        this.roomName = roomName;
        this.roomImage = roomImage;
    }

    public String getRoomName() {
        return roomName;
    }

    public int getRoomImage() {
        return roomImage;
    }



    @NonNull
    @Override
    public String toString() {
        return this.getRoomName();
    }
}
