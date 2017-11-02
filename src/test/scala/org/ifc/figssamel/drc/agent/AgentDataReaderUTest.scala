package org.ifc.figssamel.drc.agent

import org.ifc.figssamel.drc.location.{GPSCoordinates, Lat, Lng}
import org.scalatest.{FlatSpecLike, Matchers}

import scala.util.Success

class AgentDataReaderUTest extends FlatSpecLike with Matchers {
  
  "The agent reader" should "read all of the valid data into a collection of Agent case classes" in {
    val expected = Seq(
      Success(Agent("g1ombe_BM TRAVEL_FIN0435", GPSCoordinates(Lat(-4.3068878), Lng(15.3076398)))),
      Success(Agent("go2mbe_OLKA BROTHERS_FIN", GPSCoordinates(Lat(-4.308453333), Lng(15.30785833))))
    )
    val actual = AgentDataReader.read("src/test/resources/agent_test_data.csv")
    
    actual should contain theSameElementsInOrderAs expected
  }
  
}
