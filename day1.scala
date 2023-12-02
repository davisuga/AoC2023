def getFirstAndLastInts(line: String) =
  val ints = line.flatMap(_.toString.toIntOption)
  (ints.headOption, ints.lastOption) match
    case (Some(first), Some(last)) => (s"${first}${last}").toInt
    case _                         => 0

@main def main = print:
  io.Source
    .fromFile("day1input.txt")
    .getLines
    .map(getFirstAndLastInts)
    .reduce(_ + _)
