def call(command) 
{
    if (isUnix())
    {
        return sh(script: command, encoding: 'UTF-8', returnStatus: true, returnStdout: true)
    }
    
    return bat(script: command, encoding: 'UTF-8', returnStatus: true, returnStdout: true)
}
