#!/bin/sh
echo "window.env = { GATEWAY_URL: '${GATEWAY_URL}' };" > /usr/share/nginx/html/env.js

exec nginx -g "daemon off;"