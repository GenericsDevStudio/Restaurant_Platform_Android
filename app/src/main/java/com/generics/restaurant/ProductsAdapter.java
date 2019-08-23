package com.generics.restaurant;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;
import android.widget.TextView;
import android.widget.Toast;
import com.generics.restaurant.model.Category;
import com.generics.restaurant.model.Dish;
import com.generics.restaurant.model.ServerObject;
import com.generics.restaurant.network.Resources;

public class ProductsAdapter extends RecyclerView.Adapter<ProductsAdapter.ProductHolder> {

    public static boolean cartOpened;
    private View v;
    private ServerObject[] dishesOrCategories;
    private MainActivity currentActivity;

    ProductsAdapter(ServerObject[] dishesOrCategories, MainActivity currentActivity){
        this.dishesOrCategories = dishesOrCategories;
        this.currentActivity = currentActivity;
    }

    static class ProductHolder extends RecyclerView.ViewHolder{

        TextView nameText;
        TextView descrText;
        ImageButton addToCartButton;

        ProductHolder(View itemView) {
            super(itemView);
            nameText = itemView.findViewById(R.id.nameText);
            descrText = itemView.findViewById(R.id.descrTxt);
            addToCartButton = itemView.findViewById(R.id.addToCartButton);
        }
    }

    @Override
    public ProductHolder onCreateViewHolder(ViewGroup viewGroup, int i) {
        v = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.recycler_item, viewGroup, false);
        return new ProductHolder(v);
    }

    @Override
    public void onBindViewHolder(ProductHolder productHolder, int i) {
        if(dishesOrCategories != null){
            if(dishesOrCategories[i].getDescription() != null){
                if(cartOpened){
                    Dish current = ServerObject.toDish(dishesOrCategories[i]);
                    productHolder.nameText.setText(current.getName());
                    productHolder.descrText.setText(current.getDescription());
                    productHolder.addToCartButton.setVisibility(View.VISIBLE);
                    productHolder.addToCartButton.setImageResource(R.drawable.ic_clear_black_24dp);
                    productHolder.addToCartButton.setOnClickListener(event -> {
                        Resources.removeFromCart(i);
                        Toast.makeText(v.getContext(), "Removed from cart", Toast.LENGTH_SHORT).show();
                    });
                }else{
                    Dish current = ServerObject.toDish(dishesOrCategories[i]);
                    productHolder.nameText.setText(current.getName());
                    productHolder.descrText.setText(current.getDescription());
                    productHolder.addToCartButton.setVisibility(View.VISIBLE);
                    productHolder.addToCartButton.setImageResource(R.drawable.ic_add_black_24dp);
                    productHolder.addToCartButton.setOnClickListener(event -> {
                        Resources.addToUserCart(current);
                        Toast.makeText(v.getContext(), "Added to cart", Toast.LENGTH_SHORT).show();
                    });
                }
            }else{
                Category current = ServerObject.toCategory(dishesOrCategories[i]);
                productHolder.nameText.setText(current.getName());
                productHolder.descrText.setText("");
                productHolder.addToCartButton.setVisibility(View.INVISIBLE);
                productHolder.nameText.setOnClickListener(event -> {
                    currentActivity.switchToDishes(current.getId());
                });
            }
        }
    }

    @Override
    public int getItemCount() {
        if(dishesOrCategories != null){
            return dishesOrCategories.length;
        }else{
            return 0;
        }
    }
}
