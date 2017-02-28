package com.example.suchismita.essappleave.Adapter;

import android.content.Context;
import android.content.Intent;
import android.support.v7.widget.CardView;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.suchismita.essappleave.Model.ApprovedLeaveModel;
import com.example.suchismita.essappleave.R;

import java.util.List;

/**
 * Created by suchismita on 2/20/2017.
 */

public class ApprovedLeaveAdpater extends RecyclerView.Adapter<ApprovedLeaveAdpater.MyViewHolder> {
    private Context mContext;
    private List<ApprovedLeaveModel> leaveModel;

    public class MyViewHolder extends RecyclerView.ViewHolder {
        public TextView appid, leave_type, date, leaveNo;
        public CardView cardView;

        public MyViewHolder(View view) {
            super(view);
            appid = (TextView) view.findViewById(R.id.appId);
            leave_type = (TextView) view.findViewById(R.id.leave_type);
            date = (TextView) view.findViewById(R.id.from_to_date);
            leaveNo = (TextView) view.findViewById(R.id.leave_no);
            cardView = (CardView) view.findViewById(R.id.card_view);

        }
    }

    public ApprovedLeaveAdpater()
    {

    }
    public ApprovedLeaveAdpater(Context mContext, List<ApprovedLeaveModel> leaveModel) {
        this.mContext = mContext;
        this.leaveModel = leaveModel;

    }
    public MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.approved_leave_list, parent, false);

        return new MyViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(final ApprovedLeaveAdpater.MyViewHolder holder, final int position) {
        ApprovedLeaveModel album = leaveModel.get(position);
        holder.appid.setText(album.getAppId());
        holder.leave_type.setText(album.getLeaveType() );
        holder.date.setText(album.getDate());
        holder.leaveNo.setText(album.getNo_leave());
//        holder.cardView.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                Intent intent = new Intent(mContext, OrderDetailActivity.class);
////                intent.putExtra("person_name", NewOrderModel.get(position).());
////                intent.putExtra("enquiry_for", NewOrderModel.get(position).getEnquiryType());
////                intent.putExtra("enquiry_query", NewOrderModel.get(position).getQueries());
////                intent.putExtra("enquiry_phno", NewOrderModel.get(position).getPhoneNo());
////                intent.putExtra("enquiry_area", enquiryModels.get(position).getArea());
//                mContext.startActivity(intent);
//            }
//        });
//        holder.country.setText(album.getCountry());
//        holder.pin.setText(album.getPin());
//        holder.phoneno.setText(album.getPhoneno());

    }

    @Override
    public int getItemCount() {
        return leaveModel.size();
    }
}
