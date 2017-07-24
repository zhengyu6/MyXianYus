package fragment;

import android.app.Fragment;
import android.os.Bundle;
import android.os.Handler;
import android.support.annotation.Nullable;
import android.support.v4.view.PagerAdapter;
import android.support.v4.view.ViewPager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.ScrollView;

import java.util.ArrayList;
import java.util.List;

import adapter.Vip_Adapter;
import combjs.example.myxianyusdemo.R;


/**
 * User:张晓辉
 * 首页
 * viewpager轮播
 */
public class HomeFragment extends Fragment {

    private ViewPager vip;
    //小圆点
    private ImageView[] bottomImg;
    private List<ImageView> imgList = new ArrayList<>();
    private LinearLayout layout;
    private int currentItem = 0;
    private boolean isAuto = true;
    private boolean isTouch = false;
    private int[] imgs = {R.drawable.cc, R.drawable.cc, R.drawable.cc, R.drawable.cc};
    private List<String> list_s = new ArrayList<>();
    private ListView lv;
    private ScrollView scll;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.fragment_home, container, false);
        vip = (ViewPager) v.findViewById(R.id.vip_one);
        layout = (LinearLayout) v.findViewById(R.id.layout);
        scll = (ScrollView) v.findViewById(R.id.scll);
        lv = (ListView) v.findViewById(R.id.lv);
        initView();
        return v;
    }

    private void initView() {
        for (int i = 0; i < 30; i++) {
            list_s.add("我是Item");

        }
        ArrayAdapter arrayAdapter = new ArrayAdapter(
                getActivity(), android.R.layout.simple_list_item_1,
                list_s);
        lv.setAdapter(arrayAdapter);


        for (int i = 0; i < imgs.length; i++) {
            View v = View.inflate(getActivity(), R.layout.viewitem, null);
            ImageView img = (ImageView) v.findViewById(R.id.img1);
            img.setImageResource(imgs[i]);
            imgList.add(img);
        }
        Vip_Adapter adapter = new Vip_Adapter(imgList);
        vip.setAdapter(adapter);
        thread.start();
    }

    Thread thread = new Thread(new Runnable() {
        @Override
        public void run() {
            // TODO Auto-generated method stub
            while (isAuto) {
                try {
                    thread.sleep(3000);
                    handler.sendEmptyMessage(0);
                } catch (InterruptedException e) {
                    // TODO Auto-generated catch block
                    e.printStackTrace();
                }
            }
        }
    });
    Handler handler = new Handler() {
        public void handleMessage(android.os.Message msg) {
            if (msg.what == 0) {
                //如果手动滑动时不处理
                if (isTouch) {
                    return;
                }
                //如果是自动轮播时，让代表显示页面的指示位置+1;
                currentItem++;
                vip.setCurrentItem(currentItem);
            }
        }

        ;
    };

    @Override
    public void onHiddenChanged(boolean hidden) {
        super.onHiddenChanged(hidden);
        if (!hidden){
            lv.setFocusable(false);
        }
    }
}
