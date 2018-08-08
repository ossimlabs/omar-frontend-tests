rbtcloudRootDir = "NOT_ASSIGNED"
targetDeployment = System.getenv("TEST_PROFILE")
domainName = System.getenv("DOMAIN_NAME")
rbtcloudRootDir = "https://omar-${targetDeployment}.${domainName}"

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
