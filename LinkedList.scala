package exercises.week2

object LinkedList extends App {

  class Log(head: String, tail: LogList) extends LogList {
    def add(msg: String): LogList = new Log(msg, this)

    def last: String = head

    def previous: LogList = tail

    def isEmpty = false

    def all: String = {
      if (this.previous.previous.isEmpty) this.head ++ " " + this.previous.last
      else this.head ++ " " ++ new Log(this.previous.last, this.previous.previous).all
    }
  }

  object Empty extends LogList {

    def add(msg: String): LogList = new Log(msg, Empty)
    def isEmpty = true
    def all = ""
    def last = throw new NoSuchElementException
    def previous = throw new NoSuchElementException
    }


  abstract class LogList() {
    def last: String
    def previous: LogList
    def isEmpty: Boolean
    def all: String
    def add(msg: String): LogList
  }

  //val logger = new Log("m1", new Log("m2", new Log("m3", Empty)))
  //println(logger.all)
}
