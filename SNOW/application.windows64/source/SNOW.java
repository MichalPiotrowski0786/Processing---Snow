import processing.core.*; 
import processing.data.*; 
import processing.event.*; 
import processing.opengl.*; 

import java.util.HashMap; 
import java.util.ArrayList; 
import java.io.File; 
import java.io.BufferedReader; 
import java.io.PrintWriter; 
import java.io.InputStream; 
import java.io.OutputStream; 
import java.io.IOException; 

public class SNOW extends PApplet {

final int W = 1600;
final int H = 800;
int[][] indexOld = new int[W][H];
public void settings(){
  size(W,H);
}
public void setup(){
}
public void draw(){
   for(int i = 0; i < W; i+=floor(random(0,75))){
    for(int j = 0; j < 1; j++){
      indexOld[i][j] = floor(random(2));
    }
  }
  rules();
  println(PApplet.parseInt(frameRate));
  //ground();
}
public void ground(){
float xOff = 0;
for(int x = 0; x < W; x++){
  float n = noise(xOff,0,0)*100;
  fill(51);
  noStroke();
  rect(x,H,1,-n);
  xOff+=0.01f;
 }
}
public void rules(){
int[][] indexNew = new int[W][H];
  for(int i = 1; i < W-1; i++){
    for(int j = 1; j < H-1; j++){
      if(indexOld[i][j] == 0 && indexOld[i][j-1] == 1 && indexOld[i][j] != 1)
      {
        indexNew[i][j] = 1;
        indexNew[i][j-1] = 0;
      }
      else if(indexOld[i][j] == 1 && indexOld[i][j-1] == 1)
      {
        indexNew[i][j] = 1;
        indexNew[i][j-1] = 1;
      }
      else if(mouseX == i && mouseY == j && mousePressed == true)
      {
        indexNew[i][j] = 1;
      }
      else
      {
        indexNew[i][j] = indexOld[i][j];
      }     
    }
  }
  loadPixels();
  for(int i = 1; i < W; i++){
    for(int j = 1; j < H; j++){
      if(indexOld[i][j] == 0)
      {
        pixels[i+j*W] = color(65,105,225);
      }
      else if(indexOld[i][j] == 1)
      {
        pixels[i+j*W] = color(255);
      }
    }
   } 
   updatePixels();
  indexOld = indexNew;
}
  static public void main(String[] passedArgs) {
    String[] appletArgs = new String[] { "SNOW" };
    if (passedArgs != null) {
      PApplet.main(concat(appletArgs, passedArgs));
    } else {
      PApplet.main(appletArgs);
    }
  }
}
