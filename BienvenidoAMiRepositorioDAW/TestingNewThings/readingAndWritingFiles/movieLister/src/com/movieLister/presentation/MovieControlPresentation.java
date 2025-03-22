package movieLister.src.com.movieLister.presentation;

import java.util.InputMismatchException;
import java.util.Scanner;
import movieLister.src.com.movieLister.service.ControllableMovie;
import movieLister.src.com.movieLister.service.MovieControlImpl;

public class MovieControlPresentation {
   
    public static void main(String[] args) {
        // Create a new movie controller
        ControllableMovie controller = new MovieControlImpl();
        // Create a scanner for user input
        Scanner user = new Scanner(System.in);
    
        int option = 0;

        // Print welcome message
        System.out.println("\n" +
        "╔╦╦╦╦╦╦╦╦╦╦╦╦╦╦╦╦╦╦╦╦╦╦╦╦╦╦╦╦╦╦╦╦╦╦╦╦╦╦╦╦╦╦╦╦╦╦╦╦╦╦╦╦╦╦╦╦╦╦╦╦╦╦╦╦╦╦╦╦╦╦╦╦╦╦╦╦╦╦╗"+"\n"+
        "╠╬╩╩╩╩╩╩╩╩╩╩╩╩╩╩╩╩╩╩╩╩╩╩╩╩╩╩╩╩╩╩╩╩╩╩╩╩╩╩╩╩╩╩╩╩╩╩╩╩╩╩╩╩╩╩╩╩╩╩╩╩╩╩╩╩╩╩╩╩╩╩╩╩╩╩╩╩╬╣"+"\n"+
        "╠╣                                                                            ╠╣"+"\n"+
        "╠╣                                                                            ╠╣"+"\n"+
        "╠╣                                                                            ╠╣"+"\n"+
        "╠╣       __  ___               _           __     _        __                 ╠╣"+"\n"+
        "╠╣      /  |/  /_____  _   __ (_)____     / /    (_)_____ / /_ ____ _____     ╠╣"+"\n"+
        "╠╣     / /|_/ // __  /| | / // // __/    / /    / // ___// __// __// ___/     ╠╣"+"\n"+
        "╠╣    / /  / // /_/ / | |/ // // __/    / /___ / /(__  )/ /_ / __// /         ╠╣"+"\n"+
        "╠╣   /_/  /_//_____/  |___//_//___/    /_____//_//____//___//___//_/          ╠╣"+"\n"+
        "╠╣                                                                            ╠╣"+"\n"+
        "╠╣                                                                            ╠╣"+"\n"+
        "╠╣                                                                            ╠╣"+"\n"+
        "╠╣                                                                            ╠╣"+"\n"+
        "╠╬╦╦╦╦╦╦╦╦╦╦╦╦╦╦╦╦╦╦╦╦╦╦╦╦╦╦╦╦╦╦╦╦╦╦╦╦╦╦╦╦╦╦╦╦╦╦╦╦╦╦╦╦╦╦╦╦╦╦╦╦╦╦╦╦╦╦╦╦╦╦╦╦╦╦╦╦╬╣"+"\n"+
        "╚╩╩╩╩╩╩╩╩╩╩╩╩╩╩╩╩╩╩╩╩╩╩╩╩╩╩╩╩╩╩╩╩╩╩╩╩╩╩╩╩╩╩╩╩╩╩╩╩╩╩╩╩╩╩╩╩╩╩╩╩╩╩╩╩╩╩╩╩╩╩╩╩╩╩╩╩╩╩╝"+"\n"
        );

        System.out.println(
            "Welcome to Movie Lister!"+"\n"+
            "These are the current features of the program: "+"\n"+"\n");

        do {
            // Print menu options
            System.out.println("\n"+
            "1. Initiate a new movie controller"+"\n"+
            "2. Add a movie"+"\n"+
            "3. Show all the movies listed"+"\n"+
            "4. Search for a movie"+"\n"+
            "5. Exit the progam"+"\n"+"\n"
            );

            System.out.print("Select an option: ");
           
            try {
                // Read user input
                option = user.nextInt();
                user.nextLine();
                System.out.println();

                switch (option) {
                    case 1:
                        // Initiate a new movie controller
                        controller.initiateNewMovieController();
                        break;

                    case 2:
                        // Add a new movie
                        System.out.print("\n"+"Introduce the title of the movie: ");
                        String title = user.nextLine();

                        controller.addMovie(title);
                        System.out.println("Movie has been added succesfully");
                        break;

                    case 3:
                        // List all movies
                        controller.list();
                        break;

                    case 4:
                        // Search for a movie
                        System.out.print("Search:    ");
                        String movieToSearch = user.nextLine();
                        controller.search(movieToSearch);
                        break;

                    case 5:
                        // Exit the program
                        System.out.println(
                            "Thanks for using Movie Lister!"+"\n"+
                            "Closing the program..."+"\n");
                        break;

                    default:
                        // Invalid option
                        System.out.println("\n"+"This option doesn't exists please try again with one of the mentioned above"+"\n");
                        break;
                }
            } catch (InputMismatchException exception) {
                // Handle invalid input
                System.out.println("\n"+"Please introduce a number"+"\n");
                user.nextLine();
            }
        } while (option != 5);
        user.close();
    }
}
