import java.util.*;

class MyCircularDeque {
    int size;
    List<Integer> myDeque;
    /** Initialize your data structure here. Set the size of the deque to be k. */
    public MyCircularDeque(int k) {
        size = k;
        myDeque = new ArrayList<>();
    }

    /** Adds an item at the front of Deque. Return true if the operation is successful. */
    public boolean insertFront(int value) {
        if (myDeque.size() < size) {
            try {
                myDeque.add(0, value);
            } catch (Exception e) {
                return false;
            }
            return true;
        }
        return false;
    }

    /** Adds an item at the rear of Deque. Return true if the operation is successful. */
    public boolean insertLast(int value) {
        if (myDeque.size() < size) {
            try {
                myDeque.add(value);
            } catch (Exception e) {
                return false;
            }
            return true;
        }
        return false;
    }

    /** Deletes an item from the front of Deque. Return true if the operation is successful. */
    public boolean deleteFront() {
        if (myDeque.size() > 0) {
            try {
                myDeque.remove(0);
            } catch (Exception e) {
                return false;
            }
            return true;
        }
        return false;
    }

    /** Deletes an item from the rear of Deque. Return true if the operation is successful. */
    public boolean deleteLast() {
        if (myDeque.size() > 0) {
            try {
                myDeque.remove(myDeque.size() - 1);
            } catch (Exception e) {
                return false;
            }
            return true;
        }
        return false;
    }

    /** Get the front item from the deque. */
    public int getFront() {
        if (myDeque.size() > 0) {
            return myDeque.get(0);
        }
        return -1;
    }

    /** Get the last item from the deque. */
    public int getRear() {
        if (myDeque.size() > 0) {
            return myDeque.get(myDeque.size() - 1);
        }
        return -1;
    }

    /** Checks whether the circular deque is empty or not. */
    public boolean isEmpty() {
        return myDeque.isEmpty();
    }

    /** Checks whether the circular deque is full or not. */
    public boolean isFull() {
        return myDeque.size() == size;
    }
}

/**
 * Your MyCircularDeque object will be instantiated and called as such:
 * MyCircularDeque obj = new MyCircularDeque(k);
 * boolean param_1 = obj.insertFront(value);
 * boolean param_2 = obj.insertLast(value);
 * boolean param_3 = obj.deleteFront();
 * boolean param_4 = obj.deleteLast();
 * int param_5 = obj.getFront();
 * int param_6 = obj.getRear();
 * boolean param_7 = obj.isEmpty();
 * boolean param_8 = obj.isFull();
 */
