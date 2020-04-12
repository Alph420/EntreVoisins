package com.openclassrooms.entrevoisins.service;

import com.openclassrooms.entrevoisins.model.Neighbour;

import java.util.List;


/**
 * Neighbour API client
 */
public interface NeighbourApiService {

    /**
     * Get all my Neighbours
     *
     * @return {@link List}
     */
    List<Neighbour> getNeighbours();

    Neighbour getNeighbours(long id);

    /**
     * Get all my FavoritesNeighbours in neighboursList
     *
     * @return {@link List}
     */
    List<Neighbour> getFavoritesNeighbour();

    /**
     * Deletes a neighbour
     *
     * @param neighbour
     */
    void deleteNeighbour(Neighbour neighbour);

    /**
     * Create a neighbour
     *
     * @param neighbour
     */
    void createNeighbour(Neighbour neighbour);

    void changedFavoritesNeighboursStatus(Neighbour neighbour,Boolean favoris);
}
