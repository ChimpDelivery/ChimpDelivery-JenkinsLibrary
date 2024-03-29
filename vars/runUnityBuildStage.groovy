def call()
{
    if (isUnix())
    {
        sh '''
            echo "[Jenkins] Unity Build starting..."

            export LANG=en_US.UTF-8

            echo "[Jenkins] Job Environment Variables: \
                PLATFORM: $PLATFORM \
                APP_ID: $APP_ID \
                BUILD_METHOD: $UNITY_BUILD_METHOD"

            $UNITY_PATH -batchmode \
                -projectPath $WORKSPACE \
                -executeMethod $UNITY_BUILD_METHOD \
                -username $UNITY_USERNAME \
                -password $UNITY_PASSWORD \
                -serial $UNITY_SERIAL \
                -apiUrl $DASHBOARD_ACCOUNT_USR \
                -apiKey $DASHBOARD_ACCOUNT_PSW \
                -appId $APP_ID \
                -keyStorePass $ANDROID_KEYSTORE_PSW \
                -nographics \
                -accept-apiupdate \
                -stackTraceLogType ScriptOnly \
                -silent-crashes

                echo "[Jenkins] Unity Build finished..."
            '''
    }
    else
    {
        bat '''
            echo "[Jenkins] Unity Build starting..."
            echo "[Jenkins] Job Environment Variables: PLATFORM: %PLATFORM%, APP_ID: %APP_ID%, BUILD_METHOD: %UNITY_BUILD_METHOD%"

            "%UNITY_PATH%" -batchmode ^
                -projectPath "%WORKSPACE%" ^
                -executeMethod "%UNITY_BUILD_METHOD%" ^
                -username "%UNITY_USERNAME%" ^
                -password "%UNITY_PASSWORD%" ^
                -serial "%UNITY_SERIAL%" ^
                -apiUrl "%DASHBOARD_ACCOUNT_USR%" ^
                -apiKey "%$DASHBOARD_ACCOUNT_PSW%" ^
                -appId "%APP_ID%" ^
                -keyStorePass "%ANDROID_KEYSTORE_PSW%" ^
                -nographics ^
                -accept-apiupdate ^
                -stackTraceLogType ScriptOnly ^
                -silent-crashes

                echo "[Jenkins] Unity Build finished..."
            '''
    }
}
