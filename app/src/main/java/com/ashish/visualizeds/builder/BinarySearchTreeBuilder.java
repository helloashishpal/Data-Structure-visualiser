package com.ashish.visualizeds.builder;

import android.annotation.SuppressLint;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.appcompat.content.res.AppCompatResources;
import androidx.constraintlayout.widget.ConstraintLayout;

import com.ashish.visualizeds.classes.BinaryTreeNode;
import com.ashish.visualizeds.R;

public class BinarySearchTreeBuilder {
    private final Context context;
    private final ConstraintLayout constraintLayout;

    @SuppressLint("ResourceType")
    public BinarySearchTreeBuilder(Context context) {
        this.context = context;
        //Generating constraint layout.
        constraintLayout = new ConstraintLayout(context);
        ConstraintLayout.LayoutParams layoutParams = new ConstraintLayout.LayoutParams(ViewGroup.LayoutParams.WRAP_CONTENT, ViewGroup.LayoutParams.WRAP_CONTENT);
        constraintLayout.setLayoutParams(layoutParams);
    }

    public ConstraintLayout generateBinarySearchTree(BinaryTreeNode root, int target) {
        root = generateBinarySearchTreeHelper(root, target);
        root = generateBinarySearchTreeConstraintHelper(root);
        constraintLayout.addView(root.nodeView);
        return constraintLayout;
    }

    private BinaryTreeNode generateBinarySearchTreeHelper(BinaryTreeNode root, int target) {
        if (root == null) return null;
        //Generating a view of the BST Node.
        root.nodeView = LayoutInflater.from(context).inflate(R.layout.item_binary_search_tree_node, null);

        //Adding Values to the nodes.
        ((TextView) root.nodeView.findViewById(R.id.dataNodeDataTextView)).setText(String.valueOf(root.data));
        if (root.rightNode == null || root.leftNode == null)
            root.nodeView.findViewById(R.id.divider).setVisibility(View.GONE);

        if (root.data == target) {
            root.nodeView.findViewById(R.id.dataNodeCardView).setForeground(AppCompatResources.getDrawable(context, R.drawable.red_border));
        }

        //recursive fn for left and right subtree.
        root.leftNode = generateBinarySearchTreeHelper(root.leftNode, target);
        root.rightNode = generateBinarySearchTreeHelper(root.rightNode, target);
        return root;
    }

    private BinaryTreeNode generateBinarySearchTreeConstraintHelper(BinaryTreeNode root) {
        if (root == null) return null;
        //Recursive calls
        root.leftNode = generateBinarySearchTreeConstraintHelper(root.leftNode);
        root.rightNode = generateBinarySearchTreeConstraintHelper(root.rightNode);

        View currentView = root.nodeView;
        LinearLayout linearLayout = currentView.findViewById(R.id.nodeHolder);

        LinearLayout.LayoutParams params = new LinearLayout.LayoutParams(0, LinearLayout.LayoutParams.WRAP_CONTENT);
        params.weight = 1;
        if (root.leftNode != null) {
            linearLayout.addView(root.leftNode.nodeView, params);
        }
        if (root.rightNode != null) {
            linearLayout.addView(root.rightNode.nodeView, params);
        }
        root.nodeView = currentView;
        return root;
    }

}
