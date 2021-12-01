package com.example.asspageone;

import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.inputmethod.EditorInfo;
import android.widget.SearchView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {





    RecyclerView recyclerViewforCards;
    ArrayList<Subjects> subjects = new ArrayList<>();


    RecyclerView.LayoutManager subjectCardLayoutManager;
    SubjectAdapter adapter1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        createDue();
        buildReecyclerViewForSubject();

    }

    public void createDue() {
        subjects = new ArrayList<>();
        subjects.add(new Subjects(R.drawable.mathematics_, "0 Assignment", "Mathematics"));
        subjects.add(new Subjects(R.drawable.computer, "0 Assignment", "Computer Science"));
        subjects.add(new Subjects(R.drawable.sbj_geography, "0 Assignment", "Geography"));
        subjects.add(new Subjects(R.drawable.botany, "0 Assignment", "Botany"));
        subjects.add(new Subjects(R.drawable.businessstudies, "0 Assignment", "Business Studies"));
        subjects.add(new Subjects(R.drawable.account, "0 Assignment", "Accountancy"));


    }

    public void buildReecyclerViewForSubject() {
        recyclerViewforCards = findViewById(R.id.subjects_recyclerView);
        recyclerViewforCards.setHasFixedSize(true);
        subjectCardLayoutManager = new GridLayoutManager(this, 2, GridLayoutManager.VERTICAL, false);
        recyclerViewforCards.setLayoutManager(subjectCardLayoutManager);
        adapter1 = new SubjectAdapter(subjects);
        recyclerViewforCards.setAdapter(adapter1);
    }
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {

        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.menu,menu);

        MenuItem searchItem = menu.findItem(R.id.search);
        SearchView searchView = (SearchView) searchItem.getActionView();
        searchView.setImeOptions(EditorInfo.IME_ACTION_DONE);

        searchView.setOnQueryTextListener(new SearchView.OnQueryTextListener() {
            @Override
            public boolean onQueryTextSubmit(String query) {
                return false;
            }

            @Override
            public boolean onQueryTextChange(String newText) {
                adapter1.getFilter().filter(newText);

                return false;
            }
        });


        return true;
    }

}