package com.example.myproject.ui.main.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.example.myproject.R;
import com.example.myproject.data.model.AppImage;
import com.example.myproject.data.model.Model;

import java.util.List;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;
import butterknife.BindView;
import butterknife.ButterKnife;

public class AppImagesAdapter extends RecyclerView.Adapter<AppImagesAdapter.ModelHolder> {

    List<AppImage> AppImages;
    private Context context;


    public AppImagesAdapter(Context context,List<AppImage> Models) {
        this.AppImages = Models;
        this.context = context;
    }



    @NonNull
    @Override
    public AppImagesAdapter.ModelHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {

        View view = LayoutInflater.from(context).inflate(R.layout.model_app_images,viewGroup,false);

        return new AppImagesAdapter.ModelHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull AppImagesAdapter.ModelHolder ModelHolder, int i) {

        AppImage appImage = AppImages.get(i);


        Glide.with(context)
                .load(appImage.getImageUrl())
                .centerCrop()
                .into(ModelHolder.imageApp);

    }

    @Override
    public int getItemCount() {
        return AppImages.size();
    }

    class ModelHolder extends RecyclerView.ViewHolder {

        @BindView(R.id.image_app)
        ImageView imageApp;



        public ModelHolder(@NonNull View itemView) {
            super(itemView);
            ButterKnife.bind(this,itemView);
        }
    }


}

