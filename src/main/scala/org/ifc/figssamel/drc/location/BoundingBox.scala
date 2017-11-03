package org.ifc.figssamel.drc.location

case class BoundingBox(
    gPSCoordinates1: GPSCoordinates,
    gPSCoordinates2: GPSCoordinates,
    gPSCoordinates3: GPSCoordinates,
    gPSCoordinates4: GPSCoordinates)

object DegreeRadianConverter {
  
  implicit class DegreeRadianConverter(value: Double) {
    def toDegrees: Double = value * Math.PI / 180d
    
    def toRadians: Double = value * 180d / Math.PI
  }
  
  object Constants {
    val MIN_LAT: Double = (-90).toRadians
    val MAX_LAT: Double = 90.toRadians
    val MIN_LON: Double = (-180).toRadians
    val MAX_LON: Double = 180.toRadians
  
    val R = 6378.1
  }
}


object BoundingBox {
  
  import DegreeRadianConverter.Constants._
  
  def from(center: GPSCoordinates, edgeLengthKm: Double): BoundingBox = {
    val radDist = (edgeLengthKm / 2) / R
   
    val degLat = center.lat.value
    val degLon = center.lng.value
  
    val radLat = degLat.toRadians
    val radLon = degLon.toRadians

    val minLatTemp = radLat - radDist
    val maxLatTemp = radLat + radDist
    
    //  // define deltaLon to help determine min and max longitudes
    val deltaLon = Math.asin(Math.sin(radDist) / Math.cos(radLat))
    val (minLat, minLng, maxLat, maxLng) = if (minLatTemp > MIN_LAT && maxLatTemp < MAX_LAT) {
      val minLonTemp = radLon - deltaLon
      val minLon = if (minLonTemp < MIN_LON) minLonTemp + 2 * Math.PI else minLonTemp
      val maxLonTemp = radLon + deltaLon
      val maxLon = if (maxLonTemp > MAX_LON) maxLonTemp - 2 * Math.PI else maxLonTemp
      (minLatTemp.toDegrees, minLon.toDegrees, maxLatTemp.toDegrees, maxLon.toDegrees)
    } else {
      (Math.max(minLatTemp, MIN_LAT).toDegrees, MIN_LON.toDegrees, Math.min(maxLatTemp, MAX_LAT).toDegrees,
        MAX_LON.toDegrees)
    }
    val corner1 = GPSCoordinates(Lat(minLat), Lng(minLng))
    val corner2 = GPSCoordinates(Lat(maxLat), Lng(minLng))
    val corner3 = GPSCoordinates(Lat(maxLat), Lng(maxLng))
    val corner4 = GPSCoordinates(Lat(minLat), Lng(maxLng))
    
    BoundingBox(corner1, corner2, corner3, corner4)
  }
  
}