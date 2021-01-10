"""
CSCI3070- Assignment 1
Question 4: Heap Sort
Tharuni Iranjan 100694352, Deepan Patel 100704821
"""

import math

class heap:
    def __init__(self):
        self.heap_size = 0

    #swaps to elements in an array with each other position
    def swap(self,arr,a,b):
       arr[a], arr[b] = arr[b], arr[a]
       return arr

    #return the parent index
    def parent(self,index):
        return int(math.floor(index/2))

    #returns the left child index
    def left_child(self,index):
        return 2*index

    #returns the right child index
    def right_child(self,index):
        return (2*index)+1


    def max_heapify(self,A,index):
        #get the left and right child
        left = self.left_child(index)
        right = self.right_child(index)

        #this checks if left child is bigger then parent
        if left <= self.heap_size and A[left-1] > A[index-1]:
            largest = left
        else:
            largest = index
        #this checks if right child is bigger then parent
        if right <= self.heap_size and A[right-1] > A[largest-1]:
            largest = right

        #swaps with the largest child or the parents itself
        if largest != index:
            self.swap(A,index-1,largest-1)
            self.max_heapify(A,largest)

    #calls max heap half of the tree size so it creates a max heap
    def build_max_heap(self,A):
        print("Building max heap ..")
        self.heap_size = len(A)

        start = int(math.floor(len(A)/2))

        for i in range(start,0,-1):
            self.max_heapify(A,i)

    def heap_maximum(self,A):
        return A[0]#this is the maximum value the root node

    def heap_extract_max(self,A):
        print("Heap extract max ..")
        if self.heap_size < 1:
            return("error over flow") #the heap has no elements
        max = A[0]#this is the maximum value the root node
        self.swap(A,0,self.heap_size-1)#take the last element move it to the root of the heap and
        self.heap_size -= 1
        A.pop()#we remove the last element then re-adjust the heap
        self.max_heapify(A,1)
        return max

    #insert element at the end of the heap and then readjust to become a heap
    def max_heap_insert(self,A,element):
        print("Max heap insert ..")
        self.heap_size += 1
        A.append(element)

        index = self.heap_size
        while A[index-1] > A[self.parent(index)-1] and index>1:
            self.swap(A,index-1,self.parent(index)-1)
            index = self.parent(index)

    #sorts the array from least to greatest
    def heap_sort(self,A):
        print("Heap sort ..")
        #each element get swaped to the root node then max heapify is called
        for i in range(len(A),1,-1):
            self.swap(A,0,i-1)
            self.heap_size -= 1
            self.max_heapify(A,1)

    #print A in an array form
    def print_as_array(self,A):
        print("Heap in array format ..")
        print(A)


    #prints it as a horizontal binary tree
    def print_tree(self,A,index,indent):
        #The recursion process
        #print right
        #print node
        #print left

        if(self.right_child(index)<=len(A)):
            # print("moving right .. P(A,{})".format(self.right_child(index)))
            self.print_tree(A,self.right_child(index),indent + "   ")


        print(indent+str(A[index-1]))#print the node

        #then wanna check for a left node
        if(self.left_child(index) <= len(A)):
            # print("moving left .. P(A,{})".format(self.left_child(index)))
            self.print_tree(A,self.left_child(index),indent+"   ")

    def print_as_tree(self,A):
        print("Prints heap in tree format ..")
        self.print_tree(A,1,"")

# TESTING CODE HERE
A = [4,1,3,2,16,9,10,14,8,7]
heap = heap()
print("A:")
print(A)
heap.build_max_heap(A)
print(A)
heap.print_as_tree(A)
heap.print_as_array(A)
heap.heap_extract_max(A)
print(A)
heap.max_heap_insert(A,30)
print(A)
heap.heap_sort(A)
print(A)
