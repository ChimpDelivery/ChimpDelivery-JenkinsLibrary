def call() 
{
    switch (env.OS)
    {
        case 'WIN':
            return 'WIN-OS';
        break;
        
        case 'MAC':
            return 'MAC-OS';
        break;
        
        case 'UBUNTU':
            return 'UBUNTU-OS';
        break;
    }
}
