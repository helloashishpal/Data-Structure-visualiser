package com.ashish.visualizeds.utils;

import androidx.annotation.NonNull;

import com.ashish.visualizeds.topics.array.searching.binary_search.BinarySearchVisualizerActivity;
import com.ashish.visualizeds.topics.array.searching.linear_search.LinearSearchVisualizerActivity;
import com.ashish.visualizeds.topics.array.sorting.bubble_sort.BubbleSortVisualizerActivity;
import com.ashish.visualizeds.topics.array.sorting.selection_sort.SelectionSortVisualizerActivity;
import com.ashish.visualizeds.topics.binary_search_tree.binary_search_tree_basics.deletion.BinarySearchTreeDeletionVisualizerActivity;
import com.ashish.visualizeds.topics.binary_search_tree.binary_search_tree_basics.insertion.BinarySearchInsertionTreeVisualizerActivity;
import com.ashish.visualizeds.topics.binary_search_tree.traversal.infix.BinarySearchInfixTreeVisualizerActivity;
import com.ashish.visualizeds.topics.linked_list.linked_list_basics.deletion.LinkedListDeletionVisualizerActivity;
import com.ashish.visualizeds.R;
import com.ashish.visualizeds.classes.DataStructure;
import com.ashish.visualizeds.classes.DataStructureAlgorithm;
import com.ashish.visualizeds.classes.DataStructureAlgorithmContent;
import com.ashish.visualizeds.classes.DataStructureTopic;
import com.ashish.visualizeds.classes.Difficulty;
import com.ashish.visualizeds.topics.array.sorting.insertion_sort.InsertionSortVisualizerActivity;
import com.ashish.visualizeds.topics.binary_search_tree.traversal.postfix.BinarySearchPostfixTreeVisualizerActivity;
import com.ashish.visualizeds.topics.binary_search_tree.traversal.prefix.BinarySearchPrefixTreeVisualizerActivity;
import com.ashish.visualizeds.topics.doubly_linked_list.doubly_linked_list_basics.deletion.DoublyLinkedListDeletionVisualizerActivity;
import com.ashish.visualizeds.topics.doubly_linked_list.doubly_linked_list_basics.insertion.DoublyLinkedListInsertionVisualizerActivity;
import com.ashish.visualizeds.topics.doubly_linked_list.doubly_linked_list_basics.traversal.DoublyLinkedListTraversalVisualizerActivity;
import com.ashish.visualizeds.topics.linked_list.linked_list_basics.insertion.LinkedListInsertionVisualizerActivity;
import com.ashish.visualizeds.topics.linked_list.linked_list_basics.traversal.LinkedListTraversalVisualizerActivity;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class DataStructureUtil {

    public static List<Integer> listOfColors = new ArrayList<>(Arrays.asList(R.color.oxford_blue, R.color.dark_green, R.color.dark_red, R.color.old_lace_black));

    public static List<DataStructure> dataStructures =
            new ArrayList<>(Arrays.asList(
                    new DataStructure("Array",
                            new ArrayList<>(Arrays.asList(
                                    new DataStructureTopic("Searching",
                                            new ArrayList<>(Arrays.asList(
                                                    new DataStructureAlgorithm("Linear Search", LinearSearchVisualizerActivity.class,
                                                            new DataStructureAlgorithmContent(
                                                                    DataStructureAlgorithmContentUtil.LINEAR_SEARCH_THEORY,
                                                                    DataStructureAlgorithmContentUtil.LINEAR_SEARCH_ALGORITHM,
                                                                    DataStructureAlgorithmContentUtil.LINEAR_SEARCH_CODE,
                                                                    DataStructureAlgorithmContentUtil.LINEAR_SEARCH_WORST_CASE,
                                                                    DataStructureAlgorithmContentUtil.LINEAR_SEARCH_AVERAGE_CASE,
                                                                    DataStructureAlgorithmContentUtil.LINEAR_SEARCH_BEST_CASE),
                                                            Difficulty.BASIC, R.drawable.ic_linear_search),
                                                    new DataStructureAlgorithm("Binary Search", BinarySearchVisualizerActivity.class,
                                                            new DataStructureAlgorithmContent(
                                                                    DataStructureAlgorithmContentUtil.BINARY_SEARCH_THEORY,
                                                                    DataStructureAlgorithmContentUtil.BINARY_SEARCH_ALGORITHM,
                                                                    DataStructureAlgorithmContentUtil.BINARY_SEARCH_CODE,
                                                                    DataStructureAlgorithmContentUtil.BINARY_SEARCH_WORST_CASE,
                                                                    DataStructureAlgorithmContentUtil.BINARY_SEARCH_AVERAGE_CASE,
                                                                    DataStructureAlgorithmContentUtil.BINARY_SEARCH_BEST_CASE),
                                                            Difficulty.EASY, R.drawable.ic_binary_search)
                                            )), Difficulty.EASY, R.drawable.ic_search),
                                    new DataStructureTopic("Sorting",
                                            new ArrayList<>(Arrays.asList(
                                                    new DataStructureAlgorithm("Bubble Sort", BubbleSortVisualizerActivity.class,
                                                            new DataStructureAlgorithmContent(
                                                                    DataStructureAlgorithmContentUtil.BUBBLE_SORT_THEORY,
                                                                    DataStructureAlgorithmContentUtil.BUBBLE_SORT_ALGORITHM,
                                                                    DataStructureAlgorithmContentUtil.BUBBLE_SORT_CODE,
                                                                    DataStructureAlgorithmContentUtil.BUBBLE_SORT_WORST_CASE,
                                                                    DataStructureAlgorithmContentUtil.BUBBLE_SORT_AVERAGE_CASE,
                                                                    DataStructureAlgorithmContentUtil.BUBBLE_SORT_BEST_CASE),
                                                            Difficulty.BASIC, R.drawable.ic_bubble_sort),
                                                    new DataStructureAlgorithm("Selection Sort", SelectionSortVisualizerActivity.class,
                                                            new DataStructureAlgorithmContent(
                                                                    DataStructureAlgorithmContentUtil.SELECTION_SORT_THEORY,
                                                                    DataStructureAlgorithmContentUtil.SELECTION_SORT_ALGORITHM,
                                                                    DataStructureAlgorithmContentUtil.SELECTION_SORT_CODE,
                                                                    DataStructureAlgorithmContentUtil.SELECTION_SORT_WORST_CASE,
                                                                    DataStructureAlgorithmContentUtil.SELECTION_SORT_AVERAGE_CASE,
                                                                    DataStructureAlgorithmContentUtil.SELECTION_SORT_BEST_CASE),
                                                            Difficulty.BASIC, R.drawable.ic_selection_sort),
                                                    new DataStructureAlgorithm("Insertion Sort", InsertionSortVisualizerActivity.class,
                                                            new DataStructureAlgorithmContent(
                                                                    DataStructureAlgorithmContentUtil.INSERTION_SORT_THEORY,
                                                                    DataStructureAlgorithmContentUtil.INSERTION_SORT_ALGORITHM,
                                                                    DataStructureAlgorithmContentUtil.INSERTION_SORT_CODE,
                                                                    DataStructureAlgorithmContentUtil.INSERTION_SORT_WORST_CASE,
                                                                    DataStructureAlgorithmContentUtil.INSERTION_SORT_AVERAGE_CASE,
                                                                    DataStructureAlgorithmContentUtil.INSERTION_SORT_BEST_CASE),
                                                            Difficulty.EASY, R.drawable.ic_insertion_sort),
                                                    new DataStructureAlgorithm("Merge Sort", null,
                                                            new DataStructureAlgorithmContent(
                                                                    DataStructureAlgorithmContentUtil.MERGE_SORT_THEORY,
                                                                    DataStructureAlgorithmContentUtil.MERGE_SORT_ALGORITHM,
                                                                    DataStructureAlgorithmContentUtil.MERGE_SORT_CODE,
                                                                    DataStructureAlgorithmContentUtil.MERGE_SORT_WORST_CASE,
                                                                    DataStructureAlgorithmContentUtil.MERGE_SORT_AVERAGE_CASE,
                                                                    DataStructureAlgorithmContentUtil.MERGE_SORT_BEST_CASE),
                                                            Difficulty.MEDIUM, R.drawable.ic_merge_sort),
                                                    new DataStructureAlgorithm("Quick Sort", null,
                                                            new DataStructureAlgorithmContent(
                                                                    DataStructureAlgorithmContentUtil.QUICK_SORT_THEORY,
                                                                    DataStructureAlgorithmContentUtil.QUICK_SORT_ALGORITHM,
                                                                    DataStructureAlgorithmContentUtil.QUICK_SORT_CODE,
                                                                    DataStructureAlgorithmContentUtil.QUICK_SORT_WORST_CASE,
                                                                    DataStructureAlgorithmContentUtil.QUICK_SORT_AVERAGE_CASE,
                                                                    DataStructureAlgorithmContentUtil.QUICK_SORT_BEST_CASE),
                                                            Difficulty.MEDIUM, R.drawable.ic_merge_sort)
                                            )), Difficulty.EASY, R.drawable.ic_sorting)
                            )), Difficulty.EASY, R.drawable.ic_array_24),
                    new DataStructure("Linked List",
                            new ArrayList<>(Arrays.asList(
                                    new DataStructureTopic("Linked List Basics",
                                            new ArrayList<>(Arrays.asList(
                                                    new DataStructureAlgorithm("Insertion", LinkedListInsertionVisualizerActivity.class,
                                                            new DataStructureAlgorithmContent(
                                                                    DataStructureAlgorithmContentUtil.LINKED_LIST_INSERTION_THEORY,
                                                                    DataStructureAlgorithmContentUtil.LINKED_LIST_INSERTION_ALGORITHM,
                                                                    DataStructureAlgorithmContentUtil.LINKED_LIST_INSERTION_CODE,
                                                                    DataStructureAlgorithmContentUtil.LINKED_LIST_INSERTION_WORST_CASE,
                                                                    DataStructureAlgorithmContentUtil.LINKED_LIST_INSERTION_AVERAGE_CASE,
                                                                    DataStructureAlgorithmContentUtil.LINKED_LIST_INSERTION_BEST_CASE),
                                                            Difficulty.EASY, R.drawable.ic_add),
                                                    new DataStructureAlgorithm("Traversal/Searching", LinkedListTraversalVisualizerActivity.class,
                                                            new DataStructureAlgorithmContent(
                                                                    DataStructureAlgorithmContentUtil.LINKED_LIST_TRAVERSAL_THEORY,
                                                                    DataStructureAlgorithmContentUtil.LINKED_LIST_TRAVERSAL_ALGORITHM,
                                                                    DataStructureAlgorithmContentUtil.LINKED_LIST_TRAVERSAL_CODE,
                                                                    DataStructureAlgorithmContentUtil.LINKED_LIST_TRAVERSAL_WORST_CASE,
                                                                    DataStructureAlgorithmContentUtil.LINKED_LIST_TRAVERSAL_AVERAGE_CASE,
                                                                    DataStructureAlgorithmContentUtil.LINKED_LIST_TRAVERSAL_BEST_CASE),
                                                            Difficulty.EASY, R.drawable.ic_linear_search),
                                                    new DataStructureAlgorithm("Deletion", LinkedListDeletionVisualizerActivity.class,
                                                            new DataStructureAlgorithmContent(
                                                                    DataStructureAlgorithmContentUtil.LINKED_LIST_DELETION_THEORY,
                                                                    DataStructureAlgorithmContentUtil.LINKED_LIST_DELETION_ALGORITHM,
                                                                    DataStructureAlgorithmContentUtil.LINKED_LIST_DELETION_CODE,
                                                                    DataStructureAlgorithmContentUtil.LINKED_LIST_DELETION_WORST_CASE,
                                                                    DataStructureAlgorithmContentUtil.LINKED_LIST_DELETION_AVERAGE_CASE,
                                                                    DataStructureAlgorithmContentUtil.LINKED_LIST_DELETION_BEST_CASE),
                                                            Difficulty.EASY, R.drawable.ic_deletion)
                                            )), Difficulty.EASY, R.drawable.ic_linked_list)
                            )), Difficulty.EASY, R.drawable.ic_linked_list),
                    new DataStructure("Doubly Linked List",
                            new ArrayList<>(Arrays.asList(
                                    new DataStructureTopic("Doubly Linked List Basics",
                                            new ArrayList<>(Arrays.asList(
                                                    new DataStructureAlgorithm("Insertion", DoublyLinkedListInsertionVisualizerActivity.class,
                                                            new DataStructureAlgorithmContent(
                                                                    DataStructureAlgorithmContentUtil.DOUBLY_LINKED_LIST_INSERTION_THEORY,
                                                                    DataStructureAlgorithmContentUtil.DOUBLY_LINKED_LIST_INSERTION_ALGORITHM,
                                                                    DataStructureAlgorithmContentUtil.DOUBLY_LINKED_LIST_INSERTION_CODE,
                                                                    DataStructureAlgorithmContentUtil.DOUBLY_LINKED_LIST_INSERTION_WORST_CASE,
                                                                    DataStructureAlgorithmContentUtil.DOUBLY_LINKED_LIST_INSERTION_AVERAGE_CASE,
                                                                    DataStructureAlgorithmContentUtil.DOUBLY_LINKED_LIST_INSERTION_BEST_CASE),
                                                            Difficulty.EASY, R.drawable.ic_add),
                                                    new DataStructureAlgorithm("Traversal/Searching", DoublyLinkedListTraversalVisualizerActivity.class,
                                                            new DataStructureAlgorithmContent(
                                                                    DataStructureAlgorithmContentUtil.DOUBLY_LINKED_LIST_TRAVERSAL_THEORY,
                                                                    DataStructureAlgorithmContentUtil.DOUBLY_LINKED_LIST_TRAVERSAL_ALGORITHM,
                                                                    DataStructureAlgorithmContentUtil.DOUBLY_LINKED_LIST_TRAVERSAL_CODE,
                                                                    DataStructureAlgorithmContentUtil.DOUBLY_LINKED_LIST_TRAVERSAL_WORST_CASE,
                                                                    DataStructureAlgorithmContentUtil.DOUBLY_LINKED_LIST_TRAVERSAL_AVERAGE_CASE,
                                                                    DataStructureAlgorithmContentUtil.DOUBLY_LINKED_LIST_TRAVERSAL_BEST_CASE),
                                                            Difficulty.EASY, R.drawable.ic_linear_search),
                                                    new DataStructureAlgorithm("Deletion", DoublyLinkedListDeletionVisualizerActivity.class,
                                                            new DataStructureAlgorithmContent(
                                                                    DataStructureAlgorithmContentUtil.DOUBLY_LINKED_LIST_DELETION_THEORY,
                                                                    DataStructureAlgorithmContentUtil.DOUBLY_LINKED_LIST_DELETION_ALGORITHM,
                                                                    DataStructureAlgorithmContentUtil.DOUBLY_LINKED_LIST_DELETION_CODE,
                                                                    DataStructureAlgorithmContentUtil.DOUBLY_LINKED_LIST_DELETION_WORST_CASE,
                                                                    DataStructureAlgorithmContentUtil.DOUBLY_LINKED_LIST_DELETION_AVERAGE_CASE,
                                                                    DataStructureAlgorithmContentUtil.DOUBLY_LINKED_LIST_DELETION_BEST_CASE),
                                                            Difficulty.EASY, R.drawable.ic_deletion)
                                            )), Difficulty.EASY, R.drawable.ic_doubly_linked_list)
                            )), Difficulty.EASY, R.drawable.ic_doubly_linked_list),
                    new DataStructure("Binary Search Tree",
                            new ArrayList<>(Arrays.asList(
                                    new DataStructureTopic("Binary Search Tree Basics",
                                            new ArrayList<>(Arrays.asList(
                                                    new DataStructureAlgorithm("Insertion", BinarySearchInsertionTreeVisualizerActivity.class,
                                                            new DataStructureAlgorithmContent(
                                                                    DataStructureAlgorithmContentUtil.BINARY_SEARCH_TREE_INSERTION_THEORY,
                                                                    DataStructureAlgorithmContentUtil.BINARY_SEARCH_TREE_INSERTION_ALGORITHM,
                                                                    DataStructureAlgorithmContentUtil.BINARY_SEARCH_TREE_INSERTION_CODE,
                                                                    DataStructureAlgorithmContentUtil.BINARY_SEARCH_TREE_INSERTION_WORST_CASE,
                                                                    DataStructureAlgorithmContentUtil.BINARY_SEARCH_TREE_INSERTION_AVERAGE_CASE,
                                                                    DataStructureAlgorithmContentUtil.BINARY_SEARCH_TREE_INSERTION_BEST_CASE),
                                                            Difficulty.EASY, R.drawable.ic_add),
                                                    new DataStructureAlgorithm("Deletion", BinarySearchTreeDeletionVisualizerActivity.class,
                                                            new DataStructureAlgorithmContent(
                                                                    DataStructureAlgorithmContentUtil.BINARY_SEARCH_TREE_DELETION_THEORY,
                                                                    DataStructureAlgorithmContentUtil.BINARY_SEARCH_TREE_DELETION_ALGORITHM,
                                                                    DataStructureAlgorithmContentUtil.BINARY_SEARCH_TREE_DELETION_CODE,
                                                                    DataStructureAlgorithmContentUtil.BINARY_SEARCH_TREE_DELETION_WORST_CASE,
                                                                    DataStructureAlgorithmContentUtil.BINARY_SEARCH_TREE_DELETION_AVERAGE_CASE,
                                                                    DataStructureAlgorithmContentUtil.BINARY_SEARCH_TREE_DELETION_BEST_CASE),
                                                            Difficulty.MEDIUM, R.drawable.ic_deletion)
                                            )), Difficulty.MEDIUM, R.drawable.ic_tree),
                                    new DataStructureTopic("Binary Search Tree Traversals",
                                            new ArrayList<>(Arrays.asList(
                                                    new DataStructureAlgorithm("Infix Traversal", BinarySearchInfixTreeVisualizerActivity.class,
                                                            new DataStructureAlgorithmContent(
                                                                    DataStructureAlgorithmContentUtil.BINARY_SEARCH_TREE_INFIX_THEORY,
                                                                    DataStructureAlgorithmContentUtil.BINARY_SEARCH_TREE_INFIX_ALGORITHM,
                                                                    DataStructureAlgorithmContentUtil.BINARY_SEARCH_TREE_INFIX_CODE,
                                                                    DataStructureAlgorithmContentUtil.BINARY_SEARCH_TREE_INFIX_WORST_CASE,
                                                                    DataStructureAlgorithmContentUtil.BINARY_SEARCH_TREE_INFIX_AVERAGE_CASE,
                                                                    DataStructureAlgorithmContentUtil.BINARY_SEARCH_TREE_INFIX_BEST_CASE),
                                                            Difficulty.EASY, R.drawable.ic_linear_search),
                                                    new DataStructureAlgorithm("Prefix Traversal", BinarySearchPrefixTreeVisualizerActivity.class,
                                                            new DataStructureAlgorithmContent(
                                                                    DataStructureAlgorithmContentUtil.BINARY_SEARCH_TREE_PREFIX_THEORY,
                                                                    DataStructureAlgorithmContentUtil.BINARY_SEARCH_TREE_PREFIX_ALGORITHM,
                                                                    DataStructureAlgorithmContentUtil.BINARY_SEARCH_TREE_PREFIX_CODE,
                                                                    DataStructureAlgorithmContentUtil.BINARY_SEARCH_TREE_PREFIX_WORST_CASE,
                                                                    DataStructureAlgorithmContentUtil.BINARY_SEARCH_TREE_PREFIX_AVERAGE_CASE,
                                                                    DataStructureAlgorithmContentUtil.BINARY_SEARCH_TREE_PREFIX_BEST_CASE),
                                                            Difficulty.EASY, R.drawable.ic_linear_search),
                                                    new DataStructureAlgorithm("Postfix Traversal", BinarySearchPostfixTreeVisualizerActivity.class,
                                                            new DataStructureAlgorithmContent(
                                                                    DataStructureAlgorithmContentUtil.BINARY_SEARCH_TREE_POSTFIX_THEORY,
                                                                    DataStructureAlgorithmContentUtil.BINARY_SEARCH_TREE_POSTFIX_ALGORITHM,
                                                                    DataStructureAlgorithmContentUtil.BINARY_SEARCH_TREE_POSTFIX_CODE,
                                                                    DataStructureAlgorithmContentUtil.BINARY_SEARCH_TREE_POSTFIX_WORST_CASE,
                                                                    DataStructureAlgorithmContentUtil.BINARY_SEARCH_TREE_POSTFIX_AVERAGE_CASE,
                                                                    DataStructureAlgorithmContentUtil.BINARY_SEARCH_TREE_POSTFIX_BEST_CASE),
                                                            Difficulty.EASY, R.drawable.ic_linear_search)
                                            )), Difficulty.EASY, R.drawable.ic_linear_search)
                            )), Difficulty.MEDIUM, R.drawable.ic_tree)
            ));


    @NonNull
    public static List<Integer> stringToArray(@NonNull String s) {
        StringBuilder c = new StringBuilder();
        List<Integer> arr = new ArrayList<>();
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == ' ') {
                try {
                    int number = Integer.parseInt(c.toString());
                    arr.add(number);
                    c = new StringBuilder();
                } catch (Exception ignored) {
                }

            } else {
                c.append(s.charAt(i));
            }
            if (i == s.length() - 1) {
                try {
                    int number = Integer.parseInt(c.toString());
                    arr.add(number);
                    c = new StringBuilder();
                } catch (Exception ignored) {
                }
            }
        }
        return arr;
    }
}
