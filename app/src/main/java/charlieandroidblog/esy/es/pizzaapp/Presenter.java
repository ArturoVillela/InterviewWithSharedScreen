package charlieandroidblog.esy.es.pizzaapp;

import android.util.Log;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import java.io.IOException;
import java.io.InputStream;
import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.Comparator;

public class Presenter implements Contract.Presenter {

    MainActivity context;

    public Presenter(MainActivity context) {
        this.context = context;
        init();
    }

    public Presenter() {
    }

    private void init() {
        String jsonAsString = readJsonFileAsString();
        if (jsonAsString!=null){
            ArrayList<String> alCheese = parseJsonFile(jsonAsString);
            Log.d("zzz", "array parsed: ");
            for (String cad : alCheese){
                Log.d("zzz", "cad : "+cad);
            }
            sortArrayList(alCheese);
        }

    }

    public ArrayList<String> sortArrayList(ArrayList<String> alCheese) {
        Collections.sort(alCheese, new Comparator<String>() {
            @Override
            public int compare(String o1, String o2) {
                return o1.compareTo(o2);
            }
        });

        return alCheese;
    }

    @Override
    public String readJsonFileAsString() {
        String json = null;
        try {
            InputStream is = context.getAssets().open("cheese_list.json");
            int size = is.available();
            byte[] buffer = new byte[size];
            is.read(buffer);
            is.close();
            json = new String(buffer, "UTF-8");
        } catch (IOException ex) {
            ex.printStackTrace();
            return null;
        }
        return json;
    }

    @Override
    public ArrayList<String> parseJsonFile(String cadJson) {
        Gson gson = new Gson();
        String jsonOutput = cadJson; //nuestro json como string

        Type listType = new TypeToken<Collection<String>>() {}.getType();

        ArrayList<String> al = (ArrayList) gson.fromJson(jsonOutput, listType);
        return al;
    }
}
