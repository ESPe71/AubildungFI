$fn = 50;

//intersection() {
//  cube(50, center = true);
//  sphere(d = 65);
//}


//cube([50, 5, 47.5]);
//translate([0, 2.5, 47.5])
//  sphere(2.5);
//translate([50, 2.5, 47.5])
//  sphere(2.5);
//translate([0, 2.5, 47.5])
//  rotate([0, 90, 0])
//    cylinder(50, 2.5, 2.5);
  

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