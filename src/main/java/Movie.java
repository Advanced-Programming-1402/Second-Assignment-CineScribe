import org.json.JSONArray;
import org.json.JSONObject;

import java.io.IOException;
import java.io.InputStreamReader;
import java.net.URL;
import java.net.URLConnection;
import java.io.BufferedReader;
import java.util.ArrayList;
import java.util.List;

public class Movie {
    public static final String API_KEY = "4cc68bea";   // TODO --> add your api key about Movie here
    int ImdbVotes;
    ArrayList<String> actorsList;
    String rating;
    String director;
    String gener;
    String writer;
    String language;
    String responsive;

    public Movie(ArrayList<String> actorsList, String rating, int ImdbVotes, String director, String gener, String writer, String language, String responsive){
        //TODO --> (Write a proper constructor using the get_from_api functions)
        this.actorsList = actorsList;
        this.rating = rating;
        this.ImdbVotes = ImdbVotes;
        this.director = director;
        this.gener = gener;
        this.writer = writer;
        this.language = language;
        this.responsive = responsive;
    }

    @SuppressWarnings("deprecation")
    /**
     * Retrieves data for the specified movie.
     *
     * @param title the name of the title for which MovieData should be retrieved
     * @return a string representation of the MovieData, or null if an error occurred
     */

    public String getMovieData(String title) throws IOException {
        URL url = new URL("https://www.omdbapi.com/?t="+title+"&apikey="+ API_KEY);
        URLConnection Url = url.openConnection();
        Url.setRequestProperty("Authorization", "Key" + API_KEY);
        BufferedReader reader = new BufferedReader(new InputStreamReader(Url.getInputStream()));
        String line;
        StringBuilder stringBuilder = new StringBuilder();
        while ((line = reader.readLine())!=null) {
            stringBuilder.append(line);
        }
        reader.close();
        //handle an error if the chosen movie is not found
        return stringBuilder.toString();
    }
    public int getImdbVotesViaApi(String moviesInfoJson){
        //TODO --> (This function must change and return the "ImdbVotes" as an Integer)
        // NOTICE :: you are not permitted to convert this function to return a String instead of an int !!!
        int ImdbVotes = 0;
        JSONObject info = new JSONObject(moviesInfoJson);
        ImdbVotes = Integer.parseInt(info.getString("imdbVotes").replace(",",""));

        return ImdbVotes;
    }

    public String getRatingViaApi(String moviesInfoJson){
        //TODO --> (This function must return the rating in the "Ratings" part
        // where the source is "Internet Movie Database")  -->
        //String rating = null;
        JSONObject info = new JSONObject(moviesInfoJson);
        JSONArray ratings = info.getJSONArray("Ratings");
        JSONObject rate = ratings.getJSONObject(0);
        String value = rate.getString("Value");

        return value;
    }

    public ArrayList<String> getActorListViaApi(String movieInfoJson){
        //TODO --> (This function must return the "Actors" in actorsList)
        JSONObject info = new JSONObject(movieInfoJson);
        //List<String> actors = new ArrayList<>();
        String actors = info.getString("Actors");
        String[] arraylist = actors.split(", ");
        for (String i : arraylist) {
            actorsList.add(i);
        }

        return actorsList;
    }
    public String getDirector(String movieInfoJson){
        String director = null;
        JSONObject info = new JSONObject(movieInfoJson);
        director = info.getString("Director");
        return director;
    }
    public String getGener(String movieInfoJson){
        String gener = null;
        JSONObject info = new JSONObject(movieInfoJson);
        gener = info.getString("Genre");
        return gener;
    }
    public String getWriter(String movieInfoJson){
        String writer = null;
        JSONObject info = new JSONObject(movieInfoJson);
        writer = info.getString("Writer");
        return writer;
    }
    public String getLanguage(String movieInfoJson){
        String language = null;
        JSONObject info = new JSONObject(movieInfoJson);
        language = info.getString("Language");
         return language;
    }
    public String getResponsive(String movieInfoJson){
        String responsive = null;
        JSONObject info = new JSONObject(movieInfoJson);
        responsive = info.getString("Responsive");
        return responsive;
    }
}