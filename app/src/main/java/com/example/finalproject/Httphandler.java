package com.example.finalproject;

import android.util.Log;

import java.io.BufferedInputStream;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;

public class Httphandler {



    public String callURL(String surl)
    {
        String response = null;

        try
        {
            URL url = new URL(surl);

            HttpURLConnection connection = (HttpURLConnection) url.openConnection();
            connection.setRequestMethod("GET");
            connection.setRequestProperty("Content-Type","application/json");

            //Read response
            InputStream inputStream = new BufferedInputStream(connection.getInputStream());

            //Convert InputStream to String
            response = covertStream(inputStream);



        }catch (MalformedURLException e)
        {
            Log.e("Httphandler Class","MalformedURLException :"+e.getMessage());
        }catch (IOException e)
        {
            Log.e("Httphandler Class","IOException :"+e.getMessage());
        }
        return  response;
    }

    //Convert InputStream to String
    public String covertStream(InputStream ins)
    {
        BufferedReader read = new BufferedReader(new InputStreamReader(ins));

        StringBuilder stringBuilder = new StringBuilder();
        String line;

        try
        {
            stringBuilder.append("{'Repositories':");
            while ((line = read.readLine()) != null)
            {
                stringBuilder.append(line).append("\n");
            }
            stringBuilder.append("}");

        }catch (IOException e)
        {
            Log.e("ConvertStream","IOException :"+e.getMessage());
        }finally {
            try
            {
                ins.close();
            }catch (IOException e)
            {
                Log.e("ConvertStreamFinally","IOException :"+e.getMessage());
            }
        }

        return stringBuilder.toString();
    }

}
