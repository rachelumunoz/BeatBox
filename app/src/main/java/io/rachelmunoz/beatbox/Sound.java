package io.rachelmunoz.beatbox;

/**
 * Created by rachelmunoz on 7/30/17.
 */

public class Sound { // turns assets, wav files into objects that we can populate views w/, user can interact w/

	private String mAssetPath;
	private String mName;

	public Sound(String assetPath) {
		mAssetPath = assetPath;
		String[] components = assetPath.split("/");
		String fileName = components[components.length - 1];
		mName = fileName.replace(".wav", "");
	}

	public String getAssetPath() {
		return mAssetPath;
	}

	public String getName() {
		return mName;
	}
}
