package com.openclassrooms.entrevoisins.ui.neighbour_list;

import android.content.Intent;
import android.support.design.widget.FloatingActionButton;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.openclassrooms.entrevoisins.R;
import com.openclassrooms.entrevoisins.di.DI;
import com.openclassrooms.entrevoisins.model.Neighbour;
import com.openclassrooms.entrevoisins.service.NeighbourApiService;

public class ActivityProfileNeighbours extends AppCompatActivity {

    private Neighbour mNeighbour;

    private ImageView mImageNeighbour;
    private TextView mTextViewNeighbourName;
    private FloatingActionButton mButtonFavorites;
    private Button mButtonBack;

    private TextView mNeighbourName;

    private TextView mNeighbourLocation;
    private TextView mNeighbourNumber;
    private TextView mNeighbourWebSite;

    private TextView mNeighbourAboutMe;
    private NeighbourApiService mApiService;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_profile_neighbour);

        mApiService = DI.getNeighbourApiService();
        Intent intent = getIntent();

        //Get Id of Neighbour Selected
        if (intent != null) {
            if (intent.hasExtra("idNeighbour")) {
                mNeighbour = mApiService.getNeighbours(intent.getLongExtra("idNeighbour", 0));
            }
        }

        //region ASSOCIATION ID
        mImageNeighbour = findViewById(R.id.neighbour_picture);
        mTextViewNeighbourName = findViewById(R.id.neighbour_name);
        mButtonFavorites = findViewById(R.id.button_Favorites);
        mButtonBack = findViewById(R.id.back_button);

        mNeighbourName = findViewById(R.id.textView_neighbour_name);

        mNeighbourLocation = findViewById(R.id.text_view_location_content);
        mNeighbourNumber = findViewById(R.id.text_view_mobile_number_content);
        mNeighbourWebSite = findViewById(R.id.text_view_webSite_content);

        mNeighbourAboutMe = findViewById(R.id.text_view_about_content);
        //endregion

        Glide.with(this).load(mNeighbour.getAvatarUrl()).into(mImageNeighbour);

        mTextViewNeighbourName.setText(mNeighbour.getName());

        if (mNeighbour.isFav())mButtonFavorites.setImageResource(R.drawable.ic_star_full_yellow_24dp);
        else mButtonFavorites.setImageResource(R.drawable.ic_star_empty_yellow_24dp);


        mNeighbourName.setText(mNeighbour.getName());

        mNeighbourLocation.setText(mNeighbour.getAddress());
        mNeighbourNumber.setText(mNeighbour.getPhoneNumber());
        mNeighbourWebSite.setText("www.facebook.fr/" + mNeighbour.getName().toLowerCase());

        mNeighbourAboutMe.setText(mNeighbour.getAboutMe());

        mButtonFavorites.setOnClickListener(v -> {
            if (mNeighbour.isFav()) {
               mApiService.changedFavoritesNeighboursStatus(mNeighbour,false);
                mButtonFavorites.setImageResource(R.drawable.ic_star_empty_yellow_24dp);
            } else {
                mApiService.changedFavoritesNeighboursStatus(mNeighbour,true);
                mButtonFavorites.setImageResource(R.drawable.ic_star_full_yellow_24dp);
            }
        });

        mButtonBack.setOnClickListener(v -> {
            Intent intent1 = new Intent(this, ListNeighbourActivity.class);
            startActivity(intent1);
        });
    }
}