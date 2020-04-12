package com.openclassrooms.entrevoisins.events;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import com.openclassrooms.entrevoisins.ui.neighbour_list.Constant;
import com.openclassrooms.entrevoisins.ui.neighbour_list.ActivityProfileNeighbours;

/**
 * Created by Alph4 le 27/03/2020.
 * Projet: Entrevoisins
 **/
public class OpenNeighbourEvent {
    public OpenNeighbourEvent(View v) {
        Intent intent = new Intent(v.getContext(), ActivityProfileNeighbours.class);
        Bundle bundle = new Bundle();
        bundle.putLong("idNeighbour", Constant.IDNEIGHBOUR);
        intent.putExtras(bundle);
        v.getContext().startActivity(intent);
    }
}
