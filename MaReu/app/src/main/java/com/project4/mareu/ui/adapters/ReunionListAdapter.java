package com.project4.mareu.ui.adapters;

import android.content.Context;
import android.support.v4.content.ContextCompat;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;
import android.widget.TextView;

import com.project4.mareu.R;
import com.project4.mareu.service.ReunionListService;
import com.project4.mareu.ui.activity.ReunionListActivity;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

import com.project4.mareu.models.Reunion;
import com.project4.mareu.utils.Utils;


public class ReunionListAdapter extends RecyclerView.Adapter<ReunionListAdapter.ViewHolder> {

    ReunionListService mReunionListService;
    List<Reunion> mReunionList;
    Context context;
    public ReunionListAdapter(List<Reunion> reunionList) {
        mReunionList = reunionList;
    }

    public class ViewHolder extends RecyclerView.ViewHolder{

        @BindView(R.id.color_salle)
        public View mColorSalle;
        @BindView(R.id.text_reu)
        public TextView mTextReu;
        @BindView(R.id.hour_reunion)
        public TextView mHour;
        @BindView(R.id.room_name)
        public TextView mRoomName;
        @BindView(R.id.text_mail)
        public TextView mTextMail;
        @BindView(R.id.icon_delete)
        public ImageButton mDeleteButton;

        //constructor
        public ViewHolder(View itemView) {
            super(itemView);
            ButterKnife.bind(this, itemView);
        }
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int position) {
        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.item_reunion, parent, false);
        context = view.getContext();

        return new ViewHolder(view);


    }

    @Override
    public void onBindViewHolder(ViewHolder viewHolder, int position) {
        Reunion reunion = mReunionList.get(position);

        viewHolder.mColorSalle.setBackgroundColor(ContextCompat.getColor(context, Utils.map.get(reunion.getIdRoom())));


        viewHolder.mTextReu.setText(reunion.getReunionObject());
        if (reunion.getNameRoom() == null){
            return;
        }else{
            viewHolder.mRoomName.setText("- "+reunion.getNameRoom());
        }
        viewHolder.mHour.setText("- "+reunion.getTime());

        if (reunion.getMail() != null){
            if (reunion.getMail().length() < 30){
                viewHolder.mTextMail.setText(reunion.getMail());
            }else {
                String str = reunion.getMail().substring(0, 30) + " ...";
                viewHolder.mTextMail.setText(str);
            }
        }else {
            return;
        }

        viewHolder.mDeleteButton.setOnClickListener(v -> deleteReunion(reunion));
    }

    private void deleteReunion(Reunion reunion) {
        ReunionListActivity.mDummyMeetingApiServices.deleteReunion(reunion);
        this.notifyDataSetChanged();
    }

    @Override
    public int getItemCount() {
        return this.mReunionList.size();
    }

}
