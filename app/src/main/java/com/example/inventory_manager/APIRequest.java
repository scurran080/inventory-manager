package com.example.inventory_manager;


import android.content.Context;
import android.util.Log;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonObjectRequest;
import com.android.volley.toolbox.Volley;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;

public abstract class APIRequest {

    public static void apiGet(Context context, String key) {
        final ArrayList<Product> products = new ArrayList<>();
        String url = "3000/food/"; //TODO: re-add in ip address after push
        url += key;
        RequestQueue requestQueue = Volley.newRequestQueue(context);
        JsonObjectRequest jsonObjectRequest = new JsonObjectRequest(
                Request.Method.GET,
                url,
                null,
                new Response.Listener<JSONObject>() {
                    @Override
                    public void onResponse(JSONObject response) {
                        try {
                            JSONArray jsonArray = response.getJSONArray("rows");
                            for(int i = 0; i < jsonArray.length(); i++){
                                JSONObject item = jsonArray.getJSONObject(i);
                                String name = item.getString("name");
                                String upc = item.getString("upc");
                                String description = item.getString("description");
                                int packagesize = item.getInt("packagesize");
                                Product product = new Product(name, upc, description, packagesize);
                                products.add(product);
                                //logging for debugging TODO: remove later
                                Log.e("item name : " , name);
                                Log.e("item upc : " , upc);
                                Log.e("item desc : " , description);
                                Log.e("item pkgsize : " , Integer.toString(packagesize));
                            }
                        } catch (JSONException e) {
                            e.printStackTrace();
                        }
                    }
                }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                Log.e("Rest Response", error.toString());
            }
        }
        );
        requestQueue.add(jsonObjectRequest);
        //debugging
        //TODO: return the array of products in order to populate the fragment.
        for(int i = 0; i < products.size();i++){
            System.out.println(products.get(i));
        }
    }
}
