package com.openclassrooms.entrevoisins.service;

import com.openclassrooms.entrevoisins.model.Neighbour;

import java.util.ArrayList;
import java.util.List;

/**
 * Dummy mock for the Api
 */
public class DummyNeighbourApiService implements NeighbourApiService {

    private List<Neighbour> neighbours = DummyNeighbourGenerator.generateNeighbours();


    /**
     * {@inheritDoc}
     */
    @Override
    public List<Neighbour> getNeighbours() {
        return neighbours;
    }

    @Override
    public Neighbour getNeighbours(long id) {
        for (Neighbour neighbour : neighbours) {
            if (neighbour.getId() == id) return neighbour;
        }
        return null;
    }


    /**
     * Loop for add neighbours to favoritesNeighbourList
     */
    public List<Neighbour> getFavoritesNeighbour() {
        List<Neighbour> favoritesNeighbourList = new ArrayList<>();
        for (Neighbour neighbour : neighbours) {
            if (neighbour.isFav()) favoritesNeighbourList.add(neighbour);
        }
        return favoritesNeighbourList;
    }


    /**
     * {@inheritDoc}
     */
    @Override
    public void deleteNeighbour(Neighbour neighbour) {
        neighbours.remove(neighbour);
    }

    /**
     * {@inheritDoc}
     *
     * @param neighbour
     */
    @Override
    public void createNeighbour(Neighbour neighbour) {
        neighbours.add(neighbour);
    }

    @Override
    public void changedFavoritesNeighboursStatus(Neighbour neighbour, Boolean favoris) {
        Neighbour mNeighbours = neighbour;
        mNeighbours.setFav(favoris);
    }

}

