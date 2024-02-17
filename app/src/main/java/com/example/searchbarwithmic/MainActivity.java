package com.example.searchbarwithmic;
// MainActivity.java
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    private RecyclerView recyclerView;
    private RecycleAdapter adapter;
    private List<Model> modelList;
    private List<Model> filteredList;

    private EditText searchText;
    private ImageView searchMic;

    private boolean isMicIcon = true; // Flag to track the current icon state

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        recyclerView = findViewById(R.id.recycleView);
        modelList = new ArrayList<>();
        filteredList = new ArrayList<>();

        searchText = findViewById(R.id.search_text);
        searchMic = findViewById(R.id.search_mic);

        // Initialize adapter with empty list
        adapter = new RecycleAdapter(filteredList); // Use filteredList instead of modelList
        recyclerView.setAdapter(adapter);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));

        // Example: Update RecyclerView with dummy data
        updateRecyclerViewWithDummyData();

        searchText.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {
            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                filter(s.toString());
                searchMic.setImageResource(R.drawable.ic_close); // Change icon back to mic
                isMicIcon = false;
                if (s.toString().isEmpty()){
                    searchMic.setImageResource(R.drawable.ic_mic); // Change icon back to mic
                    isMicIcon = true;
                }
            }

            @Override
            public void afterTextChanged(Editable s) {
            }
        });
    }

    private void updateRecyclerViewWithDummyData() {
        // Clear existing data
        modelList.clear();
        filteredList.clear();

        modelList.add(new Model("Motif Masjid", "J6M9+G8H, Block B, Connaught Place, New Delhi, Delhi 110001, India", "Not Available"));
        modelList.add(new Model("Auliya Masjid مسجد", "12881, K Block, L-21, Connaught Cir, Block K, Connaught Place, New Delhi, Delhi 110001, India", "+911123365358"));
        // Add new dummy data

        // Add more data as needed

        // Initially, show all data in filteredList
        filteredList.addAll(modelList);

        // Notify adapter about data change
        adapter.notifyDataSetChanged();
    }

    private void filter(String searchText) {
        filteredList.clear();
        for (Model model : modelList) {
            if (model.getName().toLowerCase().contains(searchText.toLowerCase())) {
                filteredList.add(model);
            }
        }
        adapter.notifyDataSetChanged();
    }

    public void onMicIconClick(View view) {
        if (isMicIcon) {
            // Handle mic icon click
            // Set flag to true
            // For example, start voice input
        } else {
            // Handle close icon click
            searchText.setText(""); // Clear EditText
            searchMic.setImageResource(R.drawable.ic_mic); // Change icon back to mic
            isMicIcon = true; // Set flag to true
        }
    }
}
