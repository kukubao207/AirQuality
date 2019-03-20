package nju.edu.util;

import org.apache.http.HttpResponse;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.util.EntityUtils;

import java.net.URI;

public class HttpClientUtil {
    public static String getResponse(String url) {
        HttpClient httpClient = null;
        try {
            httpClient = HttpClients.createDefault();
            HttpGet get = new HttpGet(new URI(url));
            HttpResponse response = httpClient.execute(get);
            String userJson = EntityUtils.toString(response.getEntity());
            return userJson;
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            try {
                if(httpClient!=null)
                    ((CloseableHttpClient) httpClient).close();
            }
            catch (Exception E){
                E.printStackTrace();
            }
        }
        return null;
    }
}