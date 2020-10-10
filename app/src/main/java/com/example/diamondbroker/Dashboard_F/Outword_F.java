package com.example.diamondbroker.Dashboard_F;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import androidx.cardview.widget.CardView;
import androidx.fragment.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.example.diamondbroker.R;

import java.util.ArrayList;
import java.util.List;

public class Outword_F extends Fragment {
    private RecyclerView rv_outword;
    List<String> Outword_List = new ArrayList<>();

    // TODO: Rename parameter arguments, choose names that match

    public Outword_F() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View inflate = inflater.inflate(R.layout.fragment_outword, container, false);
        rv_outword = inflate.findViewById(R.id.rv_outword);
        inflate.findViewById(R.id.fab_Outword).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(getContext(),Add_Outword.class));
            }
        });
        rv_outword.setHasFixedSize(true);
        Outword_List.add("ABC");
        Outword_List.add("ABC");
        Outword_List.add("ABC");
        Outword_List.add("ABC");
        Outword_List.add("ABC");
        Outword_List.add("ABC");
        Outword_List.add("ABC");
        Outword_List.add("ABC");
        Outword_List.add("ABC");
        Outword_List.add("ABC");
        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(getContext());
        rv_outword.setLayoutManager(layoutManager);
        Outword_Adapter outword_adapter = new Outword_Adapter(getContext(),Outword_List);
        rv_outword.setAdapter(outword_adapter);
        return inflate;
    }
    private class Outword_Adapter extends RecyclerView.Adapter<Outword_Adapter.ViewHolder> {

        Context context;
        List<String> OutwordList;

        public Outword_Adapter(Context context, List<String> inwordList) {
            this.context = context;
            OutwordList = inwordList;
        }

        @Override
        public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
            View view = LayoutInflater.from(context).inflate(R.layout.item_outword,parent,false);
            return new ViewHolder(view);
        }

        @Override
        public void onBindViewHolder(Outword_Adapter.ViewHolder holder, int position) {
            ViewGroup.MarginLayoutParams cardViewMarginParams = (ViewGroup.MarginLayoutParams) holder.outword_card.getLayoutParams();
            if (position==0)
            {
                cardViewMarginParams.setMargins(10,
                        10,
                        10,
                        5);
            }
            else if (position>0 && position<OutwordList.size()-1)
            {
                cardViewMarginParams.setMargins(10,
                        5,
                        10,
                        5);
            }
            else if(position == OutwordList.size()-1)
            {
                cardViewMarginParams.setMargins(10,
                        5,
                        10,
                        10);
            }
            holder.outword_card.requestLayout();
        }

        @Override
        public int getItemCount() {
            return OutwordList.size();
        }

        public class ViewHolder extends RecyclerView.ViewHolder{
            CardView outword_card;
            public ViewHolder(View itemView) {
                super(itemView);
                outword_card = itemView.findViewById(R.id.outword_card);
            }
        }
    }
}