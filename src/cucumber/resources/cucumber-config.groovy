targetDeployment = System.getenv("TARGET_DEPLOYMENT")
if (!targetDeployment) {
   targetDeployment = "dev"
}
domainName = System.getenv("DOMAIN_NAME")
if (!domainName) {
   domainName = "ossim.io"
}
rbtcloudRootDir = "https://omar-${targetDeployment}.${domainName}"

println("\nOMAR URL being tested: ${rbtcloudRootDir}\n")

ovvUrl = "${rbtcloudRootDir}/omar-video-vrails"
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
pkiRootDir = "https://pki-omar-${targetDeployment}.${domainName}"