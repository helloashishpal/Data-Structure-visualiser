package com.ashish.visualizeds.builder;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.cardview.widget.CardView;

import com.ashish.visualizeds.R;

public class DataNodeBuilder {
    private static final int DATA_NODE_MARGIN_LEFT = 16;
    private static final int DATA_NODE_MARGIN_TOP = 16;
    private static final int DATA_NODE_MARGIN_RIGHT = 16;
    private static final int DATA_NODE_MARGIN_DOWN = 16;
    private final Context context;
    private final View dataNode;
    private final TextView dataNodeDataTextView;
    private final TextView dataNodeIndexTextView;
    private final CardView dataNodeCardView;
    private final ImageView dataNodeIndexPointer;


    public DataNodeBuilder(Context context) {
        this.context = context;

        //Initializing the data node view
        dataNode = LayoutInflater.from(context).inflate(R.layout.item_data_node, null);

        //params
        LinearLayout.LayoutParams params = new LinearLayout.LayoutParams(LinearLayout.LayoutParams.WRAP_CONTENT, LinearLayout.LayoutParams.WRAP_CONTENT);
        params.setMargins(DATA_NODE_MARGIN_LEFT, DATA_NODE_MARGIN_TOP, DATA_NODE_MARGIN_RIGHT, DATA_NODE_MARGIN_DOWN);

        //referencing
        dataNode.setLayoutParams(params);
        dataNodeDataTextView = dataNode.findViewById(R.id.dataNodeDataTextView);
        dataNodeIndexTextView = dataNode.findViewById(R.id.dataNodeIndexTextView);
        dataNodeCardView = dataNode.findViewById(R.id.dataNodeCardView);
        dataNodeIndexPointer = dataNode.findViewById(R.id.dataNodeIndexPointer);
    }

    public void setNodeData(Integer data) {
        dataNodeDataTextView.setText(String.valueOf(data));
    }

    public void setNodeIndex(Integer index) {
        dataNodeIndexTextView.setText(String.valueOf(index));
    }

    public void hideNode() {
        dataNode.setVisibility(View.GONE);
    }

    public void showIndexPointer() {
        dataNodeIndexPointer.setVisibility(View.VISIBLE);
    }

    public void setNodeColor(Integer resourceID) {
        dataNodeCardView.setCardBackgroundColor(context.getColor(resourceID));
    }

    public View getNode() {
        return dataNode;
    }
}
