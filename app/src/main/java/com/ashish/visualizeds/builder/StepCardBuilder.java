package com.ashish.visualizeds.builder;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.ashish.visualizeds.R;

public class StepCardBuilder {

    private static final int STEP_CARD_MARGIN_LEFT = 24;
    private static final int STEP_CARD_MARGIN_TOP = 4;
    private static final int STEP_CARD_MARGIN_RIGHT = 24;
    private static final int STEP_CARD_MARGIN_DOWN = 4;

    private final View stepCard;
    private final TextView titleTextView;
    private final LinearLayout dataNodeHolder;
    private final TextView descriptionTextView;

    public StepCardBuilder(Context context) {

        //generating Step Card
        stepCard = LayoutInflater.from(context).inflate(R.layout.item_visualizer_step_card_1, null,false);

        //Setting Step Card Parameters
        LinearLayout.LayoutParams params = new LinearLayout.LayoutParams(LinearLayout.LayoutParams.MATCH_PARENT, LinearLayout.LayoutParams.WRAP_CONTENT);
        params.setMargins(STEP_CARD_MARGIN_LEFT, STEP_CARD_MARGIN_TOP, STEP_CARD_MARGIN_RIGHT, STEP_CARD_MARGIN_DOWN);
        stepCard.setLayoutParams(params);

        //Referencing
        titleTextView = stepCard.findViewById(R.id.titleTextView);
        dataNodeHolder = stepCard.findViewById(R.id.dataNodeHolder);
        descriptionTextView = stepCard.findViewById(R.id.descriptionTextView);
    }

    public void setCardTitle(String title) {
        titleTextView.setText(title);
    }

    public void setCardDescription(String description) {
        descriptionTextView.setText(description);
    }

    public void addDataNode(View view) {
        dataNodeHolder.addView(view);
    }

    public LinearLayout getDataNodeHolder() {
        return dataNodeHolder;
    }

    public View getStepCard() {
        return stepCard;
    }
}
