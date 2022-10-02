package com.ashish.visualizeds.topics.array.searching.linear_search;

import android.os.Bundle;
import android.widget.LinearLayout;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.ashish.visualizeds.builder.DataNodeBuilder;
import com.ashish.visualizeds.builder.StepCardBuilder;
import com.ashish.visualizeds.R;
import com.ashish.visualizeds.classes.DataStructureAlgorithm;
import com.ashish.visualizeds.utils.DataStructureUtil;
import com.ashish.visualizeds.databinding.ActivityLinearSearchVisualizerBinding;

import java.util.List;

public class LinearSearchVisualizerActivity extends AppCompatActivity {

    private static final int COLOR_TARGET_MATCHED = R.color.dark_red;
    private static final int COLOR_TARGET_NOT_MATCHED = R.color.citron;

    private ActivityLinearSearchVisualizerBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityLinearSearchVisualizerBinding.inflate(getLayoutInflater());
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

            //getting array and target
            List<Integer> arr = DataStructureUtil.stringToArray(binding.arrayEditText.getText().toString().trim());
            int target;
            try {
                target = Integer.parseInt(binding.targetEditText.getText().toString());
            } catch (Exception e) {
                Toast.makeText(this, e.toString(), Toast.LENGTH_SHORT).show();
                return;
            }

            //Generating Visuals
            int steps = 0;
            for (int i = 0; i < arr.size(); i++) {
                StepCardBuilder stepCardBuilder = new StepCardBuilder(getApplicationContext());
                //Generating step card
                stepCardBuilder.setCardTitle(String.format("Step %d", ++steps));
                if (arr.get(i) == target) {
                    stepCardBuilder.setCardDescription(String.format("%d is equal to %d.\nTherefore, we found the target.", arr.get(i), target));
                } else {
                    stepCardBuilder.setCardDescription(String.format("%d is not equal to %d.\nTherefore, we search further for the target.", arr.get(i), target));
                }

                //adding data to the step card
                generateArrayView(arr, stepCardBuilder.getDataNodeHolder(), i, target);

                //Adding view to the holder of the Step Card
                binding.holderLinearLayout.addView(stepCardBuilder.getStepCard());
                if (arr.get(i) == target) {
                    return;
                }
            }
            StepCardBuilder stepCardBuilder = new StepCardBuilder(getApplicationContext());
            stepCardBuilder.setCardTitle(String.format("Step %d", ++steps));
            stepCardBuilder.setCardDescription(String.format("%d is not found in the array.",target));
//            generateArrayView(arr, stepCardBuilder.getDataNodeHolder(), i, target);
            binding.holderLinearLayout.addView(stepCardBuilder.getStepCard());

        });
    }

    private void clearLayout() {
        binding.holderLinearLayout.removeAllViews();
    }

    private void generateArrayView(List<Integer> arr, LinearLayout holder, int index, int target) {
        //generating data nodes
        for (int i = 0; i < arr.size(); i++) {
            DataNodeBuilder dataNodeBuilder = new DataNodeBuilder(getApplicationContext());
            dataNodeBuilder.setNodeData(arr.get(i));
            dataNodeBuilder.setNodeIndex(i);
            if (i == index) {
                dataNodeBuilder.showIndexPointer();
                if (arr.get(i) == target) {
                    dataNodeBuilder.setNodeColor(COLOR_TARGET_MATCHED);
                } else {
                    dataNodeBuilder.setNodeColor(COLOR_TARGET_NOT_MATCHED);
                }
            }
            //adding data node to the linearLayout.
            holder.addView(dataNodeBuilder.getNode());

            //requesting focus
            holder.requestChildFocus(holder.getChildAt(index), holder.getChildAt(index));
        }
    }
}