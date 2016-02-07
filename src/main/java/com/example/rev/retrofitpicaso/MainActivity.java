package com.example.rev.retrofitpicaso;

import android.media.Image;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.TextView;

import com.squareup.picasso.Picasso;


// importing gitmodel and gitapi

import com.example.rev.retrofitpicaso.gitModel;
import com.example.rev.retrofitpicaso.gitApi;

import org.w3c.dom.Text;

import retrofit.Callback;
import retrofit.RestAdapter;
import retrofit.RetrofitError;
import retrofit.client.Response;

public class MainActivity extends AppCompatActivity {
//    ImageView image;

        TextView text ;
        Button button;
        EditText editText;
        ProgressBar pb;
        String API = "https://api.github.com";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        //picasso code , not using now
//        image = (ImageView) findViewById(R.id.image);
//        Picasso.with(this)
//                .load("https://cms-assets.tutsplus.com/uploads/users/21/posts/19431/featured_image/CodeFeature.jpg")
//                .into(image);
        gitModel gitmodel = new gitModel();
        text = (TextView)findViewById(R.id.textView);
        button = (Button) findViewById(R.id.buttonMain);
        editText = (EditText) findViewById(R.id.editText);
        pb = (ProgressBar)findViewById(R.id.progressBar);
        pb.setVisibility(View.INVISIBLE);


        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String user = editText.getText().toString();
                pb.setVisibility(View.VISIBLE);
            // setting up the adapter
                RestAdapter restAdapter = new RestAdapter.Builder()
                        .setEndpoint(API).build();

                gitApi git = restAdapter.create(gitApi.class);

                //now using the adapter to make a rest call

                git.getFeed(user,new Callback<gitModel>() {

                    @Override
                    public void success(gitModel gitmodel, Response response) {
                        text.setText("Github Name :" + gitmodel.getLogin());
                        pb.setVisibility(View.INVISIBLE);
                    }
                    @Override
                    public void failure(RetrofitError error) {
                        text.setText(error.getMessage());
                        pb.setVisibility(View.INVISIBLE);
                    }
                });

            }

        });

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
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
