package exercises.week2

object GenericList extends App {

  class Log[+A](h: A, t: LogList[A]) extends LogList[A] {
    def add[B >: A](msg: B): LogList[B] = new Log[B](msg, this)

    def last: A = h

    def previous: LogList[A] = t

    def isEmpty = false

    def all: String = {
      if (this.previous.previous.isEmpty) this.h.toString ++ " " + this.previous.last.toString
      else this.h.toString ++ " " ++ new Log(this.previous.last, this.previous.previous).all
    }
  }

  object Empty extends LogList[Nothing] {

    def add[B >: Nothing](msg: B): LogList[B] = new Log[B](msg, Empty : LogList[B])
    def isEmpty = true
    def all = ""
    def last = throw new NoSuchElementException
    def previous = throw new NoSuchElementException
  }


  abstract class LogList[+A]() {
    def last: A
    def previous: LogList[A]
    def isEmpty: Boolean
    def all: String
    def add[B >: A](msg: B): LogList[B]
  }

  val intLogs: LogList[Int] = Empty
  val strLogs: LogList[String] = Empty
}
