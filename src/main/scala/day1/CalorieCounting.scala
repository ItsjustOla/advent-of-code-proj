package day1

import scala.io.Source

/**
 * Day 1 - part 1 prompt
 * https://adventofcode.com/2022/day/1
 */

object CalorieCounting extends App {

  val fileName = "src/main/scala/day1/input.txt"
  val elfFoods = Source.fromFile(fileName).getLines().toList

  def calorieIter(list: List[String], elfCalSum: Int, largestCal: Int): Int = {
    list match {
      case Nil => largestCal
      case xs :: xy =>
        if (xs equals "")
          if (elfCalSum >= largestCal)
            calorieIter(xy, 0, elfCalSum)
          else
            calorieIter(xy, 0, largestCal)
        else
          calorieIter(xy, xs.toInt + elfCalSum, largestCal)
    }
  }

  println(calorieIter(elfFoods, 0, 0))
}
