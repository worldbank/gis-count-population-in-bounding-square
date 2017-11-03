package org.ifc.figssamel.drc.location

import org.scalatest.{FlatSpecLike, Matchers}

class BoundingBoxUTest extends FlatSpecLike with Matchers {
  
  trait Fixture {
    val centerPoint = GPSCoordinates(Lat(-4.44205), Lng(15.25853))
    val bb250m = BoundingBox.from(centerPoint, 0.250)
    val bb500m = BoundingBox.from(centerPoint, 0.500)
  }
  
  "Creating a bounding box from a center point and edge length" should "return a bouding box with coordinates that " +
  "form a square with an edge length of the specified edge length" in new Fixture {
    val expectedBox250m = BoundingBox(
      GPSCoordinates(Lat(-4.443172900619172),Lng(15.257403716225726)),
      GPSCoordinates(Lat(-4.440927099380829),Lng(15.257403716225726)),
      GPSCoordinates(Lat(-4.440927099380829),Lng(15.259656283774277)),
      GPSCoordinates(Lat(-4.443172900619172),Lng(15.259656283774277))
    )
    val expectedBox500m = BoundingBox(
      GPSCoordinates(Lat(-4.444295801238343),Lng(15.256277432451448)),
      GPSCoordinates(Lat(-4.439804198761658),Lng(15.256277432451448)),
      GPSCoordinates(Lat(-4.439804198761658),Lng(15.260782567548551)),
      GPSCoordinates(Lat(-4.444295801238343),Lng(15.260782567548551))
    )
  
    bb250m shouldEqual expectedBox250m
    bb500m shouldEqual expectedBox500m
  }
  
  "The bounding box" should "be able to determine whether a given point is contained within it" in new Fixture {
    val candidatePointInside250 = GPSCoordinates(Lat(-4.44094), Lng(15.25741))
    val candidatePointOutside250 = GPSCoordinates(Lat(-4.44316), Lng(15.25967))
    
    bb250m contains candidatePointInside250 shouldBe true
    bb250m contains candidatePointOutside250 shouldBe false
    BoundingBox.from(centerPoint, 0.2479) contains candidatePointInside250 shouldBe false
  }
  
}
