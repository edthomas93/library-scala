# Gone With The Wind

## How to use

#### 1. Open your terminal and clone the repository:
`git clone git@github.com:edthomas93/library-scala.git`

#### 2. Access the root of the project in the command line and type:
`sbt console`

#### 3. Within the console create a new instance of a library by typing:
`val library = new com.company.library.Library()`

#### 4. You can then search this library by author, title or ISBN which returns a list of books:
To search by title - `library.getBookList("title", "Harry Potter", Books.all)`
To search by author - `library.getBookList("author", "Hislop", Books.all)`
To search by ISBN - `library.getBookList("ISBN", "lgzf", Books.all)`

#### 5. When finished, exit SBT by typing:
`:quit`

## Instructions

You have a library of books and are offering them to the world - you are lending so many books now that it is becoming hard to keep track of what you have.  You decided to use your programming fu to build an application which can keep track of them for you.


## Requirements

* implements the user stories listed below (optional ones not required)
* compiles
* has tests
* frequent commits

## User Stories

```text
As a visitor,
So that I can find books I am looking for,
I need to be able search books by partial title
```

```text
As a visitor,
So that I can find books I am looking for,
I need to be able search books by partial author
```

```text
As a visitor,
So that I can find books I am looking for,
I need to be able to search by full ISBN
```

```text
As a librarian,
So that I can help my community,
I need to be able to lend books to visitors
```

```text
As a librarian,
So that I can protect my expensive books,
I don't want to lend reference books
```

```text
As a librarian,
So that I can manage my library correctly,
I need to know whether a book is available or on loan
```

---

## Optional extra stories

```text
As a librarian,
So that I can update my stock levels,
I need to be able update the library when a book is returned 
```

```text
As a librarian,
So that I can manage my library correctly,
I need to know who has a book that is on loan
```

```text
As a librarian,
So that I can manage my library correctly,
I need to know which books are late
```

```text
As a librarian,
So that I can manage my library correctly,
I need to know who has a book that is late
```

```text
As a librarian,
So that I can manage my library correctly,
I want to fine users who are late returning their books

```


