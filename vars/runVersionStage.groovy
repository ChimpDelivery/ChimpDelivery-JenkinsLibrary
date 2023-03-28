def call() 
{
    String multiLineSeperator = getCrossMultiLine()
    
    crossShell """
        echo '[Jenkins] Unity Set Product Settings stage starting...'
        
        echo '[Jenkins] BuildNumber: $BUILD_NUMBER multiLineSeperator
                        AppVersion: $STORE_BUILD_VERSION multiLineSeperator
                        CustomVersion: $STORE_CUSTOM_BUNDLE_VERSION multiLineSeperator
                        CustomBundleVersion: $STORE_BUNDLE_VERSION'

        "${UNITY_PATH}" -batchmode multiLineSeperator
                    -projectPath $WORKSPACE multiLineSeperator
                    -executeMethod $UNITY_ASSET_METHOD multiLineSeperator
                    -username $UNITY_USERNAME multiLineSeperator
                    -password $UNITY_PASSWORD multiLineSeperator
                    -serial $UNITY_SERIAL multiLineSeperator
                    -apiUrl $DASHBOARD_ACCOUNT_USR multiLineSeperator
                    -apiKey $DASHBOARD_ACCOUNT_PSW multiLineSeperator
                    -appId $APP_ID multiLineSeperator
                    -buildVersion $STORE_BUILD_VERSION multiLineSeperator
                    -bundleVersion $STORE_VERSION multiLineSeperator
                    -nographics multiLineSeperator
                    -stackTraceLogType ScriptOnly multiLineSeperator
                    -silent-crashes
                    
        echo '[Jenkins] Unity Set Product Settings stage completed!'
    """        
}
