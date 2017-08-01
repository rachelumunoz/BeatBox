package io.rachelmunoz.beatbox;

import android.databinding.BaseObservable;
import android.databinding.Bindable;

/**
 * Created by rachelmunoz on 7/30/17.
 */

public class SoundViewModel extends BaseObservable {
	private Sound mSound;
	private BeatBox mBeatBox;

	public SoundViewModel(BeatBox beatBox) {
		mBeatBox = beatBox;
	}

	public Sound getSound() {
		return mSound;
	}

	@Bindable
	public void setSound(Sound sound) {
		mSound = sound;
		notifyChange(); // notifies binding class
	}

	@Bindable
	public String getTitle() {
		return mSound.getName();
	}

	public void onButtonClicked() {
		mBeatBox.play(mSound);
	}
}