package com.tistory.qlyh8.emarket.trade;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.ValueEventListener;
import com.tistory.qlyh8.emarket.R;
import com.tistory.qlyh8.emarket.firebase.GetDB;

import java.util.List;

//매칭현황 리스트 어댑터
public class TradeStautsListAdapter extends RecyclerView.Adapter<TradeStautsListAdapter.ViewHolder> {

    private Context context;
    private LayoutInflater mInflater;
    private List<Integer> res;

    public TradeStautsListAdapter(Context context, List<Integer> res){
        this.mInflater = LayoutInflater.from(context);
        this.context = context;
        this.res = res;
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = mInflater.inflate(R.layout.trade_status_list, parent, false);
        ViewHolder viewHolder = new ViewHolder(view);
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, final int position) {
        //각 아이템의 이벤트를 할당
        holder.statusBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(mInflater.getContext(),String.valueOf(position),Toast.LENGTH_SHORT).show();
            }
        });

        GetDB.mEnrollRef.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {

            }

            @Override
            public void onCancelled(DatabaseError databaseError) {

            }
        });
    }

    @Override
    public int getItemCount() {
        return res.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {

        //각 아이템의 항목을 할당
        TextView matchingName, matchingPowerRecommend, matchingSaveMoney;
        Button statusBtn;

        public ViewHolder(View view) {
            super(view);

            matchingName = view.findViewById(R.id.trade_status_list_name_text);
            matchingPowerRecommend = view.findViewById(R.id.trade_status_list_power_text);
            matchingSaveMoney = view.findViewById(R.id.trade_status_list_money_text);
            statusBtn = view.findViewById(R.id.trade_status_list_button);
        }
    }
}
