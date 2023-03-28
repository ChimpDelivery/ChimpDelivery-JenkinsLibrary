def call(command) 
{
    switch (env.OS)
    {
        case 'WIN':
            return bat(returnStdout: true, script: "${command}").trim()
        break;
        
        case 'MAC':
            return sh(returnStdout: true, script: "${command}").trim()
        break;
        
        case 'UBUNTU':
            return sh(returnStdout: true, script: "${command}").trim()
        break;
    }
}
