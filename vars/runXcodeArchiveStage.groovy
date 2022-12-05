def call()
{
    sh '''
        echo "[Jenkins] Create Archive starting..."
        echo "[Jenkins] IS_WORKSPACE: $IS_WORKSPACE, XCODE_PROJECT_ARGUMENT: $XCODE_PROJECT"

        cd $WORKSPACE/Builds/UnityBuild

        /usr/bin/xcodebuild $XCODE_PROJECT \
            -scheme Unity-iPhone \
            -sdk iphoneos \
            -configuration Release \
            PROVISIONING_PROFILE_SPECIFIER="$DASHBOARD_PROFILE_NAME" \
            DEVELOPMENT_TEAM="$DASHBOARD_TEAM_ID" \
            -UseModernBuildSystem=YES \
            archive -archivePath '../ios-build/BuildArchieve.xcarchive' \
            clean

        echo "[Jenkins] Create Archive finished..."
    '''
}
