package sg.edu.rp.c346.id20037987.l12oursingapore;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RatingBar;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    EditText etName, etDesc, etSize;
    Button btnInsert, btnShowIslandList;
    //RadioGroup rg;
    RatingBar rbInsertStar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        setTitle(getTitle().toString() + " ~ " + getResources().getText(R.string.title_activity_main));

        etName = findViewById(R.id.etName);
        etDesc = findViewById(R.id.etDesc);
        etSize = findViewById(R.id.etSize);
        btnInsert = findViewById(R.id.btnInsertIsland);
        btnShowIslandList = findViewById(R.id.btnShowIslandList);
        //rg = findViewById(R.id.rgStars);
        rbInsertStar = findViewById(R.id.ratingBar2);

        btnInsert.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                String name = etName.getText().toString().trim();
                String desc = etDesc.getText().toString().trim();
                if (name.length() == 0 || desc.length() == 0){
                    Toast.makeText(MainActivity.this, "Incomplete data", Toast.LENGTH_SHORT).show();
                    return;
                }

                String size_str = etSize.getText().toString().trim();
                int size = Integer.valueOf(size_str);
                //int stars = getStars();

                DBHelper dbh = new DBHelper(MainActivity.this);

                int rating = (int) rbInsertStar.getRating();

                //long result = dbh.insertSong(title, singers, year, stars);
                long result = dbh.insertIsland(name, desc, size, rating);

                if (result != -1) {
                    Toast.makeText(MainActivity.this, "Island inserted", Toast.LENGTH_LONG).show();
                    etName.setText("");
                    etDesc.setText("");
                    etSize.setText("");
                } else {
                    Toast.makeText(MainActivity.this, "Insert failed", Toast.LENGTH_LONG).show();
                }


            }
        });

        btnShowIslandList.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View arg0) {
                Intent i = new Intent(MainActivity.this, SecondActivity.class);
                startActivity(i);
            }
        });

    }


}
