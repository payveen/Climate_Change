package com.example.climatechange;

import android.app.Activity;
import android.content.Intent;
import android.graphics.Bitmap;
import android.os.Bundle;
import android.provider.MediaStore;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.CheckBox;
import android.widget.ImageView;

import androidx.activity.EdgeToEdge;
import androidx.activity.result.ActivityResultLauncher;
import androidx.activity.result.contract.ActivityResultContracts;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class trashActivity extends AppCompatActivity {
String str;
String selection;
    EditText cbag;
    CheckBox plastic , metal ,glass , paper;

    private ImageView iv;
    private Button b1;

    public trashActivity() {
        cameraLauncher = registerForActivityResult(
                new ActivityResultContracts.StartActivityForResult(),
                result -> {
                    if (result.getResultCode() == Activity.RESULT_OK) {
                        Intent data = result.getData();
                        if (data != null && data.getExtras() != null) {
                            Bitmap photo = (Bitmap) data.getExtras().get("data");
                            iv.setImageBitmap(photo);
                        }
                    }
                }
        );
    }

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
            iv=findViewById(R.id.imageView9);
            b1=findViewById(R.id.button7);

            return insets;
        });

        b1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent open_camera = new Intent(MediaStore.ACTION_IMAGE_CAPTURE);
                startActivityForResult(open_camera, 100);
            }
        });
    }
String checkall="",bagnum="";
    public void trashTOreward(View view) {
        cbag=findViewById(R.id.countbags);
        bagnum=cbag.getText().toString();
        if(plastic.isChecked()){checkall=checkall+"/plastic/";}
        if(metal.isChecked()){checkall=checkall+"/metal/";}
        if(glass.isChecked()){checkall=checkall+"/glass/";}
        if(paper.isChecked()){checkall=checkall+"/paper/";}

        Intent in=new Intent(this,rewardActivity.class);
        in.putExtra("SelectedTypeTrash",checkall);
        in.putExtra("FullName",str);
        in.putExtra("select",selection);
        in.putExtra("num_bags",bagnum);
        startActivity(in);
        finish();
    }

    ActivityResultLauncher<Intent> cameraLauncher;
}