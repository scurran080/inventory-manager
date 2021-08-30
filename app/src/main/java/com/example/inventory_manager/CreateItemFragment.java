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

import org.json.JSONException;
import org.json.JSONObject;

public class CreateItemFragment extends Fragment {

    private View inflatedView;
    private Button createItemButton;
    private TextView upcTextBox;
    private TextView nameTextBox;
    private TextView descriptionTextBox;
    private TextView packageSizeNumBox;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        inflatedView = inflater.inflate(R.layout.create_item_fragment, container, false);
        createItemButton = (Button) inflatedView.findViewById(R.id.createItemButton);
        upcTextBox = (TextView) inflatedView.findViewById(R.id.upcTextBox);
        nameTextBox = (TextView) inflatedView.findViewById(R.id.nameTextBox);
        descriptionTextBox = (TextView) inflatedView.findViewById(R.id.descriptionTextBox);
        packageSizeNumBox = (TextView) inflatedView.findViewById(R.id.packageSizeNumBox);

        createItemButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (okayCreation()) {
                    JSONObject jsonObject = new JSONObject();
                    try {
                        jsonObject.put("upc", upcTextBox.getText());
                        jsonObject.put("name", nameTextBox.getText());
                        jsonObject.put("description", descriptionTextBox.getText());
                        jsonObject.put("packagesize", Integer.parseInt(packageSizeNumBox.getText().toString()));
                        APIRequest.post(getActivity(), jsonObject);
                        upcTextBox.setText("");
                        nameTextBox.setText("");
                        descriptionTextBox.setText("");
                        packageSizeNumBox.setText("");
                    } catch (JSONException e) {
                        e.printStackTrace();
                    }
                }
            }
        });
        return inflatedView;
    }

    public boolean okayCreation() {
        if (!(upcTextBox.getText() != null && upcTextBox.getText() != "" && upcTextBox.getText().length() > 1)) {
            return false;
        } else if (!(nameTextBox.getText() != null && nameTextBox.getText().length() > 1)) {
            return false;
        } else if (!(packageSizeNumBox.getText() != null && packageSizeNumBox.getText().length() > 1)) {
            return false;
        } else if (!(descriptionTextBox.getText() != null && descriptionTextBox.getText().length() > 1)) {
            return false;
        } else {
            try {
                Double.parseDouble(packageSizeNumBox.getText().toString());
            } catch (NumberFormatException e) {
                e.printStackTrace();
                return false;
            }
            return true;
        }
    }
}
