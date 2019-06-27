package isrsd.sumit.com.isrsd.slider;

import android.content.Context;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.Toast;

import com.android.volley.Request;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.ImageLoader;
import com.android.volley.toolbox.StringRequest;


import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import isrsd.sumit.com.isrsd.R;


public class Frag3 extends Fragment {

    private static final String TAG = "StaticFragment";
    ImageView icon;

    public static Frag3 newInstance(String text) {

        Frag3 f = new Frag3();
        Bundle b = new Bundle();
        b.putString("msg", text);

        f.setArguments(b);

        return f;
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater
                .inflate(R.layout.frag3, container, false);
        icon = (ImageView) view.findViewById(R.id.icon);
        //  get_image();
        return view;
    }

    public void onStart() {
        super.onStart();
        if (isNetworkAvailable()) {
            //   get_image();
        } else {
            Toast.makeText(getActivity(), "No Internet Connection Available", Toast.LENGTH_LONG).show();
        }
    }

    /*   public void get_image() {
           StringRequest history = new StringRequest(Request.Method.GET, Const.Get_IMG_SLIDER,
                   new Response.Listener<String>() {
                       public void onResponse(String response) {
                           Log.d(TAG, response);
                           Log.d(TAG, "#@###" + response);
                           try {

                               JSONObject jsonObject = new JSONObject(response);
                               JSONArray jarray = jsonObject.getJSONArray("Data");
                               for (int i = 0; i <= jarray.length(); i++) {
                                   JSONObject jsonObject1 = jarray.getJSONObject(2);
                                   String urlimage = jsonObject1.getString("Imagepath");
                                   String urlimage1 = urlimage.replaceAll(" ", "%20");
                                   ImageLoader imageLoader = AppController.getInstance().getImageLoader();
                                   imageLoader.get(urlimage1, new ImageLoader.ImageListener() {
                                       @Override
                                       public void onResponse(ImageLoader.ImageContainer response, boolean isImmediate) {
                                           icon.setImageBitmap(response.getBitmap());
                                       }

                                       @Override
                                       public void onErrorResponse(VolleyError error) {

                                       }
                                   });

                               }

                           } catch (JSONException e) {
                               // e.printStackTrace();
                           }

                       }
                   }, new Response.ErrorListener() {
               @Override
               public void onErrorResponse(VolleyError error) {
               }
           });
           AppController.getInstance().addToRequestQueue(history, "history");
       }*/
    public boolean isNetworkAvailable() {
        ConnectivityManager login_cm = (ConnectivityManager) getActivity().getSystemService(Context.CONNECTIVITY_SERVICE);
        NetworkInfo activeNetworkInfo = login_cm.getActiveNetworkInfo();
        return activeNetworkInfo != null && activeNetworkInfo.isConnected();
    }


}
