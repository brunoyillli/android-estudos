package io.github.brunoyillli.abas;

import androidx.appcompat.app.AppCompatActivity;
import androidx.viewpager.widget.ViewPager;

import android.os.Bundle;

import com.ogaclejapan.smarttablayout.SmartTabLayout;
import com.ogaclejapan.smarttablayout.utils.v4.FragmentPagerItemAdapter;
import com.ogaclejapan.smarttablayout.utils.v4.FragmentPagerItems;

import io.github.brunoyillli.abas.fragment.EmAltaFragment;
import io.github.brunoyillli.abas.fragment.HomeFragment;
import io.github.brunoyillli.abas.fragment.InscricoesFragment;

public class MainActivity extends AppCompatActivity {

    private SmartTabLayout smartTabLayout;
    private ViewPager viewPager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        smartTabLayout = findViewById(R.id.viewPagerTab);
        viewPager = findViewById(R.id.viewPager);

        getSupportActionBar().setElevation(0);

        FragmentPagerItemAdapter adapter = new FragmentPagerItemAdapter(
                getSupportFragmentManager(),
                FragmentPagerItems.with(this)
                        .add("Home", HomeFragment.class)
                        .add("Inscrições", InscricoesFragment.class)
                        .add("Em alta", EmAltaFragment.class)
                        .create()
        );

        viewPager.setAdapter(adapter);
        smartTabLayout.setViewPager(viewPager);
    }
}