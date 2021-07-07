package com.example.dawadoz.ui.view.adapter;

import android.annotation.SuppressLint;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.paging.PagedListAdapter;
import androidx.recyclerview.widget.DiffUtil;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.example.dawadoz.R;
import com.example.dawadoz.db.entity.searchproducts.DtResult;

public class ItemAdapter extends PagedListAdapter<DtResult, ItemAdapter.ItemHolder> {

    private Context context;
    public ItemAdapter() {
        super(itemCallback);
    }

    @NonNull
    @Override
    public ItemHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        context = parent.getContext();
        return new ItemHolder(LayoutInflater.from(context).inflate(R.layout.rv_product_item, parent, false));
    }

    @SuppressLint("SetTextI18n")
    @Override
    public void onBindViewHolder(@NonNull ItemHolder holder, int position) {
        DtResult dtResult = getItem(position);
        if (dtResult != null) {
            Glide.with(context).asBitmap().load("http://DawaDoz.com/" + dtResult.getProductImage()).into(holder.getImgViewProduct());
            holder.getTxtViewProductName().setText(dtResult.getProductNameEN());
            holder.getTxtViewUsedFor().setText(context.getText(R.string.used_for) + ": " + dtResult.getUsedFor());
            holder.getTxtViewCompanyName().setText(context.getText(R.string.company_name) + ": " + dtResult.getCompanyName());
            holder.getTxtViewTotalPrice().setText(context.getText(R.string.total_price) + ": " + dtResult.getTotalPrice());
        } else {
            Toast.makeText(context, R.string.null_item, Toast.LENGTH_LONG).show();
        }
    }

    public static DiffUtil.ItemCallback<DtResult> itemCallback = new DiffUtil.ItemCallback<DtResult>() {

        @Override
        public boolean areItemsTheSame(@NonNull DtResult oldItem, @NonNull DtResult newItem) {
            return oldItem.getProductID() == newItem.getProductID();
        }

        @SuppressLint("DiffUtilEquals")
        @Override
        public boolean areContentsTheSame(@NonNull DtResult oldItem, @NonNull DtResult newItem) {
            return oldItem.equals(newItem);
        }
    };

    class ItemHolder extends RecyclerView.ViewHolder {

        private ImageView imgViewProduct;
        private TextView txtViewProductName, txtViewUsedFor, txtViewCompanyName, txtViewTotalPrice;

        public ItemHolder(@NonNull View itemView) {
            super(itemView);
        }

        public ImageView getImgViewProduct() {
            if (imgViewProduct == null) {
                imgViewProduct = itemView.findViewById(R.id.imgViewProduct);
            }
            return imgViewProduct;
        }

        public TextView getTxtViewProductName() {
            if (txtViewProductName == null) {
                txtViewProductName = itemView.findViewById(R.id.txtViewProductName);
            }
            return txtViewProductName;
        }

        public TextView getTxtViewUsedFor() {
            if (txtViewUsedFor == null) {
                txtViewUsedFor = itemView.findViewById(R.id.txtViewUsedFor);
            }
            return txtViewUsedFor;
        }

        public TextView getTxtViewCompanyName() {
            if (txtViewCompanyName == null) {
                txtViewCompanyName = itemView.findViewById(R.id.txtViewCompanyName);
            }
            return txtViewCompanyName;
        }

        public TextView getTxtViewTotalPrice() {
            if (txtViewTotalPrice == null) {
                txtViewTotalPrice = itemView.findViewById(R.id.txtViewTotalPrice);
            }
            return txtViewTotalPrice;
        }
    }
}
