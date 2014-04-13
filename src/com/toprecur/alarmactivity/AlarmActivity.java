package com.toprecur.alarmactivity;

import java.util.Calendar;

import android.app.Activity;
import android.app.AlarmManager;
import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.Toast;

import android.widget.CompoundButton.OnCheckedChangeListener;
import android.widget.TimePicker.OnTimeChangedListener;
import android.widget.TextView;
import android.widget.TimePicker;

public class AlarmActivity extends Activity {

	TimePicker myTimePicker;
	Button buttonstartSetDialog;
	Button buttonCancelAlarm;
	TextView textAlarmPrompt;
	private Context ctx;
	TimePicker timePicker;
	CheckBox optRepeat;
	Intent intent;
	AlarmManager alarmManager;
	private PendingIntent pendingIntent, pendingIntent1, pendingIntent2,
			pendingIntent3, pendingIntent4, pendingIntent5, pendingIntent6,
			pendingIntent7;
	private CheckBox chk_monday, chk_tuesday, chk_wednesday, chk_thursday,
			chk_friday, chk_saturday, chk_sunday;
	final static int RQS_1 = 1;
	private static final String TAG = AlarmActivity.class.getName();
	private boolean timerflag = false;

	/** Called when the activity is first created. */
	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_alarm);

		ctx = this;

		timePicker = (TimePicker) findViewById(R.id.picker);
		// optRepeat = (CheckBox) findViewById(R.id.optrepeat);

		chk_monday = (CheckBox) findViewById(R.id.optrepeat1);

		chk_tuesday = (CheckBox) findViewById(R.id.optrepeat2);
		chk_wednesday = (CheckBox) findViewById(R.id.optrepeat3);
		chk_thursday = (CheckBox) findViewById(R.id.optrepeat4);

		chk_friday = (CheckBox) findViewById(R.id.optrepeat5);

		chk_saturday = (CheckBox) findViewById(R.id.optrepeat6);

		chk_sunday = (CheckBox) findViewById(R.id.optrepeat7);

		textAlarmPrompt = (TextView) findViewById(R.id.alarmprompt);

		buttonstartSetDialog = (Button) findViewById(R.id.startSetDialog);
		buttonstartSetDialog.setOnClickListener(new OnClickListener() {

			@Override
			public void onClick(View v) {
				Calendar calNow = Calendar.getInstance();
				Calendar calSet = (Calendar) calNow.clone();

				calSet.set(Calendar.HOUR_OF_DAY, timePicker.getCurrentHour());
				calSet.set(Calendar.MINUTE, timePicker.getCurrentMinute());
				calSet.set(Calendar.SECOND, 0);
				// calSet.set(Calendar.MILL ISECOND, 0);

				if (calSet.compareTo(calNow) <= 0) {
					// Today Set time passed, count to tomorrow
					calSet.add(Calendar.DATE, 1);
				}
				onChecked(calSet);
				setAlarm(calSet);
				

			}

		});

		buttonCancelAlarm = (Button) findViewById(R.id.cancel);
		buttonCancelAlarm.setOnClickListener(new OnClickListener() {

			@Override
			public void onClick(View arg0) {
				cancelAlarm();
			}
		});

	

		// chk_monday.setOnCheckedChangeListener(this);

	}

	private void onChecked(final Calendar targetCal) {
		chk_monday
				.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {

					@Override
					public void onCheckedChanged(CompoundButton buttonView,
							boolean isChecked) {
						if (buttonView == chk_monday) {
							if (isChecked) {
								intent = new Intent(getBaseContext(), AlarmReciever.class);
								pendingIntent1 = PendingIntent.getBroadcast(getBaseContext(), 1,
										intent, Intent.FLAG_ACTIVITY_NEW_TASK);
								 alarmManager = (AlarmManager) getSystemService(Context.ALARM_SERVICE);
								forday(1, pendingIntent1, targetCal);
								Toast.makeText(ctx, "checked" + buttonView,
										Toast.LENGTH_LONG).show();
							}
						}

					}
				});
		chk_tuesday
				.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {

					@Override
					public void onCheckedChanged(CompoundButton buttonView,
							boolean isChecked) {
						if (buttonView == chk_tuesday) {
							if (isChecked) {
								intent = new Intent(getBaseContext(), AlarmReciever.class);
								pendingIntent2 = PendingIntent.getBroadcast(getBaseContext(), 2,
										intent, Intent.FLAG_ACTIVITY_NEW_TASK);
								 alarmManager = (AlarmManager) getSystemService(Context.ALARM_SERVICE);
								 forday(2, pendingIntent2, targetCal);
								Toast.makeText(ctx, "checked" + buttonView,
										Toast.LENGTH_LONG).show();
							}
						}

					}
				});
		chk_wednesday
				.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {

					@Override
					public void onCheckedChanged(CompoundButton buttonView,
							boolean isChecked) {
						if (buttonView == chk_wednesday) {
							if (isChecked) {
								intent = new Intent(getBaseContext(), AlarmReciever.class);
								pendingIntent3 = PendingIntent.getBroadcast(getBaseContext(), 3,
										intent, Intent.FLAG_ACTIVITY_NEW_TASK);
								 alarmManager = (AlarmManager) getSystemService(Context.ALARM_SERVICE);
								 forday(3, pendingIntent3, targetCal);
								Toast.makeText(ctx, "checked",
										Toast.LENGTH_LONG).show();
							}
						}

					}
				});
		chk_thursday
				.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {

					@Override
					public void onCheckedChanged(CompoundButton buttonView,
							boolean isChecked) {
						if (buttonView == chk_thursday) {
							if (isChecked) {
								intent = new Intent(getBaseContext(), AlarmReciever.class);
								pendingIntent4 = PendingIntent.getBroadcast(getBaseContext(), 4,
										intent, Intent.FLAG_ACTIVITY_NEW_TASK);
								 alarmManager = (AlarmManager) getSystemService(Context.ALARM_SERVICE);
								 forday(4, pendingIntent4, targetCal);
								Toast.makeText(ctx, "checked",
										Toast.LENGTH_LONG).show();
							}
						}

					}
				});
		chk_friday
				.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {

					@Override
					public void onCheckedChanged(CompoundButton buttonView,
							boolean isChecked) {
						if (buttonView == chk_friday) {
							if (isChecked) {
								intent = new Intent(getBaseContext(), AlarmReciever.class);
								pendingIntent5 = PendingIntent.getBroadcast(getBaseContext(), 5,
										intent, Intent.FLAG_ACTIVITY_NEW_TASK);
								 alarmManager = (AlarmManager) getSystemService(Context.ALARM_SERVICE);
								 forday(5, pendingIntent5, targetCal);
								Toast.makeText(ctx, "checked",
										Toast.LENGTH_LONG).show();
							}
						}

					}
				});
		chk_saturday
				.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {

					@Override
					public void onCheckedChanged(CompoundButton buttonView,
							boolean isChecked) {
						if (buttonView == chk_saturday) {
							if (isChecked) {
								intent = new Intent(getBaseContext(), AlarmReciever.class);
								pendingIntent6 = PendingIntent.getBroadcast(getBaseContext(), 6,
										intent, Intent.FLAG_ACTIVITY_NEW_TASK);
								 alarmManager = (AlarmManager) getSystemService(Context.ALARM_SERVICE);
								 forday(6, pendingIntent6, targetCal);
								Toast.makeText(ctx, "checked",
										Toast.LENGTH_LONG).show();
							}
						}

					}
				});
		chk_sunday
				.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {

					@Override
					public void onCheckedChanged(CompoundButton buttonView,
							boolean isChecked) {
						if (buttonView == chk_sunday) {
							if (isChecked) {
								intent = new Intent(getBaseContext(), AlarmReciever.class);
								pendingIntent7 = PendingIntent.getBroadcast(getBaseContext(), 7,
										intent, Intent.FLAG_ACTIVITY_NEW_TASK);
								 alarmManager = (AlarmManager) getSystemService(Context.ALARM_SERVICE);
								 forday(7, pendingIntent7, targetCal);
								Toast.makeText(ctx, "checked",
										Toast.LENGTH_LONG).show();
							}
						}

					}
				});

	}

	private void setAlarm(Calendar targetCal) {

		intent = new Intent(getBaseContext(), AlarmReciever.class);
		pendingIntent = PendingIntent.getBroadcast(getBaseContext(), RQS_1,
				intent, 0);
		AlarmManager alarmManager = (AlarmManager) getSystemService(Context.ALARM_SERVICE);
		alarmManager.set(AlarmManager.RTC_WAKEUP, targetCal.getTimeInMillis(),
				pendingIntent);
		

		/*if (repeat) {
			alarmManager.setRepeating(AlarmManager.RTC_WAKEUP,
					targetCal.getTimeInMillis(),
					AlarmManager.INTERVAL_FIFTEEN_MINUTES, pendingIntent);*/

			/*
			 * alarmManager.setInexactRepeating(AlarmManager.RTC_WAKEUP,
			 * targetCal.getTimeInMillis(),
			 * AlarmManager.INTERVAL_FIFTEEN_MINUTES, pendingIntent);
			 */

			/*
			 * textAlarmPrompt.setText( "\n\n***\n" + "Alarm is set@ " +
			 * targetCal.getTime() + "\n" + "Repeat every 5 minutes\n" +
			 * "***\n");
			 */
		/*} else {
			alarmManager.set(AlarmManager.RTC_WAKEUP,
					targetCal.getTimeInMillis(), pendingIntent);

			textAlarmPrompt.setText("\n\n***\n" + "Alarm is set@ "
					+ targetCal.getTime() + "\n" + "One shot\n" + "***\n");
		}*/

	}

	private void cancelAlarm() {

		textAlarmPrompt.setText("\n\n***\n" + "Alarm Cancelled! \n" + "***\n");

		Intent intent = new Intent(getBaseContext(), AlarmReciever.class);
		PendingIntent pendingIntent = PendingIntent.getBroadcast(
				getBaseContext(), RQS_1, intent, 0);
		alarmManager = (AlarmManager) getSystemService(Context.ALARM_SERVICE);
		alarmManager.cancel(pendingIntent);

	}

	/*
	 * private void setListener() {
	 * 
	 * chk_monday.setOnCheckedChangeListener(this);
	 * 
	 * chk_tuesday.setOnCheckedChangeListener(this);
	 * 
	 * chk_wednesday.setOnCheckedChangeListener(this);
	 * 
	 * chk_thursday.setOnCheckedChangeListener(this);
	 * 
	 * chk_friday.setOnCheckedChangeListener(this);
	 * 
	 * chk_sat.setOnCheckedChangeListener(this);
	 * 
	 * chk_sunday.setOnCheckedChangeListener(this);
	 * 
	 * timePicker.setOnTimeChangedListener(new OnTimeChangedListener() {
	 * 
	 * public void onTimeChanged(TimePicker view, int hourOfDay, int minute) {
	 * 
	 * // TODO Auto-generated method stub
	 * 
	 * timerflag = true;
	 * 
	 * }
	 * 
	 * });
	 * 
	 * }
	 */

	public void forday(int week, PendingIntent pendingIntent, Calendar targetCal) {

		
		Calendar calSet = Calendar.getInstance();

		int hour = timePicker.getCurrentHour();

		int minute = timePicker.getCurrentMinute();

		calSet.set(Calendar.DAY_OF_WEEK, week);

		calSet.set(Calendar.HOUR_OF_DAY, hour);

		calSet.set(Calendar.MINUTE, minute);

		calSet.set(Calendar.SECOND, 0);

		calSet.set(Calendar.MILLISECOND, 0);

		alarmManager.setRepeating(AlarmManager.RTC_WAKEUP,
				calSet.getTimeInMillis(), AlarmManager.INTERVAL_DAY * 7,
				pendingIntent);
		textAlarmPrompt.setText("\n\n***\n" + "Alarm is set@ "
				+ targetCal.getTime() + "\n" + "One shot\n" + "***\n");

	}

}