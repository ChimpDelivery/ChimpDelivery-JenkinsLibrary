def call() 
{
    sh '''
        if [ -d "${WORKSPACE}/Builds" ]; then
            rm -rf "${WORKSPACE}/Builds"
        fi
        
        if [ -d "${WORKSPACE}/Library/Il2cppBuildCache" ]; then
            rm -rf "${WORKSPACE}/Library/Il2cppBuildCache"
        fi
        
        # Clear the Scriptable Build Pipeline cache. Reference: https://docs.unity3d.com/Packages/com.unity.addressables@1.21/manual/ContinuousIntegration.html
        if [ -d "${WORKSPACE}/Library/BuildCache" ]; then
            rm -rf "${WORKSPACE}/Library/BuildCache"
        fi
        
        # Clear Unity3D related artifacts from project history
        git add . && git stash && git stash drop
    '''

    if (params.INSTALL_SDK == true)
    {
        sh '''
            if [ -d "${WORKSPACE}/Assets/FacebookSDK" ]; then
                rm -rf "${WORKSPACE}/Assets/FacebookSDK"
            fi

            if [ -d "${WORKSPACE}/Assets/Plugins/Android" ]; then
                rm -rf "${WORKSPACE}/Assets/Plugins/Android"
            fi
        '''
    }
}
