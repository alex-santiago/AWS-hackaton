package com.hart.team.battleship;

import android.os.StrictMode;

import org.json.JSONObject;

import java.io.BufferedReader;
import java.io.DataOutputStream;
import java.io.InputStreamReader;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.Scanner;

/**
 * Created by Tiago on 2017-11-04.
 */

public class DataAccess {

    public static String GetScore(){
        return ExecuteGet("https://dgy5zknu6g.execute-api.us-east-1.amazonaws.com/prod/scores");
    }

    public static String ExecuteGet(String urlToRead) {
        StrictMode.ThreadPolicy policy = new StrictMode.ThreadPolicy.Builder().permitAll().build();
        StrictMode.setThreadPolicy(policy);
        try {
            StringBuilder result = new StringBuilder();
            URL url = new URL(urlToRead);
            HttpURLConnection connection = (HttpURLConnection) url.openConnection();
            connection.setRequestMethod("GET");
            connection.setDoOutput(true);

            Scanner scanner = new Scanner(url.openStream());
            String response = scanner.useDelimiter("\\Z").next();

            scanner.close();


            return response;
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }


}
