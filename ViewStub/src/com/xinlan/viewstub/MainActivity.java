package com.xinlan.viewstub;

import android.os.Bundle;
import android.app.Activity;
import android.view.Menu;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewStub;
import android.view.ViewStub.OnInflateListener;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends Activity implements OnClickListener {
	private Button show, hide;
	private ViewStub imageViewStub;
	private String data = "习近平";
	private TextView mText;
	
	int index;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);

		imageViewStub = (ViewStub) findViewById(R.id.image_viewstub);
		show = (Button) findViewById(R.id.btn_show);
		hide = (Button) findViewById(R.id.btn_hide);
		show.setOnClickListener(this);
		hide.setOnClickListener(this);
		
		imageViewStub.setOnInflateListener(new OnInflateListener() {
			@Override
			public void onInflate(ViewStub stub, View inflated) {
				System.out.println("ViewStub载入布局   "+(index++));
				mText = (TextView) inflated.findViewById(R.id.text);
				mText.setText(data+index);
			}
		});
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.main, menu);
		return true;
	}

	@Override
	public void onClick(View v) {
		switch (v.getId()) {
		case R.id.btn_show:
			imageViewStub.setVisibility(View.VISIBLE);
			break;
		case R.id.btn_hide:
			imageViewStub.setVisibility(View.GONE);
			break;
		}// end switch
	}

}
