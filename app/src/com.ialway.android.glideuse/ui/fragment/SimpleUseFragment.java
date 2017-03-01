package com.ialway.android.glideuse.ui.fragment;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import com.ialway.android.glideuse.R;
import com.ialway.android.glideuse.mgr.GlideMgr;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * Created by dingchao on 2017/3/1.
 */
public class SimpleUseFragment extends Fragment {

    View mRoot;

    @BindView(R.id.sample_iv)
    ImageView mSampleIv;

    @BindView(R.id.sample_default_iv)
    ImageView mSampleDefaultIv;

    @BindView(R.id.sample_thumbnail_iv)
    ImageView mSampleThumbnailIv;

    public static SimpleUseFragment newInstance(Bundle bundle) {
        SimpleUseFragment skinMgrFragment = new SimpleUseFragment();
        skinMgrFragment.setArguments(bundle);
        return skinMgrFragment;
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        mRoot = inflater.inflate(R.layout.frag_simple_use, container, false);
        ButterKnife.bind(this, mRoot);
        return mRoot;
    }

    @Override
    public void onActivityCreated(Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);

        test();
    }

    public void test() {

        GlideMgr.shared().sampleLoad(this.getActivity(), "http://i1.sanwen8.cn/doc/1608/848-160R6095A9-50.jpg", mSampleIv);
        GlideMgr.shared().sampleLoad(this.getActivity(), "http://i1.sanwen8.cn/doc/1608/848-160R6095A8-50.jpg", R.drawable.ic_default, mSampleDefaultIv);
        GlideMgr.shared().sampleLoad(this.getActivity(), "http://i1.sanwen8.cn/doc/1608/848-160R6095A9.jpg", 0.1f, mSampleThumbnailIv);
    }
}
