package com.company.library

class Library {

  def printTitles(books: List[String]): String = {
    var titles = ""
    for (i <- 0 to books.size - 1) {
      if (i == 0) {
        titles = books(i)
      } else {
        titles = titles + ", " + books(i)
      }
    }
    titles
  }

}
