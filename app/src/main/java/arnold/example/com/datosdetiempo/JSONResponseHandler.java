package arnold.example.com.datosdetiempo;

import org.apache.http.HttpResponse;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.ResponseHandler;
import org.apache.http.impl.client.BasicResponseHandler;
import org.json.JSONException;
import org.json.JSONObject;
import org.json.JSONTokener;

import java.io.IOException;


public class JSONResponseHandler implements ResponseHandler<clima> {

    @Override
    public clima handleResponse(HttpResponse response)
            throws ClientProtocolException, IOException {
       clima result = new clima(0,0,0);
        String JSONResponse = new BasicResponseHandler()
                .handleResponse(response);
        try {

            // Get top-level JSON Object - a Map
            JSONObject responseObject = (JSONObject) new JSONTokener(
                    JSONResponse).nextValue();


             JSONObject mainObject=  responseObject.getJSONObject("main");
            result.setTemperatura_actual(mainObject.getInt("temp"));
            result.setTemperatura_minima(mainObject.getInt("temp_min"));
            result.setTemperatura_maxima(mainObject.getInt("temp_max"));

       } catch (JSONException e) {
            e.printStackTrace();
       }
        return result;
    }
}

