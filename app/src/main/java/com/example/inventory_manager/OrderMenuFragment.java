package com.example.inventory_manager;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import java.util.Calendar;
import java.util.Date;

public class OrderMenuFragment extends Fragment {

    private View inflatedView;
    private Button backButton;
    private Button createOrderButton;
    private Button editOrderButton;
    private Button sendOrderButton;
    private Date currentTime;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        inflatedView = inflater.inflate(R.layout.order_options_fragment, container, false);
        backButton = (Button) inflatedView.findViewById(R.id.backButton);
        createOrderButton = (Button) inflatedView.findViewById(R.id.createOrderButton);
        editOrderButton = (Button) inflatedView.findViewById(R.id.editOrderButton);
        sendOrderButton = (Button) inflatedView.findViewById(R.id.sendOrderButton);

        backButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //getActivity().getSupportFragmentManager().beginTransaction().replace(R.id.fragment_container,);
            }
        });

        createOrderButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                currentTime = Calendar.getInstance().getTime();
                Bundle bundle = new Bundle();
                bundle.putString("orderDate", currentTime.toString());
                OrderFragment orderFragment = new OrderFragment();
                orderFragment.setArguments(bundle);
                getActivity().getSupportFragmentManager().beginTransaction().replace(R.id.fragment_container, orderFragment).commit();
            }
        });

        editOrderButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

            }
        });

        sendOrderButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

            }
        });

        return inflatedView;
    }
}
