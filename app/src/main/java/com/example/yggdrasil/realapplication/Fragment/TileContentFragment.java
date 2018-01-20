package com.example.yggdrasil.realapplication.Fragment;

/**
 * Created by Yggdrasil on 12/1/2561.
 */

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.yggdrasil.realapplication.R;

/**
 * Provides UI for the view with Cards.
 */
public class TileContentFragment extends Fragment {

    private String title;
    private int page;

    public static TileContentFragment newInstance(int page, String title) {
        TileContentFragment fragment = new TileContentFragment();
        Bundle args = new Bundle();
        args.putInt("someInt", page);
        args.putString("someTitle", title);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        page = getArguments().getInt("someInt", 0);
        title = getArguments().getString("someTitle");
    }
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        return inflater.inflate(R.layout.item_tile, container, false);
    }
}
