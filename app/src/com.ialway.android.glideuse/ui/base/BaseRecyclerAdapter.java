package com.ialway.android.glideuse.ui.base;

import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.view.ViewGroup;

import butterknife.ButterKnife;

/**
 * Created by dingchao on 2015/9/1.
 */
public abstract class BaseRecyclerAdapter<T extends BaseRecyclerAdapter.BaseRecyclerHolder> extends RecyclerView.Adapter<T> {

    private RecyclerItemClickListener mItemClick;

    public void setOnItemClickListener(RecyclerItemClickListener itemClick) {
        this.mItemClick = itemClick;
    }

    @Override
    public abstract T onCreateViewHolder(ViewGroup parent, int viewType);

    @Override
    public abstract int getItemCount();

    public abstract <F> F getItem(int position);

    public abstract class BaseRecyclerHolder extends RecyclerView.ViewHolder implements View.OnClickListener {

        /**
         *
         * @param itemView
         */
        public BaseRecyclerHolder(View itemView) {
            this(itemView, false);
        }

        /**
         *
         * @param itemView
         * @param needItemClick ： 设置是否设置onItemClick事件
         */
        public BaseRecyclerHolder(View itemView, boolean needItemClick) {
            super(itemView);
            ButterKnife.bind(this, itemView);
            if (needItemClick) {
                itemView.setOnClickListener(this);
            }
        }


        @Override
        public void onClick(View v) {
            if (mItemClick != null) {
                mItemClick.onItemClick(v, getAdapterPosition());
            }
        }
    }

    public interface RecyclerItemClickListener {

        public void onItemClick(View v, int position);
    }
}
