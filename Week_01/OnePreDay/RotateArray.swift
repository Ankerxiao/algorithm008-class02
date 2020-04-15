extension Array {
    mutating func reversed(_ start: Int, _ end: Int) {
        var inStart = start
        var inEnd = end
        while inStart < inEnd {
            let temp = self[inStart]
            self[inStart] = self[inEnd]
            self[inEnd] = temp
            inStart += 1
            inEnd -= 1
        }
    }
}

class Solution {
    func rotate(_ nums: inout [Int], _ k: Int) {
        guard nums.count > 1 else { return }
        guard k > 0 else { return }
        let count = nums.count
        let inK = k % count
        if inK == 0 {
            return
        }
        nums.reversed(0, count - 1)
        nums.reversed(0, inK - 1)
        nums.reversed(inK, count - 1)
    }
}
var so = Solution()
var arr = [1, 2, 3, 4, 5]
so.rotate(&arr, 1)
print(arr)