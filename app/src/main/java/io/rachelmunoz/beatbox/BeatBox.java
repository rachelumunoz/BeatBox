package io.rachelmunoz.beatbox;

import android.content.Context;
import android.content.res.AssetFileDescriptor;
import android.content.res.AssetManager;
import android.media.AudioManager;
import android.media.SoundPool;
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
	private static final int MAX_SOUNDS = 5;

	private AssetManager mAssets;
	private List<Sound> mSounds  = new ArrayList<>();
	private SoundPool mSoundPool;

	public BeatBox(Context context){
		mAssets = context.getAssets();
		mSoundPool = new SoundPool(MAX_SOUNDS, AudioManager.STREAM_MUSIC, 0);
		loadSounds();
	}

	public void play(Sound sound){
		Integer soundId = sound.getSoundId();

		if (soundId == null){
			return;
		}

		mSoundPool.play(soundId, 1.0f, 1.0f, 1, 0, 1.0f);
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

			try {
				String assetPath = SOUNDS_FOLDER + "/" + fileName;
				Sound sound = new Sound(assetPath);
				load(sound); // load into SoundPool
				mSounds.add(sound); // add to BeatBox sound store
			} catch (IOException ioe){
				Log.e(TAG, "Could not load sound " + fileName, ioe);
			}



		}
	}

	private void load(Sound sound) throws IOException {
		AssetFileDescriptor afd = mAssets.openFd(sound.getAssetPath()); // opens Sound's file path
		int soundId = mSoundPool.load(afd, 1); // loads the file path into the SoundPool, returns ID
		sound.setSoundId(soundId);
	}

	public List<Sound> getSounds() {
		return mSounds;
	}
}
