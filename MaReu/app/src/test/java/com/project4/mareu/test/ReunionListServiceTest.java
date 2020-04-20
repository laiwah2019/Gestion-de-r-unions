package com.project4.mareu.test;

import com.project4.mareu.models.Reunion;
import com.project4.mareu.service.DummyMeetingApiServices;
import com.project4.mareu.service.ReunionListService;

import org.junit.Test;

import java.util.ArrayList;
import java.util.List;
import static org.junit.Assert.assertEquals;


public class ReunionListServiceTest {

    //Field interface
    private ReunionListService mReunionListService = new ReunionListService();
    private DummyMeetingApiServices mDummyMeetingApiServices = new DummyMeetingApiServices();
    List<Reunion> mReunionList = mDummyMeetingApiServices.getReunionList();


    @Test
    public void getReunionList() {
        assertEquals(3, mReunionList.size());
    }

    @Test
    public void addReunionWithSuccess() {
       Reunion reunionD = new Reunion("Reunion D", 3,"Luigi",
               "04/04/2020","16:00","amandine@lamzone.com,luc@lamzone.com");
       mDummyMeetingApiServices.addReunion(reunionD);
       assertEquals(4, mReunionList.size());
    }

    @Test
    public void deleteReunionWithSuccess() {
        mDummyMeetingApiServices.deleteReunion(mReunionList.get(0));
        assertEquals(2,mReunionList.size());
    }

    @Test
    public void filterWithSuccess() {
            String text = "Peach";
            Reunion r4 = new Reunion("Reunion_A", 0,"Peach",
                    "20/04/2020","16:00","amandine@lamzone.com,luc@lamzone.com");
            mDummyMeetingApiServices.addReunion(r4);

            ArrayList<Reunion> reunionSorted = mDummyMeetingApiServices.filter(text);

            assertEquals(2, reunionSorted.size());
        }
    }

