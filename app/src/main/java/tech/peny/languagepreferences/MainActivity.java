package tech.peny.languagepreferences;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.DialogInterface;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    public void setLanguage(String language){
        SharedPreferences sharedPreferences = this.getSharedPreferences("tech.peny.languagepreferences", Context.MODE_PRIVATE);
        sharedPreferences.edit().putString("language",language);

        TextView textView= findViewById(R.id.textView);

        textView.setText(language);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        new AlertDialog.Builder(this)
                .setIcon(android.R.drawable.ic_btn_speak_now)
                .setTitle("Choose a language")
                .setMessage("Which language would you like use?")
                .setPositiveButton("English", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
//                        Set English
                        setLanguage("English");

                    }
                })
                .setNegativeButton("Spanish", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
//                        set French
                        setLanguage("Spanish");
                    }
                })
                .show();
    }
}