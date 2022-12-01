package day1

import scala.io.Source

object TopThree extends App {

  val fileName = "src/main/scala/day1/input.txt"
  val elfFoods = Source.fromFile(fileName).getLines().toList

  def transformToListOfElfItemSums(list: List[String], elfCalSum: Int, finalList: List[Int]): List[Int] =
    list match {
      case Nil => finalList
      case xs :: xy =>
        if(xs equals "") transformToListOfElfItemSums(xy, 0, elfCalSum :: finalList)
        else transformToListOfElfItemSums(xy, xs.toInt + elfCalSum, finalList)
    }

  println(transformToListOfElfItemSums(elfFoods, 0, List.empty).sortWith(_ > _).take(3).sum)
}
