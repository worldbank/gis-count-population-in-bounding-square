package org.ifc.figssamel.drc.cartography

import org.ifc.figssamel.drc.agent.Agent
import org.ifc.figssamel.drc.location.BoundingBox
import org.ifc.figssamel.drc.surveyarea.{CatchmentArea, SurveyArea, SurveyAreaCharacteristics}

object Cartographer {
  
  def calculateCatchmentAreaPopulations(agents: Seq[Agent], surveyAreas: Seq[SurveyArea], edgeSizesKm: Seq[Double]):
  Seq[SurveyAreaCharacteristics] = {
    
    surveyAreas.foldLeft(Seq[SurveyAreaCharacteristics]()) { case (accSurveyAreasCharacteristics, surveyArea) =>
      val catchmentAreas = edgeSizesKm.map { edgeSizeKm =>
        val boundingBox = BoundingBox.from(surveyArea.center, edgeSizeKm)
        val nAgentsInCatchementArea = agents.count(agent => boundingBox contains agent.gPSCoordinates)
        CatchmentArea(edgeSizeKm, nAgentsInCatchementArea)
      }
      accSurveyAreasCharacteristics :+ SurveyAreaCharacteristics(surveyArea, catchmentAreas)
    }
    
  }
  
}
