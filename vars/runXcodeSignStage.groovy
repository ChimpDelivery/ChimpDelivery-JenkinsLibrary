def call()
{
    env.LIBRARY_ROOT = "/Volumes/Mac/Users/emrekovanci"
    env.PROVISION_LIBRARY_PATH = "$LIBRARY_ROOT/Library/MobileDevice/Provisioning Profiles"
    sh '''cp "$WORKSPACE/Builds/temp-provision" "$PROVISION_LIBRARY_PATH/$DASHBOARD_PROFILE_UUID.mobileprovision"'''
}
