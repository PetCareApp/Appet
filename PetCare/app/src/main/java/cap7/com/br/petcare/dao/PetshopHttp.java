package cap7.com.br.petcare.dao;

import android.content.Context;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;

import cap7.com.br.petcare.model.Petshop;

/**
 * Created by antonio on 29/07/2016.
 */
public class PetshopHttp {

    public static final String PETSHOPS_URL_JSON =
            "https://raw.githubusercontent.com/PetCareApp/Appet/master/petshops.json";

    private static HttpURLConnection connectar(String urlArquivo) throws IOException{
        final int SEGUNDOS = 1000;
        URL url = new URL(urlArquivo);
        HttpURLConnection conexao = (HttpURLConnection) url.openConnection();
        conexao.setReadTimeout(10 * SEGUNDOS);
        conexao.setConnectTimeout(15 * SEGUNDOS);
        conexao.setRequestMethod("GET");
        conexao.setDoInput(true);
        conexao.setDoOutput(false);
        conexao.connect();
        return conexao;
    }

    public static boolean temConexao(Context ctx){
        ConnectivityManager cm = (ConnectivityManager) ctx.getSystemService(Context.CONNECTIVITY_SERVICE);
        NetworkInfo info = cm.getActiveNetworkInfo();
        return (info != null && info.isConnected());
    }

    public static List<Petshop> carregarPetshopsJson(){
        try{
            HttpURLConnection conexao = connectar(PETSHOPS_URL_JSON);

            int resposta = conexao.getResponseCode();

            if (resposta == HttpURLConnection.HTTP_OK){
                InputStream is = conexao.getInputStream();
                JSONObject json = new JSONObject(bytesParaString(is));
                return lerJsonPetshops(json);
            }

        } catch (Exception e){
            e.printStackTrace();
        }
        return null;
    }

    public static List<Petshop> lerJsonPetshops(JSONObject json) throws JSONException {
        List<Petshop> listaDePetshops = new ArrayList<Petshop>();

        JSONArray jsonPetshops = json.getJSONArray("petshops");
        for (int i = 0; i < jsonPetshops.length(); i++){
            JSONObject jsonPetshop = jsonPetshops.getJSONObject(i);

            Petshop petshop = new Petshop(
                    jsonPetshop.getInt("id"),
                    jsonPetshop.getString("nome"),
                    jsonPetshop.getString("descricao"),
                    jsonPetshop.getDouble("lat"),
                    jsonPetshop.getDouble("lng"),
                    jsonPetshop.getString("site")
            );

            listaDePetshops.add(petshop);
        }

        return listaDePetshops;
    }

    private static String bytesParaString(InputStream is) throws IOException{

        byte[] buffer = new byte[1024];
        ByteArrayOutputStream bufferzao = new ByteArrayOutputStream();
        int bytesLidos;
        while ((bytesLidos = is.read(buffer)) != -1){
            bufferzao.write(buffer, 0, bytesLidos);
        }
        return new String(bufferzao.toByteArray(), "UTF-8");
    }
}
