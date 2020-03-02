package com.example.myproject.ui.main.activity;

import android.os.Bundle;
import android.widget.FrameLayout;

import com.example.myproject.R;
import com.example.myproject.ui.main.fragment.MainFragment;
import com.example.myproject.utils.ViewAction;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProviders;
import butterknife.BindView;
import butterknife.ButterKnife;

public class AcivityMain extends AppCompatActivity {

    @BindView(R.id.frame)
    FrameLayout frameLayout;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);
        initView();

//        billViewModel.getPinpadLiveData().observe(this, this::handlePinpadResponse);

    }

    private void initView() {
        displayMainFragment();
    }

    private void displayMainFragment() {
        ViewAction.replaceFragment(this, frameLayout.getId(), new MainFragment(), false);

    }

    public void displayDetailFragment(Fragment fragment) {
        ViewAction.replaceFragment(this, frameLayout.getId(), fragment, false);

    }

}
