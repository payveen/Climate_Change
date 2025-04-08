package com.example.climatechange;
import androidx.appcompat.app.AppCompatActivity;
import android.media.MediaPlayer;
import android.os.Bundle;

import android.content.Intent;
import android.os.Bundle;
import android.text.Html;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class rewardActivity extends AppCompatActivity {
TextView getname;
TextView select ,rew;
Button btnreward;
String selection="",name="",bags="",trashType="",money="";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        MediaPlayer mediaPlayer = MediaPlayer.create(this, R.raw.win_sound);
        mediaPlayer.start();
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_reward);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.paper), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
rew=findViewById(R.id.reward);
            getname=findViewById(R.id.show_name);

btnreward=findViewById(R.id.select);

            Intent g=getIntent();
            name=g.getStringExtra("FullName");
            bags=g.getStringExtra("num_bags");
            trashType=g.getStringExtra("SelectedTypeTrash");
            selection=g.getStringExtra("select");
            money=g.getStringExtra("money");
getname.setText("THANK YOU "+name.toUpperCase());

if(selection.equals("planting_tree")){
    int m=Integer.parseInt(money);
    if(m<5000) {
        String text ="<font color=#7B837A>YOU GOT SILVER!</font>";
        rew.setText(Html.fromHtml(text));
        String text2 ="<font color=#7B837A>Try To Get Gold</font>";
        btnreward.setText(Html.fromHtml(text2));

    }
    else if(m >= 5000 && m < 25000){
        String text ="<font color=#FDD835>YOU GOT GOLD!</font>";
        rew.setText(Html.fromHtml(text));
        String text2 ="<font color=#FDD835>Try To Get Diamond</font>";
        btnreward.setText(Html.fromHtml(text2));
    }
    else if(m >= 25000) {
        String text ="<font color=#46B5EB>YOU GOT DIAMOND!</font>";
        rew.setText(Html.fromHtml(text));
        String text2 ="<font color=#46B5EB>Highest Score Try Again</font>";
        btnreward.setText(Html.fromHtml(text2));
    }
}
if(selection.equals("collecting_trash")){
   int b=Integer.parseInt(bags);
    if(b<3) {
        String text ="<font color=#7B837A>YOU GOT SILVER!</font>";
        rew.setText(Html.fromHtml(text));
        String text2 ="<font color=#7B837A>Try To Get Gold</font>";
        btnreward.setText(Html.fromHtml(text2));
    }
    else if(b >= 3 && b < 8){
        String text ="<font color=#FDD835>YOU GOT GOLD!</font>";
        rew.setText(Html.fromHtml(text));
        String text2 ="<font color=#FDD835>Try To Get Diamond</font>";
        btnreward.setText(Html.fromHtml(text2));
    }
    else if(b >= 8){
        String text ="<font color=#46B5EB>YOU GOT DIAMOND!</font>";
        rew.setText(Html.fromHtml(text));
        String text2 ="<font color=#46B5EB>Highest Score Try Again</font>";
        btnreward.setText(Html.fromHtml(text2));
    }
}
            return insets;

        });

    }

    public void again(View view) {
        Intent in=new Intent(this,MainActivity.class);
        startActivity(in);
        finish();
    }
}