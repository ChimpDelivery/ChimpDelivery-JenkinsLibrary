def call(command) 
{
    switch (env.OS)
    {
        case 'WIN':
            bat command
        break;
        
        case 'MAC':
            sh command
        break;
        
        case 'UBUNTU':
            sh command
        break;
    }
}
