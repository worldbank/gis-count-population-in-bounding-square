package org.ifc.figssamel.drc.surveyarea

import org.ifc.figssamel.drc.location.{CatchmentArea, GPSCoordinates}

case class SurveyArea(name: String, center: GPSCoordinates)

case class SurveyAreaCharacteristics(surveyArea: SurveyArea, catchementAreas: Seq[CatchmentArea])
