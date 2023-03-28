def call() 
{
    switch (env.OS)
    {
        case 'WIN':
            return "C:\\Program Files\\Unity\\Hub\\Editor\\${params.UNITY_VERSION}\\Editor\\Unity.exe";
        break;
        
        case 'MAC':
            return "/Applications/Unity/Hub/Editor/${params.UNITY_VERSION}/Unity.app/Contents/MacOS/Unity";
        break;
        
        case 'UBUNTU':
            return 'UBUNTU-OS';
        break;
    }
}
