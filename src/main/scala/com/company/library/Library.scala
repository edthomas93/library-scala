package com.company.library

class Library(var books: List[Book] = Books.all) {

  var loanedBooks: List[Loaned] = Books.loaned

  def viewList(searchParameter: String, searchString: String): String = {
    if (searchParameter != "title") if (searchParameter != "author") if (searchParameter != "ISBN") {
      throw new Exception("Please enter either title, author or ISBN as a string for the first argument")
    }
    var prettyList = ""
    val list = getBookList(searchParameter, searchString)
    for (i <- list.indices) {
      prettyList += (i + 1) + ") Title: " + list(i).title + ", Author: " + list(i).author + ", ISBN: " + list(i).ISBN + ", Available: " + !list(i).onLoan + "\n"
    }
    if (prettyList == "") {
      throw new Exception ("No matching results")
    }
    prettyList
  }

  def viewLoaned: String = {
    var prettyList = ""
    for (i <- loanedBooks.indices) {
      prettyList += (i + 1) + ") " + loanedBooks(i).book + ", Loanee: " + loanedBooks(i).loanee + "\n"
    }
    prettyList
  }

  def getBookList(searchParameterType: String, searchString: String): List[Book] = {
    if (searchParameterType == "title") titleLoop(searchString)
    else if (searchParameterType == "author") authorLoop(searchString)
    else if (searchParameterType == "ISBN") ISBNLoop(searchString)
    else List[Book]()
  }

  def titleLoop(partialTitle: String): List[Book] = {
    var list = List[Book]()
    for (i <- books.indices) {
      if (searchParameter(partialTitle, books(i).title)) list = books(i) :: list
    }
    list
  }

  def authorLoop(partialAuthor: String): List[Book] = {
    var list = List[Book]()
    for (i <- books.indices) {
      if (searchParameter(partialAuthor, books(i).author)) list = books(i) :: list
    }
    list
  }

  def ISBNLoop(ISBN: String): List[Book] = {
    var book = List[Book]()
    for (i <- books.indices) {
      if (ISBN == books(i).ISBN) book = books(i) :: book
    }
    book
  }

  def searchParameter(searchValue: String, parameterValue: String): Boolean = {
    parameterValue contains searchValue
  }

  def loanBook(ISBN: String, loanee: String): Boolean = {
    var loanSuccess = false
    for (i <- books.indices) {
      val result: Boolean = ISBN == books(i).ISBN
      val onLoan: Boolean = books(i).onLoan
      val reference: Boolean = books(i).reference
      if (result && !onLoan && !reference) {
        loanSuccess = true
        val loanedBook = Book(books(i).title, books(i).author, ISBN, reference, true)
        books = books.patch(i, Seq(loanedBook), 1)
        loanedBooks = Loaned(loanedBook, loanee) :: loanedBooks
      }
    }
    loanSuccess
  }

  def returnBook(ISBN: String): Boolean = {
    var returnSuccess = false
    for (i <- books.indices) {
      val result: Boolean = ISBN == books(i).ISBN
      val onLoan: Boolean = books(i).onLoan
      if (result && onLoan) {
        returnSuccess = true
        val returnedBook = Book(books(i).title, books(i).author, ISBN, books(i).reference)
        books = books.patch(i, Seq(returnedBook), 1)
      }
    }
    if(returnSuccess) {
      for (i <- loanedBooks.indices) {
        if(ISBN == loanedBooks(i).book.ISBN) {
          loanedBooks = loanedBooks.patch(loanedBooks.indexOf(i), List(), 1)
        }
      }
    }
    returnSuccess
  }

}