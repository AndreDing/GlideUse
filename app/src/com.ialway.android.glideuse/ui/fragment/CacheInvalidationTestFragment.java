package com.ialway.android.glideuse.ui.fragment;

import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.support.annotation.Nullable;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import com.ialway.android.glideuse.R;
import com.ialway.android.glideuse.mgr.FileMgr;
import com.ialway.android.glideuse.mgr.GlideMgr;
import com.ialway.android.glideuse.ui.MainApp;
import com.ialway.android.glideuse.ui.base.BaseFragment;
import com.ialway.android.glideuse.util.AndroidUtil;
import com.ialway.android.glideuse.util.IOUtil;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * Created by dingchao on 2017/3/2.
 */
public class CacheInvalidationTestFragment extends BaseFragment {

    public static final String LOG_TAG = "CacheInvalidation";

    View mRoot;

    @BindView(R.id.cache_iv_one)
    ImageView mCacheIvOne;

    @BindView(R.id.cache_iv_two)
    ImageView mCacheIvTwo;

    @BindView(R.id.cache_iv_three)
    ImageView mCacheIvThree;

    private Handler mHandler = new Handler() {

        @Override
        public void handleMessage(Message msg) {
            super.handleMessage(msg);

            test();
        }
    };

    public static CacheInvalidationTestFragment newInstance(Bundle bundle) {
        CacheInvalidationTestFragment cacheInvalFragment = new CacheInvalidationTestFragment();
        cacheInvalFragment.setArguments(bundle);
        return cacheInvalFragment;
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        mRoot = inflater.inflate(R.layout.frag_cache_invalidation, container, false);
        ButterKnife.bind(this, mRoot);
        return mRoot;
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);

        initPics();
    }

    public void test() {
        GlideMgr.shared().loadCacheWithCustom(this.getActivity(), new File(FileMgr.shared().getPicPath("test_one.jpg")), mCacheIvOne);
        GlideMgr.shared().loadCacheWithCustom(this.getActivity(), "https://a-ssl.duitang.com/uploads/item/201603/24/20160324113541_YKtdS.thumb.700_0.jpeg", mCacheIvTwo, AndroidUtil.getVersionCode(MainApp.shared()));
        // 取消磁盘缓存测试方式：有网进入此界面，关闭网络、停止应用后，再次进入此界面
        GlideMgr.shared().loadWithNoDiskCache(this.getActivity(), "http://image.bitauto.com/dealer/news/100071745/92d94ea2-6609-48a5-997e-775cec00f6af.jpg", mCacheIvThree);
    }

    public void initPics() {

        mHandler.post(new Runnable() {
            @Override
            public void run() {
                InputStream src = null;
                OutputStream dst = null;
                try {
                    src = MainApp.shared().getAssets().open("pic/test_one.jpg");

                    final String localPath = FileMgr.shared().getPicPath("test_one.jpg");
                    final File dstFile = new File(localPath);
                    final File dstFileTemp = new File(localPath + ".tmp");
                    // do copy
                    if (!dstFile.exists()) {
                        dstFileTemp.getParentFile().mkdirs();
                        dst = new FileOutputStream(dstFileTemp);
                        IOUtil.copy(src, dst, 4096 * 8);
                        dstFileTemp.renameTo(dstFile);
                        Log.i(LOG_TAG, "copy file:" + localPath);
                    }
                } catch (IOException e) {
                    e.printStackTrace();
                } finally {
                    IOUtil.closeQuietly(src);
                    IOUtil.closeQuietly(dst);
                }
                mHandler.sendEmptyMessage(0);
            }
        });
    }
}
