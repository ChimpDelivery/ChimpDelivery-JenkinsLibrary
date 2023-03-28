def call(command) 
{
    if (isUnix())
    {
        return sh(script: command, encoding: 'UTF-8')
    }
    
    return bat(script: command, encoding: 'UTF-8')
}
