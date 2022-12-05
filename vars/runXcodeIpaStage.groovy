def call()
{
    env.EXPORTLIST = "${WORKSPACE}/Builds/exportOptions.plist"
    
    sh '''
        echo "[Jenkins] Create ipa starting..."

        cd $WORKSPACE/Builds/UnityBuild

        /usr/bin/xcodebuild -exportArchive \
            -archivePath '../ios-build/BuildArchieve.xcarchive' \
            -exportPath '.' -exportOptionsPlist $EXPORTLIST \
            -verbose

        echo "[Jenkins] Create ipa finished..."
    '''
}
