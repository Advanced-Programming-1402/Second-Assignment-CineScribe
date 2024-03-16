import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.URL;
import java.net.HttpURLConnection;
import org.json.JSONObject;
public class Actors {
    public static final String API_KEY = "DxPDkxjUL6bpYDurOQZwiw==1IjnRq8i7CSBVRPQ";
    String name;
    String birthday;
    double netWorth;
    boolean isAlive;

    public Actors(String name, boolean isAlive){

    }
    @SuppressWarnings({"deprecation"})
    /**
     * Retrieves data for the specified actor.
     * @param name for which Actor should be retrieved
     * @return a string representation of the Actors info or null if an error occurred
     */
    public String getActorData(String name) {
        try {
            URL url = new URL("https://api.api-ninjas.com/v1/celebrity?name="+ name.replace(" ", "+"));
            HttpURLConnection connection = (HttpURLConnection) url.openConnection();
            connection.setRequestProperty("X-Api-Key", API_KEY);
            if (connection.getResponseCode() == HttpURLConnection.HTTP_OK) {
                BufferedReader in = new BufferedReader(new InputStreamReader(connection.getInputStream()));
                String inputLine;
                StringBuilder response = new StringBuilder();
                while ((inputLine = in.readLine()) != null) {
                    response.append(inputLine);
                }

                in.close();
                String result = response.toString();
                return result.substring(1 ,result.length() - 1);
            } else {
                return "Error: " + connection.getResponseCode() + " " + connection.getResponseMessage();
            }
        } catch (IOException e) {
            e.printStackTrace();
            return null;
        }
    }
    public double getNetWorthViaApi(String actorsInfoJson){
        JSONObject jsonObject = new JSONObject(actorsInfoJson);
        double result = 0.0;
        result = jsonObject.getDouble("net_worth");
        return result;
    }

    public static boolean isAlive(String actorsInfoJson){
        boolean statues = false;
        JSONObject jsonObject = new JSONObject(actorsInfoJson);
        statues = jsonObject.getBoolean("is_alive");
        return statues;
    }

    public String getDateOfDeathViaApi(String actorsInfoJson){
        String date = "";
        JSONObject jsonObject = new JSONObject(actorsInfoJson);
        date = jsonObject.getString("death");
        return date;
    }


}