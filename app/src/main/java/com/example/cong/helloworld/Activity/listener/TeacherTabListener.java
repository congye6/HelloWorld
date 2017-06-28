package com.example.cong.helloworld.Activity.listener;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;

import com.ashokvarma.bottomnavigation.BottomNavigationBar;
import com.ashokvarma.bottomnavigation.BottomNavigationItem;
import com.example.cong.helloworld.Activity.MainActivity;
import com.example.cong.helloworld.Activity.listener.TabListener;
import com.example.cong.helloworld.R;

import java.util.ArrayList;
import java.util.List;

import layout.PracticeFragment;
import layout.ProfileFragment;
import layout.ScoreStatistic;
import layout.StudentListFragment;

/**
 * Created by cong on 2017-06-02.
 */

public class TeacherTabListener implements TabListener {

    private MainActivity activity;

    private BottomNavigationBar mBottomNavigationBar;

    private Fragment studentListFragment=StudentListFragment.newInstance();

    private Fragment profileFragment=ProfileFragment.newInstance();

    private Fragment practiceFragment=PracticeFragment.newInstance();

    private Fragment scoreFragment= ScoreStatistic.newInstance(38);

    private List<Fragment> fragments=new ArrayList<>();

    public TeacherTabListener(MainActivity activity){
        fragments.add(studentListFragment);
        fragments.add(practiceFragment);
        fragments.add(scoreFragment);
        fragments.add(profileFragment);
        this.activity=activity;
    }

    @Override
    public void onTabSelected(int position) {


        FragmentManager fm = activity.getSupportFragmentManager();
        FragmentTransaction transaction = fm.beginTransaction();
        if(position<fragments.size())
            transaction.replace(R.id.fragment_container, fragments.get(position));

        // 事务提交
        transaction.commit();

    }

    @Override
    public void onTabReselected(int position) {
        FragmentManager fm = activity.getSupportFragmentManager();
        FragmentTransaction transaction = fm.beginTransaction();
        if(position<fragments.size())
            transaction.replace(R.id.fragment_container, fragments.get(position));
        // 事务提交
        transaction.commit();
    }


    /**
     * 设置默认的
     */
    public void setDefaultFragment() {
        FragmentManager fm = activity.getSupportFragmentManager();
        FragmentTransaction transaction = fm.beginTransaction();
        initBottomBar();

        transaction.replace(R.id.fragment_container, studentListFragment);
        transaction.commit();


    }


    private void initBottomBar() {
        mBottomNavigationBar = (BottomNavigationBar) activity.findViewById(R.id.bottom_navigation_bar);
        mBottomNavigationBar.clearAll();
        mBottomNavigationBar.setBackgroundStyle(BottomNavigationBar.BACKGROUND_STYLE_STATIC);
        mBottomNavigationBar.setMode(BottomNavigationBar.MODE_FIXED);
        mBottomNavigationBar.addItem(new BottomNavigationItem(R.drawable.student_list, R.string.student_list)).setActiveColor(R.color.bootstrap_brand_primary).setInActiveColor(R.color.bootstrap_brand_secondary_text)
                .addItem(new BottomNavigationItem(R.drawable.homework, R.string.task).setActiveColorResource(R.color.bootstrap_brand_primary))
                .addItem(new BottomNavigationItem(R.drawable.ic_menu_manage, R.string.statistic).setActiveColorResource(R.color.bootstrap_brand_primary))
                .addItem(new BottomNavigationItem(R.drawable.profile, R.string.profile))//依次添加item,分别icon和名称

                .initialise();//初始化
        mBottomNavigationBar.setTabSelectedListener(this);
    }

    @Override
    public void onTabUnselected(int position) {

    }




}
