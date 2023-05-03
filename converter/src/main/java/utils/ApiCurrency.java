package utils;

import java.io.*;
import java.util.Map;

import com.google.gson.Gson;
import com.google.gson.JsonObject;
import okhttp3.*;

public class ApiCurrency {

    String responseBody;
    public ApiCurrency(String from, String to, String amount) throws IOException {

        String fromValue = from.substring(0, 3);
        String toValue = to.substring(0, 3);
        String amountValue = amount.replace(",", ".");

        HttpUrl url = HttpUrl.parse("https://api.apilayer.com/exchangerates_data/convert")
                .newBuilder()
                .addQueryParameter("to", toValue)
                .addQueryParameter("from", fromValue)
                .addQueryParameter("amount", amountValue)
                .build();

        OkHttpClient client = new OkHttpClient().newBuilder().build();

        Request request = new Request.Builder()
                .url(url)
                .addHeader("apikey", "uyGZ53yxI7bGqR4P8L3lClJJzyO6cPDn")
                .method("GET", null)
                .build();
        Response response = client.newCall(request).execute();
        responseBody = response.body().string();

    }

    public String convertedCurrency() {

        Gson gson = new Gson();
        JsonObject jsonObject = gson.fromJson(responseBody, JsonObject.class);
        Double result = jsonObject.get("result").getAsDouble();
        return String.format("%.2f", result);

    }

}
