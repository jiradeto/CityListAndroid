package app.pg_applications.com.effectiveuistudy.home;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.load.engine.DiskCacheStrategy;

import java.util.ArrayList;
import java.util.List;

import app.pg_applications.com.effectiveuistudy.R;
import app.pg_applications.com.effectiveuistudy.models.CityListData;


/**
 * Created by jiradet on 2/27/2017 AD.
 */

public class HomeAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {

    private static final String TAG = "HomeAdapter";
    private Context mContext;
    private List<CityListData> data = new ArrayList<>();
    private CustomClickListenerr listener;

    public HomeAdapter(CustomClickListenerr listener, Context mContext) {
        this.listener = listener;
        this.mContext = mContext;
    }

    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        Log.e(TAG, "POND: >>>>>>>");
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_home, null);
        view.setLayoutParams(new RecyclerView.LayoutParams(RecyclerView.LayoutParams.MATCH_PARENT, RecyclerView.LayoutParams.WRAP_CONTENT));
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder holder, int position) {

        Log.e(TAG, "onBindViewHolder: >>>>>>>");

        ViewHolder v = (ViewHolder) holder;

        v.click(data.get(position), listener);
        v.tvCity.setText(data.get(position).getName());
        v.tvDesc.setText(data.get(position).getDescription());

        String images = data.get(position).getBackground();

        Glide.with(mContext)
                .load(images)
                .diskCacheStrategy(DiskCacheStrategy.SOURCE)
                .skipMemoryCache(true)
                .into(v.background);

    }

    public interface CustomClickListenerr {
        void onClick(CityListData Item);
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        TextView tvCity, tvDesc;
        ImageView background;

        public void click(final CityListData cityListData, final CustomClickListenerr listener) {
            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    listener.onClick(cityListData);
                }
            });
        }

        public ViewHolder(View itemView) {
            super(itemView);
            tvCity = (TextView) itemView.findViewById(R.id.city);
            tvDesc = (TextView) itemView.findViewById(R.id.hotel);
            background = (ImageView) itemView.findViewById(R.id.image);
        }
    }

    public void setData(List<CityListData> newData) {

        if (newData != null) {
            data.addAll(newData);
            notifyDataSetChanged();
        }

    }

    @Override
    public int getItemCount() {
        return data.size();
    }
}
