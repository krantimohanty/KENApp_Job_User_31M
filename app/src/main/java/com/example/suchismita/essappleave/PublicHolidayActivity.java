package com.example.suchismita.essappleave;

import android.annotation.SuppressLint;
import android.app.usage.UsageEvents;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.NavigationView;
import android.support.v4.app.FragmentTransaction;
import android.support.v4.app.NavUtils;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBar;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.MenuItem;
import android.widget.ListView;
import android.widget.TextView;
import butterknife.BindView;

import butterknife.ButterKnife;

import io.blackbox_vision.materialcalendarview.view.CalendarView;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.Locale;

import com.example.suchismita.essappleave.Adapter.ListAdapter;
import com.example.suchismita.essappleave.Model.ListModel;
import com.example.suchismita.essappleave.logic.presenter.MainPresenter;
import com.example.suchismita.essappleave.logic.presenter_view.MainView;

import io.blackbox_vision.materialcalendarview.view.CalendarView;

import static com.example.suchismita.essappleave.utils.AnimationUtils.animate;


@SuppressLint("SimpleDateFormat")
public class PublicHolidayActivity extends AppCompatActivity  implements MainView {
    private static final String DATE_TEMPLATE = "dd/MM/yyyy";
    private static final String MONTH_TEMPLATE = "MMMM yyyy";

    private final MainPresenter presenter = new MainPresenter(this);
    public List<ListModel> holidayList;
    @BindView(R.id.listView)
    ListView listview;

    @BindView(R.id.toolbar)
    Toolbar toolbar;


    @BindView(R.id.calendar_view)
   public CalendarView calendarView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_public_holiday);

        calendarView=(CalendarView)findViewById(R.id.calendar_view);
//        textView=(TextView)findViewById(R.id.textview);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
//        getSupportActionBar().setTitle("Public Holiday List");
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        ButterKnife.bind(this);
//        presenter.addNavigationDrawer();
        presenter.addCalendarView();
        presenter.addListView();
        presenter.animate();

    }
    @Override
    public void prepareListView() {

        final String[] dates = {"January 26", "February 1" , "March 24"};
        final String[] events = {"Republic Day", "Saraswati Puja" , "Mahashivaratri"};
        listview=(ListView)findViewById(R.id.listView);
        holidayList = new ArrayList<ListModel>();
        for(int i=0; i<dates.length; i++)
        {

            ListModel item = new ListModel(dates[i], events[i]);
            holidayList.add(item);

            ListAdapter adapter = new ListAdapter(PublicHolidayActivity.this,
                    R.layout.list_item, holidayList);
            listview.setAdapter(adapter);

        }


//        textView.setText(String.format("Today is %s", formatDate(DATE_TEMPLATE, new Date(System.currentTimeMillis()))));
    }

    @Override
    public void prepareCalendarView() {

//        disabledCal.set(Calendar.DATE, disabledCal.get(Calendar.DATE) - 1);
//        Bundle args = new Bundle();
        Calendar cal = Calendar.getInstance();
//        args.putInt(Calendar.MONTH, cal.get(Calendar.MONTH) + 1);
//        args.putInt(CaldroidFragment.YEAR, cal.get(Calendar.YEAR));
//        args.putBoolean(CaldroidFragment.ENABLE_SWIPE, true);
//

        cal.set(Calendar.MONTH, Calendar.JANUARY);
        cal.set(Calendar.DAY_OF_MONTH, 26);
        Date date = cal.getTime();
//        ColorDrawable blue = new ColorDrawable(getResources().getColor(R.color.blue));
//        calendarView.setBackgroundDrawableForDate(blue, date);
//        caldroidFragment.setTextColorForDate(R.color.white, date);
//        setCustomResourceForDates(date1);

        calendarView.setFirstDayOfWeek(Calendar.MONDAY)
                .setOnDateClickListener(this::onDateClick)
                .setOnMonthChangeListener(this::onMonthChange)
                .setOnDateLongClickListener(this::onDateLongClick)
                .setOnMonthTitleClickListener(this::onMonthTitleClick)
                .setDisabledDate(cal.getTime());

        if (calendarView.isMultiSelectDayEnabled()) {
            calendarView.setOnMultipleDaySelectedListener((month, dates) -> {
                //Do something with your current selection
            });
        }

        calendarView.update(Calendar.getInstance(Locale.getDefault()));
    }


    @Override
    public void animateViews() {
        calendarView.shouldAnimateOnEnter(true);
//        animate(fab, getApplicationContext());
//        animate(textView, getApplicationContext());
    }

    private void onDateLongClick(@NonNull final Date date) {
//        textView.setText(formatDate(DATE_TEMPLATE, date));
    }

    private void onDateClick(@NonNull final Date date) {
//        textView.setText(formatDate(DATE_TEMPLATE, date));
    }

    private void onMonthTitleClick(@NonNull final Date date) {
        //Do something after month selection
    }

    private void onMonthChange(@NonNull final Date date) {
        final ActionBar actionBar = getSupportActionBar();

        if (null != actionBar) {
            String dateStr = formatDate(MONTH_TEMPLATE, date);
            dateStr = dateStr.substring(0, 1).toUpperCase() + dateStr.substring(1, dateStr.length());

            actionBar.setTitle(dateStr);
        }
    }

    private String formatDate(@NonNull String dateTemplate, @NonNull Date date) {
        return new SimpleDateFormat(dateTemplate, Locale.getDefault()).format(date);
    }
    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            // Respond to the action bar's Up/Home button
            case android.R.id.home:
                NavUtils.navigateUpFromSameTask(this);
                return true;
        }
        return super.onOptionsItemSelected(item);
    }
}
