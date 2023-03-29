def call()
{
    switch (params.PLATFORM)
    {
        case 'Appstore':
            sh '''
                echo "[Jenkins] Test-Flight upload starting..."

                cd $WORKSPACE/Builds/UnityBuild

                /usr/bin/xcrun altool --upload-app \
                    --type ios \
                    --file ***.ipa \
                    --username $TESTFLIGHT_USER_ACCOUNT_USR \
                    --password $TESTFLIGHT_USER_ACCOUNT_PSW \
                    --show-progress \
                    --verbose

                echo "[Jenkins] Test-Flight upload completed!"
            '''
        break

        case 'GooglePlay':
            echo "[Jenkins] Google Play upload starting..."

            androidApkUpload googleCredentialsId: 'GOOGLE_PLAY_KEY',
                apkFilesPattern: 'Builds/**/*.aab',
                trackName: 'internal',
                rolloutPercentage: '0'
        
            echo "[Jenkins] Google Play upload completed!"
        break
        
        default:
            echo "[Jenkins] Deliver-platform could not found!"
        break    
    }
}
