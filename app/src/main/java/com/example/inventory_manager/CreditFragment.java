package com.example.inventory_manager;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class CreditFragment extends Fragment {

    private View inflatedView;
    private TextView upcTextView;
    private TextView nameTextView;
    private TextView packageSizeTextView;

    private Button searchButton;
    private Button creditButton;
    private Button cancelButton;

    private TextView searchBox;
    private TextView casesInput;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        this.inflatedView = inflater.inflate(R.layout.fragment_credit, container, false);

        upcTextView = (TextView) inflatedView.findViewById(R.id.upcTextView);
        nameTextView = (TextView) inflatedView.findViewById(R.id.itemNameTextView);
        packageSizeTextView = (TextView) inflatedView.findViewById(R.id.packageSizeTextView);

        searchButton = (Button) inflatedView.findViewById(R.id.searchButton);
        creditButton = (Button) inflatedView.findViewById(R.id.creditButton);
        cancelButton = (Button) inflatedView.findViewById(R.id.cancelButton);

        searchBox = (TextView) inflatedView.findViewById(R.id.searchTextBox);
        casesInput = (TextView) inflatedView.findViewById(R.id.casesNumText);

        searchButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (searchBox.getText() != "" && searchBox != null) {
                    APIRequest.get(getActivity(), searchBox.getText().toString(), new VolleyResponseListener() {
                        @Override
                        public void onComplete(JSONArray jsonArray) {
                            for (int i = 0; i < jsonArray.length(); i++) {
                                try {
                                    JSONObject jsonObject = jsonArray.getJSONObject(i);
                                    upcTextView.setText(jsonObject.getString("upc"));
                                    nameTextView.setText(jsonObject.getString("name"));
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

        cancelButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                upcTextView.setText("");
                nameTextView.setText("");
                packageSizeTextView.setText("");
                searchBox.setText("");
                casesInput.setText("");
            }
        });

        creditButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

            }
        });


        return inflatedView;
    }
}
