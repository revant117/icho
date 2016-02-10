package com.example.rev.retrofitpicaso;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.ProgressBar;
import android.widget.TextView;

import java.util.List;

import retrofit.Callback;
import retrofit.RestAdapter;
import retrofit.RetrofitError;
import retrofit.client.Response;
import com.example.rev.retrofitpicaso.InfiniteScrollListener;

public class infinite extends AppCompatActivity {

    ListView infActList;
    Button buttoninfact;
    EditText editTextinf;
    String API = "https://api.github.com";
    private List<repoModel> repos;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_infinite);

        repoModel repomodel = new repoModel();
        infActList = (ListView) findViewById(R.id.infActList);
        buttoninfact = (Button) findViewById(R.id.buttoninfact);
        editTextinf = (EditText) findViewById(R.id.editTextinf);

        buttoninfact.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                String user = editTextinf.getText().toString();
                apicall(user);


            }
        });


    }

    private void showList(){
        //String array to store all the book names
        String[] items = new String[repos.size()];

        //Traversing through the whole list to get all the names
        for(int i=0; i<repos.size(); i++){
            //Storing names to string array
            items[i] = repos.get(i).getName();
        }

        //Creating an array adapter for list view
       ArrayAdapter adapter = new ArrayAdapter<String>(this,R.layout.inf_act_list_item,items);

        //Setting adapter to listview
        infActList.setAdapter(adapter);
    }


    private void apicall(String params){
        RestAdapter restAdapter = new RestAdapter.Builder()
                .setEndpoint(API).build();
        gitApi git = restAdapter.create(gitApi.class);
        git.getRepo(params, new Callback<List<repoModel>>() {
            @Override
            public void success(List<repoModel> repoModels, Response response) {

                repos = repoModels;

                showList();

            }

            @Override
            public void failure(RetrofitError error) {

            }
        });
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_infinite, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
}
