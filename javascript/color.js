(function(scope) {
    //
    // Adapted from: http://mjijackson.com/2008/02/rgb-to-hsl-and-rgb-to-hsv-color-model-conversion-algorithms-in-javascript
    //
    window.hsvToRgb = function(h, s, v){
        var r, g, b;

        h = h / 360;
        s = s / 100;
        v = v / 100;
        
        var i = Math.floor(h * 6);
        var f = h * 6 - i;
        var p = v * (1 - s);
        var q = v * (1 - f * s);
        var t = v * (1 - (1 - f) * s);

        switch(i % 6){
            case 0: r = v, g = t, b = p; break;
            case 1: r = q, g = v, b = p; break;
            case 2: r = p, g = v, b = t; break;
            case 3: r = p, g = q, b = v; break;
            case 4: r = t, g = p, b = v; break;
            case 5: r = v, g = p, b = q; break;
        }

        return [r * 255, g * 255, b * 255];
    }
    
    //
    // Adapted from: http://haacked.com/archive/2009/12/29/convert-rgb-to-hex.aspx
    //
    window.colorToHex = function(r, g, b) {
        var red   = parseInt(r);
        var green = parseInt(g);
        var blue  = parseInt(b);

        var rgb = blue | (green << 8) | (red << 16);
        return '#' + rgb.toString(16);
    };
})(window);