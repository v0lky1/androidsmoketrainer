package com.v0lky1.smoketrainer.adapters;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import com.v0lky1.smoketrainer.R;
import com.v0lky1.smoketrainer.views.CheckMarkViews;
import com.v0lky1.smoketrainer.models.Smoke;
import com.v0lky1.smoketrainer.views.ClickCounterView;


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
        CheckMarkViews checkMarkViews = convertView.findViewById(R.id.checkMarkViews);
        ClickCounterView clickCounterView = convertView.findViewById(R.id.clickCounterView);
        checkMarkViews.currentSmoke(smoke);
        clickCounterView.currentSmoke(smoke);
        text.setText(smoke.getTitle());
        clickCounterView.setText(String.valueOf(smoke.getSeenCounter()));


        return convertView;
    }
}
