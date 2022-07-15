package com.ashish.visualizeds.topics.array.searching.binary_search;

import android.os.Bundle;
import android.widget.LinearLayout;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.ashish.visualizeds.builder.DataNodeBuilder;
import com.ashish.visualizeds.builder.StepCardBuilder;
import com.ashish.visualizeds.R;
import com.ashish.visualizeds.classes.DataStructureAlgorithm;
import com.ashish.visualizeds.utils.DataStructureUtil;
import com.ashish.visualizeds.databinding.ActivityBinarySearchVisualizerBinding;

import java.util.List;

public class BinarySearchVisualizerActivity extends AppCompatActivity {

    private static final int COLOR_TARGET_MATCHED = R.color.dark_red;
    private static final int COLOR_TARGET_NOT_MATCHED = R.color.citron;

    private ActivityBinarySearchVisualizerBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityBinarySearchVisualizerBinding.inflate(getLayoutInflater());
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
            int target;
            try {
                target = Integer.parseInt(binding.targetEditText.getText().toString());
            } catch (Exception e) {
                Toast.makeText(this, e.toString(), Toast.LENGTH_SHORT).show();
                return;
            }

            int start = 0, end = arr.size() - 1;
            int steps = 0;
            while (start <= end) {
                int mid = (start + end) / 2;
                //generating Step Card
                StepCardBuilder stepCardBuilder = new StepCardBuilder(getApplicationContext());
                stepCardBuilder.setCardTitle(String.format("Step %d", ++steps));
                if (arr.get(mid) == target) {
                    stepCardBuilder.setCardDescription("Target was found at the middle position.");
                } else {
                    if (arr.get(mid) > target) {
                        stepCardBuilder.setCardDescription("Target is smaller than element at the middle position.\nTherefore we eliminate right side from the middle.");
                    } else {
                        stepCardBuilder.setCardDescription("Target is greater than element at the middle position.\nTherefore we eliminate left side from the middle.");
                    }
                }

                //Generating Data for Step Card
                generateArrayView(arr, stepCardBuilder.getDataNodeHolder(), start, end, target);

                //Adding view to the holder of the Step Card
                binding.holderLinearLayout.addView(stepCardBuilder.getStepCard());

                //Binary Search Conditions
                if (arr.get(mid) == target) {
                    return;
                } else if (arr.get(mid) > target) {
                    end = mid - 1;
                } else {
                    start = mid + 1;
                }
            }
        });
    }

    private void clearLayout() {
        binding.holderLinearLayout.removeAllViews();
    }

    private void generateArrayView(List<Integer> arr, LinearLayout holder, int start, int end, int target) {
        for (int i = 0; i < arr.size(); i++) {
            //Initializing the data node view
            DataNodeBuilder dataNodeBuilder = new DataNodeBuilder(getApplicationContext());
            dataNodeBuilder.setNodeData(arr.get(i));
            dataNodeBuilder.setNodeIndex(i);

            //hiding views and showing arrows
            int mid = (start + end) / 2;
            if (i == mid) {
                dataNodeBuilder.showIndexPointer();
                if (arr.get(i) == target) {
                    dataNodeBuilder.setNodeColor(COLOR_TARGET_MATCHED);
                } else {
                    dataNodeBuilder.setNodeColor(COLOR_TARGET_NOT_MATCHED);
                }
            }
            if (i < start || i > end) {
                dataNodeBuilder.hideNode();
            }
            //adding data node to the linearLayout.
            holder.addView(dataNodeBuilder.getNode());

            //requesting focus
            holder.requestChildFocus(holder.getChildAt(mid), holder.getChildAt(mid));
        }
    }
}