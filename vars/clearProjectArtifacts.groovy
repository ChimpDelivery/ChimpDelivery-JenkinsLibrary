def call() 
{
    // clear build related artifacts
    sh '''
        if [ -d "${WORKSPACE}/Builds" ]; then
            rm -rf "${WORKSPACE}/Builds"
        fi
        
        if [ -d "${WORKSPACE}/Library/Il2cppBuildCache" ]; then
            rm -rf "${WORKSPACE}/Library/Il2cppBuildCache"
        fi
        
        # Clears the Scriptable Build Pipeline cache. Reference: https://docs.unity3d.com/Packages/com.unity.addressables@1.21/manual/ContinuousIntegration.html
        if [ -d "${WORKSPACE}/Library/BuildCache" ]; then
            rm -rf "${WORKSPACE}/Library/BuildCache"
        fi
    '''

    // clear project related artifacts
    if (params.INSTALL_SDK == true)
    {
        sh '''
            git checkout "${WORKSPACE}/Packages/manifest.json"
            git checkout "${WORKSPACE}/Packages/packages-lock.json"

            if [ -d "${WORKSPACE}/Assets/FacebookSDK" ]; then
                rm -rf "${WORKSPACE}/Assets/FacebookSDK"
            fi

            if [ -d "${WORKSPACE}/Assets/Plugins/Android" ]; then
                rm -rf "${WORKSPACE}/Assets/Plugins/Android"
            fi
        '''
    }
}
