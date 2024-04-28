package com.example.unconvert;

import android.os.Bundle;
import android.view.View;
import android.widget.TextView;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class MainActivity extends AppCompatActivity {
    private Button button;
    private TextView inputTextView;
    private TextView outputTextView;

    private EditText editText;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        button = findViewById(R.id.button);
        inputTextView = findViewById(R.id.inputTextView);
        outputTextView = findViewById(R.id.outputTextView);
        editText = findViewById(R.id.editText);

        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String input = editText.getText().toString().trim(); // Trim to remove leading and trailing whitespace
                if (!input.isEmpty()) { // Check if input is not empty
                    try {
                        int kg = Integer.parseInt(input);
                        double pound = 2.205 * kg;
                        outputTextView.setText(String.format("The corresponding value in pound is %.2f", pound));
                    } catch (NumberFormatException e) {
                        // Handle the case where the input is not a valid integer
                        Toast.makeText(MainActivity.this, "Invalid input. Please enter a valid number.", Toast.LENGTH_SHORT).show();
                    }
                } else {
                    // Handle the case where input is empty
                    Toast.makeText(MainActivity.this, "Please enter a number.", Toast.LENGTH_SHORT).show();
                }
            }
        });

        // Apply window insets listener for edge-to-edge functionality
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            insets = insets.consumeSystemWindowInsets(); // Consume insets to prevent default handling
            v.setPadding(insets.getSystemWindowInsetLeft(), insets.getSystemWindowInsetTop(),
                    insets.getSystemWindowInsetRight(), insets.getSystemWindowInsetBottom());
            return insets;
        });
    }

}