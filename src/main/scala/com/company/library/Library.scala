package com.company.library

class Library {

  def getBooksFromPartialTitle(partialTitle: String, books: List[Book]): List[Book] = {
    var list = List[Book]()
    for (i <- 0 to books.size - 1) {
      if (searchTitle(partialTitle, books(i).title)) {
        list = books(i) :: list
      }
    }
    list
  }

  def searchTitle(search: String, title: String): Boolean = {
    title contains search
  }

}
