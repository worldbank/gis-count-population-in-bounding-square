package org.ifc.figssamel.drc.cartography

import org.ifc.figssamel.drc.agent.Agent
import org.ifc.figssamel.drc.location.{CatchmentArea, GPSCoordinates, Lat, Lng}
import org.ifc.figssamel.drc.surveyarea.{SurveyArea, SurveyAreaCharacteristics}
import org.scalatest.{FlatSpecLike, Matchers}

class CartographerUTest extends FlatSpecLike with Matchers {

  trait Fixture {
    
    val surveyArea1 = SurveyArea("barumbu_Deriere marche", GPSCoordinates(Lat(-4.31174), Lng(15.31779)))
    val surveyArea2 = SurveyArea("barumbu_Kabinda/Flambeau", GPSCoordinates(Lat(-4.32025), Lng(15.32644)))
    
    val surveyAreas = Seq(surveyArea1, surveyArea2)
    
    val agents = Seq(
      Agent("gombe_BOUTIQUE PO_FIN", GPSCoordinates(Lat(-4.319021667),Lng(15.32278333))),
      Agent("gombe_DLT_FIN", GPSCoordinates(Lat(-4.319038333),Lng(15.32318667))),
      Agent("gombe_FIFI TOP MOBILE_FIN0483", GPSCoordinates(Lat(-4.318065),Lng(15.325375))),
      Agent("gombe_GRADECO 1_FIN", GPSCoordinates(Lat(-4.321888333),Lng(15.32937667))),
      Agent("gombe_RITHA SHOP_FIN", GPSCoordinates(Lat(-4.32123),Lng(15.32912167))),
      Agent("gombe_CARLY BUSINESS_FIN", GPSCoordinates(Lat(-4.3205189),Lng(15.3294185))),
      Agent("gombe_LBM_FIN", GPSCoordinates(Lat(-4.3254917),Lng(15.3188801))),
      Agent("gombe_DM CHEZ TARCISSE_FIN", GPSCoordinates(Lat(-4.325403333),Lng(15.31647167))),
      Agent("gombe_FIFI TOP MODÃˆLE_FIN0483", GPSCoordinates(Lat(-4.317336667),Lng(15.32445333))),
      Agent("gombe_ETS GRADECO 1_FIN", GPSCoordinates(Lat(-4.3220837),Lng(15.3294021))),
      Agent("gombe_GRAND DÃ‰BAT_FIN1438", GPSCoordinates(Lat(-4.323263333),Lng(15.31964667))),
      Agent("gombe_GRADECO_FIN0511", GPSCoordinates(Lat(-4.323273333),Lng(15.31992833))),
      Agent("gombe_GRAND DEBAT_FIN1438", GPSCoordinates(Lat(-4.32338),Lng(15.31965667))),
      Agent("gombe_ETS LBM_FIN1013", GPSCoordinates(Lat(-4.323863333),Lng(15.31858167))),
      Agent("gombe_BOUTIQUE LA RESTAURATION_FIN", GPSCoordinates(Lat(-4.3115262),Lng(15.3152212))),
      Agent("gombe_LANDU LESSA SCHILO 2_FIN", GPSCoordinates(Lat(-4.314983333),Lng(15.317095))),
      Agent("gombe_RITHA SHOP_FIN0129", GPSCoordinates(Lat(-4.321566667),Lng(15.32904167))),
      Agent("gombe_GRADECO_FIN0511", GPSCoordinates(Lat(-4.322661667),Lng(15.33096833))),
      Agent("gombe_FIFI TOP MODÃˆLE_FIN0483", GPSCoordinates(Lat(-4.318148333),Lng(15.32549167))),
      Agent("gombe_DLT_FIN0959", GPSCoordinates(Lat(-4.31891),Lng(15.32315833))),
      Agent("gombe_ZYLLOO CASH_FIN1099", GPSCoordinates(Lat(-4.322523333),Lng(15.32813167))),
      Agent("gombe_GRAND DEBAT_FIN1438", GPSCoordinates(Lat(-4.323333333),Lng(15.319645))),
      Agent("gombe_LBM_FIN1013", GPSCoordinates(Lat(-4.324455),Lng(15.31889833))),
      Agent("gombe_DM CHEZ TARCISSE_FIN1223", GPSCoordinates(Lat(-4.325801667),Lng(15.31680667))),
      Agent("gombe_BOUTIQUE LA RESTAURATION_FIN0642", GPSCoordinates(Lat(-4.310213333),Lng(15.31561667))),
      Agent("gombe_FIFI TOP MODELE_FIN0483", GPSCoordinates(Lat(-4.318418333),Lng(15.325625))),
      Agent("gombe_GRADECO 1_FIN0511", GPSCoordinates(Lat(-4.3224608),Lng(15.3294678))),
      Agent("gombe_MAISON ROSSI_FIN0131", GPSCoordinates(Lat(-4.328203333),Lng(15.31738667))),
      Agent("gombe_LES OFFICINES DU PHARMACIEN_FIN0425", GPSCoordinates(Lat(-4.31115),Lng(15.32178667))),
      Agent("gombe_GRAND DÃ‰BAT_FIN1438", GPSCoordinates(Lat(-4.323608333),Lng(15.319485))),
      Agent("gombe_DLT_FIN0959", GPSCoordinates(Lat(-4.318974581),Lng(15.32325864))),
      Agent("gombe_FIFI TOP MODEL_FIN0483", GPSCoordinates(Lat(-4.318185893),Lng(15.32544897))),
      Agent("gombe_ZYLLOO CASH_FIN1099", GPSCoordinates(Lat(-4.322488149),Lng(15.32829805))),
      Agent("gombe_GRADECO 1_FIN0511", GPSCoordinates(Lat(-4.322102139),Lng(15.32929133))),
      Agent("gombe_RITHA SHOP_FIN0129", GPSCoordinates(Lat(-4.321429779),Lng(15.32939613))),
      Agent("gombe_LES OFFICINES DU PHARMACIEN_FIN0425", GPSCoordinates(Lat(-4.310973578),Lng(15.32177644))),
      Agent("gombe_LBM_FIN", GPSCoordinates(Lat(-4.324456034),Lng(15.31866103))),
      Agent("gombe_DM CHEZ TARCISSE_FIN", GPSCoordinates(Lat(-4.325968086),Lng(15.3172865))),
      Agent("upn_Ets Falon business_Fin 1019", GPSCoordinates(Lat(-4.3248714),Lng(15.3246439))),
      Agent("gombe_DLT_FIN", GPSCoordinates(Lat(-4.318973613),Lng(15.32310036))),
      Agent("gombe_FIFI TOP MODEL_FIN", GPSCoordinates(Lat(-4.318205106),Lng(15.32545994))),
      Agent("gombe_ZYLLOO CASH_FIN", GPSCoordinates(Lat(-4.322585275),Lng(15.32820677))),
      Agent("gombe_RITHA SHOP_FIN", GPSCoordinates(Lat(-4.321436617),Lng(15.32957524))),
      Agent("gombe_BOUTIQUE LA RESTAURATION_FIN", GPSCoordinates(Lat(-4.310112036),Lng(15.31564076))),
      Agent("gombe_ETS LAND U LESSA SHILO 2_FIN", GPSCoordinates(Lat(-4.314912398),Lng(15.31694885))),
      Agent("gombe_DM TARCISSE_FIN", GPSCoordinates(Lat(-4.326016144),Lng(15.31730405))),
      Agent("gombe_ETS DLT_FIN", GPSCoordinates(Lat(-4.319053723),Lng(15.32324429))),
      Agent("gombe_GRADECO 1_FIN", GPSCoordinates(Lat(-4.322129579),Lng(15.32941163))),
      Agent("gombe_LES OFFICINES DU PHARMACIEN_FIN", GPSCoordinates(Lat(-4.311181321),Lng(15.32184386))),
      Agent("gombe_DÃ‰PÃ”T PHARMACEUTIQUE EXTRA PLUS_FIN0633", GPSCoordinates(Lat(-4.30831965),Lng(15.31524694))),
      Agent("gombe_SHILO 2_FIN0387", GPSCoordinates(Lat(-4.314868335),Lng(15.31709452))),
      Agent("gombe_AGAPAO_FIN0484", GPSCoordinates(Lat(-4.324452865),Lng(15.31868724))),
      Agent("gombe_MAMAN ROSSI_FIN0131", GPSCoordinates(Lat(-4.32832698),Lng(15.31735093))),
      Agent("gombe_ZYLLO CASH_FIN1099", GPSCoordinates(Lat(-4.322510377),Lng(15.32796695))),
      Agent("gombe_LES OFFICINES DU PHARMACIENS_FIN0425", GPSCoordinates(Lat(-4.31102324),Lng(15.32182489))),
      Agent("gombe_DLT_FIN0959", GPSCoordinates(Lat(-4.318974581),Lng(15.32325864))),
      Agent("gombe_FIFI TOP MODEL_FIN0483", GPSCoordinates(Lat(-4.318185893),Lng(15.32544897))),
      Agent("gombe_ZYLLOO CASH_FIN1099", GPSCoordinates(Lat(-4.322488149),Lng(15.32829805))),
      Agent("gombe_GRADECO 1_FIN0511", GPSCoordinates(Lat(-4.322102139),Lng(15.32929133))),
      Agent("gombe_RITHA SHOP_FIN0129", GPSCoordinates(Lat(-4.321429779),Lng(15.32939613))),
      Agent("gombe_LES OFFICINES DU PHARMACIEN_FIN0425", GPSCoordinates(Lat(-4.310973578),Lng(15.32177644))),
      Agent("gombe_DÃ‰PÃ”T PHARMACEUTIQUE EXTRA PLUS_FIN00", GPSCoordinates(Lat(-4.308189472),Lng(15.31519592))),
      Agent("gombe_MAMAN ROSSI_FIN0131", GPSCoordinates(Lat(-4.328214339),Lng(15.3172441))),
      Agent("gombe_LBM_FIN1013", GPSCoordinates(Lat(-4.324548835),Lng(15.31865816))),
      Agent("gombe_BOUTIQUE LA RESTAURATION_FIN0642", GPSCoordinates(Lat(-4.310152202),Lng(15.31560893))),
      Agent("gombe_DM CHEZ TARCISSE_FIN00", GPSCoordinates(Lat(-4.326025279),Lng(15.31716402))),
      Agent("gombe_DLT_FIN", GPSCoordinates(Lat(-4.318992822),Lng(15.32316147))),
      Agent("gombe_FIFI TOP MODEL_FIN", GPSCoordinates(Lat(-4.318275676),Lng(15.3253115))),
      Agent("gombe_ZYLLOO CASH_FIN", GPSCoordinates(Lat(-4.32262323),Lng(15.32814015))),
      Agent("gombe_GGRADECO BON MARCHÃ‰_FIN", GPSCoordinates(Lat(-4.322183047),Lng(15.329387))),
      Agent("gombe_RITHA SHOP_FIN", GPSCoordinates(Lat(-4.321395517),Lng(15.32930287))),
      Agent("victoire_Groupe Emmanuel_90", GPSCoordinates(Lat(-4.3211733),Lng(15.3328881))),
      Agent("gombe_DÃ‰PÃ”T PHARMACEUTIQUE EXTRA PLUS_FIN", GPSCoordinates(Lat(-4.308336305),Lng(15.31524216))),
      Agent("gombe_BOUTIQUE  LA RESTAURATION_FIN", GPSCoordinates(Lat(-4.310249898),Lng(15.31570217))),
      Agent("gombe_ETS LANDU LESSA SHILO 2_FIN", GPSCoordinates(Lat(-4.314923631),Lng(15.31701644))),
      Agent("gombe_ETS GRADECO BON MARCHE_FIN", GPSCoordinates(Lat(-4.321944691),Lng(15.32901103))),
      Agent("gombe_MAISON ROSSI_FIN", GPSCoordinates(Lat(-4.32812901),Lng(15.31732919))),
      Agent("gombe_GRADECO BON MARCHÃ‰_FIN", GPSCoordinates(Lat(-4.322143126),Lng(15.3293042))),
      Agent("gombe_ETS DLT_FIN", GPSCoordinates(Lat(-4.319023476),Lng(15.3231873))),
      Agent("gombe_DÃ‰PÃ”T PHARMACEUTIQUE EXYRA PLUS_FIN", GPSCoordinates(Lat(-4.308354738),Lng(15.31512635))),
      Agent("gombe_FIFI TOP MODÃˆLE_FIN", GPSCoordinates(Lat(-4.318185165),Lng(15.32537958))),
    )
  }
  
  "The cartographer" should "calculate the number of agents in each catchment area of the given size" in new Fixture {
    val expected = Seq(
      SurveyAreaCharacteristics(surveyArea1, Seq(CatchmentArea(0.25, 0), CatchmentArea(0.5, 4))),
      SurveyAreaCharacteristics(surveyArea2, Seq(CatchmentArea(0.25, 0), CatchmentArea(0.5, 10))),
    )
    val actual = Cartographer.calculateCatchmentAreaPopulations(agents, surveyAreas, Seq(0.25, 0.5))
    
    actual should contain theSameElementsInOrderAs expected
  }

}
