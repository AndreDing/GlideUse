package com.ialway.android.glideuse.ui;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.ialway.android.glideuse.R;
import com.ialway.android.glideuse.model.GlideType;
import com.ialway.android.glideuse.ui.activity.SubMainActivity;
import com.ialway.android.glideuse.ui.base.BaseRecyclerAdapter;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

public class MainActivity extends Activity {

    @BindView(R.id.test_list)
    RecyclerView mTestList;

    private List<GlideType> mTestListContent = new ArrayList<>();

    private TestListAdapter mTestAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);

        initData();

        fillList();
    }

    private void initData() {

        GlideType glideType = new GlideType(GlideType.TYPE_SIMPLE, MainApp.shared().getString(R.string.simple_test));
        mTestListContent.add(glideType);
    }

    private void fillList() {
        LinearLayoutManager listLayoutMgr = new LinearLayoutManager(this);
        mTestList.setLayoutManager(listLayoutMgr);

        mTestAdapter = new TestListAdapter(this, mTestListContent);
        mTestList.setAdapter(mTestAdapter);
        mTestAdapter.setOnItemClickListener(new BaseRecyclerAdapter.RecyclerItemClickListener() {

            @Override
            public void onItemClick(View v, int position) {

                GlideType type = mTestAdapter.getItem(position);
                Intent intent = new Intent(MainActivity.this, SubMainActivity.class);
                intent.putExtra(GlideType.INTENT_EXTRA_GLIDETYPE, type);
                MainActivity.this.startActivity(intent);
            }
        });
    }

    class TestListAdapter extends BaseRecyclerAdapter<TestListAdapter.ViewHolder> {

        private Context mCtx;
        private List<GlideType> mTestList;

        public TestListAdapter(Context context, List<GlideType> data) {
            mCtx = context;
            mTestList = data;
        }

        @Override
        public GlideType getItem(int position) {
            return mTestList.get(position);
        }

        @Override
        public int getItemCount() {
            return mTestList == null ? 0 : mTestList.size();
        }

        @Override
        public void onBindViewHolder(ViewHolder holder, int position) {

            GlideType testType = getItem(position);
            if (testType == null) {
                return;
            }
            holder.mListName.setText(testType.getName());
        }

        @Override
        public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
            View view = LayoutInflater.from(mCtx).inflate(R.layout.layout_test_item, parent, false);
            ViewHolder listHolder = new ViewHolder(view, true);
            return listHolder;
        }

        class ViewHolder extends BaseRecyclerAdapter.BaseRecyclerHolder {

            @BindView(R.id.list_name)
            TextView mListName;

            public ViewHolder(View itemView, boolean needItemClick) {
                super(itemView, needItemClick);
            }
        }
    }
}
