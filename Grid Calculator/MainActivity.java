package com.example.simplecalc;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    private EditText num1, num2;
    private TextView txtRes;
    private Button buttonSub, buttonAdd, buttonDiv, buttonMul;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // Initialize views
        num1 = findViewById(R.id.num1);
        num2 = findViewById(R.id.num2);
        txtRes = findViewById(R.id.txtRes);  // Assuming you have a TextView for displaying result
        buttonAdd = findViewById(R.id.buttonAdd);
        buttonSub = findViewById(R.id.buttonSub);
        buttonMul = findViewById(R.id.buttonMul);
        buttonDiv = findViewById(R.id.buttonDiv);

        // Button click listeners
        buttonAdd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                performOperation("+");
            }
        });

        buttonSub.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                performOperation("-");
            }
        });

        buttonMul.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                performOperation("*");
            }
        });

        buttonDiv.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                performOperation("/");
            }
        });
    }

    // Method to perform calculation based on the operator
    private void performOperation(String operator) {
        String num1Str = num1.getText().toString().trim();
        String num2Str = num2.getText().toString().trim();

        if (!num1Str.isEmpty() && !num2Str.isEmpty()) {
            try {
                double num1Val = Double.parseDouble(num1Str);
                double num2Val = Double.parseDouble(num2Str);
                double result = 0;

                switch (operator) {
                    case "+":
                        result = num1Val + num2Val;
                        break;
                    case "-":
                        result = num1Val - num2Val;
                        break;
                    case "*":
                        result = num1Val * num2Val;
                        break;
                    case "/":
                        if (num2Val != 0) {
                            result = num1Val / num2Val;
                        } else {
                            Toast.makeText(MainActivity.this, "Cannot divide by zero", Toast.LENGTH_SHORT).show();
                            return;
                        }
                        break;
                }
                // Display the result
                txtRes.setText("Result: " + result);

                // Clear the EditText fields after calculation
                num1.setText("");
                num2.setText("");
            } catch (NumberFormatException e) {
                Toast.makeText(MainActivity.this, "Invalid input. Please enter valid numbers.", Toast.LENGTH_SHORT).show();
            }
        } else {
            Toast.makeText(MainActivity.this, "Please enter both numbers.", Toast.LENGTH_SHORT).show();
        }
    }
}
