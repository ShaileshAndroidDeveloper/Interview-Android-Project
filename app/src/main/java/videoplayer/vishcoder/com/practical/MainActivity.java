package videoplayer.vishcoder.com.practical;

import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.Adapter;
import android.widget.Toolbar;

import java.util.ArrayList;
import java.util.List;

import videoplayer.vishcoder.com.practical.Fragment.NewFragment;
import videoplayer.vishcoder.com.practical.Fragment.SaveFragment;

public class MainActivity extends AppCompatActivity{

    private ViewPager viewPager;
    private TabLayout tabLayout;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

       // SaveFragment fragmentOne = new SaveFragment();
        //fragmentOne.getFragmentManager().beginTransaction().replace(R.id.card_view, fragmentOne).commit();

        viewPager = (ViewPager)findViewById(R.id.viewpager);
        setupViewpager(viewPager);

        tabLayout = (TabLayout)findViewById(R.id.tabs);
        tabLayout.setupWithViewPager(viewPager);

    }

    void setupViewpager(ViewPager viewpager)
    {
        ViewPagerAdapter adapter = new ViewPagerAdapter(getSupportFragmentManager());
        adapter.addFragment(new NewFragment() , "New");
        adapter.addFragment(new SaveFragment() , "Save");


        viewpager.setAdapter(adapter);
    }




    class ViewPagerAdapter extends FragmentPagerAdapter
    {
        private final List<Fragment> mFragmentList = new ArrayList<>();
        private final List<String> mFragmentTitleList = new ArrayList<>();


        public ViewPagerAdapter(FragmentManager manager) {
            super(manager);
        }

        @Override
        public Fragment getItem(int position) {
            return mFragmentList.get(position);
        }

        @Override
        public int getCount() {
            return mFragmentList.size();
        }

        public void addFragment(Fragment fragment, String title) {
            mFragmentList.add(fragment);
            mFragmentTitleList.add(title);
        }

        @Override
        public  CharSequence getPageTitle(int position)
        {
            return mFragmentTitleList.get(position);
        }
    }

}
