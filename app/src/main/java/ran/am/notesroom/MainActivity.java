package ran.am.notesroom;

import androidx.appcompat.app.AppCompatActivity;

import android.os.AsyncTask;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void sa(View view) {
        SaveTask st = new SaveTask();
        st.execute();
    }

    class SaveTask extends AsyncTask<Void, Void, Void> {

        @Override
        protected Void doInBackground(Void... voids) {

            //creating a task
            Task task = new Task();
            task.setTask("buy computer");
            task.setDesc("i7 8gb");
            task.setFinishBy("this week");
            task.setFinished(false);

            //adding to database
            DatabaseClientt.getInstance(getApplicationContext()).getAppDatabase().taskDao().insert(task);
     return null;
        }

        @Override
        protected void onPostExecute(Void aVoid) {
            super.onPostExecute(aVoid);
            Toast.makeText(getApplicationContext(), "Saved", Toast.LENGTH_LONG).show();
        }
    }
}