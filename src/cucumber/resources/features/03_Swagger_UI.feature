@swagger_ui
Feature: SwaggerUserInterface

  Scenario: [Swagger-01] MENSA Documentation is available
    Given that the mensa swagger page is available for mensa
    Then the mensa groundToImagePoints, imageDistance, imagePointsToGround param documentation should be present

  Scenario: [Swagger-02] WFS Documentation is available
    Given that the wfs swagger page is available for wfs
    Then the wfs describeFeatureType, getCapabilities, getFeature param documentation should be present

  Scenario: [Swagger-03] WMS Documentation is available
    Given that the wms swagger page is available for wms
    Then the wms getCapabilities, getMap param documentation should be present

  Scenario: [Swagger-04] WCS Documentation is available
    Given that the wcs swagger page is available for wcs
    Then the wcs getCapabilities, getCoverage, describeCoverage param documentation should be present

  Scenario: [Swagger-05] WMTS Documentation is available
    Given that the wmts swagger page is available for wmts
    Then the wmts getCapabilities, getTile, layers param documentation should be present

  Scenario: [Swagger-06] GeoscriptApi Documentation is available
    Given that the geoscriptApi swagger page is available for geoscript
    Then the geoscriptApi getCapabilitiesData, getSchemaInfoByTypeName, listProjections, queryLayer param documentation should be present


  Scenario Outline: [Swagger-07] OMS Documentation is available
    Given that the <swaggerEndpoint> swagger page is available for <swaggerApp>
    Then the <swaggerEndpoint> <params> param documentation should be present
    Examples:
      | swaggerApp | swaggerEndpoint | params                                |
      | oms        | dataInfo        | getInfo                               |
      | oms        | chipper         | chip, ortho                           |
      | oms        | imageSpace      | getThumbnail, getTile, getTileOverlay |

  Scenario Outline: [Swagger-08] Stager Documentation is available
    Given that the <swaggerEndpoint> swagger page is available for <swaggerApp>
    Then the <swaggerEndpoint> <params> param documentation should be present
    Examples:
      | swaggerApp | swaggerEndpoint | params                                                                               |
      | stager     | rasterDataSet   | addRaster, getDistinctValues, getRasterFiles, getRasterFilesProcessing, removeRaster |
      | stager     | videoDataSet    | addVideo, removeVideo                                                                |

  Scenario Outline: [Swagger-09] AVRO Documentation is available
    Given that the <swaggerEndpoint> swagger page is available for <swaggerApp>
    Then the <swaggerEndpoint> <params> param documentation should be present
    Examples:
      | swaggerApp | swaggerEndpoint | params                                                                                            |
      | avro       | avro            | addFile, addMessage, listFiles, listMessages, resetFileProcessingStatus                           |
      | avro       | ingestMetrics   | delete, endCopy, endIngest, endStaging, list, save, startCopy, startIngest, startStaging, summary |

  Scenario Outline: [Swagger-10] Download Documentation is available
    Given that the <swaggerEndpoint> swagger page is available for <swaggerApp>
    Then the <swaggerEndpoint> <params> param documentation should be present
    Examples:
      | swaggerApp | swaggerEndpoint | params   |
      | download   | archive         | download |
