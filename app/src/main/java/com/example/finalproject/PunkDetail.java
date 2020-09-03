package com.example.finalproject;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.text.method.ScrollingMovementMethod;
import android.widget.ImageView;
import android.widget.TextView;

import com.squareup.picasso.Picasso;

public class PunkDetail extends AppCompatActivity {

    ImageView imag ;
    TextView beer_name, beer_ph, beer_ibu, beer_abv, beer_tagline,beer_description;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_punk_detail);

        imag = findViewById(R.id.beer_image);
        beer_name= findViewById(R.id.beer_name);
        beer_ibu= findViewById(R.id.beer_ibu);
        beer_ph= findViewById(R.id.beer_ph);
        beer_abv= findViewById(R.id.beer_abv);
        beer_tagline= findViewById(R.id.beer_tagline);
        beer_description= findViewById(R.id.beer_description);


        Intent i =getIntent();
        Punkapi punk = i.getParcelableExtra("Punkapi");

        Picasso.get().load(punk.getimage_url()).into(imag);
        beer_name.setText("Name: "+punk.getName());
        beer_ibu.setText("Ibu: "+String.valueOf(punk.getibu()));
        beer_ph.setText("Ph: "+String.valueOf(punk.getph()));
        beer_tagline.setText("Tagline: "+punk.gettagline());
        beer_abv.setText("Abv: "+String.valueOf(punk.getabv()));
        beer_description.setText("Description: "+punk.getdescription());


        beer_description.setMovementMethod(new ScrollingMovementMethod());
    }
}