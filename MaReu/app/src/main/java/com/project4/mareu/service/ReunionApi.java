package com.project4.mareu.service;

import java.util.ArrayList;
import java.util.List;

import com.project4.mareu.models.Reunion;

public interface ReunionApi {

     List<Reunion> getReunionList();
     void addReunion(Reunion reunion);

     void deleteReunion(Reunion reunion);

     ArrayList<Reunion> filter(String text);
}
