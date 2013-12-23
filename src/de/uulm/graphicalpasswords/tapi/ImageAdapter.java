/*******************************************************************************
 * Copyright 2013 Marcel Walch, Florian Schaub
 * 
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 * 
 *   http://www.apache.org/licenses/LICENSE-2.0
 * 
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 ******************************************************************************/
package de.uulm.graphicalpasswords.tapi;

import android.content.Context;
import android.content.res.TypedArray;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import de.uulm.graphicalpasswords.R;

public class ImageAdapter extends BaseAdapter {
	private int galleryItemBackground;
	private Context mContext;

	private String[] pictureIDs;

	public ImageAdapter(Context c, String[] pictures) {
		mContext = c;
		pictureIDs = pictures;

		TypedArray attr = mContext
				.obtainStyledAttributes(R.styleable.UYIGallery);
		galleryItemBackground = attr.getResourceId(
				R.styleable.UYIGallery_android_galleryItemBackground, 0);
		attr.recycle();
	}

	@Override
	public int getCount() {
		return pictureIDs.length;
	}

	@Override
	public Object getItem(int position) {
		return position;
	}

	@Override
	public long getItemId(int position) {
		return position;
	}

	@Override
	public View getView(int position, View convertView, ViewGroup parent) {
		String[] split = pictureIDs[position].split(":");
		int resId = Integer.parseInt(split[0]);
		int field = Integer.parseInt(split[1]);
		RememberPassImageView i = new RememberPassImageView(mContext);
		i.setHighlitedField(field);
		i.setScaleType(ImageView.ScaleType.FIT_XY);
		i.setBackgroundResource(galleryItemBackground);
		i.setImageResource(resId);
		i.setClickable(false);
		return i;
	}

}
