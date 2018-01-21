package co.borucki.easykanban.adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.ArrayList;
import java.util.List;

import butterknife.ButterKnife;
import co.borucki.easykanban.R;
import co.borucki.easykanban.model.ScannedProduct;

public class ScannedProductAdapter extends RecyclerView.Adapter<ScannedProductAdapter.ScannedProductViewHolder> {
    private final LayoutInflater mLayoutInflater;
    private final List<ScannedProduct> mData = new ArrayList<>();
    private View.OnLongClickListener mOnLongClickListener;
    private View.OnClickListener mOnClickListener;

    public ScannedProductAdapter(Context context) {
        mLayoutInflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
    }

    @Override
    public ScannedProductViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = mLayoutInflater.inflate(R.layout.activity_incoming_message_single_row, parent, false);
        return new ScannedProductViewHolder(view);
    }

    @Override
    public void onBindViewHolder(ScannedProductAdapter.ScannedProductViewHolder holder, int position) {
        ScannedProduct mProduct = mData.get(position);
    }

    @Override
    public int getItemCount() {


        return mData.size();
    }

    public void setData(List<ScannedProduct> productList) {
        mData.clear();
        mData.addAll(productList);
        notifyDataSetChanged();
    }

    public class ScannedProductViewHolder extends RecyclerView.ViewHolder {
        private ScannedProductViewHolder(View itemView) {
            super(itemView);
            ButterKnife.bind(this, itemView);
        }
    }
}

