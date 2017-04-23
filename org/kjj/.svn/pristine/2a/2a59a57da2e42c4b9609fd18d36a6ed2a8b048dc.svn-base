
var cpSmall = ColorPicker(document.getElementById('small'), updateInputs);

var iHex = document.getElementById('hex');
var color = document.getElementById('color');

function updateInputs(hex) {
    iHex.value = hex;   
    color.style.backgroundColor = hex;
}

function updateColorPickers(hex) {    
    cpSmall.setHex(hex);
}


var initialHex = '#f4329c';
updateColorPickers(initialHex);


iHex.onchange = function() { updateColorPickers(iHex.value); };

