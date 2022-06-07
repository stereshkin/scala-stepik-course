package exercises.week2

import scala.annotation.tailrec

object RecursionExercise extends App {
  val x: Int = 10
  val y: Int = 5
  val n: Int = 5


  def AddYtoX(x: Int, y: Int, n: Int) : Int = {
    @tailrec
    def loop(n: Int, acc: Int = x) : Int = {
      if (n == 0) acc
      else loop(n - 1, acc + y)
    }

    loop(n)
  }


  def FindDigitsCount(result: Int) : Int = {
    @tailrec
    def loop(number: Int, acc: Int = 0) : Int = {
      if (number / 10 == 0) acc
      else loop(number / 10, acc + 1)
    }

    loop(result)
  }


  val result : Int = AddYtoX(x, y, n)
  val times : Int = FindDigitsCount(result)
  val result_string : String = result.toString


  def PrintResult(result: Int, times: Int) : String = {
    @tailrec
    def loop(n: Int, acc: String = result_string) : String = {
      if (n == 0) acc
      else loop(n - 1, s"$acc $result")
    }
    loop(times)
  }

  val final_result : String = PrintResult(result, times) ++: " is the result"
  println(final_result)
}
