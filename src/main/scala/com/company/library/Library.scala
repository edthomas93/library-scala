package com.company.library

class Library {

  def getBookList(searchParameterType: String, searchString: String, books: List[Book]): List[Book] = {
    if (searchParameterType == "title"){
      titleLoop(searchString, books)
    } else if (searchParameterType == "author") {
      authorLoop(searchString, books)
    } else if (searchParameterType == "ISBN") {
      ISBNLoop(searchString, books)
    } else {
      List[Book]()
    }
  }

  def titleLoop(partialTitle: String, books: List[Book]): List[Book] = {
    var list = List[Book]()
    for (i <- 0 until books.size) {
      if (searchTitle(partialTitle, books(i).title)) {
        list = books(i) :: list
      }
    }
    list
  }

  def authorLoop(partialAuthor: String, books: List[Book]): List[Book] = {
    var list = List[Book]()
    for (i <- 0 until books.size) {
      if (searchTitle(partialAuthor, books(i).author)) {
        list = books(i) :: list
      }
    }
    list
  }

  def ISBNLoop(ISBN: String, books: List[Book]): List[Book] = {
    var book = List[Book]()
    for (i <- 0 until books.size) {
      if (searchTitle(ISBN, books(i).ISBN)) {
        book = books(i) :: book
      }
    }
    book
  }

  def searchTitle(search: String, title: String): Boolean = {
    title contains search
  }

}