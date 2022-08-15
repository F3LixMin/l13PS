package sg.edu.rp.c346.id21008740.l13ps;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import com.loopj.android.http.AsyncHttpClient;
import com.loopj.android.http.JsonHttpResponseHandler;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;

import cz.msebera.android.httpclient.Header;

public class MainActivity extends AppCompatActivity {
    ListView lv;
    AsyncHttpClient client;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        lv = findViewById(R.id.lv);
        client = new AsyncHttpClient();
    }
    @Override
    protected void onResume() {
        super.onResume();

        ArrayList<Kindergarten> alWeather = new ArrayList<Kindergarten>();

        client.get("https://data.gov.sg/api/action/datastore_search?resource_id=4ad866a7-c43a-4645-87fd-fc961c9de78a&limit=10", new JsonHttpResponseHandler() {

            String year;
            String enrolment;

            @Override
            public void onSuccess(int statusCode, Header[] headers, JSONObject response) {
                try {
                    JSONObject jsonArrItems = response.getJSONObject("result");
                    JSONArray jsonrecords = jsonArrItems.getJSONArray("records");

                    for (int i = 0; i < jsonrecords.length(); i++) {
                        JSONObject jsonKg = jsonrecords.getJSONObject(i);
                        year = jsonKg.getString("year");
                        enrolment = jsonKg.getString("enrolment");
                        Kindergarten KdData = new Kindergarten(year, enrolment);
                        alWeather.add(KdData);
                    }
                } catch (JSONException e) {

                }

                ArrayAdapter<Kindergarten> aaKgarten= new ArrayAdapter(MainActivity.this, android.R.layout.simple_list_item_1,alWeather);
                lv.setAdapter(aaKgarten);



            }//end onSuccess
        });
    }//end onResume
}
