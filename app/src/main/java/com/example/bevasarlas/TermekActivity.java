package com.example.bevasarlas;

public class TermekActivity extends AppCompatActivity {
    private EditText nameInput, priceInput, quantityInput, unitInput;
    private Button modifyButton, deleteButton, cancelButton;
    private Product currentProduct;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_termek);

        nameInput = findViewById(R.id.nameInput);
        priceInput = findViewById(R.id.priceInput);
        quantityInput = findViewById(R.id.quantityInput);
        unitInput = findViewById(R.id.unitInput);
        modifyButton = findViewById(R.id.modifyButton);
        deleteButton = findViewById(R.id.deleteButton);
        cancelButton = findViewById(R.id.cancelButton);

        long productId = getIntent().getLongExtra("productId", -1);
        fetchProductFromServer(productId);

        modifyButton.setOnClickListener(v -> {
            if (validateInputs()) {
                updateProduct();
            }
        });

        deleteButton.setOnClickListener(v -> {
            new AlertDialog.Builder(this)
                    .setTitle("Megerősítés")
                    .setMessage("Biztosan törölni szeretné?")
                    .setPositiveButton("Igen", (dialog, which) -> deleteProduct())
                    .setNegativeButton("Nem", null)
                    .show();
        });

        cancelButton.setOnClickListener(v -> finish());
    }



    private void populateFields() {
        if (currentProduct != null) {
            nameInput.setText(currentProduct.getName());
            priceInput.setText(String.valueOf(currentProduct.getUnitPrice()));
            quantityInput.setText(String.valueOf(currentProduct.getQuantity()));
            unitInput.setText(currentProduct.getUnit());
        }
    }

    private boolean validateInputs() {

        return true;
    }

    private void updateProduct() {

    }

    private void deleteProduct() {

    }
}
