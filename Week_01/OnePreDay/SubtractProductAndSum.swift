func subtractProductAndSum(_ n: Int) -> Int {
    var inN = n
    var add = 0
    var mul = 1
    while inN > 0 {
        let digit = inN % 10
        inN /= 10
        add += digit
        mul *= digit
    }
    return mul - add;
}