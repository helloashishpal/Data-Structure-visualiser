package com.ashish.visualizeds.topics.binary_search_tree.binary_search_tree_basics.deletion;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.Toast;

import com.ashish.visualizeds.builder.StepCardBuilder;
import com.ashish.visualizeds.classes.BinaryTreeNode;
import com.ashish.visualizeds.builder.BinarySearchTreeBuilder;
import com.ashish.visualizeds.classes.DataStructureAlgorithm;
import com.ashish.visualizeds.databinding.ActivityBinarySearchTreeDeletionVisualizerBinding;

import java.util.Random;

public class BinarySearchTreeDeletionVisualizerActivity extends AppCompatActivity {

    ActivityBinarySearchTreeDeletionVisualizerBinding binding;
    BinaryTreeNode root = null;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityBinarySearchTreeDeletionVisualizerBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());


        //filling header information
        DataStructureAlgorithm dataStructureAlgorithm = (DataStructureAlgorithm) getIntent().getSerializableExtra("data");
        binding.titleTextView.setText(dataStructureAlgorithm.getName());
        binding.difficultyTextView.setText(dataStructureAlgorithm.getDifficulty().toString());
        binding.iconImageView.setImageResource(dataStructureAlgorithm.getIcon());

        //Setting title
        setTitle(dataStructureAlgorithm.getName() + " Visualizer");


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

            int target = 0;
            try {
                target = Integer.parseInt(binding.targetEditText.getText().toString().trim());
            } catch (Exception e) {
                Toast.makeText(this, e.toString(), Toast.LENGTH_SHORT).show();
                return;
            }
            //Generating in Between layout
            int steps = 0;
            BinaryTreeNode temp = finalRoot;
            boolean found = false;
            while (temp != null) {
                //Generating Visuals
                StepCardBuilder stepCardBuilder = new StepCardBuilder(getApplicationContext());
                stepCardBuilder.setCardTitle(String.format("Step %d", ++steps));

                //Adding view to the holder of the Step Card
                BinarySearchTreeBuilder binarySearchTreeBuilder = new BinarySearchTreeBuilder(this);
                stepCardBuilder.getDataNodeHolder().addView(binarySearchTreeBuilder.generateBinarySearchTree(finalRoot, temp.data));

                //Description
                if (target == temp.data) {
                    stepCardBuilder.setCardDescription("The element to be deleted is found.");
                } else if (target < temp.data) {
                    stepCardBuilder.setCardDescription(String.format("%d is less than %d.\nTherefore we move to the left subtree.", target, temp.data));
                } else {
                    stepCardBuilder.setCardDescription(String.format("%d is greater than %d.\nTherefore we move to the right subtree.", target, temp.data));
                }
                binding.holderLinearLayout.addView(stepCardBuilder.getStepCard());

                //BST properties.
                if (target == temp.data) {
                    found = true;
                    break;
                } else if (target < temp.data) {
                    temp = temp.leftNode;
                } else {
                    temp = temp.rightNode;
                }
            }
            if (!found) {
                //Final Step Card
                StepCardBuilder stepCardBuilder = new StepCardBuilder(getApplicationContext());
                stepCardBuilder.setCardTitle("Binary Search Tree After Deletion.");
                stepCardBuilder.setCardDescription(String.format("The Binary Search Tree does not contain %d.\nTherefore, No need for deletion.\nThis is the final Binary Search Tree.", target));
                //Generating Tree for Step Card
                BinarySearchTreeBuilder binarySearchTreeBuilder = new BinarySearchTreeBuilder(this);
                stepCardBuilder.getDataNodeHolder().addView(binarySearchTreeBuilder.generateBinarySearchTree(finalRoot, target));
                //Adding view to the holder of the Step Card
                binding.holderLinearLayout.addView(stepCardBuilder.getStepCard());
            } else {
                StepCardBuilder stepCardBuilder = new StepCardBuilder(getApplicationContext());
                stepCardBuilder.setCardTitle(String.format("Step %d", ++steps));
                if (temp.leftNode == null && temp.rightNode == null) {
                    stepCardBuilder.setCardDescription("There exists no left and right subtree.\nTherefore the node can be directly deleted.");
                } else if (temp.leftNode != null && temp.rightNode == null) {
                    stepCardBuilder.setCardDescription("There exists no right subtree.\nTherefore the node can be directly deleted and the left subtree can be directly attached to the node.");
                } else if (temp.leftNode == null && temp.rightNode != null) {
                    stepCardBuilder.setCardDescription("There exists no left subtree.\nTherefore the node can be directly deleted and the right subtree can be directly attached to the node.");
                } else if (temp.leftNode != null && temp.rightNode != null) {
                    stepCardBuilder.setCardDescription("There exists both left and right subtree.\nTherefore the node cannot be directly deleted.\nTargeted node will be replaced by the Inorder Successor of the targeted node.");
                }
                binding.holderLinearLayout.addView(stepCardBuilder.getStepCard());

                this.root = deletionBST(finalRoot, target);

                //printing final tree.
                stepCardBuilder = new StepCardBuilder(getApplicationContext());
                stepCardBuilder.setCardTitle("Binary Search Tree After Deletion.");
                stepCardBuilder.setCardDescription(String.format("This is the final Binary Search Tree after deleting %d.", target));
                //Generating Tree for Step Card
                BinarySearchTreeBuilder binarySearchTreeBuilder = new BinarySearchTreeBuilder(this);
                stepCardBuilder.getDataNodeHolder().addView(binarySearchTreeBuilder.generateBinarySearchTree(this.root, target));
                //Adding view to the holder of the Step Card
                binding.holderLinearLayout.addView(stepCardBuilder.getStepCard());
            }
        });
    }

    private BinaryTreeNode deletionBST(BinaryTreeNode finalRoot, int target) {
        if (finalRoot == null) return null;
        if (finalRoot.data == target) {
            if (finalRoot.leftNode == null && finalRoot.rightNode == null) {
                finalRoot = null;
            } else if (finalRoot.leftNode != null && finalRoot.rightNode == null) {
                finalRoot = finalRoot.leftNode;
            } else if (finalRoot.leftNode == null && finalRoot.rightNode != null) {
                finalRoot = finalRoot.rightNode;
            } else if (finalRoot.leftNode != null && finalRoot.rightNode != null) {
                BinaryTreeNode temp = finalRoot.leftNode;
                while (temp.rightNode != null) {
                    temp = temp.rightNode;
                }
                finalRoot.data = temp.data;
                finalRoot.leftNode = deletionBST(finalRoot.leftNode, temp.data);
            }
        } else if (target < finalRoot.data) {
            finalRoot.leftNode = deletionBST(finalRoot.leftNode, target);
        } else {
            finalRoot.rightNode = deletionBST(finalRoot.rightNode, target);
        }
        return finalRoot;
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
