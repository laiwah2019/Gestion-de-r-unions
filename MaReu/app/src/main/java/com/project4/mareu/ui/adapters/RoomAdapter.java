package com.project4.mareu.ui.adapters;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import java.util.ArrayList;

import com.project4.mareu.R;
import com.project4.mareu.models.RoomItemSpinner;


public class RoomAdapter extends ArrayAdapter<RoomItemSpinner> {

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

        TextView textView = convertView.findViewById(R.id.name_room);

        RoomItemSpinner currentItem = getItem(position);

        if (currentItem != null){
            textView.setText(currentItem.getRoomName());
        }
        return convertView;
    }
}
