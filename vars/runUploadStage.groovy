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
                    --username $TESTFLIGHT_USERNAME \
                    --password $TESTFLIGHT_PASSWORD \
                    --show-progress \
                    --verbose

                echo "[Jenkins] Test-Flight upload completed!"
            '''
        break

        case 'GooglePlay':
            sh "echo Jenkins Google Play upload starting..."

            androidApkUpload googleCredentialsId: 'GOOGLE_PLAY_KEY',
                apkFilesPattern: 'Builds/**/*.aab',
                trackName: 'internal',
                rolloutPercentage: '0'
        
           sh "echo [Jenkins] Google Play upload completed!"
        break
    }
}
