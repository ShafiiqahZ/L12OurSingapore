package sg.edu.rp.c346.id20037987.l12oursingapore;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.ListView;

import java.util.ArrayList;

public class SecondActivity extends AppCompatActivity {

    ListView lv;
    ArrayList<OurSingapore> islandList;
    //ArrayAdapter adapter;
    CustomAdapter caIsland;
    String islandDesc;
    int requestCode = 9;
    Button btn5Stars;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);

        setTitle(getTitle().toString() + " ~ " +  getResources().getText(R.string.title_activity_second));

        lv = (ListView) this.findViewById(R.id.lv);
        btn5Stars = (Button) this.findViewById(R.id.btnShowIsland5Stars);

        DBHelper dbh = new DBHelper(this);
        islandList = dbh.getAllIslands();
        dbh.close();

        //adapter = new ArrayAdapter(this, android.R.layout.simple_list_item_1, songList);
        //lv.setAdapter(adapter);

        caIsland = new CustomAdapter(this, R.layout.row, islandList);

        lv.setAdapter(caIsland);

        lv.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Intent i = new Intent(SecondActivity.this, ThirdActivity.class);
                i.putExtra("island", islandList.get(position));
                startActivityForResult(i, requestCode);
            }
        });

        btn5Stars.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                DBHelper dbh = new DBHelper(SecondActivity.this);
                islandList.clear();
                islandList.addAll(dbh.getAllIslandsByStars(5));
                caIsland.notifyDataSetChanged();
            }
        });

    }

        @Override
        protected void onActivityResult(int requestCode, int resultCode, Intent data) {
            if(requestCode == this.requestCode && resultCode == RESULT_OK){
                DBHelper dbh = new DBHelper(this);
                islandList.clear();
                islandList.addAll(dbh.getAllIslands());
                dbh.close();
                caIsland.notifyDataSetChanged();
            }
            super.onActivityResult(requestCode, resultCode, data);
        }


}