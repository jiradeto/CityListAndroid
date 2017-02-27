package app.pg_applications.com.effectiveuistudy.home;

import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ProgressBar;
import android.widget.Toast;

import javax.inject.Inject;

import app.pg_applications.com.effectiveuistudy.BaseActivity;
import app.pg_applications.com.effectiveuistudy.R;
import app.pg_applications.com.effectiveuistudy.models.CityListData;
import app.pg_applications.com.effectiveuistudy.models.CityListResponse;
import app.pg_applications.com.effectiveuistudy.networking.Service;
import butterknife.BindView;
import butterknife.ButterKnife;

public class MainActivity extends BaseActivity implements HomeView {


    @BindView(R.id.recycle_main)
    RecyclerView mRecycleView;

    @BindView(R.id.progress_main)
    ProgressBar mProgressBar;

    @Inject
    Service mService;
    private HomeAdapter mAdapter;

    private HomeAdapter.CustomClickListenerr listenerr;
    private HomePresenter mPresenter;

    private static final String TAG = "MainActivity";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);

        getDep().inject(this);
        initInstance();
    }

    private void initInstance() {
        mPresenter = new HomePresenter(mService, this);

        mAdapter = new HomeAdapter(new HomeAdapter.CustomClickListenerr() {
            @Override
            public void onClick(CityListData Item) {
                Toast.makeText(MainActivity.this, Item.getName().toString(), Toast.LENGTH_SHORT).show();
            }
        }, this);

        mRecycleView.setLayoutManager(new LinearLayoutManager(this));
        mRecycleView.setAdapter(mAdapter);
        mPresenter.getCityList();
    }

    @Override
    public void showProgress() {
        mProgressBar.setVisibility(View.VISIBLE);
    }

    @Override
    public void hideProgress() {
        mProgressBar.setVisibility(View.GONE);
    }

    @Override
    public void onFailure(String appErrorMessage) {
        hideProgress();
        Toast.makeText(this, "Error ,try again !!", Toast.LENGTH_SHORT).show();

    }

    @Override
    public void setData(CityListResponse cityListResponse) {
        mAdapter.setData(cityListResponse.getData());
    }
}
