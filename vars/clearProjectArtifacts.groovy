def call() 
{
    if (isUnix())
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
    }
    else
    {
        bat '''
            if exist "%WORKSPACE%/Builds/" (
                rmdir /s /q "%WORKSPACE%/Builds"
           )

            if exist "%WORKSPACE%/Library/Il2cppBuildCache/" (
                rmdir /s /q "%WORKSPACE%/Library/Il2cppBuildCache"
            )

            :: Clear the Scriptable Build Pipeline cache. Reference: https://docs.unity3d.com/Packages/com.unity.addressables@1.21/manual/ContinuousIntegration.html
            if exist "%WORKSPACE%/Library/BuildCache/" (
                rmdir /s /q "%WORKSPACE%/Library/BuildCache"
            )

            :: Clear Unity3D related artifacts from project history
            git add . && git stash && git stash drop
        '''
    }
}
