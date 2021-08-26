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

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class OrderFragment extends Fragment {

    private Button searchButton;
    private View inflatedView;
    private TextView upcSearchText;
    private TextView upcTextView;
    private Button cancelButton;
    private Button orderButton;
    private TextView packageSizeTextLabel;
    private TextView itemNameLabel;
    private EditText searchTextBox;
    private TextView packageSizeTextView;
    private TextView productName;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        this.inflatedView = inflater.inflate(R.layout.fragment_order, container, false);

        //TODO: rename variables for easier understanding
        searchButton = (Button) inflatedView.findViewById(R.id.searchButton);
        upcSearchText = (TextView) inflatedView.findViewById(R.id.searchTextBox);
        upcTextView = (TextView) inflatedView.findViewById(R.id.itemNameTextView);
        cancelButton = (Button) inflatedView.findViewById(R.id.cancelButton);
        orderButton = (Button) inflatedView.findViewById(R.id.orderButton);
        packageSizeTextLabel = (TextView) inflatedView.findViewById(R.id.packSizeTextLabel);
        itemNameLabel = (TextView) inflatedView.findViewById(R.id.itemNameLabel);
        searchTextBox = (EditText) inflatedView.findViewById(R.id.searchTextBox);
        packageSizeTextView = (TextView) inflatedView.findViewById(R.id.packageSizeTextView);
        productName = (TextView) inflatedView.findViewById(R.id.itemNameView);


        //Clear all filled out fields for another search
        cancelButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                upcTextView.setText("");
                upcSearchText.setText("");
                productName.setText("");
                packageSizeTextView.setText("");
            }
        });
        //TODO: Link with a bankend database for products. Match products using UPC and return relevant data.
        searchButton.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                if (searchTextBox.getText() != null || searchTextBox.getText().toString() != "") {
                    APIRequest.get(getActivity(), searchTextBox.getText().toString(), new VolleyResponseListener() {
                        @Override
                        public void onComplete(JSONArray jsonArray) {
                            for (int i = 0; i < jsonArray.length(); i++) {
                                try {
                                    JSONObject jsonObject = jsonArray.getJSONObject(i);
                                    productName.setText(jsonObject.getString("name"));
                                    upcTextView.setText(jsonObject.getString("upc"));
                                    packageSizeTextView.setText(Integer.toString(jsonObject.getInt("packagesize")));
                                } catch (JSONException e) {
                                    e.printStackTrace();
                                }

                            }
                        }
                    });
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
