package charlieandroidblog.esy.es.pizzaapp;

import org.junit.Test;

import java.util.ArrayList;

import static org.junit.Assert.*;

public class PresenterTest {

    @Test
    public void sortArrayList() {
        ArrayList<String> alBase = new ArrayList<>();
        alBase.add("Carlos");
        alBase.add("Mario");
        alBase.add("Zed");
        alBase.add("Red");

        ArrayList<String> alExpected = new ArrayList<>();
        alExpected.add("Carlos");
        alExpected.add("Mario");
        alExpected.add("Red");
        alExpected.add("Zed");


        Presenter presenter = new Presenter();
        assertEquals(alExpected, presenter.sortArrayList(alBase));



    }
}