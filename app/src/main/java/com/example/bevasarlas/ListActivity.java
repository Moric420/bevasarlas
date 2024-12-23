package com.example.bevasarlas;

public class ListActivity extends AppCompatActivity {
    private ListView productList;
    private Button backButton;
    private ArrayAdapter<String> adapter;
    private List<Product> products = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list);

        productList = findViewById(R.id.productList);
        backButton = findViewById(R.id.backButton);

        backButton.setOnClickListener(v -> finish());

        productList.setOnItemClickListener((parent, view, position, id) -> {
            Product selectedProduct = products.get(position);
            Intent intent = new Intent(this, TermekActivity.class);
            intent.putExtra("productId", selectedProduct.getId());
            startActivity(intent);
        });

        fetchProductsFromServer();
    }



    private void updateListView() {
        List<String> productDescriptions = new ArrayList<>();
        for (Product product : products) {
            productDescriptions.add(product.getName() + "\n" +
                    "Egységár: " + product.getUnitPrice() + " Ft\n" +
                    "Mennyiség: " + product.getQuantity() + " " + product.getUnit() + "\n" +
                    "Bruttó ár: " + product.getTotalPrice() + " Ft");
        }

        adapter = new ArrayAdapter<>(this, android.R.layout.simple_list_item_1, productDescriptions);
        productList.setAdapter(adapter);
    }
}

