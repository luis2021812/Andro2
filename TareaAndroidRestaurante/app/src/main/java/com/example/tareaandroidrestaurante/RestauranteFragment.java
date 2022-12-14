package com.example.tareaandroidrestaurante;

import android.content.Context;
import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.ArrayList;
import java.util.List;

/**
 * A fragment representing a list of Items.
 */
public class RestauranteFragment extends Fragment {
    RecyclerView recyclerView;
    MyRestauranteRecyclerViewAdapter adapterRestaurante;
    List<Restaurante> restauranteList;
    OnListFragmentInteractionListener mlistener = null;
    // TODO: Customize parameter argument names
    private static final String ARG_COLUMN_COUNT = "column-count";
    // TODO: Customize parameters
    private int mColumnCount = 1;

    /**
     * Mandatory empty constructor for the fragment manager to instantiate the
     * fragment (e.g. upon screen orientation changes).
     */
    public RestauranteFragment() {
    }

    // TODO: Customize parameter initialization
    @SuppressWarnings("unused")
    public static RestauranteFragment newInstance(int columnCount) {
        RestauranteFragment fragment = new RestauranteFragment();
        Bundle args = new Bundle();
        args.putInt(ARG_COLUMN_COUNT, columnCount);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        if (getArguments() != null) {
            mColumnCount = getArguments().getInt(ARG_COLUMN_COUNT);
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_item_list, container, false);

        // Set the adapter
        if (view instanceof RecyclerView) {
            Context context = view.getContext();
            recyclerView = (RecyclerView) view;
            if (mColumnCount <= 1) {
                recyclerView.setLayoutManager(new LinearLayoutManager(context));
            } else {
                recyclerView.setLayoutManager(new GridLayoutManager(context, mColumnCount));
            }
            restauranteList = new ArrayList<>();
            restauranteList.add(new Restaurante("Pizzeria Carlos", "https://thumbs.dreamstime.com/z/pizzer%C3%ADa-fachada-exterior-de-pizza-house-bistro-la-casa-pizzas-que-sirve-comida-y-panader%C3%ADa-italiana-edificios-aislados-con-188036110.jpg", 4.0f, "Madrid, Espa??a"));
            restauranteList.add(new Restaurante("Tacos", "https://www.guatemala.com/fotos/2019/02/Las-FLautas-885x500.jpg", 5.0f, "Guatemala"));
            restauranteList.add(new Restaurante("Pollos hermanos", "https://diariocorreo.pe/resizer/cF50yIa59aClOBnoiPrDS-KJUMg=/1200x800/smart/filters:format(jpeg):quality(75)/arc-anglerfish-arc2-prod-elcomercio.s3.amazonaws.com/public/22MXXRALXJDKBIDP5IPUJMDV3U.jpg", 3.50f, "New Mexico"));

            adapterRestaurante = new MyRestauranteRecyclerViewAdapter(getContext(),restauranteList, mlistener);

            recyclerView.setAdapter(adapterRestaurante);
        }
        return view;
    }

    public interface OnListFragmentInteractionListener {
        void onListFragmentInteraction(Restaurante item);

    }
}