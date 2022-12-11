def call() 
{
    sh '''
        echo "[Jenkins] Unity Set Product Settings stage starting..."
        echo "[Jenkins] BuildNumber: ${BUILD_NUMBER}, AppVersion: ${STORE_BUILD_VERSION}, CustomVersion: ${STORE_CUSTOM_BUNDLE_VERSION}, CustomBundleVersion: ${STORE_BUNDLE_VERSION}"

        $UNITY_PATH -batchmode \
                    -projectPath $WORKSPACE \
                    -executeMethod $UNITY_ASSET_METHOD \
                    -username $UNITY_USERNAME \
                    -password $UNITY_PASSWORD \
                    -serial $UNITY_SERIAL \
                    -apiKey $BACKEND_API_KEY \
                    -apiUrl $BACKEND_API_URL \
                    -appId $APP_ID \
                    -buildVersion $STORE_BUILD_VERSION \
                    -bundleVersion $STORE_VERSION \
                    -nographics \
                    -stackTraceLogType Full \
                    -silent-crashes
                    
        echo "[Jenkins] Unity Set Product Settings stage completed!"
    '''
}
