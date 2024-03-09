import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.URL;
import java.net.HttpURLConnection;
import java.util.ArrayList;

import org.json.JSONArray;
import org.json.JSONObject;
public class Actors {
    public static final String API_KEY = "3E/O/92DfeyQvzt20ijofw==fg6Q4oEcmC35fZFD  ";
    String netWorth;
    Boolean isAlive;
    ArrayList<Object> occupation;

    public Actors(String netWorth, boolean isAlive){
        //TODO --> (Write a proper constructor using the get_from_api functions)
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
                String jsonString = response.toString();
                jsonString = jsonString.substring(1,jsonString.length() - 1);
                return jsonString;
            } else {
                return "Error: " + connection.getResponseCode() + " " + connection.getResponseMessage();
            }
        } catch (IOException e) {
            e.printStackTrace();
            return null;
        }
    }
    public double getNetWorthViaApi(String actorsInfoJson){
        JSONObject netWorth = new JSONObject(actorsInfoJson);
        return netWorth.getDouble("net_worth");
    }
    public String getNationalityViaApi(String actorsInfoJson){
        JSONObject nationality = new JSONObject(actorsInfoJson);
        return nationality.getString("nationality");
    }
    public ArrayList<Object> getOccupationViaApi(String actorsInfoJson){
        JSONObject occupy = new JSONObject(actorsInfoJson);
        String[] str = occupy.getString("occupation").split("[,]");
        for(Object i: str)
            occupation.add(i);
        return occupation;
    }
    public double getHeightViaApi(String actorsInfoJson){
        JSONObject height = new JSONObject(actorsInfoJson);
        return height.getDouble("height");
    }
    public String getBirthdayViaApi(String actorsInfoJson){
        JSONObject birthday = new JSONObject(actorsInfoJson);
        return birthday.getString("birthday");
    }
    public int getAgeViaApi(String actorsInfoJson){
        JSONObject age = new JSONObject(actorsInfoJson);
        return age.getInt("age");
    }
    public boolean isAlive(String actorsInfoJson){
        JSONObject isAlive = new JSONObject(actorsInfoJson);
        return isAlive.getBoolean("is_alive");
    }

    public String getDateOfDeathViaApi(String actorsInfoJson){
        JSONObject dateOfDeath = new JSONObject(actorsInfoJson);
        return dateOfDeath.getString("death");
    }

}