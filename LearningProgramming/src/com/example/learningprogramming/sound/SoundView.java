package com.example.learningprogramming.sound;

import android.content.Context;
import android.media.MediaPlayer;
import android.view.View;

import com.example.learningprogramming.R;

public class SoundView extends View {

	private static MediaPlayer nowPlaying = null;

	public SoundView(Context context) {
		super(context);
	}

	MediaPlayer se_push1 = MediaPlayer.create(getContext(), R.raw.push1);
	MediaPlayer se_push2 = MediaPlayer.create(getContext(), R.raw.push2);

	MediaPlayer bgm_menu = MediaPlayer.create(getContext(), R.raw.menu_back);
	MediaPlayer bgm_select = MediaPlayer.create(getContext(),
			R.raw.stageselect_back);
	MediaPlayer bgm_stage = MediaPlayer.create(getContext(), R.raw.stage_back);

	public void startSE() {
		se_push2.start();
	}

	public void startBGM_menu() {
		if (nowPlaying != null) {
			nowPlaying.stop();
		}
		nowPlaying = bgm_menu;
		nowPlaying.start();
	}

	public void startBGM_select() {
		if (nowPlaying != null) {
			nowPlaying.stop();
		}
		nowPlaying = bgm_select;
		nowPlaying.start();
	}

	public void startBGM_stage() {
		if (nowPlaying != null) {
			nowPlaying.stop();
		}
		nowPlaying = bgm_stage;
		nowPlaying.start();
	}

	public MediaPlayer getBGM() {
		return nowPlaying;
	}

	public void stopSound(MediaPlayer bgm) {
		bgm.stop();
	}
}
