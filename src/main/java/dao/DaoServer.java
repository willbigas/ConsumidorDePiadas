package dao;

import com.google.gson.Gson;
import model.Piada;
import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.util.EntityUtils;

/**
 *
 * @author William
 */
public class DaoServer {

    private static String URL = "https://us-central1-kivson.cloudfunctions.net/charada-aleatoria";

    public static Piada getPiada() {
        CloseableHttpClient closeableHttpClient = HttpClients.createDefault();

        HttpGet requisicaoGet = new HttpGet(URL);
        requisicaoGet.addHeader("content-type", "application/json");
        requisicaoGet.addHeader("Accept", "application/json");
        HttpResponse resposta;
        Piada piada;
        Gson gson = new Gson();

        try {
            resposta = closeableHttpClient.execute(requisicaoGet);
            HttpEntity entidade = resposta.getEntity();
            String conteudo = EntityUtils.toString(entidade);

            piada = gson.fromJson(conteudo, Piada.class);

        } catch (Exception e) {
            piada = null;
        }

        return piada;
    }

}
