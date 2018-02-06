package co.borucki.easykanban.adapter;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Color;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import co.borucki.easykanban.R;
import co.borucki.easykanban.model.Product;
import co.borucki.easykanban.model.ScannedProduct;
import co.borucki.easykanban.repository.ProductRepository;
import co.borucki.easykanban.repository.ProductRepositoryImpl;
import co.borucki.easykanban.repository.style.ScannedStyleRepository;
import co.borucki.easykanban.repository.style.ScannedStyleRepositoryImpl;
import co.borucki.easykanban.statics.ImageBitmap;

public class ScannedProductAdapter extends RecyclerView.Adapter<ScannedProductAdapter.ScannedProductViewHolder> {
    private final ProductRepository mProductRepository = ProductRepositoryImpl.getInstance();
    private final ScannedStyleRepository mScannedRepository = ScannedStyleRepositoryImpl.getInstance();
    private final LayoutInflater mLayoutInflater;
    private final List<ScannedProduct> mData = new ArrayList<>();
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
        Product product = mProductRepository.findProductById(mScannedProduct.getProductId());

        holder.mScannedDate.setText(res.getString(R.string.scanned_product_adapter_date_time, mScannedProduct.getTimeStamp()));//getString()+mScannedProduct.getTimeStamp());
        holder.mProductCode.setText(mScannedProduct.getProductId());
        holder.mProductName.setText(product.getDescription());
        holder.mDelete.setTag(mScannedProduct);
        holder.mDelete.setOnClickListener(mOnButtonClickListener);
        if (product.getPhoto()!=null) {
            holder.mCircleImage.setImageBitmap(ImageBitmap.decodeImageFromByteArrayToBitmap(product.getPhoto()));
        }
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
        @BindView(R.id.scanned_product_circle_image)
        ImageView mCircleImage;

        private ScannedProductViewHolder(View itemView) {
            super(itemView);
            ButterKnife.bind(this, itemView);
            mScannedDate.setTextColor(Color.parseColor(mScannedRepository.getSingleRowTextColor()));
            mProductName.setTextColor(Color.parseColor(mScannedRepository.getSingleRowTextColor()));
            mProductCode.setTextColor(Color.parseColor(mScannedRepository.getSingleRowTextColor()));
            if (mScannedRepository.getSingleRowDelButtonImage().equals("")) {
                mDelete.setImageDrawable(itemView.getResources().getDrawable(R.drawable.ic_delete_black_24dp));
            } else {
                mDelete.setImageBitmap(ImageBitmap.decodeImageFromStringToBitmap(mScannedRepository.getSingleRowDelButtonImage()));
            }

        }
    }

    public void setOnImageClickListener(ImageView.OnClickListener onImageClickListener) {
        mOnButtonClickListener = onImageClickListener;
    }
}

