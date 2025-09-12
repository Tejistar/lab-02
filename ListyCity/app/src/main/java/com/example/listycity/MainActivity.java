package com.example.listycity;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;

public class MainActivity extends AppCompatActivity {

    ListView cityList;
    ArrayAdapter<String> cityAdapter;
    ArrayList<String> dataList;
    private String last_city_string;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);

        cityList = findViewById(R.id.city_list);

        String[] cities = {"Edmonton", "Vancouver", "Moscow", "Sydney",
                "Berlin", "Vienna", "Tokyo", "Beijing", "Osaka", "New delhi"};

        dataList = new ArrayList<>();
        dataList.addAll(Arrays.asList(cities));

        cityAdapter = new ArrayAdapter<>(this, R.layout.content, dataList);
        cityList.setAdapter(cityAdapter);

        cityList.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Object last_city = parent.getItemAtPosition(position);
                last_city_string = last_city.toString();
            }
        });

    }
    public void addButtonClick(View view){
        View buttonLocation = findViewById(R.id.confirmbutton);
        buttonLocation.setVisibility(View.VISIBLE);
        View textLineLocation = findViewById(R.id.textLine);
        textLineLocation.setVisibility(View.VISIBLE);
    }
    public void deleteButtonClick(View view){
        cityAdapter.remove(last_city_string);
        }
    public void confirmButtonClick(View view){
        EditText textLineLocation = findViewById(R.id.textLine);
        String newCity = textLineLocation.getText().toString();
        textLineLocation.setText("");
        cityAdapter.add(newCity);
        View buttonLocation = findViewById(R.id.confirmbutton);
        buttonLocation.setVisibility(View.GONE);
        textLineLocation.setVisibility(View.GONE);
    }
}