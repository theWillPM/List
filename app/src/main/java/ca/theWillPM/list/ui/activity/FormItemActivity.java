package ca.theWillPM.list.ui.activity;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.Gravity;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import ca.theWillPM.list.DAO.ItemDAO;
import ca.theWillPM.list.R;
import ca.theWillPM.list.model.Item;

public class FormItemActivity extends AppCompatActivity {

    private static final String TITLE_APPBAR = "New Item";
    private EditText nameField;
    private EditText priceField;
    private EditText dateField;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_form_item);

        setTitle(TITLE_APPBAR);
        ItemDAO dao = new ItemDAO();
        textFieldInitilizer();

        Button formAddBtn = findViewById(R.id.add_button);
        formAddBtn.setOnClickListener(view -> {

            Item createdItem = createItem();
            showOnCreateConfirmation(createdItem);
            saveAndFinish(dao, createdItem);

        });


    }

    private void saveAndFinish(ItemDAO dao, Item createdItem) {
        dao.save(createdItem);
        finish();
    }

    private void showOnCreateConfirmation(Item createdItem) {
        Toast addToast = Toast.makeText(FormItemActivity.this,
                "Added " + createdItem.getClass().getSimpleName() + " to list.",
                Toast.LENGTH_SHORT);
        addToast.setGravity(Gravity.CENTER,0,0);
        addToast.show();
    }

    @NonNull
    private Item createItem() {
        String name = nameField.getText().toString();
        String price = priceField.getText().toString();
        String date = dateField.getText().toString();

        Item createdItem = new Item(name, price, date);
        return createdItem;
    }

    private void textFieldInitilizer() {
        nameField = findViewById(R.id.activity_form_item_name);
        priceField = findViewById(R.id.activity_form_item_price);
        dateField = findViewById(R.id.activity_form_item_date);
    }
}