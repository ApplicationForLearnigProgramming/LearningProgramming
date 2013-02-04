package game;

import java.util.List;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.learningprogramming.R;

public class StageSelectAdapter extends ArrayAdapter<StageSelectData> {

	private LayoutInflater _layoutInflater = null;

	public StageSelectAdapter(Context context, int textViewResourceId,
			List<StageSelectData> objects) {
		super(context, textViewResourceId, objects);
		_layoutInflater = (LayoutInflater) context
				.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
	}

	@Override
	public View getView(int position, View convertView, ViewGroup parent) {
		StageSelectData item = (StageSelectData) getItem(position);

		if (convertView == null) {
			convertView = _layoutInflater.inflate(R.layout.list_row, null);
		}

		ImageView stageImageView = null;
		stageImageView = (ImageView) convertView
				.findViewById(R.id.row_imageview_stage);
		stageImageView.setImageBitmap(item.getStageIcon());

		TextView textView = null;
		textView = (TextView) convertView.findViewById(R.id.row_textview1);
		textView.setText(item.getText());

		ImageView starImageView = null;
		starImageView = (ImageView) convertView
				.findViewById(R.id.row_imageview_star);
		starImageView.setImageBitmap(item.getDifficulty());

		return convertView;
	}
}
