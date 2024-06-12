def call() 
{
    if (isUnix())
    {
        sh '''
            echo "[Jenkins] Unity Set Product Settings stage starting..."
            echo "[Jenkins] BuildNumber: ${BUILD_NUMBER}, AppVersion: ${STORE_BUILD_VERSION}, CustomVersion: ${STORE_CUSTOM_BUNDLE_VERSION}, CustomBundleVersion: ${STORE_BUNDLE_VERSION}"

            $UNITY_PATH -batchmode \
                        -projectPath $WORKSPACE \
                        -executeMethod $UNITY_ASSET_METHOD \
                        -username $UNITY_ACCOUNT_USR \
                        -password $UNITY_ACCOUNT_PSW \
                        -serial $UNITY_SERIAL_PSW \
                        -apiUrl $DASHBOARD_ACCOUNT_USR \
                        -apiKey $DASHBOARD_ACCOUNT_PSW \
                        -appId $APP_ID \
                        -buildVersion $STORE_BUILD_VERSION \
                        -bundleVersion $STORE_VERSION \
                        -nographics \
                        -stackTraceLogType ScriptOnly \
                        -silent-crashes

            echo "[Jenkins] Unity Set Product Settings stage completed!"
        '''
    }
    else
    {
        bat '''
            echo "[Jenkins] Unity Set Product Settings stage starting..."
            echo "[Jenkins] BuildNumber: %BUILD_NUMBER%, AppVersion: %STORE_BUILD_VERSION%, CustomVersion: %STORE_CUSTOM_BUNDLE_VERSION%, CustomBundleVersion: %STORE_BUNDLE_VERSION%"

            "%UNITY_PATH%" -batchmode ^
                        -projectPath "%WORKSPACE%" ^
                        -executeMethod "%UNITY_ASSET_METHOD%" ^
                        -username "%UNITY_ACCOUNT_USR%" ^
                        -password "%UNITY_ACCOUNT_PSW%" ^
                        -serial "%UNITY_SERIAL_PSW%" ^
                        -apiUrl "%DASHBOARD_ACCOUNT_USR%" ^
                        -apiKey "%DASHBOARD_ACCOUNT_PSW%" ^
                        -appId "%APP_ID%" ^
                        -buildVersion "%STORE_BUILD_VERSION%" ^
                        -bundleVersion "%STORE_VERSION%" ^
                        -nographics ^
                        -stackTraceLogType ScriptOnly ^
                        -silent-crashes

            echo "[Jenkins] Unity Set Product Settings stage completed!"
        '''
    }
}
