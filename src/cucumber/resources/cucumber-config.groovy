rbtcloudRootDir = "NOT_ASSIGNED"
targetDeployment = System.getenv("TEST_PROFILE")
switch(targetDeployment) {
   case "dev":
      rbtcloudRootDir = "https://omar-dev.ossim.io"
      break
   case "stage":
      rbtcloudRootDir = "https://omar-stage.ossim.io"
      break
   case "prod":
      rbtcloudRootDir = "https://omar-prod.ossim.io"
      break
   case "rel":
      rbtcloudRootDir = "https://omar-rel.ossim.io"
      break
   default:
      rbtcloudRootDir = "https://omar-dev.ossim.io"
      break
}

println("\nOMAR URL being tested: ${rbtcloudRootDir}\n")

tlvUrl = "${rbtcloudRootDir}/tlv"
mensaUrl = "${rbtcloudRootDir}/omar-mensa"
wfsUrl = "${rbtcloudRootDir}/omar-wfs"
wmsUrl = "${rbtcloudRootDir}/omar-wms"
wcsUrl = "${rbtcloudRootDir}/omar-wcs"
wmtsUrl = "${rbtcloudRootDir}/omar-wmts"
geoscriptUrl = "${rbtcloudRootDir}/omar-geoscript"
omsUrl = "${rbtcloudRootDir}/omar-oms"
stagerUrl = "${rbtcloudRootDir}/omar-stager"
avroUrl = "${rbtcloudRootDir}/omar-avro"
downloadUrl = "${rbtcloudRootDir}/omar-download"
