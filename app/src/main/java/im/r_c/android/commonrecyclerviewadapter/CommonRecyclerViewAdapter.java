package im.r_c.android.commonrecyclerviewadapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.recyclerview.widget.RecyclerView;

/**
 * CommonRecyclerViewAdapter
 * Created by richard on 16/1/18.
 */
public abstract class CommonRecyclerViewAdapter<T> extends RecyclerView.Adapter<ViewHolder> {
    private Context mContext;
    private T[] mDataArray;
    private int mLayoutId;
    private OnItemClickListener mOnItemClickListener;
    private OnItemLongClickListener mOnItemLongClickListener;

    protected CommonRecyclerViewAdapter(Context context, T[] dataArray, int layoutId) {
        mContext = context;
        mDataArray = dataArray;
        mLayoutId = layoutId;
    }

    public void setOnItemClickListener(OnItemClickListener onItemClickListener) {
        mOnItemClickListener = onItemClickListener;
    }

    public void setOnItemLongClickListener(OnItemLongClickListener onItemLongClickListener) {
        mOnItemLongClickListener = onItemLongClickListener;
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(mContext).inflate(mLayoutId, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(final ViewHolder holder, int position) {
        if (mOnItemClickListener != null) {
            holder.itemView.setOnClickListener(v -> mOnItemClickListener.onItemClick(v, holder.getLayoutPosition()));
        }
        if (mOnItemLongClickListener != null) {
            holder.itemView.setOnLongClickListener(v -> mOnItemLongClickListener.onItemLongClick(v, holder.getLayoutPosition()));
        }
        onItemViewAppear(holder, mDataArray[position], position);
    }

    @Override
    public int getItemCount() {
        return mDataArray.length;
    }

    public abstract void onItemViewAppear(ViewHolder holder, T t, int position);

    public interface OnItemClickListener {
        void onItemClick(View view, int position);
    }

    public interface OnItemLongClickListener {
        boolean onItemLongClick(View view, int position);
    }
}
