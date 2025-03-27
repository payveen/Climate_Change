package com.example.climatechange;

import android.content.Intent;
import android.os.Bundle;
import android.text.Html;
import android.view.View;
import android.widget.TextView;
import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class rewardActivity extends AppCompatActivity {
TextView getname;
TextView select;
String selection,name;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_reward);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.paper), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);

            getname=findViewById(R.id.name);

            select=findViewById(R.id.g_name);
            String text ="<font color=#717171>silver!</font>";
            select.setText(Html.fromHtml(text));

            Intent g=getIntent();
            if((g.getStringExtra("SelectedType")!=null))
            {
            selection=g.getStringExtra("SelectedType");
            select.setText(selection);}
            else {
                selection = g.getStringExtra("money");
                select.setText(selection);
            }

            selection=g.getStringExtra("select");
           name=g.getStringExtra("FullName");
getname.setText(name);
            return insets;

        });

    }

    public void again(View view) {
        Intent in=new Intent(this,MainActivity.class);
        startActivity(in);
        finish();
    }
}