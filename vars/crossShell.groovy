def call(Map config = [:])
{
    switch (env.OS)
    {
        case 'WIN':
            bat """${config.script}"""
        break;
        case 'MAC':
            sh """${config.script}"""
        break;
        default:
            sh """${config.script}"""
        break;
    }
}
