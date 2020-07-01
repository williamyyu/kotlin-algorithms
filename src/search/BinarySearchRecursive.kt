package search

import kotlin.test.assertEquals

/**
 * @author WeiYi Yu
 * @date 2020-06-25
 */

/**
 *  Time Complexity
 *
 *  Best-case: O(1) -> the element to be searched for is at the first index of the array
 *  Worst-case: O(log n)
 */

fun main() {
    val values = arrayOf(1, 2, 3, 4)

    assertEquals(0, binarySearch(1, values, 0, values.size - 1))
    assertEquals(1, binarySearch(2, values, 0, values.size - 1))
    assertEquals(2, binarySearch(3, values, 0, values.size - 1))
    assertEquals(3, binarySearch(4, values, 0, values.size - 1))

    assertEquals(-1, binarySearch(5, values, 0, values.size - 1))
    assertEquals(-1, binarySearch(1, values, 1, values.size - 1))
    assertEquals(-1, binarySearch(4, values, 0, values.size - 2))
}

private fun binarySearch(element: Int, array: Array<Int>, fromIndex: Int, toIndex: Int): Int {
    if (fromIndex > toIndex) return -1

    val mid = (fromIndex + toIndex) / 2
    val midElement = array[mid]

    return when {
        element > midElement -> binarySearch(element, array, mid + 1, toIndex)
        element < midElement -> binarySearch(element, array, fromIndex, mid - 1)
        else -> mid
    }
}