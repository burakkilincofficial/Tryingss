//package test.cases;
//
//import java.io.BufferedReader;
//import java.io.IOException;
//import java.io.InputStreamReader;
//import java.net.HttpURLConnection;
//import java.net.MalformedURLException;
//import java.net.URL;
//
//
//public class udemy {
//    private static final String USER_AGENT = "Mozilla/5.0";
//    private static final String GET_URL = "https://jsonmock.hackerrank.com/api/countries/search?name=un";
//    public static void main(String[] args) throws IOException {
//        Gson g = new Gson();
//        Player p = g.fromJson(jsonString, Player.class);
//
//        JSONParser parser = new JSONParser(); JSONObject json = (JSONObject) parser.parse(stringToParse);
//
//        Read more: https://www.java67.com/2016/10/3-ways-to-convert-string-to-json-object-in-java.html#ixzz74emavo1k
//
//        System.out.println("GET DONE");
//        System.out.println("POST DONE");
//    }
//    private static String sendGET() throws IOException {
//        URL obj = new URL(GET_URL);
//        HttpURLConnection con = (HttpURLConnection) obj.openConnection();
//        con.setRequestMethod("GET");
//        int responseCode = con.getResponseCode();
//        System.out.println("GET Response Code :: " + responseCode);
//        if (responseCode == HttpURLConnection.HTTP_OK) { // success
//            BufferedReader in = new BufferedReader(new InputStreamReader(
//                    con.getInputStream()));
//            String inputLine;
//            StringBuffer response = new StringBuffer();
//
//            while ((inputLine = in.readLine()) != null) {
//                response.append(inputLine);
//            }
//            in.close();
//
//            // print result
//            System.out.println(response.toString());
//            return response.toString();
//        } else {
//            System.out.println("GET request not worked");
//            return null;
//        }
//
//    }
//
//}
