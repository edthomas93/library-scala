package com.company.library

import org.scalatest.FunSuite
import org.scalatest.Matchers._

class LibrarySpec extends FunSuite {

  test("printTitles returns a string of titles") {
    val library = new Library
    val list: List[String] = List("Twilight", "Eclipse", "Atonement")
    library.printTitles(list) shouldBe "Twilight, Eclipse, Atonement"
  }

}
