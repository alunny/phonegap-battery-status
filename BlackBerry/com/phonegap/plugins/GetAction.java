package com.phonegap.plugins;

import com.phonegap.api.PluginResult;

import org.json.me.JSONArray;
import org.json.me.JSONException;
import org.json.me.JSONObject;

import net.rim.device.api.system.DeviceInfo;

/**
 * Get system informaton based on the [W3C System Info API](http://www.w3.org/TR/system-info-api/).
 *
 * The following properties are supported:
 *   - Power (partial implementation)
 *
 */
public class GetAction {
    
    private static final String PROPERTY_POWER = "power";
    
    /**
     * Find the values for a system property.
     *
     * @param args JSONArray index 0 is the property to get.
     * @return A CommandResult object with the success or failure state for finding
     *         the state of the network.
     */
    public static PluginResult execute(JSONArray args) {
        PluginResult result   = null;
        String       property = getPropertyName(args);
        
        if (property.equals(PROPERTY_POWER)) {
            result = getPower();
        }
        else {
            result = new PluginResult(PluginResult.Status.INVALIDACTION, "Unknown property: " + property);
        }
        
        return result;
    }
    
    /**
     * Find the property name
     *
     * @param args JSONArray index 0 is the property to get.
     * @return the property or an empty String
     */
    private static String getPropertyName(JSONArray args) {
        try {
            return args.getString(0).toLowerCase();
        }
        catch (JSONException e) {
            return "";
        }
    }
    
    /**
     * Get Power Information
     *
     * @return a JSON Object with the power level
     */
    private static PluginResult getPower() {
        JSONObject json = new JSONObject();
        
        try {
            json.put("level", DeviceInfo.getBatteryLevel());
        }
        catch (JSONException e) {
        }
        
        return new PluginResult(PluginResult.Status.OK, json);
    }
}