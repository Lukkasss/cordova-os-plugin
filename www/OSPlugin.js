var exec = require('cordova/exec');

exports.coolMethod = function (arg0, success, error) {
    exec(success, error, 'OSPlugin', 'coolMethod', [arg0]);
};

let OSPlugin = {
    showToast: (message, duration, successCallback, errorCallback) => {
        exec(successCallback, errorCallback, 'OSPlugin', 'showToast', [message, duration]);
    }
};

module.exports = OSPlugin;
