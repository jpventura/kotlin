/*
 * Copyright 2010-2021 JetBrains s.r.o. and Kotlin Programming Language contributors.
 * Use of this source code is governed by the Apache 2.0 license that can be found in the license/LICENSE.txt file.
 */

package kotlin.text

//
// NOTE: THIS FILE IS AUTO-GENERATED by the GenerateUnicodeData.kt
// See: https://github.com/JetBrains/kotlin/tree/master/libraries/stdlib
//

private object OtherLowercase {
    val otherLowerStart = intArrayOf(
        0x00aa, 0x00ba, 0x02b0, 0x02c0, 0x02e0, 0x0345, 0x037a, 0x1d2c, 0x1d78, 0x1d9b, 0x2071, 0x207f, 0x2090, 0x2170, 0x24d0, 0x2c7c, 0xa69c, 0xa770, 0xa7f8, 0xab5c, 
    )
    val otherLowerLength = intArrayOf(
        1, 1, 9, 2, 5, 1, 1, 63, 1, 37, 1, 1, 13, 16, 26, 2, 2, 1, 2, 4, 
    )
}

internal fun Int.isOtherLowercase(): Boolean {
    val index = binarySearchRange(OtherLowercase.otherLowerStart, this)
    return index >= 0 && this < OtherLowercase.otherLowerStart[index] + OtherLowercase.otherLowerLength[index]
}
