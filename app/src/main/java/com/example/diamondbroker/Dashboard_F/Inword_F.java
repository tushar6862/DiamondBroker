package com.example.diamondbroker.Dashboard_F;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.widget.LinearLayout;
import androidx.annotation.NonNull;
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

public class Inword_F extends Fragment {
    RecyclerView rv_inword;
    List<String> Inword_List = new ArrayList<>();

    public Inword_F() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View inflate = inflater.inflate(R.layout.fragment_inword, container, false);
        rv_inword = inflate.findViewById(R.id.rv_inword);
        inflate.findViewById(R.id.fab_inword).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(getContext(),Add_Inword.class));
            }
        });
        rv_inword.setHasFixedSize(true);
        Inword_List.add("ABC");
        Inword_List.add("ABC");
        Inword_List.add("ABC");
        Inword_List.add("ABC");
        Inword_List.add("ABC");
        Inword_List.add("ABC");
        Inword_List.add("ABC");
        Inword_List.add("ABC");
        Inword_List.add("ABC");
        Inword_List.add("ABC");
        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(getContext());
        rv_inword.setLayoutManager(layoutManager);
        Inword_Adapter inword_adapter = new Inword_Adapter(getContext(),Inword_List);
        rv_inword.setAdapter(inword_adapter);
        return inflate;
    }

    private class Inword_Adapter extends RecyclerView.Adapter<Inword_Adapter.ViewHolder> {

        Context context;
        List<String> InwordList;

        public Inword_Adapter(Context context, List<String> inwordList) {
            this.context = context;
            InwordList = inwordList;
        }

        @Override
        public ViewHolder onCreateViewHolder( ViewGroup parent, int viewType) {
            View view = LayoutInflater.from(context).inflate(R.layout.item_inword,parent,false);
            return new ViewHolder(view);
        }

        @Override
        public void onBindViewHolder(Inword_F.Inword_Adapter.ViewHolder holder, int position) {
            ViewGroup.MarginLayoutParams cardViewMarginParams = (ViewGroup.MarginLayoutParams) holder.inword_card.getLayoutParams();
            if (position==0)
            {
                cardViewMarginParams.setMargins(10,
                        10,
                        10,
                        5);
            }
            else if (position>0 && position<InwordList.size()-1)
            {
                cardViewMarginParams.setMargins(10,
                        5,
                        10,
                        5);
            }
            else if(position == InwordList.size()-1)
            {
                cardViewMarginParams.setMargins(10,
                        5,
                        10,
                        10);
            }
            holder.inword_card.requestLayout();  //Dont forget this line
        }

        @Override
        public int getItemCount() {
            return InwordList.size();
        }

        public class ViewHolder extends RecyclerView.ViewHolder{
            CardView inword_card;
            public ViewHolder(View itemView) {
                super(itemView);
                inword_card = itemView.findViewById(R.id.inword_card);
            }
        }
    }
}