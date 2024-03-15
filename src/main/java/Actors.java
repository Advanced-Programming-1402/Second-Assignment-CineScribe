import org.json.JSONArray;
import org.json.JSONObject;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.URL;
import java.net.HttpURLConnection;
public class Actors {
    public static final String API_KEY = "2oc2yj5UHqESdhSIvfVrpA==kXY0Y8KYuwuPgvNz";   // TODO --> add your api key about Actors here
    String netWorth;
    Boolean isAlive;
    String gender;
    String nationality;
    String birthday;


    public Actors(String netWorth, boolean isAlive, String gender, String nationality, String birthday){
        //TODO --> (Write a proper constructor using the get_from_api functions)
        this.netWorth = netWorth;
        this.isAlive = isAlive;
        this.gender = gender;
        this.nationality = nationality;
        this.birthday = birthday;
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
                return response.toString();
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
        double result = 0.0;
        JSONArray array = new JSONArray(actorsInfoJson);
        JSONObject info = array.getJSONObject(0);
        result = info.getDouble("net_worth");
        return result;
    }

    public boolean isAlive(String actorsInfoJson){
        //TODO --> (If your chosen actor is alive it must return true otherwise it must return false)
        boolean statues = false;
        JSONArray array = new JSONArray(actorsInfoJson);
        JSONObject info = array.getJSONObject(0);
        statues = info.getBoolean("is_alive");
        return statues;
    }

    public String getDateOfDeathViaApi(String actorsInfoJson){
        //TODO --> (If your chosen actor is deceased it must return the date of death)  -->
        String date = "";
        boolean statues = false;
        JSONArray array = new JSONArray(actorsInfoJson);
        JSONObject info = array.getJSONObject(0);
        statues = info.getBoolean("is_alive");
        if (statues == false) {
            JSONObject Date = new JSONObject(actorsInfoJson);
            date = Date.getString("death");
        }
        else {
            date = "_";
        }
            return date;
    }
    public String getGender(String actorsInfoJson){
        String gender = null;
        JSONArray array = new JSONArray(actorsInfoJson);
        JSONObject info = array.getJSONObject(0);
        gender = info.getString("gender");
        return gender;
    }
    public String getNationality(String actorsInfoJson){
        String nationality = null;
        JSONArray array = new JSONArray(actorsInfoJson);
        JSONObject info = array.getJSONObject(0);
        nationality = info.getString("nationality");
        return nationality;
    }
    public String getBirthday(String actorsInfoJson){
        String birthday = null;
        JSONArray array = new JSONArray(actorsInfoJson);
        JSONObject info = array.getJSONObject(0);


        birthday = info.getString("birthday");
        return birthday;
    }
}