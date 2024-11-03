package com.ruizrabadanjuanpedro.pmdm_tarea2;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.ViewGroup;
import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;
import java.util.ArrayList;
import com.ruizrabadanjuanpedro.pmdm_tarea2.databinding.GameCardviewBinding;
import android.view.View;

public class CharacterRecyclerViewAdapter extends RecyclerView.Adapter<CharacterViewHolder> {

    private final ArrayList<CharacterData> games;
    private final Context context;

    public CharacterRecyclerViewAdapter(ArrayList<CharacterData> games, Context context){
        this.games = games;
        this.context = context;
    }

    // Método que crea el ViewHolder
    @NonNull
    @Override
    public CharacterViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        GameCardviewBinding binding = GameCardviewBinding.inflate(
                LayoutInflater.from(parent.getContext()), parent,false
        );
        return new CharacterViewHolder(binding);
    }

//    Método para enlazar datos con ek ViewHolder
    @Override
    public void onBindViewHolder(@NonNull CharacterViewHolder holder, int position) {
        CharacterData currentGame = this.games.get(position);
        holder.bind(currentGame);

//        Manejar el evento de clic
        holder.itemView.setOnClickListener(view -> itemClicked(currentGame, view));
    }

    @Override
    public int getItemCount() {
        return games.size();
    }

    private void itemClicked(CharacterData currentGame, View view) {

        // Llama a la función gameClicked de MainActivity, pasando la vista
        ((MainActivity) context).gameClicked(currentGame, view);

    }
}
