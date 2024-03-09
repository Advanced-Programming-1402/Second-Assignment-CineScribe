import java.io.IOException;
import java.util.ArrayList;
import java.util.Objects;
import java.util.Scanner;
public class Main {
    static ArrayList<Object> actorsList;
    static String rating;
    static String genre;
    static String about;
    static int ImdbVotes;
    static ArrayList<Object> occupation;
    static boolean exit = false;
    public static void main(String[] args) throws IOException {
        while(!exit) {
            runMenu();
        }
    }
    public static void runMenu() throws IOException {
        System.out.println("What do you want to search?");
        System.out.println("1.Movie\n2.Actors\n3.Exit");
        Scanner input = new Scanner(System.in);
        int user = input.nextInt();
        if(user == 1) {
            System.out.println("Please enter the movie you wanna search");
            String userInput = input.next();
            Movie movie = new Movie(new ArrayList<>(), "", 0, "", "");
            String data = movie.getMovieData(userInput);
            boolean loop = true;
            while(loop) {
                System.out.println("1.IMDB Rating\n2.Genre\n3.Actors\n4.IMDB Votes\n5.About Movie\n6.Exit");
                int in = input.nextInt();
                switch (in) {
                    case 1:
                        System.out.println(rating = movie.getRatingViaApi(data));
                        break;
                    case 2:
                        System.out.println(genre = movie.getGenreViaApi(data));
                        break;
                    case 3:
                        actorsList = movie.getActorListViaApi(data);
                        for (Object i : actorsList)
                            System.out.println(i);
                        break;
                    case 4:
                        System.out.println(ImdbVotes = movie.getImdbVotesViaApi(data));
                        break;
                    case 5:
                        System.out.println(about = movie.getAboutMovieViaApi(data));
                        break;
                    case 6:
                        loop = false;
                        break;
                }
                if(in != 6) {
                    System.out.println("Press Any Kay To GO Back...");
                    input.next();
                }
            }
        }
        if(user == 2){
            System.out.println("Please enter the actor you wanna search");
            String userIn = input.next();
            Actors actor = new Actors("", true, "", null, 0, "", 0);
            String data = actor.getActorData(userIn);
            boolean loop = true;
            while(loop) {
                System.out.println("1.Net worth\n2.Nationality\n3.Occupation\n4.Birthday\n5.Height\n6.Age\n7.Living situation\n8.Exit");
                int in = input.nextInt();
                switch (in) {
                    case 1:
                        System.out.println(actor.getNetWorthViaApi(data));
                        break;
                    case 2:
                        System.out.println(actor.getNationalityViaApi(data));
                        break;
                    case 3:
                        occupation = actor.getOccupationViaApi(data);
                        for (Object i : occupation)
                            System.out.println(i);
                        break;
                    case 4:
                        System.out.println(actor.getBirthdayViaApi(data));
                        break;
                    case 5:
                        System.out.println(actor.getHeightViaApi(data));
                        break;
                    case 6:
                        System.out.println(actor.getAgeViaApi(data));
                        break;
                    case 7:
                        if(!actor.isAlive(data))
                            System.out.println("Deceased at " + actor.getDateOfDeathViaApi(data));
                        else
                            System.out.println("Alive");
                        break;
                    case 8:
                        loop = false;
                        break;
                }
                if(in != 8) {
                    System.out.println("Press Any Kay To GO Back...");
                    input.next();
                }
            }
        }
        if(user == 3)
            exit = true;

    }

}
