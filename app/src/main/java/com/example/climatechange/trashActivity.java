package com.example.climatechange;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.CheckBox;
import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class trashActivity extends AppCompatActivity {
String str;
String selection;
    CheckBox plastic , metal ,glass , paper;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_trash);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.paper), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            Intent g=getIntent();
            str=g.getStringExtra("FullName");
            selection=g.getStringExtra("select");
            plastic=findViewById(R.id.plastic);
            metal=findViewById(R.id.metal);
            glass=findViewById(R.id.glass);
            paper=findViewById(R.id.paper);
            return insets;
        });
    }
String checkall="";
    public void trashTOreward(View view) {
        if(plastic.isChecked()){checkall=checkall+"/plastic/";}
        if(metal.isChecked()){checkall=checkall+"/metal/";}
        if(glass.isChecked()){checkall=checkall+"/glass/";}
        if(paper.isChecked()){checkall=checkall+"/paper/";}

        Intent in=new Intent(this,rewardActivity.class);
        in.putExtra("SelectedType",checkall);
        in.putExtra("FullName",str);
        in.putExtra("select",selection);
        startActivity(in);
        finish();
    }
}