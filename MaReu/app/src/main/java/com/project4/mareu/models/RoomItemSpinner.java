package com.project4.mareu.models;

import android.support.annotation.NonNull;


public class RoomItemSpinner {

    private String roomName;
    private Integer roomId;

    public RoomItemSpinner(int roomImage, String roomName) {
        this.roomName = roomName;
        this.roomId = roomId;
    }

    public String getRoomName() {
        return roomName;
    }

    public Integer getRoomId() {
        return roomId;
    }

    @NonNull
    @Override
    public String toString() {
        return this.getRoomName();
    }
}
