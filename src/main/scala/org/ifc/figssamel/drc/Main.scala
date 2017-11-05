package org.ifc.figssamel.drc

import com.github.tototoshi.csv.CSVWriter
import org.ifc.figssamel.drc.agent.AgentDataReader
import org.ifc.figssamel.drc.cartography.Cartographer
import org.ifc.figssamel.drc.surveyarea.{SurveyAreaCharacteristicsWriter, SurveyAreaDataReader}

object Main extends App {
  
  val surveyAreasPath = args(0)
  val agentsPath = args(1)
  val pathForSavingData = args(2)
  val boxEdgeLengthsUnparsed = args(3)
  
  val surveyAreas = SurveyAreaDataReader read surveyAreasPath
  val agents = AgentDataReader read agentsPath
  
  val cSVWRiter = CSVWriter open pathForSavingData
  val rowWriter = cSVWRiter.writeRow _
  
  val surveyAreaCharacteristics = Cartographer.calculateCatchmentAreaPopulations(agents, surveyAreas, Seq(0.25, 0.5))
  
  SurveyAreaCharacteristicsWriter write surveyAreaCharacteristics using rowWriter
  
  cSVWRiter.close()
}
