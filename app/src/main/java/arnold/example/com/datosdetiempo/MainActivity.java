package arnold.example.com.datosdetiempo;

import android.content.Intent;
import android.net.http.AndroidHttpClient;
import android.os.AsyncTask;
import android.os.Bundle;
import android.support.v7.app.ActionBarActivity;
import android.util.Log;
import android.widget.TextView;
import android.widget.Toast;

import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.methods.HttpGet;

import java.io.IOException;


public class MainActivity extends ActionBarActivity {

    private static TextView min;
    private static TextView max;
    private static TextView actual;
    private static TextView nomb_ciudad;
    //private Button actualizar;

    private static String ciudad;

    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);

        setContentView(R.layout.activity_main);

        Intent intent = getIntent();
        ciudad = intent.getStringExtra("Ciudad");
        Toast.makeText(this, ciudad + " selected", Toast.LENGTH_LONG).show();

        nomb_ciudad = (TextView) findViewById(R.id.nomb_ciudad);
        nomb_ciudad.setText(ciudad);

        min = (TextView) findViewById(R.id.temp_minima);
        max = (TextView) findViewById(R.id.temp_maxima);
        actual = (TextView) findViewById(R.id.temp_actual);

       new HttpGetTask().execute();

        /*actualizar = (Button) findViewById(R.id.btn_actualizar);


        actualizar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                new HttpGetTask().execute();
            }
        });*/


    }

    private static class HttpGetTask extends AsyncTask<Void, Void, clima> {

        public static final String NOM_CIUDAD = ciudad;

        public static final String URL = "http://api.openweathermap.org/data/2.5/weather?q="+NOM_CIUDAD;



        AndroidHttpClient mClient = AndroidHttpClient.newInstance("");

        @Override
        protected clima doInBackground(Void... params) {
            HttpGet request = new HttpGet(URL);
            JSONResponseHandler responseHandler = new JSONResponseHandler();
            try {
                return mClient.execute(request, responseHandler);
            } catch (ClientProtocolException e) {
                e.printStackTrace();
            } catch (IOException e) {
                e.printStackTrace();
            }
            Log.d("ejecutado", request.toString());
            return null;
        }

        @Override
        protected void onPostExecute(clima result) {
            if (null != mClient)
                mClient.close();

            min.setText("Minima: " + Math.round(Double.parseDouble(result.getmin())));
            max.setText("Maxima: "+ Math.round(Double.parseDouble(result.getmax())));
            actual.setText(" "+ Math.round(Double.parseDouble(result.getactual())));
        }
    }
}