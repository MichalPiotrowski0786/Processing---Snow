void rules(){
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
