package vell.bibi.vsigner.view;

import vell.bibi.vsigner.R;
import vell.bibi.vsigner.view.RefreshableView.PullToRefreshListener;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

public class MessageFragment extends BaseFragment{

	private RefreshableView mRefreshableView;
	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container,
			Bundle savedInstanceState) {
		return inflater.inflate(R.layout.fragment_message, container, false);
	}

	@Override
	public void initViews() {
		mRefreshableView = (RefreshableView) findViewById(R.id.refreshable_view);
	}

	@Override
	public void initListeners() {
		mRefreshableView.setOnRefreshListener(new PullToRefreshListener() {
			@Override
			public void onRefresh() {
				try {
					Thread.sleep(3000);
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
				mRefreshableView.finishRefreshing();
			}
		}, mRefreshableView.getId());
	}

	@Override
	public void initData() {
	}
}