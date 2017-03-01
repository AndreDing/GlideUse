package com.ialway.android.glideuse.ui;

import android.app.Activity;
import android.os.Bundle;
import android.widget.ImageView;

import com.ialway.android.glideuse.R;
import com.ialway.android.glideuse.mgr.GlideMgr;

import butterknife.BindView;
import butterknife.ButterKnife;

public class MainActivity extends Activity {

    @BindView(R.id.sample_iv)
    ImageView mSampleIv;

    @BindView(R.id.sample_default_iv)
    ImageView mSampleDefaultIv;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);

        test();
    }

    public void test() {
        GlideMgr.shared().sampleLoad(this, "https://timgsa.baidu.com/timg?image&quality=80&size=b9999_10000&sec=1488291440236&di=1c5781c0bb697e2bf55b0625f109f346&imgtype=0&src=http%3A%2F%2Fc.hiphotos.baidu.com%2Fzhidao%2Fpic%2Fitem%2Ffaf2b2119313b07e6077d3bc0ad7912396dd8cb8.jpg", 0.1f, mSampleIv);
        GlideMgr.shared().sampleLoad(this, "https://timgsa.baidu.com/timg?image&quality=80&size=b9999_10000&sec=1488291473646&di=b8e06e79243c452d09b051a7b9c72fa3&imgtype=0&src=http%3A%2F%2Fimg04.tooopen.com%2Fimages%2F20121026%2Ftooopen_201210261227413300.jpg", R.drawable.ic_default, mSampleDefaultIv);
    }
}
