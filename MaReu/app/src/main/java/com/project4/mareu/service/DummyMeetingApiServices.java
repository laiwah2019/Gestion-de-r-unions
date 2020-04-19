package com.project4.mareu.service;

import com.project4.mareu.models.Reunion;

import java.util.ArrayList;
import java.util.List;

import static com.project4.mareu.service.ReunionListService.generatorOfReunion;

public class DummyMeetingApiServices implements ReunionApi {

    private List<Reunion> mReunionList = generatorOfReunion();

    @Override
    public List<Reunion> getReunionList() {
        return mReunionList;
    }

    @Override
    public  void addReunion(Reunion reunion) {
        mReunionList.add(reunion);
    }

    @Override
    public void deleteReunion(Reunion reunion) {
        mReunionList.remove(reunion);
    }

    @Override
    public ArrayList<Reunion> filter(String text) {
        ArrayList<Reunion> reunionSorted = new ArrayList<>();
        for (Reunion r : mReunionList) {
            if (r.getNameRoom().equalsIgnoreCase(text) || r.getDate().equals(text)) {
                reunionSorted.add(r);
            }
        }
        return reunionSorted;
    }



}