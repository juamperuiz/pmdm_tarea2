package com.ruizrabadanjuanpedro.pmdm_tarea2;

import androidx.recyclerview.widget.RecyclerView;
import com.squareup.picasso.Picasso;
import com.ruizrabadanjuanpedro.pmdm_tarea2.databinding.CharacterCardviewBinding;

/**
 * Clase que representa el ViewHolder del RecyclerView
 * @author Juampe Ruiz
 */
public class CharacterViewHolder extends RecyclerView.ViewHolder {

    private final CharacterCardviewBinding binding;

    /**
     * Constructor de la clase
     * @param binding
     */
    public CharacterViewHolder(CharacterCardviewBinding binding) {
        super(binding.getRoot());
        this.binding = binding;
    }

    /**
     * Método para asignar los datos de un personaje al ViewHolder
     * @param character
     */
    public void bind (CharacterData character){

        // Utilizamos la librería Picasso para traer las imágenes desde un repositorio remoto
        Picasso.get()
                .load(character.getImage())
                .into(binding.image);

        // Hacemos el binding de los datos recibidos para enviarlos a la vista
        binding.name.setText(character.getName());
        binding.role.setText(character.getRole());
        binding.skill.setText(character.getSkill());

        // Asegura que se apliquen los cambios de inmediato
        binding.executePendingBindings();

    }
}

