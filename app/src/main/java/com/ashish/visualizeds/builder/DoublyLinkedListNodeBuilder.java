package com.ashish.visualizeds.builder;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.cardview.widget.CardView;

import com.ashish.visualizeds.R;

import java.util.Objects;

public class DoublyLinkedListNodeBuilder {
    private static final int DATA_NODE_MARGIN_LEFT = 0;
    private static final int DATA_NODE_MARGIN_TOP = 16;
    private static final int DATA_NODE_MARGIN_RIGHT = 0;
    private static final int DATA_NODE_MARGIN_DOWN = 0;
    private final Context context;
    private final View doublyLinkedListNode;
    private final TextView dataNodeDataTextView;
    private final CardView dataNodeCardView;
    private final ImageView dataNodeIndexPointer;
    private final View nodeNextPointer;
    public static final int COLOR_RED = R.color.dark_red;
    public static final int COLOR_YELLOW_GREEN = R.color.citron;
    public static final int COLOR_BLACK = R.color.old_lace_black;


    public DoublyLinkedListNodeBuilder(Context context) {
        this.context = context;

        //Initializing the data node view
        doublyLinkedListNode = LayoutInflater.from(context).inflate(R.layout.item_doubly_linked_list, null);

        //params
        LinearLayout.LayoutParams params = new LinearLayout.LayoutParams(LinearLayout.LayoutParams.WRAP_CONTENT, LinearLayout.LayoutParams.WRAP_CONTENT);
        params.setMargins(DATA_NODE_MARGIN_LEFT, DATA_NODE_MARGIN_TOP, DATA_NODE_MARGIN_RIGHT, DATA_NODE_MARGIN_DOWN);

        //referencing
        doublyLinkedListNode.setLayoutParams(params);
        dataNodeDataTextView = doublyLinkedListNode.findViewById(R.id.dataNodeDataTextView);
        dataNodeCardView = doublyLinkedListNode.findViewById(R.id.dataNodeCardView);
        dataNodeIndexPointer = doublyLinkedListNode.findViewById(R.id.dataNodeIndexPointer);
        nodeNextPointer = doublyLinkedListNode.findViewById(R.id.nodeNextPointer);
    }

    public void setNodeData(Integer data) {
        dataNodeDataTextView.setText(String.valueOf(data));
    }

    public void setNodeData(String s) {
        dataNodeDataTextView.setText(s);
        if (Objects.equals(s, "HEAD") || Objects.equals(s, "NULL"))
            this.setNodeColor(COLOR_BLACK);
    }

    public void showIndexPointer() {
        dataNodeIndexPointer.setVisibility(View.VISIBLE);
    }

    public void hideNodeNextPointer() {
        nodeNextPointer.setVisibility(View.INVISIBLE);
    }

    public void setNodeColor(Integer resourceID) {
        dataNodeCardView.setCardBackgroundColor(context.getColor(resourceID));
    }

    public View getNode() {
        return doublyLinkedListNode;
    }
}
