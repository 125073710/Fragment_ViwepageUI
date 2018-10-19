package telephony.internal.android.com.wifi;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

import java.util.List;

public class PagerAdapter extends FragmentPagerAdapter{

    private List<Fragment> mlists;
    public PagerAdapter(FragmentManager fm) {
        super(fm);
    }
    public void setListFrags(List<Fragment> listFms) {
        this.mlists = listFms;
    }
    @Override
    public Fragment getItem(int position) {
        return mlists.get(position);
    }

    @Override
    public int getCount() {
        return mlists.size();
    }
}
