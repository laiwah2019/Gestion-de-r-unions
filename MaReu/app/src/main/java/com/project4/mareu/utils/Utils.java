package com.project4.mareu.utils;

import android.view.View;
import android.widget.EditText;
import android.widget.Spinner;

import com.project4.mareu.R;
import com.project4.mareu.ui.adapters.RoomAdapter;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.Set;

import com.project4.mareu.models.Reunion;
import com.project4.mareu.models.RoomItem;
import com.project4.mareu.models.RoomItemSpinner;


public abstract class Utils {

    private static ArrayList<RoomItemSpinner> mRoomItemSpinners;

    public static void initListSpinner(){
        mRoomItemSpinners = new ArrayList<>();

        for ( RoomItem item : RoomItem.values() ){
            mRoomItemSpinners.add(new RoomItemSpinner(item.getId(),item.getName()));
        }
    }

    public static void initRoomSpinner(View view, Spinner spinner){
        initListSpinner();
        RoomAdapter mRoomAdapter = new RoomAdapter(view.getContext(), mRoomItemSpinners);
        spinner.setAdapter(mRoomAdapter);
    }

    public static List<String> initSpinnerDate(List<Reunion> mReunions){
        List<String> arrayList = new ArrayList<>();
        Set<String> set = new HashSet<>();
        for (Reunion r : mReunions){
            set.add(r.getDate());
        }
        for (String s : set){
            arrayList.add(s);
        }
        return arrayList;
    }

    public static boolean checkRoomAndDate(String room, String date,String hour, List<Reunion> reunions){
        for (Reunion r : reunions){
            if (room.equals(r.getNameRoom()) && date.equalsIgnoreCase(r.getDate()) && hour.equalsIgnoreCase(r.getTime())){
                return false;
            }
        }
        return true;
    }

    public static String checkDate(String date){
        if (date == null){
            Date date1 = new Date();
            SimpleDateFormat simpleDateFormat = new SimpleDateFormat("dd/MM/yyyy", Locale.FRENCH);
            date = simpleDateFormat.format(date1);
            return date;
        }else {
            return date;
        }
    }
    public static String checkHourNull(String hour){
        if (hour == null){
            Date date1 = new Date();
            SimpleDateFormat simpleDateFormat = new SimpleDateFormat("HH h mm", Locale.FRENCH);
            hour = simpleDateFormat.format(date1);
            return hour;
        }else {
            return hour;
        }
    }

    public static boolean checkHour(int hour, int minute){
        if (hour < 9 || (hour >= 19 && minute >= 1)){
            return false;
        }else {
            return true;
        }
    }

    public static boolean checkInputText(EditText textView){
        if (textView.getText().toString().equals("")){
            return false;
        }else {
            return true;
        }
    }

    public static String makeMailString(String mail){
        String str = "";
        String[] arrayString = mail.toLowerCase().split("[,;.:!§/$@?&#|]+");

        for (String a : arrayString){
            a += "@lamzone.com;";
            str += a;
        }
        return str;
    }

    public static Map<Integer, Integer> map = new HashMap<Integer, Integer>()
    {{
        put(0, R.color.colorMeetingRoomA);
        put(1, R.color.colorMeetingRoomB);
        put(2, R.color.colorMeetingRoomC);
        put(3, R.color.colorMeetingRoomD);
        put(4, R.color.colorMeetingRoomE);
        put(5, R.color.colorMeetingRoomF);
        put(6, R.color.colorMeetingRoomG);
        put(7, R.color.colorMeetingRoomH);
        put(8, R.color.colorMeetingRoomI);
        put(9, R.color.colorMeetingRoomJ);
    }};
}
