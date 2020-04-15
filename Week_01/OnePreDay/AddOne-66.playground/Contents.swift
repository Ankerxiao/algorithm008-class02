class Solution {
    func plusOne(_ digits: [Int]) -> [Int] {
        var result = digits
        var i = digits.count - 1
        var addNum = 1
        while i >= 0 {
            result[i] = result[i] + addNum
            if result[i] >= 10 {
                result[i] = result[i] % 10
                addNum = 1
            } else {
                addNum = 0
            }
            i -= 1
        }
        if addNum == 1 {
            result.insert(1, at: 0)
        }
        return result
    }
}

var so = Solution()
print(so.plusOne([9, 9, 9]))
