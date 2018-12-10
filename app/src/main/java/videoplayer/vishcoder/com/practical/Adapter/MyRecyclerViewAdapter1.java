package videoplayer.vishcoder.com.practical.Adapter;

import android.content.Context;
import android.graphics.Color;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import java.util.List;

import videoplayer.vishcoder.com.practical.MainActivity;
import videoplayer.vishcoder.com.practical.Model.Item1;
import videoplayer.vishcoder.com.practical.R;

public class MyRecyclerViewAdapter1 extends RecyclerView.Adapter<MyRecyclerViewAdapter1.MyViewHolder> {
    private List<Item1> item1List;
    public class MyViewHolder extends RecyclerView.ViewHolder {
        public TextView title;

        public MyViewHolder(View view) {
            super(view);
            title = (TextView) view.findViewById(R.id.title);
        }
    }


    public MyRecyclerViewAdapter1(List<Item1> item1List) {
        this.item1List = item1List;
    }

    @Override
    public MyViewHolder onCreateViewHolder(ViewGroup parent, final int viewType) {
        View itemView = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.list_item1, parent, false);



        return new MyViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(final MyViewHolder holder, final int position) {
        final Item1 element = item1List.get(position);
        final Item1 item1 = item1List.get(position);
        int x = item1List.get(position).getCheck();

        holder.title.setText(item1.getTitle());

        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                  String s = item1List.get(position).getTitle();
              int x = item1List.get(position).getCheck();

              if(x==0)
              {
                  item1List.set(position,new Item1(s,1));
                  holder.title.setBackgroundColor(Color.GREEN);
                  notifyDataSetChanged();
              }
              else
              {
                  item1List.set(position,new Item1(s,0));
                  holder.title.setBackgroundColor(Color.RED);
                  notifyDataSetChanged();

              }
            }
        });

    }

    @Override
    public int getItemCount() {
        return item1List.size();
    }
    @Override
    public  int getItemViewType(int position)
    {
        return position;
    }
}