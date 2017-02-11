package zengshihang.ilovezappos;

import android.content.Context;


import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import android.widget.ImageView;
import android.widget.TextView;
import com.squareup.picasso.Picasso;


import java.util.ArrayList;

import zengshihang.ilovezappos.model.Item;
/**
 * Created by zengshihang on 1/30/17.
 */

public class RecycleAdapter extends RecyclerView.Adapter<RecycleAdapter.ViewHolder> {
    private ArrayList<Item> items;
    private LayoutInflater layoutInflater;
    private Context context;

    public RecycleAdapter(ArrayList<Item> items,Context context){
        this.items= items;
        layoutInflater=LayoutInflater.from(context);
        this.context =context;

    }
    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view =layoutInflater.inflate(R.layout.item_view, parent,false);
        ViewHolder holder = new ViewHolder(view);

        return holder;
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        Item item=this.items.get(position);

        holder.brandView.setText(item.getBrand());
        holder.itemName.setText(item.getName());
        holder.price.setText(item.getPrice());

        Picasso.with(holder.image.getContext()).
                load(item.getThumbnail()).resize(100,100).placeholder(R.drawable.placeholder)
                .into(holder.image);

        holder.image.setOnClickListener(new View.OnClickListener(){

            @Override
            public void onClick(View v) {

            }
        });

    }

    @Override
    public int getItemCount() {
        return items.size();
    }

    class ViewHolder extends RecyclerView.ViewHolder{
        private TextView brandView;
        private TextView itemName;
        private ImageView image;
        private TextView price;


        public ViewHolder(View itemView) {
            super(itemView);

            price=(TextView)itemView.findViewById(R.id.price) ;
            itemName = (TextView)itemView.findViewById(R.id.itemName);
            brandView= (TextView)itemView.findViewById(R.id.brandName);
            image = (ImageView)itemView.findViewById(R.id.imageView);
        }


    }

}
