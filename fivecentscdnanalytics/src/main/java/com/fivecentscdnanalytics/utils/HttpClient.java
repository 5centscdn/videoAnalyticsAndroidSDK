package com.fivecentscdnanalytics.utils;

import android.content.Context;

import java.io.IOException;

import okhttp3.Call;
import okhttp3.Callback;
import okhttp3.MediaType;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.RequestBody;
import okhttp3.Response;

public class HttpClient {
    public static final MediaType JSON = MediaType.parse("application/json; charset=utf-8");
    private static final String TAG = "HttpClient";
    private OkHttpClient client = null;
    private Context context;

    public HttpClient(Context context, OkHttpClient client) {
        this.context = context;
        this.client = client;
    }

    public void post(String url, String postBody, final Callback callback) {
       FCCLog.d(TAG, String.format("Posting Analytics JSON: \n%s\n", postBody));
        Request request =
                new Request.Builder()
                        .url(url)
                        .header("Origin", String.format("http://%s", context.getPackageName()))
                        .post(RequestBody.create(JSON, postBody))
                        .build();

        client.newCall(request)
                .enqueue(
                        new Callback() {
                            @Override
                            public void onFailure(Call call, IOException e) {
                                FCCLog.e(TAG, "HTTP Error: ", e);
                                if (callback != null) {
                                    callback.onFailure(call, e);
                                }
                            }

                            @Override
                            public void onResponse(Call call, Response response)
                                    throws IOException {
                                if (callback != null) {
                                    callback.onResponse(call, response);
                                }
                                if (response == null) {
                                    return;
                                }
                                response.close();
                            }
                        });
    }
}
