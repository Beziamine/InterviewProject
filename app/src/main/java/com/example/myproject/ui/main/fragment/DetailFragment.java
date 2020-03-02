package com.example.myproject.ui.main.fragment;

import android.os.Bundle;
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.myproject.R;
import com.example.myproject.data.model.AppImage;
import com.example.myproject.data.model.Model;
import com.example.myproject.data.model.ModelDetail;
import com.example.myproject.data.remote.api.Routes;
import com.example.myproject.ui.main.adapter.AppImagesAdapter;
import com.example.myproject.ui.main.adapter.ModelAdapter;
import com.example.myproject.ui.main.listener.RecyclerItemClickListener;
import com.example.myproject.ui.main.viewModel.MainViewModel;
import com.example.myproject.utils.ViewAction;

import java.util.ArrayList;
import java.util.List;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProviders;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import butterknife.BindView;
import butterknife.ButterKnife;

public class DetailFragment extends Fragment {

    private MainViewModel mainViewModel;

    @BindView(R.id.app_images_recycler)
    RecyclerView appImagesRecycler;

    @BindView(R.id.detail_app_name)
    TextView detailAppName;

    @BindView(R.id.detail_app_ranking)
    TextView detailAppRanking;

    @BindView(R.id.detail_app_long_description)
    TextView detailAppLongDescription;

    private AppImagesAdapter appImagesAdapter;

    private List<AppImage> appImageList;
    private String idDetail;

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        mainViewModel = ViewModelProviders.of(this).get(MainViewModel.class);
        mainViewModel.getListDetailLiveData().observe(this, this::handleResponseList);

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.detail_fragment, container, false);
        ButterKnife.bind(this, view);
        return view;
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        init();
        mainViewModel.getListDetail(Routes.HEADER,idDetail);
    }

    @Override
    public void onResume() {
        super.onResume();

        getView().setFocusableInTouchMode(true);
        getView().requestFocus();
        getView().setOnKeyListener(new View.OnKeyListener() {
            @Override
            public boolean onKey(View v, int keyCode, KeyEvent event) {
                if (event.getAction() == KeyEvent.ACTION_UP && keyCode == KeyEvent.KEYCODE_BACK) {
                    handleClickButtonBackPressed();
                    return true;
                }
                return false;
            }
        });
    }

    private void handleClickButtonBackPressed() {
            ViewAction.replaceFragment(getActivity(), R.id.frame, new MainFragment(), false);
    }


    private void init() {
        Bundle bundle = this.getArguments();
        if (bundle != null) {
            idDetail = bundle.getString("id_detail", "");
        }
    }

    private void handleResponseList(ModelDetail responseRequest) {
        if (responseRequest == null) {
            return;

        }else {

            initRecyclerAppImages(responseRequest.getAppImages());

            detailAppName.setText(responseRequest.getName());
            detailAppRanking.setText(responseRequest.getAverageRatings().toString());
            detailAppLongDescription.setText(responseRequest.getLongDesc());

        }
    }

    private void initRecyclerAppImages(List<AppImage> imageList) {

        appImageList = new ArrayList();
        appImageList = imageList;

        LinearLayoutManager verticalLayoutManagaer = new LinearLayoutManager(getContext(), LinearLayoutManager.HORIZONTAL, false);
        appImagesRecycler.setLayoutManager(verticalLayoutManagaer);
        appImagesAdapter = new AppImagesAdapter(getContext(), appImageList);
        appImagesRecycler.setAdapter(appImagesAdapter);

    }
}

