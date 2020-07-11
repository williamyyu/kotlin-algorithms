package sorting

/**
 * @author WeiYi Yu
 * @date 2020-07-01
 */

/**
 *  Quick sort is one of the Divide & Conquer algorithms
 *
 *  Time Complexity
 *
 *  Best-case: O(n * log(n)) -> there are log(n) levels and each level's comparision takes O(n)
 *  Worst-case: O(n^2) -> there are n levels and each level's comparision takes O(n)
 */
fun main() {
    val values = listOf(3, 7, 5, 1, 2, 3)
    val quickSort = values.quickSort()
    println(quickSort.toString())
}

fun <T : Comparable<T>> List<T>.quickSort(): List<T> {
    if (size < 2) {
        return this
    }

    val pivot = this[size / 2]
    val smaller = filter { it < pivot }
    val equal = filter { it == pivot }
    val larger = filter { it > pivot }
    return smaller.quickSort() + equal + larger.quickSort()
}