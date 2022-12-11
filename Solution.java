//1. C++: bubble sort algorithm
#include<iostream>
using namespace std;

int main() {
    int n = 6;
    int arr[6] = {5, -10, 7, 2, 9, 0};
    for (int right = n - 1; right >= 0; right--) {
        for (int left = 0; left < right; left++) {
            if (arr[left] > arr[left + 1]) {
                int tmp = arr[left];
                arr[left] = arr[left + 1];
                arr[left + 1] = tmp;
            }
        }
    }
    for (int i = 0; i < n; i++) {
        cout << arr[i] << " ";
    }
    return 0;
}


//2. C++: Selection sort algorithm
#include<iostream>
using namespace std;

int main() {
    int n = 6;
    int arr[6] = {5, -10, 7, 2, 9, 0};
    for (int left = 0; left < n; left++) {
        int minValueIndex = left;
        for (int right = left; right < n; right++) {
            if (arr[minValueIndex] > arr[right]) {
                minValueIndex = right;
            }
         }
        int tmp = arr[left];
        arr[left] = arr[minValueIndex];
        arr[minValueIndex] = tmp;
    }
    for (int i = 0; i < n; i++) {
        cout << arr[i] << " ";
    }
    return 0;
}


//3. C++: Inserion sort algorithm
#include  <iostream>
using namespace std;

int main() {
    int n = 6;
    int arr[6] = {5, -10, 7, 2, 9, 0};
    for  (int right = 1; right < n; right++)  { 
        int left = right;
        while (left >= 1 && arr[left] < arr[left - 1]) { 
            int tmp = arr[left];
            arr[left] = arr[left - 1]; 
            arr[left - 1]  =  tmp;
            left  =  left  -  1;
        }
    }
    for  (int  i  =  0;  i  <  n;  i++)  { 
        cout  <<  arr[i] << " ";
    }
    return  0;
}

//4. C++: Implementation of binary search tree 
#include  <stdlib.h>
#include  <iostream> 
using namespace std;

struct Node {
    int  data;
    struct  Node  *left; 
    struct  Node  *right;
};

struct Node *newNode(int value)  {
    struct Node *node = (struct Node*) malloc(sizeof(struct Node)); 
    node->data = value;
    node->left = NULL; 
    node->right = NULL; 
    return (node);
}

void  preorder(struct  Node  *root)  { 
    if  (root  ==  NULL)  return;  
    cout  <<  root->data << " ";
    preorder(root->left); 
    preorder(root->right);
}

void  inorder(struct  Node  *root)  { 
    if  (root  ==  NULL)  return;  
    inorder(root->left); 
    cout  <<  root->data << " ";
    inorder(root->right);
}

void  postorder(struct Node *root)  { 
    if  (root  ==  NULL)  return;  
    postorder(root->left); 
    postorder(root->right);
    cout  <<  root->data << " ";
}

struct Node *insert(struct  Node  *root,  int  value)  { 
    if  (root  ==  NULL)  {
        return  (newNode(value));
    }
    if  (root->data  >  value)  {
        root->left  =  insert(root->left,  value);
    }  else  if  (root->  data  <  value)  {
        root->right  =  insert(root->right,  value);
    }
    return  (root);
}

int  main()  {
    struct  Node  *root  =  newNode(4);  //  4,2,7,1,3,  5 insert(root,  2);
    insert(root,  7);
    insert(root,  1);
    insert(root,  3);
    insert(root,  5);

    cout << "preorder" << " ";
    preorder(root);
    cout << "Inorder" << " ";
    inorder(root);
    cout << "Postorder" << " ";
    postorder(root);
}

//5. C++: Stack implementation
#include <iostream>
#include <limits.h> 
using namespace std;

const int size = 10;  //  max  size  of  stack 
int stack[10];
int topIndex = -1;

bool isEmpty() {
    if (topIndex == -1) return true;
    return false;
}

bool isFull() {
    if (topIndex == size-1) return true;
    return false;
}

int len() {
    if (topIndex == -1)  
        return  0; 
    return (topIndex + 1);
}

int peek() {
    if (isEmpty()) {
        cout << "Stack is Empty!";
        return INT_MIN;
    }
    return stack[topIndex];
}

int pop() {
    if (isEmpty())  {
        cout << "Stack is Empty!";
        return INT_MIN; // handle it while calling
    }
    return stack[topIndex--];
}

void push(int data) { 
    if (isFull())  {
        cout << "Opps, I can't push coz stack is full!"; 
        return;
    }
    stack[topIndex + 1] = data; 
    topIndex += 1;
}

int main() {
    push(1);
    push(2);
    push(3);
    push(4);
    push(5);
    push(6);
    push(7);
    push(8);
    push(9);
    push(10);
    cout << peek() << endl;
    if (isFull() == true) cout << "Stack Full!" << endl; 
    if (isEmpty() == true) cout << "Stack Empty!" << endl;
    return 0;
}


//6. C++:  Queue  implementation
#include <iostream>
#include <limits.h> 
using namespace std;

const int size = 10; //  max  size  of  
int queue[size];
int front = 0, rear = 0;

bool isEmpty() {
    if (front == rear) 
        return  true;
    return  false;
}

bool isFull() {
    if (rear == size) 
        return true;
    return  false;
}

void enqueue(int val) { // insert into queue 
    if  (isFull())  {
        cout << "Oops! Queue is full!"; 
        return;
    }
    queue[rear++] = val;
}

int peek() {
    if  (isEmpty())  {
        cout  <<  "Queue  is  Empty"; 
        return  INT_MIN;
    }
    return  queue[front];
}

int  dequeue()  {  //  remove  front  and  return  it 
    if  (isEmpty())  {
        cout  <<  "Queue  is  Empty!"; return  INT_MIN;
    }
    return  queue[front++];
}

int main() {
    enqueue(1); 
    enqueue(2); 
    enqueue(3); 
    enqueue(4); 
    enqueue(5); 
    enqueue(6); 
    enqueue(7); 
    enqueue(8); 
    enqueue(9); 
    enqueue(10); 
    enqueue(11);
    cout  <<  dequeue()  <<  endl; 
    cout  <<  dequeue()  <<  endl; 
    cout  <<  peek()  <<  endl; 
}

//7. Shortest path: Floyd-Warshall Algorithm in C++
#include <iostream>
using namespace std;

#define V 4
#define INF 999

void printMatrix(int matrix[V][V]) {
  for (int i = 0; i < V; i++) {
    for (int j = 0; j < V; j++) {
      if (matrix[i][j] == INF)
        printf("%4s", "INF");
      else
        printf("%4d", matrix[i][j]);
    }
    printf("\n");
  }
}

void floydWarshall(int graph[V][V]) {
  int matrix[V][V], i, j, k;

  for (i = 0; i < V; i++)
    for (j = 0; j < V; j++)
      matrix[i][j] = graph[i][j];

  for (k = 0; k < V; k++) {
    for (i = 0; i < V; i++) { 
      for (j = 0; j < V; j++) {
        if (matrix[i][k] + matrix[k][j] < matrix[i][j])
          matrix[i][j] = matrix[i][k] + matrix[k][j];
      }
    }
  }
  //i -> j: i -> k, k -> j
  printMatrix(matrix);
}

int main() {
  int graph[V][V] = 
            {{0, 3, INF, 5},
             {2, 0, INF, 4},
             {INF, 1, 0, INF},
             {INF, INF, 2, 0}};
  floydWarshall(graph);
}
/* output:
   0   3   7   5
   2   0   6   4
   3   1   0   5
   5   3   2   0
*/

//8. Merge sort in C++
#include <iostream>
using namespace std;
void merge(int arr[], int p, int q, int r) {
  // Create L ← A[p..q] and M ← A[q+1..r]
  int n1 = q - p + 1;
  int n2 = r - q;

  int L[n1], M[n2];

  for (int i = 0; i < n1; i++)
    L[i] = arr[p + i];
  for (int j = 0; j < n2; j++)
    M[j] = arr[q + 1 + j];
  int i, j, k;
  i = 0;
  j = 0;
  k = p;
  while (i < n1 && j < n2) {
    if (L[i] <= M[j]) {
      arr[k] = L[i];
      i++;
    } else {
      arr[k] = M[j];
      j++;
    }
    k++;
  }
  while (i < n1) {
    arr[k] = L[i];
    i++;
    k++;
  }
  while (j < n2) {
    arr[k] = M[j];
    j++;
    k++;
  }
}

void mergeSort(int arr[], int l, int r) {
  if (l < r) {
    int m = l + (r - l) / 2;
    mergeSort(arr, l, m);
    mergeSort(arr, m + 1, r);
    merge(arr, l, m, r);
  }
}

void printArray(int arr[], int size) {
  for (int i = 0; i < size; i++)
    cout << arr[i] << " ";
  cout << endl;
}

int main() {
  int arr[] = {6, 5, 12, 10, 9, 1};
  int size = sizeof(arr) / sizeof(arr[0]);
  mergeSort(arr, 0, size - 1);
  cout << "Sorted array: \n";
  printArray(arr, size);
  return 0;
}

// 9. Quick sort in C++
#include <iostream>
using namespace std;

void swap(int *a, int *b) {
  int t = *a;
  *a = *b;
  *b = t;
}
void printArray(int array[], int size) {
  int i;
  for (i = 0; i < size; i++)
    cout << array[i] << " ";
  cout << endl;
}

int partition(int array[], int low, int high) {
  int pivot = array[high];
  int i = (low - 1);
  for (int j = low; j < high; j++) {
    if (array[j] <= pivot) {
      i++;
      swap(&array[i], &array[j]);
    }
  }
  swap(&array[i + 1], &array[high]);
  return (i + 1);
}

void quickSort(int array[], int low, int high) {
  if (low < high) {
    int pi = partition(array, low, high);
    quickSort(array, low, pi - 1);
    quickSort(array, pi + 1, high);
  }
}

int main() {
  int data[] = {8, 7, 6, 1, 0, 9, 2};
  int n = sizeof(data) / sizeof(data[0]);
  cout << "Unsorted Array: \n";
  printArray(data, n);
  
  quickSort(data, 0, n - 1);
  
  cout << "Sorted array in ascending order: \n";
  printArray(data, n);
}


// 10. Huffman coding
#include <bits/stdc++.h>
using namespace std;

struct MinHeapNode {
	char data;
	unsigned freq;
	MinHeapNode *left, *right;
	MinHeapNode(char data, unsigned freq) {
		left = right = NULL;
		this->data = data;
		this->freq = freq;
	}
};

struct compare {
	bool operator()(MinHeapNode* l, MinHeapNode* r) {
		return (l->freq > r->freq);
	}
};

void printCodes(struct MinHeapNode* root, string str) {
	if (!root)
		return;
	if (root->data != '$')
		cout << root->data << ": " << str << "\n";
	printCodes(root->left, str + "0");
	printCodes(root->right, str + "1");
}

void HuffmanCodes(char data[], int freq[], int size) {
	struct MinHeapNode *left, *right, *top;
	priority_queue<MinHeapNode*, vector<MinHeapNode*>, compare> minHeap;
	for (int i = 0; i < size; ++i)
		minHeap.push(new MinHeapNode(data[i], freq[i]));
	while (minHeap.size() != 1) {
		left = minHeap.top();
		minHeap.pop();
		right = minHeap.top();
		minHeap.pop();
		top = new MinHeapNode('$', left->freq + right->freq);

		top->left = left;
		top->right = right;

		minHeap.push(top);
	}
	printCodes(minHeap.top(), "");
}

int main() {
	char arr[] = { 'a', 'b', 'c', 'd', 'e', 'f' };
	int freq[] = { 5, 9, 12, 13, 16, 45 };
	int size = sizeof(arr) / sizeof(arr[0]);
	HuffmanCodes(arr, freq, size);
	return 0;
}

/* output:
f: 0
c: 100
d: 101
a: 1100
b: 1101
e: 111 */
