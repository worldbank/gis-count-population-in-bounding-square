package org.ifc.figssamel.drc.surveyarea

import org.ifc.figssamel.drc.location.{CatchmentArea, GPSCoordinates, Lat, Lng}
import org.scalatest.{FlatSpecLike, Matchers}

class SurveyAreaCharacteristicsWriterUTest extends FlatSpecLike with Matchers {
  
  "The writer" should "produce a collection of a collection of strings that contain study area and agent counts" in {
    val surveyArea1 = SurveyArea("barumbu_Deriere marche", GPSCoordinates(Lat(-4.31174), Lng(15.31779)))
    val surveyArea2 = SurveyArea("barumbu_Kabinda/Flambeau", GPSCoordinates(Lat(-4.32025), Lng(15.32644)))
    val surveyAreasCharacteristics = Seq(
      SurveyAreaCharacteristics(surveyArea1, Seq(CatchmentArea(0.25, 0), CatchmentArea(0.5, 4))),
      SurveyAreaCharacteristics(surveyArea2, Seq(CatchmentArea(0.25, 0), CatchmentArea(0.5, 10))),
    )
    var accumulatedRows = Seq[Seq[String]]()
    val rowWriter = (line: Seq[String]) => {
      accumulatedRows = accumulatedRows :+ line
    }
    val writer = new SurveyAreaCharacteristicsWriter(rowWriter)
    writer write surveyAreasCharacteristics
    val expected = Seq(
      Seq("barumbu_Deriere marche", "N", "0", "Y", "4"),
      Seq("barumbu_Kabinda/Flambeau", "N", "0", "Y", "10")
    )
    accumulatedRows should contain theSameElementsInOrderAs expected
  }
  
}
