package com.example.smoketrainer;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import java.util.List;

public class SmokeAdapter extends ArrayAdapter<Smoke> {

    private LayoutInflater inflater;

    public SmokeAdapter(Context context, List<Smoke> objects) {
        super(context, R.layout.list_item_counterstrikemap, objects);
        inflater = LayoutInflater.from(context);
    }
    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        if (convertView == null) {
            convertView = inflater.inflate(R.layout.list_item_smoke, parent, false);
        }

        Smoke smoke = getItem(position);
        TextView text = convertView.findViewById(R.id.textViewListSmoke);
        text.setText(smoke.getTitle());

        return convertView;
    }
}
