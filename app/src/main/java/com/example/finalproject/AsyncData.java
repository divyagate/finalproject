package com.example.finalproject;

import android.os.AsyncTask;

public class AsyncData extends AsyncTask<String,Void,String> {
    @Override
    protected void onPreExecute() {
        super.onPreExecute();
    }

    @Override
    protected void onPostExecute(String s) {
        super.onPostExecute(s);
    }

    @Override
    protected String doInBackground(String... strings) {

        String apiurl = strings[0];

        Httphandler httpcon = new Httphandler();

        String json = httpcon.callURL(apiurl);

        System.out.println("This is JSON Response : "+json);

        return json;
    }
}
