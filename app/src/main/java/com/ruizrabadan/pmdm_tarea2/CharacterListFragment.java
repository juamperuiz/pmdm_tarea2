package com.ruizrabadan.pmdm_tarea2;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.ruizrabadan.pmdm_tarea2.databinding.CharacterListFragmentBinding;

import java.util.ArrayList;

public class CharacterListFragment extends Fragment {

    private CharacterListFragmentBinding binding; // Binding para el layout
    private ArrayList<CharacterData> characters; // Lista de juegos
    private CharacterRecyclerViewAdapter adapter; // Adaptador del RecyclerView

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {
        // Inflar el layout utilizando el binding
        binding = CharacterListFragmentBinding.inflate(inflater, container, false);
        return binding.getRoot();
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        // Inicializa la lista de juegos
        loadCharacters(); // Cargar los juegos (puedes implementar esta función para obtener datos)

        // Configurar el RecyclerView
        adapter = new CharacterRecyclerViewAdapter(characters, getActivity());
        binding.characterRecyclerview.setLayoutManager(new LinearLayoutManager(getContext()));
        binding.characterRecyclerview.setAdapter(adapter);


    }

    // Método para cargar juegos (puedes implementar tu lógica aquí)
    private void loadCharacters() {

        characters = new ArrayList<CharacterData>();

        // Llenar la lista con datos de videojuegos
        characters.add(new CharacterData(
                "@res/drawable/portrait_mario",
                "Mario",
                "Aliado",
                "Lorem ipsum",
                "Saltar"
        ));

    }


    @Override
    public void onStart() {
        super.onStart();
        // Cambia el título del ActionBar
        if (getActivity() != null) {
            ((AppCompatActivity) getActivity()).getSupportActionBar().setTitle(R.string.Characters);
        }
    }
}
