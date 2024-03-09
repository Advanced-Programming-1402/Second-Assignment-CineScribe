import java.io.IOException;
import java.io.InputStreamReader;
import java.net.URL;
import java.net.URLConnection;
import java.io.BufferedReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Objects;

import org.json.JSONArray;
import org.json.JSONObject;
public class Movie {
    public static final String API_KEY = "8f7f14d3";   // TODO --> add your api key about Movie here
    int ImdbVotes;
    ArrayList<Object> actorsList;
    String rating;

    public Movie(ArrayList<Object> actorsList, String rating, int ImdbVotes){
        this.actorsList = actorsList;
        this.ImdbVotes = ImdbVotes;
        this.rating = rating;
    }

    @SuppressWarnings("deprecation")
    /**
     * Retrieves data for the specified movie.
     *
     * @param title the name of the title for which MovieData should be retrieved
     * @return a string representation of the MovieData, or null if an error occurred
     */

    public String getMovieData(String title) throws IOException {
        URL url = new URL("https://www.omdbapi.com/?t="+title.replace(" ", "+")+"&apikey="+API_KEY);
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
        JSONObject imdb = new JSONObject(moviesInfoJson);
        String str =  imdb.getString("imdbVotes");
        str = str.replace(",", "");
        return Integer.parseInt(str);
    }

    public String getRatingViaApi(String moviesInfoJson){
        JSONObject imdb = new JSONObject(moviesInfoJson);
        return imdb.getString("imdbRating") + "/10";
    }

    public ArrayList<Object> getActorListViaApi(String movieInfoJson){
        JSONObject imdb = new JSONObject(movieInfoJson);
        String []str = imdb.getString("Actors").split("[,]");
        for(String i: str)
            actorsList.add(i);
        return actorsList;
    }
}