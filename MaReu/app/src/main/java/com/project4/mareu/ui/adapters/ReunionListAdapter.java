package com.project4.mareu.ui.adapters;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.project4.mareu.R;
import com.project4.mareu.service.ReunionListService;
import com.project4.mareu.ui.activity.ReunionListActivity;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

import com.project4.mareu.models.Reunion;



public class ReunionListAdapter extends RecyclerView.Adapter<ReunionListAdapter.ViewHolder> {

    ReunionListService mReunionListService;
    List<Reunion> mReunionList;

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
        @BindView(R.id.location)
        public TextView mLocation;
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
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(ViewHolder viewHolder, int position) {
        Reunion reunion = mReunionList.get(position);

        /*Glide.with(viewHolder.mColorSalle.getContext())
                .load(reunion.getIdRoom())
                .into(viewHolder.mColorSalle);*/

        viewHolder.mTextReu.setText(reunion.getReunionObject());
        if (reunion.getDate() == null){
            return;
        }else{
            viewHolder.mLocation.setText(reunion.getDate());
        }
        viewHolder.mHour.setText(reunion.getTime());

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
