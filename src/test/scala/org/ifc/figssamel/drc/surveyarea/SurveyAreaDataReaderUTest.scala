package org.ifc.figssamel.drc.surveyarea

import org.ifc.figssamel.drc.location.{GPSCoordinates, Lat, Lng}
import org.scalatest.{FlatSpecLike, Matchers}

import util.Success

class SurveyAreaDataReaderUTest extends FlatSpecLike with Matchers {
  
  "Reading in the survey data" should "yield a collection of survey area objects with the correct data" in {
    val expected = Seq(
     Success(SurveyArea("Ngaliema (Delcaux)_Delvaux_2", GPSCoordinates(Lat(-4.37842), Lng(15.25829)))),
     Success(SurveyArea("Ngaliema (DGC)_DGC_3", GPSCoordinates(Lat(-4.35478), Lng(15.23847)))),
     Success(SurveyArea("Mont ngafula_Triangle Cité verte_4", GPSCoordinates(Lat(-4.44205), Lng(15.25853)))),
    )
    
    val actual = SurveyAreaDataReader read "src/test/resources/survey-area_test_data.csv"
    
    actual should contain theSameElementsInOrderAs expected
  }
  
}
