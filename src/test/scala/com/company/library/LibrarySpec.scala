package com.company.library

import org.scalatest.FunSuite
import org.scalatest.Matchers._

class LibrarySpec extends FunSuite {

  test("A list of books should be returned when entering a partial title") {
    val library = new Library
    library.getBookList("title", "Half-blood", Books.all) shouldBe List(Book("Harry Potter and the Half-blood Prince", "Rowling, J.K.", "ajaoshq"), Book("Harry Potter and the Half-blood Prince:Children's Edition", "Rowling, J.K.", "gdjvia"))
  }

  test("A list of books should be returned when entering a partial author") {
    val library = new Library
    library.getBookList("author", "Hislop", Books.all) shouldBe List(Book("Island,The" ,"Hislop, Victoria", "tqtlsxmyv"))
  }

  test("A list with only one book should be returned when entering an ISBN") {
    val library = new Library
    library.getBookList("ISBN", "lgzf", Books.all) shouldBe List(Book("Northern Lights:His Dark Materials S.", "Pullman, Philip", "lgzf"))
  }

  test("Partial titles can be searched using searchTitle giving a boolean") {
    val library = new Library
    library.searchTitle("Harry", "Harry Potter") shouldBe true
  }

}
