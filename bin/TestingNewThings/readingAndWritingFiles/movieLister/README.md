# 🎬 Movie Lister 🎬

## 📖 Introduction
The **Movie Lister** program is designed to help you practice working with Java's file reading and writing methods. It provides an interactive way to manage a catalog of movies stored in `.txt` and `.bin` files.

## 🎯 Goal
The goal of this program is to allow users to interact with a menu that controls a catalog of movies. Users can create, modify, and view movies stored in files.

### 📝 Menu Options
The program will provide the following options in the menu:

1. **🎬 Initiate movie catalog control**  
   Start managing your movie catalog.
   
2. **➕ Add a new movie**  
   Add a new movie to the catalog.
   
3. **📜 List all the movies**  
   View all movies currently stored in the catalog.
   
4. **🔍 Search for a movie**  
   Find a movie by its title or other details.
   
5. **❌ Exit the program**  
   Close the program and exit.
   
---



## 📑UML Classes diagram:

                        ┌─────────────────────────────────────┐
                        │                 Movie               │
                        ├─────────────────────────────────────┤
                        │ -title: String                      │
                        ├─────────────────────────────────────┤
                        │ +Movie(title: String)               │
                        │ +getTitle(): String                 │
                        │ +setTitle(title: String): void      │
                        │ +toString(): String                 │
                        └─────────────────────────────────────┘

              ┌──────────────────────────────────────────────────────────┐
              │                          DataAccessible                  │
              ├──────────────────────────────────────────────────────────┤
              │ +fileExistenceCheck(resourceName: String): boolean       │
              │ +listMovies(resourceName: String): List<Movie>           │
              │ +writeMovie(movie: Movie, resourceName: String, append:  │
              │   boolean): void                                         │
              │ +searchMovies(resourceName: String, searchResource:      │
              │   String): String                                        │
              │ +createFile(resourceName: String): void                  │
              │ +deleteFile(resourceName: String): void                  │
              ├──────────────────────────────────────────────────────────┤
              │ Includes the necessary operations to execute in the file │
              └──────────────────────────────────────────────────────────┘

                ┌─────────────────────────────────────────────────────┐
                │                       DataAccessImpl                │
                ├─────────────────────────────────────────────────────┤
                │ +fileExistenceCheck(resourceName: String): boolean  │
                │ +listMovies(resourceName: String): List<Movie>      │
                │ +writeMovie(movie: Movie, resourceName: String,     │
                │   append: boolean): void                            │
                │ +searchMovies(resourceName: String, searchResource: │
                │   String): String                                   │
                │ +createFile(resourceName: String): void             │
                │ +deleteFile(resourceName: String): void             │
                ├─────────────────────────────────────────────────────┤
                │ Contains the implementations of the necessary       │
                │ operations for the application                      │
                └─────────────────────────────────────────────────────┘

              ┌──────────────────────────────────────────────────────────┐
              │                      ControllableMovie                   │
              ├──────────────────────────────────────────────────────────┤
              │ +addMovie(title: String): void                           │
              │ +list(): void                                            │
              │ +search(movieToSearch: String): void                     │
              │ +initiateNewMovieController(): void                      │
              └──────────────────────────────────────────────────────────┘

                ┌─────────────────────────────────────────────────────┐
                │                   MovieControlImpl                  │
                ├─────────────────────────────────────────────────────┤
                │ -data: DataAccessible                               │
                ├─────────────────────────────────────────────────────┤
                │ +MovieControlImpl()                                 │
                │ +addMovie(title: String): void                      │
                │ +list(): void                                       │
                │ +search(movieToSearch: String): void                │
                │ +initiateNewMovieController(): void                 │
                ├─────────────────────────────────────────────────────┤
                │ Implements the ControllableMovie interface          │
                └─────────────────────────────────────────────────────┘
