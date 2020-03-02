package com.example.myproject.ui.main.fragment;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;

import com.example.myproject.R;
import com.example.myproject.data.model.Model;
import com.example.myproject.data.model.Response;
import com.example.myproject.data.remote.api.Routes;
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

public class MainFragment extends Fragment {

    private MainViewModel mainViewModel;

    @BindView(R.id.model_recycler)
    RecyclerView listRecycler;

    private List<Model> list;
    private ModelAdapter modelAdapter;

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        mainViewModel = ViewModelProviders.of(this).get(MainViewModel.class);
        mainViewModel.getListLiveData().observe(this, this::handleResponseList);

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_main, container, false);
        ButterKnife.bind(this, view);
        return view;
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        mainViewModel.getList(Routes.HEADER);
    }

    private void handleResponseList(List<Model> responseRequest) {
        if (responseRequest == null) {
            return;
        }else {

            list = new ArrayList();
            list = responseRequest;

            LinearLayoutManager verticalLayoutManagaer = new LinearLayoutManager(getContext(), LinearLayoutManager.VERTICAL, false);
            listRecycler.setLayoutManager(verticalLayoutManagaer);
            modelAdapter = new ModelAdapter(getContext(), list);
            listRecycler.setAdapter(modelAdapter);
            listRecycler.addOnItemTouchListener(new RecyclerItemClickListener(getContext(), new RecyclerItemClickListener.OnItemClickListener() {

                @Override
                public void onItemClick(View view, int position) {

                    DetailFragment fragment = new DetailFragment();
                    Bundle bundle = new Bundle();
                    bundle.putString("id_detail", String.valueOf(list.get(position).getAppId()));
                    fragment.setArguments(bundle);

                    displayDetailFragment(fragment);

                }
            }));


        }
    }

    private void displayDetailFragment(Fragment fragment) {
        ViewAction.replaceFragment(getActivity(), R.id.frame, fragment, false);

    }
}
