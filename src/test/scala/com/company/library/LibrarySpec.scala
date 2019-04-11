package com.company.library

import org.scalatest.{BeforeAndAfterEach, FunSuite}
import org.scalatest.Matchers._

class LibrarySpec extends FunSuite with BeforeAndAfterEach {
  val testBooks: List[Book] = List (
    Book("Lost Boy,The:A Foster Child's Search for the Love of a Family", "Pelzer, Dave", "dsrzkqjsp"),
    Book("Jamie's Ministry of Food:Anyone Can Learn to Cook in 24 Hours", "Oliver, Jamie", "foacwdyi"),
    Book("Encyclopedia", "Various", "ukahsds", true)
  )
  var library = new Library(testBooks)

  override def beforeEach(): Unit = {
    library = new Library(testBooks)
  }

  test("A list of books should be returned when entering a partial title") {
    library.getBookList("title", "Lost Boy") shouldBe List(Book("Lost Boy,The:A Foster Child's Search for the Love of a Family", "Pelzer, Dave", "dsrzkqjsp"))
  }

  test("A list of books should be returned when entering a partial author") {
    library.getBookList("author", "Oliver") shouldBe List(Book("Jamie's Ministry of Food:Anyone Can Learn to Cook in 24 Hours", "Oliver, Jamie", "foacwdyi"))
  }

  test("A list with only one book should be returned when entering an ISBN") {
    library.getBookList("ISBN", "ukahsds") shouldBe List(Book("Encyclopedia", "Various", "ukahsds", true))
  }

  test("Partial titles can be searched using searchTitle giving a boolean") {
    library.searchParameter("Harry", "Harry Potter") shouldBe true
  }

  test("If book loaned successfully loanBook returns true and onLoan parameter changes from true to false") {
    library.loanBook("dsrzkqjsp") shouldBe true
    library.loanBook("dsrzkqjsp") shouldBe false
  }

  test("Reference books cannot be loaned out") {
    library.loanBook("ukahsds") shouldBe false
  }

  test("A book cannot be returned if not on loan") {
    library.returnBook("foacwdyi") shouldBe false
  }

  test("A book can be returned once it's been loaned out") {
    library.loanBook("dsrzkqjsp") shouldBe true
    library.returnBook("dsrzkqjsp") shouldBe true
    library.getBookList("ISBN", "dsrzkqjsp") shouldBe List(Book("Lost Boy,The:A Foster Child's Search for the Love of a Family", "Pelzer, Dave", "dsrzkqjsp", false, false))
  }

}
