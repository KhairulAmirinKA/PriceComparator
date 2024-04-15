package com.khairul.pricecomparator;


import android.annotation.SuppressLint;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;
import java.util.Locale;

import RoomDB.ProductItem;

public class ProductAdapter extends RecyclerView.Adapter<ProductAdapter.ViewHolder> {

    private List<ProductItem> productItemList;

    public ProductAdapter(List<ProductItem> productItemList) {
        this.productItemList = productItemList;
    }


    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.product_item_row_view, parent, false);

        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {

        //1st item of recycler view is in green color
        if (position==0){
            holder.LLProductItemParent.setBackgroundResource(R.color.green);
        }

        //get current product
        ProductItem currentProduct = productItemList.get(position);

        //set the data of current product into recycler view
        holder.TVProductName.setText(currentProduct.getProductName());
        holder.TVProductPrice.setText(String.format(Locale.US,"%.2f", currentProduct.getProductPrice()));
        holder.TVProductQuantity.setText(String.format(Locale.US, "%.4f", currentProduct.getProductQuantity()));
        holder.TVProductPricePerQuantity.setText(String.format(Locale.US, "%.4f", currentProduct.getPricePerQuantity()));

    }

    @Override
    public int getItemCount() {
        return productItemList.size();
    }

    @SuppressLint("NotifyDataSetChanged")
    public void updateData(List<ProductItem> productItemList){

        this.productItemList.clear();
        this.productItemList.addAll(productItemList);
        notifyDataSetChanged();
    }




    public static class ViewHolder extends RecyclerView.ViewHolder{
        LinearLayout LLProductItemParent;
        TextView TVProductName, TVProductPrice, TVProductQuantity, TVProductPricePerQuantity;


        public ViewHolder(@NonNull View itemView) {
            super(itemView);

            LLProductItemParent= itemView.findViewById(R.id.LLProductItemParent);

            TVProductName = itemView.findViewById(R.id.TVProductName);
            TVProductPrice = itemView.findViewById(R.id.TVProductPrice);
            TVProductQuantity= itemView.findViewById(R.id.TVProductQuantity);
            TVProductPricePerQuantity = itemView.findViewById(R.id.TVProductPricePerQuantity);

        }
    }

}
