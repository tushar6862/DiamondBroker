package com.example.diamondbroker.Navigation_F;

import android.content.Context;
import android.os.Bundle;
import android.util.SparseArray;
import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentPagerAdapter;
import androidx.fragment.app.FragmentTransaction;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.viewpager.widget.ViewPager;
import com.example.diamondbroker.Dashboard_F.Inword_F;
import com.example.diamondbroker.Dashboard_F.Outword_F;
import com.example.diamondbroker.Dashboard_F.Summary_F;
import com.example.diamondbroker.R;
import com.google.android.material.tabs.TabLayout;

public class Dashboard_fragment extends Fragment {

    TabLayout tabLayout;
    ViewPager viewPager;

    public Dashboard_fragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState)  {
        // Inflate the layout for this fragment
        View inflate = inflater.inflate(R.layout.fragment_dashboard, container, false);
        tabLayout = inflate.findViewById(R.id.dashboard_tabs);
        viewPager = inflate.findViewById(R.id.viewpager);
        tabLayout.addTab(tabLayout.newTab().setText("Summary"));
        tabLayout.addTab(tabLayout.newTab().setText("Inword"));
        tabLayout.addTab(tabLayout.newTab().setText("Outword"));


        final MyAdapter adapter = new MyAdapter(getContext(),getActivity().getSupportFragmentManager(), tabLayout.getTabCount());
        viewPager.setAdapter(adapter);
        viewPager.setCurrentItem(0);

        viewPager.addOnPageChangeListener(new TabLayout.TabLayoutOnPageChangeListener(tabLayout));

        tabLayout.addOnTabSelectedListener(new TabLayout.OnTabSelectedListener() {
            @Override
            public void onTabSelected(TabLayout.Tab tab) {
                viewPager.setCurrentItem(tab.getPosition());
            }

            @Override
            public void onTabUnselected(TabLayout.Tab tab) {

            }

            @Override
            public void onTabReselected(TabLayout.Tab tab) {

            }
        });

        return inflate;
    }

    public class MyAdapter extends FragmentPagerAdapter{
        SparseArray<Fragment> registeredFragments = new SparseArray<Fragment>();
        private Context myContext;
        int totalTabs;

        public MyAdapter(Context context, FragmentManager supportFragmentManager, int tabCount) {
            super(supportFragmentManager);
            totalTabs = tabCount;
            myContext = context;
        }

        public Fragment getItem(int position) {
            Fragment fragment = null;
            switch (position)
            {
                case 0:
                    fragment = new Summary_F();
                    break;
                case 1:
                    fragment = new Inword_F();
                    break;
                case 2:
                    fragment = new Outword_F();
                    break;
            }
            return fragment;
        }

        @Override
        public int getCount() {
            return totalTabs;
        }
        @Override
        public Object instantiateItem(ViewGroup container, int position) {

            Fragment fragment = (Fragment) super.instantiateItem(container, position);
            registeredFragments.put(position, fragment);
            return fragment;

        }

        @Override
        public void destroyItem(ViewGroup container, int position, Object object) {

//            registeredFragments.remove(position);
            FragmentManager manager = ((Fragment) object).getFragmentManager();
            FragmentTransaction trans = manager.beginTransaction();
            trans.remove((Fragment) object);
            trans.commit();

            super.destroyItem(container, position, object);

        }
    }
}