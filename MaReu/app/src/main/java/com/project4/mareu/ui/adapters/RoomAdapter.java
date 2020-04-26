package com.project4.mareu.ui.adapters;

import android.content.Context;
import android.graphics.drawable.GradientDrawable;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.content.ContextCompat;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import java.util.ArrayList;

import com.project4.mareu.R;
import com.project4.mareu.models.Reunion;
import com.project4.mareu.models.RoomItemSpinner;
import com.project4.mareu.utils.Utils;


public class RoomAdapter extends ArrayAdapter<RoomItemSpinner> {
    Context context;
    private Reunion reunion;
    public RoomAdapter(@NonNull Context context, ArrayList<RoomItemSpinner> arrayList) {
        super(context, 0, arrayList);
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        return initView(position, convertView, parent);
    }

    @Override
    public View getDropDownView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        return initView(position, convertView, parent);
    }

    private View initView(int position, @Nullable View convertView, @NonNull ViewGroup parent){
        if (convertView == null){
            convertView = LayoutInflater.from(getContext()).inflate(
                    R.layout.room_spinner_row, parent, false);
        }
        RoomItemSpinner currentItem = getItem(position);
        View mView = convertView.findViewById(R.id.image_room);

        mView.setBackgroundResource(R.drawable.corner_radius);

        GradientDrawable drawable = (GradientDrawable) mView.getBackground();

        drawable.setColor(ContextCompat.getColor(convertView.getContext(), Utils.map.get(currentItem.getRoomImage())));
        TextView textView = convertView.findViewById(R.id.name_room);



        if (currentItem != null){
            textView.setText(currentItem.getRoomName());
        }
        return convertView;
    }
}
