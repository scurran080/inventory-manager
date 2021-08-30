package com.example.inventory_manager;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

public class ViewInventoryFragment extends Fragment {
    private View inflatedView;
    private String inventoryName;
    private TextView inventoryNameLabel;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        this.inflatedView = inflater.inflate(R.layout.view_inventory_fragment, container, false);
        inventoryNameLabel = (TextView) inflatedView.findViewById(R.id.inventoryNameTextLabel);
        this.inventoryName = this.getArguments().getString("inventoryName");
        inventoryNameLabel.setText(this.inventoryName);
        return inflatedView;
    }
}
