package com.davisuga
import org.scalatest._
import org.scalatest.flatspec._
import org.scalatest.matchers._

val testInput = """
two1nine
eightwothree
abcone2threexyz
xtwone3four
4nineeightseven2
zoneight234
vkzvsphbltfxjfxxsl9
7pqrstsixteen
"""
import io.Source
class Tests extends AnyFlatSpec with should.Matchers {
  "Day 1" should "work" in {
    assert(
      day1.main ==
        54304
    )
  }
  "Day 1 pt. 2" should "find the sum in test input" in {
    testInput
      .split("\n")
      .map(day1pt2.getFirstAndLastInts)
      .reduce(_ + _) shouldEqual 380
  }
  "Day 1 pt. 2" should "find the sum in real input" in {
    Source
      .fromFile("inputs/day1input.txt")
      .getLines
      .map(day1pt2.getFirstAndLastInts(_))
      .sum shouldEqual 54418
  }
}
