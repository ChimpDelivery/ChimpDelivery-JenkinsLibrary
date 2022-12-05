def call()
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
            -apiKey $BACKEND_API_KEY \
            -apiUrl $BACKEND_API_URL \
            -appId $APP_ID \
            -keyStorePass $ANDROID_KEYSTORE_PASS \
            -nographics \
            -accept-apiupdate \
            -stackTraceLogType Full \
            -silent-crashes

            echo "[Jenkins] Unity Build finished..."
        '''
}
