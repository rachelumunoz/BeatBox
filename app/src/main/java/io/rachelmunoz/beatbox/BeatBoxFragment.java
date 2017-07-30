package io.rachelmunoz.beatbox;

import android.app.Fragment;
import android.databinding.DataBindingUtil;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.List;

import io.rachelmunoz.beatbox.databinding.FragmentBeatBoxBinding;
import io.rachelmunoz.beatbox.databinding.ListItemSoundBinding;

/**
 * Created by rachelmunoz on 7/29/17.
 */

public class BeatBoxFragment extends Fragment {
	public static BeatBoxFragment newInstance() {
		return new BeatBoxFragment();
	}

	@Nullable
	@Override
	public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, Bundle savedInstanceState) {
		FragmentBeatBoxBinding binding = DataBindingUtil.inflate(inflater, R.layout.fragment_beat_box, container, false);

		binding.recyclerView.setLayoutManager(new GridLayoutManager(getActivity(), 3));
		binding.recyclerView.setAdapter(new SoundAdapter());

		return binding.getRoot();
	}

	private class SoundHolder extends RecyclerView.ViewHolder {
		private ListItemSoundBinding mBinding;

		private SoundHolder(ListItemSoundBinding binding){
			super(binding.getRoot());
			mBinding = binding;
		}
	}

	private class SoundAdapter extends RecyclerView.Adapter<SoundHolder>{
		@Override
		public SoundHolder onCreateViewHolder(ViewGroup parent, int viewType) {
			LayoutInflater inflater = LayoutInflater.from(getActivity());
			ListItemSoundBinding binding = DataBindingUtil.inflate(inflater, R.layout.list_item_sound, parent, false);

			return new SoundHolder(binding);
		}

		@Override
		public void onBindViewHolder(SoundHolder holder, int position) {

		}

		@Override
		public int getItemCount() {
			return 0;
		}
	}
}
