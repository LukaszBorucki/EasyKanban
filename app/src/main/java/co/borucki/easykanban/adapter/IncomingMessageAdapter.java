package co.borucki.easykanban.adapter;

import android.content.Context;
import android.graphics.Color;
import android.graphics.drawable.GradientDrawable;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import co.borucki.easykanban.R;
import co.borucki.easykanban.model.IncomingMessage;
import co.borucki.easykanban.statics.DataTimeCounter;


public class IncomingMessageAdapter extends RecyclerView.Adapter<IncomingMessageAdapter.IncomingMessageViewHolder> {
    private final LayoutInflater mLayoutInflater;
    private final List<IncomingMessage> mData = new ArrayList<>();
    private View.OnLongClickListener mOnLongClickListener;
    private View.OnClickListener mOnClickListener;

    public IncomingMessageAdapter(Context context) {

        mLayoutInflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
    }

    @Override
    public IncomingMessageViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = mLayoutInflater.inflate(R.layout.activity_incoming_message_single_row, parent, false);

        return new IncomingMessageViewHolder(view);
    }

    @Override
    public void onBindViewHolder(IncomingMessageViewHolder holder, int position) {
        IncomingMessage message = mData.get(position);

        holder.mSubject.setText(message.getSubject());
        holder.mFrom.setText(message.getFrom());
        holder.mMessage.setText(message.getContents());
        holder.mReceivedDateTime.setText(DataTimeCounter.dateOrTime(message.getReceivedDate()));
        if (!message.isRead()) {
            GradientDrawable shape = new GradientDrawable();
            float[] i = {20, 20, 20, 20, 20, 20, 0, 0};
            shape.setCornerRadii(i);
            shape.setColor(Color.parseColor("#F03F51B5"));
            holder.mLayout.setBackground(shape);
        } else {
            holder.mLayout.setBackgroundColor(Color.parseColor("#003F51B5"));
        }
        holder.itemView.setTag(message);
        holder.itemView.setOnClickListener(mOnClickListener);
    }

    @Override
    public int getItemCount() {


        return mData.size();
    }

    public void setData(List<IncomingMessage> messages) {
        mData.clear();
        mData.addAll(messages);
        notifyDataSetChanged();
    }

    public class IncomingMessageViewHolder extends RecyclerView.ViewHolder {
        @BindView(R.id.incoming_message_subject)
        TextView mSubject;
        @BindView(R.id.incoming_message_from)
        TextView mFrom;
        @BindView(R.id.incoming_message_time)
        TextView mReceivedDateTime;
        @BindView(R.id.incoming_message_text)
        TextView mMessage;
        @BindView(R.id.message_single_row)
        LinearLayout mLayout;

        private IncomingMessageViewHolder(View itemView) {
            super(itemView);
            ButterKnife.bind(this, itemView);
        }
    }

    public void setOnLongClickListener(View.OnLongClickListener onLongClickListener) {
        mOnLongClickListener = onLongClickListener;
    }

    public void setOnClickListener(View.OnClickListener onClickListener) {
        mOnClickListener = onClickListener;
    }
}
