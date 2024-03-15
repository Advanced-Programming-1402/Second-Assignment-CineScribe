import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.URL;
import java.net.HttpURLConnection;
import org.json.JSONObject;
public class Actors {
    public static final String API_KEY = "lx3V7SSX0UGbFy8DibPSfQ==fbNjG3un4zdTPqV3";
    double netWorth;
    String date_birth;
    String gender;
    double height;
    Boolean status;
    String date;

    public Actors(double netWorth, String date_birth, String gender, double height, boolean status, String date){
        this.netWorth = netWorth;
        this.date_birth = date_birth;
        this.gender = gender;
        this.height = height;
        this.status = status;
        this.date = date;
    }
    @SuppressWarnings({"deprecation"})
    /**
     * Retrieves data for the specified actor.
     * @param name for which Actor should be retrieved
     * @return a string representation of the Actors info or null if an error occurred
     */
    public String getActorData(String name) {
        try {
            URL url = new URL("https://api.api-ninjas.com/v1/celebrity?name="+
                    name.replace(" ", "+")+"&apikey="+API_KEY);
            HttpURLConnection connection = (HttpURLConnection) url.openConnection();
            connection.setRequestProperty("X-Api-Key", API_KEY);
            System.out.println(connection);
            if (connection.getResponseCode() == HttpURLConnection.HTTP_OK) {
                BufferedReader in = new BufferedReader(new InputStreamReader(connection.getInputStream()));
                String inputLine;
                StringBuilder response = new StringBuilder();

                while ((inputLine = in.readLine()) != null) {
                    response.append(inputLine);
                }

                in.close();
                return response.toString().substring(1, response.toString().length() - 1);
            } else {
                return "Error: " + connection.getResponseCode() + " " + connection.getResponseMessage();
            }
        } catch (IOException e) {
            e.printStackTrace();
            return null;
        }
    }
    public double getNetWorthViaApi(String actorsInfoJson){
        //TODO --> (This function must return the "NetWorth")
        double netWorth = 0.0;
        try {
            JSONObject netWorthObject = new JSONObject(actorsInfoJson);
            netWorth = netWorthObject.getDouble("net_worth");
            System.out.println("Net Worth: " + netWorth);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return netWorth;
    }

    public String getDataOfBirth(String actorsInfoJson)
    {
        String date_birth = "";
        try {
            JSONObject Date = new JSONObject(actorsInfoJson);
            if(Date.has("birthday"))
            {
                date_birth = Date.getString("birthday");
            }
        }
        catch (Exception e)
        {
            e.printStackTrace();
        }
        return "Birthday: " + date_birth;
    }
    public String getGender(String moviesInfoJson)
    {
        String gender = "";
        try
        {
            JSONObject Actors_Gender = new JSONObject(moviesInfoJson);
            if(Actors_Gender.has("genre"))
            {
                gender = Actors_Gender.getString("Gender");
            }
        }
        catch (Exception e)
        {
            e.printStackTrace();
        }
        return "Gender: " + gender;
    }

    public double getHeight(String actorsInfoJson)
    {
        double height = 0.0;
        try
        {
            JSONObject height_object = new JSONObject(actorsInfoJson);
            height = height_object.getDouble("height");
            System.out.println("Height_Of_Person: " + height);
        }
        catch (Exception e)
        {
            e.printStackTrace();
        }
        return height;
    }

    public boolean isAlive(String actorsInfoJson){
        boolean status = false;
        try {
            JSONObject live = new JSONObject(actorsInfoJson);
            status = live.getBoolean("is_alive");
            System.out.println("Is Alive: "+ status);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return status;
    }

    public String getDateOfDeathViaApi(String actorsInfoJson){
        //TODO --> (If your chosen actor is deceased it must return the date of death)  -->
        String date = "";
        try {
            JSONObject Date_Of_Death = new JSONObject(actorsInfoJson);
            if(Date_Of_Death.has("death"))
            {
                date = Date_Of_Death.getString("death");
                System.out.println("death: "+ date);
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
        return date;
    }


    }

