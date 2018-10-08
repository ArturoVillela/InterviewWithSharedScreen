package charlieandroidblog.esy.es.pizzaapp;

import java.util.ArrayList;

public interface Contract {

    interface Presenter{

        String readJsonFileAsString();

        ArrayList<String> parseJsonFile(String cadJson);
    }

    interface View{

    }
}
