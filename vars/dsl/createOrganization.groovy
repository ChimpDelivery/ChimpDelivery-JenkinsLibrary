organizationFolder(REPO_OWNER)
{
    description('This contains branch source jobs for GitHub')
    displayName(REPO_OWNER)

    properties
    {
        suppressFolderAutomaticTriggering
        {
            branches('auto-deploy');
        }

        folderCredentialsProperty
        {
            domainCredentials
            {
                domainCredentials
                {
                    credentials
                    {
                        usernamePassword
                        {
                            description('GIT username and personal access token')
                            id('GIT_USER_ACCOUNT')
                            password(GIT_ACCESS_TOKEN)
                            scope('GLOBAL')
                            username(GIT_USERNAME)
                            usernameSecret(false)
                        }

                        usernamePassword
                        {
                            description('TESTLIGHT username and app-specific pass')
                            id('TF_USER_ACCOUNT')
                            password(TESTFLIGHT_PASSWORD)
                            scope('GLOBAL')
                            username(TESTFLIGHT_USERNAME)
                            usernameSecret(false)
                        }

                        domain
                        {
                            description(null)
                            name(null)
                        }
                    }
                }
            }
        }
    }

    organizations
    {
        github
        {
            credentialsId('GIT_USER_ACCOUNT')
            repoOwner(REPO_OWNER)
            traits
            {
                gitHubTopicsFilter
                {
                    topicList(GITHUB_TOPIC)
                }

                gitHubExcludeArchivedRepositories()

                gitHubBranchDiscovery
                {
                    strategyId(1)
                }
            }
        }
    }

    projectFactories
    {
        workflowMultiBranchProjectFactory
        {
            scriptPath('Jenkinsfile')
        }
    }
}
