package com.example.fields;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.DialogInterface;
import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RatingBar;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    private EditText pass;
    private Button btn, btn_alert, act_change;
    private RatingBar rating;
    private TextView text_show;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        addListenerOnButton();
    }

    public void addListenerOnButton(){
        pass = (EditText)findViewById(R.id.editTextPassword);
        btn = (Button)findViewById(R.id.button);
        btn_alert = (Button)findViewById(R.id.alert);
        act_change = (Button)findViewById(R.id.act_change);

        rating = (RatingBar)findViewById(R.id.ratingBar);
        text_show = (TextView)findViewById(R.id.textView);

        act_change.setOnClickListener(
                new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        Intent intent = new Intent(".SecondActivity");
                        startActivity(intent);
                    }
                }
        );

        rating.setOnRatingBarChangeListener(
                new RatingBar.OnRatingBarChangeListener() {
                    @Override
                    public void onRatingChanged(RatingBar ratingBar, float rating, boolean fromUser) {
                        text_show.setText("Значение: " + String.valueOf(rating));
                    }
                }
        );

        btn.setOnClickListener(
                new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        btn.setBackgroundColor(Color.RED);
                        btn.setText("ГОТОВО");
                        Toast.makeText(
                                MainActivity.this, pass.getText(),
                                Toast.LENGTH_SHORT
                        ).show();
                    }
                }
        );

        btn_alert.setOnClickListener(
                new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
//                        btn2.setBackgroundColor(Color.RED);
//                        btn2.setText("ОК");
//                        Toast.makeText(
//                                MainActivity.this, "Мы всё поменяли",
//                                Toast.LENGTH_SHORT
//                        ).show();
                        AlertDialog.Builder a_builder = new AlertDialog.Builder(MainActivity.this);
                        a_builder.setMessage("Вы хотите закрыть приложение ?")
                                .setCancelable(false)
                                .setPositiveButton("Да", new DialogInterface.OnClickListener() {
                                    @Override
                                    public void onClick(DialogInterface dialog, int which) {
                                        finish();
                                    }
                                })
                                .setNegativeButton("Нет", new DialogInterface.OnClickListener() {
                                    @Override
                                    public void onClick(DialogInterface dialog, int which) {
                                        dialog.cancel();
                                    }
                                });
                        AlertDialog alert = a_builder.create();
                        alert.setTitle("Закрытие приложения");
                        alert.show();
                    }
                }
        );
    }
}