package com.ashish.visualizeds.utils;

public class DataStructureAlgorithmContentUtil {

    //Linear Search
    public static final String LINEAR_SEARCH_THEORY =
            "A linear search is the simplest method of searching a data set.\n"
                    + "\n"
                    + "Starting at the beginning of the data set, each item of data is examined until a match is made. Once the item is found, the search ends. If there is no match, the algorithm must deal with this.";
    public static final String LINEAR_SEARCH_ALGORITHM =
            "1) Set i = 0, here i refers to the index of the array.\n" +
                    "\n" +
                    "2) Check if the element at the ith index is the target element.\n" +
                    "\n" +
                    "3) If the element at ith index is the target end the search.\n" +
                    "\n" +
                    "4) If the element at ith index is not the target increment i (i = i + 1).\n" +
                    "\n" +
                    "5) Repeat from Step 2.\n" +
                    "\n" +
                    "6) If i gets greater than the size of the array then the target does not exists.";
    public static final String LINEAR_SEARCH_CODE =
            "int main()\n" +
                    "{\n" +
                    "    int n = 5, i = 0, target = 5;\n" +
                    "    int arr[]{1, 2, 3, 4, 5};\n" +
                    "    while (i < n)\n" +
                    "    {\n" +
                    "        if (arr[i] == target)\n" +
                    "        {\n" +
                    "            cout << \"Found\" << endl;\n" +
                    "            return 0;\n" +
                    "        }\n" +
                    "        i = i + 1;\n" +
                    "    }\n" +
                    "    cout << \"Not Found\" << endl;\n" +
                    "    return 0;\n" +
                    "}";
    public static final String LINEAR_SEARCH_WORST_CASE = "N";
    public static final String LINEAR_SEARCH_AVERAGE_CASE = "N";
    public static final String LINEAR_SEARCH_BEST_CASE = "1";


    //Binary Search
    public static final String BINARY_SEARCH_THEORY =
            "Binary Search is a searching algorithm used in a sorted array by repeatedly dividing the search interval in half. \n" +
                    "\n" +
                    "The idea of binary search is to use the information that the array is sorted and reduce the time complexity to O(Log n). ";
    public static final String BINARY_SEARCH_ALGORITHM =
            "1) Initialize start = 0 and end = n-1 where n is the size and start and end is the interval of the array. \n" +
                    "\n" +
                    "2) If the value of the search key is less than the item in the middle of the interval, narrow the interval to the lower half (that is end = mid - 1).\n" +
                    "\n" +
                    "3) If the value of the search key is greater than the item in the middle of the interval, narrow the interval to the upper half (that is start = mid + 1).\n" +
                    "\n" +
                    "4) Repeat from Step 2 until the element is found at the middle of the interval.\n" +
                    "\n" +
                    "5) if start becomes equal to end that means the array has been fully traversed and the element is not present in the array.";
    public static final String BINARY_SEARCH_CODE =
            "int main()\n" +
                    "{\n" +
                    "    int n = 5, target = 5;\n" +
                    "    int arr[]{1, 2, 3, 4, 5};\n" +
                    "    int start = 0, end = n - 1;\n" +
                    "    while (start <= end)\n" +
                    "    {\n" +
                    "        int mid = (start + end) / 2;\n" +
                    "        if (arr[mid] == target)\n" +
                    "        {\n" +
                    "            cout << \"Found\" << endl;\n" +
                    "            return 0;\n" +
                    "        }\n" +
                    "        else if (arr[mid] < target)\n" +
                    "        {\n" +
                    "            start = mid + 1;\n" +
                    "        }\n" +
                    "        else\n" +
                    "        {\n" +
                    "            end = mid - 1;\n" +
                    "        }\n" +
                    "    }\n" +
                    "    cout << \"Not Found\" << endl;\n" +
                    "    return 0;\n" +
                    "}";
    public static final String BINARY_SEARCH_WORST_CASE = "Log N";
    public static final String BINARY_SEARCH_AVERAGE_CASE = "Log N";
    public static final String BINARY_SEARCH_BEST_CASE = "1";

    public static final String BUBBLE_SORT_THEORY =
            "Bubble sort is a sorting algorithm that compares two adjacent elements and swaps them until they are not in the intended order.\n" +
                    "\n" +
                    "Just like the movement of air bubbles in the water that rise up to the surface, each element of the array move to the end in each iteration.\n" +
                    "Therefore, it is called a bubble sort.";
    public static final String BUBBLE_SORT_ALGORITHM =
            "1) Starting from the first index, compare the first and the second elements.\n" +
                    "\n" +
                    "2) If the first element is greater than the second element, they are swapped.\n" +
                    "\n" +
                    "3) Now, compare the second and the third elements. Swap them if they are not in order.\n" +
                    "\n" +
                    "4) The above process goes on until the last element.\n" +
                    "\n" +
                    "5) After this the largest element will come at the end of the array.\n" +
                    "\n" +
                    "6) Repeat from Step 1 (N - 1) more time to sort all elements.\n";
    public static final String BUBBLE_SORT_CODE =
            "int main()\n" +
                    "{\n" +
                    "    int n = 5;\n" +
                    "    int arr[]{5, 4, 3, 2, 1};\n" +
                    "    int start = 0, end = n - 1;\n" +
                    "    for (int i = 0; i < n; i++)\n" +
                    "        // swapping if the next element is smaller than the previous elements\n" +
                    "        for (int j = 0; j < n - 1; j++)\n" +
                    "            if (arr[j] > arr[j + 1])\n" +
                    "                swap(arr[j], arr[j + 1]);\n" +
                    "\n" +
                    "    // printing sorted array\n" +
                    "    for (int i = 0; i < n; i++)\n" +
                    "        cout << arr[i] << \" \";\n" +
                    "    return 0;\n" +
                    "}";
    public static final String BUBBLE_SORT_WORST_CASE = "N<sup>2</sup>";
    public static final String BUBBLE_SORT_AVERAGE_CASE = "N<sup>2</sup>";
    public static final String BUBBLE_SORT_BEST_CASE = "N<sup>2</sup>";

    public static final String SELECTION_SORT_THEORY =
            "Selection sort is a simple sorting algorithm. This sorting algorithm is an in-place comparison-based algorithm in which the list is divided into two parts, the sorted part at the left end and the unsorted part at the right end. Initially, the sorted part is empty and the unsorted part is the entire list.\n" +
                    "\n" +
                    "The smallest element is selected from the unsorted array and swapped with the leftmost element, and that element becomes a part of the sorted array. This process continues moving unsorted array boundary by one element to the right.\n" +
                    "\n";
    public static final String SELECTION_SORT_ALGORITHM =
            "1) Set MIN to location 0\n" +
                    "\n" +
                    "2) Search the minimum element in the list\n" +
                    "\n" +
                    "3) Swap with value at location MIN\n" +
                    "\n" +
                    "4) Increment MIN to point to next element\n" +
                    "\n" +
                    "5) Repeat until list is sorted";
    public static final String SELECTION_SORT_CODE =
            "int main()\n" +
                    "{\n" +
                    "    int n = 5;\n" +
                    "    int arr[]{5, 4, 3, 2, 1};\n" +
                    "    for (int i = 0; i < n; i++)\n" +
                    "    {\n" +
                    "        int pos = i;\n" +
                    "        for (int j = i; j < n; j++)\n" +
                    "        {\n" +
                    "            if (arr[j] < arr[pos])\n" +
                    "            {\n" +
                    "                pos = j;\n" +
                    "            }\n" +
                    "        }\n" +
                    "        swap(arr[pos], arr[i]);\n" +
                    "    }\n" +
                    "    for (int i = 0; i < n; i++)\n" +
                    "    {\n" +
                    "        cout << arr[i] << \" \";\n" +
                    "    }\n" +
                    "    return 0;\n" +
                    "}";
    public static final String SELECTION_SORT_WORST_CASE = "N<sup>2</sup>";
    public static final String SELECTION_SORT_AVERAGE_CASE = "N<sup>2</sup>";
    public static final String SELECTION_SORT_BEST_CASE = "N<sup>2</sup>";

    //Insertion Sort
    public static final String INSERTION_SORT_THEORY =
            "Insertion sort is a simple sorting algorithm. The array is virtually split into a sorted and an unsorted part. Values from the unsorted part are picked and placed at the correct position in the sorted part.";
    public static final String INSERTION_SORT_ALGORITHM =
            "1) If the element is the first element, assume that it is already sorted. Return 1.\n" +
                    "\n" +
                    "2) Pick the next element, and store it separately in a key.\n" +
                    "\n" +
                    "3) Now, compare the key with all elements in the sorted array.\n" +
                    "\n" +
                    "4) If the element in the sorted array is smaller than the current element, then move to the next element. Else, shift greater elements in the array towards the right.\n" +
                    "\n" +
                    "5) Insert the value.\n" +
                    "\n" +
                    "6) Repeat until the array is sorted.";
    public static final String INSERTION_SORT_CODE =
            "int main()\n" +
                    "{\n" +
                    "    int n = 5;\n" +
                    "    int arr[]{5, 4, 3, 2, 1};\n" +
                    "    int i, j, temp;\n" +
                    "    for (i = 1; i < n; i++)\n" +
                    "    {\n" +
                    "        temp = arr[i];\n" +
                    "        j = i - 1;\n" +
                    "\n" +
                    "        while (j >= 0 && temp <= arr[j])\n" +
                    "        {\n" +
                    "            arr[j + 1] = arr[j];\n" +
                    "            j = j - 1;\n" +
                    "        }\n" +
                    "        arr[j + 1] = temp;\n" +
                    "    }\n" +
                    "    for (int i = 0; i < n; i++)\n" +
                    "    {\n" +
                    "        cout << arr[i] << \" \";\n" +
                    "    }\n" +
                    "    return 0;\n" +
                    "}";
    public static final String INSERTION_SORT_WORST_CASE = "N<sup>2</sup>";
    public static final String INSERTION_SORT_AVERAGE_CASE = "N<sup>2</sup>";
    public static final String INSERTION_SORT_BEST_CASE = "N";

    public static final String MERGE_SORT_THEORY =
            "Merge Sort is one of the most popular sorting algorithms that is based on the principle of Divide and Conquer Algorithm.\n" +
                    "\n" +
                    "Here, a problem is divided into multiple sub-problems. Each sub-problem is solved individually. Finally, sub-problems are combined to form the final solution.";
    public static final String MERGE_SORT_ALGORITHM =
            "MergeSort Algorithm\n" +
                    "The MergeSort function repeatedly divides the array into two halves until we reach a stage where we try to perform MergeSort on a subarray of size 1.\n" +
                    "\n" +
                    "After that, the merge function comes into play and combines the sorted arrays into larger arrays until the whole array is merged.";
    public static final String MERGE_SORT_CODE =
            "void merge(int arr[], int p, int q, int r) {\n" +
                    "  \n" +
                    "  int n1 = q - p + 1;\n" +
                    "  int n2 = r - q;\n" +
                    "\n" +
                    "  int L[n1], M[n2];\n" +
                    "\n" +
                    "  for (int i = 0; i < n1; i++)\n" +
                    "    L[i] = arr[p + i];\n" +
                    "  for (int j = 0; j < n2; j++)\n" +
                    "    M[j] = arr[q + 1 + j];\n" +
                    "\n" +
                    "  int i, j, k;\n" +
                    "  i = 0;\n" +
                    "  j = 0;\n" +
                    "  k = p;\n" +
                    "\n" +
                    "  while (i < n1 && j < n2) {\n" +
                    "    if (L[i] <= M[j]) {\n" +
                    "      arr[k] = L[i];\n" +
                    "      i++;\n" +
                    "    } else {\n" +
                    "      arr[k] = M[j];\n" +
                    "      j++;\n" +
                    "    }\n" +
                    "    k++;\n" +
                    "  }\n" +
                    "\n" +
                    "  while (i < n1) {\n" +
                    "    arr[k] = L[i];\n" +
                    "    i++;\n" +
                    "    k++;\n" +
                    "  }\n" +
                    "\n" +
                    "  while (j < n2) {\n" +
                    "    arr[k] = M[j];\n" +
                    "    j++;\n" +
                    "    k++;\n" +
                    "  }\n" +
                    "}\n" +
                    "\n" +
                    "void mergeSort(int arr[], int l, int r) {\n" +
                    "  if (l < r) {\n" +
                    "    int m = l + (r - l) / 2;\n" +
                    "\n" +
                    "    mergeSort(arr, l, m);\n" +
                    "    mergeSort(arr, m + 1, r);\n" +
                    "\n" +
                    "    merge(arr, l, m, r);\n" +
                    "  }\n" +
                    "}";
    public static final String MERGE_SORT_WORST_CASE = "N * Log N";
    public static final String MERGE_SORT_AVERAGE_CASE = "N * Log N";
    public static final String MERGE_SORT_BEST_CASE = "N * Log N";


    //Quick Sort
    public static final String QUICK_SORT_THEORY =
            "Quicksort is the widely used sorting algorithm that makes n log n comparisons in average case for sorting an array of n elements. It is a faster and highly efficient sorting algorithm. This algorithm follows the divide and conquer approach." +
                    "\n" +
                    "Divide and conquer is a technique of breaking down the algorithms into subproblems, then solving the subproblems, and combining the results back together to solve the original problem.";
    public static final String QUICK_SORT_ALGORITHM =
            "1) Quicksort picks an element as pivot, and then it partitions the given array around the picked pivot element.\n" +
                    "\n" +
                    "2) In quick sort, a large array is divided into two arrays in which one holds values that are smaller than the specified value (Pivot), and another array holds the values that are greater than the pivot.\n" +
                    "\n" +
                    "3) After that, left and right sub-arrays are also partitioned using the same approach.\n" +
                    "\n" +
                    "4) It will continue until the single element remains in the sub-array.";
    public static final String QUICK_SORT_CODE =
            "int partition (int arr[], int low, int high)\n" +
                    "{\n" +
                    "    int pivot = arr[high]; // pivot\n" +
                    "    int i = (low - 1);\n" +
                    " \n" +
                    "    for (int j = low; j <= high - 1; j++)\n" +
                    "    {\n" +
                    "        if (arr[j] < pivot)\n" +
                    "        {\n" +
                    "            i++;\n" +
                    "            swap(&arr[i], &arr[j]);\n" +
                    "        }\n" +
                    "    }\n" +
                    "    swap(arr[i + 1], arr[high]);\n" +
                    "    return (i + 1);\n" +
                    "}\n" +
                    " \n" +
                    "void quickSort(int arr[], int low, int high)\n" +
                    "{\n" +
                    "    if (low < high)\n" +
                    "    {\n" +
                    "        int pi = partition(arr, low, high);\n" +
                    " \n" +
                    "        quickSort(arr, low, pi - 1);\n" +
                    "        quickSort(arr, pi + 1, high);\n" +
                    "    }\n" +
                    "}";
    public static final String QUICK_SORT_WORST_CASE = "N<sup>2</sup>";
    public static final String QUICK_SORT_AVERAGE_CASE = "N * Log N";
    public static final String QUICK_SORT_BEST_CASE = "N * Log N";


    //Linked list


    //linked list insertion

    public static final String LINKED_LIST_INSERTION_THEORY =
            "There are three possible positions where we can enter a new node in a linked list\n" +
                    "\n" +
                    "\t\tInsertion at beginning\n" +
                    "\t\tInsertion after nth position\n" +
                    "\t\tInsertion at end\n" +
                    "\n" +
                    "Generally by definition, if a new node is added it is added at the beginning of the linked list and not the end. So, we do not need to traverse the list every time for insertion\n" +
                    "\n";
    public static final String LINKED_LIST_INSERTION_ALGORITHM =
            "1) Create a new node and assign its data value and its next node to NULL.\n" +
                    "\n" +
                    "2) If the list is empty, change the head node to the new node.\n" +
                    "\n" +
                    "3) If not then traverse till the last node.\n" +
                    "\n" +
                    "4) Assign the last node’s next pointer to this new node.\n" +
                    "\n" +
                    "5) Now, the new node has become the last node.";
    public static final String LINKED_LIST_INSERTION_CODE =
            "class Node\n" +
                    "{\n" +
                    "public:\n" +
                    "    int data;\n" +
                    "    Node *next;\n" +
                    "    Node(int _data)\n" +
                    "    {\n" +
                    "        data = _data;\n" +
                    "        next = NULL;\n" +
                    "    }\n" +
                    "};\n" +
                    "\n" +
                    "Node *Insert(Node *head, int data)\n" +
                    "{\n" +
                    "    Node *newNode = new Node(data);\n" +
                    "    if (head == NULL)\n" +
                    "        return head = newNode;\n" +
                    "    Node *temp = head;\n" +
                    "    while (temp->next != NULL)\n" +
                    "        temp = temp->next;\n" +
                    "    temp->next = newNode;\n" +
                    "    return head;\n" +
                    "}";
    public static final String LINKED_LIST_INSERTION_WORST_CASE = "N";
    public static final String LINKED_LIST_INSERTION_AVERAGE_CASE = "N";
    public static final String LINKED_LIST_INSERTION_BEST_CASE = "1";


    // Linked List Traversal
    public static final String LINKED_LIST_TRAVERSAL_THEORY =
            "Traversing is the most common operation that is performed in almost every scenario of singly linked list. Traversing means visiting each node of the list once in order to perform some operation on that.";
    public static final String LINKED_LIST_TRAVERSAL_ALGORITHM =
            "1) Initialize temp = head.\n" +
                    "\n" +
                    "2) If temp is NULL we stop the traversal (EXIT).\n" +
                    "\n" +
                    "3) If temp is not NULL we now go to the next node by setting temp = next pointer of the current temp ( temp = temp->next).\n" +
                    "\n" +
                    "4) Repeat Step 2.";
    public static final String LINKED_LIST_TRAVERSAL_CODE =
            "class Node\n" +
                    "{\n" +
                    "public:\n" +
                    "    int data;\n" +
                    "    Node *next;\n" +
                    "    Node(int _data)\n" +
                    "    {\n" +
                    "        data = _data;\n" +
                    "        next = NULL;\n" +
                    "    }\n" +
                    "};\n" +
                    "\n" +
                    "void *Traversal(Node *head)\n" +
                    "{\n" +
                    "    // prints all nodes in the Linked List.\n" +
                    "    Node *temp = head;\n" +
                    "    while (temp->next != NULL)\n" +
                    "    {\n" +
                    "        cout << temp->data << \" \";\n" +
                    "        temp = temp->next;\n" +
                    "    }\n" +
                    "}";
    public static final String LINKED_LIST_TRAVERSAL_WORST_CASE = "N";
    public static final String LINKED_LIST_TRAVERSAL_AVERAGE_CASE = "N";
    public static final String LINKED_LIST_TRAVERSAL_BEST_CASE = "N";


    //    Linked List Deletion
    public static final String LINKED_LIST_DELETION_THEORY =
            "Deleting a node from the beginning of the list is the simplest operation of all. It just need a few adjustments in the node pointers. Since the first node of the list is to be deleted, therefore, we just need to make the head, point to the next of the head.";
    public static final String LINKED_LIST_DELETION_ALGORITHM =
            "1) If the head node has the given key, make the head node points to the second node and free its memory.\n" +
                    "\n" +
                    "2) Otherwise,\n" +
                    "\n" +
                    "     From the current node, check whether the next node has the given key\n" +
                    "\n" +
                    "     if yes, make the current->next = current->next->next and free the memory.\n" +
                    "\n" +
                    "     else, update the current node to the next and do the above process (from step 2) till the last node.";
    public static final String LINKED_LIST_DELETION_CODE =
            "class Node\n" +
                    "{\n" +
                    "public:\n" +
                    "    int data;\n" +
                    "    Node *next;\n" +
                    "    Node(int _data)\n" +
                    "    {\n" +
                    "        data = _data;\n" +
                    "        next = NULL;\n" +
                    "    }\n" +
                    "};\n" +
                    "\n" +
                    "Node *Deletion(Node *head, int target)\n" +
                    "{\n" +
                    "    if (head == NULL)\n" +
                    "        return head;\n" +
                    "    if (head->data == target)\n" +
                    "        return head = head->next;\n" +
                    "    Node *currentPtr = head;\n" +
                    "    while (currentPtr->next != NULL)\n" +
                    "    {\n" +
                    "        if (currentPtr->next->data == target)\n" +
                    "        {\n" +
                    "            currentPtr->next = currentPtr->next->next;\n" +
                    "            return head;\n" +
                    "        }\n" +
                    "        currentPtr = currentPtr->next;\n" +
                    "    }\n" +
                    "}";
    public static final String LINKED_LIST_DELETION_WORST_CASE = "N";
    public static final String LINKED_LIST_DELETION_AVERAGE_CASE = "N";
    public static final String LINKED_LIST_DELETION_BEST_CASE = "1";


    //Doubly Linked List

    //Insertion
    public static final String DOUBLY_LINKED_LIST_INSERTION_THEORY =
            "Doubly linked list is a complex type of linked list in which a node contains a pointer to the previous as well as the next node in the sequence. Therefore, in a doubly linked list, a node consists of three parts: node data, pointer to the next node in sequence (next pointer) , pointer to the previous node (previous pointer).";
    public static final String DOUBLY_LINKED_LIST_INSERTION_ALGORITHM =
            "1) Create a new node and assign its data value and its next node to NULL.\n" +
                    "\n" +
                    "2) If the list is empty, change the head node to the new node.\n" +
                    "\n" +
                    "3) If not then traverse till the last node.\n" +
                    "\n" +
                    "4) Assign the last node’s next pointer to this new node.\n" +
                    "\n" +
                    "5) Now, the new node has become the last node.";
    public static final String DOUBLY_LINKED_LIST_INSERTION_CODE =
            "class Node\n" +
                    "{\n" +
                    "public:\n" +
                    "    int data;\n" +
                    "    Node *next, *prev;\n" +
                    "    Node(int _data)\n" +
                    "    {\n" +
                    "        data = _data;\n" +
                    "        next = NULL;\n" +
                    "        prev = NULL;\n" +
                    "    }\n" +
                    "};\n" +
                    "\n" +
                    "Node *Insertion(Node *head, int data)\n" +
                    "{\n" +
                    "    Node *newNode = new Node(data);\n" +
                    "    if (head == NULL)\n" +
                    "        return head = newNode;\n" +
                    "\n" +
                    "    Node *temp = head;\n" +
                    "    while (temp->next != NULL)\n" +
                    "    {\n" +
                    "        temp = temp->next;\n" +
                    "    }\n" +
                    "    temp->next = newNode;\n" +
                    "    newNode->prev = temp;\n" +
                    "}";
    public static final String DOUBLY_LINKED_LIST_INSERTION_WORST_CASE = "N";
    public static final String DOUBLY_LINKED_LIST_INSERTION_AVERAGE_CASE = "N";
    public static final String DOUBLY_LINKED_LIST_INSERTION_BEST_CASE = "1";


    //Traversal

    public static final String DOUBLY_LINKED_LIST_TRAVERSAL_THEORY =
            "A Doubly linked list is used in navigation systems or to represent a classic deck of cards. A Doubly linked list is a bidirectional linked list; i.e., you can traverse it from head to tail node or tail to head node. Unlike singly-linked lists, its node has an extra pointer that points at the last node.";
    public static final String DOUBLY_LINKED_LIST_TRAVERSAL_ALGORITHM =
            "1) Initialize temp = head.\n" +
                    "\n" +
                    "2) If temp is NULL we stop the traversal (EXIT).\n" +
                    "\n" +
                    "3) If temp is not NULL we now go to the next node by setting temp = next pointer of the current temp ( temp = temp->next).\n" +
                    "\n" +
                    "4) Repeat Step 2.";
    public static final String DOUBLY_LINKED_LIST_TRAVERSAL_CODE =
            "class Node\n" +
                    "{\n" +
                    "public:\n" +
                    "    int data;\n" +
                    "    Node *next, *prev;\n" +
                    "    Node(int _data)\n" +
                    "    {\n" +
                    "        data = _data;\n" +
                    "        next = NULL;\n" +
                    "        prev = NULL;\n" +
                    "    }\n" +
                    "};\n" +
                    "\n" +
                    "void Traversal(Node *head)\n" +
                    "{\n" +
                    "    Node *temp = head;\n" +
                    "    while (temp != NULL)\n" +
                    "    {\n" +
                    "        cout << temp->data << \" \";\n" +
                    "        temp = temp->next;\n" +
                    "    }\n" +
                    "}";
    public static final String DOUBLY_LINKED_LIST_TRAVERSAL_WORST_CASE = "N";
    public static final String DOUBLY_LINKED_LIST_TRAVERSAL_AVERAGE_CASE = "N";
    public static final String DOUBLY_LINKED_LIST_TRAVERSAL_BEST_CASE = "N";

    //Deletion

    public static final String DOUBLY_LINKED_LIST_DELETION_THEORY =
            "Deletion in a doubly linked list is similar to the singly linked list. The list is traversed to find the element to be deleted.\n" +
                    "\n" +
                    "Once the element have been found we make the next pointer of the previous node to the next of the node to be deleted and the prev pointer of the next node of the node to be deleted to the previous node of the node to be deleted.\n";
    public static final String DOUBLY_LINKED_LIST_DELETION_ALGORITHM = "1) If the head node has the given key, make the head node points to the second node and free its memory.\n" +
            "\n" +
            "2) Otherwise,\n" +
            "\n" +
            "From the current node, check whether the next node has the given key\n" +
            "\n" +
            "if yes, check if current->next->next is not NULL.\n" +
            "\n" +
            "If it is not NULL then make current->next->next->prev = current and current->next = current->next->next and free the memory.\n" +
            "\n" +
            "If it is NULL just make current->next = current->next->next and free the memory.\n" +
            "\n" +
            "else, update the current node to the next and do the above process (from step 2) till the last node.";
    public static final String DOUBLY_LINKED_LIST_DELETION_CODE =
            "class Node\n" +
                    "{\n" +
                    "public:\n" +
                    "    int data;\n" +
                    "    Node *next, *prev;\n" +
                    "    Node(int _data)\n" +
                    "    {\n" +
                    "        data = _data;\n" +
                    "        next = NULL;\n" +
                    "        prev = NULL;\n" +
                    "    }\n" +
                    "};\n" +
                    "\n" +
                    "Node *Deletion(Node *head, int target)\n" +
                    "{\n" +
                    "    if (head == NULL)\n" +
                    "        return head;\n" +
                    "    if (head->data == target)\n" +
                    "        return head = head->next;\n" +
                    "    Node *temp = head;\n" +
                    "    while (temp->next != NULL)\n" +
                    "    {\n" +
                    "        if (temp->next->data == target)\n" +
                    "        {\n" +
                    "            if (temp->next->next != NULL)\n" +
                    "                temp->next->next->prev = temp;\n" +
                    "            temp->next = temp->next->next;\n" +
                    "        }\n" +
                    "        temp = temp->next;\n" +
                    "    }\n" +
                    "}";
    public static final String DOUBLY_LINKED_LIST_DELETION_WORST_CASE = "N";
    public static final String DOUBLY_LINKED_LIST_DELETION_AVERAGE_CASE = "N";
    public static final String DOUBLY_LINKED_LIST_DELETION_BEST_CASE = "1";

    //BST

    //Insertion

    public static final String BINARY_SEARCH_TREE_INSERTION_THEORY =
            "Binary Search Tree is a node-based binary tree data structure which has the following properties:  \n" +
                    "\n" +
                    "1) The left subtree of a node contains only nodes with keys lesser than the node’s key.\n" +
                    "2) The right subtree of a node contains only nodes with keys greater than the node’s key.\n" +
                    "3) The left and right subtree each must also be a binary search tree. \n" +
                    "4) There must be no duplicate nodes.";
    public static final String BINARY_SEARCH_TREE_INSERTION_ALGORITHM =
            "1) Start from the root. \n" +
                    "\n" +
                    "2) Compare the searching element with root, if less than root, then recursively call left subtree, else recursively call right subtree.\n" +
                    " \n" +
                    "3) If the element to search is found anywhere, return true, else return false.\n" +
                    "\n" +
                    "4) We start searching a key from the root until we hit a leaf node. Once a leaf node is found, the new node is added as a child of the leaf node.\n" +
                    "\n" +
                    "5) If the key is already present we will not insert the key.";
    public static final String BINARY_SEARCH_TREE_INSERTION_CODE =
            "class TreeNode\n" +
                    "{\n" +
                    "public:\n" +
                    "    int data;\n" +
                    "    TreeNode *left, *right;\n" +
                    "    TreeNode(int _data)\n" +
                    "    {\n" +
                    "        data = _data;\n" +
                    "        left = NULL;\n" +
                    "        right = NULL;\n" +
                    "    }\n" +
                    "};\n" +
                    "\n" +
                    "TreeNode *Insertion(TreeNode *root, int target)\n" +
                    "{\n" +
                    "    if (root == NULL)\n" +
                    "        return new TreeNode(target);\n" +
                    "    if (target < root->data)\n" +
                    "        root->left = Insertion(root->left, target);\n" +
                    "    else if (target > root->data)\n" +
                    "        root->right = Insertion(root->right, target);\n" +
                    "    return root;\n" +
                    "}";
    public static final String BINARY_SEARCH_TREE_INSERTION_WORST_CASE = "N";
    public static final String BINARY_SEARCH_TREE_INSERTION_AVERAGE_CASE = "Log N";
    public static final String BINARY_SEARCH_TREE_INSERTION_BEST_CASE = "1";

    //infix
    public static final String BINARY_SEARCH_TREE_INFIX_THEORY =
            "Linear data structures such as stack, array, queue, etc., only have one way to traverse the data. But in hierarchical data structures such as tree, there are multiple ways to traverse the data. Here we will discuss another way to traverse the tree data structure, i.e., inorder traversal.";
    public static final String BINARY_SEARCH_TREE_INFIX_ALGORITHM =
            "1) Visit all the nodes in the left subtree.\n" +
                    "\n" +
                    "2) Visit the root node.\n" +
                    "\n" +
                    "3) Visit all the nodes in the right subtree.";
    public static final String BINARY_SEARCH_TREE_INFIX_CODE =
            "class TreeNode\n" +
                    "{\n" +
                    "public:\n" +
                    "    int data;\n" +
                    "    TreeNode *left, *right;\n" +
                    "    TreeNode(int _data)\n" +
                    "    {\n" +
                    "        data = _data;\n" +
                    "        left = NULL;\n" +
                    "        right = NULL;\n" +
                    "    }\n" +
                    "};\n" +
                    "\n" +
                    "void InfixTraversal(TreeNode *root)\n" +
                    "{\n" +
                    "    if (root == NULL)\n" +
                    "        return;\n" +
                    "    InfixTraversal(root->left);\n" +
                    "    cout << root->data << \" \";\n" +
                    "    InfixTraversal(root->right);\n" +
                    "}";
    public static final String BINARY_SEARCH_TREE_INFIX_WORST_CASE = "N";
    public static final String BINARY_SEARCH_TREE_INFIX_AVERAGE_CASE = "N";
    public static final String BINARY_SEARCH_TREE_INFIX_BEST_CASE = "N";

    //prefix

    public static final String BINARY_SEARCH_TREE_PREFIX_THEORY =
            "Linear data structures such as stack, array, queue, etc., only have one way to traverse the data. But in hierarchical data structures such as tree, there are multiple ways to traverse the data. Here we will discuss another way to traverse the tree data structure, i.e., prefix traversal.";
    public static final String BINARY_SEARCH_TREE_PREFIX_ALGORITHM =
            "1) Visit the root node.\n" +
                    "\n" +
                    "2) Visit all the nodes in the left subtree.\n" +
                    "\n" +
                    "3) Visit all the nodes in the right subtree.";
    public static final String BINARY_SEARCH_TREE_PREFIX_CODE =
            "class TreeNode\n" +
                    "{\n" +
                    "public:\n" +
                    "    int data;\n" +
                    "    TreeNode *left, *right;\n" +
                    "    TreeNode(int _data)\n" +
                    "    {\n" +
                    "        data = _data;\n" +
                    "        left = NULL;\n" +
                    "        right = NULL;\n" +
                    "    }\n" +
                    "};\n" +
                    "\n" +
                    "void PrefixTraversal(TreeNode *root)\n" +
                    "{\n" +
                    "    if (root == NULL)\n" +
                    "        return;\n" +
                    "    cout << root->data << \" \";\n" +
                    "    PrefixTraversal(root->left);\n" +
                    "    PrefixTraversal(root->right);\n" +
                    "}";
    public static final String BINARY_SEARCH_TREE_PREFIX_WORST_CASE = "N";
    public static final String BINARY_SEARCH_TREE_PREFIX_AVERAGE_CASE = "N";
    public static final String BINARY_SEARCH_TREE_PREFIX_BEST_CASE = "N";

    //postfix

    public static final String BINARY_SEARCH_TREE_POSTFIX_THEORY =
            "Linear data structures such as stack, array, queue, etc., only have one way to traverse the data. But in hierarchical data structures such as tree, there are multiple ways to traverse the data. Here we will discuss another way to traverse the tree data structure, i.e., postfix traversal.";
    public static final String BINARY_SEARCH_TREE_POSTFIX_ALGORITHM =
            "1) Visit all the nodes in the left subtree.\n" +
                    "\n" +
                    "2) Visit all the nodes in the right subtree.\n" +
                    "\n" +
                    "3) Visit the root node.";
    public static final String BINARY_SEARCH_TREE_POSTFIX_CODE =
            "class TreeNode\n" +
                    "{\n" +
                    "public:\n" +
                    "    int data;\n" +
                    "    TreeNode *left, *right;\n" +
                    "    TreeNode(int _data)\n" +
                    "    {\n" +
                    "        data = _data;\n" +
                    "        left = NULL;\n" +
                    "        right = NULL;\n" +
                    "    }\n" +
                    "};\n" +
                    "\n" +
                    "void PostfixTraversal(TreeNode *root)\n" +
                    "{\n" +
                    "    if (root == NULL)\n" +
                    "        return;\n" +
                    "    PostfixTraversal(root->left);\n" +
                    "    PostfixTraversal(root->right);\n" +
                    "    cout << root->data << \" \";\n" +
                    "}";
    public static final String BINARY_SEARCH_TREE_POSTFIX_WORST_CASE = "N";
    public static final String BINARY_SEARCH_TREE_POSTFIX_AVERAGE_CASE = "N";
    public static final String BINARY_SEARCH_TREE_POSTFIX_BEST_CASE = "N";


    //BST deletion
    public static final String BINARY_SEARCH_TREE_DELETION_THEORY =
            "Delete function is used to delete the specified node from a binary search tree. However, we must delete a node from a binary search tree in such a way, that the property of binary search tree doesn't violate. There are three situations of deleting a node from binary search tree.\n" +
                    "1)The node to be deleted is a leaf node.\n" +
                    "2)The node to be deleted has only one child.\n" +
                    "3)The node to be deleted has two children.";
    public static final String BINARY_SEARCH_TREE_DELETION_ALGORITHM =
            "1) We first traverse the BST to find the targeted node.\n" +
                    "\n" +
                    "2) Once the node has been found we look at the no of the node's Chi\n" +
                    "\n" +
                    "3) If the node has exactly 0 Children then the node is deleted directly and the memory is freed.\n" +
                    "\n" +
                    "4) If the node has exactly 1 Children then the node is deleted directly and the memory is freed and the children is directly attached to the parent node.\n" +
                    "\n" +
                    "5) If the node has exactly 2 Children then the node cannot deleted directly. We find the inorder successor of the node to be deleted.\n" +
                    "\n" +
                    "6) We store the inorder successor value in the targeted node. \n" +
                    "\n" +
                    "7) We call the delete function recursively in the left subtree of the targeted node.";
    public static final String BINARY_SEARCH_TREE_DELETION_CODE =
            "class TreeNode\n" +
                    "{\n" +
                    "public:\n" +
                    "    int data;\n" +
                    "    TreeNode *left, *right;\n" +
                    "    TreeNode(int _data)\n" +
                    "    {\n" +
                    "        data = _data;\n" +
                    "        left = NULL;\n" +
                    "        right = NULL;\n" +
                    "    }\n" +
                    "};\n" +
                    "\n" +
                    "TreeNode *deletion(TreeNode *root, int target)\n" +
                    "{\n" +
                    "    if (root == NULL)\n" +
                    "        return root;\n" +
                    "    if (target == root->data)\n" +
                    "    {\n" +
                    "        if (root->left == NULL && root->right == NULL)\n" +
                    "        {\n" +
                    "            delete root;\n" +
                    "        }\n" +
                    "        else if (root->left != NULL && root->right == NULL)\n" +
                    "        {\n" +
                    "            TreeNode *temp = root;\n" +
                    "            root = root->left;\n" +
                    "            delete temp;\n" +
                    "        }\n" +
                    "        else if (root->left == NULL && root->right != NULL)\n" +
                    "        {\n" +
                    "            TreeNode *temp = root;\n" +
                    "            root = root->right;\n" +
                    "            delete temp;\n" +
                    "        }\n" +
                    "        else if (root->left != NULL && root->right != NULL)\n" +
                    "        {\n" +
                    "            TreeNode *temp = root->left;\n" +
                    "            while (temp->right != NULL)\n" +
                    "            {\n" +
                    "                temp = temp->right;\n" +
                    "            }\n" +
                    "            root->data = temp->data;\n" +
                    "            root->left = deletion(root->left, root->data);\n" +
                    "        }\n" +
                    "    }\n" +
                    "    else if (target < root->data)\n" +
                    "    {\n" +
                    "        root->left = deletion(root->left, target);\n" +
                    "    }\n" +
                    "    else\n" +
                    "    {\n" +
                    "        root->right = deletion(root->right, target);\n" +
                    "    }\n" +
                    "    return root;\n" +
                    "}";
    public static final String BINARY_SEARCH_TREE_DELETION_WORST_CASE = "N";
    public static final String BINARY_SEARCH_TREE_DELETION_AVERAGE_CASE = "Log N";
    public static final String BINARY_SEARCH_TREE_DELETION_BEST_CASE = "1";
}
