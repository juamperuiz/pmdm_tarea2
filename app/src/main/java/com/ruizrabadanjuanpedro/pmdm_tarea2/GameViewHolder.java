package com.ruizrabadanjuanpedro.pmdm_tarea2;

import androidx.recyclerview.widget.RecyclerView;
import com.squareup.picasso.Picasso;
import com.ruizrabadanjuanpedro.pmdm_tarea2.databinding.GameCardviewBinding;

public class GameViewHolder extends RecyclerView.ViewHolder {

    private final GameCardviewBinding binding;

    public GameViewHolder(GameCardviewBinding binding) {
        super(binding.getRoot());
        this.binding = binding;
    }

    public void bind (GameData game){
        Picasso.get()
                .load(game.getImage())
                .into(binding.image);
        binding.name.setText(game.getName());
        binding.role.setText(game.getRole());
        binding.skill.setText(game.getSkill());
        binding.executePendingBindings(); // Asegura que se apliquen los cambios de inmediato
    }
}

