def call(Map config = [:])
{
    switch (env.OS)
    {
        case 'WIN':
            bat(script: config.script)
        break;
        case 'MAC':
            sh(script: config.script)
        break;
        default:
            sh(script: config.script)
        break;
    }
}
