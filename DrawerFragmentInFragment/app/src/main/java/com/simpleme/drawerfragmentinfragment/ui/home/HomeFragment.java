package com.simpleme.drawerfragmentinfragment.ui.home;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;
import androidx.viewpager2.widget.ViewPager2;

import com.google.android.material.tabs.TabLayout;
import com.google.android.material.tabs.TabLayoutMediator;
import com.simpleme.drawerfragmentinfragment.R;

public class HomeFragment extends Fragment {

    protected TabLayout tabLayout;
    protected ViewPager2 viewPager;

    private HomeViewModel homeViewModel;

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        homeViewModel = new ViewModelProvider(this).get(HomeViewModel.class);

        View root = inflater.inflate(R.layout.fragment_home, container, false);

        /** Set up interface. */
        /** > Tab & view pager. */
        tabLayout = root.findViewById(R.id.tab_home);
        viewPager = root.findViewById(R.id.viewpager_home);

        new TabLayoutMediator(tabLayout, viewPager,
                new TabLayoutMediator.TabConfigurationStrategy() {
                    @Override
                    public void onConfigureTab(@NonNull TabLayout.Tab tab, int position) {
                        switch (position) {
                            case 0:
                                tab.setText("About");
                                break;
                            case 1:
                                tab.setText("Contact");
                                break;
                            default:
                                tab.setText(null);
                        }
                    }
                }).attach();

//        final TextView textView = root.findViewById(R.id.text_home);
                homeViewModel.getText().observe(getViewLifecycleOwner(), new Observer<String>() {
                    @Override
                    public void onChanged(@Nullable String s) {
//                textView.setText(s);
                    }
                });
        return root;
    }
}
