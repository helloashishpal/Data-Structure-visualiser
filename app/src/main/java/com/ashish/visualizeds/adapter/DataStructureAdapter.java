package com.ashish.visualizeds.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.ashish.visualizeds.utils.DataStructureUtil;
import com.ashish.visualizeds.classes.DataStructure;
import com.ashish.visualizeds.databinding.ItemDataStructureBinding;

import java.util.List;

public class DataStructureAdapter extends RecyclerView.Adapter<DataStructureAdapter.DSItemViewHolder> {

    private final List<DataStructure> list;
    private onClickListener listener;
    private final Context context;

    public DataStructureAdapter(Context context, List<DataStructure> list) {
        this.context = context;
        this.list = list;
    }

    @NonNull
    @Override
    public DSItemViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        ItemDataStructureBinding binding = ItemDataStructureBinding.inflate(LayoutInflater.from(parent.getContext()), parent, false);
        return new DSItemViewHolder(binding);
    }

    @Override
    public void onBindViewHolder(@NonNull DSItemViewHolder holder, int position) {
        DataStructure data = list.get(position);
        holder.binding.titleTextView.setText(data.getName());
        holder.binding.difficultyTextView.setText(data.getDifficulty().toString());
        Integer color = DataStructureUtil.listOfColors.get(position % (DataStructureUtil.listOfColors.size()));
        holder.binding.dataStructureIconCard.setCardBackgroundColor(context.getColor(color));
        if (data.getIcon() != null) {
            holder.binding.dataStructureIcon.setImageResource(data.getIcon());
        }
    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    public void setOnClickListener(onClickListener listener) {
        this.listener = listener;
    }

    public class DSItemViewHolder extends RecyclerView.ViewHolder {
        public ItemDataStructureBinding binding;

        public DSItemViewHolder(@NonNull ItemDataStructureBinding binding) {
            super(binding.getRoot());
            this.binding = binding;
            //Animation
//            binding.getRoot().setAnimation(AnimationUtils.loadAnimation(context, R.anim.left_slide_in_fade_in));

            //OnClick Listener for the item View
            binding.getRoot().setOnClickListener(v -> {
                if (listener == null) return;
                listener.onCLick(getAdapterPosition());
            });
        }
    }

    public interface onClickListener {
        void onCLick(int position);
    }
}

