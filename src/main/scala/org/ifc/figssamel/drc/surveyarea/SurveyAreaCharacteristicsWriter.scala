package org.ifc.figssamel.drc.surveyarea

class SurveyAreaCharacteristicsWriter(surveyAreasCharacteristics: Seq[SurveyAreaCharacteristics] = Seq()) {

  def using(rowWriter: Seq[String] => Unit): Unit = {
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
  
  def write(surveyAreasCharacteristics: Seq[SurveyAreaCharacteristics]): SurveyAreaCharacteristicsWriter =
    new SurveyAreaCharacteristicsWriter(surveyAreasCharacteristics)

}

object SurveyAreaCharacteristicsWriter {
  
  def apply() = new SurveyAreaCharacteristicsWriter()
  
  def write(surveyAreasCharacteristics: Seq[SurveyAreaCharacteristics]): SurveyAreaCharacteristicsWriter =
    new SurveyAreaCharacteristicsWriter(surveyAreasCharacteristics)
  
}