package org.example;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.ProtocolException;
import java.net.URL;
import com.google.gson.Gson;


public class Main {
    public static void main(String[] args) {
        String apiUrl = "https://api.nytimes.com/svc/search/v2/articlesearch.json?q=election&api-key=5TMCX2qSvFGtY00sNkxjAsBSjfUUvUBS";
        System.out.println("Hello world!");
        newsMain newsMain = new newsMain();

        try {
            URL url = new URL(apiUrl);
            HttpURLConnection conn = (HttpURLConnection) url.openConnection();
            conn.setRequestMethod("GET");
            conn.setRequestProperty("Accept", "application/json");
            if (conn.getResponseCode() != 200) {
                throw new RuntimeException("HTTP error code : " + conn.getResponseCode());
            }
            BufferedReader br = new BufferedReader(new InputStreamReader((conn.getInputStream())));
            String output;
            StringBuilder json = new StringBuilder();
            while ((output = br.readLine()) != null) {
                json.append(output);
            }
            conn.disconnect();

            Gson gson = new Gson();

            newsMain m = gson.fromJson(json.toString(), newsMain.class);
            System.out.println("properties of class newsMain  \n");
            System.out.println("status    : " + m.getStatus());
            System.out.println("copyright : " + m.getCopyright());

            System.out.println("\n\n properties of class response  \n");
            response r =m.response;
            System.out.println("\n\n properties of class docs   \n");
            System.out.println("\n\n properties of class response  \n");
//            for (newsMain nam : Names) {
//
//                System.out.println("Cca2: " + nam.response.getDocs());
//                System.out.println();
//            }

            System.out.println("----------------------------");

            //name[] rr = gson.toJson(nam.name.get(0), name[].class);

        } catch (ProtocolException ex) {
            throw new RuntimeException(ex);
        } catch (MalformedURLException ex) {
            throw new RuntimeException(ex);
        } catch (IOException ex) {
            throw new RuntimeException(ex);
        }

        //	name[] Nam = gson.fromJson(json.toString(),  parent[0].name[].class);

//		 for (name n : Nam) {
//			 System.out.println(n.getCommon());
//
//		 }
    }

}