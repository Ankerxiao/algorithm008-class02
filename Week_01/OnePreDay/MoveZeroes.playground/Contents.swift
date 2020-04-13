func moveZeroes(_ nums: inout [Int]) {
    var j = 0
    for (index, _) in nums.enumerated() {
        if nums[index] != 0 {
            if index != j {
                nums[j] = nums[index]
                nums[index] = 0
            }
            j += 1
        }
    }
}

var arr = [0, 1, 0, 3, 12]
moveZeroes(&arr)
print(arr)
