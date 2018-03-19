package br.usjt.paises;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;

/**
 * Created by supor on 19/03/2018.
 */

public class ConectJSON {
    //Responsável por carregar o objeto JSON

    public static String getJSONF(String url) {
        String retorno = "";
        try {
            URL apiFinal = new URL(url);
            int codResposta;
            HttpURLConnection conexao;
            InputStream is;

            conexao = (HttpURLConnection) apiFinal.openConnection();
            conexao.setRequestMethod("GET");
            conexao.setConnectTimeout(15000);
            conexao.connect();

            codResposta = conexao.getResponseCode();
            if (codResposta < HttpURLConnection.HTTP_BAD_REQUEST) {
                is = conexao.getInputStream();
            } else {
                is = conexao.getErrorStream();
            }

            retorno = converterInputStreamToString(is);
            is.close();
            conexao.disconnect();
        } catch (MalformedURLException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
            return retorno;
    }

    private static String converterInputStreamToString(InputStream is){
        StringBuffer buffer = new StringBuffer();
        try {
            BufferedReader br;
            String linha;

            br = new BufferedReader(new InputStreamReader(is));
            while((linha = br.readLine()) != null){
                buffer.append(linha);
            }
            br.close();
        }catch(IOException e){
            e.printStackTrace();
        }return buffer.toString();
    }

}
