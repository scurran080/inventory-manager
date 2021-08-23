package com.example.inventory_manager;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

public class OrderFragment extends Fragment {

    private Button searchButton;
    private View inflatedView;
    private TextView upcSearchText;
    private TextView upcTextView;
    private Button cancelButton;
    private Button orderButton;
    private TextView packagesizeText;
    private TextView itemName;
    private EditText searchTextBox;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        this.inflatedView = inflater.inflate(R.layout.fragment_order, container, false);

        searchButton = (Button) inflatedView.findViewById(R.id.searchButton);
        upcSearchText = (TextView) inflatedView.findViewById(R.id.searchTextBox);
        upcTextView = (TextView) inflatedView.findViewById(R.id.upcTextView);
        cancelButton = (Button) inflatedView.findViewById(R.id.orderCancelBtn);
        orderButton = (Button) inflatedView.findViewById(R.id.inventoryOrderBtn);
        packagesizeText = (TextView) inflatedView.findViewById(R.id.packSizeText);
        itemName = (TextView) inflatedView.findViewById(R.id.itemNameText);
        searchTextBox = (EditText) inflatedView.findViewById(R.id.searchTextBox);


        //Clear all filled out fields for another search
        cancelButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                upcTextView.setText("");
                upcSearchText.setText("");
            }
        });
        //TODO: Link with a bankend database for products. Match products using UPC and return relevant data.
        searchButton.setOnClickListener(new View.OnClickListener(){
            public void onClick(View v){
                if(searchTextBox.getText() != null || searchTextBox.getText().toString() != ""){
                    if(searchTextBox.getText().toString() != ""){
                        APIRequest.apiGet(getActivity(),searchTextBox.getText().toString());
                        //String[] res = APIRequest.apiGet(upcSearchText.toString());
                        //System.out.println(res);


                    }
                }
            }
        });

        //not functional yet
        //need to think of how this should be implemented.
        //create an order form based off of data returned from the database?
        orderButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

            }
        });
        return inflatedView;
    }
}
