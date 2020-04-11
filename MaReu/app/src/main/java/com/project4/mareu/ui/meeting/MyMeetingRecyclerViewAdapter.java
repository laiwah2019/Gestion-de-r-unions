package com.project4.mareu.ui.meeting;

import android.content.Context;
import android.text.Layout;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.Spinner;
import android.widget.TextView;

import androidx.recyclerview.widget.RecyclerView;
import com.project4.mareu.R;
import com.project4.mareu.events.DeleteMeetingEvent;
import com.project4.mareu.model.Meeting;
import com.project4.mareu.model.Participants;
import com.project4.mareu.model.Room;

import org.greenrobot.eventbus.EventBus;
import org.w3c.dom.Text;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;


public class MyMeetingRecyclerViewAdapter  extends RecyclerView.Adapter<MyMeetingRecyclerViewAdapter.ViewHolder>{
    private final List<Meeting> mMeetings;
    private final List<Participants> mParticipants;
    private final List<Room> mRooms;
    Context context;

    public MyMeetingRecyclerViewAdapter(List<Meeting> mMeetings, List<Participants> mParticipants, List<Room> mRooms) {
        this.mMeetings = mMeetings;
        this.mParticipants = mParticipants;
        this.mRooms = mRooms;

    }

   @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.fragment_meeting, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(final ViewHolder holder, int position) {
        final Meeting meeting = mMeetings.get(position);


    }

    @Override
    public int getItemCount() {
        return mMeetings.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        @BindView(R.id.text_input)
        public Text mTextInput;
        @BindView(R.id.edit_title_meeting)
        public Text mEditTitleMeeting;
        @BindView(R.id.text_room)
        public TextView mTextRoom;
        @BindView(R.id.select_room)
        public Spinner mSelect_Room;
        @BindView(R.id.linear_date2)
        public Layout mLinerDate2;
        @BindView(R.id.text_input_date)
        public Text mTextInputDate;
        @BindView(R.id.date)
        public Text mDate;
        @BindView(R.id.text_input_hour)
        public Text mTextInputHour;
        @BindView(R.id.hour_text)
        public Text mHourText;
        @BindView(R.id.button_calendar)
        public ImageButton mButtonCalendar;

        public ViewHolder(View view) {
            super(view);
            ButterKnife.bind(this, view);
        }
    }
}
