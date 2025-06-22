# Library_Book_Tracker

A simple **console-based Library Management System** developed using **Java**. It allows users to add, view, and delete books. The system uses **ArrayList** for storage and saves book records persistently using a **text file** (`books.txt`).

## Features
- Add new books (title and author)
- View list of all books
- Delete books by number

## Technologies Used
- Java (JDK 8+)
- ArrayList
- File I/O (`Scanner`, `PrintWriter`, `File`)
- Command-Line Interface (CLI)

## Project Structure
```
LibraryManagement.java
books.txt  ← created at runtime to store book data
```

## Data Format
The program saves book data in a file named `books.txt` in the following format:
```
Book Title;Author Name
```
Example:
```
Wings of Fire;A.P.J Abdul Kalam
```
