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

  test("View list allows books to be returned in readable manner") {
    library.viewList("title", "of") shouldBe "1) Title: Jamie's Ministry of Food:Anyone Can Learn to Cook in 24 Hours, Author: Oliver, Jamie, ISBN: foacwdyi, Available: true\n2) Title: Lost Boy,The:A Foster Child's Search for the Love of a Family, Author: Pelzer, Dave, ISBN: dsrzkqjsp, Available: true\n"
  }

  test("View list notifies user if used incorrectly or no results") {
    library.viewList("tital", "of") shouldBe "Please enter either title, author or ISBN as a string for the first argument"
    library.viewList("title", "Obscure Title") shouldBe "No matching results"
  }

  test("View loaned shows list of loaned books in readable manner") {
    library.loanBook("dsrzkqjsp", "John Doe")
    library.viewLoaned shouldBe "1) Book(Lost Boy,The:A Foster Child's Search for the Love of a Family,Pelzer, Dave,dsrzkqjsp,false,true), Loanee: John Doe\n"
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

  test("If book loaned successfully loanBook returns true, if unsuccessful false") {
    library.loanBook("dsrzkqjsp", "name") shouldBe true
    library.loanBook("dsrzkqjsp", "name") shouldBe false
  }

  test("Book is added to a loanedBooks with loanee's name when loaned out") {
    library.loanBook("dsrzkqjsp", "name")
    library.loanedBooks shouldBe List(Loaned(Book("Lost Boy,The:A Foster Child's Search for the Love of a Family", "Pelzer, Dave", "dsrzkqjsp", false, true), "name"))
  }

  test("Reference books cannot be loaned out") {
    library.loanBook("ukahsds", "name") shouldBe false
  }

  test("A book cannot be returned if not on loan") {
    library.returnBook("foacwdyi") shouldBe false
  }

  test("A book can be returned once it's been loaned out") {
    library.loanBook("dsrzkqjsp", "name") shouldBe true
    library.returnBook("dsrzkqjsp") shouldBe true
    library.getBookList("ISBN", "dsrzkqjsp") shouldBe List(Book("Lost Boy,The:A Foster Child's Search for the Love of a Family", "Pelzer, Dave", "dsrzkqjsp", false, false))
  }

  test("Once a book is returned it should be removed from the loanedBooks list") {
    library.loanBook("dsrzkqjsp", "name")
    library.loanedBooks shouldBe List(Loaned(Book("Lost Boy,The:A Foster Child's Search for the Love of a Family","Pelzer, Dave","dsrzkqjsp",false,true),"name"))
    library.returnBook("dsrzkqjsp")
    library.loanedBooks shouldBe List()
  }

}
