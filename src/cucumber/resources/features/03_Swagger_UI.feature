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

  Scenario: [Swagger-04] WCS Documentation is available
    Given that the wcs swagger page is available
    Then the wcs getCapabilities, getCoverage, describeCoverage param documentation should be present

  Scenario: [Swagger-05] WMTS Documentation is available
    Given that the wmts swagger page is available
    Then the wmts getCapabilities, getTile, layers param documentation should be present

  Scenario: [Swagger-06] GeoscriptApi Documentation is available
    Given that the geoscript swagger page is available
    Then the geoscriptApi getCapabilitiesData, getSchemaInfoByTypeName, listProjections, queryLayer param documentation should be present

  Scenario: [Swagger-07] OMS Documentation is available
    Given that the oms swagger page is available
    Then the dataInfo getInfo param documentation should be present
    And the chipper chip, ortho param documentation should be present
    And the imageSpace getThumbnail, getTile, getTileOverlay param documentation should be present

  Scenario: [Swagger-08] Stager Documentation is available
    Given that the stager swagger page is available
    Then the rasterDataSet addRaster, getDistinctValues, getRasterFiles, getRasterFilesProcessing, removeRaster param documentation should be present
    And the videoDataSet addVideo, removeVideo param documentation should be present

  Scenario: [Swagger-09] AVRO Documentation is available
    Given that the avro swagger page is available
    Then the avro addFile, addMessage, listFiles, listMessages, resetFileProcessingStatus param documentation should be present
    And the ingestMetrics delete, endCopy, endIngest, endStaging, list, save, startCopy, startIngest, startStaging, summary param documentation should be present

  Scenario: [Swagger-10] Download Documentation is available
    Given that the download swagger page is available
    Then the archive download param documentation should be present