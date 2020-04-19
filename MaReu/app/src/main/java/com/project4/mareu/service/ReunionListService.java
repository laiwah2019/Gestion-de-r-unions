package com.project4.mareu.service;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import com.project4.mareu.models.Reunion;

public class ReunionListService {


    private static List<Reunion> mReunionListGenerate = Arrays.asList(
            new Reunion("Reunion A", 0, "Peach", "04/04/2019", "14:00", "maxime@lamzone.com,alex@lamzone"),
            new Reunion("Reunion B", 1, "Mario", "04/04/2019", "16:00", "paul@lamzone.com,viviane@lamzone.com"),
            new Reunion("Reunion C", 3, "Luigi", "07/04/2019", "19:00", "amandine@lamzone.com,luc@lamzone.com")
    );

    public static List<Reunion> generatorOfReunion() {
        return new ArrayList<>(mReunionListGenerate);
    }


}
