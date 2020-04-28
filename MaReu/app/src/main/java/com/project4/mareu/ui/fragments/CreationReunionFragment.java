package com.project4.mareu.ui.fragments;


import android.app.DatePickerDialog;
import android.app.TimePickerDialog;
import android.content.Context;
import android.os.Bundle;
import android.support.design.widget.Snackbar;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;

import java.util.Calendar;

import butterknife.BindView;
import butterknife.ButterKnife;

import com.project4.mareu.R;
import com.project4.mareu.ui.activity.ReunionListActivity;
import com.project4.mareu.models.Reunion;
import com.project4.mareu.models.RoomItemSpinner;
import com.project4.mareu.utils.Utils;

import static com.project4.mareu.utils.Utils.checkInputText;
import static com.project4.mareu.utils.Utils.checkRoomAndDate;
import static com.project4.mareu.utils.Utils.makeMailString;

/**
 * A simple {@link Fragment} subclass.
 */
public class CreationReunionFragment extends Fragment {

    public interface CreateReunionListener{
        void onCreateReunion(Reunion reunion);
    }

    private RoomItemSpinner mRoomItemSpinner;
    private DatePickerDialog.OnDateSetListener mDateSetListener;
    private TimePickerDialog.OnTimeSetListener mTimeSetListener;
    public CreateReunionListener mCreateReunionListener;
    private String date;
    private String hour;

    @BindView(R.id.edit_title_reu)
    public EditText reunionTitle;
    @BindView(R.id.spinner_room)
    public Spinner spinnerRoom;
    @BindView(R.id.button)
    public Button mButton;
    @BindView(R.id.date)
    public EditText mTextDate;
    @BindView(R.id.hour_text)
    public EditText hourText;
    @BindView(R.id.edit_title_mail)
    public EditText editMail;
    @BindView(R.id.button_create_reunion)
    Button mButtonCreateReunion;

    public CreationReunionFragment() {}

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        if (context instanceof CreationReunionFragment.CreateReunionListener){
            mCreateReunionListener = (CreationReunionFragment.CreateReunionListener) context;
        }else {
            throw new RuntimeException(context.toString() + " Doit implémenter l'interface");
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.fragment_creation_reunion, container, false);

        ButterKnife.bind(this,view);

        spinnerRoom.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                mRoomItemSpinner = (RoomItemSpinner) spinnerRoom.getSelectedItem();
            }
            @Override
            public void onNothingSelected(AdapterView<?> parent) {}
        });

        mButton.setOnClickListener(v -> {
            CreationReunionFragment.this.configureDialogTimer();
            CreationReunionFragment.this.configureDialogCalendar();
        });

        Utils.initRoomSpinner(view, spinnerRoom);

        mDateSetListener = (view1, year, month, dayOfMonth) -> {
            getDate (year, month, dayOfMonth);
        };

        mTimeSetListener = (view12, hourOfDay, minute) -> {
            getTime(hourOfDay,minute);
        };

        mButtonCreateReunion.setOnClickListener(v -> {
            getButton(mButton);

                 });

        return view;
    }

    private void getButton(Button mButton) {
        if (!checkInputText(reunionTitle) ||
                !checkInputText(editMail) ){
            Snackbar.make(getView(), "Vous devez écrire le sujet et le nom.", Snackbar.LENGTH_SHORT).show();

        }else if(!checkRoomAndDate(mRoomItemSpinner.getRoomName(),
                mTextDate.getText().toString(),
                hourText.getText().toString(),
                ReunionListActivity.mDummyMeetingApiServices.getReunionList())){
            Snackbar.make(this.getView(),
                    "Sélectionnez une nouvelle date pour la réunion dans la salle " + mRoomItemSpinner.getRoomName(),
                    Snackbar.LENGTH_LONG).show();
        }else{
            Reunion reunion = createReunion();
            mCreateReunionListener.onCreateReunion(reunion);
        }
    }

    private void getTime(int hourOfDay, int minute) {
        String heureString = String.valueOf(hourOfDay);
        String minuteString = String.valueOf(minute);
        if (hourOfDay < 10){
            heureString = "0" + hourOfDay;
        }
        if (minute < 10){
            minuteString = "0" + minute;
        }
        hour= heureString + "h" + minuteString;
        hourText.setText(hour);

    }
    private void getDate(int year, int month, int dayOfMonth) {

        String day = String.valueOf(dayOfMonth);
        String monthS = String.valueOf(month+1);
        if (dayOfMonth < 10){
            day = "0" + dayOfMonth;
        }
        if (month < 9){
            monthS = "0" + (month+1);
        }
        date = day + "/" + monthS + "/" + year;
        mTextDate.setText(date);
    }

    @Override
    public void onDetach() {
        mCreateReunionListener = null;
        super.onDetach();
    }

    // Method ***********************************************************
    private void configureDialogCalendar() {
        Calendar cal = Calendar.getInstance();
        int year = cal.get(Calendar.YEAR);
        int month = cal.get(Calendar.MONTH);
        int day = cal.get(Calendar.DAY_OF_MONTH);

        DatePickerDialog dialogDate = new DatePickerDialog(getContext(), mDateSetListener,
                year, month, day);
        //block the calendar to current date
        dialogDate.getDatePicker().setMinDate(System.currentTimeMillis());
        dialogDate.show();
    }

    private void configureDialogTimer() {

        Calendar cal = Calendar.getInstance();
        int hour = cal.get(Calendar.HOUR_OF_DAY);
        int minute = cal.get(Calendar.MINUTE);

        TimePickerDialog timePickerDialog = new TimePickerDialog(getContext(), mTimeSetListener,
                hour, minute, true);

        timePickerDialog.show();
    }

    private Reunion createReunion(){
        String str = "";
        if (editMail.getText().toString().isEmpty()){
            str = "";
        }else {
            str = makeMailString(editMail.getText().toString());
        }
       return new Reunion(
                reunionTitle.getText().toString(),
                mRoomItemSpinner.getRoomImage(),
                mRoomItemSpinner.getRoomName(),
                mTextDate.getText().toString(),
                hourText.getText().toString(),
                str
        );
    }

}










