package org.ifc.figssamel.drc.agent

import java.io.File

import com.github.tototoshi.csv._
import org.ifc.figssamel.drc.location.{GPSCoordinates, Lat, Lng}

import scala.util.Try

object AgentDataReader {
  
  def read(path: String): Seq[Try[Agent]] = {
    val reader = CSVReader.open(new File(path))
    val agents = reader.all.tail.map { line =>
      val agentIdentifier = Seq(line(2), line(3), line(4)).mkString("_")
      val maybeLatitude = Try(line(5).toDouble)
      val maybeLongitude = Try(line(6).toDouble)
      for {
        lat <- maybeLatitude
        lng <- maybeLongitude
      } yield {
        Agent(agentIdentifier, GPSCoordinates(Lat(lat), Lng(lng)))
      }
    }
    reader.close()
    agents
  }
  
}
