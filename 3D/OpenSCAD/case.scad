$fn=100;
epsilon = .002;

/* [Größe] */
// Breite
width = 50;
// Höhe
height = 40;
// Tiefe
depth = 100;
// Wandstärke
thickness = 2;

/* [Ansicht] */
// Deckel öffnen
topTranslate = 0.0; // [0:1:25]
// Deckel neben dem Gehäuse
print = false;

/* [Schrauben] */
// Schraubbefestigung
screws = true;
// Schraubdurchmesser
screwDiameter = 2.5;
// Schraubenlänge
screwLength = 10;
// Radius der Schraubaufnahme
screwBolt = 5;
// Senkkopfschraube
screwSink = true;


/* [Hidden] */
doubleThickness = thickness * 2;
doubleScrewBolt = screwBolt * 2;

box();
if(print) {
  rotate([180, 0, 0])
    translate([-width - 5, 
               -depth, 
               -height - thickness])
      cover();
}
else {
  cover(topTranslate);
}

module box() {
  difference() {
    cube([width, depth, height]);
    translate([thickness, 
               thickness, 
               thickness]) {
      cube([width - doubleThickness, 
            depth - doubleThickness,
            height - thickness + epsilon]);
    }
  }
  if(screws) {
    screws();
  }
}

module cover(topTranslate = 0) {
  translate([0, 0, topTranslate]){
    translate([0, 0, height]){
      difference() {
        union() {
          cube([width, depth, thickness]);
          translate([thickness, 
                     thickness, 
                     -thickness]){
            cube([width - doubleThickness,
                  depth - doubleThickness,
                  thickness]);
          }
        }
        if(screws) {
          coverScrews();
        }
      }
    }
  }
}

module screws() {
  for(x = [screwBolt, 
           width - screwBolt]){
    for(y = [screwBolt, 
             depth - screwBolt]) {
      translate([x, y, 0]) {
        difference(){
          screwCylinder(x, y);
          translate([0, 
                     0, 
                     height - thickness - screwLength + epsilon])
            cylinder(screwLength,
                     d1 = screwDiameter - .5,
                     d2 = screwDiameter - .5);
        }
      }
    }
  }
}
module coverScrews() {
  for(x = [screwBolt, 
           width - screwBolt]){
    for(y = [screwBolt, 
             depth - screwBolt]) {
      translate([x, y, -screwBolt]){
        union() {   
          cylinder(screwLength, 
                   d1 = screwDiameter, 
                   d2 = screwDiameter);
          translate([0, 0, doubleThickness])
            cylinder(1.5 + epsilon, d1 = 
                     screwSink ? 
                       screwDiameter :
                       screwDiameter + 1.5, 
                     d2 = screwDiameter + 1.5);
        }
      }
    }
  }
}
module screwCylinder(x, y) {
  union() {
    height = height - thickness;
    if(y<=screwBolt + thickness) {
      translate([-screwBolt, -screwBolt, 0])
        cube([doubleScrewBolt, screwBolt, height]);
    }
    else {
      translate([-screwBolt, 0, 0])
        cube([doubleScrewBolt, screwBolt, height]);
    }
    if(x<=screwBolt + thickness) {
      translate([-screwBolt, -screwBolt, 0])
        cube([screwBolt, doubleScrewBolt, height]);
    }
    else {
      translate([0, -screwBolt, 0])
        cube([screwBolt, doubleScrewBolt, height]);
    }
    cylinder(height, screwBolt, screwBolt);
  }
}

