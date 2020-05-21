final int W = 1600;
final int H = 800;
int[][] indexOld = new int[W][H];
void settings(){
  size(W,H);
}
void setup(){
}
void draw(){
   for(int i = 0; i < W; i+=floor(random(0,75))){
    for(int j = 0; j < 1; j++){
      indexOld[i][j] = floor(random(2));
    }
  }
  rules();
  println(int(frameRate));
  //ground();
}
void ground(){
float xOff = 0;
for(int x = 0; x < W; x++){
  float n = noise(xOff,0,0)*100;
  fill(51);
  noStroke();
  rect(x,H,1,-n);
  xOff+=0.01;
 }
}
