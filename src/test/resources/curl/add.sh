#!/bin/sh
echo ""
curl -X POST -HContent-type:application/xml --data \
"<link>
	<url>http://dir.bg</url>
	<metaDescription>Meta description</metaDescription>
</link>" \
http://localhost:8080/spring3-storage-unit/integration/link
echo ""

