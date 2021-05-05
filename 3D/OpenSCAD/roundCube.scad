$fn=50;

roundCube();  
    
module roundCube(coord = [1, 1, 1], r = .1) {
  hull() {
    for(x = [r, coord.x - r]){
      for(y = [r, coord.y - r]) {
        for(z = [r, coord.z - r]) {
          translate([x, y, z])
            sphere(r);
        }
      }
    }
  }
}
