package com.openclassrooms.entrevoisins.service;

import com.openclassrooms.entrevoisins.di.DI;
import com.openclassrooms.entrevoisins.model.Neighbour;

import org.hamcrest.collection.IsIterableContainingInAnyOrder;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;

import java.util.List;
import java.util.Objects;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertThat;
import static org.junit.Assert.assertTrue;

/**
 * Unit test on Neighbour service
 */
@RunWith(JUnit4.class)
public class NeighbourServiceTest {

    private NeighbourApiService service;

    @Before
    public void setup() {
        service = DI.getNewInstanceApiService();
    }

    @Test
    public void getNeighboursWithSuccess() {
        List<Neighbour> neighbours = service.getNeighbours();
        List<Neighbour> expectedNeighbours = DummyNeighbourGenerator.DUMMY_NEIGHBOURS;
        assertThat(neighbours, IsIterableContainingInAnyOrder.containsInAnyOrder(Objects.requireNonNull(expectedNeighbours.toArray())));
    }

    @Test
    public void getFavoritesNeighboursWithSuccess() {
        List<Neighbour> favoritesNeighbour = service.getFavoritesNeighbour();
        List<Neighbour> expectedFavoritesNeighbours = DI.getNeighbourApiService().getFavoritesNeighbour();
        assertThat(favoritesNeighbour, IsIterableContainingInAnyOrder.containsInAnyOrder(Objects.requireNonNull(expectedFavoritesNeighbours.toArray())));
    }

    @Test
    public void createNeighbourWithSuccess() {
        Neighbour bob = new Neighbour(420, "Bob", "https://i.pravatar.cc", "Paris",
                "+33 6 12 23 45 67", "Bonjour, My name is Bob");
        service.createNeighbour(bob);
        assertTrue(service.getNeighbours().contains(bob));
    }

    @Test
    public void deleteFavoritesNeighoursWithSuccess() {
        Neighbour bob = new Neighbour(420, "Bob", "https://i.pravatar.cc", "Paris",
                "+33 6 12 23 45 67", "Bonjour, My name is Bob");

        service.createNeighbour(bob);
        service.changedFavoritesNeighboursStatus(bob, true);

        List<Neighbour> favoritesNeighours = service.getFavoritesNeighbour();

        Neighbour neighbour = favoritesNeighours.get(0);

        service.changedFavoritesNeighboursStatus(neighbour, false);

        favoritesNeighours = service.getFavoritesNeighbour();

        assertFalse(favoritesNeighours.contains(bob));
    }


    @Test
    public void deleteNeighbourWithSuccess() {
        Neighbour neighbourToDelete = service.getNeighbours().get(0);
        service.deleteNeighbour(neighbourToDelete);
        assertFalse(service.getNeighbours().contains(neighbourToDelete));
    }
}
