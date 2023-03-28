def call(command) 
{
    if (isUnix())
    {
        sh(script: command, encoding: 'UTF-8', returnStatus: true, returnStdout: true)
    }
    
    bat(script: command, encoding: 'UTF-8', returnStatus: true, returnStdout: true)
}
