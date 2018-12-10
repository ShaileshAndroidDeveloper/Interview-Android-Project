package videoplayer.vishcoder.com.practical.Adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;

import videoplayer.vishcoder.com.practical.Model.save;
import videoplayer.vishcoder.com.practical.R;

public class MySaveAdapter extends BaseAdapter {
    Context context;
    ArrayList<save> arrayList;
    public MySaveAdapter(Context context,ArrayList<save> arrayList)
    {
        this.context = context;
        this.arrayList = arrayList;

    }

    private static class ViewHolder {
        public final LinearLayout rootView;
        public final TextView txtId;
        public final TextView txtName;
        public final TextView txtDate;

        private ViewHolder(LinearLayout rootView, TextView txtId, TextView txtName, TextView txtDate) {
            this.rootView = rootView;
            this.txtId = txtId;
            this.txtName = txtName;
            this.txtDate = txtDate;
        }

        public static ViewHolder create(LinearLayout rootView) {
            TextView txtId = (TextView)rootView.findViewById( R.id.txtId );
            TextView txtName = (TextView)rootView.findViewById( R.id.txtName );
            TextView txtDate = (TextView)rootView.findViewById( R.id.txtDate );
            return new ViewHolder( rootView, txtId, txtName, txtDate );
        }
    }
    @Override
    public int getCount() {
        return arrayList.size();
    }

    @Override
    public Object getItem(int position) {
        return null;
    }

    @Override
    public long getItemId(int position) {
        return 0;
    }
    private LayoutInflater mInflater;
    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        mInflater = (LayoutInflater)context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        final ViewHolder vh;
        if ( convertView == null ) {

            View view = mInflater.inflate( R.layout.listitem_save, parent, false );
            vh = ViewHolder.create( (LinearLayout)view );
            view.setTag( vh );
        } else {
            vh = (ViewHolder)convertView.getTag();
        }

        Object item = getItem( position );
        final String Id = arrayList.get(position).getId().toString();
        final String Name = arrayList.get(position).getName().toString();
        final String Date = arrayList.get(position).getDate().toString();
        vh.txtId.setText(arrayList.get(position).getId().toString());
        vh.txtName.setText(arrayList.get(position).getName().toString());
        vh.txtDate.setText(arrayList.get(position).getDate().toString());

        vh.rootView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(context,Id + Name + Date, Toast.LENGTH_LONG).show();
            }
        });
        // TODOBind your data to the views here

        return vh.rootView;
    }
}

