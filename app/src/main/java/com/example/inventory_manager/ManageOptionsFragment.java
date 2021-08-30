package com.example.inventory_manager;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

public class ManageOptionsFragment extends Fragment {

    private View inflatedView;
    private Button createItemButton;
    private Button deleteItemButton;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        inflatedView = inflater.inflate(R.layout.manage_options_fragment, container, false);
        createItemButton = (Button) inflatedView.findViewById(R.id.createItemButton);
        deleteItemButton = (Button) inflatedView.findViewById(R.id.deleteItemButton);

        createItemButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                getActivity().getSupportFragmentManager().beginTransaction().replace(R.id.fragment_container, new CreateItemFragment()).commit();
            }
        });

        deleteItemButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

            }
        });

        return inflatedView;
    }
}
