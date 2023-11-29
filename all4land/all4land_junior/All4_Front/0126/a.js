
function start(){
  var textBox = document.getElementById("text1").value;
  var color = document.getElementById("color").value;
  var size = document.getElementById("size").value;
  var shape = document.getElementsByName("style");
  var shapeArr = [];
  //체크된 값들을 저장
  for(var i=0; i<shape.length; i++){
      if(shape[i].checked){
        shapeArr.push(shape[i].value);
      }
  }
  //체크된 값들을 추출
  for(var i=0; i<shapeArr.length; i++){
      if(shapeArr[i]=="strike") textBox=textBox.strike();
      else if(shapeArr[i]=="big") textBox=textBox.big();
      else if(shapeArr[i]=="small") textBox=textBox.small();
      else if(shapeArr[i]=="bold") textBox=textBox.bold();
      else if(shapeArr[i]=="italics") textBox=textBox.italics();
      else if(shapeArr[i]=="sub") textBox=textBox.sub();
      else if(shapeArr[i]=="sup") textBox=textBox.sup();
      else if(shapeArr[i]=="upper") textBox=textBox.toUpperCase();
      else if(shapeArr[i]=="lower") textBox=textBox.toLowerCase();
  }
  textBox=textBox.fontsize(size);
  textBox=textBox.fontcolor(color);
  document.getElementById("output").innerHTML=textBox;
}