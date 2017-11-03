package org.ifc.figssamel.drc.surveyarea

import java.io.File

import com.github.tototoshi.csv.CSVReader
import org.ifc.figssamel.drc.DataReader
import org.ifc.figssamel.drc.location.{GPSCoordinates, Lat, Lng}

import scala.util.Try

object SurveyAreaDataReader extends DataReader[SurveyArea] {
  
  def readMaybe(path: String): Seq[Try[SurveyArea]] = {
    val reader = CSVReader.open(new File(path))
    val surveyAreas = reader.all.tail.map { line =>
      val Seq(maybeLatitude, maybeLongitude) = Seq(4, 5).map(n => Try(line(n).toDouble))
      for {
        lat <- maybeLatitude
        lng <- maybeLongitude
      } yield {
        val name = Seq(line(1), line(2), line(3)).mkString("_")
        SurveyArea(name, GPSCoordinates(Lat(lat), Lng(lng)))
      }
    }
    reader.close()
    surveyAreas
  }
  
}
