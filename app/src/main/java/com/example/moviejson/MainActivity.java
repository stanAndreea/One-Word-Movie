package com.example.moviejson;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {
    public static final String EXTRA_NAME_URL="name movie url";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        final EditText nameEditText = findViewById(R.id.edit_text_name_movie);

        Button buttonName = findViewById(R.id.button_name_movie);

        buttonName.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String nameMovie = nameEditText.getText().toString().trim().toLowerCase();
                Intent intent = new Intent(MainActivity.this, MovieActivity.class);
                intent.putExtra(EXTRA_NAME_URL, nameMovie);
                startActivity(intent);
            }
        });
    }

}
