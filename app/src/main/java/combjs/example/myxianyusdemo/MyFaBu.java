package combjs.example.myxianyusdemo;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

/**
 * 发布
 */

public class MyFaBu extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_my_fa_bu);
    }
    @Override
    public void finish() {
        super.finish();
        this.overridePendingTransition(R.anim.activity_close
                ,R.anim.activity_open);
    }
}
