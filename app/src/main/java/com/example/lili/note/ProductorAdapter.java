package com.example.lili.note;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.List;

public class ProductorAdapter extends  RecyclerView.Adapter<ProductorAdapter.ProductViewHolder>{

    private Context mCtx;
    private List<Product> productList;

    public ProductorAdapter(Context mCtx, List<Product> productList) {
        this.mCtx = mCtx;
        this.productList = productList;
    }

    @Override
    public ProductViewHolder onCreateViewHolder( ViewGroup viewGroup, int i) {

        LayoutInflater inflater = LayoutInflater.from(mCtx);
        View view = inflater.inflate(R.layout.listpost,null);
        return new ProductViewHolder(view);
    }

    @Override
    public void onBindViewHolder( ProductViewHolder productViewHolder, int i) {
        Product product = productList.get(i);
        productViewHolder.textViewTitle.setText(product.getTitle());
        productViewHolder.textViewDesc.setText(product.getShortdesc());
        productViewHolder.textViewPrice.setText(String.valueOf(product.getPrice()));

    }

    @Override
    public int getItemCount() {
        return productList.size();
    }

    class ProductViewHolder extends RecyclerView.ViewHolder{
        TextView textViewTitle, textViewDesc, textViewPrice,textViewContact;

        public ProductViewHolder( View itemView) {
            super(itemView);
            textViewTitle = itemView.findViewById(R.id.textViewTitle);
            textViewDesc = itemView.findViewById(R.id.textViewShortDesc);
            textViewPrice = itemView.findViewById(R.id.textViewPrice);

        }
    }


}
