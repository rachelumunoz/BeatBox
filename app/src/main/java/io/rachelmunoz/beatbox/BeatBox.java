package io.rachelmunoz.beatbox;

import android.content.Context;
import android.content.res.AssetManager;
import android.util.Log;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by rachelmunoz on 7/30/17.
 */

public class BeatBox { // manages assets, instantiated in onCreate of BeatBoxFragment
	private static final String TAG = "BeatBox";
	private static final String SOUNDS_FOLDER = "sample_sounds";

	private AssetManager mAssets;
	private List<Sound> mSounds  = new ArrayList<>();

	public BeatBox(Context context){
		mAssets = context.getAssets();
		loadSounds();
	}

	private void loadSounds(){
		String[] soundNames;

		try {
			soundNames = mAssets.list(SOUNDS_FOLDER);
			Log.i(TAG, " Found " + soundNames.length + " sounds");
		} catch (IOException ioe){
			Log.e(TAG, "Could not list assets", ioe);
			return;
		}

		for (String fileName : soundNames){
			String assetPath = SOUNDS_FOLDER + "/" + fileName;
			Sound sound = new Sound(assetPath);
			mSounds.add(sound);

		}
	}

	public List<Sound> getSounds() {
		return mSounds;
	}
}
