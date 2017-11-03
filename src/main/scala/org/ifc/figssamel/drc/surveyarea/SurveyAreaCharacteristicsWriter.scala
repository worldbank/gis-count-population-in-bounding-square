package org.ifc.figssamel.drc.surveyarea

class SurveyAreaCharacteristicsWriter(rowWriter: Seq[String] => Unit) {

  def write(surveyAreasCharacteristics: Seq[SurveyAreaCharacteristics]): Unit = {
    surveyAreasCharacteristics.foreach { surveyAreaCharacteristics =>
      val characteristics =
        surveyAreaCharacteristics.catchementAreas.foldLeft(Seq[String]())
          { case (accumulatedCatchmentData, catchementArea) =>
            val hasAgents = if (catchementArea.numberWithinArea == 0) "N" else "Y"
            accumulatedCatchmentData ++ Seq(hasAgents, catchementArea.numberWithinArea.toString)
      }
      rowWriter(Seq(surveyAreaCharacteristics.surveyArea.name) ++ characteristics)
    }
  }

}
