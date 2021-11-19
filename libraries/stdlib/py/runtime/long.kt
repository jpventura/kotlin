/*
 * Copyright 2010-2021 JetBrains s.r.o. and Kotlin Programming Language contributors.
 * Use of this source code is governed by the Apache 2.0 license that can be found in the license/LICENSE.txt file.
 */

@file:Suppress("NOTHING_TO_INLINE")

package kotlin

/**
 * Represents a 64-bit signed integer.
 */
class Long internal constructor(
    internal val low: Int,
    internal val high: Int
) : Number(), Comparable<Long> {

    companion object {
        /**
         * A constant holding the minimum value an instance of Long can have.
         */
        const val MIN_VALUE: Long = -9223372036854775807L - 1L

        /**
         * A constant holding the maximum value an instance of Long can have.
         */
        const val MAX_VALUE: Long = 9223372036854775807L

        /**
         * The number of bytes used to represent an instance of Long in a binary form.
         */
        @SinceKotlin("1.3")
        const val SIZE_BYTES: Int = 8

        /**
         * The number of bits used to represent an instance of Long in a binary form.
         */
        @SinceKotlin("1.3")
        const val SIZE_BITS: Int = 64
    }

    /**
     * Compares this value with the specified value for order.
     * Returns zero if this value is equal to the specified other value, a negative number if it's less than other,
     * or a positive number if it's greater than other.
     */
    inline operator fun compareTo(other: Byte): Int = compareTo(other.toLong())

    /**
     * Compares this value with the specified value for order.
     * Returns zero if this value is equal to the specified other value, a negative number if it's less than other,
     * or a positive number if it's greater than other.
     */
    inline operator fun compareTo(other: Short): Int = compareTo(other.toLong())

    /**
     * Compares this value with the specified value for order.
     * Returns zero if this value is equal to the specified other value, a negative number if it's less than other,
     * or a positive number if it's greater than other.
     */
    inline operator fun compareTo(other: Int): Int = compareTo(other.toLong())

    /**
     * Compares this value with the specified value for order.
     * Returns zero if this value is equal to the specified other value, a negative number if it's less than other,
     * or a positive number if it's greater than other.
     */
    override operator fun compareTo(other: Long): Int = compare(other)

    /**
     * Compares this value with the specified value for order.
     * Returns zero if this value is equal to the specified other value, a negative number if it's less than other,
     * or a positive number if it's greater than other.
     */
    inline operator fun compareTo(other: Float): Int = toFloat().compareTo(other)

    /**
     * Compares this value with the specified value for order.
     * Returns zero if this value is equal to the specified other value, a negative number if it's less than other,
     * or a positive number if it's greater than other.
     */
    inline operator fun compareTo(other: Double): Int = toDouble().compareTo(other)

    /** Adds the other value to this value. */
    inline operator fun plus(other: Byte): Long = plus(other.toLong())

    /** Adds the other value to this value. */
    inline operator fun plus(other: Short): Long = plus(other.toLong())

    /** Adds the other value to this value. */
    inline operator fun plus(other: Int): Long = plus(other.toLong())

    /** Adds the other value to this value. */
    operator fun plus(other: Long): Long = add(other)

    /** Adds the other value to this value. */
    inline operator fun plus(other: Float): Float = toFloat() + other

    /** Adds the other value to this value. */
    inline operator fun plus(other: Double): Double = toDouble() + other

    /** Subtracts the other value from this value. */
    inline operator fun minus(other: Byte): Long = minus(other.toLong())

    /** Subtracts the other value from this value. */
    inline operator fun minus(other: Short): Long = minus(other.toLong())

    /** Subtracts the other value from this value. */
    inline operator fun minus(other: Int): Long = minus(other.toLong())

    /** Subtracts the other value from this value. */
    operator fun minus(other: Long): Long = subtract(other)

    /** Subtracts the other value from this value. */
    inline operator fun minus(other: Float): Float = toFloat() - other

    /** Subtracts the other value from this value. */
    inline operator fun minus(other: Double): Double = toDouble() - other

    /** Multiplies this value by the other value. */
    inline operator fun times(other: Byte): Long = times(other.toLong())

    /** Multiplies this value by the other value. */
    inline operator fun times(other: Short): Long = times(other.toLong())

    /** Multiplies this value by the other value. */
    inline operator fun times(other: Int): Long = times(other.toLong())

    /** Multiplies this value by the other value. */
    operator fun times(other: Long): Long = multiply(other)

    /** Multiplies this value by the other value. */
    inline operator fun times(other: Float): Float = toFloat() * other

    /** Multiplies this value by the other value. */
    inline operator fun times(other: Double): Double = toDouble() * other

    /** Divides this value by the other value, truncating the result to an integer that is closer to zero. */
    inline operator fun div(other: Byte): Long = div(other.toLong())

    /** Divides this value by the other value, truncating the result to an integer that is closer to zero. */
    inline operator fun div(other: Short): Long = div(other.toLong())

    /** Divides this value by the other value, truncating the result to an integer that is closer to zero. */
    inline operator fun div(other: Int): Long = div(other.toLong())

    /** Divides this value by the other value, truncating the result to an integer that is closer to zero. */
    operator fun div(other: Long): Long = divide(other)

    /** Divides this value by the other value. */
    inline operator fun div(other: Float): Float = toFloat() / other

    /** Divides this value by the other value. */
    inline operator fun div(other: Double): Double = toDouble() / other

    /**
     * Calculates the remainder of truncating division of this value by the other value.
     *
     * The result is either zero or has the same sign as the _dividend_ and has the absolute value less than the absolute value of the divisor.
     */
    @SinceKotlin("1.1")
    inline operator fun rem(other: Byte): Long = rem(other.toLong())

    /**
     * Calculates the remainder of truncating division of this value by the other value.
     *
     * The result is either zero or has the same sign as the _dividend_ and has the absolute value less than the absolute value of the divisor.
     */
    @SinceKotlin("1.1")
    inline operator fun rem(other: Short): Long = rem(other.toLong())

    /**
     * Calculates the remainder of truncating division of this value by the other value.
     *
     * The result is either zero or has the same sign as the _dividend_ and has the absolute value less than the absolute value of the divisor.
     */
    @SinceKotlin("1.1")
    inline operator fun rem(other: Int): Long = rem(other.toLong())

    /**
     * Calculates the remainder of truncating division of this value by the other value.
     *
     * The result is either zero or has the same sign as the _dividend_ and has the absolute value less than the absolute value of the divisor.
     */
    @SinceKotlin("1.1")
    operator fun rem(other: Long): Long = modulo(other)

    /**
     * Calculates the remainder of truncating division of this value by the other value.
     *
     * The result is either zero or has the same sign as the _dividend_ and has the absolute value less than the absolute value of the divisor.
     */
    @SinceKotlin("1.1")
    inline operator fun rem(other: Float): Float = toFloat() % other

    /**
     * Calculates the remainder of truncating division of this value by the other value.
     *
     * The result is either zero or has the same sign as the _dividend_ and has the absolute value less than the absolute value of the divisor.
     */
    @SinceKotlin("1.1")
    inline operator fun rem(other: Double): Double = toDouble() % other

    /**
     * Returns this value incremented by one.
     *
     * @sample samples.misc.Builtins.inc
     */
    operator fun inc(): Long = this + 1L

    /**
     * Returns this value decremented by one.
     *
     * @sample samples.misc.Builtins.dec
     */
    operator fun dec(): Long = this - 1L

    /** Returns this value. */
    inline operator fun unaryPlus(): Long = this

    /** Returns the negative of this value. */
    operator fun unaryMinus(): Long = inv() + 1L

    /** Creates a range from this value to the specified [other] value. */
    operator fun rangeTo(other: Byte): LongRange = rangeTo(other.toLong())

    /** Creates a range from this value to the specified [other] value. */
    operator fun rangeTo(other: Short): LongRange = rangeTo(other.toLong())

    /** Creates a range from this value to the specified [other] value. */
    operator fun rangeTo(other: Int): LongRange = rangeTo(other.toLong())

    /** Creates a range from this value to the specified [other] value. */
    operator fun rangeTo(other: Long): LongRange = LongRange(this, other)

    /**
     * Shifts this value left by the [bitCount] number of bits.
     *
     * Note that only the six lowest-order bits of the [bitCount] are used as the shift distance.
     * The shift distance actually used is therefore always in the range `0..63`.
     */
    infix fun shl(bitCount: Int): Long = shiftLeft(bitCount)

    /**
     * Shifts this value right by the [bitCount] number of bits, filling the leftmost bits with copies of the sign bit.
     *
     * Note that only the six lowest-order bits of the [bitCount] are used as the shift distance.
     * The shift distance actually used is therefore always in the range `0..63`.
     */
    infix fun shr(bitCount: Int): Long = shiftRight(bitCount)

    /**
     * Shifts this value right by the [bitCount] number of bits, filling the leftmost bits with zeros.
     *
     * Note that only the six lowest-order bits of the [bitCount] are used as the shift distance.
     * The shift distance actually used is therefore always in the range `0..63`.
     */
    infix fun ushr(bitCount: Int): Long = shiftRightUnsigned(bitCount)

    /** Performs a bitwise AND operation between the two values. */
    infix fun and(other: Long): Long = Long(low and other.low, high and other.high)

    /** Performs a bitwise OR operation between the two values. */
    infix fun or(other: Long): Long = Long(low or other.low, high or other.high)

    /** Performs a bitwise XOR operation between the two values. */
    infix fun xor(other: Long): Long = Long(low xor other.low, high xor other.high)

    /** Inverts the bits in this value. */
    fun inv(): Long = Long(low.inv(), high.inv())

    override fun toByte(): Byte = low.toByte()
    @Deprecated("Direct conversion to Char is deprecated. Use toInt().toChar() or Char constructor instead.", ReplaceWith("this.toInt().toChar()"))
    @DeprecatedSinceKotlin(warningSince = "1.5")
    override fun toChar(): Char = low.toChar()
    override fun toShort(): Short = low.toShort()
    override fun toInt(): Int = low
    override fun toLong(): Long = this
    override fun toFloat(): Float = toDouble().toFloat()
    override fun toDouble(): Double = toNumber()

    // This method is used by `toString()`
    @JsName("valueOf")
    internal fun valueOf() = toDouble()

    override fun equals(other: Any?): Boolean = other is Long && equalsLong(other)

    override fun hashCode(): Int = hashCode(this)

    override fun toString(): String = this.toStringImpl(radix = 10)
}