def call(Map config = [:]) 
{
    switch (env.OS)
    {
        case 'WIN':
            return 'C:\\Program Files\\Unity\\Hub\\Editor\\' + config.unityVersion + '\\Editor\\Unity.exe';
        break;

        case 'MAC':
            return "/Applications/Unity/Hub/Editor/${config.unityVersion}/Unity.app/Contents/MacOS/Unity";
        break;

        case 'UBUNTU':
            return 'UBUNTU-OS';
        break;

        default:
            return '/usr/bin/unity3d';
        break;
    }
}
