#!/bin/sh
echo ""
curl -X POST -HContent-type:application/xml --data \
"<link>
	<url>http://dir.bg</url>
	<metaDescription>Meta description</metaDescription>
	<updatedAt>2010-09-27 11:28:48</updatedAt>
	<createdAt>2010-09-27 11:28:48</createdAt>
</link>" \
http://localhost:8080/spring3-storage-unit/integration/link
echo ""

