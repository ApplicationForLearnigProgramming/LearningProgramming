package game;

import android.graphics.Bitmap;

public class StageSelectData {

	private int _stageNumber = 0;
	private Bitmap _stageIcon = null;
	private Bitmap _difficulty = null;
	private String _text = null;

	public StageSelectData(int number, Bitmap stage, Bitmap star) {
		_text = "Score:";
		_stageNumber = number;
		_stageIcon = stage;
		_difficulty = star;
	}
	// public void setText(String text) {
	// _text = text;
	// }

	public int getStageNumber() {
		return _stageNumber;
	}

	public Bitmap getStageIcon() {
		return _stageIcon;
	}

	public Bitmap getDifficulty() {
		return _difficulty;
	}

	public String getText() {
		return _text;
	}
}
