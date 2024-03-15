import org.json.JSONArray;
import org.json.JSONObject;

import java.io.IOException;
import java.io.InputStreamReader;
import java.net.URL;
import java.net.URLConnection;
import java.io.BufferedReader;
import java.util.ArrayList;
public class Movie {
    public static final String API_KEY = "4cc68bea";   // TODO --> add your api key about Movie here
    int ImdbVotes;
    ArrayList<String> actorsList;
    String rating;
    String Year;
    String Released;
    String genre;
    String Runtime;
    String Director;
    String name;
    String Plot;
    String language;
    String country;
    String Type;
    String Actor;



    public Movie(ArrayList<String> actorsList, String rating, int ImdbVotes, String Year, String Released, String genre, String Runtime, String Director, String name, String Plot, String language, String country, String Type, String Actor){
        this.actorsList = actorsList;
        this.ImdbVotes = ImdbVotes;
        this.rating = rating;
        this.Year = Year;
        this.Released = Released;
        this.genre = genre;
        this.Runtime = Runtime;
        this.Director = Director;
        this.name = name;
        this.Plot = Plot;
        this.language = language;
        this.country = country;
        this.Type = Type;
        this.Actor = Actor;
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
        Url.setRequestProperty("Authorization", "Key" + "4cc68bea1");
        BufferedReader reader = new BufferedReader(new InputStreamReader(Url.getInputStream()));
        String line;
        StringBuilder stringBuilder = new StringBuilder();
        while ((line = reader.readLine())!=null) {
            stringBuilder.append(line);
        }
        reader.close();
        String Error = stringBuilder.toString();
        if(Error.substring(Error.length() - 27).equals("\"Error\":\"Movie not found\""))
        {
            return "Please check movies name!";
        }
        return stringBuilder.toString();
    }
    public int getImdbVotesViaApi(String moviesInfoJson){
        //TODO --> (This function must change and return the "ImdbVotes" as an Integer)
        //ImdbVotes = Imdb_Votes.getInt("imdbVotes");
        // NOTICE :: you are not permitted to convert this function to return a String instead of an int !!!
        JSONObject Imdb_Votes = new JSONObject(moviesInfoJson);
        int ImdbVotes = Integer.parseInt(Imdb_Votes.getString("imdbVotes").replace(",", ""));
        return ImdbVotes;
    }

    public String getRatingViaApi(String moviesInfoJson){
        JSONObject rate_object = new JSONObject(moviesInfoJson);
        JSONArray rate_array = rate_object.getJSONArray("Ratings");
        JSONObject rate = rate_array.getJSONObject(0);
        String rating = rate.getString("Value");
        return rating;
    }
    public String getYear(String moviesInfoJson)
    {
        String Year = "";
        try
        {
            JSONObject Date_Of_Birth = new JSONObject(moviesInfoJson);
            if(Date_Of_Birth.has("Year"))
            {
                Year = Date_Of_Birth.getString("Year");
                System.out.println("Year: " + Year);
            }
        }
        catch (Exception e)
        {
            e.printStackTrace();
        }
        return Year;
    }

    public String getReleased(String moviesInfoJson)
    {
        String Released = "";
        try
        {
            JSONObject Film_Released = new JSONObject(moviesInfoJson);
            if(Film_Released.has("Released"))
            {
                Released = Film_Released.getString("Released");
                System.out.println("Released: " + Released);
            }
        }
        catch (Exception e)
        {
            e.printStackTrace();
        }
        return Released;
    }

    public String getGenre(String moviesInfoJson)
    {
        String genre = "";
        try
        {
            JSONObject Film_Genre = new JSONObject(moviesInfoJson);
            if(Film_Genre.has("Genre"))
            {
                genre = Film_Genre.getString("Genre");
                System.out.println("Genre: " + genre);
            }
        }
        catch (Exception e)
        {
            e.printStackTrace();
        }
        return genre;
    }

    public String getRuntime(String moviesInfoJson)
    {
        String Runtime = "";
        try
        {
            JSONObject Film_Runtime = new JSONObject(moviesInfoJson);
            if(Film_Runtime.has("Runtime"))
            {
                Runtime = Film_Runtime.getString("Runtime");
                System.out.println("Runtime: " + Runtime);
            }
        }
        catch (Exception e)
        {
            e.printStackTrace();
        }
        return Runtime;
    }

    public String getDirector(String moviesInfoJson)
    {
        String Director = "";
        try
        {
            JSONObject Film_Director = new JSONObject(moviesInfoJson);
            if(Film_Director.has("Director"))
            {
                Director = Film_Director.getString("Director");
                System.out.println("Director: " + Director);
            }
        }
        catch (Exception e)
        {
            e.printStackTrace();
        }
        return Director;
    }

    public String getAuthor(String moviesInfoJson)
    {
        String name = "";
        try
        {
            JSONObject Film_Author = new JSONObject(moviesInfoJson);
            if(Film_Author.has("Writer"))
            {
                name = Film_Author.getString("Writer");
                System.out.println("Writer: " + name);
            }
        }
        catch (Exception e)
        {
            e.printStackTrace();
        }
        return name;
    }

    public String getPlot(String moviesInfoJson)
    {
        String Plot = "";
        try
        {
            JSONObject Film_Plot = new JSONObject(moviesInfoJson);
            if(Film_Plot.has("Plot"))
            {
                Plot = Film_Plot.getString("Plot");
                System.out.println("Plot: " + Plot);
            }
        }
        catch (Exception e)
        {
            e.printStackTrace();
        }
        return Plot;
    }

    public String getLanguage(String moviesInfoJson)
    {
        String language = "";
        try
        {
            JSONObject Film_Language = new JSONObject(moviesInfoJson);
            if(Film_Language.has("Language"))
            {
                language = Film_Language.getString("Language");
                System.out.println("Language: " + language);
            }
        }
        catch (Exception e)
        {
            e.printStackTrace();
        }
        return language;
    }

    public String getCountry(String moviesInfoJson)
    {
        String country = "";
        try
        {
            JSONObject Product_Of_The_country = new JSONObject(moviesInfoJson);
            if(Product_Of_The_country.has("Country"))
            {
                country = Product_Of_The_country.getString("Country");
                System.out.println("Country: " + country);
            }
        }
        catch (Exception e)
        {
            e.printStackTrace();
        }
        return country;
    }

    public String getType(String moviesInfoJson)
    {
        String Type = "";
        try
        {
            JSONObject Film_Type = new JSONObject(moviesInfoJson);
            if(Film_Type.has("Type"))
            {
                Type = Film_Type.getString("Type");
                System.out.println("Type: " + Type);
            }
        }
        catch (Exception e)
        {
            e.printStackTrace();
        }
        return Type;
    }

    public String getActorListViaApi(String movieInfoJson) {
        String Actor = "";
        JSONObject Film_Actor = new JSONObject(movieInfoJson);
        Actor = Film_Actor.getString("Actors");
        return "Actors:pro " + Actor;
    }
}






