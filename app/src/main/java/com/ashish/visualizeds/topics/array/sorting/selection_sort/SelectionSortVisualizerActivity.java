package com.ashish.visualizeds.topics.array.sorting.selection_sort;

import android.os.Bundle;
import android.widget.LinearLayout;

import androidx.appcompat.app.AppCompatActivity;

import com.ashish.visualizeds.builder.DataNodeBuilder;
import com.ashish.visualizeds.builder.StepCardBuilder;
import com.ashish.visualizeds.R;
import com.ashish.visualizeds.classes.DataStructureAlgorithm;
import com.ashish.visualizeds.utils.DataStructureUtil;
import com.ashish.visualizeds.databinding.ActivitySelectionSortVisualizerBinding;

import java.util.List;

public class SelectionSortVisualizerActivity extends AppCompatActivity {

    private ActivitySelectionSortVisualizerBinding binding;


    private static final int COLOR_SWAPPED = R.color.dark_red;
    private static final int COLOR_NOT_SWAPPED = R.color.citron;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivitySelectionSortVisualizerBinding.inflate(getLayoutInflater());
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

            //Selection Sort
            int steps = 0;
            for (int i = 0; i < arr.size(); i++) {
                int pos = i;
                for (int j = i; j < arr.size(); j++) {
                    StepCardBuilder stepCardBuilder = new StepCardBuilder(getApplicationContext());
                    stepCardBuilder.setCardTitle(String.format("Step %d", ++steps));
                    if (arr.get(j) < arr.get(pos)) {
                        stepCardBuilder.setCardDescription(String.format("%d is smaller than %d.\nNow, smallest value is %d.", arr.get(j), arr.get(pos), arr.get(j)));
                    } else {
                        stepCardBuilder.setCardDescription(String.format("%d is not smaller than %d.\nTherefore, smallest value is still %d.", arr.get(j), arr.get(pos), arr.get(j)));
                    }

                    //Selection Sort Condition
                    int color;
                    if (arr.get(j) < arr.get(pos)) {
                        color = COLOR_SWAPPED;
                        pos = j;
                    } else {
                        color = COLOR_NOT_SWAPPED;
                    }

                    //Generating Data for Step Card
                    generateArrayView(arr, stepCardBuilder.getDataNodeHolder(), j, color);

                    //Adding view to the holder of the Step Card
                    binding.holderLinearLayout.addView(stepCardBuilder.getStepCard());
                }
                StepCardBuilder stepCardBuilder = new StepCardBuilder(getApplicationContext());
                stepCardBuilder.setCardTitle(String.format("Step %d", ++steps));
                stepCardBuilder.setCardDescription(String.format("Smallest element found by traversing full array was %d.\n%d will be swapped with index %d.", arr.get(pos), arr.get(pos), i));
                binding.holderLinearLayout.addView(stepCardBuilder.getStepCard());

                //Selection Sort Condition
                int temp = arr.get(i);
                arr.set(i, arr.get(pos));
                arr.set(pos, temp);
            }
        });
    }

    private void clearLayout() {
        binding.holderLinearLayout.removeAllViews();
    }

    private void generateArrayView(List<Integer> arr, LinearLayout holder, int ptr, int color) {
        for (int i = 0; i < arr.size(); i++) {
            DataNodeBuilder dataNodeBuilder = new DataNodeBuilder(getApplicationContext());
            dataNodeBuilder.setNodeData(arr.get(i));
            dataNodeBuilder.setNodeIndex(i);
            if (i == ptr) {
                dataNodeBuilder.showIndexPointer();
                dataNodeBuilder.setNodeColor(color);
            }
            holder.addView(dataNodeBuilder.getNode());

            //requesting focus
            holder.requestChildFocus(holder.getChildAt(ptr), holder.getChildAt(ptr));
        }
    }
}