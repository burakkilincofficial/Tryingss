package test.cases;

import org.json.JSONArray;
import org.json.JSONObject;
import org.json.JSONTokener;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.*;

public class MercedesTest {
    public static void main(String[] args) throws IOException {
        List<Integer> testValues = new ArrayList<>();
        testValues.add(1);
        testValues.add(1);
        testValues.add(2);
        testValues.add(2);
        testValues.add(4);
        testValues.add(4);
        testValues.add(4);
        testValues.add(4);
        System.out.println(countDuplicate(testValues));

        List<String> usernames = getUsernames(196);
        for (String username : usernames) {
            System.out.println(username);
        }

    }

    public static int countDuplicate(List<Integer> numbers) {
        Map<Integer, Integer> duplicateMap = new HashMap<>();
        int countA;
        for (Integer number : numbers) {
            countA = Collections.frequency(numbers, number);
            if (countA > 1) {
                duplicateMap.put(number, countA);
            }
        }
        return duplicateMap.size();
    }

    public static String httpRequest(int threshold) throws IOException {

        String baseUrl = "https://jsonmock.hackerrank.com";
        URL url = new URL(String.format("%s/api/article_users/search?page=%d", baseUrl, threshold));
        HttpURLConnection con = (HttpURLConnection) url.openConnection();
        con.setRequestMethod("GET");

        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(con.getInputStream()));
        String inputLine;

        StringBuilder content = new StringBuilder();
        while ((inputLine = bufferedReader.readLine()) != null) {
            content.append(inputLine);
        }
        bufferedReader.close();
        con.disconnect();

        return content.toString();
    }

    public static List<String> getUsernames(int threshold) {
        List<String> authors = new ArrayList<>();
        URL url = null;
        int responseCode = 200;
        try {
            url = new URL("https://jsonmock.hackerrank.com/api/article_users/search?page=1");

            HttpURLConnection conn = (HttpURLConnection) url.openConnection();
            conn.setRequestMethod("GET");
            conn.connect();
            responseCode = conn.getResponseCode();
        } catch (Exception e) {
            e.printStackTrace();
        }
        if (responseCode != 200) {
            throw new RuntimeException("HttpResponseCode: " + responseCode);
        } else {
            int total_pages = 0;
            try {
                JSONTokener tokener = new JSONTokener(url.openStream());
                JSONObject jobj = new JSONObject(tokener);

                total_pages = Integer.parseInt(jobj.get("total_pages").toString());
            } catch (Exception e) {
                e.printStackTrace();
            }

            for (int pagenumber = 1; pagenumber <= total_pages; pagenumber++) {

                try {
                    url = new URL("https://jsonmock.hackerrank.com/api/article_users/search?page=" + pagenumber);

                    HttpURLConnection conn = (HttpURLConnection) url.openConnection();
                    conn.setRequestMethod("GET");
                    conn.connect();
                    responseCode = conn.getResponseCode();
                } catch (Exception e) {
                    e.printStackTrace();
                }
                if (responseCode != 200) {
                    throw new RuntimeException("HttpResponseCode: " + responseCode);
                } else {

                    try {
                        JSONTokener new_tokener = new JSONTokener(url.openStream());
                        JSONObject _jobj = new JSONObject(new_tokener);
                        JSONArray data = (JSONArray) _jobj.get("data");
                        for (int i = 0; i < (int) data.length(); i++) {
                            JSONObject author = (JSONObject) data.get(i);
                            if (Integer.parseInt(author.get("submission_count").toString()) > threshold) {
                                authors.add(author.get("username").toString());
                            }
                        }
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                }

            }
        }
        return authors;
    }

}
