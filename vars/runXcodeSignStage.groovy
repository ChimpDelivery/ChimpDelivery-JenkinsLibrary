import java.nio.file.Paths

def call()
{
    env.LIBRARY_ROOT = "/Volumes/Mac/$HOME"
    env.PROVISION_LIBRARY_PATH = Paths.get("$LIBRARY_ROOT", "/Library/MobileDevice/Provisioning Profiles")
    sh '''cp "$WORKSPACE/Builds/temp-provision" "$PROVISION_LIBRARY_PATH/$DASHBOARD_PROFILE_UUID.mobileprovision"'''
}
