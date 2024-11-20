package com.example.activity_cycle;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class MainActivity extends AppCompatActivity {

    private String text;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        System.out.println("onCreate()");
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        EditText editText = findViewById(R.id.editText);
        Button btn = findViewById(R.id.button);

        // checking if there is any instance saved if there is set the text back
        if (savedInstanceState != null) {
            String textSaved = savedInstanceState.getString("data");
            if (editText != null) {
                editText.setText(textSaved);
                System.out.println("Text Reloaded");
            }
        }

        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                text = editText.getText().toString();
            }
        });
    }

    @Override
    public void onSaveInstanceState(Bundle outState) {
        super.onSaveInstanceState(outState);

        if (text != null) {
            outState.putString("data", text);
            System.out.println("Text Saved");
        }
    }

    @Override
    protected void onStop() {
        super.onStop();
        System.out.println("onStop()");
    }

    @Override
    protected void onResume() {
        super.onResume();
        System.out.println("onResume()");
    }

    @Override
    protected void onStart() {
        super.onStart();
        System.out.println("onStart()");
    }
}