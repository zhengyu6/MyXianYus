package adapter;

import android.support.v4.view.PagerAdapter;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;
import android.widget.ImageView;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by 我 on 2017/7/24.
 */
public class Vip_Adapter extends PagerAdapter {
    private List<ImageView> imgList = new ArrayList<ImageView>();

    public Vip_Adapter(List<ImageView> imgList) {
        this.imgList = imgList;
    }

    @Override
    public int getCount() {
        // TODO Auto-generated method stub
        return Integer.MAX_VALUE;
    }

    @Override
    public boolean isViewFromObject(View arg0, Object arg1) {
        // TODO Auto-generated method stub
        return arg0 == arg1;
    }

    @Override
    public Object instantiateItem(ViewGroup container, int position) {
        // TODO Auto-generated method stub
        int p = position % imgList.size();
        ImageView img = imgList.get(p);
        ViewParent parent = img.getParent();
        if (parent != null) {
            ViewGroup vg = (ViewGroup) parent;
            vg.removeView(img);
        }
        container.addView(imgList.get(p));
        return imgList.get(p);

    }

    @Override
    public void destroyItem(ViewGroup container, int position, Object object) {
        // TODO Auto-generated method stub
        int p = position % imgList.size();
        container.removeView(imgList.get(p));
    }
}
