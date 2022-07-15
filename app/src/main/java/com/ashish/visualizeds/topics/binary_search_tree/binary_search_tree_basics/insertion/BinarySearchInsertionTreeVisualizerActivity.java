package com.ashish.visualizeds.topics.binary_search_tree.binary_search_tree_basics.insertion;

import android.os.Bundle;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.ashish.visualizeds.builder.StepCardBuilder;
import com.ashish.visualizeds.classes.BinaryTreeNode;
import com.ashish.visualizeds.builder.BinarySearchTreeBuilder;
import com.ashish.visualizeds.classes.DataStructureAlgorithm;
import com.ashish.visualizeds.databinding.ActivityBinarySearchTreeInsertionVisualizerBinding;

import java.util.Random;

public class BinarySearchInsertionTreeVisualizerActivity extends AppCompatActivity {

    private ActivityBinarySearchTreeInsertionVisualizerBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityBinarySearchTreeInsertionVisualizerBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        //filling header information
        DataStructureAlgorithm dataStructureAlgorithm = (DataStructureAlgorithm) getIntent().getSerializableExtra("data");
        binding.titleTextView.setText(dataStructureAlgorithm.getName());
        binding.difficultyTextView.setText(dataStructureAlgorithm.getDifficulty().toString());
        binding.iconImageView.setImageResource(dataStructureAlgorithm.getIcon());

        //Setting title
        setTitle(dataStructureAlgorithm.getName() + " Visualizer");
        BinaryTreeNode root = null;
        //Binary Tree
        for (int i = 0; i < 3; i++) {
            int rand = new Random().nextInt() % 50;
            root = BinaryTreeNode.insertNode(root, rand);
        }
        initialView(root);


        //button click listener
        BinaryTreeNode finalRoot = root;
        binding.visualizeButton.setOnClickListener(v -> {
            //clear all views of the linear Layout
            clearLayout();
            initialView(finalRoot);
            BinaryTreeNode temp = finalRoot;

            int target = 0;
            try {
                target = Integer.parseInt(binding.targetEditText.getText().toString().trim());
            } catch (Exception e) {
                Toast.makeText(this, e.toString(), Toast.LENGTH_SHORT).show();
                return;
            }
            //Generating in Between layout
            int steps = 0;
            while (temp != null) {
                //Generating Visuals
                StepCardBuilder stepCardBuilder = new StepCardBuilder(getApplicationContext());
                stepCardBuilder.setCardTitle(String.format("Step %d", ++steps));

                //Adding view to the holder of the Step Card
                BinarySearchTreeBuilder binarySearchTreeBuilder = new BinarySearchTreeBuilder(this);
                stepCardBuilder.getDataNodeHolder().addView(binarySearchTreeBuilder.generateBinarySearchTree(finalRoot, temp.data));

                //Description
                if (target == temp.data) {
                    stepCardBuilder.setCardDescription("The element to be inserted is already present in the Binary Search Tree.");
                } else if (target < temp.data) {
                    stepCardBuilder.setCardDescription(String.format("%d is less than %d.\nTherefore we move to the left subtree.", target, temp.data));
                } else {
                    stepCardBuilder.setCardDescription(String.format("%d is greater than %d.\nTherefore we move to the right subtree.", target, temp.data));
                }
                binding.holderLinearLayout.addView(stepCardBuilder.getStepCard());

                //BST properties.
                if (target == temp.data) {
                    return;
                } else if (target < temp.data) {
                    temp = temp.leftNode;
                } else {
                    temp = temp.rightNode;
                }
                if (temp == null) {
                    stepCardBuilder = new StepCardBuilder(getApplicationContext());
                    stepCardBuilder.setCardTitle(String.format("Step %d", ++steps));
                    stepCardBuilder.setCardDescription("We reached a null node so we will insert the node here.");
                    //Adding view to the holder of the Step Card
                    binding.holderLinearLayout.addView(stepCardBuilder.getStepCard());
                }
            }
            //Final Step Card
            BinaryTreeNode.insertNode(finalRoot, target);
            StepCardBuilder stepCardBuilder = new StepCardBuilder(getApplicationContext());
            stepCardBuilder.setCardTitle("Binary Search Tree After Insertion");
            stepCardBuilder.setCardDescription("This is the Binary Search Tree after Insertion.");

            //Generating Tree for Step Card
            BinarySearchTreeBuilder binarySearchTreeBuilder = new BinarySearchTreeBuilder(this);
            stepCardBuilder.getDataNodeHolder().addView(binarySearchTreeBuilder.generateBinarySearchTree(finalRoot, target));

            //Adding view to the holder of the Step Card
            binding.holderLinearLayout.addView(stepCardBuilder.getStepCard());
        });
    }

    private void clearLayout() {
        binding.holderLinearLayout.removeAllViews();
    }

    private void initialView(BinaryTreeNode root) {
        StepCardBuilder stepCardBuilder = new StepCardBuilder(getApplicationContext());
        stepCardBuilder.setCardTitle("Initial Binary Search Tree");
        stepCardBuilder.setCardDescription("This is the initial Binary Search Tree.");

        //Generating Tree for Step Card
        BinarySearchTreeBuilder binarySearchTreeBuilder = new BinarySearchTreeBuilder(this);
        stepCardBuilder.getDataNodeHolder().addView(binarySearchTreeBuilder.generateBinarySearchTree(root, Integer.MAX_VALUE));

        //Adding view to the holder of the Step Card
        binding.holderLinearLayout.addView(stepCardBuilder.getStepCard());
    }
}
