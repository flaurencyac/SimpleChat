package com.codepath.simplechat;

import android.app.Application;

import com.parse.Parse;
import com.parse.ParseObject;

import okhttp3.OkHttpClient;
import okhttp3.logging.HttpLoggingInterceptor;

public class ChatApplication extends Application {
    @Override
    public void onCreate() {
        super.onCreate();

        // register class in db
        ParseObject.registerSubclass(Message.class);

        // Use for monitoring Parse network traffic
        OkHttpClient.Builder builder = new OkHttpClient.Builder();
        HttpLoggingInterceptor httpLoggingInterceptor = new HttpLoggingInterceptor();
        // Can be Level.BASIC, Level.HEADERS, or Level.BODY
        httpLoggingInterceptor.setLevel(HttpLoggingInterceptor.Level.BODY);
        // any network interceptors must be added with the Configuration Builder given this syntax
        builder.networkInterceptors().add(httpLoggingInterceptor);

        // Set applicationId and server based on the values in the Back4App settings.
        Parse.initialize(new Parse.Configuration.Builder(this)
                .applicationId("BgMeRhXN4Mfsr4iu7cg2PJPITPJgn9T4meopyWPG")
                .clientKey("r6fZMD0BL8dZx0pVlYemVJbHwqaBtIRqO19SX40c")
                .clientBuilder(builder)
                .server("https://parseapi.back4app.com/").build());

    }
}
