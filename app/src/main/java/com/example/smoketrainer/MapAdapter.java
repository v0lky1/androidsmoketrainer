package com.example.smoketrainer;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

public class MapAdapter extends ArrayAdapter<CounterStrikeMap> {
    private LayoutInflater inflater;

    public MapAdapter(Context context, List<CounterStrikeMap> objects) {
        super(context, R.layout.list_item_counterstrikemap, objects);
        inflater = LayoutInflater.from(context);
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        if (convertView == null) {
            convertView = inflater.inflate(R.layout.list_item_counterstrikemap, parent, false);
        }

        CounterStrikeMap map = getItem(position);
        TextView text = convertView.findViewById(R.id.textViewList);
        text.setText(map.getName());

        return convertView;
    }
}
