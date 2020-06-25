package search

import kotlin.test.assertEquals
import kotlin.test.assertFailsWith

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

    assertEquals(0, values.binarySearch(1, 0, values.size - 1))
    assertEquals(1, values.binarySearch(2, 0, values.size - 1))
    assertEquals(2, values.binarySearch(3, 0, values.size - 1))
    assertEquals(3, values.binarySearch(4, 0, values.size - 1))

    assertEquals(-1, values.binarySearch(5, 0, values.size - 1))
    assertEquals(-1, values.binarySearch(1, 1, values.size - 1))
    assertEquals(-1, values.binarySearch(4, 0, values.size - 2))

    assertFailsWith(IllegalArgumentException::class) {
        values.binarySearch(1, 4, 1)
    }

    assertFailsWith(ArrayIndexOutOfBoundsException::class) {
        values.binarySearch(1, -1, values.size - 1)
    }

    assertFailsWith(ArrayIndexOutOfBoundsException::class) {
        values.binarySearch(1, 0, values.size)
    }
}

/**
 * Requires: the input need to be a sorted array.
 *
 * @param element the value to be searched for
 * @param fromIndex the index of the first element (inclusive) to be searched
 * @param toIndex the index of the last element (inclusive) to be searched
 * @return index of the element if found. return -1 otherwise.
 *
 * @throws IllegalArgumentException
 *         if {@code fromIndex > toIndex}
 * @throws ArrayIndexOutOfBoundsException
 *         if {@code fromIndex < 0 or toIndex > IntArray.size-1}
 */
fun <T : Comparable<T>> Array<T>.binarySearch(element: T, fromIndex: Int, toIndex: Int): Int {
    checkRange(size, fromIndex, toIndex)
    var low = fromIndex
    var high = toIndex

    while (low <= high) {
        val mid = (low + high) / 2
        val midVal = this[mid]
        when {
            element > midVal -> low = mid + 1
            element < midVal -> high = mid - 1
            else -> return mid // element found
        }
    }
    return -1
}

private fun checkRange(size: Int, fromIndex: Int, toIndex: Int) {
    if (fromIndex > toIndex) {
        throw IllegalArgumentException()
    }

    if (fromIndex < 0 || toIndex > size - 1)
        throw ArrayIndexOutOfBoundsException()
}