import java.io.IOException;
import java.util.ArrayList;
import java.util.Objects;

public class Main {
    public static void main(String[] args) throws IOException {
        // TODO --> complete main function
        runMenu();
    }
    public static void runMenu() throws IOException {
        ArrayList actorsList = new ArrayList<>();
        Movie movie = new Movie(new ArrayList<>() , "" , 0);
        String data = movie.getMovieData("joker");
        actorsList = movie.getActorListViaApi(data);
        for(Object i: actorsList)
            System.out.println(i);

    }
}