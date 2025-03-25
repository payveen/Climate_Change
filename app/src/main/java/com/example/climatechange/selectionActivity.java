package com.example.climatechange;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class selectionActivity extends AppCompatActivity {
    String str;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_selection);

        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.paper), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            Intent g=getIntent();
            str=g.getStringExtra("FullName");
            return insets;
        });
    }
String selection="";
    public void selectionTOtrash(View view) {
        selection="collecting_trash";
        Intent in=new Intent(this,trashActivity.class);
        in.putExtra("FullName",str);
        in.putExtra("select",selection);
        startActivity(in);
        finish();
    }

    public void selectionTOtree(View view) {
        selection="planting_tree";
        Intent in=new Intent(this,treeActivity.class);
        in.putExtra("FullName",str);
        in.putExtra("select",selection);
        startActivity(in);
        finish();
    }
}