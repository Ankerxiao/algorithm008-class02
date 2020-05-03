# 学习笔记
## 泛型递归、树的递归
树的面试题解法一般都是递归。节点的定义和重复性（自相似性）  
### 示例代码：

	def preorder(self, root):
		if root:
			self.traverse_path.append(root.val)
			self.preorder(root.left)
			self.preorder(root.right)
	def inorder(self, root):
		if root:
			self.inorder(root.left)
			self.traverse_path.append(root.val)
			self.inorder(root.right)
	def postorder(self, root):
		if root:
			self.postorder(root.left)
			self.postorder(root.right)
			self.traverse_path.append(root.val)

### 模板
* **Python版** 
	
		def recursion(level, param1, param2, ...):
			# recursion terminator
			if level > MAX_LEVEL:
				process_result
				return
			#process logic in current level
			process(level, data...)
			#drill down
			self.recursion(level+1, p1, ...)
			## reverse the current level status if needed
* **Java版**

		public void recur(int level, int param) {
		     // terminator
			if (level > MAX_LEVEL) { 
				// process result
				return; 
			}
		    // process current logic
		    process(level, param);
		    // drill down
		    recur( level: level + 1, newParam);
		    // restore current status
		}

### 思维要点
* 不要人肉进行递归
* 找到最近最简方法，将其拆解成可重复解决的问题(重复子问题)
* 数学归纳法思维

--

## 分治（Divide & Conquer）
### 定义
* 分治法是建基于多项分支递归的一种很重要的算法范式。字面上的解释是“分而治之”，就是把一个复杂的问题分成两个或更多的相同或相似的子问题，直到最后子问题可以简单的直接求解，原问题的解即子问题的解的合并。  
* 这个技巧是很多高效算法的基础，如排序算法（归并排序、快速排序）、傅立叶变换（快速傅立叶变换）。

### 实现
循环递归，在每一层递归上都有三个步骤：  

1. 分解：将原问题分解为若干个规模较小，相对独立，与原问题形式相同的子问题。
2. 解决：若子问题规模较小且易于解决时，则直接解。否则，递归地解决各子问题。
3. 合并：将各子问题的解合并为原问题的解。

### 代码模板

	def divide_conquer(problem, param1, param2, ...): # recursion terminator
		if problem is None:
		    print_result
		return
		
		# prepare data
		data = prepare_data(problem)
		subproblems = split_problem(problem, data)
		
		# conquer subproblems
		subresult1 = self.divide_conquer(subproblems[0], p1, ...) subresult2 = self.divide_conquer(subproblems[1], p1, ...) subresult3 = self.divide_conquer(subproblems[2], p1, ...)
		...
		# process and generate the final result
		result = process_result(subresult1, subresult2, subresult3, ...)
	    # revert the current level states

### 例子（归并排序）

	void merge_sort(int array[], unsigned int first, unsigned int last)
	 {
	 	int mid = 0;
	 	if(first<last)
	 	{
	 		mid = (first+last)/2;
	 		merge_sort(array, first, mid);
	 		merge_sort(array, mid+1,last);
	 		merge(array,first,mid,last);
	 	}
	 }
	    
## 回溯（Backtracking）
回溯法（英语：backtracking）是暴力搜索法中的一种。
回溯法采用试错的思想，它尝试分步的去解决一个问题。在分步解决问题的过程中，当它通过尝试发现现有的分步答案不能得到有效的正确的解答的时候，它将取消上一步甚至是上几步的计算，再通过其它的可能的分步解答再次尝试寻找问题的答案。	    
回溯法通常用最简单的递归方法来实现，在反复重复上述的步骤后可能出现两种 情况:  

* 找到一个可能存在的正确的答案
* 在尝试了所有可能的分步方法后宣告该问题没有答案  

在最坏的情况下，回溯法会导致一次复杂度为指数时间的计算
### 典型应用
八皇后问题是应用回溯法求解的典型案例


