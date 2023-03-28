def call() 
{
    env.MULTI_LINE_SEPERATOR = getCrossMultiLine()
    
    crossShell """
        echo '[Jenkins] Unity Set Product Settings stage starting...'
        
        echo '[Jenkins] BuildNumber: $BUILD_NUMBER $MULTI_LINE_SEPERATOR
                        AppVersion: $STORE_BUILD_VERSION $MULTI_LINE_SEPERATOR
                        CustomVersion: $STORE_CUSTOM_BUNDLE_VERSION $MULTI_LINE_SEPERATOR
                        CustomBundleVersion: $STORE_BUNDLE_VERSION'

        "${UNITY_PATH}" -batchmode $MULTI_LINE_SEPERATOR
                    -projectPath $WORKSPACE $MULTI_LINE_SEPERATOR
                    -executeMethod $UNITY_ASSET_METHOD $MULTI_LINE_SEPERATOR
                    -username $UNITY_USERNAME $MULTI_LINE_SEPERATOR
                    -password $UNITY_PASSWORD $MULTI_LINE_SEPERATOR
                    -serial $UNITY_SERIAL $MULTI_LINE_SEPERATOR
                    -apiUrl $DASHBOARD_ACCOUNT_USR $MULTI_LINE_SEPERATOR
                    -apiKey $DASHBOARD_ACCOUNT_PSW $MULTI_LINE_SEPERATOR
                    -appId $APP_ID $MULTI_LINE_SEPERATOR
                    -buildVersion $STORE_BUILD_VERSION $MULTI_LINE_SEPERATOR
                    -bundleVersion $STORE_VERSION $MULTI_LINE_SEPERATOR
                    -nographics $MULTI_LINE_SEPERATOR
                    -stackTraceLogType ScriptOnly $MULTI_LINE_SEPERATOR
                    -silent-crashes
                    
        echo '[Jenkins] Unity Set Product Settings stage completed!'
    """        
}
