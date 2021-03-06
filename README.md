# Gone With The Wind

## How to use

#### 1. Open your terminal and clone the repository:
`git clone git@github.com:edthomas93/library-scala.git`

#### 2. Access the root of the project in the command line and run tests by typing:
`sbt test`

#### 3. Use the code to have your own virtual library by typing:
`sbt console`

#### 4. Within the console create a new instance of a library by typing:
`val library = new com.company.library.Library`

#### 5. You can then search this library by author, title or ISBN which returns a list of books:
To search by title - `library.viewList("title", "Harry Potter")`

To search by author - `library.viewList("author", "Hislop")`

To search by ISBN - `library.viewList("ISBN", "nxqryzuu")`

#### 6. To loan out a book use the ISBN as the first argument (found from the viewList function) and enter the name of the loanee for the second argument. This will return true if the loan is successful:
`library.loanBook("nxqryzuu", "John Doe")`

#### 7. See all loaned out books using viewLoaned:
`library.viewLoaned`

#### 8. Return books using the ISBN (will return true if successful):
`library.returnBook("nxqryzuu")`

#### 9. When finished, exit SBT by typing:
`:quit`

## Task

You have a library of books and are offering them to the world - you are lending so many books now that it is becoming hard to keep track of what you have.  You decided to use your programming fu to build an application which can keep track of them for you.

## Completed User Stories

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

---

## User stories in progress


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


