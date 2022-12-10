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
        cout << “Stack is Empty!”;
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
