#!/bin/sh
ab -c30 -t30 -HApplication/xml -p./post-data -Tapplication/xml http://localhost:8080/spring3-storage-unit/integration/link

