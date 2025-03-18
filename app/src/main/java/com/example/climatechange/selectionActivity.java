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
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            Intent g=getIntent();
            str=g.getStringExtra("FullName");
            return insets;
        });
    }

    public void selectionTOtrash(View view) {
        Intent in=new Intent(this,trashActivity.class);
        in.putExtra("FullName",str);
        startActivity(in);
        finish();
    }

    public void selectionTOtree(View view) {
        Intent in=new Intent(this,treeActivity.class);
        in.putExtra("FullName",str);
        startActivity(in);
        finish();
    }
}