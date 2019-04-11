package com.company.library

class Library {
  var books = Books.all

  def getBookList(searchParameterType: String, searchString: String): List[Book] = {
    if (searchParameterType == "title"){
      titleLoop(searchString)
    } else if (searchParameterType == "author") {
      authorLoop(searchString)
    } else if (searchParameterType == "ISBN") {
      ISBNLoop(searchString)
    } else {
      List[Book]()
    }
  }

  def titleLoop(partialTitle: String): List[Book] = {
    var list = List[Book]()
    for (i <- 0 until books.size) {
      if (searchParameter(partialTitle, books(i).title)) {
        list = books(i) :: list
      }
    }
    list
  }

  def authorLoop(partialAuthor: String): List[Book] = {
    var list = List[Book]()
    for (i <- 0 until books.size) {
      if (searchParameter(partialAuthor, books(i).author)) {
        list = books(i) :: list
      }
    }
    list
  }

  def ISBNLoop(ISBN: String): List[Book] = {
    var book = List[Book]()
    for (i <- 0 until books.size) {
      if (ISBN == books(i).ISBN) {
        book = books(i) :: book
      }
    }
    book
  }

  def searchParameter(searchValue: String, parameterValue: String): Boolean = {
    parameterValue contains searchValue
  }

  def loanBook(ISBN: String): Boolean = {
    var loanSuccess = false
    for (i <- 0 until books.size) {
      val result: Boolean = ISBN == books(i).ISBN
      val onLoan: Boolean = books(i).onLoan
      val reference: Boolean = books(i).reference
      if (result && !onLoan && !reference) {
        loanSuccess = true
        val title = books(i).title
        val author = books(i).author
        books = books.patch(i, Seq(Book(title, author, ISBN, reference, true)), 1)
      }
    }
    loanSuccess
  }

}