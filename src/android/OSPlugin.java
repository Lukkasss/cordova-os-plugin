package cordova.os.plugin;

import org.apache.cordova.CordovaPlugin;
import org.apache.cordova.CallbackContext;
import android.widget.Toast;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/**
 * This class echoes a string called from JavaScript.
 */
public class OSPlugin extends CordovaPlugin {

    @Override
    public boolean execute(String action, JSONArray args, CallbackContext callbackContext) throws JSONException {
        if (action.equals("coolMethod")) {
            this.coolMethod("Hello World", callbackContext);
            return true;
        }
        return false;
    }

    private void coolMethod(String message, CallbackContext callbackContext) {
        if (message != null && message.length() > 0) {
            cordova.getActivity().runOnUiThread(new Runnable() {
                public void run() {
                    Toast.makeText(cordova.getActivity(), message, 15).show();
                }
            });
            callbackContext.success(message);
        } else {
            callbackContext.error("Expected one non-empty string argument.");
        }
    }

    private void showToast(final String message, final int duration) {
        cordova.getActivity().runOnUiThread(new Runnable() {
            public void run() {
                Toast.makeText(cordova.getActivity(), message, duration).show();
            }
        });
    }
}
