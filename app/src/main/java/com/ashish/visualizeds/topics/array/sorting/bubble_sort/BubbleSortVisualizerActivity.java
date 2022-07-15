package com.ashish.visualizeds.topics.array.sorting.bubble_sort;

import android.os.Bundle;
import android.widget.LinearLayout;

import androidx.appcompat.app.AppCompatActivity;

import com.ashish.visualizeds.builder.DataNodeBuilder;
import com.ashish.visualizeds.builder.StepCardBuilder;
import com.ashish.visualizeds.R;
import com.ashish.visualizeds.classes.DataStructureAlgorithm;
import com.ashish.visualizeds.utils.DataStructureUtil;
import com.ashish.visualizeds.databinding.ActivityBubbleSortVisualizerBinding;

import java.util.List;

public class BubbleSortVisualizerActivity extends AppCompatActivity {

    private static final int COLOR_SWAPPED = R.color.dark_red;
    private static final int COLOR_NOT_SWAPPED = R.color.citron;

    private ActivityBubbleSortVisualizerBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityBubbleSortVisualizerBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());


        //filling header information
        DataStructureAlgorithm dataStructureAlgorithm = (DataStructureAlgorithm) getIntent().getSerializableExtra("data");
        binding.titleTextView.setText(dataStructureAlgorithm.getName());
        binding.difficultyTextView.setText(dataStructureAlgorithm.getDifficulty().toString());
        binding.iconImageView.setImageResource(dataStructureAlgorithm.getIcon());

        //Setting title
        setTitle(dataStructureAlgorithm.getName() + " Visualizer");


        //button click listener
        binding.visualizeButton.setOnClickListener(v -> {

            //clear all views of the linear Layout
            clearLayout();

            //Generating Visuals
            List<Integer> arr = DataStructureUtil.stringToArray(binding.arrayEditText.getText().toString().trim());

            //Bubble Sort
            int steps = 0;
            for (int i = 0; i < arr.size(); i++) {
                for (int j = 0; j < arr.size() - 1; j++) {
                    //Building step card
                    StepCardBuilder stepCardBuilder = new StepCardBuilder(getApplicationContext());
                    stepCardBuilder.setCardTitle(String.format("Step %d", ++steps));
                    if (arr.get(j) > arr.get(j + 1)) {
                        stepCardBuilder.setCardDescription(String.format("%d is greater than %d.\nTherefore swapping %d & %d.", arr.get(j), arr.get(j + 1), arr.get(j), arr.get(j + 1)));
                    } else {
                        stepCardBuilder.setCardDescription(String.format("%d is not greater than %d.\nTherefore no swapping necessary.", arr.get(j), arr.get(j + 1)));
                    }

                    //Bubble Sort Condition
                    int color;
                    if (arr.get(j) > arr.get(j + 1)) {
                        color = COLOR_SWAPPED;
                        int temp = arr.get(j);
                        arr.set(j, arr.get(j + 1));
                        arr.set(j + 1, temp);
                    } else {
                        color = COLOR_NOT_SWAPPED;
                    }

                    //Generating Data for Step Card
                    generateArrayView(arr, stepCardBuilder.getDataNodeHolder(), j, color);

                    //Adding view to the holder of the Step Card
                    binding.holderLinearLayout.addView(stepCardBuilder.getStepCard());
                }
            }
        });
    }

    private void clearLayout() {
        binding.holderLinearLayout.removeAllViews();
    }

    private void generateArrayView(List<Integer> arr, LinearLayout holder, int j, int color) {
        for (int i = 0; i < arr.size(); i++) {
            //Building a data node.
            DataNodeBuilder dataNodeBuilder = new DataNodeBuilder(getApplicationContext());
            dataNodeBuilder.setNodeData(arr.get(i));
            dataNodeBuilder.setNodeIndex(i);
            if (i == j || i == j + 1) {
                dataNodeBuilder.showIndexPointer();
                dataNodeBuilder.setNodeColor(color);
            }
            //adding data node to the linearLayout.
            holder.addView(dataNodeBuilder.getNode());

            //requesting focus
            holder.requestChildFocus(holder.getChildAt(j+1), holder.getChildAt(j+1));
        }
    }
}