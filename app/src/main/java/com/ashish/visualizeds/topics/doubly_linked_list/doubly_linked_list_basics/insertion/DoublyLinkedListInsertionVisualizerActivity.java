package com.ashish.visualizeds.topics.doubly_linked_list.doubly_linked_list_basics.insertion;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.LinearLayout;
import android.widget.Toast;

import com.ashish.visualizeds.builder.DoublyLinkedListNodeBuilder;
import com.ashish.visualizeds.builder.StepCardBuilder;
import com.ashish.visualizeds.classes.DataStructureAlgorithm;
import com.ashish.visualizeds.databinding.ActivityDoublyLinkedListInsertionVisualizerBinding;

import java.util.ArrayList;
import java.util.List;

public class DoublyLinkedListInsertionVisualizerActivity extends AppCompatActivity {
    private ActivityDoublyLinkedListInsertionVisualizerBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityDoublyLinkedListInsertionVisualizerBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());


        //filling header information
        DataStructureAlgorithm dataStructureAlgorithm = (DataStructureAlgorithm) getIntent().getSerializableExtra("data");
        binding.titleTextView.setText(dataStructureAlgorithm.getName());
        binding.difficultyTextView.setText(dataStructureAlgorithm.getDifficulty().toString());
        binding.iconImageView.setImageResource(dataStructureAlgorithm.getIcon());

        //Setting title
        setTitle(dataStructureAlgorithm.getName() + " Visualizer");


        List<Integer> arr = new ArrayList<>();
        initialView(arr);

        //button click listener
        binding.visualizeButton.setOnClickListener(v -> {
            //clear all views of the linear Layout
            clearLayout();

            //Generating Visuals
            initialView(arr);


            //Generating in Between layout
            int steps = 0;
            for (int i = 0; i < arr.size(); i++) {
                //Generating Visuals
                StepCardBuilder stepCardBuilder = new StepCardBuilder(getApplicationContext());
                stepCardBuilder.setCardTitle(String.format("Step %d", ++steps));
                if (i != arr.size() - 1)
                    stepCardBuilder.setCardDescription("This is not the end of the List.\nTherefore we move to the next node.");
                else
                    stepCardBuilder.setCardDescription("We reached the end of the Doubly Linked List because the next pointer points to NULL.\n\nTherefore, we will add the Node here.");
                //Generating Data for Step Card
                generateLinkedListView(arr, stepCardBuilder.getDataNodeHolder(), i);
                //Adding view to the holder of the Step Card
                binding.holderLinearLayout.addView(stepCardBuilder.getStepCard());
            }

            //Inserting the value
            int target = 0;
            try {
                target = Integer.parseInt(binding.targetEditText.getText().toString().trim());
            } catch (Exception e) {
                Toast.makeText(this, e.toString(), Toast.LENGTH_SHORT).show();
                return;
            }
            arr.add(target);

            StepCardBuilder stepCardBuilder = new StepCardBuilder(getApplicationContext());
            stepCardBuilder.setCardTitle("Final Step");
            stepCardBuilder.setCardDescription(String.format("Doubly Linked List after adding node with value %d.", target));
            //Generating Data for Step Card
            generateLinkedListView(arr, stepCardBuilder.getDataNodeHolder(), arr.size() - 1);
            //Adding view to the holder of the Step Card
            binding.holderLinearLayout.addView(stepCardBuilder.getStepCard());
        });
    }

    private void clearLayout() {
        binding.holderLinearLayout.removeAllViews();
    }

    private void initialView(List<Integer> arr) {
        StepCardBuilder builder = new StepCardBuilder(getApplicationContext());
        builder.setCardTitle("Initial doubly Doubly Linked List");
        builder.setCardDescription("This is the initial doubly Doubly Linked List.");
        //Generating Data for Step Card
        generateLinkedListView(arr, builder.getDataNodeHolder(), -1);
        //Adding view to the holder of the Step Card
        binding.holderLinearLayout.addView(builder.getStepCard());
    }

    private void generateLinkedListView(@NonNull List<Integer> arr, @NonNull LinearLayout holder, int index) {
        //adding head node
        DoublyLinkedListNodeBuilder doublyLinkedListNodeBuilder = new DoublyLinkedListNodeBuilder(getApplicationContext());
        doublyLinkedListNodeBuilder.setNodeData("HEAD");
        holder.addView(doublyLinkedListNodeBuilder.getNode());

        //adding data nodes
        for (int i = 0; i < arr.size(); i++) {
            //Initializing the data node view
            doublyLinkedListNodeBuilder = new DoublyLinkedListNodeBuilder(getApplicationContext());
            doublyLinkedListNodeBuilder.setNodeData(arr.get(i));
            if (i == index) {
                doublyLinkedListNodeBuilder.showIndexPointer();
            }
            //adding data node to the linearLayout.
            holder.addView(doublyLinkedListNodeBuilder.getNode());

            //requesting focus
            holder.requestChildFocus(holder.getChildAt(index+ 1),holder.getChildAt(index+ 1));
        }

        //adding last NULL node
        doublyLinkedListNodeBuilder = new DoublyLinkedListNodeBuilder(getApplicationContext());
        doublyLinkedListNodeBuilder.setNodeData("NULL");
        doublyLinkedListNodeBuilder.hideNodeNextPointer();
        holder.addView(doublyLinkedListNodeBuilder.getNode());
    }
}