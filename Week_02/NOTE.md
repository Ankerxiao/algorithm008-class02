# 学习笔记
## 哈希表
哈希表也叫散列表，是根据关键码值（key-value）而直接进行访问的数据结构。它通过把关键码值映射到表中一个位置来访问记录，以加快查找的速度。Java中如HashMap，其他语言可能叫做字典，其实都是一样的。
### 定义：
`
public class HashMap<K,V> extents AbstractMap<K,V> implements Map<K,V>, Cloneable, Serializable
`
### Constructors
`HashMap():
Constructs an empty HashMap with the default initial capacity (16) and the default load factor (0.75).`
` HashMap(int initialCapacity):
Constructs an empty HashMap with the specified initial capacity and the default load factor (0.75).
`
`
HashMap(int initialCapacity, float loadFactor):
Constructs an empty HashMap with the specified initial capacity and load factor.
`
### Methods
方法比较多，主要有：  
put:`put(K key, V value)` `putAll(Map<? extends K,? extends V> m)`  
get:`get(Object key)` `getOrDefault(Object key, V defaultValue)`  
其他方法:`isEmpty()` `clear()` `clone()` `containsKey(Object key)` `containsValue(Object value)` `merge(K key, V value, BiFunction<? super V,? super V,? extends V> remappingFunction)` `remove(Object key)` `replace(K key, V value)` `	size()`  
这些方法看名字就知道是什么意思了，在此就不解释了

### 工程实践
电话号码簿、用户信息表、缓存(LRU)、键值对存储(Redis)等

### 例子:有效的字母异位词([题目链接](https://leetcode-cn.com/problems/valid-anagram/description/))：  
给定两个字符串 s 和 t ，编写一个函数来判断 t 是否是 s 的字母异位词。  
示例 1:
输入: s = "anagram", t = "nagaram"
输出: true  
示例 2:
输入: s = "rat", t = "car"
输出: false  
说明:你可以假设字符串只包含小写字母。

    class Solution {
	    public boolean isAnagram(String s, String t) {
	        if (s.length() != t.length()) {
	            return false;
	        }
	        int[] counter = new int[26];
	        for (int i = 0; i < s.length(); i++) {
	            counter[s.charAt(i) - 'a']++;
	            counter[t.charAt(i) - 'a']--;
	        }
	        for (int count : counter) {
	            if (count != 0) {
	                return false;
	            }
	        }
	        return true;
	    }
	}    


--
## 集合
是一种特殊的Hash，里面的value都不重复。Java中的Set是一个接口，其实现类有很多，如`AbstractSet, ConcurrentHashMap.KeySetView, ConcurrentSkipListSet, CopyOnWriteArraySet, EnumSet, HashSet, JobStateReasons, LinkedHashSet, TreeSet`  
具体请参考官方文档：[Set官网](https://docs.oracle.com/en/java/javase/12/docs/api/java.base/java/util/Set.html)  
  
    

--
## 树、二叉树、二叉搜索树
### 定义  
树（英语：tree）是一种抽象数据类型（ADT）或是实现这种抽象数据类型的数据结构，用来模拟具有树状结构性质的数据集合。它是由n（n>0）个有限节点组成一个具有层次关系的集合。把它叫做“树”是因为它看起来像一棵倒挂的树，也就是说它是根朝上，而叶朝下的。它具有以下的特点：  
*	每个节点都只有有限个子节点或无子节点
*	没有父节点的节点称为根节点；
*	每一个非根节点有且只有一个父节点
*	除了根节点外，每个子节点可以分为多个不相交的子树
* 树里面没有环路(cycle)
  
1. **节点的度：**一个节点含有的子树的个数称为该节点的度
2. **树的度：**一棵树中，最大的节点度称为树的度
3. **深度：**对于任意节点n,n的深度为从根到n的唯一路径长，根的深度为0
4. **高度：**对于任意节点n,n的高度为从n到一片树叶的最长路径长，所有树叶的高度为0
  
### 树的种类
* **无序树：**树中任意节点的子节点之间没有顺序关系，这种树称为无序树，也称为自由树
* **有序树：**树中任意节点的子节点之间有顺序关系，这种树称为有序树  
	* **二叉树：**每个节点最多含有两个子树的树称为二叉树
		* **完全二叉树：**对于一颗二叉树，假设其深度为d（d>1）。除了第d层外，其它各层的节点数目均已达最大值，且第d层所有节点从左向右连续地紧密排列，这样的二叉树被称为完全二叉树
			* **满二叉树：**所有叶节点都在最底层的完全二叉树
		* **平衡二叉树(AVL树)：**当且仅当任何节点的两棵子树的高度差不大于1的二叉树
		* **排序二叉树(二叉查找树（英语：Binary Search Tree))：**也称二叉搜索树、有序二叉树
	* **霍夫曼树：**带权路径最短的二叉树称为哈夫曼树或最优二叉树
	* **B树：**一种对读写操作进行优化的自平衡的二叉查找树，能够保持数据有序，拥有多于两个子树

### 实现（二叉树）
	
	public class TreeNode {
	    int val;
	    TreeNode left;
	    TreeNode right;
	    TreeNode(int x) {
	        val = x;
	    }
    }

### 例子
* 二叉树的前序遍历([LeetCode链接](https://leetcode-cn.com/problems/binary-tree-preorder-traversal/))

		class Solution {
		    public List<Integer> preorderTraversal(TreeNode root) {
		        if (root == null) return new ArrayList<>();
		        List<Integer> list = new ArrayList<>();
		        list.add(root.val);
		        list.addAll(preorderTraversal(root.left));
		        list.addAll(preorderTraversal(root.right));
		        return list;
	    	}
		}
	
* 二叉树的中序遍历([LeetCode链接](https://leetcode-cn.com/problems/binary-tree-inorder-traversal/))

		class Solution {
		    public List<Integer> inorderTraversal(TreeNode root) {
		        if (root == null) return new ArrayList<>();
		        List<Integer> list = new ArrayList<>();
		        list.addAll(inorderTraversal(root.left));
		        list.add(root.val);
		        list.addAll(inorderTraversal(root.right));
		        return list;
		    }
		}
* 二叉树的后序遍历([LeetCode链接](https://leetcode-cn.com/problems/binary-tree-postorder-traversal/))

		class Solution {
		    public List<Integer> postorderTraversal(TreeNode root) {
		        if (root == null) return new ArrayList<>();
		        List<Integer> list = new ArrayList<>();
		        list.addAll(postorderTraversal(root.left));
		        list.addAll(postorderTraversal(root.right));
		        list.add(root.val);
		        return list;
		    }
		}
* 二叉树的最大深度([LeetCode链接](https://leetcode-cn.com/problems/maximum-depth-of-binary-tree/))
		
		class Solution {
		    public int maxDepth(TreeNode root) {
		        if (root == null) return 0;
		        int leftHeight = maxDepth(root.left);
		        int rightHeigt = maxDepth(root.right);
		        return Math.max(leftHeight, rightHeigt) + 1;
		    }
		}
* 二叉树的最小深度([LeetCode链接](https://leetcode-cn.com/problems/minimum-depth-of-binary-tree/))
		
		  class Solution {
		    public int minDepth(TreeNode root) {
		        if (root == null) return 0;
		        if (root.left == null && root.right == null) return 1;
		        int depth = Integer.MAX_VALUE;
		        if (root.left != null) {
		            depth = Math.min(minDepth(root.left), depth);
		        }
		        if (root.right != null) {
		            depth = Math.min(minDepth(root.right), depth);
		        }
		        return depth + 1;
		    }
		}
* N叉树的前续遍历([LeetCode链接](https://leetcode-cn.com/problems/n-ary-tree-preorder-traversal/))

		class Solution {
		    public List<Integer> preorder(Node root) {
		        if (root == null) {
		            return new ArrayList<>();
		        }
		        List<Integer> result = new ArrayList<>();
		        result.add(root.val);
		        for (Node node: root.children) {
		            result.addAll(preorder(node));
		        }
		        return result;
		    }
		}

* N叉树的后续遍历([LeetCode链接](https://leetcode-cn.com/problems/n-ary-tree-postorder-traversal/))

		class Solution {
		    public List<Integer> postorder(Node root) {
		        if (root == null) {
		            return new ArrayList<>();
		        }
		        List<Integer> result = new ArrayList<>();
		        for (Node node: root.children) {
		            result.addAll(postorder(node));
		        }
		        result.add(root.val);
		        return result;
		    }
		}
* N叉树的层序遍历([LeetCode链接](https://leetcode-cn.com/problems/n-ary-tree-level-order-traversal/))

		class Solution {
		    public List<List<Integer>> levelOrder(Node root) {
		        List<List<Integer>> result = new ArrayList<>();
		        if (root == null) {
		            return result;
		        }
		        Queue<Node> queue = new LinkedList<>();
		        queue.add(root);
		        while (!queue.isEmpty()) {
		            List<Integer> level = new ArrayList<>();
		            int size = queue.size();
		            for (int i = 0; i < size; i++) {
		                Node node = queue.poll();
		                level.add(node.val);
		                queue.addAll(node.children);
		            }
		            result.add(level);
		        }
		        return result;
		    }
		}

--
## 堆和二叉堆
### 定义  
堆（英语：Heap）是计算机科学中的一种特别的树状数据结构。若是满足以下特性，即可称为堆：“给定堆中任意节点P和C，若P是C的母节点，那么P的值会小于等于（或大于等于）C的值”。若母节点的值恒小于等于子节点的值，此堆称为最小堆（min heap）；反之，若母节点的值恒大于等于子节点的值，此堆称为最大堆（max heap）。在堆中最顶端的那一个节点，称作根节点（root node），根节点本身没有母节点（parent node）。
### 实现代码

	import java.util.Arrays;
	import java.util.NoSuchElementException;
	
	public class BinaryHeap {
	    private static final int d = 2;
	    private int[] heap;
	    private int heapSize;
	    /**
	     * This will initialize our heap with default size.
	     */
	    public BinaryHeap(int capacity) {
	        heapSize = 0;
	        heap = new int[capacity + 1];
	        Arrays.fill(heap, -1);
	    }
	    public boolean isEmpty() {
	        return heapSize == 0;
	    }
	    public boolean isFull() {
	        return heapSize == heap.length;
	    }
	    private int parent(int i) {
	        return (i - 1) / d;
	    }
	    private int kthChild(int i, int k) {
	        return d * i + k;
	    }
	    /**
	     * Inserts new element in to heap
	     * Complexity: O(log N)
	     * As worst case scenario, we need to traverse till the root
	     */
	    public void insert(int x) {
	        if (isFull()) {
	            throw new NoSuchElementException("Heap is full, No space to insert new element");
	        }
	        heap[heapSize] = x;
	        heapSize ++;
	        heapifyUp(heapSize - 1);
	    }
	    /**
	     * Deletes element at index x
	     * Complexity: O(log N)
	     */
	    public int delete(int x) {
	        if (isEmpty()) {
	            throw new NoSuchElementException("Heap is empty, No element to delete");
	        }
	        int maxElement = heap[x];
	        heap[x] = heap[heapSize - 1];
	        heapSize--;
	        heapifyDown(x);
	        return maxElement;
	    }
	    /**
	     * Maintains the heap property while inserting an element.
	     */
	    private void heapifyUp(int i) {
	        int insertValue = heap[i];
	        while (i > 0 && insertValue > heap[parent(i)]) {
	            heap[i] = heap[parent(i)];
	            i = parent(i);
	        }
	        heap[i] = insertValue;
	    }
	    /**
	     * Maintains the heap property while deleting an element.
	     */
	    private void heapifyDown(int i) {
	        int child;
	        int temp = heap[i];
	        while (kthChild(i, 1) < heapSize) {
	            child = maxChild(i);
	            if (temp >= heap[child]) {
	                break;
	            }
	            heap[i] = heap[child];
	            i = child;
	        }
	        heap[i] = temp;
	    }
	    private int maxChild(int i) {
	        int leftChild = kthChild(i, 1);
	        int rightChild = kthChild(i, 2);
	        return heap[leftChild] > heap[rightChild] ? leftChild : rightChild;
	    }
	    /**
	     * Prints all elements of the heap
	     */
	    public void printHeap() {
	        System.out.print("nHeap = ");
	        for (int i = 0; i < heapSize; i++)
	            System.out.print(heap[i] + " ");
	        System.out.println();
	    }
	    /**
	     * This method returns the max element of the heap.
	     * complexity: O(1)
	     */
	    public int findMax() {
	        if (isEmpty())
	            throw new NoSuchElementException("Heap is empty.");
	        return heap[0];
	    }
	    public static void main(String[] args) {
	        BinaryHeap maxHeap = new BinaryHeap(10);
	        maxHeap.insert(10);
	        maxHeap.insert(4);
	        maxHeap.insert(9);
	        maxHeap.insert(1);
	        maxHeap.insert(7);
	        maxHeap.insert(5);
	        maxHeap.insert(3);
	        maxHeap.printHeap();
	        maxHeap.delete(5);
	        maxHeap.printHeap();
	        maxHeap.delete(2);
	        maxHeap.printHeap();
	    }
	}
### 例子：滑动窗口最大值([LeetCode链接](https://leetcode-cn.com/problems/sliding-window-maximum))  
--
## 图
### 定义
图是一种复杂的非线性结构。无权无向图、无权有向图、有权无向图、有权有向图

* 由节点(Vertex)和边(Edge)组成
* 图的表示
	* 邻接表
	* 邻接矩阵
* 图的遍历：BFS、DFS
* 最小生成树问题（Prim Kruskal）
* 最短路径问题（Dijkstra Bellman-Ford）
* 拓扑排序



