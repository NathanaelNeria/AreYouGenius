package com.example.nathanaelneria.areyougenius;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;

public class highScore extends AppCompatActivity {
    ArrayAdapter<Java> myStringArray;
    ListView listView;
    Database db;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_high_score);
    }

    @Override
    protected void onStart() {
        super.onStart();
        myStringArray = new ArrayAdapter<Java>(this, android.R.layout.simple_list_item_1);


        ListView listView = (ListView) findViewById(R.id.listView);
        listView.setAdapter(myStringArray);



        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                System.out.println("Index: " + position);
                System.out.println("Name: " + myStringArray.getItem(position));
        }
});
    }
}