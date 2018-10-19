package telephony.internal.android.com.wifi.listView;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import java.util.ArrayList;

import telephony.internal.android.com.wifi.R;

public class ListAdapter extends BaseAdapter {
    private ArrayList<String> lists;
    private Context context;

    public  ListAdapter (Context context, ArrayList lists){
        this.lists =lists;
        this.context = context;
    }
    @Override
    public int getCount() {
        return lists.size();
    }

    @Override
    public Object getItem(int i) {
        return null;
    }

    @Override
    public long getItemId(int i) {
        return 0;
    }

    @Override
    public View getView(int i, View convertView, ViewGroup viewGroup) {
        ViewHolder holder = null;
        if (null == convertView) {
            convertView = View.inflate(context, R.layout.item, null);
            holder = new ViewHolder();
            holder.bt = (TextView) convertView.findViewById(R.id.bt);
            convertView.setTag(holder);
        } else {

            holder = (ViewHolder) convertView.getTag();
        }
        holder.bt.setText(lists.get(i));
        return convertView;
    }
    static class ViewHolder{
        TextView bt;
    }
}
