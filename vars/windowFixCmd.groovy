def call(Map config = [:]) 
{
    if (config.useWsl) 
    {
        return WindowsWslCommand(config.cmd);
    }

    return config.cmd;
}
