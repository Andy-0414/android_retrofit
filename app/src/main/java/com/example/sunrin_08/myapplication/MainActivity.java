package com.example.sunrin_08.myapplication;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.widget.ListView;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MainActivity extends AppCompatActivity {
    ListView lv;
    static MainAdapter ma;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        lv = findViewById(R.id.lv);
        ma = new MainAdapter(this);

        SunrinAniService githubService = SunrinAniService.retrofit.create(SunrinAniService.class);

        Call<List<Item>> call = null;
        call = githubService.getAniData();
        call.enqueue(new Callback<List<Item>>() {
            @Override
            public void onResponse(Call<List<Item>> call, Response<List<Item>> response) {
                if (response.body() != null) {
                    for (int i = 0; i < response.body().size(); i++) {
                        ma.putItem((Item)response.body().get(i));
                    }
                    ma.notifyDataSetChanged();
                    lv.setAdapter(ma);
                } else
                    Log.e("ERR : ", "NOTDATA");
            }

            @Override
            public void onFailure(Call<List<Item>> call, Throwable t) {
            }
        });

    }
}
