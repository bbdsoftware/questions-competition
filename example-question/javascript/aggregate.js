'use strict';

const fs = require('fs');
process.stdin.resume();
process.stdin.setEncoding('utf-8');

let inputString = '';
let currentLine = 0;
process.stdin.on('data', function(inputStdin) {
    inputString += inputStdin;
});
process.stdin.on('end', function() {
    inputString = inputString.split('\n');

    main();
});

function readLine() {
    return inputString[currentLine++];
}
function AggregateNames(nameList) {
    //YOUR ANSWER GOES HERE
}

function main() {
    const ws = fs.createWriteStream(process.env.OUTPUT_PATH);
    const nameListCount = parseInt(readLine().trim(), 10);
    let nameList = [];
    for (let i = 0; i < nameListCount; i++) {
        const nameListItem = readLine();
        nameList.push(nameListItem);
    }
    let result = AggregateNames(nameList);
    result = sortOnKeys(result);
    for(var key in result) {
        ws.write(key + ' ' + result[key] + '\n');
    }
    ws.end();
}

function sortOnKeys(dict) {
    var sorted = [];
    for(var key in dict) {
        sorted[sorted.length] = key;
    }
    sorted.sort();
    var tempDict = {};
    for(var i = 0; i < sorted.length; i++) {
        tempDict[sorted[i]] = dict[sorted[i]];
    }
    return tempDict;
}
