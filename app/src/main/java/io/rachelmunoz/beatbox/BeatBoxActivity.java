package io.rachelmunoz.beatbox;

public class BeatBoxActivity extends SingleFragmentActivity {

	@Override
	protected BeatBoxFragment createFragment() {
		return BeatBoxFragment.newInstance();
	}
}
