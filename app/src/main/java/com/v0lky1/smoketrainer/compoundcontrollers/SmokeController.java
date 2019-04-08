package com.v0lky1.smoketrainer.compoundcontrollers;

import android.support.constraint.ConstraintLayout;
import android.view.View;
import android.webkit.WebView;
import android.widget.AdapterView;
import android.widget.EditText;

import com.v0lky1.smoketrainer.R;
import com.v0lky1.smoketrainer.objects.Smoke;
import com.v0lky1.smoketrainer.views.CounterStrikeSmokeWebView;

import java.util.List;

public class SmokeController implements AdapterView.OnItemClickListener {


    private List<Smoke> smokes;
    private WebView wb;

    public SmokeController(List<Smoke>smokes, WebView wb){

        this.smokes = smokes;
        this.wb = wb;
    }

    @Override
    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
        wb.getSettings().setJavaScriptEnabled(true);
        wb.getSettings().setLoadWithOverviewMode(true);
        wb.getSettings().setUseWideViewPort(true);
        wb.getSettings().setBuiltInZoomControls(true);
        wb.setWebViewClient(new CounterStrikeSmokeWebView());
        wb.loadUrl(smokes.get(position).getUrl());
        smokes.get(position).setSeen(true);

        //counts amount of clicks
        int seenCounter = smokes.get(position).getSeenCounter() + 1;
        smokes.get(position).setSeenCounter(seenCounter++);

        // We hebben op een item geclicked, dus zorg ervoor dat de checkmarkview zich
        // opnieuw tekent.

        //
        ((ConstraintLayout) view).getViewById(R.id.checkMarkViews).invalidate();
        ((ConstraintLayout) view).getViewById(R.id.clickCounterView).invalidate();
    }
}
