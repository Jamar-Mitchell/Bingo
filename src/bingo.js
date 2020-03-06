$(document).ready(function() {
  loadTable();
  $("td").click(function() {
    $(this).toggleClass("highlight");
    saveTable();
  });
});

function saveTable() {
  var name = document.getElementById("cardHolder").innerHTML.split(":")[1];
  var numRound = document.getElementById("numround").innerHTML.split(" ")[1];
  var _table =
    name.split(" ")[1].trim() +
    "_" +
    name.split(" ")[2].trim() +
    " Round" +
    numRound;

  localStorage._firstUse = "no";

  localStorage[_table] = document.getElementById("cards").innerHTML;
  console.log("saved table for " + _table);
}

function loadTable() {
  var name = document.getElementById("cardHolder").innerHTML.split(":")[1];
  var numRound = document.getElementById("numround").innerHTML.split(" ")[1];
  var _table =
    name.split(" ")[1].trim() +
    "_" +
    name.split(" ")[2].trim() +
    " Round" +
    numRound;

  if (
    localStorage._firstUse == "no" &&
    typeof localStorage[_table] !== "undefined"
  ) {
    console.log("previous Table for " + _table + " loaded");
    document.getElementById("cards").innerHTML = localStorage[_table];
  } else {
    console.log("first time loading");
  }
}
