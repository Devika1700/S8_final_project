package com.example.programmingknowledge.image_to_text.Adapters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.programmingknowledge.image_to_text.Models.Phonetics;
import com.example.programmingknowledge.image_to_text.R;
import com.example.programmingknowledge.image_to_text.ViewHolders.PhoneticViewHolder;

import java.util.List;

public class PhoneticsAdapter extends RecyclerView.Adapter<PhoneticViewHolder> {
    private Context context;
    private List<Phonetics> phoneticsList;

    public PhoneticsAdapter(Context context, List<Phonetics> phoneticsList) {
        this.context = context;
        this.phoneticsList = phoneticsList;
    }

    @NonNull
    @Override
    public PhoneticViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return new PhoneticViewHolder(LayoutInflater.from(context).inflate(R.layout.phonetic_list_items,parent,false ));

    }

    @Override
    public void onBindViewHolder(@NonNull PhoneticViewHolder holder, final int position) {
        holder.textView_phonetic.setText(phoneticsList.get(position).getText());

    }

    @Override
    public int getItemCount() {
        return phoneticsList.size();
    }
}
