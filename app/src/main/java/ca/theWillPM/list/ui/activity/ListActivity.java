package ca.theWillPM.list.ui.activity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;
import android.widget.Toast;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import com.google.android.material.floatingactionbutton.FloatingActionButton;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import ca.theWillPM.list.DAO.ItemDAO;
import ca.theWillPM.list.R;
import ca.theWillPM.list.model.Item;

public class ListActivity extends AppCompatActivity {

    public static final String TITLE_APPBAR = "List";
    private final ItemDAO dao = new ItemDAO();

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list);
        setTitle(TITLE_APPBAR);
        configFabNewItem();
    }

    private void configFabNewItem() {
        FloatingActionButton btn = (FloatingActionButton) findViewById(R.id.activity_main_fab_new_item);
        btn.setOnClickListener(v -> openFormItemActivity());
    }

    private void openFormItemActivity() {
        startActivity(new Intent(ListActivity.this, FormItemActivity.class));
    }

    @Override
    protected void onResume() {
        super.onResume();
        configList();
    }

    private void configList() {
        ListView mainList = findViewById(R.id.activity_main_list);  //Correlates the .xml layout object to a java object
        mainList.setAdapter( new ArrayAdapter<>(                    //tells the program to adapt the list to a given context...
                this,                                        //...and follow a layout pattern from the android library
                android.R.layout.simple_list_item_1,
                dao.all()));
    }
}
