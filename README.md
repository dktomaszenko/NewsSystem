# NewsSystem
Restfull Spring Java

# mongo-express setting

    cookieKeyName: 'mongo-express',
    cookieSecret:     process.env.ME_CONFIG_SITE_COOKIESECRET   || 'cookiesecret',
    host:             process.env.VCAP_APP_HOST                 || 'localhost',
    port:             process.env.VCAP_APP_PORT                 || 8090,
    requestSizeLimit: process.env.ME_CONFIG_REQUEST_SIZE        || '50mb',
    sessionSecret:    process.env.ME_CONFIG_SITE_SESSIONSECRET  || 'sessionsecret',
    sslCert:          process.env.ME_CONFIG_SITE_SSL_CRT_PATH   || '',
    sslEnabled:       process.env.ME_CONFIG_SITE_SSL_ENABLED    || false,
    sslKey:           process.env.ME_CONFIG_SITE_SSL_KEY_PATH   || '',

# Inicio

    mongod --dbpath (mi_path to db mongo)
 
    mongo-express -a -u newsAdminUser -p abc123
