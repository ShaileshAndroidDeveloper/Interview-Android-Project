package videoplayer.vishcoder.com.practical.Fragment;

import android.content.Context;
import android.database.Cursor;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;

import java.util.ArrayList;

import videoplayer.vishcoder.com.practical.Adapter.MySaveAdapter;
import videoplayer.vishcoder.com.practical.Database.DbHelper;
import videoplayer.vishcoder.com.practical.Model.save;
import videoplayer.vishcoder.com.practical.R;


public class SaveFragment extends Fragment {
    // TODO: Rename parameter arguments, choose names that match
    ListView lstSave;
    ArrayList<save> arrayList;
    MySaveAdapter mySaveAdapter;
    DbHelper dbHelper;
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_save, container, false);
        arrayList = new ArrayList<save>();
        dbHelper = new DbHelper(getContext());
       lstSave = (ListView)view.findViewById(R.id.lstSave);
       getData();
       mySaveAdapter = new MySaveAdapter(getContext(),arrayList);
       lstSave.setAdapter(mySaveAdapter);
       mySaveAdapter.notifyDataSetChanged();

        return view;
    }
    public void getData()
    {
        Cursor cursor = dbHelper.selectRecord_category();
        arrayList = new ArrayList<save>();
        arrayList.clear();
        if(cursor.moveToNext())
        {
            do {
                String Id = cursor.getString(cursor.getColumnIndex(DbHelper.ID));
                String Name = cursor.getString(cursor.getColumnIndex(DbHelper.NAME));
                String Date = cursor.getString(cursor.getColumnIndex(DbHelper.DATE));
                arrayList.add(new save(Id,Name,Date));

            }while (cursor.moveToNext());

        }
        cursor.close();

    }

    @Override
    public void setUserVisibleHint(boolean isVisibleToUser) {
        super.setUserVisibleHint(isVisibleToUser);
        if (isVisibleToUser) {
            // Refresh your fragment here
            getFragmentManager().beginTransaction().detach(this).attach(this).commit();

        }
    }

}
