package com.davisuga.day1pt2

import scala.util.matching.Regex

val digitOfWord: String => String =
  case "zero"  => "0"
  case "one"   => "1"
  case "two"   => "2"
  case "three" => "3"
  case "four"  => "4"
  case "five"  => "5"
  case "six"   => "6"
  case "seven" => "7"
  case "eight" => "8"
  case "nine"  => "9"
  case word    => word.toIntOption.map(_.toString).getOrElse("")

val allDigits: Regex =
  """(zero|one|two|three|four|five|six|seven|eight|nine|\d)""".r

val allDigitsReversed: Regex =
  """(orez|eno|owt|eerht|ruof|evif|xis|neves|thgie|enin|\d)""".r

def getFirstAndLastInts(line: String): Int = {
  for
    first <- allDigits.findFirstIn(line)
    last <- allDigitsReversed.findFirstIn(line.reverse)
    line = digitOfWord(first) + digitOfWord(last.reverse)
  yield line.toInt
}.getOrElse(0)

@main def main =
  io.Source
    .fromFile("inputs/day1input.txt")
    .getLines
    .map(getFirstAndLastInts)
    .sum
