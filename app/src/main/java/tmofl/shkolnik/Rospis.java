package tmofl.shkolnik;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.res.Resources;
import android.nfc.Tag;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.support.v7.app.AppCompatActivity;

public class Rospis extends AppCompatActivity{

    Button button;
    SharedPreferences lol;
    int lessonsnumber;
    EditText editText;
    TextView textView;
    EditText editText2;
    String[] lessons = {"Алгебра","Русский язык","Биология","Литература","Физика","Химия","Информатика","История","Геометрия","Английский язык"};
    private static  final String TAG = "lol";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_rospis);
        editText = (EditText) findViewById(R.id.editText);
        editText2 = (EditText) findViewById(R.id.editText2);
        button= (Button) findViewById(R.id.button);
        textView = (TextView) findViewById(R.id.textView);
        lol = getSharedPreferences("MondayLessons", Context.MODE_PRIVATE);
        lol = getSharedPreferences("TuesdayLessons", Context.MODE_PRIVATE);
    }

    public  void primenit (View view){
        lessonsnumber = 0;
        for(int i = 1; i<10; i++){
            if (editText.getText().toString().equalsIgnoreCase(lessons[i-1])){lessonsnumber = lessonsnumber + i;}
            if (editText2.getText().toString().equalsIgnoreCase(lessons[i-1])){lessonsnumber = lessonsnumber + i*10;}}
        }

    public  void back(View view){
        Intent intent = new Intent(Rospis.this, MainActivity.class);
        startActivity(intent);}

    @Override
    protected void onResume(){
        super.onResume();
        lessonsnumber = 0;
        Intent intent = getIntent();

        if( intent.getIntExtra("Monday",0) ==  1) {
            lessonsnumber = lol.getInt("MondayLessons",0);
            textView.setText("Понедельник");}

        if( intent.getIntExtra("Tuesday",0) ==  1) {
            lessonsnumber = lol.getInt("TuesdayLessons",0);
            textView.setText("Вторник");}

        if(lessonsnumber>11) {
            editText.setText(lessons[lessonsnumber % 10-1]);
            editText2.setText(lessons[lessonsnumber % 100 / 10-1]);
        }
    }

    @Override
    protected  void onPause() {
        super.onPause();
        Intent intent = getIntent();
        SharedPreferences.Editor editor  =lol.edit();
        if( intent.getIntExtra("Monday",0) ==  1){
        editor.putInt("MondayLessons", lessonsnumber);}
        if( intent.getIntExtra("Tuesday",0) ==  1){
            editor.putInt("TuesdayLessons", lessonsnumber);}
        editor.apply();}
}


