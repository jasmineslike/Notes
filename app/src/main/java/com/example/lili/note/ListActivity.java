package com.example.lili.note;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.Menu;
import android.view.MenuItem;

import com.amazonaws.mobile.auth.core.IdentityManager;

import java.util.ArrayList;
import java.util.List;

public class ListActivity extends AppCompatActivity {

    RecyclerView recyclerView;
    ProductorAdapter adapter;

    List<Product> productList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list);

        productList = new ArrayList<>();

        recyclerView =(RecyclerView) findViewById(R.id.recyclerView);
        adapter = new ProductorAdapter(this, productList);

        recyclerView.setLayoutManager(new LinearLayoutManager(this));


        productList.add(
                new Product(
                        1,
                        "Barron's AP Biology, 6th Edition",
                        "Barron’s AP Biology is one of the most popular test preparation guides around and a “must-have” manual for success on the Biology AP Test.\n" +
                                "Contact: email: 290884384@qq,com \n" +
                                "               Phone: 7143252421 \n" +
                                "                LastName : Xu ",
                        15));

        productList.add(
                new Product(
                        2,
                        "Head First Java",
                        "Learning a complex new language is no easy task especially when it s an object-oriented computer programming language like Java.\n" +
                                "Contact: email: chanelM@gmail,com \n" +
                                "               Phone: 9723642123 \n" +
                                "                LastName : Mendoza ",
                        40));

        productList.add(
                new Product(
                        3,
                        "Barron's AP Physics C, 4th Edition)",
                        "One diagnostic test and two full-length Physics C practice tests\n" +
                                "All test questions answered and explained.\n" +
                                "A detailed review of all test topics \n" +
                                "Contact: email: EddieSeng@yahoo,com \n" +
                                "               Phone: 8736234821 \n" +
                                "                LastName : Seng ",
                        17));



        adapter = new ProductorAdapter(this, productList);
        recyclerView.setAdapter(adapter);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_post, menu);
        return true;
    }
    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        int id = item.getItemId();

        switch (id){
            case R.id.menu_main_singOut:
                signout();
                break;
        }


        return super.onOptionsItemSelected(item);
    }

    private void signout() {
        IdentityManager.getDefaultIdentityManager().signOut();
    }
}
