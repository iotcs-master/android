package com.simpleme.drawerfragmentinfragment;

import androidx.lifecycle.ViewModelProvider;
import androidx.lifecycle.ViewModelProviders;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import com.simpleme.drawerfragmentinfragment.ui.gallery.GalleryFragment;
import com.simpleme.drawerfragmentinfragment.ui.home.HomeFragment;
import com.simpleme.drawerfragmentinfragment.ui.slideshow.SlideshowFragment;

public class MainFragment extends Fragment {

    private MainViewModel maimViewModel;

    public static MainFragment newInstance() {
        return new MainFragment();
    }

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {
        maimViewModel = new ViewModelProvider(this).get(MainViewModel.class);
        View root = inflater.inflate(R.layout.fragment_main, container, false);

        /** Set up interface. */
        /** > Button. */
        Button buttonHome = root.findViewById(R.id.button_home);
        buttonHome.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                HomeFragment homeFragment = new HomeFragment();
                getActivity().getSupportFragmentManager()
                        .beginTransaction()
                        .replace(((ViewGroup)getView().getParent()).getId(), homeFragment)
                        .addToBackStack("MainFragment")
                        .commit();
            }
        });

        Button buttonGallery = root.findViewById(R.id.button_gallery);
        buttonGallery.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                GalleryFragment galleryFragment = new GalleryFragment();
                getActivity().getSupportFragmentManager()
                        .beginTransaction()
                        .replace(((ViewGroup)getView().getParent()).getId(), galleryFragment)
                        .addToBackStack("MainFragment")
                        .commit();
            }
        });

        Button buttonSlideshow = root.findViewById(R.id.button_slideshow);
        buttonSlideshow.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                SlideshowFragment slideshowFragment = new SlideshowFragment();
                getActivity().getSupportFragmentManager()
                        .beginTransaction()
                        .replace(((ViewGroup)getView().getParent()).getId(), slideshowFragment)
                        .addToBackStack("MainFragment")
                        .commit();
            }
        });

        return root;
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        // TODO: Use the ViewModel
    }

}
