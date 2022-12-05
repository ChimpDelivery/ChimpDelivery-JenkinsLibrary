def call() 
{
    // (channel->settings->integrations)
    env.DISCORD_WEBHOOK_URL = credentials('DISCORD_WEBHOOK_URL') 

    discordSend description: "Build ${BUILD_NUMBER}: ${currentBuild.currentResult}",
                footer: "Platform: ${PLATFORM}, Version: ${STORE_BUILD_VERSION} / ${STORE_VERSION}, App ID: ${APP_ID}",
                link: env.BUILD_URL,
                result: currentBuild.currentResult,
                title: "Job: ${JOB_NAME}",
                webhookURL: env.DISCORD_WEBHOOK_URL
}
