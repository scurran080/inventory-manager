package com.example.inventory_manager;

import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.Spinner;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;


public class InventorySelectFragment extends Fragment {

    private View inflatedView;
    private Button updateInvBtn;    //leads to update inventory fragment.
    private Button viewInvBtn;      //leads to view inventory fragment.
    private Button clearInvBtn;     //leads to clear inventory fragment.
    private Spinner inventorySpinner;


    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        inflatedView = inflater.inflate(R.layout.inventory_select, container, false);
        updateInvBtn = (Button) inflatedView.findViewById(R.id.updateInventoryBtn);
        viewInvBtn = (Button) inflatedView.findViewById(R.id.viewInventoryBtn);
        clearInvBtn = (Button) inflatedView.findViewById(R.id.clearInventoryBtn);

        String[] locations = new String[]{"sale", "overstock", "display"};

        inventorySpinner = (Spinner) inflatedView.findViewById(R.id.inventorySpinner);
        ArrayAdapter<String> adapter = new ArrayAdapter<String>(this.getActivity(), android.R.layout.simple_spinner_item, locations);
        adapter.setDropDownViewResource(android.R.layout.simple_dropdown_item_1line);
        inventorySpinner.setAdapter(adapter);


        updateInvBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String selectedLocation = inventorySpinner.getSelectedItem().toString();
                getActivity().getSupportFragmentManager().beginTransaction().replace(R.id.fragment_container, new OrderFragment()).commit();
            }
        });

        viewInvBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String selectedLocation = inventorySpinner.getSelectedItem().toString();
                Log.e("selected inv : ", selectedLocation);
                Bundle bundle = new Bundle();
                bundle.putString("inventoryName", selectedLocation);
                ViewInventoryFragment viewInventory = new ViewInventoryFragment();
                viewInventory.setArguments(bundle);
                getActivity().getSupportFragmentManager().beginTransaction().replace(R.id.fragment_container, viewInventory).commit();
            }
        });

        clearInvBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String selectedLocation = inventorySpinner.getSelectedItem().toString();
            }
        });

        return inflatedView;
    }
}
