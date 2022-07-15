package com.ashish.visualizeds.topics.binary_search_tree.traversal.postfix;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

import com.ashish.visualizeds.builder.BinarySearchTreeBuilder;
import com.ashish.visualizeds.builder.StepCardBuilder;
import com.ashish.visualizeds.classes.BinaryTreeNode;
import com.ashish.visualizeds.classes.DataStructureAlgorithm;
import com.ashish.visualizeds.databinding.ActivityBinarySearchTreePostfixVisualizerBinding;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class BinarySearchPostfixTreeVisualizerActivity extends AppCompatActivity {

    private ActivityBinarySearchTreePostfixVisualizerBinding binding;
    private List<Integer> arr;
    private int steps = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityBinarySearchTreePostfixVisualizerBinding.inflate(getLayoutInflater());
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
        for (int i = 0; i < 5; i++) {
            int rand = new Random().nextInt() % 500;
            root = BinaryTreeNode.insertNode(root, rand);
        }
        initialView(root);


        //button click listener
        BinaryTreeNode finalRoot = root;
        binding.visualizeButton.setOnClickListener(v -> {
            //clear all views of the linear Layout
            clearLayout();
            initialView(finalRoot);

            arr = new ArrayList<>();
            steps = 0;

            postfixHelper(finalRoot, finalRoot);
        });
    }

    private void clearLayout() {
        binding.holderLinearLayout.removeAllViews();
    }


    private void postfixHelper(BinaryTreeNode finalRoot, BinaryTreeNode root) {
        if (root == null) {
            //Generating Visuals
            StepCardBuilder stepCardBuilder = new StepCardBuilder(getApplicationContext());
            stepCardBuilder.setCardTitle(String.format("Step %d", ++steps));
            //Description
            stepCardBuilder.setCardDescription("We reach a null point.\nTherefore we move back to the parent node");
            binding.holderLinearLayout.addView(stepCardBuilder.getStepCard());
            return;
        }

        //LEFT SUBTREE VISUAL + CALL
        {
            //Generating Visuals
            StepCardBuilder stepCardBuilder = new StepCardBuilder(getApplicationContext());
            stepCardBuilder.setCardTitle(String.format("Step %d", ++steps));
            //Adding view to the holder of the Step Card
            BinarySearchTreeBuilder binarySearchTreeBuilder = new BinarySearchTreeBuilder(this);
            stepCardBuilder.getDataNodeHolder().addView(binarySearchTreeBuilder.generateBinarySearchTree(finalRoot, root.data));
            //Description
            stepCardBuilder.setCardDescription(String.format("We move to the left subtree.\nCurrent list : %s", arr.toString()));
            binding.holderLinearLayout.addView(stepCardBuilder.getStepCard());

            //RECURSIVE LEFT SUBTREE CALL
            postfixHelper(finalRoot, root.leftNode);
        }

        //RIGHT SUBTREE VISUAL + CALL
        {
            //Generating Visuals
            StepCardBuilder stepCardBuilder = new StepCardBuilder(getApplicationContext());
            stepCardBuilder.setCardTitle(String.format("Step %d", ++steps));
            //Adding view to the holder of the Step Card
            BinarySearchTreeBuilder binarySearchTreeBuilder = new BinarySearchTreeBuilder(this);
            stepCardBuilder.getDataNodeHolder().addView(binarySearchTreeBuilder.generateBinarySearchTree(finalRoot, root.data));
            //Description
            stepCardBuilder.setCardDescription(String.format("We move to the right subtree.\nCurrent list : %s", arr.toString()));
            binding.holderLinearLayout.addView(stepCardBuilder.getStepCard());

            //RECURSIVE RIGHT SUBTREE CALL
            postfixHelper(finalRoot, root.rightNode);
        }

        // NODE VISUAL + CALL
        {
            //adding the middle value
            arr.add(root.data);
            //Generating Visuals

            StepCardBuilder stepCardBuilder = new StepCardBuilder(getApplicationContext());
            stepCardBuilder.setCardTitle(String.format("Step %d", ++steps));
            //Adding view to the holder of the Step Card
            BinarySearchTreeBuilder binarySearchTreeBuilder = new BinarySearchTreeBuilder(this);
            stepCardBuilder.getDataNodeHolder().addView(binarySearchTreeBuilder.generateBinarySearchTree(finalRoot, root.data));
            //Description
            stepCardBuilder.setCardDescription(String.format("Both Left and right SubTree traversed.\nTherefore, %d is now added to the traversed list.\nCurrent list : %s \n\nNow we move back to the parent Node.", root.data, arr.toString()));
            binding.holderLinearLayout.addView(stepCardBuilder.getStepCard());

        }
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