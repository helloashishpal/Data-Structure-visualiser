package com.ashish.visualizeds.topics.array.sorting.insertion_sort;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.LinearLayout;

import com.ashish.visualizeds.builder.DataNodeBuilder;
import com.ashish.visualizeds.builder.StepCardBuilder;
import com.ashish.visualizeds.classes.DataStructureAlgorithm;
import com.ashish.visualizeds.utils.DataStructureUtil;
import com.ashish.visualizeds.R;
import com.ashish.visualizeds.databinding.ActivityInsertionSortVisualizerBinding;

import java.util.List;

public class InsertionSortVisualizerActivity extends AppCompatActivity {
    private static final int COLOR_SWAPPED = R.color.dark_red;
    private static final int COLOR_NOT_SWAPPED = R.color.citron;
    private ActivityInsertionSortVisualizerBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityInsertionSortVisualizerBinding.inflate(getLayoutInflater());
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

            //Insertion Sort
            int steps = 0;
            for (int i = 1; i < arr.size(); i++) {
                int temp = arr.get(i);
                int j = i - 1;
                while (j >= 0 && temp <= arr.get(j)) {
                    //Building step card
                    StepCardBuilder stepCardBuilder = new StepCardBuilder(getApplicationContext());
                    stepCardBuilder.setCardTitle(String.format("Step %d", ++steps));
                    stepCardBuilder.setCardDescription(String.format("%d is greater than %d.\nTherefore, moving array element right.", arr.get(j), temp));

                    //Generating Data for Step Card
                    generateArrayView(arr, stepCardBuilder.getDataNodeHolder(), j, COLOR_SWAPPED);

                    //Adding view to the holder of the Step Card
                    binding.holderLinearLayout.addView(stepCardBuilder.getStepCard());

                    //Insertion Sort condition
                    arr.set(j + 1, arr.get(j));
                    arr.set(j, temp);
                    j = j - 1;
                }
            }
            //Building step card
            StepCardBuilder stepCardBuilder = new StepCardBuilder(getApplicationContext());
            stepCardBuilder.setCardTitle(String.format("Step %d", ++steps));
            stepCardBuilder.setCardDescription("The Array is now sorted!");
            //Adding view to the holder of the Step Card
            binding.holderLinearLayout.addView(stepCardBuilder.getStepCard());
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
            holder.requestChildFocus(holder.getChildAt(j), holder.getChildAt(j));
        }
    }
}