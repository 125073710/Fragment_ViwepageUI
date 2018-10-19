package telephony.internal.android.com.wifi;

import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.ListAdapter;
import android.widget.ListView;

import java.util.ArrayList;
import java.util.List;

import telephony.internal.android.com.wifi.fragment.ConnectFragment;
import telephony.internal.android.com.wifi.fragment.DisconnectFragmen;
import telephony.internal.android.com.wifi.fragment.SearchFragment;

public class MainActivity extends AppCompatActivity implements View.OnClickListener{
    private  String TAG ="MainActivity";
    private NoScrollViewPager viewpager;
    private Button search,connect,disconnect,forget,enter;
    private PagerAdapter vpadapter;
    private ListView listView;
    public int mPageIdx = 0;
    private List<Fragment> list;
    private ArrayList<String> lists;
    private  ListAdapter adapter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        initView();
        initListView();
        initData();
        Intent intent = getIntent();
        if (intent != null) {
            dealLaunchIntent(intent);
        }
    }

    private void initListView() {
        listView = findViewById(R.id.listview);
        lists = new ArrayList<>();
        lists.add("1");
        lists.add("2");
        lists.add("3");
        lists.add("4");
        lists.add("5");
        lists.add("6");
        lists.add("6");
        lists.add("7");
        lists.add("8");
        lists.add("9");
        lists.add("10");
         adapter = new telephony.internal.android.com.wifi.listView.ListAdapter(this,lists);
        listView.setAdapter(adapter);
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int position, long l) {
                Log.e("yyy","position="+position);
                swithItemPage(position);
            }
        });
    }


    private void initView() {
        viewpager = findViewById(R.id.vp_content);
        search = findViewById(R.id.search);
        connect = findViewById(R.id.connect);
        disconnect = findViewById(R.id.disconnect);
        forget = findViewById(R.id.forget);
        enter = findViewById(R.id.enter);
        search.setOnClickListener(this);
        connect.setOnClickListener(this);
        disconnect.setOnClickListener(this);
        forget.setOnClickListener(this);
        enter.setOnClickListener(this);
    }

    private void initData() {
        list = new ArrayList<>();
        list.add(SearchFragment.INDX,new SearchFragment());
        list.add(ConnectFragment.INDX,new ConnectFragment());
        list.add(DisconnectFragmen.INDX,new DisconnectFragmen());
        vpadapter = new PagerAdapter(getSupportFragmentManager());
        vpadapter.setListFrags(list);
        viewpager.setAdapter(vpadapter);
        viewpager.setNoScroll(false);
        swithItemPage(SearchFragment.INDX);
        swithItemPage(SearchFragment.INDX);
    }
    private void swithItemPage(int index){
        mPageIdx = index;
        viewpager.setCurrentItem(index,false);
    }
    private void dealLaunchIntent(Intent intent) {
        String info = intent.getStringExtra("launch");
        Log.i(TAG, "dealLaunchIntent " + info);
        if("search".equals(info)){
            swithItemPage(SearchFragment.INDX);
        }
    }

    @Override
    protected void onNewIntent(Intent intent) {
        super.onNewIntent(intent);
        if (intent != null) {
            dealLaunchIntent(intent);
        }
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()){
            case R.id.search:
                swithItemPage(SearchFragment.INDX);
                break;
            case R.id.connect:
                swithItemPage(ConnectFragment.INDX);
                break;
            case R.id.disconnect:
                swithItemPage(DisconnectFragmen.INDX);
                break;
        }
    }
}
