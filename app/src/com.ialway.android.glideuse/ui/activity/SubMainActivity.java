package com.ialway.android.glideuse.ui.activity;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentActivity;
import android.support.v4.app.FragmentTransaction;

import com.ialway.android.glideuse.R;
import com.ialway.android.glideuse.model.GlideType;
import com.ialway.android.glideuse.ui.fragment.SimpleUseFragment;

/**
 * Created by dingchao on 2017/3/1.
 */
public class SubMainActivity extends FragmentActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sub_main);

        GlideType glideType = this.getIntent().getParcelableExtra(GlideType.INTENT_EXTRA_GLIDETYPE);
        if (glideType != null) {
            fillFragment(glideType);
        }
    }

    public void fillFragment(GlideType glideType) {
        Fragment testFragment = null;
        switch (glideType.getType()) {
            case GlideType.TYPE_SIMPLE:
                testFragment = SimpleUseFragment.newInstance(new Bundle());
                break;
        }
        FragmentTransaction trans = getSupportFragmentManager().beginTransaction();
        trans.replace(R.id.frag_container, testFragment);
        trans.commitAllowingStateLoss();
    }
}
