package tmofl.shkolnik;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Parcelable;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.ImageView;

public class MainActivity extends AppCompatActivity {
    ImageView imageViewMon;
    ImageView imageViewTue;
    int monday;
    int tuesday;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        imageViewMon = (ImageView) findViewById(R.id.imageView);
        imageViewTue = (ImageView) findViewById(R.id.imageView2);
  imageViewMon.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view) {
              monday = 1;
                Intent intent = new Intent(MainActivity.this, Rospis.class);
                intent.putExtra("Monday", monday);
                startActivity(intent);
            }
        } );
        imageViewTue.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view) {
                tuesday = 1;
                Intent intent = new Intent(MainActivity.this, Rospis.class);
                intent.putExtra("Tuesday", tuesday);
                startActivity(intent);
            }
        } );
    }
    @Override
    protected  void onResume(){
        super.onResume();
        monday = 0;
        tuesday = 0;
    }
}
