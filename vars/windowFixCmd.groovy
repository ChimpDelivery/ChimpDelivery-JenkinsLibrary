def call(String cmd, boolean useWsl) 
{
    if (useWsl) 
    {
        return WindowsWslCommand(cmd);
    }

    return cmd;
}
