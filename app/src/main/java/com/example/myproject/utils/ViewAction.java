package com.example.myproject.utils;

import android.app.Activity;

import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

public class ViewAction {


    public static void addFragment(Activity activity, int fragmentContainer, Fragment fragment) {
        FragmentManager fragmentManager = ((FragmentActivity) activity).getSupportFragmentManager();
        FragmentTransaction fragmentTransaction = fragmentManager
                .beginTransaction();
        fragmentTransaction.add(fragmentContainer,
                fragment).commit();

    }

    public static void replaceFragment(Activity activity, int fragmentContainer, Fragment fragment, boolean addToBackStack) {
        FragmentManager fragmentManager = ((FragmentActivity) activity).getSupportFragmentManager();
        FragmentTransaction fragmentTransaction = fragmentManager
                .beginTransaction();
        if (addToBackStack) {
            fragmentTransaction.replace(fragmentContainer,
                    fragment).addToBackStack(null).commit();
        } else {
            fragmentTransaction.replace(fragmentContainer,
                    fragment).commit();
        }
    }
}
