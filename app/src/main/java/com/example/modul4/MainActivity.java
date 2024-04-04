package com.example.modul4;

import android.app.DatePickerDialog;
import android.app.TimePickerDialog;
import android.os.Bundle;
import android.view.View;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.TimePicker;
import androidx.appcompat.app.AppCompatActivity;
import java.util.Calendar;

public class MainActivity extends AppCompatActivity {
    private EditText tanggalEditText, waktuEditText;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        tanggalEditText = findViewById(R.id.tanggal);
        waktuEditText = findViewById(R.id.waktu);
    }

    /**
     * Menampilkan dialog untuk memilih tanggal.
     * @param v View yang dipilih
     */
    public void setTanggal(View v) {
        final Calendar calendar = Calendar.getInstance();
        int tahun = calendar.get(Calendar.YEAR);
        int bulan = calendar.get(Calendar.MONTH);
        int tanggal = calendar.get(Calendar.DAY_OF_MONTH);

        DatePickerDialog datePickerDialog = new DatePickerDialog(MainActivity.this,
                new DatePickerDialog.OnDateSetListener() {
                    @Override
                    public void onDateSet(DatePicker view, int tahun, int bulan, int tanggal) {
                        // Ubah format tanggal ke Tahun/Bulan/Tanggal
                        tanggalEditText.setText(tahun + "/" + (bulan + 1) + "/" + tanggal);
                    }
                }, tahun, bulan, tanggal);
        datePickerDialog.show();
    }


    /**
     * Menampilkan dialog untuk memilih waktu.
     * @param v View yang dipilih
     */
    public void setWaktu(View v) {
        final Calendar calendar = Calendar.getInstance();
        int jam = calendar.get(Calendar.HOUR_OF_DAY);
        int menit = calendar.get(Calendar.MINUTE);

        TimePickerDialog timePickerDialog = new TimePickerDialog(MainActivity.this,
                new TimePickerDialog.OnTimeSetListener() {
                    @Override
                    public void onTimeSet(TimePicker view, int jam, int menit) {
                        waktuEditText.setText(String.format("%02d:%02d", jam, menit));
                    }
                }, jam, menit, false);
        timePickerDialog.show();
    }
}
