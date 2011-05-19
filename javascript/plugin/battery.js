(function() {
    var Battery = function() {
        return {
            get: function(property, successCallback, errorCallback) {
                PhoneGap.exec(successCallback, errorCallback, 'Battery', 'get', [ property ]);
            }
        }
    };

    PhoneGap.addConstructor(function() {
        // add plugin to window.plugins
        // addPlugin wasn't implemented on iOS on my last check
        if (PhoneGap.addPlugin) {
            PhoneGap.addPlugin('battery', new Battery());
        } else {
            window.plugins.battery = new Battery();
        }

        // register plugin on native side
        phonegap.PluginManager.addPlugin('Battery', 'com.phonegap.plugins.Battery');
    });
})();
