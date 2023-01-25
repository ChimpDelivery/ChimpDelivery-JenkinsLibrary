def call()
{
    sh '''
        echo "[Jenkins] Unity Backend Packages integration starting..."

        $UNITY_PATH -batchmode \
            -projectPath $WORKSPACE \
            -executeMethod $UNITY_PACKAGE_METHOD \
            -username $UNITY_USERNAME \
            -password $UNITY_PASSWORD \
            -serial $UNITY_SERIAL \
            -apiUrl $DASHBOARD_ACCOUNT_USR \
            -apiKey $DASHBOARD_ACCOUNT_PSW \
            -appId $APP_ID \
            -nographics \
            -accept-apiupdate \
            -stackTraceLogType Full \
            -silent-crashes

            echo "[Jenkins] Unity Backend Packages integration finished..."
    '''
}
