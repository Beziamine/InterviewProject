package com.example.myproject.ui.main.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.example.myproject.R;
import com.example.myproject.data.model.Model;

import java.util.List;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;
import butterknife.BindView;
import butterknife.ButterKnife;

public class ModelAdapter extends RecyclerView.Adapter<ModelAdapter.ModelHolder> {

    List<Model> Models;
    private Context context;
    ItemClickListener itemClickListener;

    public ModelAdapter(Context context,List<Model> Models) {
        this.Models = Models;
        this.context = context;
    }

    public void setItemClickListener(ModelAdapter.ItemClickListener ItemClickListener) {
        this.itemClickListener = ItemClickListener;
    }

    @NonNull
    @Override
    public ModelHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {

        View view = LayoutInflater.from(context).inflate(R.layout.model_item,viewGroup,false);

        return new ModelHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ModelHolder ModelHolder, int i) {

        Model Model = Models.get(i);
        ModelHolder.appName.setText(Model.getName());
        ModelHolder.appDescription.setText(Model.getShortDesc());

        Glide.with(context)
                .load(Model.getAppIconUrl())
                .centerCrop()
                .into(ModelHolder.appIcon);

        ModelHolder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                if (itemClickListener!=null)
                    itemClickListener.itemOnClick(i);
            }
        });

    }

    @Override
    public int getItemCount() {
        return Models.size();
    }

    class ModelHolder extends RecyclerView.ViewHolder {

        @BindView(R.id.app_name)
        TextView appName;
        @BindView(R.id.app_description)
        TextView appDescription;
        @BindView(R.id.app_icon)
        ImageView appIcon;



        public ModelHolder(@NonNull View itemView) {
            super(itemView);
            ButterKnife.bind(this,itemView);
        }
    }

    public interface ItemClickListener {

        void itemOnClick(int i);
    }
}
