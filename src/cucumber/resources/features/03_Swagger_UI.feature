@swagger_ui
Feature: SwaggerUserInterface

  Scenario: [Swagger-01] MENSA Documentation is available
    Given that the mensa swagger page is available
    Then the mensa groundToImagePoints, imageDistance, imagePointsToGround param documentation should be present

  Scenario: [Swagger-02] WFS Documentation is available
    Given that the wfs swagger page is available
    Then the wfs describeFeatureType, getCapabilities, getFeature param documentation should be present

  Scenario: [Swagger-03] WMS Documentation is available
    Given that the wms swagger page is available
    Then the wms getCapabilities, getMap param documentation should be present

#  Scenario: [Swagger-04] WMS Documentation is available
#    Given that the wms swagger page is available
#    Then the wms getCapabilities, getMap param documentation should be present
#
#  Scenario: [Swagger-05] WMS Documentation is available
#    Given that the wms swagger page is available
#    Then the wms getCapabilities, getMap param documentation should be present
#
#  Scenario: [Swagger-06] WMS Documentation is available
#    Given that the wms swagger page is available
#    Then the wms getCapabilities, getMap param documentation should be present
#
#  Scenario: [Swagger-07] WMS Documentation is available
#    Given that the wms swagger page is available
#    Then the wms getCapabilities, getMap param documentation should be present
#
#  Scenario: [Swagger-08] WMS Documentation is available
#    Given that the wms swagger page is available
#    Then the wms getCapabilities, getMap param documentation should be present
#
#  Scenario: [Swagger-09] WMS Documentation is available
#    Given that the wms swagger page is available
#    Then the wms getCapabilities, getMap param documentation should be present
#
#  Scenario: [Swagger-10] WMS Documentation is available
#    Given that the wms swagger page is available
#    Then the wms getCapabilities, getMap param documentation should be present
#
#