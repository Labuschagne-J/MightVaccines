package jeanhomepc.createbatch;

import com.android.volley.Response;
import com.android.volley.toolbox.StringRequest;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by Jean on 2017/09/06.
 */

public class RegisterRequest extends StringRequest {

    private static final String REGISTER_REQUEST_URL = "https://Android.000webhostapp.com/select.php";
    private Map<String, String> params;

    public RegisterRequest(String bnr, String state, String cP, String cO, Response.Listener<String> listener) {
        super(Method.POST, REGISTER_REQUEST_URL, listener, null);

        params = new HashMap<>();
        params.put("Batch_Nr", bnr);
        params.put("State", state);
        params.put("Current_Process", cP);
        params.put("Current_Owner", cO);
    }

    @Override
    public Map<String, String> getParams() {
        return params;
    }


}


