package com.example.climatechange;

import android.content.Intent;
import android.os.Bundle;
import android.os.PersistableBundle;
import android.view.View;
import android.widget.TextView;
import androidx.activity.EdgeToEdge;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class rewardActivity extends AppCompatActivity {
TextView getname ,select;
String name,selection,m;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_reward);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            getname=findViewById(R.id.g_name);
            select=findViewById(R.id.select);
            Intent g=getIntent();
            name=g.getStringExtra("FullName");
            getname.setText(name);
            selection=g.getStringExtra("select");
           m=g.getStringExtra("money");

            return insets;

        });

    }

    public void again(View view) {
        Intent in=new Intent(this,MainActivity.class);
        startActivity(in);
        finish();
    }
}