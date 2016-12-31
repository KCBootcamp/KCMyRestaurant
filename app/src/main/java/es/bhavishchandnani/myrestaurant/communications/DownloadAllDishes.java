package es.bhavishchandnani.myrestaurant.communications;


import android.content.Context;

import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;

import java.lang.ref.WeakReference;

import es.bhavishchandnani.myrestaurant.R;

public class DownloadAllDishes {

    private WeakReference<Context> context;

    public DownloadAllDishes(Context context) {
        this.context = new WeakReference<Context>(context);
    }

    public void execute(final CommunicationsInterface communication){
        RequestQueue requestQueue = Volley.newRequestQueue(context.get());
        String url = context.get().getString(R.string.dishes_url);

        StringRequest request = new StringRequest(url,
                new Response.Listener<String>() {
                    @Override
                    public void onResponse(String response) {
                        communication.getDataSuccess(response);
                    }
                },
                new Response.ErrorListener() {
                    @Override
                    public void onErrorResponse(VolleyError error) {
                        communication.getDataFailed();
                    }
                }
        );


        requestQueue.add(request);
    }
}
