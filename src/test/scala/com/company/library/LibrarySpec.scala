package com.company.library

import org.scalatest.FunSuite
import org.scalatest.Matchers._

class LibrarySpec extends FunSuite {
  val library = new Library

  test("A list of books should be returned when entering a partial title") {
    library.getBookList("title", "Half-blood") shouldBe List(Book("Harry Potter and the Half-blood Prince", "Rowling, J.K.", "ajaoshq"), Book("Harry Potter and the Half-blood Prince:Children's Edition", "Rowling, J.K.", "gdjvia"))
  }

  test("A list of books should be returned when entering a partial author") {
    library.getBookList("author", "Hislop") shouldBe List(Book("Island,The" ,"Hislop, Victoria", "tqtlsxmyv"))
  }

  test("A list with only one book should be returned when entering an ISBN") {
    library.getBookList("ISBN", "lgzf") shouldBe List(Book("Northern Lights:His Dark Materials S.", "Pullman, Philip", "lgzf"))
  }

  test("Partial titles can be searched using searchTitle giving a boolean") {
    library.searchParameter("Harry", "Harry Potter") shouldBe true
  }

  test("If book loaned successfully loanBook returns true and onLoan parameter changes from true to false") {
    library.getBookList("ISBN", "nxqryzuu") shouldBe List(Book("House at Riverton,The", "Morton, Kate", "nxqryzuu", false))
    library.loanBook("nxqryzuu") shouldBe true
    library.getBookList("ISBN", "nxqryzuu") shouldBe List(Book("House at Riverton,The", "Morton, Kate", "nxqryzuu", true))
  }

}
