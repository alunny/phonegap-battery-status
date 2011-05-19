package com.phonegap.plugins;

import org.json.me.JSONArray;

import com.phonegap.api.Plugin;
import com.phonegap.api.PluginResult;

public class Battery extends Plugin {

    /**
     * Plugin actions
     */
    protected static final String ACTION_GET = "get";
    
    /**
     * Executes the requested action and returns a PluginResult.
     * 
     * @param action        The action to execute.
     * @param callbackId    The callback ID to be invoked upon action completion.
     * @param args          JSONArry of arguments for the action.
     * @return              A PluginResult object with a status and message.
     */
    public PluginResult execute(String action, JSONArray args, String callbackId) {
        PluginResult result = null;

        /* Normalize the action */
        action = (action == null) ? "" : action.toLowerCase();
        
        /*
         * Determine action to execute.
         */
        if (action.equals(ACTION_GET)) {
            result = GetAction.execute(args);
        } 
        else {
            result = new PluginResult(PluginResult.Status.INVALIDACTION, "Battery: invalid action " + action);
        }
        
        return result;
    }
    
    /**
     * Called when Plugin is paused. 
     */
    public void onPause() {
        
    }
    
    /**
     * Called when Plugin is resumed. 
     */
    public void onResume() {
        
    }
    
    /**
     * Called when Plugin is destroyed. 
     */
    public void onDestroy() {
        
    }    
}