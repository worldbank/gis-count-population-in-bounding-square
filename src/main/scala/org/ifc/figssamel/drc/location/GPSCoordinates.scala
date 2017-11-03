package org.ifc.figssamel.drc.location

case class Lat(value: Double)

case class Lng(value: Double)

case class GPSCoordinates(lat: Lat, lng: Lng)

case class CatchmentArea(squareEdgeLengthMeters: Double, numberWithinArea: Double)
