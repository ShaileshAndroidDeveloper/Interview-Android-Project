package videoplayer.vishcoder.com.practical.Fragment;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.Toast;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

import videoplayer.vishcoder.com.practical.Adapter.MyRecyclerViewAdapter1;
import videoplayer.vishcoder.com.practical.Adapter.MySaveAdapter;
import videoplayer.vishcoder.com.practical.Database.DbHelper;
import videoplayer.vishcoder.com.practical.Model.Item1;
import videoplayer.vishcoder.com.practical.R;



public class NewFragment extends Fragment {
    DbHelper dbHelper;
    MySaveAdapter mySaveAdapter;
    public List<Item1> item1List;
    public List<Item1> item2List;
    public List<Item1> item3List;
    public List<Item1> item4List;
    private RecyclerView recyclerView1;
    private RecyclerView recyclerView2;
    private RecyclerView recyclerView3;
    private RecyclerView recyclerView4;
    private MyRecyclerViewAdapter1 mAdapter1;
    private Calendar calendar;
    private SimpleDateFormat dateFormat;
    private String date;
    String s;

    // TODO: Rename parameter arguments, choose names that match

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.fragment_new, container, false);
        //Item111111
        dbHelper = new DbHelper(getContext());
        recyclerView1 = (RecyclerView) view.findViewById(R.id.recycler_view1);
        recyclerView2 = (RecyclerView) view.findViewById(R.id.recycler_view2);
        recyclerView3 = (RecyclerView) view.findViewById(R.id.recycler_view3);


        recyclerView4 = (RecyclerView) view.findViewById(R.id.recycler_view4);
        Button btnSave = (Button)view.findViewById(R.id.btnSave);
        Button btnClear = (Button)view.findViewById(R.id.btnClear);
        calendar = Calendar.getInstance();
        dateFormat = new SimpleDateFormat("MM/dd/yyyy");
        date = dateFormat.format(calendar.getTime());

        Item1();


        btnSave.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                s="";

                for(int x=0;x<item1List.size();x++){
                    if(item1List.get(x).getCheck() == 1)
                    {
                        s=s+item1List.get(x).getTitle()+",";
                    }
                }
                for(int x=0;x<item2List.size();x++){
                    if(item2List.get(x).getCheck() == 1)
                    {
                        s=s+item2List.get(x).getTitle()+",";
                    }
                }
                for(int x=0;x<item3List.size();x++){
                    if(item3List.get(x).getCheck() == 1)
                    {
                        s=s+item3List.get(x).getTitle()+",";
                    }
                }
                for(int x=0;x<item4List.size();x++){
                    if(item4List.get(x).getCheck() == 1)
                    {
                        s=s+item4List.get(x).getTitle()+",";
                    }
                }

                insert();
                Toast.makeText(getActivity(),s,Toast.LENGTH_LONG).show();
            }
        });
        btnClear.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Item1();

            }
        });


        return view;
    }

    private void Item1() {
        s="";
        item1List = new ArrayList<>();
         item2List = new ArrayList<>();
        item3List = new ArrayList<>();
        item4List = new ArrayList<>();
        mAdapter1 = new MyRecyclerViewAdapter1(item1List);
        // RecyclerView.LayoutManager mLayoutManager1 = new LinearLayoutManager(getContext());
        RecyclerView.LayoutManager mLayoutManager1 = (new LinearLayoutManager(getContext(), LinearLayoutManager.HORIZONTAL, false));
        recyclerView1.setLayoutManager(mLayoutManager1);
        recyclerView1.setItemAnimator(new DefaultItemAnimator());
        recyclerView1.setAdapter(mAdapter1);


//Item2222
        recyclerView1.setNestedScrollingEnabled(false);

        mAdapter1 = new MyRecyclerViewAdapter1(item2List);
        // RecyclerView.LayoutManager mLayoutManager2 = new LinearLayoutManager(getContext());
        RecyclerView.LayoutManager mLayoutManager2 = (new LinearLayoutManager(getContext(), LinearLayoutManager.HORIZONTAL, false));
        recyclerView2.setLayoutManager(mLayoutManager2);
        recyclerView2.setItemAnimator(new DefaultItemAnimator());
        recyclerView2.setAdapter(mAdapter1);
        recyclerView2.setNestedScrollingEnabled(false);



        //Item333
        //   recyclerView1.setNestedScrollingEnabled(false);

        mAdapter1 = new MyRecyclerViewAdapter1(item3List);
        // RecyclerView.LayoutManager mLayoutManager2 = new LinearLayoutManager(getContext());
        RecyclerView.LayoutManager mLayoutManager3 = (new LinearLayoutManager(getContext(), LinearLayoutManager.HORIZONTAL, false));
        recyclerView3.setLayoutManager(mLayoutManager3);
        recyclerView3.setItemAnimator(new DefaultItemAnimator());
        recyclerView3.setAdapter(mAdapter1);
        recyclerView3.setNestedScrollingEnabled(false);



        //Item333
        //   recyclerView1.setNestedScrollingEnabled(false);


        mAdapter1 = new MyRecyclerViewAdapter1(item4List);
        // RecyclerView.LayoutManager mLayoutManager2 = new LinearLayoutManager(getContext());
        RecyclerView.LayoutManager mLayoutManager4 = (new LinearLayoutManager(getContext(), LinearLayoutManager.HORIZONTAL, false));
        recyclerView4.setLayoutManager(mLayoutManager4);
        recyclerView4.setItemAnimator(new DefaultItemAnimator());
        recyclerView4.setAdapter(mAdapter1);
        recyclerView4.setNestedScrollingEnabled(false);
        // Inflate the layout for this fragment


        Item1 item1 = new Item1("A",0);
        item1List.add(item1);
        item1 = new Item1("B",0);
        item1List.add(item1);
        item1 = new Item1("C",0);
        item1List.add(item1);
        item1 = new Item1("D",0);
        item1List.add(item1);
        item1 = new Item1("E",0);
        item1List.add(item1);
        item1 = new Item1("F",0);
        item1List.add(item1);
        item1 = new Item1("G",0);
        item1List.add(item1);
        item1 = new Item1("H",0);
        item1List.add(item1);
        item1 = new Item1("I",0);
        item1List.add(item1);
        item1 = new Item1("J",0);
        item1List.add(item1);

        item1 = new Item1("1",0);
        item2List.add(item1);
        item1 = new Item1("2",0);
        item2List.add(item1);

        item1 = new Item1("3",0);
        item2List.add(item1);

        item1 = new Item1("4",0);
        item2List.add(item1);

        item1 = new Item1("5",0);
        item2List.add(item1);

        item1 = new Item1("6",0);
        item2List.add(item1);

        item1 = new Item1("7",0);
        item2List.add(item1);

        item1 = new Item1("8",0);
        item2List.add(item1);

        item1 = new Item1("9",0);
        item2List.add(item1);

        item1 = new Item1("10",0);
        item2List.add(item1);


        item1 = new Item1("K",0);
        item3List.add(item1);
        item1 = new Item1("L",0);
        item3List.add(item1);

        item1 = new Item1("M",0);
        item3List.add(item1);

        item1 = new Item1("N",0);
        item3List.add(item1);

        item1 = new Item1("O",0);
        item3List.add(item1);

        item1 = new Item1("P",0);
        item3List.add(item1);

        item1 = new Item1("Q",0);
        item3List.add(item1);

        item1 = new Item1("R",0);
        item3List.add(item1);

        item1 = new Item1("S",0);
        item3List.add(item1);

        item1 = new Item1("T",0);
        item3List.add(item1);



        item1 = new Item1("11",0);
        item4List.add(item1);
        item1 = new Item1("12",0);
        item4List.add(item1);

        item1 = new Item1("13",0);
        item4List.add(item1);

        item1 = new Item1("14",0);
        item4List.add(item1);

        item1 = new Item1("15",0);
        item4List.add(item1);

        item1 = new Item1("16",0);
        item4List.add(item1);

        item1 = new Item1("17",0);
        item4List.add(item1);

        item1 = new Item1("18",0);
        item4List.add(item1);

        item1 = new Item1("19",0);
        item4List.add(item1);

        item1 = new Item1("20",0);
        item4List.add(item1);
           mAdapter1.notifyDataSetChanged();
         //  mySaveAdapter.notifyDataSetChanged();
    }


    public  void  insert()
    {
       Toast.makeText(getContext(),s+ "" + date , Toast.LENGTH_LONG).show();
      dbHelper.insertRecord_Category(s,date);

    }
        //    mAdapter.notifyDataSetChanged();
}


