package com.example.a2ndinclassactivity;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import java.lang.reflect.Type;
import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    ArrayList<Book> bookList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        addData();
        setInsertButton();

        Button buttonSave = findViewById(R.id.saveBtn);
        buttonSave.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                saveData();
            }
        });
    }

    private void saveData() {
        SharedPreferences sharedPreferences = getSharedPreferences("shared preferences", MODE_PRIVATE);
        SharedPreferences.Editor editor = sharedPreferences.edit();
        Gson gson = new Gson();
        String json = gson.toJson(bookList);
        editor.putString("task list", json);
        editor.apply();
    }

    private void addData() {
        SharedPreferences sharedPreferences = getSharedPreferences("shared preferences", MODE_PRIVATE);
        Gson gson = new Gson();
        String json = sharedPreferences.getString("task list", null);
        Type type = new TypeToken<ArrayList<Book>>() {}.getType();
        bookList = gson.fromJson(json, type);

        if (bookList == null) {
            bookList = new ArrayList<>();
        }
    }

    private void setInsertButton() {
        Button buttonInsert = findViewById(R.id.addBtn);
        buttonInsert.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                EditText bookTitle = findViewById(R.id.bookText);
                EditText author = findViewById(R.id.authorText);
                EditText pages = findViewById(R.id.pagesText);
                insertItem(bookTitle.getText().toString(), author.getText().toString(), pages.getText().toString());
            }
        });
    }

    private void insertItem(String bookTitle, String author, String pages) {
        bookList.add(new Book(bookTitle, author,pages));
    }
}
