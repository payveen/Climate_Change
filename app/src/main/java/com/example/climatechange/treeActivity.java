package com.example.climatechange;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class treeActivity extends AppCompatActivity {
String str;
String selection, money="";
    EditText count_money;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_tree);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.paper), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            Intent g=getIntent();
            str=g.getStringExtra("FullName");
            selection=g.getStringExtra("select");

            return insets;
        });
    }

    public void to_reward(View view) {
        count_money=findViewById(R.id.money_num);
        money=count_money.getText().toString();

        Intent in=new Intent(this,rewardActivity.class);
        in.putExtra("FullName",str);
        in.putExtra("select",selection);
        in.putExtra("money",money);
        startActivity(in);
        finish();
    }
}