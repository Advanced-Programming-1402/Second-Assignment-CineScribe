import org.json.JSONObject;

import java.util.ArrayList;
import java.util.Scanner;
public class Main {
    public static void main(String[] args) {
        runMenu();
    }
    public static void runMenu() {
        Scanner in = new Scanner(System.in);
        System.out.print("1. Movie\n2. Actor\n3. Exit\nPlease Select an Option: ");
        String option = in.nextLine();
        if(option.equals("1")){
            System.out.print("Enter the Name of Movie: ");
            String title = in.nextLine();
            Movie movie = new Movie(new ArrayList<>(),"",0);
            String movieInfoJson = movie.getMovieData(title);
            JSONObject json = new JSONObject(movieInfoJson);
            System.out.println(json.toString(4).replace("\"" , "") + "\n**********************************************************");
            runMenu();
        }
        else if(option.equals("2")){
            System.out.print("Enter the Name of Actor: ");
            String name = in.nextLine();
            Actors actors = new Actors("", false);
            String actorsInfoJson = actors.getActorData(name);
            JSONObject json = new JSONObject(actorsInfoJson);
            System.out.println(json.toString(4).replace("\"" , "") + "\n**********************************************************");
            runMenu();
        }
        else{
            System.out.println("Bye^-^");
        }
    }
}