package com.example.bevasarlas;

import android.os.Bundle;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class MainActivity extends AppCompatActivity {
    private EditText nameInput, priceInput, quantityInput, unitInput;
    private Button addButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        nameInput = findViewById(R.id.nameInput);
        priceInput = findViewById(R.id.priceInput);
        quantityInput = findViewById(R.id.quantityInput);
        unitInput = findViewById(R.id.unitInput);
        addButton = findViewById(R.id.addButton);

        addButton.setOnClickListener(v -> {
            String name = nameInput.getText().toString();
            String price = priceInput.getText().toString();
            String quantity = quantityInput.getText().toString();
            String unit = unitInput.getText().toString();

            if (validateInputs(name, price, quantity, unit)) {
                Product product = new Product(name, Integer.parseInt(price), Double.parseDouble(quantity), unit);
                addProductToServer(product);
            }
        });
    }

    private boolean validateInputs(String name, String price, String quantity, String unit) {
        if (name.isEmpty() || price.isEmpty() || quantity.isEmpty() || unit.isEmpty()) {
            Toast.makeText(this, "Minden mezőt ki kell tölteni!", Toast.LENGTH_SHORT).show();
            return false;
        }
        try {
            Integer.parseInt(price);
            Double.parseDouble(quantity);
        } catch (NumberFormatException e) {
            Toast.makeText(this, "Helyes formátumban adja meg az adatokat!", Toast.LENGTH_SHORT).show();
            return false;
        }
        return true;
    }

    private void addProductToServer(Product product) {

    }
}
