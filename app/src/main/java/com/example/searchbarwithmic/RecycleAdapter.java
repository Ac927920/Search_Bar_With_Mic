package com.example.searchbarwithmic;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;
import java.util.List;

public class RecycleAdapter extends RecyclerView.Adapter<RecycleAdapter.ViewHolder> {

    private List<Model> listData;

    public RecycleAdapter(List<Model> listData) {
        this.listData = listData;
    }


    @NonNull
    @Override
    public RecycleAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
//        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.search_item, parent, false);
        return null;
    }

    @Override
    public void onBindViewHolder(@NonNull RecycleAdapter.ViewHolder holder, int position) {
        Model model = listData.get(position);
        holder.nameTextView.setText(model.getName());
        holder.addressTextView.setText(model.getAddress());
        holder.contactStatusTextView.setText(model.getContactStatus());
        // Set other views accordingly
    }

    @Override
    public int getItemCount() {
        return listData.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        TextView nameTextView;
        TextView addressTextView;
        TextView contactStatusTextView;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
//            nameTextView = itemView.findViewById(R.id.name);
//            addressTextView = itemView.findViewById(R.id.address);
//            contactStatusTextView = itemView.findViewById(R.id.contact_status);
            // Initialize other views here
        }
    }
}
