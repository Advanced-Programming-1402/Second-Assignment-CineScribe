import org.json.JSONObject;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws IOException {
        // TODO --> complete main function
        runMenu();
    }
    public static void runMenu() throws IOException {
        while (true)
        {
            Scanner input = new Scanner(System.in);
            System.out.println("Hi, Welcome Movie and Actor database. In this program, you enter the name of the movie or actor and receive the information of them.");
            System.out.println("1. Movie");
            System.out.println("2. Actors");
            int choice = input.nextInt();
            switch (choice) {
                case 1:
                    Movie movie_object = new Movie(new ArrayList<>(), "", 0, "", "", "", "", "", "", "", "", "", "", "");
                    System.out.println("Enter name of Movie: ");
                    Scanner Input_Movie = new Scanner(System.in);
                    String FilmName = Input_Movie.nextLine();
                    String check = movie_object.getMovieData(FilmName);
                    while (check.equals("Please check movies name!"))
                    {
                        FilmName = input.next();
                        check = movie_object.getMovieData(FilmName);

                    }
                    System.out.println(FilmName);
                    System.out.println(movie_object.getYear(movie_object.getMovieData(FilmName)));
                    System.out.println(movie_object.getRatingViaApi(movie_object.getMovieData(FilmName)));
                    System.out.println(movie_object.getReleased(movie_object.getMovieData(FilmName)));
                    System.out.println(movie_object.getGenre(movie_object.getMovieData(FilmName)));
                    System.out.println(movie_object.getRuntime(movie_object.getMovieData(FilmName)));
                    System.out.println(movie_object.getDirector(movie_object.getMovieData(FilmName)));
                    System.out.println(movie_object.getAuthor(movie_object.getMovieData(FilmName)));
                    System.out.println(movie_object.getPlot(movie_object.getMovieData(FilmName)));
                    System.out.println(movie_object.getLanguage(movie_object.getMovieData(FilmName)));
                    System.out.println(movie_object.getCountry(movie_object.getMovieData(FilmName)));
                    System.out.println(movie_object.getType(movie_object.getMovieData(FilmName)));
                    System.out.println(movie_object.getActorListViaApi(movie_object.getMovieData(FilmName)));
                    System.out.println(movie_object.getImdbVotesViaApi(movie_object.getMovieData(FilmName)));
                    break;
                case 2:
                    Actors actors_object = new Actors(0.0, "", "", 0.0, false, "");
                    System.out.println("Enter name of Actor: ");
                    Scanner input_actor = new Scanner(System.in);
                    String ActorName = input_actor.next();
                    String Check = actors_object.getActorData(ActorName);
                    while (Check.equals("Please check actor name!"))
                    {
                        ActorName = input.next();
                        Check = actors_object.getActorData(ActorName);

                    }
                    System.out.println(ActorName);
                    System.out.println(actors_object.getNetWorthViaApi(actors_object.getActorData(ActorName)));
                    System.out.println(actors_object.getDataOfBirth(actors_object.getActorData(ActorName)));
                    System.out.println(actors_object.getGender(actors_object.getActorData(ActorName)));
                    System.out.println(actors_object.getHeight(actors_object.getActorData(ActorName)));
                    System.out.println(actors_object.isAlive(actors_object.getActorData(ActorName)));
                    System.out.println(actors_object.getDateOfDeathViaApi(actors_object.getActorData(ActorName)));
                    break;
                default:
                    System.out.println("Invalid choice. Please select a valid option!");
            }
        }

    }
}