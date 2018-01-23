package co.borucki.easykanban.adapter;

import android.app.Activity;
import android.content.Context;
import android.content.res.Resources;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import co.borucki.easykanban.AndroidApplication;
import co.borucki.easykanban.R;
import co.borucki.easykanban.model.ScannedProduct;

public class ScannedProductAdapter extends RecyclerView.Adapter<ScannedProductAdapter.ScannedProductViewHolder> {
    private final LayoutInflater mLayoutInflater;
    private final List<ScannedProduct> mData = new ArrayList<>();
    private View.OnLongClickListener mOnLongClickListener;
    private View.OnClickListener mOnClickListener;
    private ImageView.OnClickListener mOnButtonClickListener;

    public ScannedProductAdapter(Context context) {
        mLayoutInflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
    }

    @Override
    public ScannedProductViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = mLayoutInflater.inflate(R.layout.scanned_product_single_row, parent, false);
        return new ScannedProductViewHolder(view);
    }

    @Override
    public void onBindViewHolder(ScannedProductAdapter.ScannedProductViewHolder holder, int position) {
        ScannedProduct mScannedProduct = mData.get(position);
        Resources res = holder.itemView.getContext().getResources();

        holder.mScannedDate.setText(res.getString(R.string.scanned_product_adapter_date_time, mScannedProduct.getTimeStamp()));//getString()+mScannedProduct.getTimeStamp());
        holder.mProductCode.setText(mScannedProduct.getProductId());
        holder.mProductName.setText(String.valueOf(mScannedProduct.getId()));
        holder.mDelete.setTag(mScannedProduct);
        holder.mDelete.setOnClickListener(mOnButtonClickListener);
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
        @BindView(R.id.scanned_product_date)
        TextView mScannedDate;
        @BindView(R.id.scanned_product_code)
        TextView mProductCode;
        @BindView(R.id.scanned_product_name)
        TextView mProductName;
        @BindView(R.id.scanned_product_delete)
        ImageView mDelete;

        private ScannedProductViewHolder(View itemView) {
            super(itemView);
            ButterKnife.bind(this, itemView);
        }
    }

    public void setOnImageClickListener(ImageView.OnClickListener onImageClickListener) {
        mOnButtonClickListener = onImageClickListener;
    }
}

