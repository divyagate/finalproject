package com.example.finalproject;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.Toast;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.concurrent.ExecutionException;

public class MainActivity extends AppCompatActivity {

    ListView repolistv;
    ListViewAdpter listviewAdapter;
    ArrayList<Punkapi> punkapiarrayList;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        repolistv = findViewById(R.id.listview);
        punkapiarrayList = new ArrayList<>();
        String apiurl = getResources().getString(R.string.repourl);
        punkapiarrayList = getData(apiurl);
        listviewAdapter = new ListViewAdpter(MainActivity.this,punkapiarrayList);

        repolistv.setAdapter(listviewAdapter);

        repolistv.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int position, long id) {
              Toast.makeText(getApplicationContext(),punkapiarrayList.get(position).getName(),Toast.LENGTH_LONG).show();
                Intent intent1 = new Intent(MainActivity.this,PunkDetail.class);
                intent1.putExtra("Punkapi",punkapiarrayList.get(position));
                startActivity(intent1);
            }
        });


    }

    public ArrayList<Punkapi> getData(String url) {

        ArrayList<Punkapi> PunkArrayList = new ArrayList<>();

        try {
            String jsondata = new AsyncData().execute(url).get();

            JSONObject mainobj = new JSONObject(jsondata);
            JSONArray pokemonArray = mainobj.getJSONArray("Repositories");
            int p_id,ibu;
            Double ph,abv;
            String name,image_url,tagline,description;

            for (int i = 0; i < pokemonArray.length(); i++) {
                JSONObject childobj = pokemonArray.getJSONObject(i);
                System.out.println(childobj);

                p_id = childobj.getInt("id");
                name = childobj.getString("name");
                image_url = childobj.getString("image_url");

                if(childobj.isNull("ph") ){
                    ph= 0.0;
                    System.out.println(ph);

                }
                else{
                    ph = childobj.getDouble("ph");
                    System.out.println(ph);

                }
                if(childobj.isNull("ibu") ){
                    ibu= 0;
                }
                else{
                    ibu = childobj.getInt("ibu");
                }

                abv = childobj.getDouble("abv");
                tagline = childobj.getString("tagline");
                description = childobj.getString("description");

                PunkArrayList.add(new Punkapi(p_id,name,image_url,abv,ibu,ph,tagline,description) );

            }

        } catch (InterruptedException e) {
            e.printStackTrace();
        } catch (ExecutionException e) {
            e.printStackTrace();
        } catch (JSONException e) {
            e.printStackTrace();
        }

        System.out.println("Size of Arraylist(Outside try) :"+PunkArrayList.size());
        return  PunkArrayList;
    }
}